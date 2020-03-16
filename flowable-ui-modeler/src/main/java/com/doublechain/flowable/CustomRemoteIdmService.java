package com.doublechain.flowable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.flowable.ui.common.model.RemoteGroup;
import org.flowable.ui.common.model.RemoteToken;
import org.flowable.ui.common.model.RemoteUser;
import org.flowable.ui.common.properties.FlowableCommonAppProperties;
import org.flowable.ui.common.security.FlowableAppUser;
import org.flowable.ui.common.security.SecurityUtils;
import org.flowable.ui.common.service.idm.RemoteIdmServiceImpl;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CustomRemoteIdmService extends RemoteIdmServiceImpl {
	@Getter
	@Setter
	@Value("${auth.url}")
	// http://localhost:8880/flowable/secUserManager/login/username/password/
	private String authUrl;

	public CustomRemoteIdmService(FlowableCommonAppProperties properties) {
		super(properties);
	}

	@Override
	public RemoteUser getUser(String userId) {
		FlowableAppUser currentFlowableAppUser = SecurityUtils.getCurrentFlowableAppUser();
		return (RemoteUser) Optional.ofNullable(currentFlowableAppUser).map(FlowableAppUser::getUserObject).orElse(new RemoteUser());
	}

	@Override
	public List<RemoteUser> findUsersByNameFilter(String filter) {
		JsonNode json = callRemoteIdmService(url + "api/idm/users?filter=" + encode(filter), adminUser, adminPassword);
		if (json != null) {
			return parseUsersInfo(json);
		}
		return new ArrayList<>();
	}

	@Override
	public List<RemoteUser> findUsersByGroup(String groupId) {
		JsonNode json = callRemoteIdmService(url + "api/idm/groups/" + encode(groupId) + "/users", adminUser, adminPassword);
		if (json != null) {
			return parseUsersInfo(json);
		}
		return new ArrayList<>();
	}

	@Override
	public RemoteGroup getGroup(String groupId) {
		JsonNode json = callRemoteIdmService(url + "api/idm/groups/" + encode(groupId), adminUser, adminPassword);
		if (json != null) {
			return parseGroupInfo(json);
		}
		return null;
	}

	@Override
	public List<RemoteGroup> findGroupsByNameFilter(String filter) {
		String remoteUrl = "http://localhost:8880/flowable/roleManager/viewByName/" + encode(filter) + "/";
		JsonNode json = callRemoteIdmService(remoteUrl, adminUser, adminPassword);
		if (json != null) {
			return parseGroupsInfo(json);
		}
		return new ArrayList<>();
	}

	@Override
	public RemoteUser authenticateUser(String username, String password) {

		FormBody.Builder builder = new FormBody.Builder();
		builder.add("username", username);
		builder.add("password", password);
		Request request = new Request.Builder().url(getAuthUrl()).post(builder.build()).build();
		Response resp = null;
		try {
			resp = new OkHttpClient().newCall(request).execute();
			String result = resp.body().string();
			Map resultObject = new ObjectMapper().readValue(result, Map.class);
			RemoteUser remoteUser = new RemoteUser();
			remoteUser.setId((String) resultObject.get("id"));
			remoteUser.setPassword((String) resultObject.get("pwd"));
			remoteUser.setFirstName(remoteUser.getId());
//	  				List<SimpleGrantedAuthority> auths = new ArrayList<>();
//	  				auths.add(new SimpleGrantedAuthority(DefaultPrivileges.ACCESS_MODELER));
			return remoteUser;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Optional.ofNullable(resp).ifPresent(Response::close);
		}
		return null;
	}

	@Override
	public RemoteToken getToken(String tokenValue) {
		return super.getToken(tokenValue);
	}
}

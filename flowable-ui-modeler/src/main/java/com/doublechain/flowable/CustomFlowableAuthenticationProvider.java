package com.doublechain.flowable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.flowable.ui.common.model.RemoteUser;
import org.flowable.ui.common.security.DefaultPrivileges;
import org.flowable.ui.common.security.FlowableAppUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CustomFlowableAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	@Getter
	@Setter
	@Value("${auth.url}")
	//http://localhost:8880/flowable/secUserManager/login/username/password/
	private String authUrl;


		public CustomFlowableAuthenticationProvider() {
			super();
		}

		@Override
	    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	    	String password = authentication.getCredentials().toString();
	        return getRemoteUser(username,password);
	    }

	    protected FlowableAppUser getRemoteUser(String login,String password) {
			FormBody.Builder builder = new FormBody.Builder();
			builder.add("username", login);
			builder.add("password", password);
			Request request = new Request.Builder().url(getAuthUrl()).post(builder.build()).build();
			Response resp=null;
			try {
				 resp = new OkHttpClient().newCall(request).execute();
				String result = resp.body().string();
				Map resultObject = new ObjectMapper().readValue(result, Map.class);
				RemoteUser remoteUser = new RemoteUser();
				remoteUser.setId((String) resultObject.get("id"));
				remoteUser.setPassword((String) resultObject.get("pwd"));
				remoteUser.setFirstName(remoteUser.getId());
				List<SimpleGrantedAuthority> auths = new ArrayList<>();
				auths.add(new SimpleGrantedAuthority(DefaultPrivileges.ACCESS_MODELER));
				return new FlowableAppUser(remoteUser, remoteUser.getId(),auths );
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				Optional.ofNullable(resp).ifPresent(Response::close);
			}
			return null;
		}

		@Override
		protected void additionalAuthenticationChecks(UserDetails userDetails,
				UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
			//TODO
		}


}

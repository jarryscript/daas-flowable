package com.doublechain.flowable;

import java.util.Optional;

import org.flowable.idm.api.User;
import org.flowable.ui.common.model.RemoteUser;
import org.flowable.ui.common.properties.FlowableCommonAppProperties;
import org.flowable.ui.common.security.FlowableAppUser;
import org.flowable.ui.common.security.SecurityUtils;
import org.flowable.ui.common.service.idm.RemoteIdmServiceImpl;



public class CustomRemoteIdmService extends RemoteIdmServiceImpl {



	public CustomRemoteIdmService(FlowableCommonAppProperties properties) {
		super(properties);
	}

	@Override
	public RemoteUser getUser(String userId) {
		FlowableAppUser currentFlowableAppUser = SecurityUtils.getCurrentFlowableAppUser();
		 User currentUser = Optional.ofNullable(currentFlowableAppUser).map(FlowableAppUser::getUserObject).orElse(null);
		 return currentUser instanceof RemoteUser?(RemoteUser)currentUser:null;
	}
}

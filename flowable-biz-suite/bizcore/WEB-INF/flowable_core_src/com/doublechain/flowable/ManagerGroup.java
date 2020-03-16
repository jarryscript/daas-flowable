package com.doublechain.flowable;


import com.doublechain.flowable.platform.PlatformManager;

import com.doublechain.flowable.user.UserManager;

import com.doublechain.flowable.role.RoleManager;

import com.doublechain.flowable.leaverecord.LeaveRecordManager;

import com.doublechain.flowable.leaverecordtype.LeaveRecordTypeManager;

import com.doublechain.flowable.holydaysetting.HolydaySettingManager;

import com.doublechain.flowable.province.ProvinceManager;

import com.doublechain.flowable.city.CityManager;

import com.doublechain.flowable.district.DistrictManager;

import com.doublechain.flowable.userdomain.UserDomainManager;

import com.doublechain.flowable.userwhitelist.UserWhiteListManager;

import com.doublechain.flowable.secuser.SecUserManager;

import com.doublechain.flowable.userapp.UserAppManager;

import com.doublechain.flowable.quicklink.QuickLinkManager;

import com.doublechain.flowable.listaccess.ListAccessManager;

import com.doublechain.flowable.objectaccess.ObjectAccessManager;

import com.doublechain.flowable.loginhistory.LoginHistoryManager;

import com.doublechain.flowable.genericform.GenericFormManager;

import com.doublechain.flowable.formmessage.FormMessageManager;

import com.doublechain.flowable.formfieldmessage.FormFieldMessageManager;

import com.doublechain.flowable.formfield.FormFieldManager;

import com.doublechain.flowable.formaction.FormActionManager;

import com.doublechain.flowable.candidatecontainer.CandidateContainerManager;

import com.doublechain.flowable.candidateelement.CandidateElementManager;

import com.doublechain.flowable.wechatworkappidentify.WechatWorkappIdentifyManager;

import com.doublechain.flowable.wechatminiappidentify.WechatMiniappIdentifyManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected UserManager userManager;

	protected RoleManager roleManager;

	protected LeaveRecordManager leaveRecordManager;

	protected LeaveRecordTypeManager leaveRecordTypeManager;

	protected HolydaySettingManager holydaySettingManager;

	protected ProvinceManager provinceManager;

	protected CityManager cityManager;

	protected DistrictManager districtManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected UserAppManager userAppManager;

	protected QuickLinkManager quickLinkManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	protected CandidateContainerManager candidateContainerManager;

	protected CandidateElementManager candidateElementManager;

	protected WechatWorkappIdentifyManager wechatWorkappIdentifyManager;

	protected WechatMiniappIdentifyManager wechatMiniappIdentifyManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public UserManager getUserManager(){
		return this.userManager;
	}
	public void setUserManager(UserManager manager){
		this.userManager = manager;
	}


	public RoleManager getRoleManager(){
		return this.roleManager;
	}
	public void setRoleManager(RoleManager manager){
		this.roleManager = manager;
	}


	public LeaveRecordManager getLeaveRecordManager(){
		return this.leaveRecordManager;
	}
	public void setLeaveRecordManager(LeaveRecordManager manager){
		this.leaveRecordManager = manager;
	}


	public LeaveRecordTypeManager getLeaveRecordTypeManager(){
		return this.leaveRecordTypeManager;
	}
	public void setLeaveRecordTypeManager(LeaveRecordTypeManager manager){
		this.leaveRecordTypeManager = manager;
	}


	public HolydaySettingManager getHolydaySettingManager(){
		return this.holydaySettingManager;
	}
	public void setHolydaySettingManager(HolydaySettingManager manager){
		this.holydaySettingManager = manager;
	}


	public ProvinceManager getProvinceManager(){
		return this.provinceManager;
	}
	public void setProvinceManager(ProvinceManager manager){
		this.provinceManager = manager;
	}


	public CityManager getCityManager(){
		return this.cityManager;
	}
	public void setCityManager(CityManager manager){
		this.cityManager = manager;
	}


	public DistrictManager getDistrictManager(){
		return this.districtManager;
	}
	public void setDistrictManager(DistrictManager manager){
		this.districtManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public QuickLinkManager getQuickLinkManager(){
		return this.quickLinkManager;
	}
	public void setQuickLinkManager(QuickLinkManager manager){
		this.quickLinkManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


	public CandidateContainerManager getCandidateContainerManager(){
		return this.candidateContainerManager;
	}
	public void setCandidateContainerManager(CandidateContainerManager manager){
		this.candidateContainerManager = manager;
	}


	public CandidateElementManager getCandidateElementManager(){
		return this.candidateElementManager;
	}
	public void setCandidateElementManager(CandidateElementManager manager){
		this.candidateElementManager = manager;
	}


	public WechatWorkappIdentifyManager getWechatWorkappIdentifyManager(){
		return this.wechatWorkappIdentifyManager;
	}
	public void setWechatWorkappIdentifyManager(WechatWorkappIdentifyManager manager){
		this.wechatWorkappIdentifyManager = manager;
	}


	public WechatMiniappIdentifyManager getWechatMiniappIdentifyManager(){
		return this.wechatMiniappIdentifyManager;
	}
	public void setWechatMiniappIdentifyManager(WechatMiniappIdentifyManager manager){
		this.wechatMiniappIdentifyManager = manager;
	}


}








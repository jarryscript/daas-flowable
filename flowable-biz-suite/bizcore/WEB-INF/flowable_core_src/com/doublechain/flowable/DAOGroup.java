package com.doublechain.flowable;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.doublechain.flowable.platform.Platform;
import com.doublechain.flowable.platform.PlatformDAO;
import com.doublechain.flowable.platform.PlatformTokens;
import com.doublechain.flowable.user.User;
import com.doublechain.flowable.user.UserDAO;
import com.doublechain.flowable.user.UserTokens;
import com.doublechain.flowable.role.Role;
import com.doublechain.flowable.role.RoleDAO;
import com.doublechain.flowable.role.RoleTokens;
import com.doublechain.flowable.leaverecord.LeaveRecord;
import com.doublechain.flowable.leaverecord.LeaveRecordDAO;
import com.doublechain.flowable.leaverecord.LeaveRecordTokens;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.leaverecordtype.LeaveRecordTypeDAO;
import com.doublechain.flowable.leaverecordtype.LeaveRecordTypeTokens;
import com.doublechain.flowable.holydaysetting.HolydaySetting;
import com.doublechain.flowable.holydaysetting.HolydaySettingDAO;
import com.doublechain.flowable.holydaysetting.HolydaySettingTokens;
import com.doublechain.flowable.province.Province;
import com.doublechain.flowable.province.ProvinceDAO;
import com.doublechain.flowable.province.ProvinceTokens;
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.city.CityDAO;
import com.doublechain.flowable.city.CityTokens;
import com.doublechain.flowable.district.District;
import com.doublechain.flowable.district.DistrictDAO;
import com.doublechain.flowable.district.DistrictTokens;
import com.doublechain.flowable.userdomain.UserDomain;
import com.doublechain.flowable.userdomain.UserDomainDAO;
import com.doublechain.flowable.userdomain.UserDomainTokens;
import com.doublechain.flowable.userwhitelist.UserWhiteList;
import com.doublechain.flowable.userwhitelist.UserWhiteListDAO;
import com.doublechain.flowable.userwhitelist.UserWhiteListTokens;
import com.doublechain.flowable.secuser.SecUser;
import com.doublechain.flowable.secuser.SecUserDAO;
import com.doublechain.flowable.secuser.SecUserTokens;
import com.doublechain.flowable.userapp.UserApp;
import com.doublechain.flowable.userapp.UserAppDAO;
import com.doublechain.flowable.userapp.UserAppTokens;
import com.doublechain.flowable.quicklink.QuickLink;
import com.doublechain.flowable.quicklink.QuickLinkDAO;
import com.doublechain.flowable.quicklink.QuickLinkTokens;
import com.doublechain.flowable.listaccess.ListAccess;
import com.doublechain.flowable.listaccess.ListAccessDAO;
import com.doublechain.flowable.listaccess.ListAccessTokens;
import com.doublechain.flowable.objectaccess.ObjectAccess;
import com.doublechain.flowable.objectaccess.ObjectAccessDAO;
import com.doublechain.flowable.objectaccess.ObjectAccessTokens;
import com.doublechain.flowable.loginhistory.LoginHistory;
import com.doublechain.flowable.loginhistory.LoginHistoryDAO;
import com.doublechain.flowable.loginhistory.LoginHistoryTokens;
import com.doublechain.flowable.genericform.GenericForm;
import com.doublechain.flowable.genericform.GenericFormDAO;
import com.doublechain.flowable.genericform.GenericFormTokens;
import com.doublechain.flowable.formmessage.FormMessage;
import com.doublechain.flowable.formmessage.FormMessageDAO;
import com.doublechain.flowable.formmessage.FormMessageTokens;
import com.doublechain.flowable.formfieldmessage.FormFieldMessage;
import com.doublechain.flowable.formfieldmessage.FormFieldMessageDAO;
import com.doublechain.flowable.formfieldmessage.FormFieldMessageTokens;
import com.doublechain.flowable.formfield.FormField;
import com.doublechain.flowable.formfield.FormFieldDAO;
import com.doublechain.flowable.formfield.FormFieldTokens;
import com.doublechain.flowable.formaction.FormAction;
import com.doublechain.flowable.formaction.FormActionDAO;
import com.doublechain.flowable.formaction.FormActionTokens;
import com.doublechain.flowable.candidatecontainer.CandidateContainer;
import com.doublechain.flowable.candidatecontainer.CandidateContainerDAO;
import com.doublechain.flowable.candidatecontainer.CandidateContainerTokens;
import com.doublechain.flowable.candidateelement.CandidateElement;
import com.doublechain.flowable.candidateelement.CandidateElementDAO;
import com.doublechain.flowable.candidateelement.CandidateElementTokens;
import com.doublechain.flowable.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechain.flowable.wechatworkappidentify.WechatWorkappIdentifyDAO;
import com.doublechain.flowable.wechatworkappidentify.WechatWorkappIdentifyTokens;
import com.doublechain.flowable.wechatminiappidentify.WechatMiniappIdentify;
import com.doublechain.flowable.wechatminiappidentify.WechatMiniappIdentifyDAO;
import com.doublechain.flowable.wechatminiappidentify.WechatMiniappIdentifyTokens;

public class DAOGroup {

	protected PlatformDAO platformDAO;

	protected UserDAO userDAO;

	protected RoleDAO roleDAO;

	protected LeaveRecordDAO leaveRecordDAO;

	protected LeaveRecordTypeDAO leaveRecordTypeDAO;

	protected HolydaySettingDAO holydaySettingDAO;

	protected ProvinceDAO provinceDAO;

	protected CityDAO cityDAO;

	protected DistrictDAO districtDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserWhiteListDAO userWhiteListDAO;

	protected SecUserDAO secUserDAO;

	protected UserAppDAO userAppDAO;

	protected QuickLinkDAO quickLinkDAO;

	protected ListAccessDAO listAccessDAO;

	protected ObjectAccessDAO objectAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected GenericFormDAO genericFormDAO;

	protected FormMessageDAO formMessageDAO;

	protected FormFieldMessageDAO formFieldMessageDAO;

	protected FormFieldDAO formFieldDAO;

	protected FormActionDAO formActionDAO;

	protected CandidateContainerDAO candidateContainerDAO;

	protected CandidateElementDAO candidateElementDAO;

	protected WechatWorkappIdentifyDAO wechatWorkappIdentifyDAO;

	protected WechatMiniappIdentifyDAO wechatMiniappIdentifyDAO;

	

	public PlatformDAO getPlatformDAO(){
		return this.platformDAO;
	}
	public void setPlatformDAO(PlatformDAO dao){
		this.platformDAO = dao;
	}


	public UserDAO getUserDAO(){
		return this.userDAO;
	}
	public void setUserDAO(UserDAO dao){
		this.userDAO = dao;
	}


	public RoleDAO getRoleDAO(){
		return this.roleDAO;
	}
	public void setRoleDAO(RoleDAO dao){
		this.roleDAO = dao;
	}


	public LeaveRecordDAO getLeaveRecordDAO(){
		return this.leaveRecordDAO;
	}
	public void setLeaveRecordDAO(LeaveRecordDAO dao){
		this.leaveRecordDAO = dao;
	}


	public LeaveRecordTypeDAO getLeaveRecordTypeDAO(){
		return this.leaveRecordTypeDAO;
	}
	public void setLeaveRecordTypeDAO(LeaveRecordTypeDAO dao){
		this.leaveRecordTypeDAO = dao;
	}


	public HolydaySettingDAO getHolydaySettingDAO(){
		return this.holydaySettingDAO;
	}
	public void setHolydaySettingDAO(HolydaySettingDAO dao){
		this.holydaySettingDAO = dao;
	}


	public ProvinceDAO getProvinceDAO(){
		return this.provinceDAO;
	}
	public void setProvinceDAO(ProvinceDAO dao){
		this.provinceDAO = dao;
	}


	public CityDAO getCityDAO(){
		return this.cityDAO;
	}
	public void setCityDAO(CityDAO dao){
		this.cityDAO = dao;
	}


	public DistrictDAO getDistrictDAO(){
		return this.districtDAO;
	}
	public void setDistrictDAO(DistrictDAO dao){
		this.districtDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserWhiteListDAO getUserWhiteListDAO(){
		return this.userWhiteListDAO;
	}
	public void setUserWhiteListDAO(UserWhiteListDAO dao){
		this.userWhiteListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public QuickLinkDAO getQuickLinkDAO(){
		return this.quickLinkDAO;
	}
	public void setQuickLinkDAO(QuickLinkDAO dao){
		this.quickLinkDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public ObjectAccessDAO getObjectAccessDAO(){
		return this.objectAccessDAO;
	}
	public void setObjectAccessDAO(ObjectAccessDAO dao){
		this.objectAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public GenericFormDAO getGenericFormDAO(){
		return this.genericFormDAO;
	}
	public void setGenericFormDAO(GenericFormDAO dao){
		this.genericFormDAO = dao;
	}


	public FormMessageDAO getFormMessageDAO(){
		return this.formMessageDAO;
	}
	public void setFormMessageDAO(FormMessageDAO dao){
		this.formMessageDAO = dao;
	}


	public FormFieldMessageDAO getFormFieldMessageDAO(){
		return this.formFieldMessageDAO;
	}
	public void setFormFieldMessageDAO(FormFieldMessageDAO dao){
		this.formFieldMessageDAO = dao;
	}


	public FormFieldDAO getFormFieldDAO(){
		return this.formFieldDAO;
	}
	public void setFormFieldDAO(FormFieldDAO dao){
		this.formFieldDAO = dao;
	}


	public FormActionDAO getFormActionDAO(){
		return this.formActionDAO;
	}
	public void setFormActionDAO(FormActionDAO dao){
		this.formActionDAO = dao;
	}


	public CandidateContainerDAO getCandidateContainerDAO(){
		return this.candidateContainerDAO;
	}
	public void setCandidateContainerDAO(CandidateContainerDAO dao){
		this.candidateContainerDAO = dao;
	}


	public CandidateElementDAO getCandidateElementDAO(){
		return this.candidateElementDAO;
	}
	public void setCandidateElementDAO(CandidateElementDAO dao){
		this.candidateElementDAO = dao;
	}


	public WechatWorkappIdentifyDAO getWechatWorkappIdentifyDAO(){
		return this.wechatWorkappIdentifyDAO;
	}
	public void setWechatWorkappIdentifyDAO(WechatWorkappIdentifyDAO dao){
		this.wechatWorkappIdentifyDAO = dao;
	}


	public WechatMiniappIdentifyDAO getWechatMiniappIdentifyDAO(){
		return this.wechatMiniappIdentifyDAO;
	}
	public void setWechatMiniappIdentifyDAO(WechatMiniappIdentifyDAO dao){
		this.wechatMiniappIdentifyDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    void enhanceList(DAOGroup daoGoup, List list) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("Platform", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPlatformDAO().load(id, PlatformTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPlatformDAO().enhanceList((List<Platform>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPlatformDAO().present((Platform)data, tokens);
			}
		});

		internalLoaderMap.put("User", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDAO().load(id, UserTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserDAO().enhanceList((List<User>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDAO().present((User)data, tokens);
			}
		});

		internalLoaderMap.put("Role", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRoleDAO().load(id, RoleTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRoleDAO().enhanceList((List<Role>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRoleDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRoleDAO().present((Role)data, tokens);
			}
		});

		internalLoaderMap.put("LeaveRecord", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLeaveRecordDAO().load(id, LeaveRecordTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLeaveRecordDAO().enhanceList((List<LeaveRecord>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLeaveRecordDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLeaveRecordDAO().present((LeaveRecord)data, tokens);
			}
		});

		internalLoaderMap.put("LeaveRecordType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLeaveRecordTypeDAO().load(id, LeaveRecordTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLeaveRecordTypeDAO().enhanceList((List<LeaveRecordType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLeaveRecordTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLeaveRecordTypeDAO().present((LeaveRecordType)data, tokens);
			}
		});

		internalLoaderMap.put("HolydaySetting", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getHolydaySettingDAO().load(id, HolydaySettingTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getHolydaySettingDAO().enhanceList((List<HolydaySetting>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getHolydaySettingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getHolydaySettingDAO().present((HolydaySetting)data, tokens);
			}
		});

		internalLoaderMap.put("Province", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProvinceDAO().load(id, ProvinceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getProvinceDAO().enhanceList((List<Province>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProvinceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProvinceDAO().present((Province)data, tokens);
			}
		});

		internalLoaderMap.put("City", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCityDAO().load(id, CityTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCityDAO().enhanceList((List<City>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityDAO().present((City)data, tokens);
			}
		});

		internalLoaderMap.put("District", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getDistrictDAO().load(id, DistrictTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getDistrictDAO().enhanceList((List<District>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDistrictDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDistrictDAO().present((District)data, tokens);
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserDomainDAO().enhanceList((List<UserDomain>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
		});

		internalLoaderMap.put("UserWhiteList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, UserWhiteListTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserWhiteListDAO().enhanceList((List<UserWhiteList>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserWhiteListDAO().present((UserWhiteList)data, tokens);
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSecUserDAO().enhanceList((List<SecUser>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserAppDAO().enhanceList((List<UserApp>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
		});

		internalLoaderMap.put("QuickLink", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, QuickLinkTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getQuickLinkDAO().enhanceList((List<QuickLink>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().present((QuickLink)data, tokens);
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getListAccessDAO().enhanceList((List<ListAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
		});

		internalLoaderMap.put("ObjectAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, ObjectAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getObjectAccessDAO().enhanceList((List<ObjectAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getObjectAccessDAO().present((ObjectAccess)data, tokens);
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLoginHistoryDAO().enhanceList((List<LoginHistory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
		});

		internalLoaderMap.put("GenericForm", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, GenericFormTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGenericFormDAO().enhanceList((List<GenericForm>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGenericFormDAO().present((GenericForm)data, tokens);
			}
		});

		internalLoaderMap.put("FormMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, FormMessageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormMessageDAO().enhanceList((List<FormMessage>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormMessageDAO().present((FormMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormFieldMessage", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, FormFieldMessageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormFieldMessageDAO().enhanceList((List<FormFieldMessage>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldMessageDAO().present((FormFieldMessage)data, tokens);
			}
		});

		internalLoaderMap.put("FormField", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, FormFieldTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormFieldDAO().enhanceList((List<FormField>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormFieldDAO().present((FormField)data, tokens);
			}
		});

		internalLoaderMap.put("FormAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getFormActionDAO().load(id, FormActionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getFormActionDAO().enhanceList((List<FormAction>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getFormActionDAO().present((FormAction)data, tokens);
			}
		});

		internalLoaderMap.put("CandidateContainer", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, CandidateContainerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateContainerDAO().enhanceList((List<CandidateContainer>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().present((CandidateContainer)data, tokens);
			}
		});

		internalLoaderMap.put("CandidateElement", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, CandidateElementTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateElementDAO().enhanceList((List<CandidateElement>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().present((CandidateElement)data, tokens);
			}
		});

		internalLoaderMap.put("WechatWorkappIdentify", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().load(id, WechatWorkappIdentifyTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatWorkappIdentifyDAO().enhanceList((List<WechatWorkappIdentify>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentifyDAO().present((WechatWorkappIdentify)data, tokens);
			}
		});

		internalLoaderMap.put("WechatMiniappIdentify", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().load(id, WechatMiniappIdentifyTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatMiniappIdentifyDAO().enhanceList((List<WechatMiniappIdentify>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentifyDAO().present((WechatMiniappIdentify)data, tokens);
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public <T> void enhanceList(List list, Class<T> clazz) throws Exception{
	    BasicLoader loader = internalLoaderMap.get(clazz.getSimpleName());
	    if (loader == null) {
	    	return ;
	    }

	    loader.enhanceList(this, list);
	}
}


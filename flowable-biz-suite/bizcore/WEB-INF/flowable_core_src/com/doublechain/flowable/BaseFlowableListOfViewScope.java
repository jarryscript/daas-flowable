package com.doublechain.flowable;

import java.util.HashMap;
import java.util.Map;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechain.flowable.platform.Platform;
import com.doublechain.flowable.user.User;
import com.doublechain.flowable.role.Role;
import com.doublechain.flowable.leaverecord.LeaveRecord;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.holydaysetting.HolydaySetting;
import com.doublechain.flowable.province.Province;
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.district.District;
import com.doublechain.flowable.userdomain.UserDomain;
import com.doublechain.flowable.userwhitelist.UserWhiteList;
import com.doublechain.flowable.secuser.SecUser;
import com.doublechain.flowable.userapp.UserApp;
import com.doublechain.flowable.quicklink.QuickLink;
import com.doublechain.flowable.listaccess.ListAccess;
import com.doublechain.flowable.objectaccess.ObjectAccess;
import com.doublechain.flowable.loginhistory.LoginHistory;
import com.doublechain.flowable.genericform.GenericForm;
import com.doublechain.flowable.formmessage.FormMessage;
import com.doublechain.flowable.formfieldmessage.FormFieldMessage;
import com.doublechain.flowable.formfield.FormField;
import com.doublechain.flowable.formaction.FormAction;
import com.doublechain.flowable.candidatecontainer.CandidateContainer;
import com.doublechain.flowable.candidateelement.CandidateElement;
import com.doublechain.flowable.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechain.flowable.wechatminiappidentify.WechatMiniappIdentify;


public class BaseFlowableListOfViewScope {

	/** Platform的简单属性序列化列表 */
	protected SerializeScope getPlatformSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(Platform.ID_PROPERTY)
			.field(Platform.NAME_PROPERTY)
			.field(Platform.FOUNDED_PROPERTY)
			.field(Platform.VERSION_PROPERTY)
		;
	}

	/** User的简单属性序列化列表 */
	protected SerializeScope getUserSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(User.ID_PROPERTY)
			.field(User.NAME_PROPERTY)
			.field(User.MOBILE_PROPERTY)
			.field(User.AVATAR_PROPERTY)
			.field(User.AGE_PROPERTY)
			.field(User.DESCRIPTION_PROPERTY)
			.field(User.VERSION_PROPERTY)
		;
	}

	/** Role的简单属性序列化列表 */
	protected SerializeScope getRoleSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(Role.ID_PROPERTY)
			.field(Role.NAME_PROPERTY)
			.field(Role.CODE_PROPERTY)
			.field(Role.VERSION_PROPERTY)
		;
	}

	/** LeaveRecord的简单属性序列化列表 */
	protected SerializeScope getLeaveRecordSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(LeaveRecord.ID_PROPERTY)
			.field(LeaveRecord.FROMDATE_PROPERTY)
			.field(LeaveRecord.TODATE_PROPERTY)
			.field(LeaveRecord.VERSION_PROPERTY)
		;
	}

	/** LeaveRecordType的简单属性序列化列表 */
	protected SerializeScope getLeaveRecordTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(LeaveRecordType.ID_PROPERTY)
			.field(LeaveRecordType.NAME_PROPERTY)
			.field(LeaveRecordType.CODE_PROPERTY)
			.field(LeaveRecordType.VERSION_PROPERTY)
		;
	}

	/** HolydaySetting的简单属性序列化列表 */
	protected SerializeScope getHolydaySettingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(HolydaySetting.ID_PROPERTY)
			.field(HolydaySetting.LEAVE_DAYS_PROPERTY)
			.field(HolydaySetting.VERSION_PROPERTY)
		;
	}

	/** Province的简单属性序列化列表 */
	protected SerializeScope getProvinceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(Province.ID_PROPERTY)
			.field(Province.NAME_PROPERTY)
			.field(Province.VERSION_PROPERTY)
		;
	}

	/** City的简单属性序列化列表 */
	protected SerializeScope getCitySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(City.ID_PROPERTY)
			.field(City.NAME_PROPERTY)
			.field(City.VERSION_PROPERTY)
		;
	}

	/** District的简单属性序列化列表 */
	protected SerializeScope getDistrictSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(District.ID_PROPERTY)
			.field(District.NAME_PROPERTY)
			.field(District.VERSION_PROPERTY)
		;
	}

	/** UserDomain的简单属性序列化列表 */
	protected SerializeScope getUserDomainSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY)
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserWhiteList的简单属性序列化列表 */
	protected SerializeScope getUserWhiteListSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(UserWhiteList.ID_PROPERTY)
			.field(UserWhiteList.USER_IDENTITY_PROPERTY)
			.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
			.field(UserWhiteList.VERSION_PROPERTY)
		;
	}

	/** SecUser的简单属性序列化列表 */
	protected SerializeScope getSecUserSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(SecUser.ID_PROPERTY)
			.field(SecUser.LOGIN_PROPERTY)
			.field(SecUser.MOBILE_PROPERTY)
			.field(SecUser.EMAIL_PROPERTY)
			.field(SecUser.PWD_PROPERTY)
			.field(SecUser.WEIXIN_OPENID_PROPERTY)
			.field(SecUser.WEIXIN_APPID_PROPERTY)
			.field(SecUser.ACCESS_TOKEN_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
			.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的简单属性序列化列表 */
	protected SerializeScope getUserAppSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY)
			.field(UserApp.APP_ICON_PROPERTY)
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的简单属性序列化列表 */
	protected SerializeScope getQuickLinkSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY)
			.field(QuickLink.ICON_PROPERTY)
			.field(QuickLink.IMAGE_PATH_PROPERTY)
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的简单属性序列化列表 */
	protected SerializeScope getListAccessSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY)
			.field(ListAccess.INTERNAL_NAME_PROPERTY)
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** ObjectAccess的简单属性序列化列表 */
	protected SerializeScope getObjectAccessSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(ObjectAccess.ID_PROPERTY)
			.field(ObjectAccess.NAME_PROPERTY)
			.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
			.field(ObjectAccess.LIST1_PROPERTY)
			.field(ObjectAccess.LIST2_PROPERTY)
			.field(ObjectAccess.LIST3_PROPERTY)
			.field(ObjectAccess.LIST4_PROPERTY)
			.field(ObjectAccess.LIST5_PROPERTY)
			.field(ObjectAccess.LIST6_PROPERTY)
			.field(ObjectAccess.LIST7_PROPERTY)
			.field(ObjectAccess.LIST8_PROPERTY)
			.field(ObjectAccess.LIST9_PROPERTY)
			.field(ObjectAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的简单属性序列化列表 */
	protected SerializeScope getLoginHistorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY)
			.field(LoginHistory.DESCRIPTION_PROPERTY)
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** GenericForm的简单属性序列化列表 */
	protected SerializeScope getGenericFormSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(GenericForm.ID_PROPERTY)
			.field(GenericForm.TITLE_PROPERTY)
			.field(GenericForm.DESCRIPTION_PROPERTY)
			.field(GenericForm.VERSION_PROPERTY)
		;
	}

	/** FormMessage的简单属性序列化列表 */
	protected SerializeScope getFormMessageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(FormMessage.ID_PROPERTY)
			.field(FormMessage.TITLE_PROPERTY)
			.field(FormMessage.LEVEL_PROPERTY)
			.field(FormMessage.VERSION_PROPERTY)
		;
	}

	/** FormFieldMessage的简单属性序列化列表 */
	protected SerializeScope getFormFieldMessageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(FormFieldMessage.ID_PROPERTY)
			.field(FormFieldMessage.TITLE_PROPERTY)
			.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
			.field(FormFieldMessage.LEVEL_PROPERTY)
			.field(FormFieldMessage.VERSION_PROPERTY)
		;
	}

	/** FormField的简单属性序列化列表 */
	protected SerializeScope getFormFieldSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(FormField.ID_PROPERTY)
			.field(FormField.LABEL_PROPERTY)
			.field(FormField.LOCALE_KEY_PROPERTY)
			.field(FormField.PARAMETER_NAME_PROPERTY)
			.field(FormField.TYPE_PROPERTY)
			.field(FormField.PLACEHOLDER_PROPERTY)
			.field(FormField.DEFAULT_VALUE_PROPERTY)
			.field(FormField.DESCRIPTION_PROPERTY)
			.field(FormField.FIELD_GROUP_PROPERTY)
			.field(FormField.MINIMUM_VALUE_PROPERTY)
			.field(FormField.MAXIMUM_VALUE_PROPERTY)
			.field(FormField.REQUIRED_PROPERTY)
			.field(FormField.DISABLED_PROPERTY)
			.field(FormField.CUSTOM_RENDERING_PROPERTY)
			.field(FormField.CANDIDATE_VALUES_PROPERTY)
			.field(FormField.SUGGEST_VALUES_PROPERTY)
			.field(FormField.VERSION_PROPERTY)
		;
	}

	/** FormAction的简单属性序列化列表 */
	protected SerializeScope getFormActionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(FormAction.ID_PROPERTY)
			.field(FormAction.LABEL_PROPERTY)
			.field(FormAction.LOCALE_KEY_PROPERTY)
			.field(FormAction.ACTION_KEY_PROPERTY)
			.field(FormAction.LEVEL_PROPERTY)
			.field(FormAction.URL_PROPERTY)
			.field(FormAction.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的简单属性序列化列表 */
	protected SerializeScope getCandidateContainerSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY)
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的简单属性序列化列表 */
	protected SerializeScope getCandidateElementSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY)
			.field(CandidateElement.TYPE_PROPERTY)
			.field(CandidateElement.IMAGE_PROPERTY)
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentify的简单属性序列化列表 */
	protected SerializeScope getWechatWorkappIdentifySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentify.ID_PROPERTY)
			.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
			.field(WechatWorkappIdentify.USER_ID_PROPERTY)
			.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentify.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentify的简单属性序列化列表 */
	protected SerializeScope getWechatMiniappIdentifySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentify.ID_PROPERTY)
			.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
			.field(WechatMiniappIdentify.APP_ID_PROPERTY)
			.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentify.VERSION_PROPERTY)
		;
	}

	/** Platform的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPlatformListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='EHR';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='founded';
		//	type='date_time_now';
		//	value='now()';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(Platform.ID_PROPERTY)
			.field(Platform.NAME_PROPERTY).as("title")
			.field(Platform.FOUNDED_PROPERTY).as("brief")
			.field(Platform.VERSION_PROPERTY)
		;
	}

	/** User的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='王大锤';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string_longtext';
		//	value='text()';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(User.ID_PROPERTY)
			.field(User.NAME_PROPERTY).as("title")
			.field(User.MOBILE_PROPERTY)
			.field(User.AVATAR_PROPERTY)
			.field(User.AGE_PROPERTY)
			.field(User.DESCRIPTION_PROPERTY).as("brief")
			.field(User.DISTRICT_PROPERTY, getDistrictSummaryScope())
			.field(User.ROLE_PROPERTY, getRoleSummaryScope())
			.field(User.VERSION_PROPERTY)
		;
	}

	/** Role的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRoleListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='员工|主管|老板';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='EMPLOYEE|MANAGER|BOSS';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(Role.ID_PROPERTY)
			.field(Role.NAME_PROPERTY).as("title")
			.field(Role.CODE_PROPERTY).as("brief")
			.field(Role.VERSION_PROPERTY)
		;
	}

	/** LeaveRecord的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLeaveRecordListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='fromdate';
		//	type='date';
		//	value='2020-02-02';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='type';
		//	type='leave_record_type';
		//	value='$(object)';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(LeaveRecord.ID_PROPERTY)
			.field(LeaveRecord.USER_PROPERTY, getUserSummaryScope())
			.field(LeaveRecord.TYPE_PROPERTY, SerializeScope.INCLUDE()
				.field(LeaveRecordType.NAME_PROPERTY).as("brief")).move_up()
			.field(LeaveRecord.FROMDATE_PROPERTY).as("title")
			.field(LeaveRecord.TODATE_PROPERTY)
			.field(LeaveRecord.PLATFORM_PROPERTY, getPlatformSummaryScope())
			.field(LeaveRecord.VERSION_PROPERTY)
		;
	}

	/** LeaveRecordType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLeaveRecordTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='年假|病假|事假|婚假|产假';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='code';
		//	type='string';
		//	value='ANNUAL_LEAVE|SICK_LEACK|PERSONAL_LEAVE|MARRIAGE_HOLIDAY|MATERNITY_LEAVE';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(LeaveRecordType.ID_PROPERTY)
			.field(LeaveRecordType.NAME_PROPERTY).as("title")
			.field(LeaveRecordType.CODE_PROPERTY).as("brief")
			.field(LeaveRecordType.VERSION_PROPERTY)
		;
	}

	/** HolydaySetting的ListOf时需要序列化的属性列表 */
	protected SerializeScope getHolydaySettingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='leave_days';
		//	type='int';
		//	value='10';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='type';
		//	type='leave_record_type';
		//	value='$(object)';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(HolydaySetting.ID_PROPERTY)
			.field(HolydaySetting.TYPE_PROPERTY, SerializeScope.INCLUDE()
				.field(LeaveRecordType.NAME_PROPERTY).as("brief")).move_up()
			.field(HolydaySetting.LEAVE_DAYS_PROPERTY).as("title")
			.field(HolydaySetting.VERSION_PROPERTY)
		;
	}

	/** Province的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProvinceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='四川|北京';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(Province.ID_PROPERTY)
			.field(Province.NAME_PROPERTY).as("title")
			.field(Province.PLATFORM_PROPERTY, getPlatformSummaryScope())
			.field(Province.VERSION_PROPERTY)
		;
	}

	/** City的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCityListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='成都|北京';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(City.ID_PROPERTY)
			.field(City.NAME_PROPERTY).as("title")
			.field(City.PROVINCE_PROPERTY, getProvinceSummaryScope())
			.field(City.PLATFORM_PROPERTY, getPlatformSummaryScope())
			.field(City.VERSION_PROPERTY)
		;
	}

	/** District的ListOf时需要序列化的属性列表 */
	protected SerializeScope getDistrictListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='成华区|朝阳区|锦江区|海淀区';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(District.ID_PROPERTY)
			.field(District.NAME_PROPERTY).as("title")
			.field(District.CITY_PROPERTY, getCitySummaryScope())
			.field(District.PLATFORM_PROPERTY, getPlatformSummaryScope())
			.field(District.VERSION_PROPERTY)
		;
	}

	/** UserDomain的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserDomainListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='用户区域';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY).as("title")
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserWhiteList的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserWhiteListListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='user_identity';
		//	type='string';
		//	value='clariones|13808188512';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='user_special_functions';
		//	type='string';
		//	value='tester;ios-spokesperson';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(UserWhiteList.ID_PROPERTY)
			.field(UserWhiteList.USER_IDENTITY_PROPERTY).as("title")
			.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY).as("brief")
			.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(UserWhiteList.VERSION_PROPERTY)
		;
	}

	/** SecUser的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSecUserListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='login';
		//	type='string';
		//	value='login';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='verification_code';
		//	type='int';
		//	value='0|9999999';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(SecUser.ID_PROPERTY)
			.field(SecUser.LOGIN_PROPERTY).as("title")
			.field(SecUser.MOBILE_PROPERTY)
			.field(SecUser.EMAIL_PROPERTY)
			.field(SecUser.PWD_PROPERTY)
			.field(SecUser.WEIXIN_OPENID_PROPERTY)
			.field(SecUser.WEIXIN_APPID_PROPERTY)
			.field(SecUser.ACCESS_TOKEN_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_PROPERTY).as("brief")
			.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
			.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
			.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserAppListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='审车平台|账户管理|接车公司|审车公司|维修公司|顾客';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='app_icon';
		//	type='string';
		//	value='users|bank|wechat|bar-chart|user|users';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY).as("title")
			.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(UserApp.APP_ICON_PROPERTY).as("brief")
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的ListOf时需要序列化的属性列表 */
	protected SerializeScope getQuickLinkListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='列表';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='icon';
		//	type='string';
		//	value='facebook|google';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_path';
		//	type='string_image';
		//	value='y-200-200-red.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY).as("title")
			.field(QuickLink.ICON_PROPERTY).as("brief")
			.field(QuickLink.IMAGE_PATH_PROPERTY).as("imageUrl")
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的ListOf时需要序列化的属性列表 */
	protected SerializeScope getListAccessListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='列表';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='internal_name';
		//	type='string';
		//	value='levelOneCategoryList';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY).as("title")
			.field(ListAccess.INTERNAL_NAME_PROPERTY).as("brief")
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** ObjectAccess的ListOf时需要序列化的属性列表 */
	protected SerializeScope getObjectAccessListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='控制访问列表1';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='object_type';
		//	type='string';
		//	value='FranchiseeStoreCountryCenter|AccountSet';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(ObjectAccess.ID_PROPERTY)
			.field(ObjectAccess.NAME_PROPERTY).as("title")
			.field(ObjectAccess.OBJECT_TYPE_PROPERTY).as("brief")
			.field(ObjectAccess.LIST1_PROPERTY)
			.field(ObjectAccess.LIST2_PROPERTY)
			.field(ObjectAccess.LIST3_PROPERTY)
			.field(ObjectAccess.LIST4_PROPERTY)
			.field(ObjectAccess.LIST5_PROPERTY)
			.field(ObjectAccess.LIST6_PROPERTY)
			.field(ObjectAccess.LIST7_PROPERTY)
			.field(ObjectAccess.LIST8_PROPERTY)
			.field(ObjectAccess.LIST9_PROPERTY)
			.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
			.field(ObjectAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLoginHistoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='from_ip';
		//	type='string';
		//	value='192.168.1.1|192.168.1.2';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='登陆成功';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY).as("title")
			.field(LoginHistory.DESCRIPTION_PROPERTY).as("brief")
			.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** GenericForm的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGenericFormListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='登记输入单';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='姓名就是你身份证上的名字';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(GenericForm.ID_PROPERTY)
			.field(GenericForm.TITLE_PROPERTY).as("title")
			.field(GenericForm.DESCRIPTION_PROPERTY).as("brief")
			.field(GenericForm.VERSION_PROPERTY)
		;
	}

	/** FormMessage的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormMessageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='字段组合错误';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='level';
		//	type='string';
		//	value='success|info|warning|danger';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(FormMessage.ID_PROPERTY)
			.field(FormMessage.TITLE_PROPERTY).as("title")
			.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormMessage.LEVEL_PROPERTY).as("brief")
			.field(FormMessage.VERSION_PROPERTY)
		;
	}

	/** FormFieldMessage的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormFieldMessageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title';
		//	type='string';
		//	value='输入错误';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='parameter_name';
		//	type='string';
		//	value='name';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(FormFieldMessage.ID_PROPERTY)
			.field(FormFieldMessage.TITLE_PROPERTY).as("title")
			.field(FormFieldMessage.PARAMETER_NAME_PROPERTY).as("brief")
			.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormFieldMessage.LEVEL_PROPERTY)
			.field(FormFieldMessage.VERSION_PROPERTY)
		;
	}

	/** FormField的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormFieldListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='parameter_name';
		//	type='string';
		//	value='name';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='description';
		//	type='string';
		//	value='姓名就是你身份证上的名字';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(FormField.ID_PROPERTY)
			.field(FormField.LABEL_PROPERTY)
			.field(FormField.LOCALE_KEY_PROPERTY)
			.field(FormField.PARAMETER_NAME_PROPERTY).as("title")
			.field(FormField.TYPE_PROPERTY)
			.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormField.PLACEHOLDER_PROPERTY)
			.field(FormField.DEFAULT_VALUE_PROPERTY)
			.field(FormField.DESCRIPTION_PROPERTY).as("brief")
			.field(FormField.FIELD_GROUP_PROPERTY)
			.field(FormField.MINIMUM_VALUE_PROPERTY)
			.field(FormField.MAXIMUM_VALUE_PROPERTY)
			.field(FormField.REQUIRED_PROPERTY)
			.field(FormField.DISABLED_PROPERTY)
			.field(FormField.CUSTOM_RENDERING_PROPERTY)
			.field(FormField.CANDIDATE_VALUES_PROPERTY)
			.field(FormField.SUGGEST_VALUES_PROPERTY)
			.field(FormField.VERSION_PROPERTY)
		;
	}

	/** FormAction的ListOf时需要序列化的属性列表 */
	protected SerializeScope getFormActionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='label';
		//	type='string';
		//	value='功能';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='locale_key';
		//	type='string';
		//	value='name';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(FormAction.ID_PROPERTY)
			.field(FormAction.LABEL_PROPERTY).as("title")
			.field(FormAction.LOCALE_KEY_PROPERTY).as("brief")
			.field(FormAction.ACTION_KEY_PROPERTY)
			.field(FormAction.LEVEL_PROPERTY)
			.field(FormAction.URL_PROPERTY)
			.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
			.field(FormAction.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateContainerListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='我只是一个容器';
		//equired='true';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY).as("title")
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateElementListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name';
		//	type='string';
		//	value='搜索到的匹配字段';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='type';
		//	type='string';
		//	value='类型描述';
		//equired='true';
		//}
		//, imageUrlField=fieldesc{
		//	name='image';
		//	type='string_image';
		//	value='1.jpg';
		//equired='true';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY).as("title")
			.field(CandidateElement.TYPE_PROPERTY).as("brief")
			.field(CandidateElement.IMAGE_PROPERTY).as("imageUrl")
			.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentify的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatWorkappIdentifyListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='corp_id';
		//	type='string';
		//	value='corporation123';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='user_id';
		//	type='string';
		//	value='user123';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentify.ID_PROPERTY)
			.field(WechatWorkappIdentify.CORP_ID_PROPERTY).as("title")
			.field(WechatWorkappIdentify.USER_ID_PROPERTY).as("brief")
			.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentify.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentify的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatMiniappIdentifyListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='open_id';
		//	type='string';
		//	value='wechat_open_id_1234567890';
		//equired='true';
		//}
		//, briefField=fieldesc{
		//	name='app_id';
		//	type='string';
		//	value='wechat_miniapp_id_1234567890';
		//equired='true';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(FlowableBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentify.ID_PROPERTY)
			.field(WechatMiniappIdentify.OPEN_ID_PROPERTY).as("title")
			.field(WechatMiniappIdentify.APP_ID_PROPERTY).as("brief")
			.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentify.VERSION_PROPERTY)
		;
	}

	
	public SerializeScope getListOfViewScope(String listClassName, String ownerClassName) {
		return scopes.get(listClassName);
	}
	
	
	protected Map<String, SerializeScope> scopes;
	protected void initAllViewScope() {
		scopes = new HashMap<>();
		scopes.put(Platform.class.getName(),getPlatformListOfViewScope());
		scopes.put(User.class.getName(),getUserListOfViewScope());
		scopes.put(Role.class.getName(),getRoleListOfViewScope());
		scopes.put(LeaveRecord.class.getName(),getLeaveRecordListOfViewScope());
		scopes.put(LeaveRecordType.class.getName(),getLeaveRecordTypeListOfViewScope());
		scopes.put(HolydaySetting.class.getName(),getHolydaySettingListOfViewScope());
		scopes.put(Province.class.getName(),getProvinceListOfViewScope());
		scopes.put(City.class.getName(),getCityListOfViewScope());
		scopes.put(District.class.getName(),getDistrictListOfViewScope());
		scopes.put(UserDomain.class.getName(),getUserDomainListOfViewScope());
		scopes.put(UserWhiteList.class.getName(),getUserWhiteListListOfViewScope());
		scopes.put(SecUser.class.getName(),getSecUserListOfViewScope());
		scopes.put(UserApp.class.getName(),getUserAppListOfViewScope());
		scopes.put(QuickLink.class.getName(),getQuickLinkListOfViewScope());
		scopes.put(ListAccess.class.getName(),getListAccessListOfViewScope());
		scopes.put(ObjectAccess.class.getName(),getObjectAccessListOfViewScope());
		scopes.put(LoginHistory.class.getName(),getLoginHistoryListOfViewScope());
		scopes.put(GenericForm.class.getName(),getGenericFormListOfViewScope());
		scopes.put(FormMessage.class.getName(),getFormMessageListOfViewScope());
		scopes.put(FormFieldMessage.class.getName(),getFormFieldMessageListOfViewScope());
		scopes.put(FormField.class.getName(),getFormFieldListOfViewScope());
		scopes.put(FormAction.class.getName(),getFormActionListOfViewScope());
		scopes.put(CandidateContainer.class.getName(),getCandidateContainerListOfViewScope());
		scopes.put(CandidateElement.class.getName(),getCandidateElementListOfViewScope());
		scopes.put(WechatWorkappIdentify.class.getName(),getWechatWorkappIdentifyListOfViewScope());
		scopes.put(WechatMiniappIdentify.class.getName(),getWechatMiniappIdentifyListOfViewScope());
	}

}








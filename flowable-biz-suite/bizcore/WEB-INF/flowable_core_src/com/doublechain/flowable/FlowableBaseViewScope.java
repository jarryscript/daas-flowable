package com.doublechain.flowable;


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


public class FlowableBaseViewScope {

	protected static SerializeScope PlatformBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Platform.ID_PROPERTY)
		.field(Platform.NAME_PROPERTY)
		.field(Platform.FOUNDED_PROPERTY)
		;
	/** 用于Platform的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPlatformSummaryScope() {
		return PlatformBaseSummaryScope;
	}

	protected static SerializeScope UserBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(User.ID_PROPERTY)
		.field(User.NAME_PROPERTY)
		.field(User.MOBILE_PROPERTY)
		.field(User.AVATAR_PROPERTY)
		.field(User.AGE_PROPERTY)
		.field(User.DESCRIPTION_PROPERTY)
		;
	/** 用于User的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserSummaryScope() {
		return UserBaseSummaryScope;
	}

	protected static SerializeScope RoleBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Role.ID_PROPERTY)
		.field(Role.NAME_PROPERTY)
		.field(Role.CODE_PROPERTY)
		;
	/** 用于Role的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRoleSummaryScope() {
		return RoleBaseSummaryScope;
	}

	protected static SerializeScope LeaveRecordBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LeaveRecord.ID_PROPERTY)
		.field(LeaveRecord.FROMDATE_PROPERTY)
		.field(LeaveRecord.TODATE_PROPERTY)
		;
	/** 用于LeaveRecord的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLeaveRecordSummaryScope() {
		return LeaveRecordBaseSummaryScope;
	}

	protected static SerializeScope LeaveRecordTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LeaveRecordType.ID_PROPERTY)
		.field(LeaveRecordType.NAME_PROPERTY)
		.field(LeaveRecordType.CODE_PROPERTY)
		;
	/** 用于LeaveRecordType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLeaveRecordTypeSummaryScope() {
		return LeaveRecordTypeBaseSummaryScope;
	}

	protected static SerializeScope HolydaySettingBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(HolydaySetting.ID_PROPERTY)
		.field(HolydaySetting.LEAVE_DAYS_PROPERTY)
		;
	/** 用于HolydaySetting的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getHolydaySettingSummaryScope() {
		return HolydaySettingBaseSummaryScope;
	}

	protected static SerializeScope ProvinceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Province.ID_PROPERTY)
		.field(Province.NAME_PROPERTY)
		;
	/** 用于Province的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProvinceSummaryScope() {
		return ProvinceBaseSummaryScope;
	}

	protected static SerializeScope CityBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(City.ID_PROPERTY)
		.field(City.NAME_PROPERTY)
		;
	/** 用于City的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCitySummaryScope() {
		return CityBaseSummaryScope;
	}

	protected static SerializeScope DistrictBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(District.ID_PROPERTY)
		.field(District.NAME_PROPERTY)
		;
	/** 用于District的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDistrictSummaryScope() {
		return DistrictBaseSummaryScope;
	}

	protected static SerializeScope UserDomainBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSummaryScope() {
		return UserDomainBaseSummaryScope;
	}

	protected static SerializeScope UserWhiteListBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSummaryScope() {
		return UserWhiteListBaseSummaryScope;
	}

	protected static SerializeScope SecUserBaseSummaryScope = SerializeScope.INCLUDE()
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
		;
	/** 用于SecUser的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserSummaryScope() {
		return SecUserBaseSummaryScope;
	}

	protected static SerializeScope UserAppBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppSummaryScope() {
		return UserAppBaseSummaryScope;
	}

	protected static SerializeScope QuickLinkBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSummaryScope() {
		return QuickLinkBaseSummaryScope;
	}

	protected static SerializeScope ListAccessBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessSummaryScope() {
		return ListAccessBaseSummaryScope;
	}

	protected static SerializeScope ObjectAccessBaseSummaryScope = SerializeScope.INCLUDE()
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
		;
	/** 用于ObjectAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessSummaryScope() {
		return ObjectAccessBaseSummaryScope;
	}

	protected static SerializeScope LoginHistoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySummaryScope() {
		return LoginHistoryBaseSummaryScope;
	}

	protected static SerializeScope GenericFormBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		;
	/** 用于GenericForm的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGenericFormSummaryScope() {
		return GenericFormBaseSummaryScope;
	}

	protected static SerializeScope FormMessageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormMessageSummaryScope() {
		return FormMessageBaseSummaryScope;
	}

	protected static SerializeScope FormFieldMessageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageSummaryScope() {
		return FormFieldMessageBaseSummaryScope;
	}

	protected static SerializeScope FormFieldBaseSummaryScope = SerializeScope.INCLUDE()
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
		;
	/** 用于FormField的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldSummaryScope() {
		return FormFieldBaseSummaryScope;
	}

	protected static SerializeScope FormActionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		;
	/** 用于FormAction的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormActionSummaryScope() {
		return FormActionBaseSummaryScope;
	}

	protected static SerializeScope CandidateContainerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSummaryScope() {
		return CandidateContainerBaseSummaryScope;
	}

	protected static SerializeScope CandidateElementBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSummaryScope() {
		return CandidateElementBaseSummaryScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifySummaryScope() {
		return WechatWorkappIdentifyBaseSummaryScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseSummaryScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifySummaryScope() {
		return WechatMiniappIdentifyBaseSummaryScope;
	}

	protected static SerializeScope PlatformBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Platform.ID_PROPERTY)
		.field(Platform.NAME_PROPERTY)
		.field(Platform.FOUNDED_PROPERTY)
		;
	/** 用于Platform的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPlatformSecondaryListItemScope() {
		return PlatformBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(User.ID_PROPERTY)
		.field(User.NAME_PROPERTY)
		.field(User.MOBILE_PROPERTY)
		.field(User.AVATAR_PROPERTY)
		.field(User.AGE_PROPERTY)
		.field(User.DESCRIPTION_PROPERTY)
		;
	/** 用于User的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserSecondaryListItemScope() {
		return UserBaseSecondaryListItemScope;
	}

	protected static SerializeScope RoleBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Role.ID_PROPERTY)
		.field(Role.NAME_PROPERTY)
		.field(Role.CODE_PROPERTY)
		;
	/** 用于Role的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRoleSecondaryListItemScope() {
		return RoleBaseSecondaryListItemScope;
	}

	protected static SerializeScope LeaveRecordBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LeaveRecord.ID_PROPERTY)
		.field(LeaveRecord.FROMDATE_PROPERTY)
		.field(LeaveRecord.TODATE_PROPERTY)
		;
	/** 用于LeaveRecord的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLeaveRecordSecondaryListItemScope() {
		return LeaveRecordBaseSecondaryListItemScope;
	}

	protected static SerializeScope LeaveRecordTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LeaveRecordType.ID_PROPERTY)
		.field(LeaveRecordType.NAME_PROPERTY)
		.field(LeaveRecordType.CODE_PROPERTY)
		;
	/** 用于LeaveRecordType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLeaveRecordTypeSecondaryListItemScope() {
		return LeaveRecordTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope HolydaySettingBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(HolydaySetting.ID_PROPERTY)
		.field(HolydaySetting.LEAVE_DAYS_PROPERTY)
		;
	/** 用于HolydaySetting的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getHolydaySettingSecondaryListItemScope() {
		return HolydaySettingBaseSecondaryListItemScope;
	}

	protected static SerializeScope ProvinceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Province.ID_PROPERTY)
		.field(Province.NAME_PROPERTY)
		;
	/** 用于Province的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProvinceSecondaryListItemScope() {
		return ProvinceBaseSecondaryListItemScope;
	}

	protected static SerializeScope CityBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(City.ID_PROPERTY)
		.field(City.NAME_PROPERTY)
		;
	/** 用于City的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCitySecondaryListItemScope() {
		return CityBaseSecondaryListItemScope;
	}

	protected static SerializeScope DistrictBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(District.ID_PROPERTY)
		.field(District.NAME_PROPERTY)
		;
	/** 用于District的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDistrictSecondaryListItemScope() {
		return DistrictBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserDomainBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSecondaryListItemScope() {
		return UserDomainBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSecondaryListItemScope() {
		return UserWhiteListBaseSecondaryListItemScope;
	}

	protected static SerializeScope SecUserBaseSecondaryListItemScope = SerializeScope.INCLUDE()
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
		;
	/** 用于SecUser的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserSecondaryListItemScope() {
		return SecUserBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserAppBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppSecondaryListItemScope() {
		return UserAppBaseSecondaryListItemScope;
	}

	protected static SerializeScope QuickLinkBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSecondaryListItemScope() {
		return QuickLinkBaseSecondaryListItemScope;
	}

	protected static SerializeScope ListAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessSecondaryListItemScope() {
		return ListAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope ObjectAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
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
		;
	/** 用于ObjectAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessSecondaryListItemScope() {
		return ObjectAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySecondaryListItemScope() {
		return LoginHistoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope GenericFormBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		;
	/** 用于GenericForm的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGenericFormSecondaryListItemScope() {
		return GenericFormBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormMessageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormMessageSecondaryListItemScope() {
		return FormMessageBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormFieldMessageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageSecondaryListItemScope() {
		return FormFieldMessageBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormFieldBaseSecondaryListItemScope = SerializeScope.INCLUDE()
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
		;
	/** 用于FormField的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldSecondaryListItemScope() {
		return FormFieldBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormActionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		;
	/** 用于FormAction的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormActionSecondaryListItemScope() {
		return FormActionBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSecondaryListItemScope() {
		return CandidateContainerBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateElementBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSecondaryListItemScope() {
		return CandidateElementBaseSecondaryListItemScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifySecondaryListItemScope() {
		return WechatWorkappIdentifyBaseSecondaryListItemScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifySecondaryListItemScope() {
		return WechatMiniappIdentifyBaseSecondaryListItemScope;
	}

	protected static SerializeScope PlatformBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Platform.ID_PROPERTY)
		.field(Platform.NAME_PROPERTY)
		.field(Platform.FOUNDED_PROPERTY)
		.field(Platform.LEAVE_RECORD_LIST, getLeaveRecordSecondaryListItemScope())
		.field(Platform.PROVINCE_LIST, getProvinceSecondaryListItemScope())
		.field(Platform.CITY_LIST, getCitySecondaryListItemScope())
		.field(Platform.DISTRICT_LIST, getDistrictSecondaryListItemScope())
		;
	/** 用于Platform对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPlatformListItemScope() {
		return PlatformBaseListItemScope;
	}

	protected static SerializeScope UserBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(User.ID_PROPERTY)
		.field(User.NAME_PROPERTY)
		.field(User.MOBILE_PROPERTY)
		.field(User.AVATAR_PROPERTY)
		.field(User.AGE_PROPERTY)
		.field(User.DESCRIPTION_PROPERTY)
		.field(User.DISTRICT_PROPERTY, getDistrictSummaryScope())
		.field(User.ROLE_PROPERTY, getRoleSummaryScope())
		.field(User.LEAVE_RECORD_LIST, getLeaveRecordSecondaryListItemScope())
		;
	/** 用于User对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserListItemScope() {
		return UserBaseListItemScope;
	}

	protected static SerializeScope RoleBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Role.ID_PROPERTY)
		.field(Role.NAME_PROPERTY)
		.field(Role.CODE_PROPERTY)
		.field(Role.USER_LIST, getUserSecondaryListItemScope())
		;
	/** 用于Role对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRoleListItemScope() {
		return RoleBaseListItemScope;
	}

	protected static SerializeScope LeaveRecordBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LeaveRecord.ID_PROPERTY)
		.field(LeaveRecord.USER_PROPERTY, getUserSummaryScope())
		.field(LeaveRecord.TYPE_PROPERTY, getLeaveRecordTypeSummaryScope())
		.field(LeaveRecord.FROMDATE_PROPERTY)
		.field(LeaveRecord.TODATE_PROPERTY)
		.field(LeaveRecord.PLATFORM_PROPERTY, getPlatformSummaryScope())
		;
	/** 用于LeaveRecord对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLeaveRecordListItemScope() {
		return LeaveRecordBaseListItemScope;
	}

	protected static SerializeScope LeaveRecordTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LeaveRecordType.ID_PROPERTY)
		.field(LeaveRecordType.NAME_PROPERTY)
		.field(LeaveRecordType.CODE_PROPERTY)
		.field(LeaveRecordType.LEAVE_RECORD_LIST, getLeaveRecordSecondaryListItemScope())
		.field(LeaveRecordType.HOLYDAY_SETTING_LIST, getHolydaySettingSecondaryListItemScope())
		;
	/** 用于LeaveRecordType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLeaveRecordTypeListItemScope() {
		return LeaveRecordTypeBaseListItemScope;
	}

	protected static SerializeScope HolydaySettingBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(HolydaySetting.ID_PROPERTY)
		.field(HolydaySetting.TYPE_PROPERTY, getLeaveRecordTypeSummaryScope())
		.field(HolydaySetting.LEAVE_DAYS_PROPERTY)
		;
	/** 用于HolydaySetting对象的列表时需要序列化的属性列表 */
	public static SerializeScope getHolydaySettingListItemScope() {
		return HolydaySettingBaseListItemScope;
	}

	protected static SerializeScope ProvinceBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Province.ID_PROPERTY)
		.field(Province.NAME_PROPERTY)
		.field(Province.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(Province.CITY_LIST, getCitySecondaryListItemScope())
		;
	/** 用于Province对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProvinceListItemScope() {
		return ProvinceBaseListItemScope;
	}

	protected static SerializeScope CityBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(City.ID_PROPERTY)
		.field(City.NAME_PROPERTY)
		.field(City.PROVINCE_PROPERTY, getProvinceSummaryScope())
		.field(City.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(City.DISTRICT_LIST, getDistrictSecondaryListItemScope())
		;
	/** 用于City对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityListItemScope() {
		return CityBaseListItemScope;
	}

	protected static SerializeScope DistrictBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(District.ID_PROPERTY)
		.field(District.NAME_PROPERTY)
		.field(District.CITY_PROPERTY, getCitySummaryScope())
		.field(District.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(District.USER_LIST, getUserSecondaryListItemScope())
		;
	/** 用于District对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDistrictListItemScope() {
		return DistrictBaseListItemScope;
	}

	protected static SerializeScope UserDomainBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListSecondaryListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserSecondaryListItemScope())
		;
	/** 用于UserDomain对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainListItemScope() {
		return UserDomainBaseListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListListItemScope() {
		return UserWhiteListBaseListItemScope;
	}

	protected static SerializeScope SecUserBaseListItemScope = SerializeScope.INCLUDE()
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
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.USER_APP_LIST, getUserAppSecondaryListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistorySecondaryListItemScope())
		.field(SecUser.WECHAT_WORKAPP_IDENTIFY_LIST, getWechatWorkappIdentifySecondaryListItemScope())
		.field(SecUser.WECHAT_MINIAPP_IDENTIFY_LIST, getWechatMiniappIdentifySecondaryListItemScope())
		;
	/** 用于SecUser对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserListItemScope() {
		return SecUserBaseListItemScope;
	}

	protected static SerializeScope UserAppBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkSecondaryListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessSecondaryListItemScope())
		.field(UserApp.OBJECT_ACCESS_LIST, getObjectAccessSecondaryListItemScope())
		;
	/** 用于UserApp对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppListItemScope() {
		return UserAppBaseListItemScope;
	}

	protected static SerializeScope QuickLinkBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkListItemScope() {
		return QuickLinkBaseListItemScope;
	}

	protected static SerializeScope ListAccessBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessListItemScope() {
		return ListAccessBaseListItemScope;
	}

	protected static SerializeScope ObjectAccessBaseListItemScope = SerializeScope.INCLUDE()
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
		.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ObjectAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessListItemScope() {
		return ObjectAccessBaseListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryListItemScope() {
		return LoginHistoryBaseListItemScope;
	}

	protected static SerializeScope GenericFormBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		.field(GenericForm.FORM_MESSAGE_LIST, getFormMessageSecondaryListItemScope())
		.field(GenericForm.FORM_FIELD_MESSAGE_LIST, getFormFieldMessageSecondaryListItemScope())
		.field(GenericForm.FORM_FIELD_LIST, getFormFieldSecondaryListItemScope())
		.field(GenericForm.FORM_ACTION_LIST, getFormActionSecondaryListItemScope())
		;
	/** 用于GenericForm对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGenericFormListItemScope() {
		return GenericFormBaseListItemScope;
	}

	protected static SerializeScope FormMessageBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormMessageListItemScope() {
		return FormMessageBaseListItemScope;
	}

	protected static SerializeScope FormFieldMessageBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageListItemScope() {
		return FormFieldMessageBaseListItemScope;
	}

	protected static SerializeScope FormFieldBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
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
		;
	/** 用于FormField对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldListItemScope() {
		return FormFieldBaseListItemScope;
	}

	protected static SerializeScope FormActionBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
		;
	/** 用于FormAction对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormActionListItemScope() {
		return FormActionBaseListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementSecondaryListItemScope())
		;
	/** 用于CandidateContainer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerListItemScope() {
		return CandidateContainerBaseListItemScope;
	}

	protected static SerializeScope CandidateElementBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementListItemScope() {
		return CandidateElementBaseListItemScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifyListItemScope() {
		return WechatWorkappIdentifyBaseListItemScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseListItemScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifyListItemScope() {
		return WechatMiniappIdentifyBaseListItemScope;
	}

	protected static SerializeScope PlatformBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Platform.ID_PROPERTY)
		.field(Platform.NAME_PROPERTY)
		.field(Platform.FOUNDED_PROPERTY)
		.field(Platform.LEAVE_RECORD_LIST, getLeaveRecordListItemScope())
		.field(Platform.PROVINCE_LIST, getProvinceListItemScope())
		.field(Platform.CITY_LIST, getCityListItemScope())
		.field(Platform.DISTRICT_LIST, getDistrictListItemScope())
		;
	/** 用于Platform对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPlatformDetailScope() {
		return PlatformBaseDetailScope;
	}

	protected static SerializeScope UserBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(User.ID_PROPERTY)
		.field(User.NAME_PROPERTY)
		.field(User.MOBILE_PROPERTY)
		.field(User.AVATAR_PROPERTY)
		.field(User.AGE_PROPERTY)
		.field(User.DESCRIPTION_PROPERTY)
		.field(User.DISTRICT_PROPERTY, getDistrictSummaryScope())
		.field(User.ROLE_PROPERTY, getRoleSummaryScope())
		.field(User.LEAVE_RECORD_LIST, getLeaveRecordListItemScope())
		;
	/** 用于User对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDetailScope() {
		return UserBaseDetailScope;
	}

	protected static SerializeScope RoleBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Role.ID_PROPERTY)
		.field(Role.NAME_PROPERTY)
		.field(Role.CODE_PROPERTY)
		.field(Role.USER_LIST, getUserListItemScope())
		;
	/** 用于Role对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRoleDetailScope() {
		return RoleBaseDetailScope;
	}

	protected static SerializeScope LeaveRecordBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LeaveRecord.ID_PROPERTY)
		.field(LeaveRecord.USER_PROPERTY, getUserSummaryScope())
		.field(LeaveRecord.TYPE_PROPERTY, getLeaveRecordTypeSummaryScope())
		.field(LeaveRecord.FROMDATE_PROPERTY)
		.field(LeaveRecord.TODATE_PROPERTY)
		.field(LeaveRecord.PLATFORM_PROPERTY, getPlatformSummaryScope())
		;
	/** 用于LeaveRecord对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLeaveRecordDetailScope() {
		return LeaveRecordBaseDetailScope;
	}

	protected static SerializeScope LeaveRecordTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LeaveRecordType.ID_PROPERTY)
		.field(LeaveRecordType.NAME_PROPERTY)
		.field(LeaveRecordType.CODE_PROPERTY)
		.field(LeaveRecordType.LEAVE_RECORD_LIST, getLeaveRecordListItemScope())
		.field(LeaveRecordType.HOLYDAY_SETTING_LIST, getHolydaySettingListItemScope())
		;
	/** 用于LeaveRecordType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLeaveRecordTypeDetailScope() {
		return LeaveRecordTypeBaseDetailScope;
	}

	protected static SerializeScope HolydaySettingBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(HolydaySetting.ID_PROPERTY)
		.field(HolydaySetting.TYPE_PROPERTY, getLeaveRecordTypeSummaryScope())
		.field(HolydaySetting.LEAVE_DAYS_PROPERTY)
		;
	/** 用于HolydaySetting对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getHolydaySettingDetailScope() {
		return HolydaySettingBaseDetailScope;
	}

	protected static SerializeScope ProvinceBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(Province.ID_PROPERTY)
		.field(Province.NAME_PROPERTY)
		.field(Province.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(Province.CITY_LIST, getCityListItemScope())
		;
	/** 用于Province对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProvinceDetailScope() {
		return ProvinceBaseDetailScope;
	}

	protected static SerializeScope CityBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(City.ID_PROPERTY)
		.field(City.NAME_PROPERTY)
		.field(City.PROVINCE_PROPERTY, getProvinceSummaryScope())
		.field(City.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(City.DISTRICT_LIST, getDistrictListItemScope())
		;
	/** 用于City对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityDetailScope() {
		return CityBaseDetailScope;
	}

	protected static SerializeScope DistrictBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(District.ID_PROPERTY)
		.field(District.NAME_PROPERTY)
		.field(District.CITY_PROPERTY, getCitySummaryScope())
		.field(District.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(District.USER_LIST, getUserListItemScope())
		;
	/** 用于District对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDistrictDetailScope() {
		return DistrictBaseDetailScope;
	}

	protected static SerializeScope UserDomainBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserListItemScope())
		;
	/** 用于UserDomain对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainDetailScope() {
		return UserDomainBaseDetailScope;
	}

	protected static SerializeScope UserWhiteListBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListDetailScope() {
		return UserWhiteListBaseDetailScope;
	}

	protected static SerializeScope SecUserBaseDetailScope = SerializeScope.INCLUDE()
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
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.USER_APP_LIST, getUserAppListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistoryListItemScope())
		.field(SecUser.WECHAT_WORKAPP_IDENTIFY_LIST, getWechatWorkappIdentifyListItemScope())
		.field(SecUser.WECHAT_MINIAPP_IDENTIFY_LIST, getWechatMiniappIdentifyListItemScope())
		;
	/** 用于SecUser对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserDetailScope() {
		return SecUserBaseDetailScope;
	}

	protected static SerializeScope UserAppBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessListItemScope())
		.field(UserApp.OBJECT_ACCESS_LIST, getObjectAccessListItemScope())
		;
	/** 用于UserApp对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppDetailScope() {
		return UserAppBaseDetailScope;
	}

	protected static SerializeScope QuickLinkBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkDetailScope() {
		return QuickLinkBaseDetailScope;
	}

	protected static SerializeScope ListAccessBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessDetailScope() {
		return ListAccessBaseDetailScope;
	}

	protected static SerializeScope ObjectAccessBaseDetailScope = SerializeScope.INCLUDE()
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
		.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ObjectAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessDetailScope() {
		return ObjectAccessBaseDetailScope;
	}

	protected static SerializeScope LoginHistoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryDetailScope() {
		return LoginHistoryBaseDetailScope;
	}

	protected static SerializeScope GenericFormBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		.field(GenericForm.FORM_MESSAGE_LIST, getFormMessageListItemScope())
		.field(GenericForm.FORM_FIELD_MESSAGE_LIST, getFormFieldMessageListItemScope())
		.field(GenericForm.FORM_FIELD_LIST, getFormFieldListItemScope())
		.field(GenericForm.FORM_ACTION_LIST, getFormActionListItemScope())
		;
	/** 用于GenericForm对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGenericFormDetailScope() {
		return GenericFormBaseDetailScope;
	}

	protected static SerializeScope FormMessageBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormMessageDetailScope() {
		return FormMessageBaseDetailScope;
	}

	protected static SerializeScope FormFieldMessageBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageDetailScope() {
		return FormFieldMessageBaseDetailScope;
	}

	protected static SerializeScope FormFieldBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
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
		;
	/** 用于FormField对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldDetailScope() {
		return FormFieldBaseDetailScope;
	}

	protected static SerializeScope FormActionBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
		;
	/** 用于FormAction对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormActionDetailScope() {
		return FormActionBaseDetailScope;
	}

	protected static SerializeScope CandidateContainerBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementListItemScope())
		;
	/** 用于CandidateContainer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerDetailScope() {
		return CandidateContainerBaseDetailScope;
	}

	protected static SerializeScope CandidateElementBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementDetailScope() {
		return CandidateElementBaseDetailScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifyDetailScope() {
		return WechatWorkappIdentifyBaseDetailScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseDetailScope = SerializeScope.INCLUDE()
		.field(FlowableBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifyDetailScope() {
		return WechatMiniappIdentifyBaseDetailScope;
	}

	

}








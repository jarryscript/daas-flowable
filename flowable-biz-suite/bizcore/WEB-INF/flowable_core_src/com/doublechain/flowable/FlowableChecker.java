
package com.doublechain.flowable;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class FlowableChecker extends BaseChecker{

	
	public FlowableChecker() {
		this.messageList = new ArrayList<Message>();
	}
	

	public static final String  ID_OF_PLATFORM ="platform.id";
	public FlowableChecker checkIdOfPlatform(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PLATFORM ="platform.name";
	public FlowableChecker checkNameOfPlatform(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PLATFORM ="platform.version";
	public FlowableChecker checkVersionOfPlatform(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER ="user.id";
	public FlowableChecker checkIdOfUser(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_USER ="user.name";
	public FlowableChecker checkNameOfUser(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_USER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_USER ="user.mobile";
	public FlowableChecker checkMobileOfUser(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_USER ); 		
		
		return this;
	}	

	public static final String  AVATAR_OF_USER ="user.avatar";
	public FlowableChecker checkAvatarOfUser(String avatar)
	{		
	 	checkStringLengthRange(avatar,2, 28,AVATAR_OF_USER ); 		
		
		return this;
	}	

	public static final String  AGE_OF_USER ="user.age";
	public FlowableChecker checkAgeOfUser(int age)
	{		
	 	checkIntegerRange(age,1, 100,AGE_OF_USER ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_USER ="user.description";
	public FlowableChecker checkDescriptionOfUser(String description)
	{		
	 	checkLongtext(description,0, 1048576,DESCRIPTION_OF_USER ); 		
		
		return this;
	}	

	public static final String  DISTRICT_OF_USER ="user.district";
	public FlowableChecker checkDistrictIdOfUser(String districtId)
	{		
	 	checkIdOfUser(districtId ); 		
		
		return this;
	}	

	public static final String  ROLE_OF_USER ="user.role";
	public FlowableChecker checkRoleIdOfUser(String roleId)
	{		
	 	checkIdOfUser(roleId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER ="user.version";
	public FlowableChecker checkVersionOfUser(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER ); 		
		
		return this;
	}	

	public static final String  ID_OF_ROLE ="role.id";
	public FlowableChecker checkIdOfRole(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ROLE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_ROLE ="role.name";
	public FlowableChecker checkNameOfRole(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_ROLE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_ROLE ="role.code";
	public FlowableChecker checkCodeOfRole(String code)
	{		
	 	checkStringLengthRange(code,2, 32,CODE_OF_ROLE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ROLE ="role.version";
	public FlowableChecker checkVersionOfRole(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ROLE ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEAVE_RECORD ="leave_record.id";
	public FlowableChecker checkIdOfLeaveRecord(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEAVE_RECORD ); 		
		
		return this;
	}	

	public static final String  USER_OF_LEAVE_RECORD ="leave_record.user";
	public FlowableChecker checkUserIdOfLeaveRecord(String userId)
	{		
	 	checkIdOfLeaveRecord(userId ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_LEAVE_RECORD ="leave_record.type";
	public FlowableChecker checkTypeIdOfLeaveRecord(String typeId)
	{		
	 	checkIdOfLeaveRecord(typeId ); 		
		
		return this;
	}	

	public static final String  FROMDATE_OF_LEAVE_RECORD ="leave_record.fromdate";
	public FlowableChecker checkFromdateOfLeaveRecord(Date fromdate)
	{		
	 	checkDateRange(fromdate,parseDate("1900-01-01"), parseDate("2020-02-02"),FROMDATE_OF_LEAVE_RECORD ); 		
		
		return this;
	}	

	public static final String  TODATE_OF_LEAVE_RECORD ="leave_record.todate";
	public FlowableChecker checkTodateOfLeaveRecord(Date todate)
	{		
	 	checkDateRange(todate,parseDate("1900-01-01"), parseDate("2020-02-04"),TODATE_OF_LEAVE_RECORD ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_LEAVE_RECORD ="leave_record.platform";
	public FlowableChecker checkPlatformIdOfLeaveRecord(String platformId)
	{		
	 	checkIdOfLeaveRecord(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEAVE_RECORD ="leave_record.version";
	public FlowableChecker checkVersionOfLeaveRecord(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEAVE_RECORD ); 		
		
		return this;
	}	

	public static final String  ID_OF_LEAVE_RECORD_TYPE ="leave_record_type.id";
	public FlowableChecker checkIdOfLeaveRecordType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LEAVE_RECORD_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LEAVE_RECORD_TYPE ="leave_record_type.name";
	public FlowableChecker checkNameOfLeaveRecordType(String name)
	{		
	 	checkStringLengthRange(name,1, 8,NAME_OF_LEAVE_RECORD_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_LEAVE_RECORD_TYPE ="leave_record_type.code";
	public FlowableChecker checkCodeOfLeaveRecordType(String code)
	{		
	 	checkStringLengthRange(code,5, 64,CODE_OF_LEAVE_RECORD_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LEAVE_RECORD_TYPE ="leave_record_type.version";
	public FlowableChecker checkVersionOfLeaveRecordType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEAVE_RECORD_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_HOLYDAY_SETTING ="holyday_setting.id";
	public FlowableChecker checkIdOfHolydaySetting(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_HOLYDAY_SETTING ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_HOLYDAY_SETTING ="holyday_setting.type";
	public FlowableChecker checkTypeIdOfHolydaySetting(String typeId)
	{		
	 	checkIdOfHolydaySetting(typeId ); 		
		
		return this;
	}	

	public static final String  LEAVE_DAYS_OF_HOLYDAY_SETTING ="holyday_setting.leave_days";
	public FlowableChecker checkLeaveDaysOfHolydaySetting(int leaveDays)
	{		
	 	checkIntegerRange(leaveDays,0, 100,LEAVE_DAYS_OF_HOLYDAY_SETTING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_HOLYDAY_SETTING ="holyday_setting.version";
	public FlowableChecker checkVersionOfHolydaySetting(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_HOLYDAY_SETTING ); 		
		
		return this;
	}	

	public static final String  ID_OF_PROVINCE ="province.id";
	public FlowableChecker checkIdOfProvince(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PROVINCE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PROVINCE ="province.name";
	public FlowableChecker checkNameOfProvince(String name)
	{		
	 	checkStringLengthRange(name,1, 120,NAME_OF_PROVINCE ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_PROVINCE ="province.platform";
	public FlowableChecker checkPlatformIdOfProvince(String platformId)
	{		
	 	checkIdOfProvince(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PROVINCE ="province.version";
	public FlowableChecker checkVersionOfProvince(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROVINCE ); 		
		
		return this;
	}	

	public static final String  ID_OF_CITY ="city.id";
	public FlowableChecker checkIdOfCity(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CITY ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CITY ="city.name";
	public FlowableChecker checkNameOfCity(String name)
	{		
	 	checkStringLengthRange(name,1, 120,NAME_OF_CITY ); 		
		
		return this;
	}	

	public static final String  PROVINCE_OF_CITY ="city.province";
	public FlowableChecker checkProvinceIdOfCity(String provinceId)
	{		
	 	checkIdOfCity(provinceId ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_CITY ="city.platform";
	public FlowableChecker checkPlatformIdOfCity(String platformId)
	{		
	 	checkIdOfCity(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CITY ="city.version";
	public FlowableChecker checkVersionOfCity(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY ); 		
		
		return this;
	}	

	public static final String  ID_OF_DISTRICT ="district.id";
	public FlowableChecker checkIdOfDistrict(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_DISTRICT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_DISTRICT ="district.name";
	public FlowableChecker checkNameOfDistrict(String name)
	{		
	 	checkStringLengthRange(name,1, 120,NAME_OF_DISTRICT ); 		
		
		return this;
	}	

	public static final String  CITY_OF_DISTRICT ="district.city";
	public FlowableChecker checkCityIdOfDistrict(String cityId)
	{		
	 	checkIdOfDistrict(cityId ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_DISTRICT ="district.platform";
	public FlowableChecker checkPlatformIdOfDistrict(String platformId)
	{		
	 	checkIdOfDistrict(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_DISTRICT ="district.version";
	public FlowableChecker checkVersionOfDistrict(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_DISTRICT ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public FlowableChecker checkIdOfUserDomain(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public FlowableChecker checkNameOfUserDomain(String name)
	{		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public FlowableChecker checkVersionOfUserDomain(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public FlowableChecker checkIdOfUserWhiteList(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public FlowableChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public FlowableChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public FlowableChecker checkDomainIdOfUserWhiteList(String domainId)
	{		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public FlowableChecker checkVersionOfUserWhiteList(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public FlowableChecker checkIdOfSecUser(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public FlowableChecker checkLoginOfSecUser(String login)
	{		
	 	checkStringLengthRange(login,0, 256,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public FlowableChecker checkMobileOfSecUser(String mobile)
	{		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public FlowableChecker checkEmailOfSecUser(String email)
	{		
	 	checkEmail(email,0, 256,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public FlowableChecker checkPwdOfSecUser(String pwd)
	{		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_OPENID_OF_SEC_USER ="sec_user.weixin_openid";
	public FlowableChecker checkWeixinOpenidOfSecUser(String weixinOpenid)
	{		
	 	checkStringLengthRange(weixinOpenid,0, 128,WEIXIN_OPENID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_APPID_OF_SEC_USER ="sec_user.weixin_appid";
	public FlowableChecker checkWeixinAppidOfSecUser(String weixinAppid)
	{		
	 	checkStringLengthRange(weixinAppid,0, 128,WEIXIN_APPID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ACCESS_TOKEN_OF_SEC_USER ="sec_user.access_token";
	public FlowableChecker checkAccessTokenOfSecUser(String accessToken)
	{		
	 	checkStringLengthRange(accessToken,0, 128,ACCESS_TOKEN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public FlowableChecker checkVerificationCodeOfSecUser(int verificationCode)
	{		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public FlowableChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public FlowableChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public FlowableChecker checkDomainIdOfSecUser(String domainId)
	{		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public FlowableChecker checkVersionOfSecUser(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_APP ="user_app.id";
	public FlowableChecker checkIdOfUserApp(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public FlowableChecker checkTitleOfUserApp(String title)
	{		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public FlowableChecker checkSecUserIdOfUserApp(String secUserId)
	{		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public FlowableChecker checkAppIconOfUserApp(String appIcon)
	{		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public FlowableChecker checkFullAccessOfUserApp(boolean fullAccess)
	{		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public FlowableChecker checkPermissionOfUserApp(String permission)
	{		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public FlowableChecker checkObjectTypeOfUserApp(String objectType)
	{		
	 	checkStringLengthRange(objectType,1, 100,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public FlowableChecker checkObjectIdOfUserApp(String objectId)
	{		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public FlowableChecker checkLocationOfUserApp(String location)
	{		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public FlowableChecker checkVersionOfUserApp(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  ID_OF_QUICK_LINK ="quick_link.id";
	public FlowableChecker checkIdOfQuickLink(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_QUICK_LINK ="quick_link.name";
	public FlowableChecker checkNameOfQuickLink(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ICON_OF_QUICK_LINK ="quick_link.icon";
	public FlowableChecker checkIconOfQuickLink(String icon)
	{		
	 	checkStringLengthRange(icon,1, 200,ICON_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  IMAGE_PATH_OF_QUICK_LINK ="quick_link.image_path";
	public FlowableChecker checkImagePathOfQuickLink(String imagePath)
	{		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  LINK_TARGET_OF_QUICK_LINK ="quick_link.link_target";
	public FlowableChecker checkLinkTargetOfQuickLink(String linkTarget)
	{		
	 	checkStringLengthRange(linkTarget,1, 200,LINK_TARGET_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  APP_OF_QUICK_LINK ="quick_link.app";
	public FlowableChecker checkAppIdOfQuickLink(String appId)
	{		
	 	checkIdOfQuickLink(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_QUICK_LINK ="quick_link.version";
	public FlowableChecker checkVersionOfQuickLink(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public FlowableChecker checkIdOfListAccess(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public FlowableChecker checkNameOfListAccess(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public FlowableChecker checkInternalNameOfListAccess(String internalName)
	{		
	 	checkStringLengthRange(internalName,1, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public FlowableChecker checkReadPermissionOfListAccess(boolean readPermission)
	{		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public FlowableChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public FlowableChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public FlowableChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public FlowableChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public FlowableChecker checkAppIdOfListAccess(String appId)
	{		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public FlowableChecker checkVersionOfListAccess(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public FlowableChecker checkIdOfObjectAccess(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public FlowableChecker checkNameOfObjectAccess(String name)
	{		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public FlowableChecker checkObjectTypeOfObjectAccess(String objectType)
	{		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public FlowableChecker checkList1OfObjectAccess(String list1)
	{		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public FlowableChecker checkList2OfObjectAccess(String list2)
	{		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public FlowableChecker checkList3OfObjectAccess(String list3)
	{		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public FlowableChecker checkList4OfObjectAccess(String list4)
	{		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public FlowableChecker checkList5OfObjectAccess(String list5)
	{		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public FlowableChecker checkList6OfObjectAccess(String list6)
	{		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public FlowableChecker checkList7OfObjectAccess(String list7)
	{		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public FlowableChecker checkList8OfObjectAccess(String list8)
	{		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public FlowableChecker checkList9OfObjectAccess(String list9)
	{		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public FlowableChecker checkAppIdOfObjectAccess(String appId)
	{		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public FlowableChecker checkVersionOfObjectAccess(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public FlowableChecker checkIdOfLoginHistory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public FlowableChecker checkFromIpOfLoginHistory(String fromIp)
	{		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public FlowableChecker checkDescriptionOfLoginHistory(String description)
	{		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public FlowableChecker checkSecUserIdOfLoginHistory(String secUserId)
	{		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public FlowableChecker checkVersionOfLoginHistory(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public FlowableChecker checkIdOfGenericForm(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public FlowableChecker checkTitleOfGenericForm(String title)
	{		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public FlowableChecker checkDescriptionOfGenericForm(String description)
	{		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public FlowableChecker checkVersionOfGenericForm(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public FlowableChecker checkIdOfFormMessage(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public FlowableChecker checkTitleOfFormMessage(String title)
	{		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public FlowableChecker checkFormIdOfFormMessage(String formId)
	{		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public FlowableChecker checkLevelOfFormMessage(String level)
	{		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public FlowableChecker checkVersionOfFormMessage(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public FlowableChecker checkIdOfFormFieldMessage(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public FlowableChecker checkTitleOfFormFieldMessage(String title)
	{		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public FlowableChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public FlowableChecker checkFormIdOfFormFieldMessage(String formId)
	{		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public FlowableChecker checkLevelOfFormFieldMessage(String level)
	{		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public FlowableChecker checkVersionOfFormFieldMessage(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public FlowableChecker checkIdOfFormField(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public FlowableChecker checkLabelOfFormField(String label)
	{		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public FlowableChecker checkLocaleKeyOfFormField(String localeKey)
	{		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public FlowableChecker checkParameterNameOfFormField(String parameterName)
	{		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public FlowableChecker checkTypeOfFormField(String type)
	{		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public FlowableChecker checkFormIdOfFormField(String formId)
	{		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public FlowableChecker checkPlaceholderOfFormField(String placeholder)
	{		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public FlowableChecker checkDefaultValueOfFormField(String defaultValue)
	{		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public FlowableChecker checkDescriptionOfFormField(String description)
	{		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public FlowableChecker checkFieldGroupOfFormField(String fieldGroup)
	{		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public FlowableChecker checkMinimumValueOfFormField(String minimumValue)
	{		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public FlowableChecker checkMaximumValueOfFormField(String maximumValue)
	{		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public FlowableChecker checkRequiredOfFormField(boolean required)
	{		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public FlowableChecker checkDisabledOfFormField(boolean disabled)
	{		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public FlowableChecker checkCustomRenderingOfFormField(boolean customRendering)
	{		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public FlowableChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		if(candidateValues == null) {
			return this;
		}
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public FlowableChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		if(suggestValues == null) {
			return this;
		}
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public FlowableChecker checkVersionOfFormField(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public FlowableChecker checkIdOfFormAction(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public FlowableChecker checkLabelOfFormAction(String label)
	{		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public FlowableChecker checkLocaleKeyOfFormAction(String localeKey)
	{		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public FlowableChecker checkActionKeyOfFormAction(String actionKey)
	{		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public FlowableChecker checkLevelOfFormAction(String level)
	{		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public FlowableChecker checkUrlOfFormAction(String url)
	{		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public FlowableChecker checkFormIdOfFormAction(String formId)
	{		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public FlowableChecker checkVersionOfFormAction(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_CONTAINER ="candidate_container.id";
	public FlowableChecker checkIdOfCandidateContainer(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_CONTAINER ="candidate_container.name";
	public FlowableChecker checkNameOfCandidateContainer(String name)
	{		
	 	checkStringLengthRange(name,2, 28,NAME_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_CONTAINER ="candidate_container.version";
	public FlowableChecker checkVersionOfCandidateContainer(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_ELEMENT ="candidate_element.id";
	public FlowableChecker checkIdOfCandidateElement(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_ELEMENT ="candidate_element.name";
	public FlowableChecker checkNameOfCandidateElement(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_CANDIDATE_ELEMENT ="candidate_element.type";
	public FlowableChecker checkTypeOfCandidateElement(String type)
	{		
	 	checkStringLengthRange(type,1, 200,TYPE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  IMAGE_OF_CANDIDATE_ELEMENT ="candidate_element.image";
	public FlowableChecker checkImageOfCandidateElement(String image)
	{		
	 	checkImage(image,0, 512,IMAGE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  CONTAINER_OF_CANDIDATE_ELEMENT ="candidate_element.container";
	public FlowableChecker checkContainerIdOfCandidateElement(String containerId)
	{		
	 	checkIdOfCandidateElement(containerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_ELEMENT ="candidate_element.version";
	public FlowableChecker checkVersionOfCandidateElement(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.id";
	public FlowableChecker checkIdOfWechatWorkappIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  CORP_ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.corp_id";
	public FlowableChecker checkCorpIdOfWechatWorkappIdentify(String corpId)
	{		
	 	checkStringLengthRange(corpId,0, 100,CORP_ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  USER_ID_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.user_id";
	public FlowableChecker checkUserIdOfWechatWorkappIdentify(String userId)
	{		
	 	checkStringLengthRange(userId,1, 100,USER_ID_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.sec_user";
	public FlowableChecker checkSecUserIdOfWechatWorkappIdentify(String secUserId)
	{		
	 	checkIdOfWechatWorkappIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.last_login_time";
	public FlowableChecker checkLastLoginTimeOfWechatWorkappIdentify(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_WORKAPP_IDENTIFY ="wechat_workapp_identify.version";
	public FlowableChecker checkVersionOfWechatWorkappIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_WORKAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.id";
	public FlowableChecker checkIdOfWechatMiniappIdentify(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  OPEN_ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.open_id";
	public FlowableChecker checkOpenIdOfWechatMiniappIdentify(String openId)
	{		
	 	checkStringLengthRange(openId,5, 128,OPEN_ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  APP_ID_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.app_id";
	public FlowableChecker checkAppIdOfWechatMiniappIdentify(String appId)
	{		
	 	checkStringLengthRange(appId,5, 128,APP_ID_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.sec_user";
	public FlowableChecker checkSecUserIdOfWechatMiniappIdentify(String secUserId)
	{		
	 	checkIdOfWechatMiniappIdentify(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.last_login_time";
	public FlowableChecker checkLastLoginTimeOfWechatMiniappIdentify(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_MINIAPP_IDENTIFY ="wechat_miniapp_identify.version";
	public FlowableChecker checkVersionOfWechatMiniappIdentify(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_MINIAPP_IDENTIFY ); 		
		
		return this;
	}	
}











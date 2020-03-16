package com.doublechain.flowable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class FlowableObjectChecker extends FlowableChecker{

	Set<BaseEntity> checkedObjectSet;
	
	protected void markAsChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			checkedObjectSet =  new HashSet<BaseEntity>();
		}
		checkedObjectSet.add(baseEntity);
		
		
	}
	
	protected boolean isChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			return false;
			
		}
		return checkedObjectSet.contains(baseEntity);
	}
	@FunctionalInterface
	public interface CheckerParameterFunction<P1> {
		FlowableChecker apply(P1 valueToCheck);
	}
	@FunctionalInterface
	public interface AssignParameterFunction {
		FlowableObjectChecker apply(BaseEntity targetEntity);
	}
	
	protected boolean isReferenceObject(BaseEntity target) {
		
		if(target.getId()==null) {
			return false;
		}
		if(target.getId().isEmpty()) {
			return false;
		}
		if(target.getVersion() > 0) {
			return false;
		}
		
		return true;
		
	}
	protected boolean isObjectForCreate(BaseEntity target) {
		if(target.getVersion() > 0) {
			return false;
		}
		if(target.getId()==null) {
			return true;
		}
		if(!target.getId().isEmpty()) {
			return false;
		}
		
		
		return true;
		
	}
	protected void setEntityProperty(BaseEntity targetEntity, String property, Object value) {
		if(!targetEntity.isChanged()) {
			return;
		}
		try {
			targetEntity.setPropertyOf(property, value);
		} catch (Exception e) {
			throw new IllegalArgumentException(concat("set property <",property,"> with value ",value.toString()," of ",targetEntity.toString()," failed"));
		}
		
	}
	
	public <T> FlowableObjectChecker commonObjectPropertyAssign(BaseEntity target, String propertyName, AssignParameterFunction assigmentFunction) {
		assigmentFunction.apply(target);
		return this;
	}
	public <T> FlowableObjectChecker commonObjectPropertyCheck(BaseEntity target, String propertyName, CheckerParameterFunction<T> checkerFunction) {
		
		
		if(!target.isChanged()) {
			return this;
		}
		
		if(isReferenceObject(target)&&!propertyName.equals("id")) {
			//this is an object reference, so all other properties except id check will be ignored
			//id will be checked in this case
			return this; //with an Id, but version is 0 regard as refencer
		}
		if(isObjectForCreate(target)&&propertyName.equals("id")) {
			// ignore check id for new object to create
			return this;
		}
		pushPosition(propertyName);
		T valueToCheck=(T)target.propertyOf(propertyName);
		checkerFunction.apply(valueToCheck);
		popPosition();
		
		return this;
	}
	public  FlowableChecker commonObjectElementCheck(BaseEntity target, String propertyName, CheckerParameterFunction<BaseEntity> checkerFunction) {
		
		pushPosition(propertyName);
		checkerFunction.apply(target);
		popPosition();
		return this;
	}
	protected String wrapArrayIndex(int andIncrement) {
		return "["+andIncrement+"]";
	}
	protected String concat(String ...args) {
		
		return Arrays.asList(args).stream().collect(Collectors.joining(""));
		
	}
	// use like commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);

	public FlowableObjectChecker checkAndFixPlatform(BaseEntity platformAsBaseEntity){

		if( isChecked(platformAsBaseEntity) ){
			return this;
		}
		markAsChecked(platformAsBaseEntity);
		commonObjectPropertyCheck(platformAsBaseEntity,"id",this::checkIdOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"name",this::checkNameOfPlatform);
		commonObjectPropertyAssign(platformAsBaseEntity,"founded",this::assignFoundedOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"version",this::checkVersionOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"leaveRecordList",this::checkLeaveRecordListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"provinceList",this::checkProvinceListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"cityList",this::checkCityListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"districtList",this::checkDistrictListOfPlatform);
		return this;

	}

	public FlowableObjectChecker checkAndFixUser(BaseEntity userAsBaseEntity){

		if( isChecked(userAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAsBaseEntity);
		commonObjectPropertyCheck(userAsBaseEntity,"id",this::checkIdOfUser);
		commonObjectPropertyCheck(userAsBaseEntity,"name",this::checkNameOfUser);
		commonObjectPropertyCheck(userAsBaseEntity,"mobile",this::checkMobileOfUser);
		commonObjectPropertyCheck(userAsBaseEntity,"avatar",this::checkAvatarOfUser);
		commonObjectPropertyCheck(userAsBaseEntity,"age",this::checkAgeOfUser);
		commonObjectPropertyCheck(userAsBaseEntity,"description",this::checkDescriptionOfUser);
		commonObjectPropertyCheck(userAsBaseEntity,"district",this::checkDistrictOfUser);
		commonObjectPropertyCheck(userAsBaseEntity,"role",this::checkRoleOfUser);
		commonObjectPropertyCheck(userAsBaseEntity,"version",this::checkVersionOfUser);
		commonObjectPropertyCheck(userAsBaseEntity,"leaveRecordList",this::checkLeaveRecordListOfUser);
		return this;

	}

	public FlowableObjectChecker checkAndFixRole(BaseEntity roleAsBaseEntity){

		if( isChecked(roleAsBaseEntity) ){
			return this;
		}
		markAsChecked(roleAsBaseEntity);
		commonObjectPropertyCheck(roleAsBaseEntity,"id",this::checkIdOfRole);
		commonObjectPropertyCheck(roleAsBaseEntity,"name",this::checkNameOfRole);
		commonObjectPropertyCheck(roleAsBaseEntity,"code",this::checkCodeOfRole);
		commonObjectPropertyCheck(roleAsBaseEntity,"version",this::checkVersionOfRole);
		commonObjectPropertyCheck(roleAsBaseEntity,"userList",this::checkUserListOfRole);
		return this;

	}

	public FlowableObjectChecker checkAndFixLeaveRecord(BaseEntity leaveRecordAsBaseEntity){

		if( isChecked(leaveRecordAsBaseEntity) ){
			return this;
		}
		markAsChecked(leaveRecordAsBaseEntity);
		commonObjectPropertyCheck(leaveRecordAsBaseEntity,"id",this::checkIdOfLeaveRecord);
		commonObjectPropertyCheck(leaveRecordAsBaseEntity,"user",this::checkUserOfLeaveRecord);
		commonObjectPropertyCheck(leaveRecordAsBaseEntity,"type",this::checkTypeOfLeaveRecord);
		commonObjectPropertyCheck(leaveRecordAsBaseEntity,"fromdate",this::checkFromdateOfLeaveRecord);
		commonObjectPropertyCheck(leaveRecordAsBaseEntity,"todate",this::checkTodateOfLeaveRecord);
		commonObjectPropertyCheck(leaveRecordAsBaseEntity,"platform",this::checkPlatformOfLeaveRecord);
		commonObjectPropertyCheck(leaveRecordAsBaseEntity,"version",this::checkVersionOfLeaveRecord);
		return this;

	}

	public FlowableObjectChecker checkAndFixLeaveRecordType(BaseEntity leaveRecordTypeAsBaseEntity){

		if( isChecked(leaveRecordTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(leaveRecordTypeAsBaseEntity);
		commonObjectPropertyCheck(leaveRecordTypeAsBaseEntity,"id",this::checkIdOfLeaveRecordType);
		commonObjectPropertyCheck(leaveRecordTypeAsBaseEntity,"name",this::checkNameOfLeaveRecordType);
		commonObjectPropertyCheck(leaveRecordTypeAsBaseEntity,"code",this::checkCodeOfLeaveRecordType);
		commonObjectPropertyCheck(leaveRecordTypeAsBaseEntity,"version",this::checkVersionOfLeaveRecordType);
		commonObjectPropertyCheck(leaveRecordTypeAsBaseEntity,"leaveRecordList",this::checkLeaveRecordListOfLeaveRecordType);
		commonObjectPropertyCheck(leaveRecordTypeAsBaseEntity,"holydaySettingList",this::checkHolydaySettingListOfLeaveRecordType);
		return this;

	}

	public FlowableObjectChecker checkAndFixHolydaySetting(BaseEntity holydaySettingAsBaseEntity){

		if( isChecked(holydaySettingAsBaseEntity) ){
			return this;
		}
		markAsChecked(holydaySettingAsBaseEntity);
		commonObjectPropertyCheck(holydaySettingAsBaseEntity,"id",this::checkIdOfHolydaySetting);
		commonObjectPropertyCheck(holydaySettingAsBaseEntity,"type",this::checkTypeOfHolydaySetting);
		commonObjectPropertyCheck(holydaySettingAsBaseEntity,"leaveDays",this::checkLeaveDaysOfHolydaySetting);
		commonObjectPropertyCheck(holydaySettingAsBaseEntity,"version",this::checkVersionOfHolydaySetting);
		return this;

	}

	public FlowableObjectChecker checkAndFixProvince(BaseEntity provinceAsBaseEntity){

		if( isChecked(provinceAsBaseEntity) ){
			return this;
		}
		markAsChecked(provinceAsBaseEntity);
		commonObjectPropertyCheck(provinceAsBaseEntity,"id",this::checkIdOfProvince);
		commonObjectPropertyCheck(provinceAsBaseEntity,"name",this::checkNameOfProvince);
		commonObjectPropertyCheck(provinceAsBaseEntity,"platform",this::checkPlatformOfProvince);
		commonObjectPropertyCheck(provinceAsBaseEntity,"version",this::checkVersionOfProvince);
		commonObjectPropertyCheck(provinceAsBaseEntity,"cityList",this::checkCityListOfProvince);
		return this;

	}

	public FlowableObjectChecker checkAndFixCity(BaseEntity cityAsBaseEntity){

		if( isChecked(cityAsBaseEntity) ){
			return this;
		}
		markAsChecked(cityAsBaseEntity);
		commonObjectPropertyCheck(cityAsBaseEntity,"id",this::checkIdOfCity);
		commonObjectPropertyCheck(cityAsBaseEntity,"name",this::checkNameOfCity);
		commonObjectPropertyCheck(cityAsBaseEntity,"province",this::checkProvinceOfCity);
		commonObjectPropertyCheck(cityAsBaseEntity,"platform",this::checkPlatformOfCity);
		commonObjectPropertyCheck(cityAsBaseEntity,"version",this::checkVersionOfCity);
		commonObjectPropertyCheck(cityAsBaseEntity,"districtList",this::checkDistrictListOfCity);
		return this;

	}

	public FlowableObjectChecker checkAndFixDistrict(BaseEntity districtAsBaseEntity){

		if( isChecked(districtAsBaseEntity) ){
			return this;
		}
		markAsChecked(districtAsBaseEntity);
		commonObjectPropertyCheck(districtAsBaseEntity,"id",this::checkIdOfDistrict);
		commonObjectPropertyCheck(districtAsBaseEntity,"name",this::checkNameOfDistrict);
		commonObjectPropertyCheck(districtAsBaseEntity,"city",this::checkCityOfDistrict);
		commonObjectPropertyCheck(districtAsBaseEntity,"platform",this::checkPlatformOfDistrict);
		commonObjectPropertyCheck(districtAsBaseEntity,"version",this::checkVersionOfDistrict);
		commonObjectPropertyCheck(districtAsBaseEntity,"userList",this::checkUserListOfDistrict);
		return this;

	}

	public FlowableObjectChecker checkAndFixUserDomain(BaseEntity userDomainAsBaseEntity){

		if( isChecked(userDomainAsBaseEntity) ){
			return this;
		}
		markAsChecked(userDomainAsBaseEntity);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"id",this::checkIdOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"name",this::checkNameOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"version",this::checkVersionOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"userWhiteListList",this::checkUserWhiteListListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"secUserList",this::checkSecUserListOfUserDomain);
		return this;

	}

	public FlowableObjectChecker checkAndFixUserWhiteList(BaseEntity userWhiteListAsBaseEntity){

		if( isChecked(userWhiteListAsBaseEntity) ){
			return this;
		}
		markAsChecked(userWhiteListAsBaseEntity);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"id",this::checkIdOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userIdentity",this::checkUserIdentityOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userSpecialFunctions",this::checkUserSpecialFunctionsOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"domain",this::checkDomainOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"version",this::checkVersionOfUserWhiteList);
		return this;

	}

	public FlowableObjectChecker checkAndFixSecUser(BaseEntity secUserAsBaseEntity){

		if( isChecked(secUserAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserAsBaseEntity);
		commonObjectPropertyCheck(secUserAsBaseEntity,"id",this::checkIdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"login",this::checkLoginOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"mobile",this::checkMobileOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"email",this::checkEmailOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"pwd",this::checkPwdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinOpenid",this::checkWeixinOpenidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinAppid",this::checkWeixinAppidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"accessToken",this::checkAccessTokenOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCode",this::checkVerificationCodeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCodeExpire",this::checkVerificationCodeExpireOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"domain",this::checkDomainOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"version",this::checkVersionOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"userAppList",this::checkUserAppListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"loginHistoryList",this::checkLoginHistoryListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatWorkappIdentifyList",this::checkWechatWorkappIdentifyListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"wechatMiniappIdentifyList",this::checkWechatMiniappIdentifyListOfSecUser);
		return this;

	}

	public FlowableObjectChecker checkAndFixUserApp(BaseEntity userAppAsBaseEntity){

		if( isChecked(userAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAppAsBaseEntity);
		commonObjectPropertyCheck(userAppAsBaseEntity,"id",this::checkIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"title",this::checkTitleOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"secUser",this::checkSecUserOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appIcon",this::checkAppIconOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"fullAccess",this::checkFullAccessOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"permission",this::checkPermissionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectType",this::checkObjectTypeOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectId",this::checkObjectIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"location",this::checkLocationOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"version",this::checkVersionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"quickLinkList",this::checkQuickLinkListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"listAccessList",this::checkListAccessListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectAccessList",this::checkObjectAccessListOfUserApp);
		return this;

	}

	public FlowableObjectChecker checkAndFixQuickLink(BaseEntity quickLinkAsBaseEntity){

		if( isChecked(quickLinkAsBaseEntity) ){
			return this;
		}
		markAsChecked(quickLinkAsBaseEntity);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"id",this::checkIdOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"name",this::checkNameOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"icon",this::checkIconOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"imagePath",this::checkImagePathOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"linkTarget",this::checkLinkTargetOfQuickLink);
		commonObjectPropertyAssign(quickLinkAsBaseEntity,"createTime",this::assignCreateTimeOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"app",this::checkAppOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"version",this::checkVersionOfQuickLink);
		return this;

	}

	public FlowableObjectChecker checkAndFixListAccess(BaseEntity listAccessAsBaseEntity){

		if( isChecked(listAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(listAccessAsBaseEntity);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"id",this::checkIdOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"name",this::checkNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"internalName",this::checkInternalNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"readPermission",this::checkReadPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"createPermission",this::checkCreatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"deletePermission",this::checkDeletePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"updatePermission",this::checkUpdatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"executionPermission",this::checkExecutionPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"app",this::checkAppOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"version",this::checkVersionOfListAccess);
		return this;

	}

	public FlowableObjectChecker checkAndFixObjectAccess(BaseEntity objectAccessAsBaseEntity){

		if( isChecked(objectAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(objectAccessAsBaseEntity);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"id",this::checkIdOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"name",this::checkNameOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"objectType",this::checkObjectTypeOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list1",this::checkList1OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list2",this::checkList2OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list3",this::checkList3OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list4",this::checkList4OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list5",this::checkList5OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list6",this::checkList6OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list7",this::checkList7OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list8",this::checkList8OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list9",this::checkList9OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"app",this::checkAppOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"version",this::checkVersionOfObjectAccess);
		return this;

	}

	public FlowableObjectChecker checkAndFixLoginHistory(BaseEntity loginHistoryAsBaseEntity){

		if( isChecked(loginHistoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(loginHistoryAsBaseEntity);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"id",this::checkIdOfLoginHistory);
		commonObjectPropertyAssign(loginHistoryAsBaseEntity,"loginTime",this::assignLoginTimeOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"fromIp",this::checkFromIpOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"description",this::checkDescriptionOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"secUser",this::checkSecUserOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"version",this::checkVersionOfLoginHistory);
		return this;

	}

	public FlowableObjectChecker checkAndFixGenericForm(BaseEntity genericFormAsBaseEntity){

		if( isChecked(genericFormAsBaseEntity) ){
			return this;
		}
		markAsChecked(genericFormAsBaseEntity);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"id",this::checkIdOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"title",this::checkTitleOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"description",this::checkDescriptionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"version",this::checkVersionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formMessageList",this::checkFormMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldMessageList",this::checkFormFieldMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldList",this::checkFormFieldListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formActionList",this::checkFormActionListOfGenericForm);
		return this;

	}

	public FlowableObjectChecker checkAndFixFormMessage(BaseEntity formMessageAsBaseEntity){

		if( isChecked(formMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formMessageAsBaseEntity);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"id",this::checkIdOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"title",this::checkTitleOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"form",this::checkFormOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"level",this::checkLevelOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"version",this::checkVersionOfFormMessage);
		return this;

	}

	public FlowableObjectChecker checkAndFixFormFieldMessage(BaseEntity formFieldMessageAsBaseEntity){

		if( isChecked(formFieldMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldMessageAsBaseEntity);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"id",this::checkIdOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"title",this::checkTitleOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"parameterName",this::checkParameterNameOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"form",this::checkFormOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"level",this::checkLevelOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"version",this::checkVersionOfFormFieldMessage);
		return this;

	}

	public FlowableObjectChecker checkAndFixFormField(BaseEntity formFieldAsBaseEntity){

		if( isChecked(formFieldAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldAsBaseEntity);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"id",this::checkIdOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"label",this::checkLabelOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"parameterName",this::checkParameterNameOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"type",this::checkTypeOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"form",this::checkFormOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"placeholder",this::checkPlaceholderOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"defaultValue",this::checkDefaultValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"description",this::checkDescriptionOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"fieldGroup",this::checkFieldGroupOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"minimumValue",this::checkMinimumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"maximumValue",this::checkMaximumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"required",this::checkRequiredOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"disabled",this::checkDisabledOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"customRendering",this::checkCustomRenderingOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"candidateValues",this::checkCandidateValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"suggestValues",this::checkSuggestValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"version",this::checkVersionOfFormField);
		return this;

	}

	public FlowableObjectChecker checkAndFixFormAction(BaseEntity formActionAsBaseEntity){

		if( isChecked(formActionAsBaseEntity) ){
			return this;
		}
		markAsChecked(formActionAsBaseEntity);
		commonObjectPropertyCheck(formActionAsBaseEntity,"id",this::checkIdOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"label",this::checkLabelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"actionKey",this::checkActionKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"level",this::checkLevelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"url",this::checkUrlOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"form",this::checkFormOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"version",this::checkVersionOfFormAction);
		return this;

	}

	public FlowableObjectChecker checkAndFixCandidateContainer(BaseEntity candidateContainerAsBaseEntity){

		if( isChecked(candidateContainerAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateContainerAsBaseEntity);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"id",this::checkIdOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"name",this::checkNameOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"version",this::checkVersionOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"candidateElementList",this::checkCandidateElementListOfCandidateContainer);
		return this;

	}

	public FlowableObjectChecker checkAndFixCandidateElement(BaseEntity candidateElementAsBaseEntity){

		if( isChecked(candidateElementAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateElementAsBaseEntity);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"id",this::checkIdOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"name",this::checkNameOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"type",this::checkTypeOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"image",this::checkImageOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"container",this::checkContainerOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"version",this::checkVersionOfCandidateElement);
		return this;

	}

	public FlowableObjectChecker checkAndFixWechatWorkappIdentify(BaseEntity wechatWorkappIdentifyAsBaseEntity){

		if( isChecked(wechatWorkappIdentifyAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatWorkappIdentifyAsBaseEntity);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"id",this::checkIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"corpId",this::checkCorpIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"userId",this::checkUserIdOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"secUser",this::checkSecUserOfWechatWorkappIdentify);
		commonObjectPropertyAssign(wechatWorkappIdentifyAsBaseEntity,"createTime",this::assignCreateTimeOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatWorkappIdentify);
		commonObjectPropertyCheck(wechatWorkappIdentifyAsBaseEntity,"version",this::checkVersionOfWechatWorkappIdentify);
		return this;

	}

	public FlowableObjectChecker checkAndFixWechatMiniappIdentify(BaseEntity wechatMiniappIdentifyAsBaseEntity){

		if( isChecked(wechatMiniappIdentifyAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatMiniappIdentifyAsBaseEntity);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"id",this::checkIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"openId",this::checkOpenIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"appId",this::checkAppIdOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"secUser",this::checkSecUserOfWechatMiniappIdentify);
		commonObjectPropertyAssign(wechatMiniappIdentifyAsBaseEntity,"createTime",this::assignCreateTimeOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfWechatMiniappIdentify);
		commonObjectPropertyCheck(wechatMiniappIdentifyAsBaseEntity,"version",this::checkVersionOfWechatMiniappIdentify);
		return this;

	}


	public FlowableObjectChecker checkLeaveRecordListOfPlatform(List<BaseEntity> leaveRecordList){
		AtomicInteger index = new AtomicInteger();
		leaveRecordList.stream().forEach(leaveRecord->
			commonObjectElementCheck(leaveRecord,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLeaveRecord));
		return this;
	}

	public FlowableObjectChecker checkProvinceListOfPlatform(List<BaseEntity> provinceList){
		AtomicInteger index = new AtomicInteger();
		provinceList.stream().forEach(province->
			commonObjectElementCheck(province,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixProvince));
		return this;
	}

	public FlowableObjectChecker checkCityListOfPlatform(List<BaseEntity> cityList){
		AtomicInteger index = new AtomicInteger();
		cityList.stream().forEach(city->
			commonObjectElementCheck(city,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCity));
		return this;
	}

	public FlowableObjectChecker checkDistrictListOfPlatform(List<BaseEntity> districtList){
		AtomicInteger index = new AtomicInteger();
		districtList.stream().forEach(district->
			commonObjectElementCheck(district,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDistrict));
		return this;
	}

	public FlowableObjectChecker checkLeaveRecordListOfUser(List<BaseEntity> leaveRecordList){
		AtomicInteger index = new AtomicInteger();
		leaveRecordList.stream().forEach(leaveRecord->
			commonObjectElementCheck(leaveRecord,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLeaveRecord));
		return this;
	}

	public static final String DISTRICT_OF_USER = "user.district";


	public FlowableObjectChecker checkDistrictOfUser(BaseEntity districtAsBaseEntity){

		if(districtAsBaseEntity == null){
			checkBaseEntityReference(districtAsBaseEntity,true,DISTRICT_OF_USER);
			return this;
		}
		checkAndFixDistrict(districtAsBaseEntity);
		return this;
	}


	public static final String ROLE_OF_USER = "user.role";


	public FlowableObjectChecker checkRoleOfUser(BaseEntity roleAsBaseEntity){

		if(roleAsBaseEntity == null){
			checkBaseEntityReference(roleAsBaseEntity,true,ROLE_OF_USER);
			return this;
		}
		checkAndFixRole(roleAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkUserListOfRole(List<BaseEntity> userList){
		AtomicInteger index = new AtomicInteger();
		userList.stream().forEach(user->
			commonObjectElementCheck(user,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUser));
		return this;
	}

	public static final String USER_OF_LEAVE_RECORD = "leave_record.user";


	public FlowableObjectChecker checkUserOfLeaveRecord(BaseEntity userAsBaseEntity){

		if(userAsBaseEntity == null){
			checkBaseEntityReference(userAsBaseEntity,true,USER_OF_LEAVE_RECORD);
			return this;
		}
		checkAndFixUser(userAsBaseEntity);
		return this;
	}


	public static final String TYPE_OF_LEAVE_RECORD = "leave_record.type";


	public FlowableObjectChecker checkTypeOfLeaveRecord(BaseEntity typeAsBaseEntity){

		if(typeAsBaseEntity == null){
			checkBaseEntityReference(typeAsBaseEntity,true,TYPE_OF_LEAVE_RECORD);
			return this;
		}
		checkAndFixLeaveRecordType(typeAsBaseEntity);
		return this;
	}


	public static final String PLATFORM_OF_LEAVE_RECORD = "leave_record.platform";


	public FlowableObjectChecker checkPlatformOfLeaveRecord(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_LEAVE_RECORD);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkLeaveRecordListOfLeaveRecordType(List<BaseEntity> leaveRecordList){
		AtomicInteger index = new AtomicInteger();
		leaveRecordList.stream().forEach(leaveRecord->
			commonObjectElementCheck(leaveRecord,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLeaveRecord));
		return this;
	}

	public FlowableObjectChecker checkHolydaySettingListOfLeaveRecordType(List<BaseEntity> holydaySettingList){
		AtomicInteger index = new AtomicInteger();
		holydaySettingList.stream().forEach(holydaySetting->
			commonObjectElementCheck(holydaySetting,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixHolydaySetting));
		return this;
	}

	public static final String TYPE_OF_HOLYDAY_SETTING = "holyday_setting.type";


	public FlowableObjectChecker checkTypeOfHolydaySetting(BaseEntity typeAsBaseEntity){

		if(typeAsBaseEntity == null){
			checkBaseEntityReference(typeAsBaseEntity,true,TYPE_OF_HOLYDAY_SETTING);
			return this;
		}
		checkAndFixLeaveRecordType(typeAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkCityListOfProvince(List<BaseEntity> cityList){
		AtomicInteger index = new AtomicInteger();
		cityList.stream().forEach(city->
			commonObjectElementCheck(city,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCity));
		return this;
	}

	public static final String PLATFORM_OF_PROVINCE = "province.platform";


	public FlowableObjectChecker checkPlatformOfProvince(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_PROVINCE);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkDistrictListOfCity(List<BaseEntity> districtList){
		AtomicInteger index = new AtomicInteger();
		districtList.stream().forEach(district->
			commonObjectElementCheck(district,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixDistrict));
		return this;
	}

	public static final String PROVINCE_OF_CITY = "city.province";


	public FlowableObjectChecker checkProvinceOfCity(BaseEntity provinceAsBaseEntity){

		if(provinceAsBaseEntity == null){
			checkBaseEntityReference(provinceAsBaseEntity,true,PROVINCE_OF_CITY);
			return this;
		}
		checkAndFixProvince(provinceAsBaseEntity);
		return this;
	}


	public static final String PLATFORM_OF_CITY = "city.platform";


	public FlowableObjectChecker checkPlatformOfCity(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_CITY);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkUserListOfDistrict(List<BaseEntity> userList){
		AtomicInteger index = new AtomicInteger();
		userList.stream().forEach(user->
			commonObjectElementCheck(user,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUser));
		return this;
	}

	public static final String CITY_OF_DISTRICT = "district.city";


	public FlowableObjectChecker checkCityOfDistrict(BaseEntity cityAsBaseEntity){

		if(cityAsBaseEntity == null){
			checkBaseEntityReference(cityAsBaseEntity,true,CITY_OF_DISTRICT);
			return this;
		}
		checkAndFixCity(cityAsBaseEntity);
		return this;
	}


	public static final String PLATFORM_OF_DISTRICT = "district.platform";


	public FlowableObjectChecker checkPlatformOfDistrict(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_DISTRICT);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkUserWhiteListListOfUserDomain(List<BaseEntity> userWhiteListList){
		AtomicInteger index = new AtomicInteger();
		userWhiteListList.stream().forEach(userWhiteList->
			commonObjectElementCheck(userWhiteList,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserWhiteList));
		return this;
	}

	public FlowableObjectChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public static final String DOMAIN_OF_USER_WHITE_LIST = "user_white_list.domain";


	public FlowableObjectChecker checkDomainOfUserWhiteList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_WHITE_LIST);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		AtomicInteger index = new AtomicInteger();
		userAppList.stream().forEach(userApp->
			commonObjectElementCheck(userApp,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserApp));
		return this;
	}

	public FlowableObjectChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		AtomicInteger index = new AtomicInteger();
		loginHistoryList.stream().forEach(loginHistory->
			commonObjectElementCheck(loginHistory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLoginHistory));
		return this;
	}

	public FlowableObjectChecker checkWechatWorkappIdentifyListOfSecUser(List<BaseEntity> wechatWorkappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatWorkappIdentifyList.stream().forEach(wechatWorkappIdentify->
			commonObjectElementCheck(wechatWorkappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatWorkappIdentify));
		return this;
	}

	public FlowableObjectChecker checkWechatMiniappIdentifyListOfSecUser(List<BaseEntity> wechatMiniappIdentifyList){
		AtomicInteger index = new AtomicInteger();
		wechatMiniappIdentifyList.stream().forEach(wechatMiniappIdentify->
			commonObjectElementCheck(wechatMiniappIdentify,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatMiniappIdentify));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public FlowableObjectChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkQuickLinkListOfUserApp(List<BaseEntity> quickLinkList){
		AtomicInteger index = new AtomicInteger();
		quickLinkList.stream().forEach(quickLink->
			commonObjectElementCheck(quickLink,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuickLink));
		return this;
	}

	public FlowableObjectChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		AtomicInteger index = new AtomicInteger();
		listAccessList.stream().forEach(listAccess->
			commonObjectElementCheck(listAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixListAccess));
		return this;
	}

	public FlowableObjectChecker checkObjectAccessListOfUserApp(List<BaseEntity> objectAccessList){
		AtomicInteger index = new AtomicInteger();
		objectAccessList.stream().forEach(objectAccess->
			commonObjectElementCheck(objectAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixObjectAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public FlowableObjectChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_QUICK_LINK = "quick_link.app";


	public FlowableObjectChecker checkAppOfQuickLink(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_QUICK_LINK);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public FlowableObjectChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_OBJECT_ACCESS = "object_access.app";


	public FlowableObjectChecker checkAppOfObjectAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_OBJECT_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public FlowableObjectChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkFormMessageListOfGenericForm(List<BaseEntity> formMessageList){
		AtomicInteger index = new AtomicInteger();
		formMessageList.stream().forEach(formMessage->
			commonObjectElementCheck(formMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormMessage));
		return this;
	}

	public FlowableObjectChecker checkFormFieldMessageListOfGenericForm(List<BaseEntity> formFieldMessageList){
		AtomicInteger index = new AtomicInteger();
		formFieldMessageList.stream().forEach(formFieldMessage->
			commonObjectElementCheck(formFieldMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormFieldMessage));
		return this;
	}

	public FlowableObjectChecker checkFormFieldListOfGenericForm(List<BaseEntity> formFieldList){
		AtomicInteger index = new AtomicInteger();
		formFieldList.stream().forEach(formField->
			commonObjectElementCheck(formField,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormField));
		return this;
	}

	public FlowableObjectChecker checkFormActionListOfGenericForm(List<BaseEntity> formActionList){
		AtomicInteger index = new AtomicInteger();
		formActionList.stream().forEach(formAction->
			commonObjectElementCheck(formAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormAction));
		return this;
	}

	public static final String FORM_OF_FORM_MESSAGE = "form_message.form";


	public FlowableObjectChecker checkFormOfFormMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD_MESSAGE = "form_field_message.form";


	public FlowableObjectChecker checkFormOfFormFieldMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD = "form_field.form";


	public FlowableObjectChecker checkFormOfFormField(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_ACTION = "form_action.form";


	public FlowableObjectChecker checkFormOfFormAction(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_ACTION);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public FlowableObjectChecker checkCandidateElementListOfCandidateContainer(List<BaseEntity> candidateElementList){
		AtomicInteger index = new AtomicInteger();
		candidateElementList.stream().forEach(candidateElement->
			commonObjectElementCheck(candidateElement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCandidateElement));
		return this;
	}

	public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";


	public FlowableObjectChecker checkContainerOfCandidateElement(BaseEntity containerAsBaseEntity){

		if(containerAsBaseEntity == null){
			checkBaseEntityReference(containerAsBaseEntity,true,CONTAINER_OF_CANDIDATE_ELEMENT);
			return this;
		}
		checkAndFixCandidateContainer(containerAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY = "wechat_workapp_identify.sec_user";


	public FlowableObjectChecker checkSecUserOfWechatWorkappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_WORKAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY = "wechat_miniapp_identify.sec_user";


	public FlowableObjectChecker checkSecUserOfWechatMiniappIdentify(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_WECHAT_MINIAPP_IDENTIFY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}

	public FlowableObjectChecker assignFoundedOfPlatform(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"founded",userContext.now());
		return this;
	}
	public FlowableObjectChecker assignCreateTimeOfQuickLink(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public FlowableObjectChecker assignLoginTimeOfLoginHistory(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"loginTime",userContext.now());
		return this;
	}
	public FlowableObjectChecker assignCreateTimeOfWechatWorkappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public FlowableObjectChecker assignCreateTimeOfWechatMiniappIdentify(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}

}


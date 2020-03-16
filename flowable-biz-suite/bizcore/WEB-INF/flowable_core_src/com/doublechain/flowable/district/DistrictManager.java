
package com.doublechain.flowable.district;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface DistrictManager extends BaseManager{

		

	public District createDistrict(FlowableUserContext userContext, String name,String cityId,String platformId) throws Exception;	
	public District updateDistrict(FlowableUserContext userContext,String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public District loadDistrict(FlowableUserContext userContext, String districtId, String [] tokensExpr) throws Exception;
	public District internalSaveDistrict(FlowableUserContext userContext, District district) throws Exception;
	public District internalSaveDistrict(FlowableUserContext userContext, District district,Map<String,Object>option) throws Exception;
	
	public District transferToAnotherCity(FlowableUserContext userContext, String districtId, String anotherCityId)  throws Exception;
 	public District transferToAnotherPlatform(FlowableUserContext userContext, String districtId, String anotherPlatformId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String districtId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, District newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserManager getUserManager(FlowableUserContext userContext, String districtId, String name, String mobile, String avatar, int age, String description, String roleId ,String [] tokensExpr)  throws Exception;
	
	public  District addUser(FlowableUserContext userContext, String districtId, String name, String mobile, String avatar, int age, String description, String roleId , String [] tokensExpr)  throws Exception;
	public  District removeUser(FlowableUserContext userContext, String districtId, String userId, int userVersion,String [] tokensExpr)  throws Exception;
	public  District updateUser(FlowableUserContext userContext, String districtId, String userId, int userVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCity(FlowableUserContext userContext,String cityId) throws Exception;
	public Object listPageByCity(FlowableUserContext userContext,String cityId, int start, int count) throws Exception;
  
	public Object listByPlatform(FlowableUserContext userContext,String platformId) throws Exception;
	public Object listPageByPlatform(FlowableUserContext userContext,String platformId, int start, int count) throws Exception;
  

}



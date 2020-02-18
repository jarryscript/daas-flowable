
package com.doublechain.flowable.city;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface CityManager extends BaseManager{

		

	public City createCity(FlowableUserContext userContext, String name,String provinceId,String platformId) throws Exception;	
	public City updateCity(FlowableUserContext userContext,String cityId, int cityVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public City loadCity(FlowableUserContext userContext, String cityId, String [] tokensExpr) throws Exception;
	public City internalSaveCity(FlowableUserContext userContext, City city) throws Exception;
	public City internalSaveCity(FlowableUserContext userContext, City city,Map<String,Object>option) throws Exception;
	
	public City transferToAnotherProvince(FlowableUserContext userContext, String cityId, String anotherProvinceId)  throws Exception;
 	public City transferToAnotherPlatform(FlowableUserContext userContext, String cityId, String anotherPlatformId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String cityId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, City newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  DistrictManager getDistrictManager(FlowableUserContext userContext, String cityId, String name, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  City addDistrict(FlowableUserContext userContext, String cityId, String name, String platformId , String [] tokensExpr)  throws Exception;
	public  City removeDistrict(FlowableUserContext userContext, String cityId, String districtId, int districtVersion,String [] tokensExpr)  throws Exception;
	public  City updateDistrict(FlowableUserContext userContext, String cityId, String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}



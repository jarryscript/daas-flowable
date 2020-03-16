
package com.doublechain.flowable.province;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface ProvinceManager extends BaseManager{

		

	public Province createProvince(FlowableUserContext userContext, String name,String platformId) throws Exception;	
	public Province updateProvince(FlowableUserContext userContext,String provinceId, int provinceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Province loadProvince(FlowableUserContext userContext, String provinceId, String [] tokensExpr) throws Exception;
	public Province internalSaveProvince(FlowableUserContext userContext, Province province) throws Exception;
	public Province internalSaveProvince(FlowableUserContext userContext, Province province,Map<String,Object>option) throws Exception;
	
	public Province transferToAnotherPlatform(FlowableUserContext userContext, String provinceId, String anotherPlatformId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String provinceId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, Province newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  CityManager getCityManager(FlowableUserContext userContext, String provinceId, String name, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  Province addCity(FlowableUserContext userContext, String provinceId, String name, String platformId , String [] tokensExpr)  throws Exception;
	public  Province removeCity(FlowableUserContext userContext, String provinceId, String cityId, int cityVersion,String [] tokensExpr)  throws Exception;
	public  Province updateCity(FlowableUserContext userContext, String provinceId, String cityId, int cityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPlatform(FlowableUserContext userContext,String platformId) throws Exception;
	public Object listPageByPlatform(FlowableUserContext userContext,String platformId, int start, int count) throws Exception;
  

}



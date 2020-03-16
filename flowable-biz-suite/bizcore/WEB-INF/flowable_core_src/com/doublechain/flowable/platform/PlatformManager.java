
package com.doublechain.flowable.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface PlatformManager extends BaseManager{

		

	public Platform createPlatform(FlowableUserContext userContext, String name) throws Exception;	
	public Platform updatePlatform(FlowableUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(FlowableUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(FlowableUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(FlowableUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(FlowableUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  LeaveRecordManager getLeaveRecordManager(FlowableUserContext userContext, String platformId, String userId, String typeId, Date fromdate, Date todate ,String [] tokensExpr)  throws Exception;
	
	public  Platform addLeaveRecord(FlowableUserContext userContext, String platformId, String userId, String typeId, Date fromdate, Date todate , String [] tokensExpr)  throws Exception;
	public  Platform removeLeaveRecord(FlowableUserContext userContext, String platformId, String leaveRecordId, int leaveRecordVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateLeaveRecord(FlowableUserContext userContext, String platformId, String leaveRecordId, int leaveRecordVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ProvinceManager getProvinceManager(FlowableUserContext userContext, String platformId, String name ,String [] tokensExpr)  throws Exception;
	
	public  Platform addProvince(FlowableUserContext userContext, String platformId, String name , String [] tokensExpr)  throws Exception;
	public  Platform removeProvince(FlowableUserContext userContext, String platformId, String provinceId, int provinceVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateProvince(FlowableUserContext userContext, String platformId, String provinceId, int provinceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CityManager getCityManager(FlowableUserContext userContext, String platformId, String name, String provinceId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addCity(FlowableUserContext userContext, String platformId, String name, String provinceId , String [] tokensExpr)  throws Exception;
	public  Platform removeCity(FlowableUserContext userContext, String platformId, String cityId, int cityVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateCity(FlowableUserContext userContext, String platformId, String cityId, int cityVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  DistrictManager getDistrictManager(FlowableUserContext userContext, String platformId, String name, String cityId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addDistrict(FlowableUserContext userContext, String platformId, String name, String cityId , String [] tokensExpr)  throws Exception;
	public  Platform removeDistrict(FlowableUserContext userContext, String platformId, String districtId, int districtVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateDistrict(FlowableUserContext userContext, String platformId, String districtId, int districtVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}



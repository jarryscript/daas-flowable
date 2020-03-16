
package com.doublechain.flowable.holydaysetting;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface HolydaySettingManager extends BaseManager{

		

	public HolydaySetting createHolydaySetting(FlowableUserContext userContext, String typeId,int leaveDays) throws Exception;	
	public HolydaySetting updateHolydaySetting(FlowableUserContext userContext,String holydaySettingId, int holydaySettingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public HolydaySetting loadHolydaySetting(FlowableUserContext userContext, String holydaySettingId, String [] tokensExpr) throws Exception;
	public HolydaySetting internalSaveHolydaySetting(FlowableUserContext userContext, HolydaySetting holydaySetting) throws Exception;
	public HolydaySetting internalSaveHolydaySetting(FlowableUserContext userContext, HolydaySetting holydaySetting,Map<String,Object>option) throws Exception;
	
	public HolydaySetting transferToAnotherType(FlowableUserContext userContext, String holydaySettingId, String anotherTypeId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String holydaySettingId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, HolydaySetting newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByType(FlowableUserContext userContext,String typeId) throws Exception;
	public Object listPageByType(FlowableUserContext userContext,String typeId, int start, int count) throws Exception;
  

}



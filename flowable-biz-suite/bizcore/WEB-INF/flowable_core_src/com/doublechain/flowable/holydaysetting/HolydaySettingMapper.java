
package com.doublechain.flowable.holydaysetting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechain.flowable.BaseRowMapper;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;

public class HolydaySettingMapper extends BaseRowMapper<HolydaySetting>{
	
	protected HolydaySetting internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		HolydaySetting holydaySetting = getHolydaySetting();		
		 		
 		setId(holydaySetting, rs, rowNumber); 		
 		setType(holydaySetting, rs, rowNumber); 		
 		setLeaveDays(holydaySetting, rs, rowNumber); 		
 		setVersion(holydaySetting, rs, rowNumber);

		return holydaySetting;
	}
	
	protected HolydaySetting getHolydaySetting(){
		return new HolydaySetting();
	}		
		
	protected void setId(HolydaySetting holydaySetting, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(HolydaySettingTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		holydaySetting.setId(id);
	}
		 		
 	protected void setType(HolydaySetting holydaySetting, ResultSet rs, int rowNumber) throws SQLException{
 		String leaveRecordTypeId = rs.getString(HolydaySettingTable.COLUMN_TYPE);
 		if( leaveRecordTypeId == null){
 			return;
 		}
 		if( leaveRecordTypeId.isEmpty()){
 			return;
 		}
 		LeaveRecordType leaveRecordType = holydaySetting.getType();
 		if( leaveRecordType != null ){
 			//if the root object 'holydaySetting' already have the property, just set the id for it;
 			leaveRecordType.setId(leaveRecordTypeId);
 			
 			return;
 		}
 		holydaySetting.setType(createEmptyType(leaveRecordTypeId));
 	}
 	
	protected void setLeaveDays(HolydaySetting holydaySetting, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer leaveDays = rs.getInt(HolydaySettingTable.COLUMN_LEAVE_DAYS);
		
		if(leaveDays == null){
			//do nothing when nothing found in database
			return;
		}
		
		holydaySetting.setLeaveDays(leaveDays);
	}
		
	protected void setVersion(HolydaySetting holydaySetting, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(HolydaySettingTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		holydaySetting.setVersion(version);
	}
		
		

 	protected LeaveRecordType  createEmptyType(String leaveRecordTypeId){
 		LeaveRecordType leaveRecordType = new LeaveRecordType();
 		leaveRecordType.setId(leaveRecordTypeId);
 		leaveRecordType.setVersion(Integer.MAX_VALUE);
 		return leaveRecordType;
 	}
 	
}



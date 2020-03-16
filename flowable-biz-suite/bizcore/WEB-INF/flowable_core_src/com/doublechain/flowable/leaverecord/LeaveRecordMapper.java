
package com.doublechain.flowable.leaverecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechain.flowable.BaseRowMapper;
import com.doublechain.flowable.user.User;
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.platform.Platform;

public class LeaveRecordMapper extends BaseRowMapper<LeaveRecord>{
	
	protected LeaveRecord internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LeaveRecord leaveRecord = getLeaveRecord();		
		 		
 		setId(leaveRecord, rs, rowNumber); 		
 		setUser(leaveRecord, rs, rowNumber); 		
 		setType(leaveRecord, rs, rowNumber); 		
 		setFromdate(leaveRecord, rs, rowNumber); 		
 		setTodate(leaveRecord, rs, rowNumber); 		
 		setPlatform(leaveRecord, rs, rowNumber); 		
 		setVersion(leaveRecord, rs, rowNumber);

		return leaveRecord;
	}
	
	protected LeaveRecord getLeaveRecord(){
		return new LeaveRecord();
	}		
		
	protected void setId(LeaveRecord leaveRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(LeaveRecordTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		leaveRecord.setId(id);
	}
		 		
 	protected void setUser(LeaveRecord leaveRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String userId = rs.getString(LeaveRecordTable.COLUMN_USER);
 		if( userId == null){
 			return;
 		}
 		if( userId.isEmpty()){
 			return;
 		}
 		User user = leaveRecord.getUser();
 		if( user != null ){
 			//if the root object 'leaveRecord' already have the property, just set the id for it;
 			user.setId(userId);
 			
 			return;
 		}
 		leaveRecord.setUser(createEmptyUser(userId));
 	}
 	 		
 	protected void setType(LeaveRecord leaveRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String leaveRecordTypeId = rs.getString(LeaveRecordTable.COLUMN_TYPE);
 		if( leaveRecordTypeId == null){
 			return;
 		}
 		if( leaveRecordTypeId.isEmpty()){
 			return;
 		}
 		LeaveRecordType leaveRecordType = leaveRecord.getType();
 		if( leaveRecordType != null ){
 			//if the root object 'leaveRecord' already have the property, just set the id for it;
 			leaveRecordType.setId(leaveRecordTypeId);
 			
 			return;
 		}
 		leaveRecord.setType(createEmptyType(leaveRecordTypeId));
 	}
 	
	protected void setFromdate(LeaveRecord leaveRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date fromdate = rs.getDate(LeaveRecordTable.COLUMN_FROMDATE);
		
		if(fromdate == null){
			//do nothing when nothing found in database
			return;
		}
		
		leaveRecord.setFromdate(fromdate);
	}
		
	protected void setTodate(LeaveRecord leaveRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date todate = rs.getDate(LeaveRecordTable.COLUMN_TODATE);
		
		if(todate == null){
			//do nothing when nothing found in database
			return;
		}
		
		leaveRecord.setTodate(todate);
	}
		 		
 	protected void setPlatform(LeaveRecord leaveRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(LeaveRecordTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = leaveRecord.getPlatform();
 		if( platform != null ){
 			//if the root object 'leaveRecord' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		leaveRecord.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(LeaveRecord leaveRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(LeaveRecordTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		leaveRecord.setVersion(version);
	}
		
		

 	protected User  createEmptyUser(String userId){
 		User user = new User();
 		user.setId(userId);
 		user.setVersion(Integer.MAX_VALUE);
 		return user;
 	}
 	
 	protected LeaveRecordType  createEmptyType(String leaveRecordTypeId){
 		LeaveRecordType leaveRecordType = new LeaveRecordType();
 		leaveRecordType.setId(leaveRecordTypeId);
 		leaveRecordType.setVersion(Integer.MAX_VALUE);
 		return leaveRecordType;
 	}
 	
 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}



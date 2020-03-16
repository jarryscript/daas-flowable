
package com.doublechain.flowable.leaverecordtype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechain.flowable.BaseRowMapper;

public class LeaveRecordTypeMapper extends BaseRowMapper<LeaveRecordType>{
	
	protected LeaveRecordType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LeaveRecordType leaveRecordType = getLeaveRecordType();		
		 		
 		setId(leaveRecordType, rs, rowNumber); 		
 		setName(leaveRecordType, rs, rowNumber); 		
 		setCode(leaveRecordType, rs, rowNumber); 		
 		setVersion(leaveRecordType, rs, rowNumber);

		return leaveRecordType;
	}
	
	protected LeaveRecordType getLeaveRecordType(){
		return new LeaveRecordType();
	}		
		
	protected void setId(LeaveRecordType leaveRecordType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(LeaveRecordTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		leaveRecordType.setId(id);
	}
		
	protected void setName(LeaveRecordType leaveRecordType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(LeaveRecordTypeTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		leaveRecordType.setName(name);
	}
		
	protected void setCode(LeaveRecordType leaveRecordType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(LeaveRecordTypeTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		leaveRecordType.setCode(code);
	}
		
	protected void setVersion(LeaveRecordType leaveRecordType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(LeaveRecordTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		leaveRecordType.setVersion(version);
	}
		
		

}



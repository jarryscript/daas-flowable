
package com.doublechain.flowable.role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechain.flowable.BaseRowMapper;

public class RoleMapper extends BaseRowMapper<Role>{
	
	protected Role internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Role role = getRole();		
		 		
 		setId(role, rs, rowNumber); 		
 		setName(role, rs, rowNumber); 		
 		setCode(role, rs, rowNumber); 		
 		setVersion(role, rs, rowNumber);

		return role;
	}
	
	protected Role getRole(){
		return new Role();
	}		
		
	protected void setId(Role role, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RoleTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		role.setId(id);
	}
		
	protected void setName(Role role, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(RoleTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		role.setName(name);
	}
		
	protected void setCode(Role role, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(RoleTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		role.setCode(code);
	}
		
	protected void setVersion(Role role, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RoleTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		role.setVersion(version);
	}
		
		

}



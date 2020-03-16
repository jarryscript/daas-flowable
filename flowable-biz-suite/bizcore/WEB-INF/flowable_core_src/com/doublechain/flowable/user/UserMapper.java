
package com.doublechain.flowable.user;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechain.flowable.BaseRowMapper;
import com.doublechain.flowable.district.District;
import com.doublechain.flowable.role.Role;

public class UserMapper extends BaseRowMapper<User>{
	
	protected User internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		User user = getUser();		
		 		
 		setId(user, rs, rowNumber); 		
 		setName(user, rs, rowNumber); 		
 		setMobile(user, rs, rowNumber); 		
 		setAvatar(user, rs, rowNumber); 		
 		setAge(user, rs, rowNumber); 		
 		setDescription(user, rs, rowNumber); 		
 		setDistrict(user, rs, rowNumber); 		
 		setRole(user, rs, rowNumber); 		
 		setVersion(user, rs, rowNumber);

		return user;
	}
	
	protected User getUser(){
		return new User();
	}		
		
	protected void setId(User user, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(UserTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		user.setId(id);
	}
		
	protected void setName(User user, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(UserTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		user.setName(name);
	}
		
	protected void setMobile(User user, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String mobile = rs.getString(UserTable.COLUMN_MOBILE);
		
		if(mobile == null){
			//do nothing when nothing found in database
			return;
		}
		
		user.setMobile(mobile);
	}
		
	protected void setAvatar(User user, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String avatar = rs.getString(UserTable.COLUMN_AVATAR);
		
		if(avatar == null){
			//do nothing when nothing found in database
			return;
		}
		
		user.setAvatar(avatar);
	}
		
	protected void setAge(User user, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer age = rs.getInt(UserTable.COLUMN_AGE);
		
		if(age == null){
			//do nothing when nothing found in database
			return;
		}
		
		user.setAge(age);
	}
		
	protected void setDescription(User user, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(UserTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		user.setDescription(description);
	}
		 		
 	protected void setDistrict(User user, ResultSet rs, int rowNumber) throws SQLException{
 		String districtId = rs.getString(UserTable.COLUMN_DISTRICT);
 		if( districtId == null){
 			return;
 		}
 		if( districtId.isEmpty()){
 			return;
 		}
 		District district = user.getDistrict();
 		if( district != null ){
 			//if the root object 'user' already have the property, just set the id for it;
 			district.setId(districtId);
 			
 			return;
 		}
 		user.setDistrict(createEmptyDistrict(districtId));
 	}
 	 		
 	protected void setRole(User user, ResultSet rs, int rowNumber) throws SQLException{
 		String roleId = rs.getString(UserTable.COLUMN_ROLE);
 		if( roleId == null){
 			return;
 		}
 		if( roleId.isEmpty()){
 			return;
 		}
 		Role role = user.getRole();
 		if( role != null ){
 			//if the root object 'user' already have the property, just set the id for it;
 			role.setId(roleId);
 			
 			return;
 		}
 		user.setRole(createEmptyRole(roleId));
 	}
 	
	protected void setVersion(User user, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(UserTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		user.setVersion(version);
	}
		
		

 	protected District  createEmptyDistrict(String districtId){
 		District district = new District();
 		district.setId(districtId);
 		district.setVersion(Integer.MAX_VALUE);
 		return district;
 	}
 	
 	protected Role  createEmptyRole(String roleId){
 		Role role = new Role();
 		role.setId(roleId);
 		role.setVersion(Integer.MAX_VALUE);
 		return role;
 	}
 	
}



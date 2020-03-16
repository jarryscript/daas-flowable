
package com.doublechain.flowable.role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.SmartList;
import com.doublechain.flowable.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechain.flowable.user.User;

@JsonSerialize(using = RoleSerializer.class)
public class Role extends BaseEntity implements  java.io.Serializable{

	public static final String EMPLOYEE = "EMPLOYEE";	// 员工
	public static final String MANAGER = "MANAGER";	// 主管
	public static final String BOSS = "BOSS";	// 老板
	public static List<KeyValuePair> CODE_NAME_LIST;
	static {
		CODE_NAME_LIST = new ArrayList<>();

		CODE_NAME_LIST.add(new KeyValuePair(EMPLOYEE, "员工"));
		CODE_NAME_LIST.add(new KeyValuePair(MANAGER, "主管"));
		CODE_NAME_LIST.add(new KeyValuePair(BOSS, "老板"));
	}
	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_LIST                                = "userList"          ;

	public static final String INTERNAL_TYPE="Role";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mCode               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<User>     	mUserList           ;
	
		
	public 	Role(){
		// lazy load for all the properties
	}
	public 	static Role withId(String id){
		Role role = new Role();
		role.setId(id);
		role.setVersion(Integer.MAX_VALUE);
		return role;
	}
	public 	static Role refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
	
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCodeProperty(String newValueExpr){
	
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCode(newValue);
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(USER_LIST.equals(property)){
			List<BaseEntity> list = getUserList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Role updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Role updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public Role updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Role updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<User> getUserList(){
		if(this.mUserList == null){
			this.mUserList = new SmartList<User>();
			this.mUserList.setListInternalName (USER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mUserList;	
	}
	public  void setUserList(SmartList<User> userList){
		for( User user:userList){
			user.setRole(this);
		}

		this.mUserList = userList;
		this.mUserList.setListInternalName (USER_LIST );
		
	}
	
	public  void addUser(User user){
		user.setRole(this);
		getUserList().add(user);
	}
	public  void addUserList(SmartList<User> userList){
		for( User user:userList){
			user.setRole(this);
		}
		getUserList().addAll(userList);
	}
	public  void mergeUserList(SmartList<User> userList){
		if(userList==null){
			return;
		}
		if(userList.isEmpty()){
			return;
		}
		addUserList( userList );
		
	}
	public  User removeUser(User userIndex){
		
		int index = getUserList().indexOf(userIndex);
        if(index < 0){
        	String message = "User("+userIndex.getId()+") with version='"+userIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        User user = getUserList().get(index);        
        // user.clearRole(); //disconnect with Role
        user.clearFromAll(); //disconnect with Role
		
		boolean result = getUserList().planToRemove(user);
        if(!result){
        	String message = "User("+userIndex.getId()+") with version='"+userIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return user;
        
	
	}
	//断舍离
	public  void breakWithUser(User user){
		
		if(user == null){
			return;
		}
		user.setRole(null);
		//getUserList().remove();
	
	}
	
	public  boolean hasUser(User user){
	
		return getUserList().contains(user);
  
	}
	
	public void copyUserFrom(User user) {

		User userInList = findTheUser(user);
		User newUser = new User();
		userInList.copyTo(newUser);
		newUser.setVersion(0);//will trigger copy
		getUserList().add(newUser);
		addItemToFlexiableObject(COPIED_CHILD, newUser);
	}
	
	public  User findTheUser(User user){
		
		int index =  getUserList().indexOf(user);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "User("+user.getId()+") with version='"+user.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getUserList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpUserList(){
		getUserList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getUserList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getUserList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, USER_LIST, getUserList());
		if(!getUserList().isEmpty()){
			appendKeyValuePair(result, "userCount", getUserList().getTotalCount());
			appendKeyValuePair(result, "userCurrentPageNumber", getUserList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Role){
		
		
			Role dest =(Role)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setVersion(getVersion());
			dest.setUserList(getUserList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Role){
		
			
			Role dest =(Role)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeVersion(getVersion());
			dest.mergeUserList(getUserList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Role){
		
			
			Role dest =(Role)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getCode(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Role{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}



package com.doublechain.flowable.district;

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
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.platform.Platform;

@JsonSerialize(using = DistrictSerializer.class)
public class District extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CITY_PROPERTY                  = "city"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_LIST                                = "userList"          ;

	public static final String INTERNAL_TYPE="District";
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
	protected		City                	mCity               ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<User>     	mUserList           ;
	
		
	public 	District(){
		// lazy load for all the properties
	}
	public 	static District withId(String id){
		District district = new District();
		district.setId(id);
		district.setVersion(Integer.MAX_VALUE);
		return district;
	}
	public 	static District refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCity( null );
		setPlatform( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CITY_PROPERTY.equals(property)){
			return getCity();
		}
		if(PLATFORM_PROPERTY.equals(property)){
			return getPlatform();
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
	public District updateId(String id){
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
	public District updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCity(City city){
		this.mCity = city;;
	}
	public City getCity(){
		return this.mCity;
	}
	public District updateCity(City city){
		this.mCity = city;;
		this.changed = true;
		return this;
	}
	public void mergeCity(City city){
		if(city != null) { setCity(city);}
	}
	
	
	public void clearCity(){
		setCity ( null );
		this.changed = true;
	}
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public District updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	public void mergePlatform(Platform platform){
		if(platform != null) { setPlatform(platform);}
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public District updateVersion(int version){
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
			user.setDistrict(this);
		}

		this.mUserList = userList;
		this.mUserList.setListInternalName (USER_LIST );
		
	}
	
	public  void addUser(User user){
		user.setDistrict(this);
		getUserList().add(user);
	}
	public  void addUserList(SmartList<User> userList){
		for( User user:userList){
			user.setDistrict(this);
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
        // user.clearDistrict(); //disconnect with District
        user.clearFromAll(); //disconnect with District
		
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
		user.setDistrict(null);
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

		addToEntityList(this, entityList, getCity(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
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
		appendKeyValuePair(result, CITY_PROPERTY, getCity());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, USER_LIST, getUserList());
		if(!getUserList().isEmpty()){
			appendKeyValuePair(result, "userCount", getUserList().getTotalCount());
			appendKeyValuePair(result, "userCurrentPageNumber", getUserList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof District){
		
		
			District dest =(District)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCity(getCity());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setUserList(getUserList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof District){
		
			
			District dest =(District)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCity(getCity());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeUserList(getUserList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof District){
		
			
			District dest =(District)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getCity(), getPlatform(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("District{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getCity() != null ){
 			stringBuilder.append("\tcity='City("+getCity().getId()+")';");
 		}
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}



package com.doublechain.flowable.user;

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
import com.doublechain.flowable.district.District;
import com.doublechain.flowable.leaverecord.LeaveRecord;
import com.doublechain.flowable.role.Role;

@JsonSerialize(using = UserSerializer.class)
public class User extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String AVATAR_PROPERTY                = "avatar"            ;
	public static final String AGE_PROPERTY                   = "age"               ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String DISTRICT_PROPERTY              = "district"          ;
	public static final String ROLE_PROPERTY                  = "role"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEAVE_RECORD_LIST                        = "leaveRecordList"   ;

	public static final String INTERNAL_TYPE="User";
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
	protected		String              	mMobile             ;
	protected		String              	mAvatar             ;
	protected		int                 	mAge                ;
	protected		String              	mDescription        ;
	protected		District            	mDistrict           ;
	protected		Role                	mRole               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LeaveRecord>	mLeaveRecordList    ;
	
		
	public 	User(){
		// lazy load for all the properties
	}
	public 	static User withId(String id){
		User user = new User();
		user.setId(id);
		user.setVersion(Integer.MAX_VALUE);
		return user;
	}
	public 	static User refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDistrict( null );
		setRole( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PROPERTY.equals(property)){
			changeMobileProperty(newValueExpr);
		}
		if(AVATAR_PROPERTY.equals(property)){
			changeAvatarProperty(newValueExpr);
		}
		if(AGE_PROPERTY.equals(property)){
			changeAgeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			
	protected void changeMobileProperty(String newValueExpr){
	
		String oldValue = getMobile();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMobile(newValue);
		this.onChangeProperty(MOBILE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAvatarProperty(String newValueExpr){
	
		String oldValue = getAvatar();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAvatar(newValue);
		this.onChangeProperty(AVATAR_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAgeProperty(String newValueExpr){
	
		int oldValue = getAge();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAge(newValue);
		this.onChangeProperty(AGE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
	
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(MOBILE_PROPERTY.equals(property)){
			return getMobile();
		}
		if(AVATAR_PROPERTY.equals(property)){
			return getAvatar();
		}
		if(AGE_PROPERTY.equals(property)){
			return getAge();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(DISTRICT_PROPERTY.equals(property)){
			return getDistrict();
		}
		if(ROLE_PROPERTY.equals(property)){
			return getRole();
		}
		if(LEAVE_RECORD_LIST.equals(property)){
			List<BaseEntity> list = getLeaveRecordList().stream().map(item->item).collect(Collectors.toList());
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
	public User updateId(String id){
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
	public User updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setMobile(String mobile){
		this.mMobile = trimString(mobile);;
	}
	public String getMobile(){
		return this.mMobile;
	}
	public User updateMobile(String mobile){
		this.mMobile = trimString(mobile);;
		this.changed = true;
		return this;
	}
	public void mergeMobile(String mobile){
		if(mobile != null) { setMobile(mobile);}
	}
	
	
	
	public String getMaskedMobile(){
		String mobilePhoneNumber = getMobile();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setAvatar(String avatar){
		this.mAvatar = trimString(avatar);;
	}
	public String getAvatar(){
		return this.mAvatar;
	}
	public User updateAvatar(String avatar){
		this.mAvatar = trimString(avatar);;
		this.changed = true;
		return this;
	}
	public void mergeAvatar(String avatar){
		if(avatar != null) { setAvatar(avatar);}
	}
	
	
	public void setAge(int age){
		this.mAge = age;;
	}
	public int getAge(){
		return this.mAge;
	}
	public User updateAge(int age){
		this.mAge = age;;
		this.changed = true;
		return this;
	}
	public void mergeAge(int age){
		setAge(age);
	}
	
	
	public void setDescription(String description){
		this.mDescription = description;;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public User updateDescription(String description){
		this.mDescription = description;;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setDistrict(District district){
		this.mDistrict = district;;
	}
	public District getDistrict(){
		return this.mDistrict;
	}
	public User updateDistrict(District district){
		this.mDistrict = district;;
		this.changed = true;
		return this;
	}
	public void mergeDistrict(District district){
		if(district != null) { setDistrict(district);}
	}
	
	
	public void clearDistrict(){
		setDistrict ( null );
		this.changed = true;
	}
	
	public void setRole(Role role){
		this.mRole = role;;
	}
	public Role getRole(){
		return this.mRole;
	}
	public User updateRole(Role role){
		this.mRole = role;;
		this.changed = true;
		return this;
	}
	public void mergeRole(Role role){
		if(role != null) { setRole(role);}
	}
	
	
	public void clearRole(){
		setRole ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public User updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<LeaveRecord> getLeaveRecordList(){
		if(this.mLeaveRecordList == null){
			this.mLeaveRecordList = new SmartList<LeaveRecord>();
			this.mLeaveRecordList.setListInternalName (LEAVE_RECORD_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLeaveRecordList;	
	}
	public  void setLeaveRecordList(SmartList<LeaveRecord> leaveRecordList){
		for( LeaveRecord leaveRecord:leaveRecordList){
			leaveRecord.setUser(this);
		}

		this.mLeaveRecordList = leaveRecordList;
		this.mLeaveRecordList.setListInternalName (LEAVE_RECORD_LIST );
		
	}
	
	public  void addLeaveRecord(LeaveRecord leaveRecord){
		leaveRecord.setUser(this);
		getLeaveRecordList().add(leaveRecord);
	}
	public  void addLeaveRecordList(SmartList<LeaveRecord> leaveRecordList){
		for( LeaveRecord leaveRecord:leaveRecordList){
			leaveRecord.setUser(this);
		}
		getLeaveRecordList().addAll(leaveRecordList);
	}
	public  void mergeLeaveRecordList(SmartList<LeaveRecord> leaveRecordList){
		if(leaveRecordList==null){
			return;
		}
		if(leaveRecordList.isEmpty()){
			return;
		}
		addLeaveRecordList( leaveRecordList );
		
	}
	public  LeaveRecord removeLeaveRecord(LeaveRecord leaveRecordIndex){
		
		int index = getLeaveRecordList().indexOf(leaveRecordIndex);
        if(index < 0){
        	String message = "LeaveRecord("+leaveRecordIndex.getId()+") with version='"+leaveRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LeaveRecord leaveRecord = getLeaveRecordList().get(index);        
        // leaveRecord.clearUser(); //disconnect with User
        leaveRecord.clearFromAll(); //disconnect with User
		
		boolean result = getLeaveRecordList().planToRemove(leaveRecord);
        if(!result){
        	String message = "LeaveRecord("+leaveRecordIndex.getId()+") with version='"+leaveRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return leaveRecord;
        
	
	}
	//断舍离
	public  void breakWithLeaveRecord(LeaveRecord leaveRecord){
		
		if(leaveRecord == null){
			return;
		}
		leaveRecord.setUser(null);
		//getLeaveRecordList().remove();
	
	}
	
	public  boolean hasLeaveRecord(LeaveRecord leaveRecord){
	
		return getLeaveRecordList().contains(leaveRecord);
  
	}
	
	public void copyLeaveRecordFrom(LeaveRecord leaveRecord) {

		LeaveRecord leaveRecordInList = findTheLeaveRecord(leaveRecord);
		LeaveRecord newLeaveRecord = new LeaveRecord();
		leaveRecordInList.copyTo(newLeaveRecord);
		newLeaveRecord.setVersion(0);//will trigger copy
		getLeaveRecordList().add(newLeaveRecord);
		addItemToFlexiableObject(COPIED_CHILD, newLeaveRecord);
	}
	
	public  LeaveRecord findTheLeaveRecord(LeaveRecord leaveRecord){
		
		int index =  getLeaveRecordList().indexOf(leaveRecord);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LeaveRecord("+leaveRecord.getId()+") with version='"+leaveRecord.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLeaveRecordList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLeaveRecordList(){
		getLeaveRecordList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDistrict(), internalType);
		addToEntityList(this, entityList, getRole(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLeaveRecordList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLeaveRecordList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
		appendKeyValuePair(result, AVATAR_PROPERTY, getAvatar());
		appendKeyValuePair(result, AGE_PROPERTY, getAge());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, DISTRICT_PROPERTY, getDistrict());
		appendKeyValuePair(result, ROLE_PROPERTY, getRole());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEAVE_RECORD_LIST, getLeaveRecordList());
		if(!getLeaveRecordList().isEmpty()){
			appendKeyValuePair(result, "leaveRecordCount", getLeaveRecordList().getTotalCount());
			appendKeyValuePair(result, "leaveRecordCurrentPageNumber", getLeaveRecordList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof User){
		
		
			User dest =(User)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMobile(getMobile());
			dest.setAvatar(getAvatar());
			dest.setAge(getAge());
			dest.setDescription(getDescription());
			dest.setDistrict(getDistrict());
			dest.setRole(getRole());
			dest.setVersion(getVersion());
			dest.setLeaveRecordList(getLeaveRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof User){
		
			
			User dest =(User)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeAvatar(getAvatar());
			dest.mergeAge(getAge());
			dest.mergeDescription(getDescription());
			dest.mergeDistrict(getDistrict());
			dest.mergeRole(getRole());
			dest.mergeVersion(getVersion());
			dest.mergeLeaveRecordList(getLeaveRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof User){
		
			
			User dest =(User)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeAvatar(getAvatar());
			dest.mergeAge(getAge());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getMobile(), getAvatar(), getAge(), getDescription(), getDistrict(), getRole(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("User{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		stringBuilder.append("\tavatar='"+getAvatar()+"';");
		stringBuilder.append("\tage='"+getAge()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		if(getDistrict() != null ){
 			stringBuilder.append("\tdistrict='District("+getDistrict().getId()+")';");
 		}
		if(getRole() != null ){
 			stringBuilder.append("\trole='Role("+getRole().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseAge(int incAge){
		updateAge(this.mAge +  incAge);
	}
	public void decreaseAge(int decAge){
		updateAge(this.mAge - decAge);
	}
	

}



package com.doublechain.flowable.leaverecord;

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
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;
import com.doublechain.flowable.platform.Platform;

@JsonSerialize(using = LeaveRecordSerializer.class)
public class LeaveRecord extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String USER_PROPERTY                  = "user"              ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String FROMDATE_PROPERTY              = "fromdate"          ;
	public static final String TODATE_PROPERTY                = "todate"            ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="LeaveRecord";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		User                	mUser               ;
	protected		LeaveRecordType     	mType               ;
	protected		Date                	mFromdate           ;
	protected		Date                	mTodate             ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	LeaveRecord(){
		// lazy load for all the properties
	}
	public 	static LeaveRecord withId(String id){
		LeaveRecord leaveRecord = new LeaveRecord();
		leaveRecord.setId(id);
		leaveRecord.setVersion(Integer.MAX_VALUE);
		return leaveRecord;
	}
	public 	static LeaveRecord refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUser( null );
		setType( null );
		setPlatform( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(FROMDATE_PROPERTY.equals(property)){
			changeFromdateProperty(newValueExpr);
		}
		if(TODATE_PROPERTY.equals(property)){
			changeTodateProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeFromdateProperty(String newValueExpr){
	
		Date oldValue = getFromdate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFromdate(newValue);
		this.onChangeProperty(FROMDATE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeTodateProperty(String newValueExpr){
	
		Date oldValue = getTodate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTodate(newValue);
		this.onChangeProperty(TODATE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(USER_PROPERTY.equals(property)){
			return getUser();
		}
		if(TYPE_PROPERTY.equals(property)){
			return getType();
		}
		if(FROMDATE_PROPERTY.equals(property)){
			return getFromdate();
		}
		if(TODATE_PROPERTY.equals(property)){
			return getTodate();
		}
		if(PLATFORM_PROPERTY.equals(property)){
			return getPlatform();
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
	public LeaveRecord updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setUser(User user){
		this.mUser = user;;
	}
	public User getUser(){
		return this.mUser;
	}
	public LeaveRecord updateUser(User user){
		this.mUser = user;;
		this.changed = true;
		return this;
	}
	public void mergeUser(User user){
		if(user != null) { setUser(user);}
	}
	
	
	public void clearUser(){
		setUser ( null );
		this.changed = true;
	}
	
	public void setType(LeaveRecordType type){
		this.mType = type;;
	}
	public LeaveRecordType getType(){
		return this.mType;
	}
	public LeaveRecord updateType(LeaveRecordType type){
		this.mType = type;;
		this.changed = true;
		return this;
	}
	public void mergeType(LeaveRecordType type){
		if(type != null) { setType(type);}
	}
	
	
	public void clearType(){
		setType ( null );
		this.changed = true;
	}
	
	public void setFromdate(Date fromdate){
		this.mFromdate = fromdate;;
	}
	public Date getFromdate(){
		return this.mFromdate;
	}
	public LeaveRecord updateFromdate(Date fromdate){
		this.mFromdate = fromdate;;
		this.changed = true;
		return this;
	}
	public void mergeFromdate(Date fromdate){
		setFromdate(fromdate);
	}
	
	
	public void setTodate(Date todate){
		this.mTodate = todate;;
	}
	public Date getTodate(){
		return this.mTodate;
	}
	public LeaveRecord updateTodate(Date todate){
		this.mTodate = todate;;
		this.changed = true;
		return this;
	}
	public void mergeTodate(Date todate){
		setTodate(todate);
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public LeaveRecord updatePlatform(Platform platform){
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
	public LeaveRecord updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getUser(), internalType);
		addToEntityList(this, entityList, getType(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, USER_PROPERTY, getUser());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, FROMDATE_PROPERTY, getFromdate());
		appendKeyValuePair(result, TODATE_PROPERTY, getTodate());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LeaveRecord){
		
		
			LeaveRecord dest =(LeaveRecord)baseDest;
		
			dest.setId(getId());
			dest.setUser(getUser());
			dest.setType(getType());
			dest.setFromdate(getFromdate());
			dest.setTodate(getTodate());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LeaveRecord){
		
			
			LeaveRecord dest =(LeaveRecord)baseDest;
		
			dest.mergeId(getId());
			dest.mergeUser(getUser());
			dest.mergeType(getType());
			dest.mergeFromdate(getFromdate());
			dest.mergeTodate(getTodate());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LeaveRecord){
		
			
			LeaveRecord dest =(LeaveRecord)baseDest;
		
			dest.mergeId(getId());
			dest.mergeFromdate(getFromdate());
			dest.mergeTodate(getTodate());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getUser(), getType(), getFromdate(), getTodate(), getPlatform(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LeaveRecord{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getUser() != null ){
 			stringBuilder.append("\tuser='User("+getUser().getId()+")';");
 		}
		if(getType() != null ){
 			stringBuilder.append("\ttype='LeaveRecordType("+getType().getId()+")';");
 		}
		stringBuilder.append("\tfromdate='"+getFromdate()+"';");
		stringBuilder.append("\ttodate='"+getTodate()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}



package com.doublechain.flowable.holydaysetting;

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
import com.doublechain.flowable.leaverecordtype.LeaveRecordType;

@JsonSerialize(using = HolydaySettingSerializer.class)
public class HolydaySetting extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String LEAVE_DAYS_PROPERTY            = "leaveDays"         ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="HolydaySetting";
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
	protected		LeaveRecordType     	mType               ;
	protected		int                 	mLeaveDays          ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	HolydaySetting(){
		// lazy load for all the properties
	}
	public 	static HolydaySetting withId(String id){
		HolydaySetting holydaySetting = new HolydaySetting();
		holydaySetting.setId(id);
		holydaySetting.setVersion(Integer.MAX_VALUE);
		return holydaySetting;
	}
	public 	static HolydaySetting refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setType( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(LEAVE_DAYS_PROPERTY.equals(property)){
			changeLeaveDaysProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLeaveDaysProperty(String newValueExpr){
	
		int oldValue = getLeaveDays();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLeaveDays(newValue);
		this.onChangeProperty(LEAVE_DAYS_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(TYPE_PROPERTY.equals(property)){
			return getType();
		}
		if(LEAVE_DAYS_PROPERTY.equals(property)){
			return getLeaveDays();
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
	public HolydaySetting updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setType(LeaveRecordType type){
		this.mType = type;;
	}
	public LeaveRecordType getType(){
		return this.mType;
	}
	public HolydaySetting updateType(LeaveRecordType type){
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
	
	public void setLeaveDays(int leaveDays){
		this.mLeaveDays = leaveDays;;
	}
	public int getLeaveDays(){
		return this.mLeaveDays;
	}
	public HolydaySetting updateLeaveDays(int leaveDays){
		this.mLeaveDays = leaveDays;;
		this.changed = true;
		return this;
	}
	public void mergeLeaveDays(int leaveDays){
		setLeaveDays(leaveDays);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public HolydaySetting updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getType(), internalType);

		
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
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, LEAVE_DAYS_PROPERTY, getLeaveDays());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof HolydaySetting){
		
		
			HolydaySetting dest =(HolydaySetting)baseDest;
		
			dest.setId(getId());
			dest.setType(getType());
			dest.setLeaveDays(getLeaveDays());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof HolydaySetting){
		
			
			HolydaySetting dest =(HolydaySetting)baseDest;
		
			dest.mergeId(getId());
			dest.mergeType(getType());
			dest.mergeLeaveDays(getLeaveDays());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof HolydaySetting){
		
			
			HolydaySetting dest =(HolydaySetting)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLeaveDays(getLeaveDays());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getType(), getLeaveDays(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("HolydaySetting{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getType() != null ){
 			stringBuilder.append("\ttype='LeaveRecordType("+getType().getId()+")';");
 		}
		stringBuilder.append("\tleaveDays='"+getLeaveDays()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseLeaveDays(int incLeaveDays){
		updateLeaveDays(this.mLeaveDays +  incLeaveDays);
	}
	public void decreaseLeaveDays(int decLeaveDays){
		updateLeaveDays(this.mLeaveDays - decLeaveDays);
	}
	

}



package com.doublechain.flowable.leaverecordtype;

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
import com.doublechain.flowable.holydaysetting.HolydaySetting;
import com.doublechain.flowable.leaverecord.LeaveRecord;

@JsonSerialize(using = LeaveRecordTypeSerializer.class)
public class LeaveRecordType extends BaseEntity implements  java.io.Serializable{

	public static final String ANNUAL_LEAVE = "ANNUAL_LEAVE";	// 年假
	public static final String SICK_LEACK = "SICK_LEACK";	// 病假
	public static final String PERSONAL_LEAVE = "PERSONAL_LEAVE";	// 事假
	public static final String MARRIAGE_HOLIDAY = "MARRIAGE_HOLIDAY";	// 婚假
	public static final String MATERNITY_LEAVE = "MATERNITY_LEAVE";	// 产假
	public static List<KeyValuePair> CODE_NAME_LIST;
	static {
		CODE_NAME_LIST = new ArrayList<>();

		CODE_NAME_LIST.add(new KeyValuePair(ANNUAL_LEAVE, "年假"));
		CODE_NAME_LIST.add(new KeyValuePair(SICK_LEACK, "病假"));
		CODE_NAME_LIST.add(new KeyValuePair(PERSONAL_LEAVE, "事假"));
		CODE_NAME_LIST.add(new KeyValuePair(MARRIAGE_HOLIDAY, "婚假"));
		CODE_NAME_LIST.add(new KeyValuePair(MATERNITY_LEAVE, "产假"));
	}
	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEAVE_RECORD_LIST                        = "leaveRecordList"   ;
	public static final String HOLYDAY_SETTING_LIST                     = "holydaySettingList";

	public static final String INTERNAL_TYPE="LeaveRecordType";
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
	
	
	protected		SmartList<LeaveRecord>	mLeaveRecordList    ;
	protected		SmartList<HolydaySetting>	mHolydaySettingList ;
	
		
	public 	LeaveRecordType(){
		// lazy load for all the properties
	}
	public 	static LeaveRecordType withId(String id){
		LeaveRecordType leaveRecordType = new LeaveRecordType();
		leaveRecordType.setId(id);
		leaveRecordType.setVersion(Integer.MAX_VALUE);
		return leaveRecordType;
	}
	public 	static LeaveRecordType refById(String id){
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
		if(LEAVE_RECORD_LIST.equals(property)){
			List<BaseEntity> list = getLeaveRecordList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(HOLYDAY_SETTING_LIST.equals(property)){
			List<BaseEntity> list = getHolydaySettingList().stream().map(item->item).collect(Collectors.toList());
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
	public LeaveRecordType updateId(String id){
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
	public LeaveRecordType updateName(String name){
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
	public LeaveRecordType updateCode(String code){
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
	public LeaveRecordType updateVersion(int version){
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
			leaveRecord.setType(this);
		}

		this.mLeaveRecordList = leaveRecordList;
		this.mLeaveRecordList.setListInternalName (LEAVE_RECORD_LIST );
		
	}
	
	public  void addLeaveRecord(LeaveRecord leaveRecord){
		leaveRecord.setType(this);
		getLeaveRecordList().add(leaveRecord);
	}
	public  void addLeaveRecordList(SmartList<LeaveRecord> leaveRecordList){
		for( LeaveRecord leaveRecord:leaveRecordList){
			leaveRecord.setType(this);
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
        // leaveRecord.clearType(); //disconnect with Type
        leaveRecord.clearFromAll(); //disconnect with Type
		
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
		leaveRecord.setType(null);
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
	
	
	


	public  SmartList<HolydaySetting> getHolydaySettingList(){
		if(this.mHolydaySettingList == null){
			this.mHolydaySettingList = new SmartList<HolydaySetting>();
			this.mHolydaySettingList.setListInternalName (HOLYDAY_SETTING_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mHolydaySettingList;	
	}
	public  void setHolydaySettingList(SmartList<HolydaySetting> holydaySettingList){
		for( HolydaySetting holydaySetting:holydaySettingList){
			holydaySetting.setType(this);
		}

		this.mHolydaySettingList = holydaySettingList;
		this.mHolydaySettingList.setListInternalName (HOLYDAY_SETTING_LIST );
		
	}
	
	public  void addHolydaySetting(HolydaySetting holydaySetting){
		holydaySetting.setType(this);
		getHolydaySettingList().add(holydaySetting);
	}
	public  void addHolydaySettingList(SmartList<HolydaySetting> holydaySettingList){
		for( HolydaySetting holydaySetting:holydaySettingList){
			holydaySetting.setType(this);
		}
		getHolydaySettingList().addAll(holydaySettingList);
	}
	public  void mergeHolydaySettingList(SmartList<HolydaySetting> holydaySettingList){
		if(holydaySettingList==null){
			return;
		}
		if(holydaySettingList.isEmpty()){
			return;
		}
		addHolydaySettingList( holydaySettingList );
		
	}
	public  HolydaySetting removeHolydaySetting(HolydaySetting holydaySettingIndex){
		
		int index = getHolydaySettingList().indexOf(holydaySettingIndex);
        if(index < 0){
        	String message = "HolydaySetting("+holydaySettingIndex.getId()+") with version='"+holydaySettingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        HolydaySetting holydaySetting = getHolydaySettingList().get(index);        
        // holydaySetting.clearType(); //disconnect with Type
        holydaySetting.clearFromAll(); //disconnect with Type
		
		boolean result = getHolydaySettingList().planToRemove(holydaySetting);
        if(!result){
        	String message = "HolydaySetting("+holydaySettingIndex.getId()+") with version='"+holydaySettingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return holydaySetting;
        
	
	}
	//断舍离
	public  void breakWithHolydaySetting(HolydaySetting holydaySetting){
		
		if(holydaySetting == null){
			return;
		}
		holydaySetting.setType(null);
		//getHolydaySettingList().remove();
	
	}
	
	public  boolean hasHolydaySetting(HolydaySetting holydaySetting){
	
		return getHolydaySettingList().contains(holydaySetting);
  
	}
	
	public void copyHolydaySettingFrom(HolydaySetting holydaySetting) {

		HolydaySetting holydaySettingInList = findTheHolydaySetting(holydaySetting);
		HolydaySetting newHolydaySetting = new HolydaySetting();
		holydaySettingInList.copyTo(newHolydaySetting);
		newHolydaySetting.setVersion(0);//will trigger copy
		getHolydaySettingList().add(newHolydaySetting);
		addItemToFlexiableObject(COPIED_CHILD, newHolydaySetting);
	}
	
	public  HolydaySetting findTheHolydaySetting(HolydaySetting holydaySetting){
		
		int index =  getHolydaySettingList().indexOf(holydaySetting);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "HolydaySetting("+holydaySetting.getId()+") with version='"+holydaySetting.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getHolydaySettingList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpHolydaySettingList(){
		getHolydaySettingList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLeaveRecordList(), internalType);
		collectFromList(this, entityList, getHolydaySettingList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLeaveRecordList());
		listOfList.add( getHolydaySettingList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEAVE_RECORD_LIST, getLeaveRecordList());
		if(!getLeaveRecordList().isEmpty()){
			appendKeyValuePair(result, "leaveRecordCount", getLeaveRecordList().getTotalCount());
			appendKeyValuePair(result, "leaveRecordCurrentPageNumber", getLeaveRecordList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, HOLYDAY_SETTING_LIST, getHolydaySettingList());
		if(!getHolydaySettingList().isEmpty()){
			appendKeyValuePair(result, "holydaySettingCount", getHolydaySettingList().getTotalCount());
			appendKeyValuePair(result, "holydaySettingCurrentPageNumber", getHolydaySettingList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LeaveRecordType){
		
		
			LeaveRecordType dest =(LeaveRecordType)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setVersion(getVersion());
			dest.setLeaveRecordList(getLeaveRecordList());
			dest.setHolydaySettingList(getHolydaySettingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LeaveRecordType){
		
			
			LeaveRecordType dest =(LeaveRecordType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeVersion(getVersion());
			dest.mergeLeaveRecordList(getLeaveRecordList());
			dest.mergeHolydaySettingList(getHolydaySettingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LeaveRecordType){
		
			
			LeaveRecordType dest =(LeaveRecordType)baseDest;
		
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

		stringBuilder.append("LeaveRecordType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


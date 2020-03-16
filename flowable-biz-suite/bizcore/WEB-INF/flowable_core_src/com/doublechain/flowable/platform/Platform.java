
package com.doublechain.flowable.platform;

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
import com.doublechain.flowable.province.Province;
import com.doublechain.flowable.district.District;
import com.doublechain.flowable.city.City;
import com.doublechain.flowable.leaverecord.LeaveRecord;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEAVE_RECORD_LIST                        = "leaveRecordList"   ;
	public static final String PROVINCE_LIST                            = "provinceList"      ;
	public static final String CITY_LIST                                = "cityList"          ;
	public static final String DISTRICT_LIST                            = "districtList"      ;

	public static final String INTERNAL_TYPE="Platform";
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
	protected		DateTime            	mFounded            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LeaveRecord>	mLeaveRecordList    ;
	protected		SmartList<Province> 	mProvinceList       ;
	protected		SmartList<City>     	mCityList           ;
	protected		SmartList<District> 	mDistrictList       ;
	
		
	public 	Platform(){
		// lazy load for all the properties
	}
	public 	static Platform withId(String id){
		Platform platform = new Platform();
		platform.setId(id);
		platform.setVersion(Integer.MAX_VALUE);
		return platform;
	}
	public 	static Platform refById(String id){
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
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
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
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
	
		DateTime oldValue = getFounded();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFounded(newValue);
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(LEAVE_RECORD_LIST.equals(property)){
			List<BaseEntity> list = getLeaveRecordList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(PROVINCE_LIST.equals(property)){
			List<BaseEntity> list = getProvinceList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CITY_LIST.equals(property)){
			List<BaseEntity> list = getCityList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(DISTRICT_LIST.equals(property)){
			List<BaseEntity> list = getDistrictList().stream().map(item->item).collect(Collectors.toList());
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
	public Platform updateId(String id){
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
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setFounded(DateTime founded){
		this.mFounded = founded;;
	}
	public DateTime getFounded(){
		return this.mFounded;
	}
	public Platform updateFounded(DateTime founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(DateTime founded){
		setFounded(founded);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
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
			leaveRecord.setPlatform(this);
		}

		this.mLeaveRecordList = leaveRecordList;
		this.mLeaveRecordList.setListInternalName (LEAVE_RECORD_LIST );
		
	}
	
	public  void addLeaveRecord(LeaveRecord leaveRecord){
		leaveRecord.setPlatform(this);
		getLeaveRecordList().add(leaveRecord);
	}
	public  void addLeaveRecordList(SmartList<LeaveRecord> leaveRecordList){
		for( LeaveRecord leaveRecord:leaveRecordList){
			leaveRecord.setPlatform(this);
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
        // leaveRecord.clearPlatform(); //disconnect with Platform
        leaveRecord.clearFromAll(); //disconnect with Platform
		
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
		leaveRecord.setPlatform(null);
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
	
	
	


	public  SmartList<Province> getProvinceList(){
		if(this.mProvinceList == null){
			this.mProvinceList = new SmartList<Province>();
			this.mProvinceList.setListInternalName (PROVINCE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProvinceList;	
	}
	public  void setProvinceList(SmartList<Province> provinceList){
		for( Province province:provinceList){
			province.setPlatform(this);
		}

		this.mProvinceList = provinceList;
		this.mProvinceList.setListInternalName (PROVINCE_LIST );
		
	}
	
	public  void addProvince(Province province){
		province.setPlatform(this);
		getProvinceList().add(province);
	}
	public  void addProvinceList(SmartList<Province> provinceList){
		for( Province province:provinceList){
			province.setPlatform(this);
		}
		getProvinceList().addAll(provinceList);
	}
	public  void mergeProvinceList(SmartList<Province> provinceList){
		if(provinceList==null){
			return;
		}
		if(provinceList.isEmpty()){
			return;
		}
		addProvinceList( provinceList );
		
	}
	public  Province removeProvince(Province provinceIndex){
		
		int index = getProvinceList().indexOf(provinceIndex);
        if(index < 0){
        	String message = "Province("+provinceIndex.getId()+") with version='"+provinceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Province province = getProvinceList().get(index);        
        // province.clearPlatform(); //disconnect with Platform
        province.clearFromAll(); //disconnect with Platform
		
		boolean result = getProvinceList().planToRemove(province);
        if(!result){
        	String message = "Province("+provinceIndex.getId()+") with version='"+provinceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return province;
        
	
	}
	//断舍离
	public  void breakWithProvince(Province province){
		
		if(province == null){
			return;
		}
		province.setPlatform(null);
		//getProvinceList().remove();
	
	}
	
	public  boolean hasProvince(Province province){
	
		return getProvinceList().contains(province);
  
	}
	
	public void copyProvinceFrom(Province province) {

		Province provinceInList = findTheProvince(province);
		Province newProvince = new Province();
		provinceInList.copyTo(newProvince);
		newProvince.setVersion(0);//will trigger copy
		getProvinceList().add(newProvince);
		addItemToFlexiableObject(COPIED_CHILD, newProvince);
	}
	
	public  Province findTheProvince(Province province){
		
		int index =  getProvinceList().indexOf(province);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Province("+province.getId()+") with version='"+province.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProvinceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProvinceList(){
		getProvinceList().clear();
	}
	
	
	


	public  SmartList<City> getCityList(){
		if(this.mCityList == null){
			this.mCityList = new SmartList<City>();
			this.mCityList.setListInternalName (CITY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCityList;	
	}
	public  void setCityList(SmartList<City> cityList){
		for( City city:cityList){
			city.setPlatform(this);
		}

		this.mCityList = cityList;
		this.mCityList.setListInternalName (CITY_LIST );
		
	}
	
	public  void addCity(City city){
		city.setPlatform(this);
		getCityList().add(city);
	}
	public  void addCityList(SmartList<City> cityList){
		for( City city:cityList){
			city.setPlatform(this);
		}
		getCityList().addAll(cityList);
	}
	public  void mergeCityList(SmartList<City> cityList){
		if(cityList==null){
			return;
		}
		if(cityList.isEmpty()){
			return;
		}
		addCityList( cityList );
		
	}
	public  City removeCity(City cityIndex){
		
		int index = getCityList().indexOf(cityIndex);
        if(index < 0){
        	String message = "City("+cityIndex.getId()+") with version='"+cityIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        City city = getCityList().get(index);        
        // city.clearPlatform(); //disconnect with Platform
        city.clearFromAll(); //disconnect with Platform
		
		boolean result = getCityList().planToRemove(city);
        if(!result){
        	String message = "City("+cityIndex.getId()+") with version='"+cityIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return city;
        
	
	}
	//断舍离
	public  void breakWithCity(City city){
		
		if(city == null){
			return;
		}
		city.setPlatform(null);
		//getCityList().remove();
	
	}
	
	public  boolean hasCity(City city){
	
		return getCityList().contains(city);
  
	}
	
	public void copyCityFrom(City city) {

		City cityInList = findTheCity(city);
		City newCity = new City();
		cityInList.copyTo(newCity);
		newCity.setVersion(0);//will trigger copy
		getCityList().add(newCity);
		addItemToFlexiableObject(COPIED_CHILD, newCity);
	}
	
	public  City findTheCity(City city){
		
		int index =  getCityList().indexOf(city);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "City("+city.getId()+") with version='"+city.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCityList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCityList(){
		getCityList().clear();
	}
	
	
	


	public  SmartList<District> getDistrictList(){
		if(this.mDistrictList == null){
			this.mDistrictList = new SmartList<District>();
			this.mDistrictList.setListInternalName (DISTRICT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mDistrictList;	
	}
	public  void setDistrictList(SmartList<District> districtList){
		for( District district:districtList){
			district.setPlatform(this);
		}

		this.mDistrictList = districtList;
		this.mDistrictList.setListInternalName (DISTRICT_LIST );
		
	}
	
	public  void addDistrict(District district){
		district.setPlatform(this);
		getDistrictList().add(district);
	}
	public  void addDistrictList(SmartList<District> districtList){
		for( District district:districtList){
			district.setPlatform(this);
		}
		getDistrictList().addAll(districtList);
	}
	public  void mergeDistrictList(SmartList<District> districtList){
		if(districtList==null){
			return;
		}
		if(districtList.isEmpty()){
			return;
		}
		addDistrictList( districtList );
		
	}
	public  District removeDistrict(District districtIndex){
		
		int index = getDistrictList().indexOf(districtIndex);
        if(index < 0){
        	String message = "District("+districtIndex.getId()+") with version='"+districtIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        District district = getDistrictList().get(index);        
        // district.clearPlatform(); //disconnect with Platform
        district.clearFromAll(); //disconnect with Platform
		
		boolean result = getDistrictList().planToRemove(district);
        if(!result){
        	String message = "District("+districtIndex.getId()+") with version='"+districtIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return district;
        
	
	}
	//断舍离
	public  void breakWithDistrict(District district){
		
		if(district == null){
			return;
		}
		district.setPlatform(null);
		//getDistrictList().remove();
	
	}
	
	public  boolean hasDistrict(District district){
	
		return getDistrictList().contains(district);
  
	}
	
	public void copyDistrictFrom(District district) {

		District districtInList = findTheDistrict(district);
		District newDistrict = new District();
		districtInList.copyTo(newDistrict);
		newDistrict.setVersion(0);//will trigger copy
		getDistrictList().add(newDistrict);
		addItemToFlexiableObject(COPIED_CHILD, newDistrict);
	}
	
	public  District findTheDistrict(District district){
		
		int index =  getDistrictList().indexOf(district);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "District("+district.getId()+") with version='"+district.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getDistrictList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpDistrictList(){
		getDistrictList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLeaveRecordList(), internalType);
		collectFromList(this, entityList, getProvinceList(), internalType);
		collectFromList(this, entityList, getCityList(), internalType);
		collectFromList(this, entityList, getDistrictList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLeaveRecordList());
		listOfList.add( getProvinceList());
		listOfList.add( getCityList());
		listOfList.add( getDistrictList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEAVE_RECORD_LIST, getLeaveRecordList());
		if(!getLeaveRecordList().isEmpty()){
			appendKeyValuePair(result, "leaveRecordCount", getLeaveRecordList().getTotalCount());
			appendKeyValuePair(result, "leaveRecordCurrentPageNumber", getLeaveRecordList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PROVINCE_LIST, getProvinceList());
		if(!getProvinceList().isEmpty()){
			appendKeyValuePair(result, "provinceCount", getProvinceList().getTotalCount());
			appendKeyValuePair(result, "provinceCurrentPageNumber", getProvinceList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CITY_LIST, getCityList());
		if(!getCityList().isEmpty()){
			appendKeyValuePair(result, "cityCount", getCityList().getTotalCount());
			appendKeyValuePair(result, "cityCurrentPageNumber", getCityList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, DISTRICT_LIST, getDistrictList());
		if(!getDistrictList().isEmpty()){
			appendKeyValuePair(result, "districtCount", getDistrictList().getTotalCount());
			appendKeyValuePair(result, "districtCurrentPageNumber", getDistrictList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setFounded(getFounded());
			dest.setVersion(getVersion());
			dest.setLeaveRecordList(getLeaveRecordList());
			dest.setProvinceList(getProvinceList());
			dest.setCityList(getCityList());
			dest.setDistrictList(getDistrictList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
			
			Platform dest =(Platform)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());
			dest.mergeLeaveRecordList(getLeaveRecordList());
			dest.mergeProvinceList(getProvinceList());
			dest.mergeCityList(getCityList());
			dest.mergeDistrictList(getDistrictList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
			
			Platform dest =(Platform)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getFounded(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}


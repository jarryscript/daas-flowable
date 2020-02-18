
package com.doublechain.flowable.platform;
import com.doublechain.flowable.CommonTokens;
import java.util.Map;
public class PlatformTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="platform";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected PlatformTokens(){
		//ensure not initialized outside the class
	}
	public  static  PlatformTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PlatformTokens tokens = new PlatformTokens(options);
		return tokens;
		
	}
	protected PlatformTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public PlatformTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PlatformTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PlatformTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PlatformTokens start(){
		return new PlatformTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PlatformTokens allTokens(){
		
		return start()
			.withLeaveRecordList()
			.withProvinceList()
			.withCityList()
			.withDistrictList();
	
	}
	public static PlatformTokens withoutListsTokens(){
		
		return start();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}
	
	public PlatformTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String LEAVE_RECORD_LIST = "leaveRecordList";
	public String getLeaveRecordList(){
		return LEAVE_RECORD_LIST;
	}
	public PlatformTokens withLeaveRecordList(){		
		addSimpleOptions(LEAVE_RECORD_LIST);
		return this;
	}
	public PlatformTokens analyzeLeaveRecordList(){		
		addSimpleOptions(LEAVE_RECORD_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLeaveRecordListEnabled(){		
		
		if(checkOptions(this.options(), LEAVE_RECORD_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromLeaveRecordList(String idsSeperatedWithComma){		
		addSimpleOptions(LEAVE_RECORD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int leaveRecordListSortCounter = 0;
	public PlatformTokens sortLeaveRecordListWith(String field, String descOrAsc){		
		addSortMoreOptions(LEAVE_RECORD_LIST,leaveRecordListSortCounter++, field, descOrAsc);
		return this;
	}
	private int leaveRecordListSearchCounter = 0;
	public PlatformTokens searchLeaveRecordListWith(String field, String verb, String value){		
		
		withLeaveRecordList();
		addSearchMoreOptions(LEAVE_RECORD_LIST,leaveRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens searchAllTextOfLeaveRecordList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(LEAVE_RECORD_LIST,leaveRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfLeaveRecordList(int rowsPerPage){		
		addSimpleOptions(LEAVE_RECORD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfLeaveRecordList(int currentPageNumber){		
		addSimpleOptions(LEAVE_RECORD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfLeaveRecordList(String[] columns){		
		addSimpleOptions(LEAVE_RECORD_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfLeaveRecordList(String[] columns){		
		addSimpleOptions(LEAVE_RECORD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String PROVINCE_LIST = "provinceList";
	public String getProvinceList(){
		return PROVINCE_LIST;
	}
	public PlatformTokens withProvinceList(){		
		addSimpleOptions(PROVINCE_LIST);
		return this;
	}
	public PlatformTokens analyzeProvinceList(){		
		addSimpleOptions(PROVINCE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeProvinceListEnabled(){		
		
		if(checkOptions(this.options(), PROVINCE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromProvinceList(String idsSeperatedWithComma){		
		addSimpleOptions(PROVINCE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int provinceListSortCounter = 0;
	public PlatformTokens sortProvinceListWith(String field, String descOrAsc){		
		addSortMoreOptions(PROVINCE_LIST,provinceListSortCounter++, field, descOrAsc);
		return this;
	}
	private int provinceListSearchCounter = 0;
	public PlatformTokens searchProvinceListWith(String field, String verb, String value){		
		
		withProvinceList();
		addSearchMoreOptions(PROVINCE_LIST,provinceListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens searchAllTextOfProvinceList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(PROVINCE_LIST,provinceListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfProvinceList(int rowsPerPage){		
		addSimpleOptions(PROVINCE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfProvinceList(int currentPageNumber){		
		addSimpleOptions(PROVINCE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfProvinceList(String[] columns){		
		addSimpleOptions(PROVINCE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfProvinceList(String[] columns){		
		addSimpleOptions(PROVINCE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CITY_LIST = "cityList";
	public String getCityList(){
		return CITY_LIST;
	}
	public PlatformTokens withCityList(){		
		addSimpleOptions(CITY_LIST);
		return this;
	}
	public PlatformTokens analyzeCityList(){		
		addSimpleOptions(CITY_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCityListEnabled(){		
		
		if(checkOptions(this.options(), CITY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromCityList(String idsSeperatedWithComma){		
		addSimpleOptions(CITY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int cityListSortCounter = 0;
	public PlatformTokens sortCityListWith(String field, String descOrAsc){		
		addSortMoreOptions(CITY_LIST,cityListSortCounter++, field, descOrAsc);
		return this;
	}
	private int cityListSearchCounter = 0;
	public PlatformTokens searchCityListWith(String field, String verb, String value){		
		
		withCityList();
		addSearchMoreOptions(CITY_LIST,cityListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens searchAllTextOfCityList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(CITY_LIST,cityListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfCityList(int rowsPerPage){		
		addSimpleOptions(CITY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfCityList(int currentPageNumber){		
		addSimpleOptions(CITY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfCityList(String[] columns){		
		addSimpleOptions(CITY_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfCityList(String[] columns){		
		addSimpleOptions(CITY_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String DISTRICT_LIST = "districtList";
	public String getDistrictList(){
		return DISTRICT_LIST;
	}
	public PlatformTokens withDistrictList(){		
		addSimpleOptions(DISTRICT_LIST);
		return this;
	}
	public PlatformTokens analyzeDistrictList(){		
		addSimpleOptions(DISTRICT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeDistrictListEnabled(){		
		
		if(checkOptions(this.options(), DISTRICT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromDistrictList(String idsSeperatedWithComma){		
		addSimpleOptions(DISTRICT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int districtListSortCounter = 0;
	public PlatformTokens sortDistrictListWith(String field, String descOrAsc){		
		addSortMoreOptions(DISTRICT_LIST,districtListSortCounter++, field, descOrAsc);
		return this;
	}
	private int districtListSearchCounter = 0;
	public PlatformTokens searchDistrictListWith(String field, String verb, String value){		
		
		withDistrictList();
		addSearchMoreOptions(DISTRICT_LIST,districtListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens searchAllTextOfDistrictList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(DISTRICT_LIST,districtListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfDistrictList(int rowsPerPage){		
		addSimpleOptions(DISTRICT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfDistrictList(int currentPageNumber){		
		addSimpleOptions(DISTRICT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfDistrictList(String[] columns){		
		addSimpleOptions(DISTRICT_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfDistrictList(String[] columns){		
		addSimpleOptions(DISTRICT_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfLeaveRecordList(verb, value);	
		searchAllTextOfProvinceList(verb, value);	
		searchAllTextOfCityList(verb, value);	
		searchAllTextOfDistrictList(verb, value);	
		return this;
	}
}


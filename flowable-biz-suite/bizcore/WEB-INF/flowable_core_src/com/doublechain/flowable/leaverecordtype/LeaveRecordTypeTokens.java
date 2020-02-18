
package com.doublechain.flowable.leaverecordtype;
import com.doublechain.flowable.CommonTokens;
import java.util.Map;
public class LeaveRecordTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="leaveRecordType";
	
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
	protected LeaveRecordTypeTokens(){
		//ensure not initialized outside the class
	}
	public  static  LeaveRecordTypeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		LeaveRecordTypeTokens tokens = new LeaveRecordTypeTokens(options);
		return tokens;
		
	}
	protected LeaveRecordTypeTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public LeaveRecordTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static LeaveRecordTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected LeaveRecordTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static LeaveRecordTypeTokens start(){
		return new LeaveRecordTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static LeaveRecordTypeTokens allTokens(){
		
		return start()
			.withLeaveRecordList()
			.withHolydaySettingList();
	
	}
	public static LeaveRecordTypeTokens withoutListsTokens(){
		
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
	
	public LeaveRecordTypeTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String LEAVE_RECORD_LIST = "leaveRecordList";
	public String getLeaveRecordList(){
		return LEAVE_RECORD_LIST;
	}
	public LeaveRecordTypeTokens withLeaveRecordList(){		
		addSimpleOptions(LEAVE_RECORD_LIST);
		return this;
	}
	public LeaveRecordTypeTokens analyzeLeaveRecordList(){		
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
	public LeaveRecordTypeTokens extractMoreFromLeaveRecordList(String idsSeperatedWithComma){		
		addSimpleOptions(LEAVE_RECORD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int leaveRecordListSortCounter = 0;
	public LeaveRecordTypeTokens sortLeaveRecordListWith(String field, String descOrAsc){		
		addSortMoreOptions(LEAVE_RECORD_LIST,leaveRecordListSortCounter++, field, descOrAsc);
		return this;
	}
	private int leaveRecordListSearchCounter = 0;
	public LeaveRecordTypeTokens searchLeaveRecordListWith(String field, String verb, String value){		
		
		withLeaveRecordList();
		addSearchMoreOptions(LEAVE_RECORD_LIST,leaveRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LeaveRecordTypeTokens searchAllTextOfLeaveRecordList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(LEAVE_RECORD_LIST,leaveRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LeaveRecordTypeTokens rowsPerPageOfLeaveRecordList(int rowsPerPage){		
		addSimpleOptions(LEAVE_RECORD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LeaveRecordTypeTokens currentPageNumberOfLeaveRecordList(int currentPageNumber){		
		addSimpleOptions(LEAVE_RECORD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public LeaveRecordTypeTokens retainColumnsOfLeaveRecordList(String[] columns){		
		addSimpleOptions(LEAVE_RECORD_LIST+"RetainColumns",columns);
		return this;
	}
	public LeaveRecordTypeTokens excludeColumnsOfLeaveRecordList(String[] columns){		
		addSimpleOptions(LEAVE_RECORD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String HOLYDAY_SETTING_LIST = "holydaySettingList";
	public String getHolydaySettingList(){
		return HOLYDAY_SETTING_LIST;
	}
	public LeaveRecordTypeTokens withHolydaySettingList(){		
		addSimpleOptions(HOLYDAY_SETTING_LIST);
		return this;
	}
	public LeaveRecordTypeTokens analyzeHolydaySettingList(){		
		addSimpleOptions(HOLYDAY_SETTING_LIST+".anaylze");
		return this;
	}
	public boolean analyzeHolydaySettingListEnabled(){		
		
		if(checkOptions(this.options(), HOLYDAY_SETTING_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public LeaveRecordTypeTokens extractMoreFromHolydaySettingList(String idsSeperatedWithComma){		
		addSimpleOptions(HOLYDAY_SETTING_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int holydaySettingListSortCounter = 0;
	public LeaveRecordTypeTokens sortHolydaySettingListWith(String field, String descOrAsc){		
		addSortMoreOptions(HOLYDAY_SETTING_LIST,holydaySettingListSortCounter++, field, descOrAsc);
		return this;
	}
	private int holydaySettingListSearchCounter = 0;
	public LeaveRecordTypeTokens searchHolydaySettingListWith(String field, String verb, String value){		
		
		withHolydaySettingList();
		addSearchMoreOptions(HOLYDAY_SETTING_LIST,holydaySettingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LeaveRecordTypeTokens searchAllTextOfHolydaySettingList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(HOLYDAY_SETTING_LIST,holydaySettingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public LeaveRecordTypeTokens rowsPerPageOfHolydaySettingList(int rowsPerPage){		
		addSimpleOptions(HOLYDAY_SETTING_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public LeaveRecordTypeTokens currentPageNumberOfHolydaySettingList(int currentPageNumber){		
		addSimpleOptions(HOLYDAY_SETTING_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public LeaveRecordTypeTokens retainColumnsOfHolydaySettingList(String[] columns){		
		addSimpleOptions(HOLYDAY_SETTING_LIST+"RetainColumns",columns);
		return this;
	}
	public LeaveRecordTypeTokens excludeColumnsOfHolydaySettingList(String[] columns){		
		addSimpleOptions(HOLYDAY_SETTING_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  LeaveRecordTypeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfLeaveRecordList(verb, value);	
		searchAllTextOfHolydaySettingList(verb, value);	
		return this;
	}
}


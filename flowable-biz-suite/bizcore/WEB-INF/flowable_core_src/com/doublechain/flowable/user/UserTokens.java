
package com.doublechain.flowable.user;
import com.doublechain.flowable.CommonTokens;
import java.util.Map;
public class UserTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="user";
	
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
	protected UserTokens(){
		//ensure not initialized outside the class
	}
	public  static  UserTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		UserTokens tokens = new UserTokens(options);
		return tokens;
		
	}
	protected UserTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public UserTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static UserTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected UserTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static UserTokens start(){
		return new UserTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static UserTokens allTokens(){
		
		return start()
			.withDistrict()
			.withRole()
			.withLeaveRecordList();
	
	}
	public static UserTokens withoutListsTokens(){
		
		return start()
			.withDistrict()
			.withRole();
	
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
	
	public UserTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String DISTRICT = "district";
	public String getDistrict(){
		return DISTRICT;
	}
	public UserTokens withDistrict(){		
		addSimpleOptions(DISTRICT);
		return this;
	}
	
	
	protected static final String ROLE = "role";
	public String getRole(){
		return ROLE;
	}
	public UserTokens withRole(){		
		addSimpleOptions(ROLE);
		return this;
	}
	
	
	protected static final String LEAVE_RECORD_LIST = "leaveRecordList";
	public String getLeaveRecordList(){
		return LEAVE_RECORD_LIST;
	}
	public UserTokens withLeaveRecordList(){		
		addSimpleOptions(LEAVE_RECORD_LIST);
		return this;
	}
	public UserTokens analyzeLeaveRecordList(){		
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
	public UserTokens extractMoreFromLeaveRecordList(String idsSeperatedWithComma){		
		addSimpleOptions(LEAVE_RECORD_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int leaveRecordListSortCounter = 0;
	public UserTokens sortLeaveRecordListWith(String field, String descOrAsc){		
		addSortMoreOptions(LEAVE_RECORD_LIST,leaveRecordListSortCounter++, field, descOrAsc);
		return this;
	}
	private int leaveRecordListSearchCounter = 0;
	public UserTokens searchLeaveRecordListWith(String field, String verb, String value){		
		
		withLeaveRecordList();
		addSearchMoreOptions(LEAVE_RECORD_LIST,leaveRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserTokens searchAllTextOfLeaveRecordList(String verb, String value){	
		String field = "id";
		addSearchMoreOptions(LEAVE_RECORD_LIST,leaveRecordListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public UserTokens rowsPerPageOfLeaveRecordList(int rowsPerPage){		
		addSimpleOptions(LEAVE_RECORD_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public UserTokens currentPageNumberOfLeaveRecordList(int currentPageNumber){		
		addSimpleOptions(LEAVE_RECORD_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public UserTokens retainColumnsOfLeaveRecordList(String[] columns){		
		addSimpleOptions(LEAVE_RECORD_LIST+"RetainColumns",columns);
		return this;
	}
	public UserTokens excludeColumnsOfLeaveRecordList(String[] columns){		
		addSimpleOptions(LEAVE_RECORD_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  UserTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfLeaveRecordList(verb, value);	
		return this;
	}
}


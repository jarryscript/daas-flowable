
package com.doublechain.flowable.district;
import com.doublechain.flowable.CommonTokens;
import java.util.Map;
public class DistrictTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="district";
	
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
	protected DistrictTokens(){
		//ensure not initialized outside the class
	}
	public  static  DistrictTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		DistrictTokens tokens = new DistrictTokens(options);
		return tokens;
		
	}
	protected DistrictTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public DistrictTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static DistrictTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected DistrictTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static DistrictTokens start(){
		return new DistrictTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static DistrictTokens allTokens(){
		
		return start()
			.withCity()
			.withPlatform()
			.withUserList();
	
	}
	public static DistrictTokens withoutListsTokens(){
		
		return start()
			.withCity()
			.withPlatform();
	
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
	
	public DistrictTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CITY = "city";
	public String getCity(){
		return CITY;
	}
	public DistrictTokens withCity(){		
		addSimpleOptions(CITY);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public DistrictTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String USER_LIST = "userList";
	public String getUserList(){
		return USER_LIST;
	}
	public DistrictTokens withUserList(){		
		addSimpleOptions(USER_LIST);
		return this;
	}
	public DistrictTokens analyzeUserList(){		
		addSimpleOptions(USER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUserListEnabled(){		
		
		if(checkOptions(this.options(), USER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public DistrictTokens extractMoreFromUserList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userListSortCounter = 0;
	public DistrictTokens sortUserListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_LIST,userListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userListSearchCounter = 0;
	public DistrictTokens searchUserListWith(String field, String verb, String value){		
		
		withUserList();
		addSearchMoreOptions(USER_LIST,userListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public DistrictTokens searchAllTextOfUserList(String verb, String value){	
		String field = "id|name|mobile|avatar|description";
		addSearchMoreOptions(USER_LIST,userListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public DistrictTokens rowsPerPageOfUserList(int rowsPerPage){		
		addSimpleOptions(USER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public DistrictTokens currentPageNumberOfUserList(int currentPageNumber){		
		addSimpleOptions(USER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public DistrictTokens retainColumnsOfUserList(String[] columns){		
		addSimpleOptions(USER_LIST+"RetainColumns",columns);
		return this;
	}
	public DistrictTokens excludeColumnsOfUserList(String[] columns){		
		addSimpleOptions(USER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  DistrictTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfUserList(verb, value);	
		return this;
	}
}


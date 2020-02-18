
package com.doublechain.flowable.role;
import com.doublechain.flowable.CommonTokens;
import java.util.Map;
public class RoleTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="role";
	
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
	protected RoleTokens(){
		//ensure not initialized outside the class
	}
	public  static  RoleTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RoleTokens tokens = new RoleTokens(options);
		return tokens;
		
	}
	protected RoleTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public RoleTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RoleTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RoleTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RoleTokens start(){
		return new RoleTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RoleTokens allTokens(){
		
		return start()
			.withUserList();
	
	}
	public static RoleTokens withoutListsTokens(){
		
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
	
	public RoleTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String USER_LIST = "userList";
	public String getUserList(){
		return USER_LIST;
	}
	public RoleTokens withUserList(){		
		addSimpleOptions(USER_LIST);
		return this;
	}
	public RoleTokens analyzeUserList(){		
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
	public RoleTokens extractMoreFromUserList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userListSortCounter = 0;
	public RoleTokens sortUserListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_LIST,userListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userListSearchCounter = 0;
	public RoleTokens searchUserListWith(String field, String verb, String value){		
		
		withUserList();
		addSearchMoreOptions(USER_LIST,userListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RoleTokens searchAllTextOfUserList(String verb, String value){	
		String field = "id|name|mobile|avatar|description";
		addSearchMoreOptions(USER_LIST,userListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public RoleTokens rowsPerPageOfUserList(int rowsPerPage){		
		addSimpleOptions(USER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RoleTokens currentPageNumberOfUserList(int currentPageNumber){		
		addSimpleOptions(USER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RoleTokens retainColumnsOfUserList(String[] columns){		
		addSimpleOptions(USER_LIST+"RetainColumns",columns);
		return this;
	}
	public RoleTokens excludeColumnsOfUserList(String[] columns){		
		addSimpleOptions(USER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  RoleTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfUserList(verb, value);	
		return this;
	}
}


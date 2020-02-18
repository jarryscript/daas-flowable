
package com.doublechain.flowable.leaverecord;
import com.doublechain.flowable.CommonTokens;
import java.util.Map;
public class LeaveRecordTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="leaveRecord";
	
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
	protected LeaveRecordTokens(){
		//ensure not initialized outside the class
	}
	public  static  LeaveRecordTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		LeaveRecordTokens tokens = new LeaveRecordTokens(options);
		return tokens;
		
	}
	protected LeaveRecordTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public LeaveRecordTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static LeaveRecordTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected LeaveRecordTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static LeaveRecordTokens start(){
		return new LeaveRecordTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static LeaveRecordTokens allTokens(){
		
		return start()
			.withUser()
			.withType()
			.withPlatform();
	
	}
	public static LeaveRecordTokens withoutListsTokens(){
		
		return start()
			.withUser()
			.withType()
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
	
	public LeaveRecordTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String USER = "user";
	public String getUser(){
		return USER;
	}
	public LeaveRecordTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String TYPE = "type";
	public String getType(){
		return TYPE;
	}
	public LeaveRecordTokens withType(){		
		addSimpleOptions(TYPE);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public LeaveRecordTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	
	public  LeaveRecordTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


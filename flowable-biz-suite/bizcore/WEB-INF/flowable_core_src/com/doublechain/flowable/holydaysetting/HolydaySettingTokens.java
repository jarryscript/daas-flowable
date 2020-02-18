
package com.doublechain.flowable.holydaysetting;
import com.doublechain.flowable.CommonTokens;
import java.util.Map;
public class HolydaySettingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="holydaySetting";
	
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
	protected HolydaySettingTokens(){
		//ensure not initialized outside the class
	}
	public  static  HolydaySettingTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		HolydaySettingTokens tokens = new HolydaySettingTokens(options);
		return tokens;
		
	}
	protected HolydaySettingTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public HolydaySettingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static HolydaySettingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected HolydaySettingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static HolydaySettingTokens start(){
		return new HolydaySettingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static HolydaySettingTokens allTokens(){
		
		return start()
			.withType();
	
	}
	public static HolydaySettingTokens withoutListsTokens(){
		
		return start()
			.withType();
	
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
	
	public HolydaySettingTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String TYPE = "type";
	public String getType(){
		return TYPE;
	}
	public HolydaySettingTokens withType(){		
		addSimpleOptions(TYPE);
		return this;
	}
	
	
	
	public  HolydaySettingTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}


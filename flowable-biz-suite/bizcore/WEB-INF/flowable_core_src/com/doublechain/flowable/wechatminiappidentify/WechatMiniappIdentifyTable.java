
package com.doublechain.flowable.wechatminiappidentify;
import com.doublechain.flowable.AccessKey;


public class WechatMiniappIdentifyTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="wechat_miniapp_identify_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_OPEN_ID = "open_id";
	static final String COLUMN_APP_ID = "app_id";
	static final String COLUMN_SEC_USER = "sec_user";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_LAST_LOGIN_TIME = "last_login_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_OPEN_ID,COLUMN_APP_ID,COLUMN_SEC_USER,COLUMN_CREATE_TIME,COLUMN_LAST_LOGIN_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_OPEN_ID,COLUMN_APP_ID,COLUMN_SEC_USER,COLUMN_CREATE_TIME,COLUMN_LAST_LOGIN_TIME};
	
	
}











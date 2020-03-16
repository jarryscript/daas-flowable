package com.doublechain.flowable.wechatminiappidentify;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.flowable.FlowableObjectPlainCustomSerializer;
public class WechatMiniappIdentifySerializer extends FlowableObjectPlainCustomSerializer<WechatMiniappIdentify>{

	@Override
	public void serialize(WechatMiniappIdentify wechatMiniappIdentify, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, wechatMiniappIdentify, provider);
		
	}
}









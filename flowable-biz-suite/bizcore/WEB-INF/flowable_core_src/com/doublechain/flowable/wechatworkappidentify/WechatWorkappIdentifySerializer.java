package com.doublechain.flowable.wechatworkappidentify;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.flowable.FlowableObjectPlainCustomSerializer;
public class WechatWorkappIdentifySerializer extends FlowableObjectPlainCustomSerializer<WechatWorkappIdentify>{

	@Override
	public void serialize(WechatWorkappIdentify wechatWorkappIdentify, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, wechatWorkappIdentify, provider);
		
	}
}



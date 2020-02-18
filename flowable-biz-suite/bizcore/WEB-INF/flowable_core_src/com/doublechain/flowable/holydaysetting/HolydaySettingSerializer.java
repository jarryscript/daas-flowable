package com.doublechain.flowable.holydaysetting;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.flowable.FlowableObjectPlainCustomSerializer;
public class HolydaySettingSerializer extends FlowableObjectPlainCustomSerializer<HolydaySetting>{

	@Override
	public void serialize(HolydaySetting holydaySetting, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, holydaySetting, provider);
		
	}
}



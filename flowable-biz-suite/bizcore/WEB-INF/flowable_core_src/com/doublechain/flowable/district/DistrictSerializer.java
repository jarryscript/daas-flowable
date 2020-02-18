package com.doublechain.flowable.district;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.flowable.FlowableObjectPlainCustomSerializer;
public class DistrictSerializer extends FlowableObjectPlainCustomSerializer<District>{

	@Override
	public void serialize(District district, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, district, provider);
		
	}
}



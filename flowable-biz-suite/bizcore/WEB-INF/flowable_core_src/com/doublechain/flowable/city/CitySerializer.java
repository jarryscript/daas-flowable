package com.doublechain.flowable.city;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.flowable.FlowableObjectPlainCustomSerializer;
public class CitySerializer extends FlowableObjectPlainCustomSerializer<City>{

	@Override
	public void serialize(City city, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, city, provider);
		
	}
}



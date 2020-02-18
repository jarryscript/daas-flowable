package com.doublechain.flowable.leaverecord;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.flowable.FlowableObjectPlainCustomSerializer;
public class LeaveRecordSerializer extends FlowableObjectPlainCustomSerializer<LeaveRecord>{

	@Override
	public void serialize(LeaveRecord leaveRecord, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, leaveRecord, provider);
		
	}
}



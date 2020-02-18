package com.doublechain.flowable.leaverecordtype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechain.flowable.FlowableObjectPlainCustomSerializer;
public class LeaveRecordTypeSerializer extends FlowableObjectPlainCustomSerializer<LeaveRecordType>{

	@Override
	public void serialize(LeaveRecordType leaveRecordType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, leaveRecordType, provider);
		
	}
}



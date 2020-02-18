
package com.doublechain.flowable.district;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class DistrictManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public DistrictManagerException(String string) {
		super(string);
	}
	public DistrictManagerException(Message message) {
		super(message);
	}
	public DistrictManagerException(List<Message> messageList) {
		super(messageList);
	}

}



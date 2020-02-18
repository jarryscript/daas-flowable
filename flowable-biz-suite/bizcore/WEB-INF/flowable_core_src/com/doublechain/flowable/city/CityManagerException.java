
package com.doublechain.flowable.city;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class CityManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public CityManagerException(String string) {
		super(string);
	}
	public CityManagerException(Message message) {
		super(message);
	}
	public CityManagerException(List<Message> messageList) {
		super(messageList);
	}

}



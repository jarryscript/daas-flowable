
package com.doublechain.flowable.province;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class ProvinceManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public ProvinceManagerException(String string) {
		super(string);
	}
	public ProvinceManagerException(Message message) {
		super(message);
	}
	public ProvinceManagerException(List<Message> messageList) {
		super(messageList);
	}

}



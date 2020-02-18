
package com.doublechain.flowable.user;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class UserManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public UserManagerException(String string) {
		super(string);
	}
	public UserManagerException(Message message) {
		super(message);
	}
	public UserManagerException(List<Message> messageList) {
		super(messageList);
	}

}



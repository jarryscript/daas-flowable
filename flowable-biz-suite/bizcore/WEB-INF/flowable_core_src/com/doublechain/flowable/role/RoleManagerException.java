
package com.doublechain.flowable.role;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class RoleManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public RoleManagerException(String string) {
		super(string);
	}
	public RoleManagerException(Message message) {
		super(message);
	}
	public RoleManagerException(List<Message> messageList) {
		super(messageList);
	}

}



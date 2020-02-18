
package com.doublechain.flowable.formmessage;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class FormMessageManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public FormMessageManagerException(String string) {
		super(string);
	}
	public FormMessageManagerException(Message message) {
		super(message);
	}
	public FormMessageManagerException(List<Message> messageList) {
		super(messageList);
	}

}



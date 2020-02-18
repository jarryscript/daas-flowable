
package com.doublechain.flowable.quicklink;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class QuickLinkManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public QuickLinkManagerException(String string) {
		super(string);
	}
	public QuickLinkManagerException(Message message) {
		super(message);
	}
	public QuickLinkManagerException(List<Message> messageList) {
		super(messageList);
	}

}



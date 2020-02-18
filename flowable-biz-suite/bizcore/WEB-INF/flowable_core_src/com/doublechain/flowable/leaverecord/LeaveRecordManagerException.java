
package com.doublechain.flowable.leaverecord;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class LeaveRecordManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public LeaveRecordManagerException(String string) {
		super(string);
	}
	public LeaveRecordManagerException(Message message) {
		super(message);
	}
	public LeaveRecordManagerException(List<Message> messageList) {
		super(messageList);
	}

}



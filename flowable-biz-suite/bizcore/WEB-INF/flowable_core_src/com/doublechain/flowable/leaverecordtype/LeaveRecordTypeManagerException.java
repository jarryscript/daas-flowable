
package com.doublechain.flowable.leaverecordtype;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class LeaveRecordTypeManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public LeaveRecordTypeManagerException(String string) {
		super(string);
	}
	public LeaveRecordTypeManagerException(Message message) {
		super(message);
	}
	public LeaveRecordTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}



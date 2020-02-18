
package com.doublechain.flowable.candidateelement;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class CandidateElementManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public CandidateElementManagerException(String string) {
		super(string);
	}
	public CandidateElementManagerException(Message message) {
		super(message);
	}
	public CandidateElementManagerException(List<Message> messageList) {
		super(messageList);
	}

}



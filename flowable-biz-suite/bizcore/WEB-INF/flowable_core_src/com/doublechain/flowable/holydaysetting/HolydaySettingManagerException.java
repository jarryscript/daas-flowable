
package com.doublechain.flowable.holydaysetting;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class HolydaySettingManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public HolydaySettingManagerException(String string) {
		super(string);
	}
	public HolydaySettingManagerException(Message message) {
		super(message);
	}
	public HolydaySettingManagerException(List<Message> messageList) {
		super(messageList);
	}

}



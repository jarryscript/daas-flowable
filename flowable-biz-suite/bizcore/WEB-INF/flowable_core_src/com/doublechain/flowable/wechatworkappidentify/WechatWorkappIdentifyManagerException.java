
package com.doublechain.flowable.wechatworkappidentify;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class WechatWorkappIdentifyManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public WechatWorkappIdentifyManagerException(String string) {
		super(string);
	}
	public WechatWorkappIdentifyManagerException(Message message) {
		super(message);
	}
	public WechatWorkappIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}



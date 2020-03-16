
package com.doublechain.flowable.wechatminiappidentify;
//import com.doublechain.flowable.EntityNotFoundException;
import com.doublechain.flowable.FlowableException;
import com.doublechain.flowable.Message;
import java.util.List;

public class WechatMiniappIdentifyManagerException extends FlowableException {
	private static final long serialVersionUID = 1L;
	public WechatMiniappIdentifyManagerException(String string) {
		super(string);
	}
	public WechatMiniappIdentifyManagerException(Message message) {
		super(message);
	}
	public WechatMiniappIdentifyManagerException(List<Message> messageList) {
		super(messageList);
	}

}











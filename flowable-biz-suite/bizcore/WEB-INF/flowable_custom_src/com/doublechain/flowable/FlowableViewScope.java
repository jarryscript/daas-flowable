package com.doublechain.flowable;


import com.terapico.caf.viewpage.SerializeScope;

public class FlowableViewScope extends FlowableBaseViewScope{

	static {
		// 定制化本项目的序列化scope的代码放在这里
		System.out.println("**************************************************************\n定制序列化\n");
	}
	
	protected static FlowableViewScope instance = null;
	public static FlowableViewScope getInstance() {
		if (instance != null) {
			return instance;
		}
		synchronized (FlowableViewScope.class) {
			instance = new FlowableViewScope();
		}
		return instance;
	}
}








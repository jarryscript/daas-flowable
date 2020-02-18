package com.doublechain.flowable;

import com.terapico.caf.Password;
import com.terapico.caf.baseelement.LoginParam;

public class LoginParams extends LoginParam {
	private Password password;

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}
	
	
	
}

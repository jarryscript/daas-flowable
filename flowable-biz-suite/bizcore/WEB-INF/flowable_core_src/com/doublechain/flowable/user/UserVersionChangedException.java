
package com.doublechain.flowable.user;
import com.doublechain.flowable.EntityNotFoundException;

public class UserVersionChangedException extends UserManagerException {
	private static final long serialVersionUID = 1L;
	public UserVersionChangedException(String string) {
		super(string);
	}


}



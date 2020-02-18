
package com.doublechain.flowable.user;
import com.doublechain.flowable.EntityNotFoundException;
public class UserNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public UserNotFoundException(String string) {
		super(string);
	}

}


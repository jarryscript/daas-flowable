
package com.doublechain.flowable.userdomain;
import com.doublechain.flowable.EntityNotFoundException;
public class UserDomainNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public UserDomainNotFoundException(String string) {
		super(string);
	}

}


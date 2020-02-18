
package com.doublechain.flowable.objectaccess;
import com.doublechain.flowable.EntityNotFoundException;
public class ObjectAccessNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessNotFoundException(String string) {
		super(string);
	}

}


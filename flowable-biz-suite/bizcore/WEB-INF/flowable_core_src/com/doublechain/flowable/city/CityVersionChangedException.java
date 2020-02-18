
package com.doublechain.flowable.city;
import com.doublechain.flowable.EntityNotFoundException;

public class CityVersionChangedException extends CityManagerException {
	private static final long serialVersionUID = 1L;
	public CityVersionChangedException(String string) {
		super(string);
	}


}



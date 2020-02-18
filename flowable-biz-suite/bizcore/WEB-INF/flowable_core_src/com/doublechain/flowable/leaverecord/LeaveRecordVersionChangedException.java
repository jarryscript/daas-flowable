
package com.doublechain.flowable.leaverecord;
import com.doublechain.flowable.EntityNotFoundException;

public class LeaveRecordVersionChangedException extends LeaveRecordManagerException {
	private static final long serialVersionUID = 1L;
	public LeaveRecordVersionChangedException(String string) {
		super(string);
	}


}



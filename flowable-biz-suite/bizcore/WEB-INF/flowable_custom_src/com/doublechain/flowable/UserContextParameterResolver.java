package com.doublechain.flowable;

import org.flowable.common.engine.api.variable.VariableContainer;
import org.flowable.common.engine.impl.el.VariableContainerELResolver;

public class UserContextParameterResolver extends VariableContainerELResolver {

	public UserContextParameterResolver(VariableContainer variableContainer) {
		super(variableContainer);
	}

//	@Override
//	public Object getValue(ELContext context, Object base, Object property) {
//		 if (base == null && "departmentAssignee".equals(property) && variableContainer instanceof ExecutionEntity) {
//	            Object departmentId = variableContainer.getVariable("departmentId");
//	            if (departmentId == null) {
//	                throw new RuntimeException("departmentId was not found in execution " + ((ExecutionEntity) variableContainer).getId());
//	            }
//	            context.setPropertyResolved(true);
//	            return getDepartmentAssignee(departmentId);
//	        }
//	        return null;
//	}
}

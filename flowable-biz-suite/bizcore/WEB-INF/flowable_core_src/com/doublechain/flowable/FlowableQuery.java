package com.doublechain.flowable;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class FlowableQuery extends BaseQuery {
	
	public FlowableQuery(Class startType, String ... pStart) {
        super(startType, pStart);
        super.setProject("flowable");
  }

  public FlowableQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}














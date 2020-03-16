
package com.doublechain.flowable.candidateelement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface CandidateElementManager extends BaseManager{

		

	public CandidateElement createCandidateElement(FlowableUserContext userContext, String name,String type,String image,String containerId) throws Exception;	
	public CandidateElement updateCandidateElement(FlowableUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateElement loadCandidateElement(FlowableUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception;
	public CandidateElement internalSaveCandidateElement(FlowableUserContext userContext, CandidateElement candidateElement) throws Exception;
	public CandidateElement internalSaveCandidateElement(FlowableUserContext userContext, CandidateElement candidateElement,Map<String,Object>option) throws Exception;
	
	public CandidateElement transferToAnotherContainer(FlowableUserContext userContext, String candidateElementId, String anotherContainerId)  throws Exception;
 

	public void delete(FlowableUserContext userContext, String candidateElementId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, CandidateElement newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	


	public Object listByContainer(FlowableUserContext userContext,String containerId) throws Exception;
	public Object listPageByContainer(FlowableUserContext userContext,String containerId, int start, int count) throws Exception;
  

}



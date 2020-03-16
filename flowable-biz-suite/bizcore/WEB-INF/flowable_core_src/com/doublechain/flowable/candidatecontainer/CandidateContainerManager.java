
package com.doublechain.flowable.candidatecontainer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechain.flowable.FlowableUserContext;
import com.doublechain.flowable.BaseEntity;
import com.doublechain.flowable.BaseManager;
import com.doublechain.flowable.SmartList;

public interface CandidateContainerManager extends BaseManager{

		

	public CandidateContainer createCandidateContainer(FlowableUserContext userContext, String name) throws Exception;	
	public CandidateContainer updateCandidateContainer(FlowableUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateContainer loadCandidateContainer(FlowableUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(FlowableUserContext userContext, CandidateContainer candidateContainer) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(FlowableUserContext userContext, CandidateContainer candidateContainer,Map<String,Object>option) throws Exception;
	


	public void delete(FlowableUserContext userContext, String candidateContainerId, int version) throws Exception;
	public int deleteAll(FlowableUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(FlowableUserContext userContext, CandidateContainer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  CandidateElementManager getCandidateElementManager(FlowableUserContext userContext, String candidateContainerId, String name, String type, String image ,String [] tokensExpr)  throws Exception;
	
	public  CandidateContainer addCandidateElement(FlowableUserContext userContext, String candidateContainerId, String name, String type, String image , String [] tokensExpr)  throws Exception;
	public  CandidateContainer removeCandidateElement(FlowableUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion,String [] tokensExpr)  throws Exception;
	public  CandidateContainer updateCandidateElement(FlowableUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}



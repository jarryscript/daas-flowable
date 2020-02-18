
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}leaveRecordManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}leaveRecordManager/loadLeaveRecord/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateUser = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}leaveRecordManager/requestCandidateUser/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherUser = (id, parameters) => {
  const url = `${PREFIX}leaveRecordManager/transferToAnotherUser/id/anotherUserId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}leaveRecordManager/requestCandidateType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherType = (id, parameters) => {
  const url = `${PREFIX}leaveRecordManager/transferToAnotherType/id/anotherTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePlatform = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}leaveRecordManager/requestCandidatePlatform/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPlatform = (id, parameters) => {
  const url = `${PREFIX}leaveRecordManager/transferToAnotherPlatform/id/anotherPlatformId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}leaveRecordService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}leaveRecordService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}leaveRecordService/process/`,
    data,
  })
}

const LeaveRecordService = { view,
  load,
  requestCandidateUser,
  requestCandidateType,
  requestCandidatePlatform,
  transferToAnotherUser,
  transferToAnotherType,
  transferToAnotherPlatform, listFunctions, saveRequest, processRequest}
export default LeaveRecordService



import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}userManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}userManager/loadUser/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateDistrict = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userManager/requestCandidateDistrict/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDistrict = (id, parameters) => {
  const url = `${PREFIX}userManager/transferToAnotherDistrict/id/anotherDistrictId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateRole = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}userManager/requestCandidateRole/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherRole = (id, parameters) => {
  const url = `${PREFIX}userManager/transferToAnotherRole/id/anotherRoleId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addLeaveRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}userManager/addLeaveRecord/userId/typeId/fromdate/todate/platformId/tokensExpr/`
  const userId = targetObjectId
  const requestParameters = { ...parameters, userId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLeaveRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}userManager/updateLeaveRecordProperties/userId/id/fromdate/todate/tokensExpr/`
  const userId = targetObjectId
  const requestParameters = { ...parameters, userId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLeaveRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userManager/removeLeaveRecordList/userId/leaveRecordIds/tokensExpr/`
  const requestParameters = { ...parameters, userId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}userService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}userService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}userService/process/`,
    data,
  })
}

const UserService = { view,
  load,
  addLeaveRecord,
  updateLeaveRecord,
  removeLeaveRecordList,
  requestCandidateDistrict,
  requestCandidateRole,
  transferToAnotherDistrict,
  transferToAnotherRole, listFunctions, saveRequest, processRequest}
export default UserService


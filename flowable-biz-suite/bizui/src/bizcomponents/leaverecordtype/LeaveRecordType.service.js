
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}leaveRecordTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}leaveRecordTypeManager/loadLeaveRecordType/${targetObjectId}/${parametersExpr}/`,
  })
}







const addLeaveRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}leaveRecordTypeManager/addLeaveRecord/leaveRecordTypeId/userId/fromdate/todate/platformId/tokensExpr/`
  const leaveRecordTypeId = targetObjectId
  const requestParameters = { ...parameters, leaveRecordTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLeaveRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}leaveRecordTypeManager/updateLeaveRecordProperties/leaveRecordTypeId/id/fromdate/todate/tokensExpr/`
  const leaveRecordTypeId = targetObjectId
  const requestParameters = { ...parameters, leaveRecordTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLeaveRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}leaveRecordTypeManager/removeLeaveRecordList/leaveRecordTypeId/leaveRecordIds/tokensExpr/`
  const requestParameters = { ...parameters, leaveRecordTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addHolydaySetting = (targetObjectId, parameters) => {
  const url = `${PREFIX}leaveRecordTypeManager/addHolydaySetting/leaveRecordTypeId/leaveDays/tokensExpr/`
  const leaveRecordTypeId = targetObjectId
  const requestParameters = { ...parameters, leaveRecordTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateHolydaySetting = (targetObjectId, parameters) => {
  const url = `${PREFIX}leaveRecordTypeManager/updateHolydaySettingProperties/leaveRecordTypeId/id/leaveDays/tokensExpr/`
  const leaveRecordTypeId = targetObjectId
  const requestParameters = { ...parameters, leaveRecordTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeHolydaySettingList = (targetObjectId, parameters) => {
  const url = `${PREFIX}leaveRecordTypeManager/removeHolydaySettingList/leaveRecordTypeId/holydaySettingIds/tokensExpr/`
  const requestParameters = { ...parameters, leaveRecordTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}leaveRecordTypeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}leaveRecordTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}leaveRecordTypeService/process/`,
    data,
  })
}

const LeaveRecordTypeService = { view,
  load,
  addLeaveRecord,
  addHolydaySetting,
  updateLeaveRecord,
  updateHolydaySetting,
  removeLeaveRecordList,
  removeHolydaySettingList, listFunctions, saveRequest, processRequest}
export default LeaveRecordTypeService


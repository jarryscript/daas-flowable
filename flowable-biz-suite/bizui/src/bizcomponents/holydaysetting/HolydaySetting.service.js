
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}holydaySettingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}holydaySettingManager/loadHolydaySetting/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}holydaySettingManager/requestCandidateType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherType = (id, parameters) => {
  const url = `${PREFIX}holydaySettingManager/transferToAnotherType/id/anotherTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}holydaySettingService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}holydaySettingService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}holydaySettingService/process/`,
    data,
  })
}

const HolydaySettingService = { view,
  load,
  requestCandidateType,
  transferToAnotherType, listFunctions, saveRequest, processRequest}
export default HolydaySettingService


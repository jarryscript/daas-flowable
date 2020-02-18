
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addLeaveRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addLeaveRecord/platformId/userId/typeId/fromdate/todate/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLeaveRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateLeaveRecordProperties/platformId/id/fromdate/todate/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLeaveRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeLeaveRecordList/platformId/leaveRecordIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addProvince = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addProvince/platformId/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProvince = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateProvinceProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProvinceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeProvinceList/platformId/provinceIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addCity = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addCity/platformId/name/provinceId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCity = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateCityProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCityList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeCityList/platformId/cityIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addDistrict = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addDistrict/platformId/name/cityId/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateDistrict = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateDistrictProperties/platformId/id/name/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeDistrictList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeDistrictList/platformId/districtIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}platformService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}platformService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}platformService/process/`,
    data,
  })
}

const PlatformService = { view,
  load,
  addLeaveRecord,
  addProvince,
  addCity,
  addDistrict,
  updateLeaveRecord,
  updateProvince,
  updateCity,
  updateDistrict,
  removeLeaveRecordList,
  removeProvinceList,
  removeCityList,
  removeDistrictList, listFunctions, saveRequest, processRequest}
export default PlatformService


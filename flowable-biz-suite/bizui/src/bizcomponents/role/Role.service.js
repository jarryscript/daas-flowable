
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}roleManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}roleManager/loadRole/${targetObjectId}/${parametersExpr}/`,
  })
}







const addUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}roleManager/addUser/roleId/name/mobile/avatar/age/description/districtId/tokensExpr/`
  const roleId = targetObjectId
  const requestParameters = { ...parameters, roleId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}roleManager/updateUserProperties/roleId/id/name/mobile/avatar/age/description/tokensExpr/`
  const roleId = targetObjectId
  const requestParameters = { ...parameters, roleId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserList = (targetObjectId, parameters) => {
  const url = `${PREFIX}roleManager/removeUserList/roleId/userIds/tokensExpr/`
  const requestParameters = { ...parameters, roleId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}roleService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}roleService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}roleService/process/`,
    data,
  })
}

const RoleService = { view,
  load,
  addUser,
  updateUser,
  removeUserList, listFunctions, saveRequest, processRequest}
export default RoleService


import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList

const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName: window.trans('user'), menuFor: "user",
  		subItems: [
  {name: 'leaveRecordList', displayName: window.mtrans('leave_record','user.leave_record_list',false), type:'leaveRecord',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('user'), menuFor: "user",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('user.id'),
  name: window.trans('user.name'),
  mobile: window.trans('user.mobile'),
  avatar: window.trans('user.avatar'),
  age: window.trans('user.age'),
  description: window.trans('user.description'),
  district: window.trans('user.district'),
  role: window.trans('user.role'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'user') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.avatar, debugtype: 'string', dataIndex: 'avatar', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.age, debugtype: 'int', dataIndex: 'age', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string_longtext', dataIndex: 'description', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.district, dataIndex: 'district', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.role, dataIndex: 'role', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(user, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={user.id}>
	
      <DescriptionList  key={user.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{user.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{user.name}</Description> 
        <Description term={fieldLabels.mobile} style={{wordBreak: 'break-all'}}>{user.mobile}</Description> 
        <Description term={fieldLabels.avatar} style={{wordBreak: 'break-all'}}>{user.avatar}</Description> 
        <Description term={fieldLabels.age}><div style={{"color":"red"}}>{user.age}</div></Description> 
        <Description term={fieldLabels.district}><div>{user.district==null?appLocaleName(userContext,"NotAssigned"):`${user.district.displayName}(${user.district.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobile, avatar, age, districtId, roleId, description} = formValuesToPack
	const district = {id: districtId, version: 2^31}
	const role = {id: roleId, version: 2^31}
	const data = {name, mobile, avatar, age, district, role, description}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, mobile, avatar, age, district, role, description} = objectToUnpack
	const districtId = district ? district.id : null
	const roleId = role ? role.id : null
	const data = {name, mobile, avatar, age, districtId, roleId, description}
	return data
}
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const UserBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default UserBase




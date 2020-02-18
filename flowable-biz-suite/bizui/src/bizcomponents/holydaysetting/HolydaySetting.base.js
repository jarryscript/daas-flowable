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



const menuData = {menuName: window.trans('holyday_setting'), menuFor: "holydaySetting",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('holyday_setting'), menuFor: "holydaySetting",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('holyday_setting.id'),
  type: window.trans('holyday_setting.type'),
  leaveDays: window.trans('holyday_setting.leave_days'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'holydaySetting') , sorter: true },
  { title: fieldLabels.type, dataIndex: 'type', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.leaveDays, debugtype: 'int', dataIndex: 'leaveDays', width: '6',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(holydaySetting, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={holydaySetting.id}>
	
      <DescriptionList  key={holydaySetting.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{holydaySetting.id}</Description> 
        <Description term={fieldLabels.leaveDays}><div style={{"color":"red"}}>{holydaySetting.leaveDays}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {leaveDays, typeId} = formValuesToPack
	const type = {id: typeId, version: 2^31}
	const data = {leaveDays, type}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {leaveDays, type} = objectToUnpack
	const typeId = type ? type.id : null
	const data = {leaveDays, typeId}
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
const HolydaySettingBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default HolydaySettingBase




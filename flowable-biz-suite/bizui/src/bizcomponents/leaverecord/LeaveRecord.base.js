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



const menuData = {menuName: window.trans('leave_record'), menuFor: "leaveRecord",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('leave_record'), menuFor: "leaveRecord",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('leave_record.id'),
  user: window.trans('leave_record.user'),
  type: window.trans('leave_record.type'),
  fromdate: window.trans('leave_record.fromdate'),
  todate: window.trans('leave_record.todate'),
  platform: window.trans('leave_record.platform'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'leaveRecord') , sorter: true },
  { title: fieldLabels.user, dataIndex: 'user', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.type, dataIndex: 'type', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.fromdate, dataIndex: 'fromdate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.todate, dataIndex: 'todate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.platform, dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(leaveRecord, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={leaveRecord.id}>
	
      <DescriptionList  key={leaveRecord.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{leaveRecord.id}</Description> 
        <Description term={fieldLabels.user}><div>{leaveRecord.user==null?appLocaleName(userContext,"NotAssigned"):`${leaveRecord.user.displayName}(${leaveRecord.user.id})`}
        </div></Description>
        <Description term={fieldLabels.fromdate}><div>{ moment(leaveRecord.fromdate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.todate}><div>{ moment(leaveRecord.todate).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {fromdate, todate, userId, typeId, platformId} = formValuesToPack
	const user = {id: userId, version: 2^31}
	const type = {id: typeId, version: 2^31}
	const platform = {id: platformId, version: 2^31}
	const data = {fromdate:moment(fromdate).valueOf(), todate:moment(todate).valueOf(), user, type, platform}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {fromdate, todate, user, type, platform} = objectToUnpack
	const userId = user ? user.id : null
	const typeId = type ? type.id : null
	const platformId = platform ? platform.id : null
	const data = {fromdate:moment(fromdate), todate:moment(todate), userId, typeId, platformId}
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
const LeaveRecordBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default LeaveRecordBase




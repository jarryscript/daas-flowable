

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './LeaveRecordType.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (leaveRecordType,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{leaveRecordType.id}</Description> 
<Description term="名称">{leaveRecordType.name}</Description> 
<Description term="编码">{leaveRecordType.code}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = leaveRecordType => {
  const {LeaveRecordTypeBase} = GlobalComponents
  return <PermissionSetting targetObject={leaveRecordType}  targetObjectMeta={LeaveRecordTypeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class LeaveRecordTypePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  leaveRecordType = this.props.leaveRecordType
    const { id,displayName, leaveRecordCount, holydaySettingCount } = leaveRecordType
    const  returnURL = `/leaveRecordType/${id}/dashboard`
    const cardsData = {cardsName:"离开记录类型",cardsFor: "leaveRecordType",cardsSource: leaveRecordType,displayName,returnURL,
  		subItems: [
{name: 'holydaySettingList', displayName:'宗教节日的设置',type:'holydaySetting',count:holydaySettingCount,addFunction: true, role: 'holydaySetting', data: leaveRecordType.holydaySettingList},
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  leaveRecordType: state._leaveRecordType,
}))(Form.create()(LeaveRecordTypePermission))


/*
把以下代码贴到customindex.js里面去
import PlatformDashboard from './platform/Platform.dashboardex';
import PlatformBizApp from './platform/Platform.appex';

在customindex增加的esult

const result = {
PlatformDashboard,
PlatformBizApp

};

*/

import PlatformDashboard from '../../bizcomponents/platform/Platform.dashboard'
import { List, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch  } from 'antd'
import numeral from 'numeral'
import FontAwesome from 'react-fontawesome'
import React, { Component } from 'react'
import { connect } from 'dva'
import styles from './Platform.dashboardex.less'
import { Link, Route, Redirect} from 'dva/router'
import appLocaleName from '../../common/Locale.tool'
const { TabPane } = Tabs

const topColResponsiveProps = {
  xs: 8,
  sm: 6,
  md: 6,
  lg: 4,
  xl: 4,
  style: { marginBottom: 24 },
}

const renderExtraHeader = platform => {
  const targetId = platform.id
  const functions=[
    {name:'借书',link:`/platform/${targetId}/about/1`,icon:"download"},
    {name:'还书',link:`/platform/${targetId}/about/2`,icon:"upload"},
    {name:'上架',link:`/platform/${targetId}/about/3`,icon:"arrow-up"},
    {name:'下架',link:`/platform/${targetId}/about/4`,icon:"arrow-down"},
    {name:'入库',link:`/platform/${targetId}/about/5`,icon:"login"},
    {name:'转入',link:`/platform/${targetId}/about/6`,icon:"menu-unfold"},
    {name:'出库',link:`/platform/${targetId}/about/7`,icon:"logout"},
    {name:'盘点',link:`/platform/${targetId}/about/8`,icon:"calculator"}

  ];

  return (

    <List
    grid={{ gutter: 16, xs: 1, sm: 2, md: 4, lg: 6, xl: 8, xxl: 12 }}
    dataSource={functions}
    renderItem={item => (
      <List.Item>
        <Card title={item.name}><Link to={item.link}>
        
        <Icon type={item.icon} style={{ fontSize: 50, color: '#08c' }}/>
        
        
       
       </Link></Card>
      </List.Item>
    )}
  />



   
  )
};




class PlatformDashboardEx extends Component {

  render() {
    return (<PlatformDashboard renderExtraHeader={renderExtraHeader}/>)
  }


}

export default connect(state => ({
  platform: state._platform,
}))(PlatformDashboardEx)

/*
这里是一个定制的例子，我们相用新的header来替换旧的header

能够定制下面的方法：

        {renderExtraHeader(cardsData.cardsSource)}
        {quickFunctions(cardsData)} 
        {imageListOf(cardsData.cardsSource)}  
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}


*/


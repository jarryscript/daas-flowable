import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,Row, Col,
  Input,Button
} from 'antd'
import TopMenu from '../../launcher/TopMenu'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './LeaveRecordType.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
import BizAppTool from '../../common/BizApp.tool'

const { Header, Sider, Content } = Layout
const { SubMenu } = Menu
const {
  defaultFilteredNoGroupMenuItems,
  defaultFilteredMenuItemsGroup,
  defaultRenderMenuItem,

} = BizAppTool


const filteredNoGroupMenuItems = defaultFilteredNoGroupMenuItems
const filteredMenuItemsGroup = defaultFilteredMenuItemsGroup
const renderMenuItem=defaultRenderMenuItem

const userBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const searchBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 12,
  xl: 12,
  
};


const naviBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class LeaveRecordTypeBizApp extends React.PureComponent {
constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
      showSearch: false,
      searchKeyword:''
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/leaveRecordType/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
	  <Menu
        theme="dark"
        mode="inline"
        
        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}
        style={{ width: '456px' }}
       >
           

             <Menu.Item key="dashboard">
               <Link to={`/leaveRecordType/${this.props.leaveRecordType.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
           </Menu>
    )
  }
  



  getLeaveRecordSearch = () => {
    const {LeaveRecordSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('leave_record','leave_record_type.leave_record_list',false),
      role: "leaveRecord",
      data: state._leaveRecordType.leaveRecordList,
      metaInfo: state._leaveRecordType.leaveRecordListMetaInfo,
      count: state._leaveRecordType.leaveRecordCount,
      returnURL: `/leaveRecordType/${state._leaveRecordType.id}/dashboard`,
      currentPage: state._leaveRecordType.leaveRecordCurrentPageNumber,
      searchFormParameters: state._leaveRecordType.leaveRecordSearchFormParameters,
      searchParameters: {...state._leaveRecordType.searchParameters},
      expandForm: state._leaveRecordType.expandForm,
      loading: state._leaveRecordType.loading,
      partialList: state._leaveRecordType.partialList,
      owner: { type: '_leaveRecordType', id: state._leaveRecordType.id, 
      referenceName: 'type', 
      listName: 'leaveRecordList', ref:state._leaveRecordType, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LeaveRecordSearch)
  }
  
  getLeaveRecordCreateForm = () => {
   	const {LeaveRecordCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "leaveRecord",
      data: state._leaveRecordType.leaveRecordList,
      metaInfo: state._leaveRecordType.leaveRecordListMetaInfo,
      count: state._leaveRecordType.leaveRecordCount,
      returnURL: `/leaveRecordType/${state._leaveRecordType.id}/list`,
      currentPage: state._leaveRecordType.leaveRecordCurrentPageNumber,
      searchFormParameters: state._leaveRecordType.leaveRecordSearchFormParameters,
      loading: state._leaveRecordType.loading,
      owner: { type: '_leaveRecordType', id: state._leaveRecordType.id, referenceName: 'type', listName: 'leaveRecordList', ref:state._leaveRecordType, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(LeaveRecordCreateForm)
  }
  
  getLeaveRecordUpdateForm = () => {
    const userContext = null
  	const {LeaveRecordUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._leaveRecordType.selectedRows,
      role: "leaveRecord",
      currentUpdateIndex: state._leaveRecordType.currentUpdateIndex,
      owner: { type: '_leaveRecordType', id: state._leaveRecordType.id, listName: 'leaveRecordList', ref:state._leaveRecordType, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(LeaveRecordUpdateForm)
  }

  getHolydaySettingSearch = () => {
    const {HolydaySettingSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: window.mtrans('holyday_setting','leave_record_type.holyday_setting_list',false),
      role: "holydaySetting",
      data: state._leaveRecordType.holydaySettingList,
      metaInfo: state._leaveRecordType.holydaySettingListMetaInfo,
      count: state._leaveRecordType.holydaySettingCount,
      returnURL: `/leaveRecordType/${state._leaveRecordType.id}/dashboard`,
      currentPage: state._leaveRecordType.holydaySettingCurrentPageNumber,
      searchFormParameters: state._leaveRecordType.holydaySettingSearchFormParameters,
      searchParameters: {...state._leaveRecordType.searchParameters},
      expandForm: state._leaveRecordType.expandForm,
      loading: state._leaveRecordType.loading,
      partialList: state._leaveRecordType.partialList,
      owner: { type: '_leaveRecordType', id: state._leaveRecordType.id, 
      referenceName: 'type', 
      listName: 'holydaySettingList', ref:state._leaveRecordType, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(HolydaySettingSearch)
  }
  
  getHolydaySettingCreateForm = () => {
   	const {HolydaySettingCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "holydaySetting",
      data: state._leaveRecordType.holydaySettingList,
      metaInfo: state._leaveRecordType.holydaySettingListMetaInfo,
      count: state._leaveRecordType.holydaySettingCount,
      returnURL: `/leaveRecordType/${state._leaveRecordType.id}/list`,
      currentPage: state._leaveRecordType.holydaySettingCurrentPageNumber,
      searchFormParameters: state._leaveRecordType.holydaySettingSearchFormParameters,
      loading: state._leaveRecordType.loading,
      owner: { type: '_leaveRecordType', id: state._leaveRecordType.id, referenceName: 'type', listName: 'holydaySettingList', ref:state._leaveRecordType, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(HolydaySettingCreateForm)
  }
  
  getHolydaySettingUpdateForm = () => {
    const userContext = null
  	const {HolydaySettingUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._leaveRecordType.selectedRows,
      role: "holydaySetting",
      currentUpdateIndex: state._leaveRecordType.currentUpdateIndex,
      owner: { type: '_leaveRecordType', id: state._leaveRecordType.id, listName: 'holydaySettingList', ref:state._leaveRecordType, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(HolydaySettingUpdateForm)
  }


  

 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'EHR'
    return title
  }
 
  buildRouters = () =>{
  	const {LeaveRecordTypeDashboard} = GlobalComponents
  	const {LeaveRecordTypePermission} = GlobalComponents
  	const {LeaveRecordTypeProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/leaveRecordType/:id/dashboard", component: LeaveRecordTypeDashboard},
  	{path:"/leaveRecordType/:id/profile", component: LeaveRecordTypeProfile},
  	{path:"/leaveRecordType/:id/permission", component: LeaveRecordTypePermission},
  	
  	
  	
  	{path:"/leaveRecordType/:id/list/leaveRecordList", component: this.getLeaveRecordSearch()},
  	{path:"/leaveRecordType/:id/list/leaveRecordCreateForm", component: this.getLeaveRecordCreateForm()},
  	{path:"/leaveRecordType/:id/list/leaveRecordUpdateForm", component: this.getLeaveRecordUpdateForm()},
   	
  	{path:"/leaveRecordType/:id/list/holydaySettingList", component: this.getHolydaySettingSearch()},
  	{path:"/leaveRecordType/:id/list/holydaySettingCreateForm", component: this.getHolydaySettingCreateForm()},
  	{path:"/leaveRecordType/:id/list/holydaySettingUpdateForm", component: this.getHolydaySettingUpdateForm()},
     	
 	 
  	]
  	
  	const {extraRoutesFunc} = this.props;
  	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
  	const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
     const userContext = null
     const renderBreadcrumbText=(value)=>{
     	if(value==null){
     		return "..."
     	}
     	if(value.length < 10){
     		return value
     	}
     
     	return value.substring(0,10)+"..."
     	
     	
     }
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const renderBreadcrumbMenuItem=(breadcrumbMenuItem)=>{

      return (
      <Menu.Item key={breadcrumbMenuItem.link}>
      <Link key={breadcrumbMenuItem.link} to={`${breadcrumbMenuItem.link}`} className={styles.breadcrumbLink}>
        <Icon type="heart" style={{marginRight:"10px",color:"red"}} />
        {renderBreadcrumbText(breadcrumbMenuItem.name)}
      </Link></Menu.Item>)

     }
     const breadcrumbMenu=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <Menu mode="vertical"> 
      {currentBreadcrumb.map(item => renderBreadcrumbMenuItem(item))}
      </Menu>)
  

     }
     
     const { Search } = Input;
     const showSearchResult=()=>{

        this.setState({showSearch:true})

     }
     const searchChange=(evt)=>{

      this.setState({searchKeyword :evt.target.value})

    }
    const hideSearchResult=()=>{

      this.setState({showSearch:false})

    }

    const {searchLocalData}=GlobalComponents.LeaveRecordTypeBase
	
    
     
     
     const layout = (
     <Layout>
 <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
            <Dropdown overlay= {this.getNavMenuItems(this.props.leaveRecordType)}>
              <a  className={styles.menuLink}>
                <Icon type="unordered-list" style={{fontSize:"20px", marginRight:"10px"}}/> 菜单
              </a>
            </Dropdown>            
            <Dropdown overlay={breadcrumbMenu()}>
              <a  className={styles.menuLink}>
                <Icon type="down" style={{fontSize:"20px", marginRight:"10px"}}/> 快速转到
              </a>
            </Dropdown>
        </Col>
        <Col  className={styles.searchBox} {...searchBarResponsiveStyle}  > 
          
          <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释，关闭请点击搜索结果空白处" 
            enterButton onFocus={()=>showSearchResult()} onChange={(evt)=>searchChange(evt)}
           	
            style={{ marginLeft:"10px",marginTop:"7px",width:"100%"}} />  
            
            
          </Col>
          <Col  {...userBarResponsiveStyle}  > 
            <Dropdown overlay= { <TopMenu {...this.props} />} className={styles.right}>
                <a  className={styles.menuLink}>
                  <Icon type="user" style={{fontSize:"20px",marginRight:"10px"}}/> 账户
                </a>
            </Dropdown>
            
           </Col>  
         
         </Row>
        </Header>
       <Layout style={{  marginTop: 44 }}>
       
      {this.state.showSearch&&(

        <div style={{backgroundColor:'black'}}  onClick={()=>hideSearchResult()}  >{searchLocalData(this.props.leaveRecordType,this.state.searchKeyword)}</div>

      )}
       
        
         
         <Layout>
         
            
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  leaveRecordType: state._leaveRecordType,
  ...state,
}))(LeaveRecordTypeBizApp)




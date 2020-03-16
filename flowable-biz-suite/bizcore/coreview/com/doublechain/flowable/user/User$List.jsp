<%@ page import='java.util.*,com.doublechain.flowable.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty userList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['user']}! 
		 <a href="./${ownerBeanName}Manager/addUser/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty userList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("userList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['user']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addUser/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'userList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${userListName};${userListName}CurrentPage=${page.pageNumber};${userListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='userListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['user.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['user.name']}</th>
</c:if>
<c:if test="${param.referName ne 'mobile'}">
	<th>${userContext.localeMap['user.mobile']}</th>
</c:if>
<c:if test="${param.referName ne 'avatar'}">
	<th>${userContext.localeMap['user.avatar']}</th>
</c:if>
<c:if test="${param.referName ne 'age'}">
	<th>${userContext.localeMap['user.age']}</th>
</c:if>
<c:if test="${param.referName ne 'description'}">
	<th>${userContext.localeMap['user.description']}</th>
</c:if>
<c:if test="${param.referName ne 'district'}">
	<th>${userContext.localeMap['user.district']}</th>
</c:if>
<c:if test="${param.referName ne 'role'}">
	<th>${userContext.localeMap['user.role']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${userList}">
				<tr currentVersion='${item.version}' id="user-${item.id}" ><td><a class="link-action-removed" href="./userManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateUser/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'mobile'}">	<td contenteditable='true' class='edit-value'  propertyToChange='mobile' storedCellValue='${item.maskedMobile}' prefix='${ownerBeanName}Manager/updateUser/${result.id}/${item.id}/'>${item.maskedMobile}</td>
</c:if><c:if test="${param.referName ne 'avatar'}">	<td contenteditable='true' class='edit-value'  propertyToChange='avatar' storedCellValue='${item.avatar}' prefix='${ownerBeanName}Manager/updateUser/${result.id}/${item.id}/'>${item.avatar}</td>
</c:if><c:if test="${param.referName ne 'age'}">	<td contenteditable='true' class='edit-value'  propertyToChange='age' storedCellValue='${item.age}' prefix='${ownerBeanName}Manager/updateUser/${result.id}/${item.id}/'>${item.age}</td>
</c:if><c:if test="${param.referName ne 'description'}">	<td contenteditable='true' class='edit-value'  propertyToChange='description' storedCellValue='${item.description}' prefix='${ownerBeanName}Manager/updateUser/${result.id}/${item.id}/'><a title='${item.description}'>${fn:substring(item.description,0,10)}...</a></td>
</c:if><c:if test="${param.referName ne 'district'}">
	<td class="select_candidate_td"
			data-candidate-method="./userManager/requestCandidateDistrict/${ownerBeanName}/${item.id}/"
			data-switch-method="./userManager/transferToAnotherDistrict/${item.id}/"
			data-link-template="./districtManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.district}">
			<a href='./districtManager/view/${item.district.id}/'>${item.district.displayName}</a>
			</c:if>
			<c:if test="${empty  item.district}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'role'}">
	<td class="select_candidate_td"
			data-candidate-method="./userManager/requestCandidateRole/${ownerBeanName}/${item.id}/"
			data-switch-method="./userManager/transferToAnotherRole/${item.id}/"
			data-link-template="./roleManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.role}">
			<a href='./roleManager/view/${item.role.id}/'>${item.role.displayName}</a>
			</c:if>
			<c:if test="${empty  item.role}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>

				<td>

				<a href='#${ownerBeanName}Manager/removeUser/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyUserFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>



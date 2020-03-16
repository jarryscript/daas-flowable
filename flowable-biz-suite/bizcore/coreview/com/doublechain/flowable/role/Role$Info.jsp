
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty role}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Role">${userContext.localeMap['role']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./roleManager/view/${role.id}/"> ${role.id}</a></li>
<li><span>${userContext.localeMap['role.name']}</span> ${role.name}</li>
<li><span>${userContext.localeMap['role.code']}</span> ${role.code}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>





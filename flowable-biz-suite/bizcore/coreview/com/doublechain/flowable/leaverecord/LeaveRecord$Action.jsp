
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty leaveRecord}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A LeaveRecord" style="color: green">${userContext.localeMap['leave_record']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['leave_record.id']}</span> ${leaveRecord.id}</li>
<li><span>${userContext.localeMap['leave_record.fromdate']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${leaveRecord.fromdate}" /></li>
<li><span>${userContext.localeMap['leave_record.todate']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${leaveRecord.todate}" /></li>

	
	</ul>
</div>



</c:if>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Agent Details:</h2>
<table><thead>
<tr><td></td></tr>
</thead>
<tbody>
<tr><td>First Name:</td><td>${requestScope.agent.firstName}</td></tr>
<tr><td>Last Name:</td><td>${requestScope.agent.lastName}</td></tr>
<tr><td>EmailId:</td><td>${requestScope.agent.emailId}</td></tr>
<tr><td>Phone Number :</td><td>${requestScope.agent.phoneNumber}</td></tr>
<c:if test="${not empty requestScope.agent.agencyName}">
<tr><td>Agency Name:</td><td>${requestScope.agent.agencyName}</td></tr>
</c:if>
<c:if test="${not empty requestScope.agent.agentType}">
<tr><td>Agency Type:</td><td>${requestScope.agent.agentType}</td></tr>
</c:if>
</tbody>
</table>
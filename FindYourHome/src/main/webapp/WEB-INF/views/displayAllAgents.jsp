<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
<div>

<h2>List of Agents:</h2>
<c:forEach var="agent" items="${requestScope.agentslist}">
<table><thead>
<tr><td>Agent Profile Id</td><td> ${agent.personId}</td></tr>
</thead>
<tbody>
<tr><td>First Name:</td><td>${agent.firstName}</td></tr>
<tr><td>Last Name:</td><td>${agent.lastName}</td></tr>
<tr><td>EmailId:</td><td>${agent.emailId}</td></tr>
<tr><td>Phone Number :</td><td>${agent.phoneNumber}</td></tr>
<c:if test="${not empty agent.agencyName}">
<tr><td>Agency Name:</td><td>${agent.agencyName}</td></tr>
</c:if>
<c:if test="${not empty agent.agentType}">
<tr><td>Agency Type:</td><td>${agent.agentType}</td></tr>
</c:if>
</tbody>
</table>
</c:forEach>
</div>
</section>
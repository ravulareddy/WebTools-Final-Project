<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<div>
<sform:form commandName="userTypes" method="post">
	<table>
	<thead>
	<tr>
	<td>
	<h4> Please Enter details to Sign in</h4>
	</td>
	</tr>
	</thead>
	<tbody>
	<tr>
	<td><label>Enter Role Name</label></td>
	<td><sform:input  path="firstName" size="30" /></td>
	<td><sform:errors path="firstName" class="errors" /> </td></tr>
	
	<tr>
	<td><label>Last Name</label></td>
	<td><sform:input  path="lastName" size="30" /></td>
	<td><sform:errors path="lastName" class="errors"/></td></tr>
	</tbody>
	</table>

</sform:form>
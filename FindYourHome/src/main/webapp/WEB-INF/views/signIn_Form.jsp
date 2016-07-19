<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<section>
<div>
<sform:form commandName="user" method="post">
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
	<td><label>First Name</label></td>
	<td><sform:input  path="firstName" size="30" /></td>
	<td><sform:errors path="firstName" class="errors" /> </td>
	</tr>
	
	<tr>
	<td><label>Last Name</label></td>
	<td><sform:input  path="lastName" size="30" /></td>
	<td><sform:errors path="lastName" class="errors"/></td>
	</tr>
	
	<tr>
	<td><label>Email Id</label></td>
	<td><sform:input  path="emailId" size="30" /></td>
	<td><sform:errors path="emailId" class="errors" /> </td>
	</tr>
	
	<tr>
	<td><label>Contact Number</label></td>
	<td><sform:input  path="phoneNumber" size="30" /></td>
	<td><sform:errors path="phoneNumber" class="errors" /> </td>
	</tr>
	
	<tr>
	<td><label>UserName</label></td>
	<td><sform:input  path="name" size="30" /></td>
	<td><sform:errors path="name" class="errors" /> </td>
	</tr>

	<tr>
	<td><label>Password</label></td>
	<td><sform:password  path="password" size="30" /></td>
	<td><sform:errors path="password" class="errors"/> </td>
	</tr>
	
	
	<tr>
	<td><label>Role</label></td>
	<td><sform:select  path="role" >
	<!--<sform:option value="ADMIN">Admin</sform:option> -->
	<sform:option value="BUYER">Buyer</sform:option>
	<sform:option value="AGENT">Agent</sform:option>
	</sform:select>
	</td>
	<td><sform:errors path="role" class="errors"/> </td>
	</tr>
	
	<tr>
	<td></td>
	<td><input type="submit" class="btn btn-primary" value="Sign Up" /></td>
	</tr>
</tbody>

</table>
</sform:form>
</div>
</section>
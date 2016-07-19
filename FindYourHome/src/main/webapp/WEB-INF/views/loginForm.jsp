<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<section>
<div >
<sform:form commandName="user" method="post" class="form-horizontal" >
 <h3>Enter your details to login</h3>
<table >
<tbody>
<tr>
<td><label>Enter your Username</label></td>
<td><sform:input path="name" size="30" /></td>
<td><sform:errors path="name" class="errors" /> </td></tr>

	<tr><td><label>Enter your Password</label></td>
<td>	<sform:password path="password" size="30" /></td>
<td>	<sform:errors path="password" class="errors"/> </td></tr>
	
<tr><td></td><td><input type="submit" class="button" value="Login" />
</td></tr>
<tr><td></td></tr>
<tr><td><a href="signIn.htm">Create New Account</a></td></tr>
</tbody>
</table>	
</sform:form>
</div>
</section>
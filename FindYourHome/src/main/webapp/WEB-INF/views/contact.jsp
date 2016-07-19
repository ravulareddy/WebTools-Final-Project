<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<section>
<sform:form action="contact.htm" method="post" commandName="contact">
<table>
	<thead>
	<tr>
	<td>
	<h4>Contact us Form :</h4>
	</td>
	
	</tr>
	</thead>
	<tbody>
	<tr>
	<td>
	<h4>Enter Details below:</h4>
	</td>
	
	</tr>
	<tr><td><label>Title</label></td>
	<td><sform:input  path="title" size="30" /></td>
	<td><sform:errors path="title" class="errors" /> </td>
	</tr>
	
	<tr><td><label>Question</label></td>
	<td><sform:textarea  path="question" size="30" /></td>
	<td><sform:errors path="question" class="errors" /> </td>
	</tr>
	
	<tr><td><label>Details about Question</label></td>
	<td><sform:textarea  path="questionDetails" size="30" /></td>
	<td><sform:errors path="questionDetails" class="errors" /> </td>
	</tr>
	
	<tr><td><label>Your EmailId</label></td>
	<td><sform:input path="emailId" size="30" /></td>
	<td><sform:errors path="emailId" class="errors" /> </td>
	</tr>
	
	<tr><td></td>
	<td><input type="submit" class="btn btn-primary" value="Send Email" /></td>
	
	</tr>
	</tbody>
	</table>
	</sform:form>
</section>
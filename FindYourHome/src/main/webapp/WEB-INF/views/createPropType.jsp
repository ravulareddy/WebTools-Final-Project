<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
<div >
<sform:form commandName="listingpropType" method="post" class="form-horizontal" >
 <h3>Create New Property Type </h3>
<table>
<tbody>
<tr>
<td><label>Property Type:</label></td>
<td><sform:input path="homeTypeName" size="30"/></td>
<td><sform:errors path="homeTypeName" class="errors" /> </td></tr>

<tr><td></td><td><input type="submit" class="button" value="Add New Property Type" />
</td></tr>

</tbody>
</table>	
</sform:form>
</div>
</section>
s
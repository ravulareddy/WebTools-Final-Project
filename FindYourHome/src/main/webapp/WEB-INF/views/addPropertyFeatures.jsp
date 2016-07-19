<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
<div >
<sform:form commandName="listingFeatures" method="post" class="form-horizontal" >
 <h3>Create New Property Features </h3>
<table>
<tbody>
<tr>
<td><label>Property Feature:</label></td>
<td><sform:input path="feature" size="30"/></td>
<td><sform:errors path="feature" class="errors" /> </td></tr>

<tr>
<td><label>Feature Description:</label></td>
<td><sform:input path="description" size="30"/></td>
<td><sform:errors path="description" class="errors" /> </td></tr>

<tr><td></td><td><input type="submit" class="button" value="Add New Category" />
</td></tr>

</tbody>
</table>	
</sform:form>
</div>
</section>

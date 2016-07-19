<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
<div >
<sform:form commandName="listingCategories" method="post" class="form-horizontal" >
 <h3>Add New Property Listing Category </h3>
<table>
<tbody>
<tr>
<td><label>Category Name:</label></td>
<td><sform:input path="title" size="30"/></td>
<td><sform:errors path="title" class="errors" /> </td></tr>

<tr><td></td><td><input type="submit" class="button" value="Add New Category" />
</td></tr>

</tbody>
</table>	
</sform:form>


</div>
</section>

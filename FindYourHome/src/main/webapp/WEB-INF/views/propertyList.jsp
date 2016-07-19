<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<section>
<div>
<sform:form commandName="listing" method="post">
	<table>
	<thead>
	<tr>
	<td>
	<h4>Address :</h4>
	</td>
	</tr>
	</thead>
	<tbody>
	
	
<!-- 	<tr>
	<td><label>Home Type</label></td>
	<td><sform:input  path="property.homeType." size="30" /></td>
	<td><sform:errors path="property.homeType" class="errors"/></td></tr> -->
	
	<tr>
	<td><label>No of Baths</label></td>
	<td><sform:input  path="property.noOfBaths" size="30" /></td>
	<td><sform:errors path="property.noOfBaths" class="errors" /> </td></tr>
	
	<tr>
	<td><label>No of Bedrooms</label></td>
	<td><sform:input  path="property.noOfBedrooms" size="30" /></td>
	
	<td><sform:errors path="property.noOfBedrooms" class="errors" /> </td></tr>

	<tr><td><label>Year built</label></td>
	<td><sform:input  path="property.yearBuilt" size="30" /></td>
	<td><sform:errors path="property.yearBuilt" class="errors"/> </td></tr>
	<tr>
	<tr><td><h4>Address:</h4></td> </tr>
	<tr>
	<td><label>Address Line1</label></td>
	<td><sform:input  path="property.homeAddress.addressLine1" size="30" /></td>
	<td><sform:errors path="property.homeAddress.addressLine1" class="errors" /> </td></tr>
	
	<tr>
	<td><label>Address Line2</label></td>
	<td><sform:input  path="property.homeAddress.addressLine2" size="30" /></td>
	<td><sform:errors path="property.homeAddress.addressLine2" class="errors" /> </td></tr>

	<tr><td><label>City</label></td>
	<td><sform:input  path="property.homeAddress.city" size="30" /></td>
	<td><sform:errors path="property.homeAddress.city" class="errors"/> </td></tr>
	<tr>
	
	<tr>
	<td><label>State</label></td>
	<td><sform:input  path="property.homeAddress.state" size="30" /></td>
	<td><sform:errors path="property.homeAddress.state" class="errors" /> </td></tr>
	
	<tr>
	<td><label>Zipcode</label></td>
	<td><sform:input  path="property.homeAddress.zipcode" size="30" /></td>
	<td><sform:errors path="property.homeAddress.zipcode" class="errors" /> </td></tr>
	
	<tr><td></td>
	<td><input type="submit" class="btn btn-primary" value="Add Property Listing" /></td>
	
</tbody>

</table>
</sform:form>
</div>
</section>
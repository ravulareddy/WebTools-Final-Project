<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
<table>
<thead>
<tr> <td> Apartments Available For Rent: </td></tr>
</thead>
<tbody>
<c:forEach var="rentAprt" items="${requestScope.rentAptListing}">
<tr><td>HomeType:</td><td>${rentAprt.propType}</td></tr>
<tr><td>No of Baths:</td><td>${rentAprt.noOfBaths}</td></tr>
<tr><td>No of Bedrooms:</td><td>${rentAprt.noOfBedrooms}</td></tr>
<tr><td>Year Built:</td><td>${rentAprt.yearBuilt}</td></tr>
<tr><td>Address:</td></tr>
<tr><td>Address Line1:</td><td>${rentAprt.homeAddress.addressLine1}</td></tr>
<tr><td>Address Line2:</td><td>${rentAprt.homeAddress.addressLine2}</td></tr>
<tr><td>City:</td><td>${rentAprt.homeAddress.city}</td></tr>
<tr><td>State:</td><td>${rentAprt.homeAddress.state}</td></tr>
<tr><td>Zipcode:</td><td>${rentAprt.homeAddress.zipcode}</td></tr>
<tr><td><img alt="Property Image" src="resources/images/${rentAprt.imagePath}" width="250px" height="200px" /></td></tr>

</c:forEach>
</tbody>
</table>
</section>
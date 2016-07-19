<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
<div style="width: 100%; height: auto;">
<div id="searchResults" style="width: 50%; height: auto;">
 <c:forEach var="home" items="${requestScope.homeListing}">
<table>
<thead>
<tr><td><h3>Property Details</h3></td></tr>
</thead>
<tbody>
<tr><td>HomeType:</td><td>${home.propType}</td></tr>
<tr><td>No of Baths:</td><td>${home.noOfBaths}</td></tr>
<tr><td>No of Bedrooms:</td><td>${home.noOfBedrooms}</td></tr>
<tr><td>Year Built:</td><td>${home.yearBuilt}</td></tr>
<tr><td>Address:</td></tr>
<tr><td>Address Line1:</td><td>${home.homeAddress.addressLine1}</td></tr>
<tr><td>Address Line2:</td><td>${home.homeAddress.addressLine2}</td></tr>
<tr><td>City:</td><td>${home.homeAddress.city}</td></tr>
<tr><td>State:</td><td>${home.homeAddress.state}</td></tr>
<tr><td>Zipcode:</td><td>${home.homeAddress.zipcode}</td></tr>

<tr><td><img alt="Property Image" src="resources/images/${home.imagePath}" width="250px" height="200px" /></td></tr>
</tbody>
</table>

</c:forEach>     
 </div>
</div>
</section>
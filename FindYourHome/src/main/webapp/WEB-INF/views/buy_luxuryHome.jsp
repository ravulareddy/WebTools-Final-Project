<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
<div>
<h1>Display ${requestScope.listTitle} Homes </h1>

<c:forEach var="luxuryHome" items="${requestScope.luxuryHomeListing}">
<div>

<table>
<thead>
<tr><td><h3>Property Details</h3></td></tr>
</thead>
<tbody>
<tr><td>HomeType:</td><td>${luxuryHome.propType}</td></tr>
<tr><td>No of Baths:</td><td>${luxuryHome.noOfBaths}</td></tr>
<tr><td>No of Bedrooms:</td><td>${luxuryHome.noOfBedrooms}</td></tr>
<tr><td>Year Built:</td><td>${luxuryHome.yearBuilt}</td></tr>
<tr><td>Address:</td></tr>
<tr><td>Address Line1:</td><td>${luxuryHome.homeAddress.addressLine1}</td></tr>
<tr><td>Address Line2:</td><td>${luxuryHome.homeAddress.addressLine2}</td></tr>
<tr><td>City:</td><td>${luxuryHome.homeAddress.city}</td></tr>
<tr><td>State:</td><td>${luxuryHome.homeAddress.state}</td></tr>
<tr><td>Zipcode:</td><td>${luxuryHome.homeAddress.zipcode}</td></tr>
</tbody>
</table>

<span>
<img alt="Property Image" src="resources/images/${luxuryHome.imagePath}" width="250px" height="200px" />

</span>
</div>

</c:forEach>


</div>
</section>

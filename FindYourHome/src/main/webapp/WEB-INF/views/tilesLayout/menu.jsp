<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<ul id="mainMenu">
	 <li><a href="http://localhost:8080/myhome/">Home Page</a> </li> 
  <li><a href="buyhome.htm">Buy home</a>
  <ul class="hidden">
  <li><a href="buy_luxuryHome.htm">Luxury Home</a> </li>
  <li><a href="buy_assistedLiving.htm">Homes in Assisted Living Community</a> </li>
  <li><a href="buy_searchByCriteria.htm">Search Home with More Options </a> </li>
 <!--  <li><a href="buy_byOwner.htm">Home For Sale By Owner</a> </li> -->
  <li><a href="buy_newHome.htm">Newly Constructed Home</a> </li>
  <li><a href="buy_searchAll.htm">Search all Homes</a> </li>
  </ul>
  </li>
  <li><a href="sellhome.htm">Sell home</a>
  <ul class="hidden">
  <li><a href="sell_FindAgent.htm">Find an Agent</a> </li>
  <li><a href="sell_postListing.htm">Post Listing For Sale</a> </li>
  <li><a href="sell_FindAllAgents.htm">Find All Agents</a> </li>
  </ul>
  </li>
  <li><a href="rentHome.htm">Rent a Home</a>
    <ul class="hidden">
  <li><a href="rent_apartment.htm">Apartments For Rent</a> </li>
  <li><a href="rent_all.htm">Find all available rental properties</a> </li>
  </ul>
  </li>
  
   <li><a href="contact.htm">Contact Us</a> </li> 
   <li><a href="buy_searchByCriteria.htm">Search Properties</a></li>
   <c:if test="${not empty sessionScope.user}" >
  <li><a href="logout.htm" >Logout</a> </li>
  </c:if>
   <c:if test="${empty sessionScope.user}" >
  <li><a href="login.htm" >Login/SignUp</a> </li>
  </c:if>
   
</ul>



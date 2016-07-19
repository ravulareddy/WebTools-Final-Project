<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

function validateAddressForm(form) {
	
	var inputs = document.getElementsByTagName("input");
    var zipcode = document.getElementById("zipcode");
    var city = document.getElementById("city");
    var state = document.getElementById("state");
    
    if (zipcode.value.trim() == "" || city.value.trim() == "" || state.value.trim() == "")  {
        alert("Search Criteria Fields Cannot be Empty, Please Enter Zipcode, city and state!");
        return false;
    }
       return true;
}

function validatePriceForm(form) {
    var inputs = document.getElementsByTagName("input");
    var minPrice = document.getElementById("minPrice");
    var maxPrice = document.getElementById("maxPrice");
    
    
    if (minPrice.value.trim() == "" || maxPrice.value.trim() == "" )  {
        alert("Please Enter min and max price!");
        return false;
    }
       return true;
}

function validatePropTypeForm(form) {
	
	var homeTypes = document.getElementsByName('homeType[]');
	var hasCheckedhomeType = false;
	for (var i = 0; i < homeTypes.length; i++)
	{
	if (homeTypes[i].checked)
	{
		hasCheckedhomeType = true;
	break;
	}
	}
	if (hasCheckedhomeType == false)
	{
	alert("Please select at least one Property Type!");
	return false;
	}
	return true;
}

function validateFeaturesForm(form) {
	
	var features = document.getElementsByName('features[]');
	var hasCheckedFeature = false;
	for (var i = 0; i < features.length; i++)
	{
	if (features[i].checked)
	{
		hasCheckedFeature = true;
	break;
	}
	}
	if (hasCheckedFeature == false)
	{
	alert("Please select at least one feature!");
	return false;
	}
	return true;
}



</script>
<section>

 <div> 
<form action="buy_searchByCriteria.htm" method="post" id="searchByAddress" onsubmit="return validateAddressForm(this);">
<div>
<span><input type="radio" name="category" value="Rent" checked> Rent</span>
<span><input type="radio" name="category" value="Buy"> Buy </span>
</div>
<table>
	<thead>
	<tr>
	<td>
	<h4>Search Home By Address :</h4>
	</td>
	
	</tr>
	</thead>
	<tbody>
	<tr>
	<td><label>Zipcode</label></td>
	<td><input type="text" id="zipcode" name="zipcode" size="30" min=1 maxlength="5" required="required" placeholder="Eg:02145"/></td>
	</tr>
	
	<tr>
	<td><label>City</label></td>
	<td><input type="text" id="city" name="city" size="30" min=1 maxlength="50" required="required" placeholder="somerville"/></td>
	</tr>
	
	<tr>
	<td><label>State</label></td>
	<td><input type="text" id="state" name="state" size="30" min=1 maxlength="50" required="required" placeholder="MA"/></td>
	</tr>

	
	<tr><td></td>
	<td><input type="submit" class="btn btn-primary" value="Search Now" /></td>
	<td> <input type="hidden" name="action" value="searchByAddress" /></td>
	</tr>
	</tbody></table>
	</form>
</div>	
<div>
<form action="buy_searchByCriteria.htm" method="post" id="searchByPrice"  onsubmit="return validatePriceForm(this);">
<h4>Search Home By Price :</h4> 
<span><input type="radio" name="category" value="Rent" checked> Rent</span>
<span><input type="radio" name="category" value="Buy"> Buy </span>
<br/>
<table>
	<thead>
	<tr>
	<td>
	Enter Price Range:
	</td>
	
	</tr>
	</thead>
	<tbody>
	<tr>
	<td><label>Minimum Price</label></td>
	<td><input type="number" id="minPrice" name="minPrice"  min=1 maxlength="15" required="required"/></td>
	</tr>
	<tr>
	<td><label>Maximum Price</label></td>
	<td><input type="number" id="maxPrice" name="maxPrice"  min=1 maxlength="15" required="required"/></td>
	</tr>

	
	<tr><td></td>
	<td><input type="submit" class="btn btn-primary" value="Search Now" /></td>
	<td> <input type="hidden" name="action" value="searchByPrice" /></td>
	</tr>
	</tbody></table>
</form>	
</div>
<div>
<form action="buy_searchByCriteria.htm" method="post" id="searchByFeatures"  onsubmit="return validateFeaturesForm(this);">

	<h4>Search Home By Features :</h4> <span><input type="radio" name="category" value="Rent" checked> Rent</span>
<span><input type="radio" name="category" value="Buy"> Buy </span>
<br/>
	
	<label>Select Features :</label>
	<p>
	 <c:forEach items="${featuresList}" var="feature">
         <span><input type="checkbox" name="features[]" value="${feature}" id="${feature}" />${feature} &nbsp;&nbsp; </span>
         </c:forEach>
	
	</p>
	<br/>

	<input type="submit" class="btn btn-primary" value="Search Now" />
	<input type="hidden" name="action" value="searchByFeatures" />
	
</form>	
</div>
<div>
<form action="buy_searchByCriteria.htm" method="post" id="searchByPropType"  onsubmit="return validatePropTypeForm(this);">

	<h4>Search Home By Property Type :</h4> <span><input type="radio" name="category" value="Rent" checked> Rent</span>
<span><input type="radio" name="category" value="Buy"> Buy </span>
<br/>
	
	<label>Select Property Type :</label>
	<p>
	 <c:forEach items="${propertyTypeList}" var="homeType">
    <span></span><input type="checkbox" name="homeType[]" value="${homeType}" id="${homeType}" />${homeType} &nbsp;&nbsp;</span>
         </c:forEach>
	</p>
	<br/>
	<input type="submit" class="btn btn-primary" value="Search Now" />
	 <input type="hidden" name="action" value="searchByPropType" />
	
</form>	
</div>
</section>
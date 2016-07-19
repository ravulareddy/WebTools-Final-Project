<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
function validateForm(form)
{
	if(document.getElementById('homeType').value == 0)
	{
	alert("Please select HomeType");
	return false;
	}
	if(document.getElementById('category').value == 0)
		{
		alert("Please select Listing Category");
		return false;
		}
	
	file_upload();

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

function file_upload() {
    var imagePath = document.getElementById("imagefile").value;
    if (imagePath == "") {
        alert("Please upload image");
        document.file.word.focus();
        return false;
    }
    else {
        var arrStr1 = new Array;
        arrStr1 = imagePath.split("\\");
        var len = arrStr1.length;
        var img1 = arrStr1[len - 1];
        var filextnsn = img1.substring(img1.lastIndexOf(".") + 1);
        if (filextnsn == "gif" || filextnsn == "png" || filextnsn == "bmp" ||  filextnsn == "jpg" || filextnsn == "jpeg" ) {
          	return false;
        }
        else {
            alert("Please upload image with Extension ' png , jpg , bmp , gif, jpeg '");
            document.form.word.focus();
            return false;
        }
    }
}
</script>
<section>
<div>
<form action="sell_postListing.htm" method="post" id="postPropLising" enctype="multipart/form-data" onsubmit="return validateForm(this);">
<div>
<ul class="errorMessages"></ul>
</div>
<table>
	<thead>
	<tr>
	<td>
	<h4>Add New Listing :</h4>
	</td>
	
	</tr>
	</thead>
	<tbody>
	<tr>
	<td>
	<h4>Enter Property Details :</h4>
	</td>
	
	</tr>
	<tr><td><label>Title</label></td>
	<td><input type="text" name="title" size="40" placeholder="Enter title (Special Character are not Allowed)" 
		required="required" min="1" maxlength="30" pattern="^[0-9]*[a-zA-Z][a-zA-Z0-9]*$" title="Please enter Valid title with no special characters"/></td>
	</tr>
	
<!-- 	<tr>
	<td><label>Home Type</label></td>
	<td>
	<input type="text" name="homeType" placeholder="Enter Home Type" maxlength="12" value=""/></td>
	</tr> -->
	
	<tr>
	<td><label>Property Type</label></td>
	<td><select required name="homeType" id="homeType">
	 <c:forEach items="${propertyTypeList}" var="homeType">
          <option value="${homeType}">${homeType}</option>
         </c:forEach>
	</select></td>
	</tr>
	
	<tr>
	<td><label>Listing Category</label></td>
	<td><select required name="category" id="category">
	 <c:forEach items="${categoriesList}" var="category">
          <option value="${category}">${category}</option>
         </c:forEach>
	</select></td>
	</tr>

	<tr>
	<td><label>No of Baths</label></td>
	<td><input type="number" name="noOfBaths" placeholder="Enter Numbers only" title="Please enter number of bathrooms" size="30" pattern="[0-9]" required="required" min="1" maxlength="30"/></td>
	</tr>
	
	
	<tr>
	<td><label>No of Bedrooms</label></td>
	<td><input type="number" name="noOfBedrooms" placeholder="Enter Numbers only" size="30" title="Please enter number of bedrooms" pattern="[0-9]" required="required" min="1" maxlength="30"/></td>
	</tr>
	

	<tr><td><label>Year built</label></td>
	<td><input type="number" name="yearBuilt" size="30" placeholder="Enter Numbers only" title="Please enter the year built " required="required" pattern="[1-9]{1}+[0-9]$" min="1" maxlength="4"/></td>
	</tr>
	
	<tr><td><label>Price</label></td>
	<td><input type="number" name="price" size="30" placeholder="Enter Numbers only" required="required" title="Please enter the price of the property" pattern="[0-9]" min="1" maxlength="15"/></td>
	</tr>
	
	<tr>
	<tr><td><h4>Address:</h4></td> </tr>
	<tr>
	<td><label>Address Line1</label></td>
	<td><input type="text" name="addressLine1" size="30" placeholder="Enter Valid Address" title="Please enter valid address" required="required" min="1" maxlength="100"/></td>
	</tr>
	
	<tr>
	<td><label>Address Line2</label></td>
	<td><input type="text" name="addressLine2" size="30" placeholder="Enter Valid Address" title="Please enter valid address" required="required"  min="1" maxlength="100"/></td>
	</tr>

	<tr><td><label>City</label></td>
	<td><input type="text" name="city" size="30" required="required" placeholder="Enter city" title="Please enter valid city" min="1" pattern="^[0-9]*[a-zA-Z][a-zA-Z0-9]*$" maxlength="100"/></td>
	</tr>
	
	
	<tr>
	<td><label>State</label></td>
	<td><input type="text" name="state" size="30" required="required" placeholder="Enter state" title="Please enter valid state"  min="1" pattern="^[0-9]*[a-zA-Z][a-zA-Z0-9]*$" maxlength="100"/></td>
	</tr>
	
	<tr>
	<td><label>Zipcode</label></td>
	<td><input type="number" name="zipcode" size="30" pattern="[0-9]*" placeholder="Enter zipcode" title="Please enter valid zipcode"  required="required" min="5" maxlength="9"/></td>
	</tr>
	
	<tr>
	<td><label>Select Features from List</label></td>
	<td><select multiple="multiple" name="features" id="features">
	 <c:forEach items="${featuresList}" var="feature">
          <option value="${feature}">${feature}</option>
         </c:forEach>
	</select></td>
	</tr>
	<tr><td> Please select a Image to upload : </td>
	<td><input type="file" name="imagefile" id="imagefile" required="required"  title="Please upload image with extension jpeg, bmp , gif, png , jpg ,  "  /></td></tr>
	
	<tr><td></td>
	<td><input type="submit" class="btn btn-primary" value="Add Property Listing" /></td>
	<td> <input type="hidden" name="action" value="addPropertyListing" /></td>
	</tr>
	</tbody>
	</table>

</form>
</div>
</section>
<!-- 	<div style="display: none;">
	<form method="post" action="/uploadImage" enctype="multipart/form-data">
	  Please select a Image to upload : <input type="file" name="imagefile" />
    <input type="submit" value="Upload Image " />

</form>
</div> -->

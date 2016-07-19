<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
          

<script>
$(document).ready(function () {
    $("#searchByName").click(function (event) {
    	 var agentName = $("#agentName").val();
       $.post("http://localhost:8080/myhome/sell_FindAgent.htm",
    		   {agentName: agentName},
     	 function(obj){
    	    var json = JSON.parse(obj);
				alert(json);
				 $('#ajaxResult').append(json);  
				 });
      
		});
});
</script>
<section>


<form method="POST">
<table>
<tbody>
<tr><td><input type="text" name="agentName" id="agentName" size="30" placeholder="Enter Agent Name" pattern="[a-zA-Z][a-zA-Z0-9\s]*" required="required" min="1" maxlength="30" /></td>
<td><input type="submit" id="searchByName" value="Search Agent By Name"/></td>
<td><input type="hidden" name="action" value="displayAgent" /></td>

</tbody>
</table>
</form>


<div id="ajaxResult">

</div>

</section>
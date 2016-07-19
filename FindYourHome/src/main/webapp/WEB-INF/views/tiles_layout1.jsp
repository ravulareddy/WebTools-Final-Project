<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>  
<html>  
<head>  
<c:url value="/resources/css/tilesLayout.css" var="cssURL"/>
<c:url value="/resources/css/main.css" var="maincssURL"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  

 <link  rel="stylesheet" href="${maincssURL}">
<!-- Latest compiled and minified CSS 
<link  rel="stylesheet" href="${cssURL}"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" ></script>
<title>
<tiles:insertAttribute name="title" ignore="true" />
</title>  
</head>  
<body> 
<div class="container-fluid">
<div class="row">
<div class="col-md-10">
<tiles:insertAttribute name="sideMenu" />
</div>
</div>
<div class="row">
</div>
<div class="row">
<div class="col-md-12">  
       
        <tiles:insertAttribute name="mainContent" />
        
            
    </div>
</div>
  
      <div id="row">
      <div class="col-md-12"> 
        <tiles:insertAttribute name="footer" />
      </div>
    </div>  
</div>
</body>  
</html>  
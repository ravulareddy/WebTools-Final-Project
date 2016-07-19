<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>  
<html>  
<head>  
<c:url value="/resources/css/tilesLayout.css" var="cssURL"/>
<c:url value="/resources/css/main.css" var="maincssURL"/>
<c:url value="/resources/css/mainLayout.css" var="mainLayoutURL"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  


<link  rel="stylesheet" href="${mainLayoutURL}">
<!-- Latest compiled and minified CSS 
<link  rel="stylesheet" href="${mainLayoutURL}">

<link  rel="stylesheet" href="${cssURL}">
<link  rel="stylesheet" href="${maincssURL}">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
-->
<title>
<tiles:insertAttribute name="title" ignore="true" />
</title> 
</head>  
<body> 

<header> 
<h1>Welcome Home</h1>  
<nav>
<tiles:insertAttribute name="navMenu" />
</nav>
</header>
	<article>
		
        <tiles:insertAttribute name="mainContent" />
    <section>
	   <tiles:insertAttribute name="search" />
    </section>
  </article>
        <footer>
        <tiles:insertAttribute name="footer" />
       </footer>
      

</body>  
</html>  
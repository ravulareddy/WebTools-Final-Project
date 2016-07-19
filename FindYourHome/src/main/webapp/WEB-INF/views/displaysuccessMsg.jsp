<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
<div>

<h2>
Success !!
</h2>
<br/>
<c:if test="${not empty requestScope.successMsg}">
<p> ${requestScope.successMsg} </p>
</c:if>
</div>
</section>
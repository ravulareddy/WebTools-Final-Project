<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
<div>

<h2 class="errors">
Error displaying results,
</h2>

<c:if test="${not empty requestScope.errorMsg}">
<p>Reason : ${requestScope.errorMsg}</p>
</c:if>
</div>
</section>
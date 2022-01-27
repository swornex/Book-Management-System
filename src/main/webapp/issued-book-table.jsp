<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="component/header.jsp"%>
<div class="container w-50 mr-0">
    <a href="./" class="btn btn-primary">View Books</a>
    <table class="table">
        <thead>
        <tr>
            <th>Book Id</th>
            <th>Customer Id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="issue" items="${issues}">
            <tr>
                <td>${issue.bookId}</td>
                <td>${issue.customerId}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="component/footer.jsp"%>
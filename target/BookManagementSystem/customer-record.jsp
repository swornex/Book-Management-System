<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="component/header.jsp"%>
<div class="container w-50 mr-0">
    <a href="add-customer" class="btn btn-primary">Add</a>
    <a href="./" class="btn btn-primary">View Books</a>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Contact</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.contact}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="component/footer.jsp"%>
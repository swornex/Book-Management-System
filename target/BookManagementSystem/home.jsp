<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="component/header.jsp"%>
<div class="container w-50 mr-0">
    <a href="books-form" class="btn btn-primary">Add</a>
    <a href="view-customer-records" class="btn btn-primary">Customer Records</a>
    <a href="view-issued-book" class="btn btn-primary">Issued Book Records</a>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Book</th>
            <th>Author</th>
            <th>Page</th>
            <th>Genre</th>
            <th>Stock</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.book}</td>
                <td>${book.author}</td>
                <td>${book.page}</td>
                <td>${book.genre}</td>
                <td>${book.stock}</td>
                <td>
                    <a class="btn btn-primary"
                       href="${pageContext.request.contextPath}/issue-form?id=${book.id}">Issue</a>
                    <a class="btn btn-primary"
                       href="${pageContext.request.contextPath}/books-form?id=${book.id}">Edit</a>
                    <a class="btn btn-danger"
                       href="${pageContext.request.contextPath}/delete-book?id=${book.id}">Delete</a>
                </td>

            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="component/footer.jsp"%>
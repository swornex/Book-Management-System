<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="component/header.jsp"%>
<div class="container w-50 mr-0">
    <a href="books-form" class="btn btn-primary">Add</a>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Book</th>
            <th>Author</th>
            <th>Page</th>
            <th>Genre</th>
            <th>Stock</th>
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
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="component/footer.jsp"%>
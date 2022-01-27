<%@ page isELIgnored="false" %>
<%@include file="component/header.jsp"%>
<div class="container w-50 mr-0">
    <form action ="books-form" method="post">
        <input type="hidden" value="${book.id}" name="id">
        <div class="mb-3">
            <label class="form-label">Book Name:</label>
            <input type="text" class="form-control" value="${book.book}" placeholder="Half-GirlFriend" name="book-name">
        </div>
        <div class="mb-3">
            <label class="form-label">Author:</label>
            <input type="text" class="form-control" value="${book.author}" placeholder="Chetan Bhagat" name="author">
        </div>
        <div class="mb-3">
            <label class="form-label">Genre:</label>
            <input type="text" class="form-control" value="${book.genre}" placeholder="Romance" name="genre">
        </div>
        <div class="mb-3">
            <label class="form-label">Page:</label>
            <input type="text" class="form-control" value="${book.page}" placeholder="280" name="page">
        </div>
        <div class="mb-3">
            <label class="form-label">Stock:</label>
            <input type="text" class="form-control" value="${book.stock}" placeholder="20" name="stock">
        </div>
        <button type="submit" class="btn btn-primary">${action}</button>
    </form>
</div>
<%@include file="component/footer.jsp"%>
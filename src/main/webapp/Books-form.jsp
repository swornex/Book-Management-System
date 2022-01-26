<%@ page isELIgnored="false" %>
<%@include file="component/header.jsp"%>
<div class="container w-50 mr-0">
    <form action ="books-form" method="post">
        <div class="mb-3">
            <label class="form-label">Book Name:</label>
            <input type="text" class="form-control" placeholder="Half-GirlFriend" name="book-name">
        </div>
        <div class="mb-3">
            <label class="form-label">Author:</label>
            <input type="text" class="form-control" placeholder="Chetan Bhagat" name="author">
        </div>
        <select class="form-select" aria-label="Default select example" name="genre">
            <option selected>select genre...</option>
            <option value="Romance">Romance</option>
            <option value="Fiction">Fiction</option>
            <option value="Fantasy">Fantasy</option>
            <option value="Suspense">Suspense</option>
            <option value="Thriller">Thriller</option>
            <option value="Horror">Horror</option>
            <option value="Sci-Fi">Sci-Fi</option>
        </select>
        <div class="mb-3">
            <label class="form-label">Page:</label>
            <input type="text" class="form-control" placeholder="280" name="page">
        </div>
        <div class="mb-3">
            <label class="form-label">Stock:</label>
            <input type="text" class="form-control" placeholder="20" name="stock">
        </div>
        <button type="submit" class="btn btn-primary">${action}</button>
    </form>
</div>
<%@include file="component/footer.jsp"%>
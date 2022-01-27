<%@ page isELIgnored="false" %>
<%@include file="component/header.jsp"%>
<div class="container w-50 mr-0">
    <form action ="issue-form" method="post">
        <div class="mb-3">
            <label class="form-label">Customer Id:</label>
            <input type="text" class="form-control" name="customer-Id">
        </div>
            <input type="hidden" value="${bookId}" name="book-Id">
        <button type="submit" class="btn btn-primary">Issue</button>
    </form>
</div>
<%@include file="component/footer.jsp"%>

<%@ page isELIgnored="false" %>
<%@include file="component/header.jsp"%>
<div class="container w-50 mr-0">
    <form action ="add-customer" method="post">
        <div class="mb-3">
            <label class="form-label">Customer Name:</label>
            <input type="text" class="form-control" placeholder="Swornima" name="customer-name">
        </div>

        <div class="mb-3">
            <label class="form-label">Contact No:</label>
            <input type="text" class="form-control" placeholder="9801000120" name="contact">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@include file="component/footer.jsp"%>
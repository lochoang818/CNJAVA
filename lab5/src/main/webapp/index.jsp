<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Danh sách sản phẩm</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="js/confirm-dialog.js"></script>
</head>
<body style="background-color: #f8f8f8">

<div class="container-fluid p-5">
  <div class="row mb-5">
    <div class="col-md-6">
      <h3>Product Management</h3>
    </div>
    <div class="col-md-6 text-right">
      Xin chào <span class="text-danger">${User.userName}!</span> | <a href="/LoginServlet">Logout</a>
    </div>
  </div>
  <div class="row rounded border p-3">
    <div class="col-md-4">
      <h4 class="text-success">Thêm sản phẩm mới</h4>
      <form class="mt-3" method="post" action = "/ProductServlet">
        <div class="form-group">
          <label for="product-name">Tên sản phẩm</label>
          <input class="form-control" type="text" placeholder="Nhập tên sản phẩm" id="product-name" name="name" required>
        </div>
        <div class="form-group">
          <label for="price">Giá sản phẩm</label>
          <input class="form-control" type="number" placeholder="Nhập giá bán" id="price" name="price" required>
        </div>
        <div class="form-group">
          <button type = "submit" class="btn btn-success mr-2">Thêm sản phẩm</button>
        </div>

        <c:if test="${not empty requestScope.errorMessage}">
          <div class="alert alert-danger">
              ${requestScope.errorMessage}
          </div>
        </c:if>
      </form>
    </div>
    <div class="col-md-8">
      <h4 class="text-success">Danh sách sản phẩm</h4>
      <p>Chọn một sản phẩm cụ thể để xem chi tiết</p>
      <table class="table table-striped">
        <thead>
        <tr>
          <th>STT</th>
          <th>Tên sản phẩm</th>
          <th>Giá</th>
          <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
          <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>

              <form action="/ProductServlet" method="post" style="display: inline;">
                <input type="hidden" name="id" value="${product.id}">
                <input type="hidden" name="action" value="delete">
                <button type="button" class="btn btn-danger delete-product">Delete</button>
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
<script>
  // Add the following code if you want the name of the file appear on select
  $(".custom-file-input").on("change", function() {
    var fileName = $(this).val().split("\\").pop();
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
  });

  $(document).ready(function() {
    $(".delete-product").click(function(event) {
      event.preventDefault();

      if (confirm("Are you sure you want to delete this product?")) {
        $(this).closest("form").submit();
      }
    });
  });
</script>
</body>
</html>
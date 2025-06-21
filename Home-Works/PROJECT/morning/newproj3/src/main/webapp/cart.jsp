<%@ page import="com.pojo.*"%>
<%@ page import="java.util.*" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Untree.co">
  <link rel="shortcut icon" href="favicon.png">
  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <link href="css/tiny-slider.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <title>Furni Cart </title>
  <style>
    .remove-col {
      display: none;
    }
    .cart-show-remove .remove-col {
      display: table-cell;
    }
  </style>
</head>
<body>
  <%@include file="customerheader.jsp" %>
  <div class="untree_co-section before-footer-section">
    <div class="container">
      <div class="row mb-5">
        <form class="col-md-12" method="post" action="CartServlet">
          <input type="hidden" name="action" value="update">
          <div class="site-blocks-table">
            <table class="table cart-table">
              <thead>
                <tr>
                  <th class="product-thumbnail">Image</th>
                  <th class="product-name">Product</th>
                  <th class="product-price">Price</th>
                  <th class="product-quantity">Quantity</th>
                  <th class="product-total">Total</th>
                  <th class="remove-col">Remove</th>
                </tr>
              </thead>
              <tbody>
              <%
                List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
                double total = 0.0;
                if (cartItems != null) {
                  for (CartItem item : cartItems) {
                    double itemTotal = item.getPrice() * item.getQuantity();
                    total += itemTotal;
              %>
                <tr>
                  <td class="product-thumbnail">
                    <img src="<%=item.getImagePath()%>" alt="Image" class="img-fluid">
                  </td>
                  <td class="product-name">
                    <h2 class="h5 text-black"><%=item.getName()%></h2>
                  </td>
                  <td class="price">$<%=item.getPrice()%></td>
                  <td>
                    <div class="input-group mb-3 d-flex align-items-center quantity-container" style="max-width: 120px;">
                      <div class="input-group-prepend">
                        <button class="btn btn-outline-black decrease" type="button">&minus;</button>
                      </div>
                      <input type="text" class="form-control text-center quantity-amount" name="quantity_<%=item.getId()%>" value="<%=item.getQuantity()%>">
                      <div class="input-group-append">
                        <button class="btn btn-outline-black increase" type="button">&plus;</button>
                      </div>
                    </div>
                  </td>
                  <td class="item-total">$<%=itemTotal%></td>
                  <td class="remove-col"><a href="RemoveItemServlet?id=<%=item.getId()%>" class="btn btn-black btn-sm">X</a></td>
                </tr>
              <%
                  }
                }
                session.setAttribute("total",total);
              %>
              </tbody>
            </table>
          </div>
          <div class="row mt-3">
            <div class="col-md-6">
              <button id="updateCartBtn" type="submit" class="btn btn-black btn-sm btn-block">Update Cart</button>
            </div>
            <div class="col-md-6">
              <a href="shop.jsp" class="btn btn-outline-black btn-sm btn-block">Continue Shopping</a>
            </div>
          </div>
        </form>
      </div>
      <div class="row">
        <div class="col-md-6"></div>
        <div class="col-md-6 pl-5">
          <div class="row justify-content-end">
            <div class="col-md-7">
              <div class="row">
                <div class="col-md-12 text-right border-bottom mb-5">
                  <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-6">
                  <span class="text-black">Subtotal</span>
                </div>
                <div class="col-md-6 text-right">
                  <strong id="cart-subtotal" class="text-black">$<%=String.format("%.2f", total)%></strong>
                </div>
              </div>
              <div class="row mb-5">
                <div class="col-md-6">
                  <span class="text-black">Total</span>
                </div>
                <div class="col-md-6 text-right">
                  <strong class="text-black">$<%=String.format("%.2f", total)%></strong>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <button class="btn btn-black btn-lg py-3 btn-block" onclick="window.location='checkout.jsp'">Proceed To Checkout</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <%@include file="footer.jsp" %>
  <script src="js/bootstrap.bundle.min.js"></script>
  <script src="js/tiny-slider.js"></script>
  <script src="js/custom.js"></script>
  <script src="js/cart.js"></script>
</body>
</html>
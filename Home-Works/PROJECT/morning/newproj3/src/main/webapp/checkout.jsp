<%@page import="com.pojo.CartItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <title>Furni Checkout</title>
  <style>
    .payment-method {
      margin-bottom: 20px;
    }
    .payment-details {
      padding: 15px;
      background: #f8f9fa;
      border-radius: 5px;
      margin-top: 10px;
      display: none;
    }
    .form-check {
      margin-bottom: 10px;
    }
  </style>
</head>

<body>
<%@include file="customerheader.jsp" %>

<div class="untree_co-section">
  <div class="container">
    <div class="row mb-5">
      <div class="col-md-12">
        <div class="border p-4 rounded" role="alert">
          Returning customer? <a href="cart.jsp">Click here</a> to go back to cart
        </div>
      </div>
    </div>

    <!-- Checkout Form -->
    <form action="OrderServlet" method="post" id="checkoutForm">
      <div class="row">
        <!-- Billing Details -->
        <div class="col-md-6 mb-5 mb-md-0">
          <h2 class="h3 mb-3 text-black">Billing Details</h2>
          <div class="p-3 p-lg-5 border bg-white">
            <div class="form-group">
              <label for="billingName" class="text-black">Full Name <span class="text-danger">*</span></label>
              <input type="text" class="form-control" id="billingName" name="billingName" required>
            </div>

            <div class="form-group">
              <label for="billingAddress" class="text-black">Address <span class="text-danger">*</span></label>
              <textarea class="form-control" id="billingAddress" name="billingAddress" style="height: 100px" required></textarea>
            </div>

            <div class="form-group row">
              <div class="col-md-6">
                <label for="billingState" class="text-black">State / Country <span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="billingState" name="billingState" required>
              </div>
              <div class="col-md-6">
                <label for="billingZip" class="text-black">Postal / Zip <span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="billingZip" name="billingZip" required>
              </div>
            </div>

            <div class="form-group row mb-5">
              <div class="col-md-6">
                <label for="billingEmail" class="text-black">Email Address <span class="text-danger">*</span></label>
                <input type="email" class="form-control" id="billingEmail" name="billingEmail" required>
              </div>
              <div class="col-md-6">
                <label for="billingPhone" class="text-black">Phone <span class="text-danger">*</span></label>
                <input type="tel" class="form-control" id="billingPhone" name="billingPhone" required>
              </div>
            </div>

            <!-- Ship to Different Address -->
            <div class="form-group">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="1" id="c_ship_different_address">
                <label class="form-check-label text-black" for="c_ship_different_address">
                  Ship To A Different Address?
                </label>
              </div>
              
              <div class="collapse" id="ship_different_address">
                <div class="py-2">
                  <div class="form-group">
                    <label for="c_diff_country" class="text-black">Country <span class="text-danger">*</span></label>
                    <select id="c_diff_country" class="form-control">
                      <option value="1">Select a country</option>    
                      <option value="2">bangladesh</option>    
                      <option value="3">Algeria</option>    
                      <option value="4">Afghanistan</option>    
                      <option value="5">Ghana</option>    
                      <option value="6">Albania</option>    
                      <option value="7">Bahrain</option>    
                      <option value="8">Colombia</option>    
                      <option value="9">Dominican Republic</option>    
                    </select>
                  </div>
            
                  <div class="form-group">
                    <label for="shippingName" class="text-black">Full Name <span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="shippingName" name="shippingName">
                  </div>

                  <div class="form-group">
                    <label for="shippingAddress" class="text-black">Address <span class="text-danger">*</span></label>
                    <textarea class="form-control" id="shippingAddress" name="shippingAddress" style="height: 100px"></textarea>
                  </div>

                  <div class="form-group row">
                    <div class="col-md-6">
                      <label for="shippingState" class="text-black">State / Country <span class="text-danger">*</span></label>
                      <input type="text" class="form-control" id="shippingState" name="shippingState">
                    </div>
                    <div class="col-md-6">
                      <label for="shippingZip" class="text-black">Postal / Zip <span class="text-danger">*</span></label>
                      <input type="text" class="form-control" id="shippingZip" name="shippingZip">
                    </div>
                  </div>

                  <div class="form-group row">
                    <div class="col-md-6">
                      <label for="shippingEmail" class="text-black">Email Address</label>
                      <input type="email" class="form-control" id="shippingEmail" name="shippingEmail">
                    </div>
                    <div class="col-md-6">
                      <label for="shippingPhone" class="text-black">Phone</label>
                      <input type="tel" class="form-control" id="shippingPhone" name="shippingPhone">
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div> <!-- End of billing details column -->

        <!-- Order Summary -->
        <div class="col-md-6">
          <div class="row mb-5">
            <div class="col-md-12">
              <h2 class="h3 mb-3 text-black">Your Order</h2>
              <div class="p-3 p-lg-5 border bg-white">
                <table class="table site-block-order-table mb-5">
                  <thead>
                    <tr>
                      <th>Product</th>
                      <th>Total</th>
                    </tr>
                  </thead>
                  <tbody>
                    <%@ page import="java.util.*, com.pojo.CartItem" %>
<%
  List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cartItems");
  Double grandTotal = (Double) session.getAttribute("grandTotal");
  if (grandTotal == null) grandTotal = 0.0;
%>
<%
  if (cartItems != null) {
    for (CartItem item : cartItems) {
%>
<tr>
  <td><%=item.getName()%> <strong class="mx-2">x</strong> <%=item.getQuantity()%></td>
  <td>$<%=item.getPrice() * item.getQuantity()%></td>
</tr>
<%
    }
  }
%>
<tr>
  <td class="text-black font-weight-bold"><strong>Cart Subtotal</strong></td>
  <td class="text-black">$<%=grandTotal%></td>
</tr>
<tr>
  <td class="text-black font-weight-bold"><strong>Order Total</strong></td>
  <td class="text-black font-weight-bold"><strong>$<%=grandTotal%></strong></td>
</tr>
                  </tbody>
                </table>

                <!-- Payment Options -->
                <div class="payment-method">
                  <h3 class="h6 mb-3 text-black">Payment Method</h3>
                  <div class="form-check">
                    <input class="form-check-input" type="radio" name="paymentMethod" 
                           id="codPayment" value="COD" required checked>
                    <label class="form-check-label" for="codPayment">
                      Cash on Delivery
                    </label>
                  </div>
                  <div class="form-check">
                    <input class="form-check-input" type="radio" name="paymentMethod" 
                           id="onlinePayment" value="Online" required>
                    <label class="form-check-label" for="onlinePayment">
                      Online Payment
                    </label>
                  </div>
                  
                  <div class="payment-details" id="onlinePaymentDetails">
                    <div class="form-group mt-3">
                      <label>Card Number</label>
                      <input type="text" class="form-control" name="cardNumber" 
                             placeholder="1234 5678 9012 3456" id="cardNumber">
                    </div>
                    <div class="form-group">
                      <label>Expiry Date</label>
                      <input type="text" class="form-control" name="expiryDate" 
                             placeholder="MM/YY" id="expiryDate">
                    </div>
                    <div class="form-group">
                      <label>CVV</label>
                      <input type="text" class="form-control" name="cvv" 
                             placeholder="123" id="cvv">
                    </div>
                  </div>
                </div>

                <div class="form-group">
                  <button type="submit" class="btn btn-black btn-lg py-3 btn-block">Place Order</button>
                </div>
              </div>
            </div>
          </div>
        </div> <!-- End of order summary column -->
      </div> <!-- End of row -->
    </form>
  </div>
</div>

<%@include file="footer.jsp" %>

<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/tiny-slider.js"></script>
<script src="js/custom.js"></script>
</body>

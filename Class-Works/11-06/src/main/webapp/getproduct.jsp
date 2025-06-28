
<%@page import="com.ips.pojo.Product"%>
<%@page import="com.ips.daoimpl.ProductDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>IPS Academy</h1>
<p>place for IT & CS Students.</p>
<br>
<hr>
<br>
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
{
	out.println(msg);
}

%>
<br>

<%
int pid=0;
try
{
	pid = Integer.parseInt(request.getParameter("s1"));		
}
catch(NumberFormatException e)
{
	
}

ProductDaoImpl daoimpl = new ProductDaoImpl();
Product pd = daoimpl.searchProduct(pid);
	
	if(pd!=null)
	{
	%>
	<form action="saveproduct.jsp">
	Product - Id<input type="text" name="pid" value="<%=pd.getPid()%>"><br><br>
	Product - Name<input type="text" name="pname" value="<%=pd.getPname()%>"><br><br>
	Product - Price<input type="text" name="price" value="<%=pd.getPrice()%>"><br><br>
	<input type="submit" value="Update Product Details" name="b1">
	<%
	}
	else
	{
		out.print("<h1>Record Not Found</h1>");
	}
	 %>
	<br>
	<br>
	
	<a href="home.jsp">Back To Product Home Page</a>
	</form>
</table>
<br>
<br>


<br>
<br>
<hr>
<address>
IPS Academty ,Indore
</address>
</center>
</body>
</html>
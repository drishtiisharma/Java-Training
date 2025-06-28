<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
int add(int x,int y)
{
	return x+y;
}

int sub(int x,int y)
{
	return x-y;
}

int multi(int x,int y)
{
	return x*y;
}

int div(int x,int y)
{
	return x/y;
}

%>

<%
int x = add(100,200);
out.println("<br>Sum = "+x);

x = sub(100,200);
out.println("<br>Diff = "+x);

x = multi(100,200);
out.println("<br>Product = "+x);

x = div(100,200);
out.println("<br>Quotient = "+x);

%>



</body>
</html>


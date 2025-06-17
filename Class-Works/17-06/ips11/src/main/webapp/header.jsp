<center>
<img src="images/cropped-jit-logo1.png">
<h1 style="color: blue;">IPS E - Shopping</h1>
<font color=blue size = 3>
WELCOME
</font>
<%
String user = (String)session.getAttribute("user");
if(user!=null)
{
	out.print(user);
}
%>
<hr>

<br><br><br><br>
<%
String sms = (String)request.getAttribute("sms");
if(sms!=null)
{
	out.print(sms);
}
%>
<br>

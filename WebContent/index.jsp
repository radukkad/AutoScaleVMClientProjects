<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SJSU Group 6</title>
</head>

<body>
<h1>Welcome SJSU Fall-13 Group6 Project</h1>
<%

java.net.InetAddress addr = java.net.InetAddress.getLocalHost();
String hostname = addr.getHostName();

%>

<h2>Served by :</h2>
<h3>Hostname : <%=hostname%></h3>
<br>
<br>
<a href="SessionDestroy.jsp">Session Destroy</a>
</body>
</html>
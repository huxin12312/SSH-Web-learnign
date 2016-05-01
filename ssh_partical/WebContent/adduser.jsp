<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "/" + request.getServerName() + "/"  + request.getServerPort() + path + "/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User!</title>
</head>
<body>
  <center>  <h1> Add new user</h1>
  <form action = "user!addUser.action" method="post">
        user id<input type = "text" name = "user.id"/><br/>
        user name <input type = "text" name = "user.name"> <br/>
        user company <input type = "text" name = "user.company"> <br/>
        user date <input type = "date" name = "user.date" min = "1900-01-01"><br/>
        user email <input type = "email" name = "user.email" > <br/>
  </form>
    
  </center>
</body>
</html>
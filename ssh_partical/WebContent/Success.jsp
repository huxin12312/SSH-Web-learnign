<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "/" + request.getServerName() + "." + request.getServerPort() + path + "/";
    %>
    <!-- type C prefix -->
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Successful page</title>
<style type="text/css">
td{
  text-align : center;
  width: 100px;
}
</style>
</head>
<body>
<!-- checkUser Action return user1 for user's name-->
    <div align="right">Welcome, ${user1.name } | <a href="logout.jsp">Exit</a>
    </div>
        <center>
    		<table border="1">
    			<tr>
    				<td>user id</td><td>user name</td><td>company</td><td colspan="2" style="center">Options</td>
    			</tr>

                <!-- iterative database to return the list which include the correct information -->
    			<c:forEach items="${users}" var="u">

    				<tr>
    					<td>${u.id}</td><td>${u.name}</td><td>${u.company}</td><td><a href="user!deleteUser.action?user.id=${u.id}">Delete</a></td><td><a href="user!updateUser.action?user.id=${u.id}">Modify</a></td>
    				</tr>
    			</c:forEach>
    			
    		</table>
    		<br/>

            <!-- user option bottom redirect to adduser page -->
    		<input type="submit" value="Add User" onclick="window.location.href='adduser.jsp'"/> 
    	</center>
    	<br>
    	<br>
    	<br>
    	<br>
    	
        <!-- 查询用户输入框，包含 name、company 两种查询条件 -->
    	<center>
		   	<form action="user!queryUser.action" method="post">
		   		user name<input type="text" name="user.name"/>&nbsp;&nbsp;&nbsp;&nbsp;
		   		company<input type="text" name="user.company"/>&nbsp;&nbsp;&nbsp;&nbsp;	
		   		<input type="submit" value="Search"/>
		   </form>
    	</center>
    	<br>
    	<br>
    	<br><br>


        <!-- tag>0 if valid search info-->
    	<c:if test="${tag>0}">
    	<center>
    		<table border="1">

                <!-- return the users name and company -->
    			<tr>
    				<td>user id</td><td>user name</td><td>company</td>
    			</tr>


    			<!-- searched by using queryUser() -->
                <c:forEach items="${users2}" var="u">
    				<tr>
    					<td>${u.id}</td><td>${u.name}</td><td>${u.company }</td>
    				</tr>
    			</c:forEach>
    			
    		</table>
    		
    	</center>
    	</c:if>

</body>
</html>
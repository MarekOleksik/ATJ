<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New user confirmation</title>
</head>
<body>
  <h1>New user has been registered.</h1>
  <table>
    <tr>
      <td><label>E-mail: </label></td>
      <td><b>${user.getEmail()}</b></td>
    </tr>
    <tr>
      <td><label>Rights:</label></td>
      <td><b>${user.getRights()}</b></td>
    </tr>
    <tr>
      <td><label>Access :</label></td>
      <td><b>
        <c:forEach items="${user.getAccess()}" var="access">
          ${access}<br>
        </c:forEach>
      </b></td>
    </tr>
    <tr>
      <td><label>Password:</label></td>
      <td><b>${user.getPassword()}</b></td>
    </tr>    
  </table>
</body>
</html>
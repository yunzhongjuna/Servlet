<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1> <a href="add.html">增加</a></h1>
<h1>

<table border="1">
<c:forEach var="reader" items="${readers}" >
   <tr>
   		<td>${reader.readID }</td>
        <td>${reader.name }</td>
        <td>${reader.age }</td>
        <td>${reader.tel }</td>
        <td><a href="editUser?editID=${reader.readID}">编辑</a></td>
        <td><a href="deleteUser?deleteID=${reader.readID}">删除</a></td>
    </tr>
</c:forEach>
</table>
</h1>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="reader" items="${readers}">
		<form action="editUser" method="post">
			姓名<input type="text" name="Name" id="name" value="${reader.name }" /><br>
			性别<input type="text" name="Age" id="age" value="${reader.age }" /><br>
			电话 <input type="text" name="Tel" id="tel" value="${reader.tel }" /><br>
			<input type="submit" value="update" onclick="update()" />
		</form>
	</c:forEach>
	<script type="text/javascript">
		function update() {
			alert("更新成功！");
		}
	</script>
</body>
</html>
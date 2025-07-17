<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Servlet 계산기</h3>
    <!-- el로 contextPath 확인 -->
    <form name="form1" action="${pageContext.request.contextPath}/servlet/CalcServlet2" method="post">
        <input type="number" name="num1" size="5" required>
        <select name="operator">
            <option value="+" selected>+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
        <input type="number" name="num2" size="5" required>
        <button type="submit">계산</button>
        <button type="reset">초기화</button>
    </form>
    <h3>결과: </h3>
    <h3>결과: </h3>
</body>
</html>
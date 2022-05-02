<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>read.jsp</title>
</head>
<body>

<h3>상세보기 Page</h3>
<table border="1">
    <tr>
        <th>상품코드</th>
        <td>${productDTO.code}</td>
    </tr>
    <tr>
        <th>상품이름</th>
        <td>${productDTO.name}</td>
    </tr>
    <tr>
        <th>상품가격</th>
        <td>${productDTO.price}</td>
    </tr>
    <tr>
        <th>상품설명</th>
        <td>${productDTO.detail}</td>
    </tr>
    <tr>
        <th colspan="2">
            <a href="${pageContext.request.contextPath}/index.kosta">홈으로</a>
        </th>
    </tr>
</table>


</body>
</html>
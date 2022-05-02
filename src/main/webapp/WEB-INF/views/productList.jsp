<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>productList.jsp</title>
    <style type="text/css">
        table {
            width: 800px;
            border: 5px green solid;
        }

        td, th {
            text-align: center;
            border: 1px gray solid;
        }

        a {
            text-decoration: none;
        }
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>


<body>
<table>
    <caption>
        <h1>[ Product List Page ]</h1>
    </caption>
    <%-- inside for statement, take out productList --%>
    <tr>
        <th>번호</th>
        <th>상품코드</th>
        <th>상품이름</th>
        <th>상품가격</th>
        <th>상품설명</th>
        <th>삭제하기</th>
    </tr>
    <c:forEach varStatus="loop" var="product" items="${productDTOList}">
        <tr>
            <td>${loop.index}</td>
            <td>${product.code}</td>
            <td><a href="${pageContext.request.contextPath}/read.kosta?code=${product.code}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.detail}</td>
            <td>
                <a href="${pageContext.request.contextPath}/del/${product.code}">
                    <button>X</button> <!-- omitted id="$ {delete.kosta}" -->
                </a>
            </td>
        </tr>
    </c:forEach>


    <tr>
        <th colspan="6"><a href="insertForm.kosta">상품등록하기</a></th>
    </tr>

</table>


<script>
    /*
    $(function(){
        console.log("jQuery loaded..");

        $("button").on("click", function() {
            let productCode = $(this).attr("id")

            //AJAX call delete.kosta w/ productCode as data
            $.ajax({
                url:"delete.kosta",
                type:"get",
                dataType:'json',
                data:{'productCode': productCode},
                success: function() {
                    alert("Product Deletion Successful");
                },
                error: function() {
                    alert("Product Deletion Failure");
                }
            })//end of ajax
        })

    })//end of jQuery
     */
</script>


</body>


</html>
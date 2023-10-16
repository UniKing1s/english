<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!--JSTL-->
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Word List</title>
    <style>
        * { /* reset lại margin và padding cho các tag */
            margin: 0;
            padding: 0;
        }
        .tableStyle {
            width: 100%;
        }
        .tableStyle td {
            height: 60px;
            padding: 10px;
        }
        .fontText{
            color: white;
        }
        .alignL { text-align: left; }
        .alignC { text-align: center; }
        .alignR { text-align: right; }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <jsp:include page = "header.jsp"></jsp:include>
    <jsp:include page = "menu.jsp"></jsp:include>
    <!--Content-->
    <h1>Word List</h1>
    <table class="tableStyle" border="1" cellpadding ="5" cellspacing = "1"> 
        <tr class="fontText" >
            <td class="alignC" style="background: #150003 ;"><b>English</b></td>
            <td class="alignC" style="background: #150003 ;"><b>Tiếng Việt</b></td>
            <td class="alignC" style="background: #150003 ;"><b>Thời Gian Chỉnh Sửa</b></td>
            <td class="alignC" colspan="2" style="background-color: skyblue;"><a href="add" style="text-decoration: none;"> <b><font style="color: black;">Thêm từ</font></b></a></td>
        </tr>
        <c:if test="${not empty list}">
            <c:forEach var="c" items="${list}">
                <tr class="fontText" style="background-color: #152c48;" >
                    <td class="alignC"><font>${c.word}</font></td>
                    <td class="alignC"><font>${c.mean}</font></td>
                    <td class="alignC"><font>${c.time}</font></td>
                    <td class="alignC" style="background-color: indianred;"><a href="edit?word=${c.word}" style="text-decoration: none;"> <b><font style="color: white;">Sửa</font></b> </a></td>
                    <td class="alignC" style="background-color: cyan;"><a href="delete?word=${c.word}" style="text-decoration: none;"> <b><font style="color: black;">Xóa</font></b></a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <jsp:include page = "footer.jsp"></jsp:include>

</body>
</html>
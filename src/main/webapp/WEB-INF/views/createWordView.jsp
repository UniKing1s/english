<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!--JSTL-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>English Home</title>
</head>
<body>
    <jsp:include page = "header.jsp"></jsp:include>
    <jsp:include page = "menu.jsp"></jsp:include>
    <!--Content-->
    <h1>Add Word page</h1>
    <form action="" method="post">
        <table>
            <tr>
                <td>Word</td>
                <td><input type="text" name="word" placeholder="Hello" required></td>
            </tr>
            <tr>
                <td>Mean</td>
                <td><input type="text" name="mean" placeholder="Xin chào" required></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="Submit"></td>
                <td><input type="submit" name="submit" value="Cancel"></td>
            </tr>
        </table>
    </form>
    
    <jsp:include page = "footer.jsp"></jsp:include>

</body>
</html>
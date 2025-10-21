<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Success</title>
    <script>
        setTimeout(()=>{window.location.href="${pageContext.request.contextPath}"}, 2000)
    </script>
</head>
<body style="background-color:rgb(0,0,0); margin:0; display: flex; justify-content: center; align-items: center;">
        <img src="${pageContext.request.contextPath}/image/error404.jpg" style="height: 100vh;"/>
</body>
</html>
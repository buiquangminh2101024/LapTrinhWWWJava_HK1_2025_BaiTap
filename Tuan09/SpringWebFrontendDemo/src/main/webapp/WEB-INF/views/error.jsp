<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Not Found</title>
    <style>
        body {
            margin: 0;
        }
        .container {
            background-color:rgb(0,0,0);
            width: 100vw; height: 100vh;
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        img {
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <img src="${pageContext.request.contextPath}/images/error404.jpg"/>
    </div>
</body>
</html>
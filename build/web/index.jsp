<%-- 
    Document   : index
    Created on : Jun 12, 2018, 9:56:26 AM
    Author     : DEll
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background: url('http://www.roelofsinterieurs.nl/beheer/upload/editor_images/ict/26.jpg');
                background-attachment: fixed;
                background-position: center;
                background-size: cover;
            }
            .a{
                position: absolute;
                margin: auto;
                top: 0;
                bottom: 0;
                right: 0;
                left: 0;
                width: 400px;
                height: 300px;
                background-color: white;
                text-align: center;
                //padding: 100px;
            }
            .btn{
                font-family: inherit;
                font-size: 30px;
                background-color: lightgrey
            }

            //linear-gradient(rgba(47, 23, 15, 0.65), rgba(47, 23, 15, 0.65)),
            //linear-gradient(rgba(47, 23, 15, 0.4), rgba(47, 23, 15, 0.4)), 
        </style>
    </head>
    <body>
        <form action="AdminLogin.jsp">
        <div class="a">
            <img src="logo1.png">
            <br>
            <br>
            <br>
            <br>
            <br>
            <div>
                <button type="submit" name="action" class="btn">Admin</button>
                <button type="submit" name="action" formaction="CustomerLogin.jsp" class="btn">Customer</button>
<!--                    <button class="btn"><a href="AdminLogin.jsp">Admin</button>
                    <button class="btn"><a href="CustomerLogin.jsp">Customer</button>-->
            </div>
        </div>
        </form>
    </body>
</html>

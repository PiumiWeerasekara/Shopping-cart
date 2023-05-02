<%-- 
    Document   : SearchItem
    Created on : Jun 19, 2018, 9:47:52 PM
    Author     : DEll
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>JSP Page</title>
        <style>
            body {
                background: url('http://www.roelofsinterieurs.nl/beheer/upload/editor_images/ict/26.jpg');
                background-attachment: fixed;
                background-position: center;
                background-size: cover;
            }
            .button {
                background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 5px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                -webkit-transition-duration: 0.4s; /* Safari */
                transition-duration: 0.4s;
                cursor: pointer;
            }
            .a{
                display: flex;
                position: absolute;
                margin: auto;
                top: 0;
                bottom: 0;
                right: 0;
                left: 0;
                width: 500px;
                height: 200px;
                background-color: #ffffff;
                text-align: center;
                opacity: 0.9;

                //padding: 100px;
            }
            .b{
                position: absolute;
                margin: auto;
                top: 0;
                bottom: 0;
                right: 0;
                left: 0;
                width: 500px;
                height: 50px;
            }
            .search{
                background-color: #66ffff;
                border: none;
                color: black;
                padding: 5px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 20px;
                size: 12px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <form action="SearchItemController">
            <div class="a">
                <div class="b">
                    <input type="text" name="name" size="30px" placeholder="Enter Item Name">
                    <button type="submit" class="search">Search</button>
                    <br>
                    <a href="AdminMain.jsp" class="button back">Back</a>
                </div>

            </div>
        </form>
    </body>
</html>

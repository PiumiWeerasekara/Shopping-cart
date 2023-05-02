<%-- 
    Document   : CustomerLogin
    Created on : Jun 15, 2018, 6:34:12 AM
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
            .a{
                position: absolute;
                margin: auto;
                top: 0;
                bottom: 0;
                right: 0;
                left: 0;
                width: 500px;
                height: 450px;
                background-color: #ffffff;
                text-align: center;
                opacity: 0.7;

                //padding: 100px;
            }
            .back{
                background-color: #009966; 
                border: none;
                color: black;
                padding: 5px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                size: 6px;
                float: left;
            }
            .log{
                background-color: lightgreen; 
                border: none;
                color: black;
                padding: 5px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 20px;
            }
            .cancel{
                background-color: lightpink; 
                border: none;
                color: black;
                padding: 5px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 20px;
                size: 12px;
            }
            #name{
                border-color: black;
                background-color: white
            }
            #password{
                border-color: black;
                background-color: white
            }
            #img{
                display: block;
                margin-right: auto;
                margin-left: auto;

            }


            .lbl{
                font-size: 25px;
            }

            //linear-gradient(rgba(47, 23, 15, 0.65), rgba(47, 23, 15, 0.65)),
            //linear-gradient(rgba(47, 23, 15, 0.4), rgba(47, 23, 15, 0.4)), 
        </style>
    </head>
    <body>
        <form action="CustomerLoginController" method="POST">
            <div class="a">
                <br>
                <img src="icons8-customer-96.png" id="img">
                <h2>Customer Login</h2>
                <br>
                <div class="form-group row">
                    <div class="col-md-9">
                        <label class="lbl">Name :</label>
                        <input type="text" id="name" name="name" size="27" autofocus/> 
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-md-9">
                        <label class="lbl">Password :</label>
                        <input type="password" id="password" name="password"/> 
                    </div>
                </div>
                <br>
                <br>
                <div>
                    <button type="submit" class="log" name="action" formaction="CustomerLoginController">Login</button>
                    <a href="CustomerLogin.jsp" class="cancel" >Cancel</a>
                    <br>
                    <a href="index.jsp" class="back">Back</a>
                </div>
            </div>
        </form>
    </body>
</html>

<%-- 
    Document   : AdminMain
    Created on : Jun 15, 2018, 7:37:12 PM
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
                width: 700px;
                height: 500px;
                background-color: #ffffff;
                text-align: center;
                opacity: 0.9;

                //padding: 100px;
            }
            .b{
                width: 150px;
                height: 500px;
                background-color: black;
            }
            #btn{
                border-color: black;
                size: 30px;
                font-size: 25px;
                background-color:black; 
                color: white;
            }
            .logOut{
                background-color: #ff9999;
                border: none;
                color: black;
                padding: 5px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 20px;
                float: right; 
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
            /*            #icon{
                            background-color: black;
                            float: left;
                        }*/


            .lbl{
                font-size: 25px;
            }
            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f1f1f1;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content a:hover {background-color: #ddd}

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .dropdown:hover .dropbtn {
                background-color: #3e8e41;
            }

            //linear-gradient(rgba(47, 23, 15, 0.65), rgba(47, 23, 15, 0.65)),
            //linear-gradient(rgba(47, 23, 15, 0.4), rgba(47, 23, 15, 0.4)), 
        </style>
    </head>
    <body>
        <form>
            <div class="a">
                <a href="AdminLogin.jsp" class="logOut">LogOut</a>
                <div class="b">

                    <!--                    <button id="icon">
                                <img src="icons8-customer-filled-50.png">
                                <button>-->
                    <br>
                    <br>
                    <br>
                    <br>
                    <div class="form-group row">
                        <div class="col-md-6">
                            <div class="dropdown">
                                <button id="btn">Item</button>
                                <div class="dropdown-content">
                                    <a href="AddItem.jsp">Create Item</a>
                                    <a href="ViewAllItems.jsp">All Items</a>
                                    <a href="SearchItem.jsp">Update Item</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-6">
                            <div class="dropdown">
                                <button id="btn">Customer</button>
                                <div class="dropdown-content">
                                    <a href="AddCustomer.jsp">Create Customer</a>
                                    <a href="ViewAllCustomer.jsp">All Customers</a>
                                    <a href="SearchCustomer.jsp">Update Customer</a>
                                    <a href="DeleteCustomer.jsp">Delete Customer</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>

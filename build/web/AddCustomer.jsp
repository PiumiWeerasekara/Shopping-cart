<%-- 
    Document   : AddCustomer
    Created on : Jun 16, 2018, 2:13:05 AM
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
                display: flex;
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
            .save{
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
            .b{
                width: 150px;
                height: 500px;
                background-color: black
            }
            .c{
                width: 550px;
                height: 500px;   
                float: right;
            }
            .dropdown {
                position: relative;
                display: inline-block;
            }
            #btn{
                border-color: black;
                size: 30px;
                font-size: 25px;
                background-color:black; 
                color: white;
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
            h1{
                color: red;
            }
        </style>
    </head>
    <body>
        <form action="AddCustomerController">
            <div class="a">
                <div class="b">
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
                <div class="c">
                    <h1>Create Customer</h1>
                    <br>
                    <br>
                    <div class="form-group row">
                        <div class="col-md-6">
                            <p>
                                <label>User Name :</label>
                                <input type="text" name="name">
                            </p>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-6">
                            <p>
                                <label>Password :</label>
                                <input type="text" name="password" size="20px">
                            </p>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-6">
                            <p>
                                <label>Mobile :</label>
                                <input type="text" name="mobile" size="15px">
                            </p>
                        </div>
                    </div>

                    <button type="submit" class="save" name="action" formaction="AddCustomerController">Save</button>
                    <a href="AddCustomer.jsp" class="cancel" >Cancel</a>

                </div>

            </div>
        </form>
    </body>
</html>

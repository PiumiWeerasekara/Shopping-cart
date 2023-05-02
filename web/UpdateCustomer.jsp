<%-- 
    Document   : UpdateCustomer
    Created on : Jun 16, 2018, 2:13:18 AM
    Author     : DEll
--%>

<%@page import="com.publicshop.shopmngsys.dto.CustomerDto"%>
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
            .update{
                background-color: #ffcc99;
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
        <form action="UpdateCustomerController"> 
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
                    <h1>Update Item</h1>
                    <br>
                    <br>
                    <!--                    <div class="form-group row">
                                            <div class="col-md-6">
                                                <p>
                                                    <label>Name :</label>
                                                    <input type="text" name="name" placeholder="Enter Item Name" size="25px">
                                                                                    <button type="submit" class="cancel" name="action" formaction="SearchItemController">Search</button>
                                                </p>
                                            </div>
                                        </div>-->

                    
                    <%
                         CustomerDto customerDto = (CustomerDto) request.getAttribute("customer");
                        out.print("<div class='form-group row'><div class='col-md-6'><p><label>Name :</label><input type='text' name='name' value='" + customerDto.getName()+ "'></p></div></div>");
                        out.print("<div class='form-group row'><div class='col-md-6'><p><label>Password :</label><input type='text' name='password'  value='" + customerDto.getPassword()+ "'></p></div></div>");
                        out.print("<div class='form-group row'><div class='col-md-6'><p><label>Mobile :</label><input type='text' name='mobile' value='" + customerDto.getMobile()+ "'></p></div></div>");
                    %>

<!--                        CustomerDto customerDto = (CustomerDto) request.getAttribute("customer");
                        out.print("<div class='form-group row'><div class='col-md-6'><p><label>Name :</label><input type='text' name='name' value='" + customerDto.getName() + "'></p></div></div>");
                        out.print("<div class='form-group row'><div class='col-md-6'><p><label>Password :</label><input type='text'size='20x' name='password'  value='" + customerDto.getPassword() + "'></p></div></div>");
                        out.print("<div class='form-group row'><div class='col-md-6'><p><label>Mobile :</label><input type='text' size='15px' name='mobile' value='" + customerDto.getMobile() + "'></p></div></div>");
                       -->
                    

                    <!--                    <div class="form-group row">
                                            <div class="col-md-6">
                                                <p>
                                                    <label>Unit Price :</label>
                                                    <input type="text" name="unitPrice" size="12px">
                                                </p>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                     <div class="col-md-6">
                                                <p>
                                                    <label>No of quantity :</label>
                                                    <input type="text" name="qty" size="7px">
                                                </p>
                                            </div>
                                        </div>-->



                    <button type="submit" class="update" name="action" formaction="UpdateCustomerController">Update</button>
                    <a href="SearchCustomer.jsp" class="cancel" >Cancel</a>

                </div>
            </div>
        </form>
    </body>
</html>

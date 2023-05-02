<%-- 
    Document   : Cart
    Created on : Jun 16, 2018, 10:06:32 AM
    Author     : DEll
--%>

<%@page import="com.publicshop.shopmngsys.controller.CartController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.publicshop.shopmngsys.controller.CartController.MyCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>All Items</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){background-color: lightgrey}

            th {
                background-color: darkblue;
                color: white;
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
            .buy{
                background-color: lightblue;
                border: none;
                color: black;
                padding: 5px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 20px;
                size: 12px;
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
                size: 12px;
            }
            .backbtn{
                background-color: #009966; 
                border: none;
                color: black;
                padding: 5px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 20px;
                size: 12px;
            }
            body {
                background: url('http://www.roelofsinterieurs.nl/beheer/upload/editor_images/ict/26.jpg');
                background-attachment: fixed;
                background-position: center;
                background-size: cover;
            }


            .container {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
                width: 1000px;
                border-radius: 5px;
            }
            h2{
                color: red;
                text-align: center;
            }
            h3{
                color: black;
            }
        </style>
    </head>
    <body>
        <br>
        <br>
        <br>
        <form>
        <div class="container">
            <a href="CustomerLogOutController" class="logOut">LogOut</a>
            <br>
            <h2>My Cart</h2>
            <br>
            <br>
            <table>
                <tr>
                    <th>Item</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                    <th> </th>
                </tr>
                <%
                    ArrayList<CartController.MyCart> myList = (ArrayList<MyCart>) session.getAttribute("myList");
                    for (MyCart cart : myList) {
                        if (cart != null) {
                            out.print("<tr>"
                                    + "<td>" + cart.getName() + "</td>"
                                    + "<td>" + cart.getUnitPrice() + "</td>"
                                    + "<td>" + cart.getQty() + "</td>"
                                    + "<td>" + cart.getTotal() + "</td>"
                                    + "<td><form action=\"RemoveController\">"
                                    +"<Input type='hidden' name='name' size=5px value='"+cart.getName()+"'/>"
                                    +"<Input type='hidden' name='qty' size=2px  value='"+cart.getQty()+"'/>"
                                    + "<input type='submit' class=\"button back\" formaction='RemoveController' value='Remove'/>"
                                    + "<input type='submit' class=\"button Back\" formaction='RemoveAllController' value='Remove All'/>"
                                    + "</form></td>"
                            );
                        } else {
                            session.setAttribute("mylist", myList);
                            RequestDispatcher dis = request.getRequestDispatcher("CartController");
                            dis.forward(request, response);
                        }
                    }
                    double subTotal = 0;
                    for (MyCart cart : myList) {
                        if (cart != null) {
                            subTotal += cart.getTotal();

                        }
                    }
                    out.print("<tr>"
                            + "<td></td>"
                            + "<td></td>"
                            + "<td><h3>Sub Total :</h></td>"
                            + "<td> <h3>" + subTotal + "</h3></td>"
                            + "</tr>"
                    );

                %>

            </table>
            <br>
            <br>
            <div>
                <a href="CustomerMain.jsp" class="backbtn">Back</a>
                <a href="EndController" class="buy">Buy</a>
            </div>
            <br>
        </div>
        </form>
    </body>
</html>

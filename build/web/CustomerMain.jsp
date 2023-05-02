<%-- 
    Document   : ViewAllItems
    Created on : Jun 16, 2018, 2:12:52 AM
    Author     : DEll
--%>

<%@page import="com.publicshop.shopmngsys.dto.ItemDto"%>
<%@page import="java.util.ArrayList"%>
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
                text-align: center;
                padding: 8px;
            }

            tr:nth-child(even){background-color: lightgrey}

            th {
                background-color: blueviolet;
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
        </style>
    </head>
    <body>
        <br>
        <br>
        <br>
        <div class="container">
            <br>
            <h2>Purchase Order</h2>
            <br>
            <br>
            <table>
                <tr>
                    <th>Item</th>
                    <th>Unit Price</th>
                    <th>Quantity On Hand</th>
                    <th> </th>
                </tr>
                <%
                    ArrayList<ItemDto> all = (ArrayList<ItemDto>) request.getAttribute("allItems");
                    if (null != all) {
                        for (ItemDto item : all) {
                            out.print("<tr>"
                                    + "<td>" + item.getDescription() + "</td>"
                                    + "<td>" + item.getUnitPrice() + "</td>"
                                    + "<td>" + item.getQty() + "</td> "
                                    + "<td><form action=\"CartController\">"
                                    + "<Input type='hidden' name='name' size=10px value='" + item.getDescription() + "'/>"
                                    + "<input type='submit' class=\"button back\" value='Buy' onclick='myFunction()'/>"
                                    + "<Input type='text' id='buy' name='qty' size='2px'/>"
                                    + "<input type='submit' class=\"button Back\" value='Buy More'/>"
                                   // +                                    "<script language='javaScript'>function myFunction() {document.getElementById('buy').value = '1';}</script>"

                                    + "</form><td>"
                            );
                        }
                    } else {
                        RequestDispatcher dis = request.getRequestDispatcher("PurchaseController");
                        dis.forward(request, response);
                    }
                %>
                <script>
                    function myFunction() {
                        document.getElementById("buy").value = "1";
                    }
                </script>
            </table>
            <br>
            <br>
            <div>
                <a href="Cart.jsp" class="backbtn">MyCart</a>
            </div>
            <br>
        </div>
    </body>
</html>

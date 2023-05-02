/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.controller;

import com.publicshop.shopmngsys.dto.ItemDto;
import com.publicshop.shopmngsys.service.ItemService;
import com.publicshop.shopmngsys.service.ServiceFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DEll
 */
public class CartController extends HttpServlet {

    public double subTotal;
    private Object itemService;

    public class MyCart {

        private String name;
        private double unitPrice;
        private int qty;
        private double total;

        public MyCart() {
        }

        public MyCart(String name, double unitPrice, int qty, double total) {
            this.name = name;
            this.unitPrice = unitPrice;
            this.qty = qty;
            this.total = total;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the unitPrice
         */
        public double getUnitPrice() {
            return unitPrice;
        }

        /**
         * @param unitPrice the unitPrice to set
         */
        public void setUnitPrice(double unitPrice) {
            this.unitPrice = unitPrice;
        }

        /**
         * @return the qty
         */
        public int getQty() {
            return qty;
        }

        /**
         * @param qty the qty to set
         */
        public void setQty(int qty) {
            this.qty = qty;
        }

        /**
         * @return the total
         */
        public double getTotal() {
            return total;
        }

        /**
         * @param total the total to set
         */
        public void setTotal(double total) {
            this.total = total;
        }

        @Override
        public String toString() {
            return "MyCart{" + "name=" + name + ", unitPrice=" + unitPrice + ", qty=" + qty + ", total=" + total + '}';
        }

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            ItemService itemService = new ServiceFactory().getItemService();

            HttpSession session = request.getSession();
            ArrayList<MyCart> myList = (ArrayList<MyCart>) session.getAttribute("myList");

            System.out.println("aaaaa");

            String name = request.getParameter("name");
            int qty = Integer.parseInt(request.getParameter("qty"));

            System.out.println("ccccc");
            ArrayList<ItemDto> alItems = (ArrayList<ItemDto>) request.getAttribute("allItems");
            if (null == alItems) {
                alItems = new ArrayList<>();
            }
            ArrayList<ItemDto> all = (ArrayList<ItemDto>) itemService.showItems();
            System.out.println("ddddd");
            if (null == myList) {
                myList = new ArrayList<>();
                MyCart myCart = new MyCart();
                for (ItemDto item : all) {
                    if (item.getDescription().equalsIgnoreCase(name)) {
                        myCart.setName(name);
                        myCart.setUnitPrice(item.getUnitPrice());
                        myCart.setQty(qty);
                        myCart.setTotal(qty * item.getUnitPrice());
                        myList.add(myCart);

                        System.out.println("string");
                        System.out.println("double");
                        System.out.println("double2");

                        ItemDto itemDto = new ItemDto();
                        itemDto.setDescription(name);
                        itemDto.setUnitPrice(item.getUnitPrice());
                        itemDto.setQty(item.getQty() - qty);
                        System.out.println(qty);

                        System.out.println("bbbbb");

                        boolean result = itemService.editItem(itemDto);
                        if (result) {
                            System.out.println("oooooooooo");
                        }
                        break;
                    }
                }
            } else {
                boolean b = true;
                for (MyCart cart : myList) {
                    if (cart.getName().equalsIgnoreCase(name)) {
                        int oldQty = cart.getQty();
                        double price = cart.getUnitPrice();
                        int indexOfCart = myList.indexOf(cart);
                        cart.setName(name);
                        cart.setUnitPrice(price);
                        cart.setQty(oldQty + qty);
                        cart.setTotal(price * (oldQty + qty));

                        for (ItemDto item : all) {
                            if (item.getDescription().equalsIgnoreCase(name)) {
                                ItemDto itemDto = new ItemDto();
                                itemDto.setDescription(item.getDescription());
                                itemDto.setUnitPrice(item.getUnitPrice());
                                itemDto.setQty(item.getQty() - qty);
                                System.out.println(qty);

                                System.out.println("bbbbb");

                                boolean result = itemService.editItem(itemDto);
                                if (result) {
                                    System.out.println("oooooooooo");
                                }
                            }
                        }

                        myList.set(indexOfCart, cart);
                        b = false;
                        break;
                    }
                }
                if (b) {
                    MyCart myCart = new MyCart();
                    for (ItemDto item : all) {
                        if (item.getDescription().equalsIgnoreCase(name)) {
                            myCart.setName(name);
                            myCart.setUnitPrice(item.getUnitPrice());
                            myCart.setQty(qty);
                            myCart.setTotal(item.getUnitPrice() * qty);
                            myList.add(myCart);

                            ItemDto itemDto = new ItemDto();
                            itemDto.setDescription(name);
                            itemDto.setUnitPrice(item.getUnitPrice());
                            itemDto.setQty(item.getQty() - qty);

                            boolean result = itemService.editItem(itemDto);
                            if (result) {
                                System.out.print("aaaaaaaaaaa");
                            }
                        }
                    }
                }
            }
            session.setAttribute("myList", myList);
            RequestDispatcher dis = request.getRequestDispatcher("Cart.jsp");
            dis.forward(request, response);

//            out.print("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
//            out.print("<br>");
//            out.print("<style>"
//                    + ".button {"
//                    + "background-color: #4CAF50; /* Green */"
//                    + "border: none;"
//                    + "color: white;"
//                    + "padding: 5px 32px;"
//                    + "text-align: center;"
//                    + "text-decoration: none;"
//                    + "display: inline-block;"
//                    + "font-size: 16px;"
//                    + "margin: 4px 2px;"
//                    + "-webkit-transition-duration: 0.4s; /* Safari */"
//                    + "transition-duration: 0.4s;"
//                    + "cursor: pointer;"
//                    + "}"
//                    + "table {"
//                    + "border-collapse: collapse;"
//                    + "width: 100%;"
//                    + "}"
//                    + "th, td {"
//                    + " text-align: left;"
//                    + "padding: 8px;"
//                    + "}"
//                    + "tr:nth-child(even){background-color: #f2f2f2}"
//                    + "th {"
//                    + "background-color: #6666ff;"
//                    + "color: white;"
//                    + "}"
//                    + ".add {"
//                    + "background-color: white; "
//                    + "color: black; "
//                    + "border: 2px solid #008CBA;"
//                    + "}"
//                    + ".add:hover {"
//                    + "background-color: #008CBA;"
//                    + "color: white;"
//                    + "}"
//                    + ".back {"
//                    + "background-color: white;"
//                    + "color: black;"
//                    + "border: 2px solid #555555;"
//                    + "}"
//                    + ".back:hover{"
//                    + "background-color: #555555;"
//                    + "color: white;"
//                    + "}"
//                    + "</style>");
//            out.print("<div class=container>"
//                    + "<div class=\"form-group row\">"
//                    + "<table>"
//                    + "<tr>"
//                    + "<th>Item Name</th>"
//                    + "<th>Qty</th>"
//                    + "<th>Unit Price</th>"
//                    + "<th>Total Price</th>"
//                    + "<th></th>"
//                    + "</tr>");
//            for (MyCart cart : myList) {
//                if (cart != null) {
//                    out.print("<tr>"
//                            + "<td>" + cart.getName() + "</td>"
//                            + "<td>" + cart.getQty() + "</td>"
//                            + "<td>" + cart.getUnitPrice() + "</td>"
//                            + "<td>" + cart.getTotal() + "</td>"
//                            +"<td>"
//                            + "<input type='submit' class=\"button back\" value='Remove' onclick='myFunction()'/>"
//                                    + "<input type='submit' class=\"button Back\" value='Remove All'/>"
//                            +"</td>"
//                    );
//                }
//            }
//            double amount=0;
//            for (MyCart cart : myList) {
//                if (cart != null) {
//                    amount+=cart.getTotal();
//            subTotal=amount;
//                    }
//            }
//            out.print("<tr>"
//                  + "<td></td>"                  
//                    + "<td></td>"
//                    + "<td><h2>Sub Total :</h2></td>"
//                    + "<td> <h3>"+subTotal+"</h3></td>"
//                    + "</tr>"
//            );
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

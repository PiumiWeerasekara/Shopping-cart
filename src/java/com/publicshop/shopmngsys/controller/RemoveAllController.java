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
public class RemoveAllController extends HttpServlet {

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
             
            String name=request.getParameter("name");
            int qty=Integer.parseInt(request.getParameter("qty"));
            
            HttpSession session=request.getSession();
            ArrayList<CartController.MyCart> myList=(ArrayList<CartController.MyCart>) session.getAttribute("myList");
            
            ArrayList<ItemDto> alItems = (ArrayList<ItemDto>) request.getAttribute("allItems");
            if (null == alItems) {
                alItems = new ArrayList<>();
            }
            ArrayList<ItemDto> all = (ArrayList<ItemDto>) itemService.showItems();
            
            if (null!=myList) {
                for (CartController.MyCart cart : myList) {
                    if (cart.getName().equalsIgnoreCase(name)) {
                        int old=cart.getQty();
                        int indexofCart=myList.indexOf(cart);
                        cart.setName(name);
                        cart.setUnitPrice(cart.getUnitPrice());
                        cart.setQty(old-qty);
                        cart.setTotal(cart.getUnitPrice()*(old-qty));
                        
                        for (ItemDto item : all) {
                            if (item.getDescription().equalsIgnoreCase(name)) {
                                ItemDto itemDto = new ItemDto();
                                itemDto.setDescription(item.getDescription());
                                itemDto.setUnitPrice(item.getUnitPrice());
                                itemDto.setQty(item.getQty() + qty);

                                System.out.println("bbbbb");

                                boolean result = itemService.editItem(itemDto);
                                if (result) {
                                    System.out.println("oooooooooo");
                                }
                            }
                        }
System.out.println("cart indexxxxxxxxxxxxxxx");
                        if (cart.getQty()==0) {
                            System.out.println(cart.getQty());
                            myList.remove(indexofCart);
                        }else{
                        myList.set(indexofCart, cart);
                        }
                    }
                    
                }
            }
            session.setAttribute("myList", myList);
            RequestDispatcher dis = request.getRequestDispatcher("Cart.jsp");
            dis.forward(request, response);
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

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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DEll
 */
public class UpdateItemController extends HttpServlet {

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
            System.out.println("aaaaaa");
            
            ItemService itemService=new ServiceFactory().getItemService();
            System.out.println("string");
            String description=request.getParameter("name");
            System.out.println("double");
            Double unitPrice=Double.parseDouble(request.getParameter("unitPrice"));
            System.out.println("double2");
            int qty=Integer.parseInt(request.getParameter("qty"));
            
            ItemDto itemDto=new ItemDto();
            itemDto.setDescription(description);
            itemDto.setUnitPrice(unitPrice);
            itemDto.setQty(qty);
            
            System.out.println("bbbbb");
            
            boolean result=itemService.editItem(itemDto);
            System.out.println("cccc");
            if (result) {
                out.print("<script language='javaScript'>alert('Successfully Updated')</script>");
            }
            else{
                out.print("<script language='javaScript'>alert('Failed to update')</script>");
            }
            out.print("<script language='JavaScript'>window.location.replace('UpdateItem.jsp');</script>");
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.service;

import com.publicshop.shopmngsys.service.serviceImpl.AdminServiceImpl;
import com.publicshop.shopmngsys.service.serviceImpl.CustomerServiceImpl;
import com.publicshop.shopmngsys.service.serviceImpl.ItemServiceImpl;

/**
 *
 * @author DEll
 */
public class ServiceFactory {

    public ItemService getItemService() {
        return new ItemServiceImpl();
    }

    public CustomerService getCustomerService() {
        return new CustomerServiceImpl();
    }

    public AdminService getAdminService() {
        return new AdminServiceImpl();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.service;

import com.publicshop.shopmngsys.dto.AdminDto;
import com.publicshop.shopmngsys.dto.CustomerDto;
import java.util.List;

/**
 *
 * @author DEll
 */
public interface CustomerService {
    public boolean saveCustomer(CustomerDto customerDto);
    public List<CustomerDto> showICustomers();
    public boolean editCustomer(CustomerDto customerDto);
    public boolean deleteCustomer(CustomerDto customerDto);
    public CustomerDto searchCustomer(String name);
    public CustomerDto findCustomer(String name,String password);
}

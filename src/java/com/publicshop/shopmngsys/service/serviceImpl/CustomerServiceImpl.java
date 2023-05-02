/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.service.serviceImpl;

import com.publicshop.shopmngsys.dao.CustomerDao;
import com.publicshop.shopmngsys.dao.DaoFactory;
import com.publicshop.shopmngsys.dto.AdminDto;
import com.publicshop.shopmngsys.dto.CustomerDto;
import com.publicshop.shopmngsys.model.CustomerModel;
import com.publicshop.shopmngsys.service.CustomerService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEll
 */
public class CustomerServiceImpl implements CustomerService {

    @Override
    public boolean saveCustomer(CustomerDto customerDto) {
        CustomerDao customerDao = new DaoFactory().getCustomerDao();
        CustomerModel customerModel = new CustomerModel();
        customerModel.setName(customerDto.getName());
        customerModel.setPassword(customerDto.getPassword());
        customerModel.setMobile(customerDto.getMobile());
        boolean res = false;
        try {
            res = (0 < customerDao.insert(customerModel));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    @Override
    public List<CustomerDto> showICustomers() {
        CustomerDao customerDao = new DaoFactory().getCustomerDao();
        ArrayList<CustomerDto> alCustomerDtos = null;
        try {
            ArrayList<CustomerModel> alCustomerModels = (ArrayList<CustomerModel>) customerDao.readAll();

            for (CustomerModel alCustomerModel : alCustomerModels) {
                if (null != alCustomerModels) {
                    CustomerDto customerDto = new CustomerDto();
                    customerDto.setName(alCustomerModel.getName());
                    customerDto.setPassword(alCustomerModel.getPassword());
                    customerDto.setMobile(alCustomerModel.getMobile());
                    alCustomerDtos.add(customerDto);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alCustomerDtos;
    }

    @Override
    public boolean editCustomer(CustomerDto customerDto) {
        CustomerDao customerDao = new DaoFactory().getCustomerDao();
        CustomerModel customerModel = new CustomerModel();
        customerModel.setName(customerDto.getName());
        customerModel.setPassword(customerDto.getPassword());
        customerModel.setMobile(customerDto.getMobile());
        int res = -1;
        try {
            res = customerDao.update(customerModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (0 < res);
    }

    @Override
    public boolean deleteCustomer(CustomerDto customerDto) {
        CustomerDao customerDao = new DaoFactory().getCustomerDao();
        CustomerModel customerModel = new CustomerModel();
        customerModel.setName(customerDto.getName());
        int res = -1;
        try {
            res = customerDao.delete(customerModel);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0 < res;
    }

    @Override
    public CustomerDto searchCustomer(String name) {
        CustomerDao customerDao = new DaoFactory().getCustomerDao();
        CustomerModel customerModel = null;
        try {
            customerModel = customerDao.search(name);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (customerModel != null) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setName(customerModel.getName());
            customerDto.setPassword(customerModel.getPassword());
            customerDto.setMobile(customerModel.getMobile());
            return customerDto;
        } else {
            return null;
        }
    }

    @Override
    public CustomerDto findCustomer(String name, String password) {
        CustomerDao customerDao = new DaoFactory().getCustomerDao();
        CustomerModel customerModel = null;
        try {
            customerModel = customerDao.find(name, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (null != customerModel) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setName(customerModel.getName());
            customerDto.setPassword(customerModel.getPassword());
            return customerDto;
        } else {
            return null;
        }
    }

    
}
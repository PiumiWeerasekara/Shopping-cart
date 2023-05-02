/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.dao;

import com.publicshop.shopmngsys.model.CustomerModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author DEll
 */
public interface CustomerDao {
    public int insert(CustomerModel customerModel)throws ClassNotFoundException,SQLException;
    public List<CustomerModel> readAll()throws ClassNotFoundException,SQLException;
    public int update(CustomerModel customerModel)throws ClassNotFoundException,SQLException;
    public int delete(CustomerModel customerModel)throws ClassNotFoundException,SQLException;
    public CustomerModel search(String name)throws ClassNotFoundException,SQLException;
    public CustomerModel find(String name,String password)throws ClassNotFoundException,SQLException;
}

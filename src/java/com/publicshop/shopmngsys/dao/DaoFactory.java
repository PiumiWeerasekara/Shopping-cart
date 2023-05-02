/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.dao;

import com.publicshop.shopmngsys.dao.daoImpl.AdminDaoImpl;
import com.publicshop.shopmngsys.dao.daoImpl.CustomerDaoImpl;
import com.publicshop.shopmngsys.dao.daoImpl.ItemDaoImpl;

/**
 *
 * @author DEll
 */
public class DaoFactory {
    
    public ItemDao getItemDao(){
        return new ItemDaoImpl();
    }
    public CustomerDao getCustomerDao(){
        return new CustomerDaoImpl();
    }
    public AdminDao getAdminDao(){
        return new AdminDaoImpl();
    }
    
//    public enum DAOTypes{
//        ITEM,CUSOMER
//    }
//    private static DaoFactory daoFactory;
//
//    private DaoFactory() {
//    }
//    public static DaoFactory getInstance(){
//        if (null==daoFactory) {
//            daoFactory=new DaoFactory();
//        }
//        return daoFactory;
//    }
//    
}

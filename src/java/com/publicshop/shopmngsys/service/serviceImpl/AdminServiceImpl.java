/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.service.serviceImpl;

import com.publicshop.shopmngsys.dao.AdminDao;
import com.publicshop.shopmngsys.dao.DaoFactory;
import com.publicshop.shopmngsys.dto.AdminDto;
import com.publicshop.shopmngsys.model.AdminModel;
import com.publicshop.shopmngsys.service.AdminService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEll
 */
public class AdminServiceImpl implements AdminService {

    @Override
    public AdminDto findAdmin(String name,String password) {
        AdminDao adminDao = new DaoFactory().getAdminDao();
        AdminModel adminModel = null;
        try {
            adminModel = adminDao.find(name, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (null != adminModel) {
            AdminDto adminDto = new AdminDto();
            adminDto.setName(adminModel.getName());
            adminDto.setPassword(adminModel.getPassword());
            return adminDto;
        } else {
            return null;
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.dao.daoImpl;

import com.publicshop.shopmngsys.connection.ResourceConnection;
import com.publicshop.shopmngsys.connection.ResourceConnectionFactory;
import com.publicshop.shopmngsys.dao.AdminDao;
import com.publicshop.shopmngsys.model.AdminModel;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEll
 */
public class AdminDaoImpl implements AdminDao {

    @Override
    public AdminModel find(String name,String password) throws ClassNotFoundException, SQLException {
        Statement stm = null;
        try {
            ResourceConnection resourceConnection = new ResourceConnectionFactory().getConnection();
            stm = resourceConnection.getConnection().createStatement();
        } catch (IOException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        ResultSet rst = stm.executeQuery("SELECT * FROM ADMIN WHERE ANAME='" + name + "' AND APASSWORD='"+password+"'");
        if (rst.next()) {
            AdminModel adminModel = new AdminModel(rst.getString("ANAME"), rst.getString("APASSWORD"));
            return adminModel;
        } else {
            return null;
        }

    }

}

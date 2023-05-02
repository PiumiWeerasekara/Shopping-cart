/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.dao.daoImpl;

import com.mysql.jdbc.PreparedStatement;
import com.publicshop.shopmngsys.connection.ResourceConnection;
import com.publicshop.shopmngsys.connection.ResourceConnectionFactory;
import com.publicshop.shopmngsys.dao.CustomerDao;
import com.publicshop.shopmngsys.model.CustomerModel;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEll
 */
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public int insert(CustomerModel customerModel) throws ClassNotFoundException, SQLException {
        int res = -1;
        try {
            ResourceConnection resourceConnection = new ResourceConnectionFactory().getConnection();

            try {
                Statement stm = resourceConnection.getConnection().createStatement();
                res = stm.executeUpdate("INSERT INTO CUSTOMER(CNAME,CPASSWORD,MOBILE) VALUES('" + customerModel.getName() + "','" + customerModel.getPassword() + "','" + customerModel.getMobile() + "')");

//            String sql="INSERT INTO CUSTOMER VALUES(CNAME=?,CPASSWORD=?,MOBILE=?)";
//            PreparedStatement stm=(PreparedStatement) resourceConnection.getConnection().prepareStatement(sql);
//            stm.setObject(1, customerModel.getName());
//            stm.setObject(2, customerModel.getPassword());
//            stm.setObject(3, customerModel.getMobile());
//            res=stm.executeUpdate();
//            Statement stm=resourceConnection.getConnection().createStatement();
//            res=stm.executeUpdate("INSERT INTO CUSTOMER VALUES(CNAME="+customerModel.getName()+"',CPASSWORD='"+customerModel.getPassword()+"',MOBILE='"+customerModel.getMobile()+"')");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }
        } catch (IOException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return res;
    }

    @Override
    public List<CustomerModel> readAll() throws ClassNotFoundException, SQLException {
        ArrayList<CustomerModel> alCustomers = null;
        try {
            ResourceConnection resourceConnection = new ResourceConnectionFactory().getConnection();
            Statement stm = resourceConnection.getConnection().createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM CUSTOMER");
            alCustomers = new ArrayList<>();
            while (rst.next()) {
                CustomerModel customerModel = new CustomerModel(rst.getString("CNAME"), rst.getString("CPASSWORD"), rst.getShort("MOBILE"));
                alCustomers.add(customerModel);
            }

        } catch (IOException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return alCustomers;
    }

    @Override
    public int update(CustomerModel customerModel) throws ClassNotFoundException, SQLException {
        int res = -1;
        try {
            ResourceConnection resourceConnection = new ResourceConnectionFactory().getConnection();
            Statement stm = resourceConnection.getConnection().createStatement();
            res = stm.executeUpdate("UPDATE CUSTOMER SET CPASSWORD='" + customerModel.getPassword() + "',MOBILE='" + customerModel.getMobile() + "' WHERE CNAME='" + customerModel.getMobile() + "'");
        } catch (IOException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public int delete(CustomerModel customerModel) throws ClassNotFoundException, SQLException {
        int res = -1;
        try {
            ResourceConnection resourceConnection = new ResourceConnectionFactory().getConnection();
            Statement stm = resourceConnection.getConnection().createStatement();
            res = stm.executeUpdate("DELETE FROM CUSTOMER WHERE CNAME='" + customerModel.getName() + "'");
        } catch (IOException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public CustomerModel search(String name) throws ClassNotFoundException, SQLException {
        Statement stm = null;
        try {
            ResourceConnection resourceConnection = new ResourceConnectionFactory().getConnection();
            stm = resourceConnection.getConnection().createStatement();
        } catch (IOException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        ResultSet rst = stm.executeQuery("SELECT * FROM CUSTOMER WHERE CNAME='" + name + "'");
        if (rst.next()) {
            CustomerModel customerModel = new CustomerModel(rst.getString("CNAME"), rst.getNString("PASSWORD"), Integer.parseInt(rst.getString("MOBILE")));
            return customerModel;
        } else {
            return null;
        }

    }

    @Override
    public CustomerModel find(String name, String password) throws ClassNotFoundException, SQLException {
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
        ResultSet rst = stm.executeQuery("SELECT * FROM CUSTOMER WHERE CNAME='" + name + "' AND CPASSWORD='" + password + "'");
        if (rst.next()) {
            CustomerModel customerModel = new CustomerModel(rst.getString("CNAME"), rst.getString("CPASSWORD"));
            return customerModel;
        } else {
            return null;
        }
    }
}
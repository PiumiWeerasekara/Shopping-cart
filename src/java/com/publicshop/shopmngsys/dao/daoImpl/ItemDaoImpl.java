/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.dao.daoImpl;

import com.publicshop.shopmngsys.connection.ResourceConnection;
import com.publicshop.shopmngsys.connection.ResourceConnectionFactory;
import com.publicshop.shopmngsys.dao.ItemDao;
import com.publicshop.shopmngsys.model.ItemModel;
import java.io.FileNotFoundException;
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
public class ItemDaoImpl implements ItemDao {

    @Override
    public int insert(ItemModel itemModel) throws ClassNotFoundException, SQLException {
        int res = -1;
        ResourceConnection resourceConnection;
        try {
            resourceConnection = new ResourceConnectionFactory().getConnection();
            Statement stm = resourceConnection.getConnection().createStatement();
            res = stm.executeUpdate("INSERT INTO ITEM(DESCRIPTION,UNITPRICE,QTY) VALUES('" + itemModel.getDescription() + "','" + itemModel.getUnitPrice() + "','" + itemModel.getQty() + "')");

        } catch (IOException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public List<ItemModel> readAll() throws ClassNotFoundException, SQLException {
        ResourceConnection resourceConnection = null;
        try {
            resourceConnection = new ResourceConnectionFactory().getConnection();
        } catch (IOException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<ItemModel> alItems = null;
        try {
            Statement stm = resourceConnection.getConnection().createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM ITEM");
            alItems = new ArrayList<>();
            while (rst.next()) {
                ItemModel items = new ItemModel(rst.getString("DESCRIPTION"), Double.parseDouble(rst.getString("UNITPRICE")), Integer.parseInt(rst.getString("QTY")));
                alItems.add(items);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return alItems;
    }

    @Override
    public int update(ItemModel itemModel) throws ClassNotFoundException, SQLException {

        ResourceConnection resourceConnection = null;
        try {
            resourceConnection = new ResourceConnectionFactory().getConnection();
        } catch (IOException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        int res = -1;
        try {
            Statement stm = resourceConnection.getConnection().createStatement();
            res = stm.executeUpdate("UPDATE ITEM SET UNITPRICE='" + itemModel.getUnitPrice() + "',QTY='" + itemModel.getQty() + "' WHERE DESCRIPTION='" + itemModel.getDescription() + "'");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public int delete(ItemModel itemModel) throws ClassNotFoundException, SQLException {
        ResourceConnection resourceConnection = null;
        int res = -1;
        try {
            resourceConnection = new ResourceConnectionFactory().getConnection();
        } catch (IOException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement stm = resourceConnection.getConnection().createStatement();
            res = stm.executeUpdate("DELETE FROM ITEM WHERE DESCRIPTION='" + itemModel.getDescription() + "'");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return res;
    }

    @Override
    public ItemModel searchItem(String name) throws ClassNotFoundException, SQLException {
        Statement stm=null;
        try {
            ResourceConnection resourceConnection = new ResourceConnectionFactory().getConnection();
            stm = resourceConnection.getConnection().createStatement();

        } catch (IOException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        ResultSet rst = stm.executeQuery("SELECT * FROM ITEM WHERE DESCRIPTION='" + name + "'");

        if (rst.next()) {
            ItemModel item = new ItemModel(rst.getString("DESCRIPTION"), Double.parseDouble(rst.getString("UNITPRICE")), Integer.parseInt(rst.getString("QTY")));
            return item;
        } else {
            return null;
        }
    }

}

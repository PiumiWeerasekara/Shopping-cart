/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.dao;

import com.publicshop.shopmngsys.model.AdminModel;
import java.sql.SQLException;

/**
 *
 * @author DEll
 */
public interface AdminDao {
    public AdminModel find(String name,String password)throws ClassNotFoundException,SQLException;
}

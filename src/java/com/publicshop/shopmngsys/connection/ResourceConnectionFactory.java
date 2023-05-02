/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.connection;

import com.publicshop.shopmngsys.connection.impl.MySqlResourceConnectionImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author DEll
 */
public class ResourceConnectionFactory {
    
    public ResourceConnection getConnection() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{
        return new MySqlResourceConnectionImpl();
    }
    
//    public enum ConnectionTypes{
//        DBCONNECTION
//    }
//    private static ResourceConnectionFactory resourceConnectionFactory;
//
//    public ResourceConnectionFactory() {
//        
//    }
//    public static ResourceConnectionFactory getInstance(){
//        if (resourceConnectionFactory==null) {
//            resourceConnectionFactory=new ResourceConnectionFactory();
//        }
//        return resourceConnectionFactory;
//    }
//    public SuperConnectionFactory getConnection()
}

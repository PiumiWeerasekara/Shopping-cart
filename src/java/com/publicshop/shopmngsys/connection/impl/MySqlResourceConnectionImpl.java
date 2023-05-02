/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.publicshop.shopmngsys.connection.impl;

import com.publicshop.shopmngsys.connection.ResourceConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEll
 */
public class MySqlResourceConnectionImpl implements ResourceConnection{

    public static MySqlResourceConnectionImpl mySqlResourceConnectionImpl;
    public Connection connection;

    public MySqlResourceConnectionImpl() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
//        Properties dbProperties=new Properties();
//        File dbFile=new File("Settings/MysqlSettings.properties");
//        FileReader dbFileReader=new FileReader(dbFile);
//        dbProperties.load(dbFileReader);
//        
//        String ip=dbProperties.getProperty("ip");
//        String port=dbProperties.getProperty("port");
//        String database=dbProperties.getProperty("database");
//        String username=dbProperties.getProperty("username");
//        String password=dbProperties.getProperty("password");
//        
//        String url="jdbc:mysql://"+ip+":"+port+"/"+database;
//        
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection=DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(MySqlResourceConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        } catch (SQLException ex) {
//            Logger.getLogger(MySqlResourceConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
//            throw ex;
//        }
//        
//    }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart", "root", "biyankapiumi");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlResourceConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(MySqlResourceConnectionImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        
    }
    public static MySqlResourceConnectionImpl getInstance() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{
        if (null==mySqlResourceConnectionImpl) {
            mySqlResourceConnectionImpl=new MySqlResourceConnectionImpl();
        }
        return mySqlResourceConnectionImpl;
    }
        
    
    
    
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return connection;
    }
    
    
    
}

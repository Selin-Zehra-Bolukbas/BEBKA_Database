package com.selin.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectorConfig {

    public static Connection connection;

    public static  void setConnection(){
        try {
            connection= DriverManager.getConnection(DataBaseConfig.DATABASE_URL,  DataBaseConfig.DATABASE_USERNAME, DataBaseConfig.DATABASE_PASSWORD);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}


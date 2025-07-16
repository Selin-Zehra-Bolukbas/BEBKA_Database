package com.selin;

import com.selin.config.DataBaseConfig;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {


        String sql="CREATE TABLE IF NOT EXISTS users (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "email VARCHAR(100))";

        try {
            Connection connection= DriverManager.getConnection(DataBaseConfig.DATABASE_URL, DataBaseConfig.DATABASE_USERNAME,DataBaseConfig.DATABASE_PASSWORD);
           Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Tablo oluşturuldu.");


            String insertsql= "INSERT INTO users(name,email) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertsql);
            preparedStatement.setString(1,"Ali");
            preparedStatement.setString(2,"ali@gmail.com");
            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }




    }


}
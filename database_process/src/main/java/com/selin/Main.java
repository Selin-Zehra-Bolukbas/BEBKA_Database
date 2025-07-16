package com.selin;

import com.selin.config.DataBaseConfig;


import java.sql.*;

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

           // prepared statement [JA-5]
            String insertsql= "INSERT INTO users(name,email) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertsql);
            preparedStatement.setString(1,"Ali");
            preparedStatement.setString(2,"ali@gmail.com");
            preparedStatement.executeUpdate();

            //resultset  [JA-6]
            String selectsql= "SELECT * FROM users WHERE email=?";
            PreparedStatement prepared = connection.prepareStatement(selectsql);
            prepared.setString(1,"ali@gmail.com");
            ResultSet resultSet = prepared.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("email"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }




    }


}
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

            // update [JA-7]
            String updatesql= "UPDATE users SET name=? WHERE id=?";
            PreparedStatement preparedUpdate = connection.prepareStatement(updatesql);
            preparedUpdate.setString(1,"Mehmet");
            preparedUpdate.setInt(2,1);

            int affectedRows = preparedUpdate.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Kayıt başarıyla güncellendi.");
            } else {
                System.out.println("Güncelleme yapılamadı.");
            }

            // delete  [JA-7]
            String deletesql= "DELETE FROM users WHERE id=?";
            PreparedStatement preparedDelete = connection.prepareStatement(deletesql);
            preparedDelete.setInt(1,3);

            int affectedRowsDeleted = preparedDelete.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Kayıt başarıyla silindi.");
            } else {
                System.out.println("Silinecek kayıt bulunamadı.");
            }

        }catch (Exception e){
            e.printStackTrace();
        }




    }


}
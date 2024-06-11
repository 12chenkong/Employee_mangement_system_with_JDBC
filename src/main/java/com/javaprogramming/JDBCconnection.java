package com.javaprogramming;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCconnection {
   static Connection con;
   static Connection CreateConnection(){
       try {
            final String password="1234567";
            final String username="root";
            final String url="jdbc:mysql://localhost:3306/employeeDB";
            // load the driver or start the connection between database and java
         con=DriverManager.getConnection(url,username,password);
       }catch (Exception ex){
           System.out.println("something went wrong");
       }

           return con;
   }

}

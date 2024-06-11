package com.javaprogramming;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class employeeimplement implements employeeInterface{
        Connection con;
    @Override
    public void createEmployee(employee em) {
        con=JDBCconnection.CreateConnection();
        String query="INSERT INTO employee VALUES(?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,em.getId());
            pstm.setString(2, em.getName());
            pstm.setInt(3,em.getSalary());
            pstm.setInt(4,em.getAge());
           int cnt=pstm.executeUpdate();
           if(cnt!=0){
               System.out.println("inserted correctly!");
           }

        }catch (Exception ex){
          ex.printStackTrace();
        }

    }

    @Override
    public void showAllEmployee() {
        con=JDBCconnection.CreateConnection();
        String  query="SELECT*FROM employee";
        System.out.println("Here are employee's info:");
        try {
            Statement statement= con.createStatement();
            ResultSet result=statement.executeQuery(query);
            while (result.next()){
                // Tell sal which column to you want to fetch
                System.out.print(result.getInt("id")+" ");
                System.out.print(result.getString("name")+" ");
                System.out.print(result.getInt("age")+" ");
                System.out.print(result.getInt("salary")+"$");
                System.out.println();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnId(int id) {
        try {
            String query="SELECT*FROM employee WHERE id="+id;
            con=JDBCconnection.CreateConnection();
            Statement statement= con.createStatement();
           ResultSet resul= statement.executeQuery(query);
            while (resul.next()){
                System.out.print(resul.getInt(1)+" ");
                System.out.print(resul.getString(2)+" ");
                System.out.print(resul.getInt(3)+" ");
                System.out.print(resul.getInt(4)+"$");
                System.out.println();
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    @Override
    public void updateEmployee(int id, String name) {
        final  String query="UPDATE employee SET name=? WHERE id=?";
        con=JDBCconnection.CreateConnection();
        try{
            PreparedStatement st=con.prepareStatement(query);
            st.setInt(2,id);
            st.setString(1,name);
            System.out.println( st.executeUpdate());

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Something went wrong");

        }


    }

    @Override
    public void deleteEmployee(int id) {
        con=JDBCconnection.CreateConnection();
        String query="DELETE FROM employee WHERE id=?";
        try{
            PreparedStatement preparedStatement= con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int rowAfected=preparedStatement.executeUpdate();
            if(rowAfected>0){
                System.out.println("Remove successful");
            }
        }catch (Exception ex){
            ex.printStackTrace();

        }


    }
}

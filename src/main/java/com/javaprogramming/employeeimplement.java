package com.javaprogramming;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
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
        String  query="SELECT*FROM employee ORDER BY name";
        int totalSalary=0;
        int totalEmployee=0;

        try {
            Statement statement= con.createStatement();
            ResultSet result=statement.executeQuery(query);
            CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.CENTER);
            Table table=new Table(4, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
            Table table1=new Table(2, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
            table.setColumnWidth(0,10,15);
            table.setColumnWidth(1,10,20);
            table.setColumnWidth(2,10,20);
            table.setColumnWidth(3,10,20);
            // adding cells to the table
            table.addCell("ID",cellStyle);
            table.addCell("NAME",cellStyle);
            table.addCell("AGE",cellStyle);
            table.addCell("SALARY",cellStyle);
            boolean status=true;

                    while (result.next()){
                        // Tell sql which column to you want to fetch
                        status=false;
                        table.addCell(String.valueOf(result.getInt("id")), cellStyle);
                        table.addCell(String.valueOf(result.getString("name")),cellStyle);
                        table.addCell(String.valueOf(result.getInt("age")),cellStyle);
                        table.addCell((String.valueOf(result.getInt("salary"))+"$"),cellStyle);
                        totalSalary=totalSalary+result.getInt("salary");
                        totalEmployee++;

                    }
                    // creating another table for total employees and salary
                    table1.addCell("Total:",cellStyle);
                    table1.addCell("Employees",cellStyle);
                    table1.addCell((String.valueOf(totalSalary)+"$"),cellStyle);
                    table1.addCell(String.valueOf(totalEmployee),cellStyle);
                    System.out.println(table.render());
                    System.out.println(table1.render());



        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnId(int id) {
        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.CENTER);
        Table table=new Table(4, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        try {
            String query="SELECT*FROM employee WHERE id="+id;
            con=JDBCconnection.CreateConnection();
            PreparedStatement preparedStatement= con.prepareStatement(query);
           ResultSet resul= preparedStatement.executeQuery(query);
            table.setColumnWidth(0,10,15);
            table.setColumnWidth(1,10,20);
            table.setColumnWidth(2,10,20);
            table.setColumnWidth(3,10,20);
            // adding cells to the table
            table.addCell("ID",cellStyle);
            table.addCell("NAME",cellStyle);
            table.addCell("AGE",cellStyle);
            table.addCell("SALARY",cellStyle);
            while (resul.next()){
                table.addCell(String.valueOf(resul.getInt(1)),cellStyle);
                table.addCell(String.valueOf(resul.getString(2)),cellStyle);
                table.addCell(String.valueOf(resul.getInt(3)),cellStyle);
                table.addCell(String.valueOf(resul.getInt("salary")+"$"),cellStyle);
                System.out.println(table.render());
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

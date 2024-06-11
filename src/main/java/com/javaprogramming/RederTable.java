package com.javaprogramming;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class RederTable {
    public static void rederMenu   (){
        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.CENTER);
        Table table=new Table(2, BorderStyle.UNICODE_BOX_HEAVY_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.setColumnWidth(0,5,10);
        table.setColumnWidth(1,20,70);
        table.addCell("NO",cellStyle);
        table.addCell("PLease choose",cellStyle);
        table.addCell("1",cellStyle);
        table.addCell("Add employee",cellStyle);
        table.addCell("2",cellStyle);
        table.addCell("Show all employees",cellStyle);
        table.addCell("3",cellStyle);
        table.addCell("Search employee by id",cellStyle);
        table.addCell("4",cellStyle);
        table.addCell("Update employee's name",cellStyle);
        table.addCell("5",cellStyle);
        table.addCell(" Delete employee ",cellStyle);
        table.addCell("6",cellStyle);
        table.addCell("Exit the program!!!",cellStyle);
        System.out.println(table.render());

    }

    public  static void renderWelcomeMessage(){
        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.CENTER);
        Table table=new Table(1, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.setColumnWidth(0,10,90);
        table.addCell("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM",cellStyle);
        System.out.println(table.render());

    }
    public  static  void thanksMessage(){
        CellStyle cellStyle=new CellStyle(CellStyle.HorizontalAlign.CENTER);
        Table table=new Table(1, BorderStyle.DESIGN_CASUAL, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.setColumnWidth(0,20,50);
        table.addCell("THANKS FOR USING OUR SYSTEM!");
        System.out.println(table.render());
    }

    public static void main(String[] args) {

    }
}

package com.javaprogramming;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        employeeInterface em=new employeeimplement();
       RederTable.renderWelcomeMessage();
        Scanner scanner=new Scanner(System.in);
        int input;
        do{
           RederTable.rederMenu();
            System.out.println("Please enter your choice");
            input=scanner.nextInt();
            switch (input){
                case 1:
                    employee employeeobj=new employee();
                    try {
                        System.out.println("Enter your id: ");
                        int id=scanner.nextInt();
                        System.out.println("Enter your name: ");
                        scanner.nextLine();
                        String name=scanner.nextLine();
                        System.out.println("Enter your age: ");
                        int age=scanner.nextInt();
                        System.out.println("Enter your salary: ");
                        int salary=scanner.nextInt();
                        employeeobj.setId(id);
                        employeeobj.setName(name);
                        employeeobj.setAge(age);
                        employeeobj.setSalary(salary);
                        em.createEmployee(employeeobj);

                    }catch (InputMismatchException ex){
                        System.out.println("invaid input bro");
                    }
                    break;
                case 2:
                    em.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Please enter employee's id to see detail");
                    int id=scanner.nextInt();
                    em.showEmployeeBasedOnId(id);
                    break;
                case 4:
                    System.out.println("Enter employee's id: ");
                    int idUpdate= scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter employee's name: ");
                    String nameUpdate=scanner.nextLine();
                    em.updateEmployee(idUpdate,nameUpdate);
                    break;
                case 5:
                    System.out.println("Enter id to remove");
                    int idRemove= scanner.nextInt();
                    em.deleteEmployee(idRemove);
                    break;
                case 6:
                   RederTable.thanksMessage();
                    break;
                default:
                    System.out.println("Invalid input please try again!!");

            }


        }while(input!=6);
    }
}

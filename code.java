package com.tka.controller;

import java.util.Scanner;
import com.tka.entity.Employees;
import com.tka.methods.EmployeeData;

public class EmpMethodMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        char ans = 'y';
        
        do {
            // Display the menu options
            System.out.println("\nEmployee Management System:");
            System.out.println("1. Add employee details");
            System.out.println("2. Display employee by ID");
            System.out.println("3. Display all employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1: {
                    System.out.println("Enter employee ID, name, and salary:");
                    Employees e = new Employees(sc.nextInt(), sc.next(), sc.nextFloat());
                    EmployeeData.addEmployee(e);  // Add employee to the list
                    System.out.println("Employee added successfully!");
                    break;
                }
                case 2: {
                    System.out.print("Enter employee ID to display: ");
                    int empId = sc.nextInt();
                    Employees e = EmployeeData.getEmployeeById(empId);  // Fetch employee by ID
                    if (e != null) {
                        System.out.println("Employee details:\n" + e);  // Use toString() method to display details
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                }
                case 3: {
                    Employees[] allEmployees = EmployeeData.getAllEmployees();  // Fetch all employees
                    if (allEmployees.length > 0) {
                        System.out.println("Employee List:");
                        for (Employees emp : allEmployees) {
                            System.out.println(emp);  // Use toString() to display employee details
                        }
                    } else {
                        System.out.println("No employees found!");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Exiting program...");
                    break;
                }
                default:
                    System.out.println("Invalid option! Please try again.");
            }

            if (choice != 4) {
                System.out.print("Do you want to continue? (y/n): ");
                ans = sc.next().toLowerCase().charAt(0);
            } else {
                ans = 'n'; // To exit the loop
            }

        } while (ans == 'y');

        sc.close();
    }
}

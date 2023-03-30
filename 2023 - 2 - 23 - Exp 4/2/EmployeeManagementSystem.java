import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;

        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option, please select again.");
                    break;
            }
        }
    }

    public static void addEmployee() {
        try {
            FileWriter fw = new FileWriter("employees.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            System.out.println("Enter Employee Name: ");
            String name = sc.next();

            System.out.println("Enter Employee ID: ");
            String id = sc.next();

            System.out.println("Enter Employee Designation: ");
            String designation = sc.next();

            System.out.println("Enter Employee Salary: ");
            String salary = sc.next();

            pw.println(name + "," + id + "," + designation + "," + salary);
            pw.flush();
            pw.close();

            System.out.println("Employee added successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void displayAll() {
        try {
            FileReader fr = new FileReader("employees.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] employeeDetails = line.split(",");
                System.out.println("Employee Name: " + employeeDetails[0]);
                System.out.println("Employee ID: " + employeeDetails[1]);
                System.out.println("Employee Designation: " + employeeDetails[2]);
                System.out.println("Employee Salary: " + employeeDetails[3]);
                System.out.println("-----------------------");
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
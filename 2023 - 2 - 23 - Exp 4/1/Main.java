import java.util.*;
import java.io.*;
import java.io.IOException;

class Employee {
    Scanner sc = new Scanner(System.in);

    public void addEmployee() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("employee.txt", true))) {
            System.out.print("\nEnter employee name: ");
            String name = sc.next();
            System.out.print("Enter employee id: ");
            int id = sc.nextInt();
            System.out.print("Enter employee designation: ");
            String designation = sc.next();
            writer.printf("%s,%d,%s\n", name, id, designation);
            System.out.println("Employee added successfully.\n");
        } catch (IOException e) {
            System.err.println("Error adding employee: " + e.getMessage());
        }
    }

    public void displayall() {
        try (Scanner reader = new Scanner(new File("employee.txt"))) {
            System.out.println("EMPLOYEE LIST");
            System.out.println("==============");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] fields = line.split(",");
                String name = fields[0];
                int id = Integer.parseInt(fields[1]);
                String designation = fields[2];
                System.out.printf("Name: %s, ID: %d, Designation: %s\n",
                        name, id, designation);
            }
        } catch (IOException e) {
            System.err.println("Error displaying employees: " + e.getMessage());
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Employee e = new Employee();
        Scanner sc = new Scanner(System.in);
        int cont = 1;
        int choice;
        while (cont == 1) {
            System.out.println("Press 1. To add employee record");
            System.out.println("Press 2. To display employee records");
            System.out.println("Press 3. To exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    e.addEmployee();
                    break;

                case 2:
                    e.displayall();
                    break;
                case 3:
                    cont = 0;
                    break;
                default:
                    System.out.println("Wrong Input");
            }
        }
    }
}
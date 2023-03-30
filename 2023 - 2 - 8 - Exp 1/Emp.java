import java.util.*;

public class Emp {
    /*
     * Designations-
     * CEO
     * Manager
     * HR
     * Developer
     */

    Scanner sc = new Scanner(System.in);

    public int empId;
    public String depName;
    public String empDes;
    public String empName;
    public String dateJoin;
    public float basic;
    public int hra;
    public int itr;
    public double da;
    public int desCode;
    public double salary;

    public void empInit() {
        // empId
        System.out.println("Enter Employee ID: ");
        this.empId = sc.nextInt();

        // emp Department Name
        System.out.println("Enter Employee Department Name: ");
        sc.nextLine();
        this.depName = sc.nextLine();

        // Emp Designation
        System.out.println("Press Corresponding Number for Employee Designation: ");
        System.out.println("0 -> CEO");
        System.out.println("1 -> Manager");
        System.out.println("2 -> HR");
        System.out.println("3 -> Developer");
        int choice = sc.nextInt();
        if (choice == 0)
            this.empDes = "CEO";
        else if (choice == 1)
            this.empDes = "Manager";
        else if (choice == 2)
            this.empDes = "HR";
        else if (choice == 3)
            this.empDes = "Developer";

        // Emp Name
        System.out.println("Enter Employee Name: ");
        sc.nextLine();
        this.empName = sc.nextLine();

        // Emp Joining
        System.out.println("Enter Employee Joining Date (format = DD/MM/YYYY): ");
        this.dateJoin = sc.nextLine();

        // Emp Basic Salary
        System.out.println("Enter Employee Base Salary Amount: ");
        this.basic = sc.nextFloat();

        // Emp HRA
        System.out.println("Enter Employee HRA Amount: ");
        this.hra = sc.nextInt();

        // Emp ITR
        System.out.println("Enter Employee ITR: ");
        this.itr = sc.nextInt();

        // EMP DA
        this.da = (double) basic * 0.1;

        // EMP Salary
        this.salary = this.basic + this.hra + this.da - this.itr;

        // desCode
        if (choice == 0)
            this.desCode = 9981;
        else if (choice == 1)
            this.desCode = 9990;
        else if (choice == 2)
            this.desCode = 9931;
        else if (choice == 1)
            this.desCode = 9895;
    }

    public void display() {
        System.out.println("Employee ID: " + this.empId);

        System.out.println("Employee Name: " + this.empName);

        System.out.println("Employee Department Name: " + this.depName);

        System.out.println("Employee Designation: " + this.empDes);

        System.out.println("Employee Designation Code: " + this.desCode);

        System.out.println("Employee Joining Date: " + this.dateJoin);

        System.out.println("Employee Salary Breakdown : " + this.empId);

        System.out.println("\tBasic = " + this.basic);

        System.out.println("\tHRA (House Rent Analysis) = " + this.hra);

        System.out.println("\tITR (Income Tax Return): " + this.itr);

        System.out.println("\tDA (Daily Allowances): " + this.da);

        System.out.println("Total Salary = " + this.salary);

    }

    public static void main(String[] args) {

        System.out.println("Enter Employee Details of 4 Employees");

        Emp empArr[] = new Emp[4];
        for (int i = 1; i < 5; i++) {

            empArr[i - 1] = new Emp();

            System.out.println("Enter the " + i + " Employee Details");
            System.out.println("\n");
            empArr[i - 1].empInit();
            System.out.println("\n");
        }

        for (int i = 1; i < 5; i++) {
            System.out.println("Employee " + i);
            System.out.println("\n");
            empArr[i - 1].display();
            System.out.println("\n");
        }
    }

}

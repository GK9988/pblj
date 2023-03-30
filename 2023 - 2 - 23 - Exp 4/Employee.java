import java.io.Serializable;
import java.util.*;
import java.io.*;

class Employee implements Serializable {
    private int id;
    private String name;
    private double salary;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
                + ", age=" + age + "]";
    }

    public Employee(int id, String name, double salary, int age) {
        super();
        setId(id);
        setName(name);
        setSalary(salary);
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class EmployeeManager {
    int menuChoice = 0;
    Scanner objectScanner = new Scanner(System.in);
    List<Employee> objectEmployeeList = new LinkedList<Employee>();

    public static void main(String[] args) {
        EmployeeManager objectManager = new EmployeeManager();
        objectManager.displayMenu();
        while (objectManager.menuChoice != 5) {
            objectManager.displayMenu();
        }
    }

    void displayMenu() {
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("1.Add an employee");
        System.out.println("2.Display All");
        System.out.println("3. Write all the entered employees to file");
        System.out.println("4.Read all the employees from the file");
        System.out.println("5.Exit");
        System.out.println();

        menuChoice = objectScanner.nextInt();
        try {
            switch (menuChoice) {
                case 1:
                    getEmployeeInformationFromConsole();
                    break;
                case 2:
                    displayFromList(objectEmployeeList);
                    break;
                case 3:
                    System.out.println("Write the file name you want to write to ");
                    writeEmployeesToFile(objectScanner.next());
                    break;
                case 4:
                    System.out.println("Write the file name you want to read from ");
                    readEmployeesFromFile(objectScanner.next());
                    break;
                case 5:
                    System.out.println("Exiting the program");
                    System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Exception is----->" + e);
        }
    }

    void writeEmployeesToFile(String fileName) {
        File fileObject = new File(fileName);
        FileOutputStream fileStreamObject;
        try {
            fileStreamObject = new FileOutputStream(fileObject);
            System.out.println(" inside file");

            ObjectOutputStream objectWriterToFile = new ObjectOutputStream(fileStreamObject);
            objectWriterToFile.writeObject(objectEmployeeList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String readEmployeesFromFile(String fileName) {
        String status = null;
        File fileobject = new File(fileName);
        if (!fileobject.exists()) {
            status = "unable to create the file";
            return status;
        }

        FileInputStream fileStreamObject;
        try {
            fileStreamObject = new FileInputStream(fileobject);
            ObjectInputStream objectReaderFromFile = new ObjectInputStream(fileStreamObject);
            objectEmployeeList.clear();
            objectEmployeeList = (List<Employee>) objectReaderFromFile.readObject();
            status = displayFromList(objectEmployeeList);
            if (status.equalsIgnoreCase("Displayed Successfully")) {
                status = "Files read from file successfully";
            } else {
                status = "";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return status;
    }

    void getEmployeeInformationFromConsole() {
        System.out.println("Enter Employee ID:");
        try {
            int id = objectScanner.nextInt();
            System.out.println("Enter Employee Name:");
            String name = objectScanner.next();
            System.out.println("Enter Employee Age:");
            int age = objectScanner.nextInt();
            System.out.println("Enter Employee Salary:");
            double salary = objectScanner.nextDouble();
            objectEmployeeList.add(new Employee(id, name, salary, age));
        } catch (InputMismatchException e) {
            System.out.println("" + e);
        }

    }

    String displayFromList(List<Employee> objectList) {
        String status = "";
        try {
            Iterator objectIterator = objectList.iterator();
            while (objectIterator.hasNext()) {
                System.out.println("" + objectIterator.next());
            }
            status = "Displayed Successfully";
            return status;

        } catch (Exception e) {
            status = "Failure";
            return status;
        }
    }
}

import java.util.*;

class Account {
    double principle;
    int accid;
}

class SavingsAccount extends Account {
    double interest = 0;
    int days, age, rate;
    double savingsrate = 0.14;

    SavingsAccount(double principle, int month, int age) {
        interest = (principle * savingsrate * month) / 100;
        System.out.println();
        System.out.println("The orignal amount was: " + principle);
        System.out.println("The interest added is : " + interest);
        System.out.println("Final amount in account is: " + (principle + interest));
        System.out.println();
    }
}

class FixedDeposit extends Account {
    double fixedrate = 1.8;
    double interest = 0;

    FixedDeposit(double principle, int years, int age) {
        if (age > 60) {
            fixedrate = 7;
        }
        interest = (principle * fixedrate * years) / 100;

        System.out.println();
        System.out.println("The orignal amount in FD was: " + principle);
        System.out.println("The interest added is : " + interest);
        System.out.println("Final amount in FD is: " + (principle + interest));
        System.out.println();
    }
}

class RecurringDeposit extends Account {
    double recurringrate = 0.2;
    double interest = 0;

    RecurringDeposit(double principle, int days, int age) {
        if (age > 50) {
            recurringrate = 0.8;
        }
        interest = (principle * recurringrate * days) / 100;

        System.out.println();
        System.out.println("The orignal amount in RD was: " + principle);
        System.out.println("The interest added is : " + interest);
        System.out.println("Final amount in RD is: " + (principle + interest));
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        double principle;
        int month, years, days, age;
        Scanner sc = new Scanner(System.in);
        int choice, cont = 1;
        while (cont == 1) {
            System.out.println("Press 1. Calculate Interest Savings Account");
            System.out.println("Press 2. Calculate Interest Fixed Deposit");
            System.out.println("Press 3. Calculate Interest Recurring Deposit");
            System.out.println("Press 4. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter principle: ");
                    principle = sc.nextDouble();
                    System.out.print("Enter months: ");
                    month = sc.nextInt();
                    System.out.print("Enter age: ");
                    age = sc.nextInt();

                    SavingsAccount sa = new SavingsAccount(principle, month, age);

                    break;

                case 2:
                    System.out.print("Enter principle: ");
                    principle = sc.nextDouble();
                    System.out.print("Enter years: ");
                    years = sc.nextInt();
                    System.out.print("Enter age: ");
                    age = sc.nextInt();

                    FixedDeposit fd = new FixedDeposit(principle, years, age);

                    break;

                case 3:
                    System.out.print("Enter principle: ");
                    principle = sc.nextDouble();
                    System.out.print("Enter days: ");
                    days = sc.nextInt();
                    System.out.print("Enter age: ");
                    age = sc.nextInt();

                    RecurringDeposit rd = new RecurringDeposit(principle, days, age);

                    break;

                case 4:
                    cont = 0;
                    break;
            }
        }
    }
}
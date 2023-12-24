package OOP_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    protected String username="admin";
    protected String password="admin";
    Scanner scanner = new Scanner(System.in);


    void DisplayEmployees(ArrayList<Employee> Employees){ //takes the employees array
        for (Employee employee:Employees) {
            System.out.println(employee.toString());      //needs toString method overriding
        }
    }
    void DisplayClients(ArrayList<Client> clients){ //takes array of clients
        for(Client client:clients){
            System.out.println(client.toString());    //needs toString method overriding
        }

    }

    void authorizeEmployee(ArrayList<Employee> emps){
        System.out.println("Non-authorized employees: \n");
        int i =1;
        for (Employee employee : emps) {
            if (!employee.status){
                System.out.println(i+++"- Employee ID: "+employee.id+"\n"+"   Name: "+employee.firstName+" "+employee.lastName);

            }
        }
        int inputId;
        boolean validInput;
        boolean authorizedEmployee = false;
        boolean found=false;
        // Validate user input
        System.out.println("Enter Employee's ID to authorize (enter 0 to exit): ");
        do {

            if (scanner.hasNextInt()) {
                inputId = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                validInput = false;
                scanner.next(); // Consume the invalid input
                inputId = 0;
                continue;
            }
            for (Employee employee : emps) {
                if (employee.id == inputId) {
                    found = true;
                    break;
                }
            }
            for (Employee employee : emps) {
                if (employee.id == inputId && !employee.status) {
                    authorizedEmployee = true;
                    employee.status = true;
                    System.out.println("Employee Authorized Successfully");
                    break;
                }else if (!found) {
                    System.out.println("Invalid Employee ID. Please enter a valid ID.");
                    break;
                }
                else if (employee.id == inputId && (employee.status)) {
                    System.out.println("Employee is already authorized");
                    break;
                }
            }

        } while (!validInput || (inputId != 0 && !authorizedEmployee));
    }
  //missing method to view transactions by date/clientID/EmloyeeID
    public void showTransactions(ArrayList<Employee> employees, ArrayList<Client> clients,
                                        ArrayList<transaction> transactions) {
        int choice = 0;
        boolean validChoice = false;
        boolean validInput = false;
        int targetID;
        String date;
        int i = 1;
        System.out.println("Search for Transactions by: \n  1-Client ID\n  2-Employee ID\n  3-Date of transaction\n");
        Scanner scanner = new Scanner(System.in);
        do {
            // Check if the input is an integer
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }

            // Get the integer input
            choice = scanner.nextInt();

            // Check if the integer is within the desired range
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }

        } while (choice < 1 || choice > 3);


        validChoice = true;


        if (choice == 1) {
            validChoice = true;
            System.out.println("Enter Client ID: ");
            do {
                // Check if the input is an integer
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid ID.");
                    scanner.next(); // Consume the invalid input
                }

                // Get the integer input
                targetID = scanner.nextInt();
                validInput = true;
                boolean transactionFound = false, idFound = false;
                for (transaction trans : transactions) {
                    if (trans.getCustomerId() == targetID) {
                        System.out.println("  " + i + " - Sender ID: " + trans.getCustomerId() + "\n     " +
                                "Recipient ID: " + trans.getRecipientId() + "\n     " +
                                "Amount: " + trans.getTransactionAmount() + "\n     " +
                                "Date: " + trans.getTransactionDate() + "\n     " +
                                "Done By Employee number: " + trans.getemployeeId() + "\n");
                        i++;
                        transactionFound = true;
                    }
                }
                if (!transactionFound) {
                    System.out.println("No Transactions found!");
                }


            } while (!validInput);

        } else if (choice == 2) {
            validChoice = true;
            System.out.println("Enter Employee ID: ");
            do {
                // Check if the input is an integer
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid ID.");
                    scanner.next(); // Consume the invalid input
                }
                targetID = scanner.nextInt();
                validInput = true;
                boolean transactionFound = false, idFound = false;
                for (transaction trans : transactions) {
                    if (trans.getemployeeId() == targetID) {
                        System.out.println("  " + i + " - Sender ID: " + trans.getCustomerId() + "\n     " +
                                "Recipient ID: " + trans.getRecipientId() + "\n     " +
                                "Amount: " + trans.getTransactionAmount() + "\n     " +
                                "Date: " + trans.getTransactionDate() + "\n     " +
                                "Done By Employee number: " + trans.getemployeeId() + "\n");
                        transactionFound = true;
                    }
                }
                if (!transactionFound) {
                    System.out.println("No Transactions found!");
                }


            } while (!validInput);

        } else {
            int day, month, year;

            System.out.println("Enter Date of Transaction: ");

            System.out.println("Enter day: ");
            while (!scanner.hasNextInt()) {            // Check if the input is an integer
                System.out.println("Please insert a valid Day!");
                scanner.next(); // Consume the invalid input
            }
            day = scanner.nextInt();
            if (day < 1 || day > 31) {
                System.out.println("Invalid day. Enter a day between 1-31!");

                while (!scanner.hasNextInt()) {            // Check if the input is an integer
                    System.out.println("Please insert a valid Day!");
                    scanner.next(); // Consume the invalid input
                }
                day = scanner.nextInt();
            }

            System.out.println("Enter Month : ");
            while (!scanner.hasNextInt()) {            // Check if the input is an integer
                System.out.println("Please insert a valid Month!");
                scanner.next(); // Consume the invalid input
            }
            month = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Invalid Month. Enter a Month between 1-12!");

                while (!scanner.hasNextInt()) {            // Check if the input is an integer
                    System.out.println("Please insert a valid Month!");
                    scanner.next(); // Consume the invalid input
                }
                month = scanner.nextInt();
            }
            System.out.println("Enter Year: ");
            while (!scanner.hasNextInt()) {            // Check if the input is an integer
                System.out.println("Please insert a valid Year!");
                scanner.next(); // Consume the invalid input
            }

            year = scanner.nextInt();

            while (year < 1970 || year > 2023) {
                System.out.println("Invalid Year. Enter a year between 1970-2023!");

                while (!scanner.hasNextInt()) {            // Check if the input is an integer
                    System.out.println("Please insert a valid Year!");
                    scanner.next(); // Consume the invalid input
                }

                year = scanner.nextInt();
            }


            date = day + "-" + month + "-" + year;
            boolean transactionFound = false;
            for (transaction trans : transactions) {
                if (trans.getTransactionDate().equals(date)) {
                    transactionFound = true;
                    System.out.println("  " + i++ +" " + trans);
                }
            }
            if (!transactionFound) {
                System.out.println("No Transactions Found!");
            }

        }
    }
}

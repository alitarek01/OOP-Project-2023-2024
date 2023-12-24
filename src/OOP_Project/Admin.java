package OOP_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    protected String username="Admin";
    protected String password="Admin";
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
    void showTransactions(ArrayList<Employee> employees, ArrayList<Client> clients,
                                ArrayList<transaction> transactions) {
        int choice = 0;
        boolean validChoice = false;
        int targetID;
        String date;
        int i = 1;
        System.out.println("Search for Transactions by: \n  1-Client ID\n  2-Employee ID\n  3-Date of transaction\n");
        Scanner scanner = new Scanner(System.in);
        do {
            if ((scanner.hasNextInt())) {
                choice = scanner.nextInt();
                if (choice < 0 || choice > 3) {
                    System.out.println("Invalid Choice. Please choose a number between 1-3!\n");
                    validChoice = false;
                    scanner.next(); // Consume the invalid input
                    break;//
                }
            }
            if (choice == 1) {
                validChoice = true;
                System.out.println("Enter Client ID: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please insert a valid ID number!\n");
                    scanner.next(); // Consume the invalid input
                }
                targetID = scanner.nextInt();
                for (transaction trans : transactions) {
                    if (trans.getCustomerId() == targetID) {// i should increment, || recpient id, use to string
                        System.out.println("  " + i + " - Sender ID: " + trans.getCustomerId() + "\n     " +
                            "Recipient ID: " + trans.getRecipientId() + "\n     " +
                            "Amount: " + trans.getTransactionAmount() + "\n     " +
                            "Date: " + trans.getTransactionDate() + "\n     " +
                            "Done By Employee number: " + trans.getemployeeId() + "\n");
                    }
                }

            } else if (choice == 2) {
                validChoice = true;
                System.out.println("Enter Employee ID: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please insert a valid ID number!\n");
                    scanner.next(); // Consume the invalid input
                }
                targetID = scanner.nextInt();
                for (transaction trans : transactions) {
                    if (trans.getemployeeId() == targetID) {// i should increment, use to string
                        System.out.println("  " + i + " - Sender ID: " + trans.getCustomerId() + "\n     " +
                            "Recipient ID: " + trans.getRecipientId() + "\n     " +
                            "Amount: " + trans.getTransactionAmount() + "\n     " +
                            "Date: " + trans.getTransactionDate() + "\n     " +
                            "Done By Employee number: " + trans.getemployeeId() + "\n");
                    }
                }
            } else if (choice == 3) {
                int day, month, year;
                System.out.println("Enter Date of Transaction: ");

                System.out.println("Enter day: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please insert a valid Day!");
                    scanner.next(); // Consume the invalid input
                }
                day = scanner.nextInt();
                if (day < 1 || day > 31) {
                    System.out.println("Invalid day. Enter a day between 1-31!");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Please insert a valid Day!");
                        scanner.next(); // Consume the invalid input
                    }
                    day = scanner.nextInt();
                }

                System.out.println("Enter Month : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please insert a valid Month!");
                    scanner.next(); // Consume the invalid input
                }
                month = scanner.nextInt();
                if (month < 1 || month > 12) {
                    System.out.println("Invalid Month. Enter a Month between 1-12!");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Please insert a valid Month!");
                        scanner.next(); // Consume the invalid input
                    }
                    month = scanner.nextInt();
                }

                System.out.println("Enter Year: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please insert a valid Year!");
                    scanner.next(); // Consume the invalid input
                }
                year = scanner.nextInt();
                if (year < 1970 || year > 2023) {
                    System.out.println("Invalid Year. Enter a year between 1970-2023!");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Please insert a valid Year!");
                        scanner.next(); // Consume the invalid input
                    }
                    year = scanner.nextInt();
                }

                date = day + "/" + month + "/" + year;
                for (transaction trans : transactions) {
                    if (trans.getTransactionDate().equals(date)) {// i should increment, use to string
                        System.out.println("  " + i + " - Sender ID: " + trans.getCustomerId() + "\n     " +
                            "Recipient ID: " + trans.getRecipientId() + "\n     " +
                            "Amount: " + trans.getTransactionAmount() + "\n     " +
                            "Date: " + trans.getTransactionDate() + "\n     " +
                            "Done By Employee number: " + trans.getemployeeId() + "\n");
                    }
                }

        }
        } while (!validChoice);
    }
}

package OOP_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String username="admin";
    private String password="admin";

    Boolean AdminLogIn(String username, String password){
        return (this.username.equals(username)) && (this.password.equals(password));
    }
    void DisplayEmployees(ArrayList<Employee> Employees){ //takes the employees array
        for (Employee employee:Employees) {
            System.out.println(employee);      //needs toString method overriding
        }
    }
    void DisplayClients(ArrayList<Client> clients){ //takes array of clients
        for(Client client:clients){
            System.out.println(client);    //needs toString method overriding
        }

    }

    static void authorizeEmployee(ArrayList<Employee> emps){
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
            Scanner scanner = new Scanner(System.in);

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
                    found=true;
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
                    authorizedEmployee = false;
                    break;
                }
            }

        } while (!validInput || (inputId != 0 && !authorizedEmployee));
    }
  //missing method to view transactions by date/clientID/EmloyeeID
}

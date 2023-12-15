package OOP_Project;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author alit7
 */
public class Employee {

    Scanner scanner = new Scanner(System.in);


    String username;
    String password;
    int id;
    String firstName;
    String lastName;
    String address;
    String position;
    String graduatedCollage;
    int yearOfGraduation;
    String totalGrade;
    static int counter = 1;


    //For testing

    public Employee(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    Employee(String username, String password, String firstName, String lastName, String address, String position, String graduatedCollage, int yearOfGraduation, String totalGrade) {
        this.id = counter;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.position = position;
        this.graduatedCollage = graduatedCollage;
        this.yearOfGraduation = yearOfGraduation;
        this.totalGrade = totalGrade;
        counter++;

    }

    // Methods
    void EmployeeEditInfo() {

        while (true) {
            System.out.println("Press 1 to change your address\nPress 2 to change your position");  // ask him what to change
            int editInfoInput = scanner.nextInt();
            if (editInfoInput == 1) {
                System.out.println("Enter your new address:");
                this.address = scanner.nextLine();
                break;
            }
            else if (editInfoInput == 2) {
                this.position = scanner.nextLine();
                break;
            }
            else{
                System.out.println("Wrong Input!, try Again");
            }
        }

    }

    // This function is used to check if the username and password of the client are correct
    Boolean UPcheckerForClient(String user, String pass, Client[] clients) {

        for (int i = 0; i < clients.length; i++) {
            if (clients[i].username.equals(user) && clients[i].password.equals(pass)) {
                return true;
            }
        }

        return false;
    }
    Boolean employeeUPChecker(Client[] clients) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i].username == this.username && clients[i].password == this.password) {
                return true;
            }

        }

        return false;
    }

    void createAClient(ArrayList<Client> clients2) {
        System.out.println("Enter Client's ID:");
        int ID = scanner.nextInt();

        System.out.println("Enter Client's FirstName:");
        String firstName = scanner.next();

        System.out.println("Enter Client's LastName:");
        String lastName = scanner.next();
        System.out.println("Enter Client's Username:");
        String username = scanner.next();
        System.out.println("Enter Client's Password:");
        String password = scanner.next();
        System.out.println("Enter Client's telephoneNumber:");
        long telephoneNumber = scanner.nextLong();
        clients2.add(new Client(ID, firstName, lastName, username, password, telephoneNumber));

    }

    boolean EmployeeCreatingAccount(ArrayList<Client> clients2, int ID) {
        String clientUsername;
        String clientPassword;
        int clientIndex = -1;
        boolean clientFounded = false;
        for (int i = 0; i < clients2.size(); i++) {
            if (clients2.get(i).ID == ID) {
                clientFounded = true;
                clientIndex = i;
                break;
            }
        }
        if (clientFounded) {
            while (true) {
                System.out.println("Enter the username and password of the client ");
                System.out.println("Username:");
                clientUsername = scanner.nextLine();

                System.out.println("Password:");
                clientPassword = scanner.nextLine();
                if (clients2.get(clientIndex).username.equals(clientUsername) && clients2.get(clientIndex).password.equals(clientPassword)) {
                    System.out.println("Press 1 to Create saving account\nPress 2 to Create current account\nPress 0 to cancel:");
                    int inputAccountType;
                    inputAccountType = scanner.nextInt();
                    double initialbalance;
                    if (inputAccountType == 1) {
                    System.out.println("enter initial balance:");
                        initialbalance = scanner.nextDouble();
                        clients2.get(clientIndex).myAccounts.add(new SavingAccount(initialbalance));
                        return true;

                    } else if (inputAccountType == 2) {
                        System.out.println("enter initial balance:");
                        initialbalance = scanner.nextDouble();
                        clients2.get(clientIndex).myAccounts.add(new CurrentAccount(initialbalance));
                        return true;

                    }
                    else {return true;}

                } else {
                    System.out.println("wrong input");
                }
            }

        }
        else {
            System.out.println("ID not found\nTry Again!");
            return false;
        }
    }


    boolean EmployeeEditClient(ArrayList<Client> clients2, int ID) {
        int clientIndex = -1;
        boolean clientFounded = false;
        for (int i = 0; i < clients2.size(); i++) {
            if (clients2.get(i).ID == ID) {
                clientFounded = true;
                clientIndex = i;
                break;
            }
        }
        if (clientFounded) {
            while (true) {
                System.out.println("Press 1 to change Client's username\nPress 2 to change Client's password");  // ask him what to change
                int editInfoInput = scanner.nextInt();
                if (editInfoInput == 1) {
                    System.out.println("Enter new Username:");
                    clients2.get(clientIndex).username = scanner.nextLine();
                    return true;
                } else if (editInfoInput == 2) {
                    clients2.get(clientIndex).password = scanner.nextLine();
                    return true;
                } else {
                    System.out.println("Wrong Input!, try Again");
                }
            }
        } else {
            System.out.println("ID not found\nTry Again!");
            return false;
        }

    }
// Working on it don't edit any thing
    
//    boolean EmployeeSearchClient(ArrayList<Client> clients2, int ID){
//        int clientIndex = -1;
//        boolean clientFounded = false;
//        for (int i = 0; i < clients2.size(); i++) {
//            if (clients2.get(i).ID == ID) {
//                clientFounded = true;
//                clientIndex = i;
//                break;
//            }
//        }
//    }

    // create a method that takes an array of client and an id to update his username and password
    // Or use index() and get() in arraylist




         /*

         Raise an exception here if the username and password were not found


         */

//     }

    static Employee[] addToArray(Employee[] array, Employee newItem) {
        int length = array.length;

        // Create a new array with increased size
        Employee[] newArray = new Employee[length + 1];

        // Copy the elements from the original array to the new array
        System.arraycopy(array, 0, newArray, 0, length);

        // Add the new item to the last index
        newArray[length] = newItem;

        return newArray;
    }

//     static EmployeeSearchForClient(Client [] clients , int id)
//     {
//         for(Client client : clients)
//         {
//             if (client.id == id)
//             {
//                 // Display all data of the client
//             }
//         }
//     }


    // this method is used to add new created account to the client's account array
    // omar and samir must complete it
   /* public void AddingNewAccountToAccountArray(String username , Client [] clients)
    {
        System.out.println("Enter 1 to create a saving account or 2 to create a current account:");
        int num = scanner.nextInt();
        if (num == 1)
        {
            // Write a statement asking the user to enter details of the account and give it to the constructor

            SavingAccount temp = new SavingAccount();
            for (int i = 0 ; i < clients.length ; i++ ) {
                int num = clients.indexOf(client[i].username);
            }
        }
        else if (num == 2)
        {
            // Write a statement asking the user to enter details of the account and give it to the constructor

            CurrentAccount temp = new CurrentAccount();
            this.addAccount(temp);
        }

    }*/
//    public void EmployeeAddAccount( Client [] clients)
//    {
//        System.out.println("Please enter username and password of the client");
//        System.out.println("Username:"); String user = scanner.nextLine();
//        System.out.println("Password:"); String pass = scanner.nextLine();
//        if (UPcheckerForClient(user , pass  , clients))
//        {
//            System.out.println("Enter 1 for saving account or 2 for current account or 0 to cancel:");
//
//
//            // Call the method that adds new account to the array of accounts of a specific client
//        }
//
//
//
//    }

}

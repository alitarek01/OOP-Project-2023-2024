package OOP_Project;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

/**
 *
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

    Employee(String username , String password , String firstName, String lastName , String address , String position  , String graduatedCollage , int yearOfGraduation , String totalGrade)
    {
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

    
    void EmployeeEditInfo(  )
    {
        System.out.println("Enter 1 to ");  // ask him what to change
        System.out.println("Enter your new address:");
        String address = scanner.nextLine();
        String position = scanner.nextLine();
                this.address = address;
                this.position = position;


    }

    /*
    *
    * Create a method to add an account to the client

    *
    * */


    // This function is used to check if the username and password of the client are correct
    Boolean UPcheckerForClient(String user , String pass , Client [] clients)
    {

        for (int i = 0 ; i < clients.length ; i++ )
        {
            if (clients[i].username.equals(user) && clients[i].password.equals(pass)){return true;}
        }

        return false;
    }


    void createAClient (ArrayList <Client>  clients2){
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
        clients2.add(new Client(ID,  firstName,  lastName,  username,  password,  telephoneNumber));

    }


    // this method is used to create an account to an existing client
    void EmployeeCreatingAccount(ArrayList <Client> clients2  , int ID) {
        String clientUsername;
        String clientPassword;
        for (int i = 0; i < clients2.size(); i++) {
            if (clients2.get(i).ID == ID) {

                System.out.println("Enter the username and password of the client "); // the program asking the employee to enter the username and password of the client to proceed
                System.out.println("Username:");
                clientUsername = scanner.nextLine();

                System.out.println("Password:");
                clientPassword = scanner.nextLine();
                if (clients2.get(i).username.equals(clientUsername) && clients2.get(i).password.equals(clientPassword)) {
                    System.out.println("Press 1 to Create saving account\nPress 2 to Create current account\nPress 0 to cancel:");
                    int inputAccountType;
                    inputAccountType = scanner.nextInt();
                    System.out.println("enter initial balance:");
                    double initialbalance;
                    initialbalance = scanner.nextDouble();
                    if (inputAccountType == 1) {
                        clients2.get(i).myAccounts.add(new SavingAccount(initialbalance));
                    }
                    if (inputAccountType == 2) {
                        clients2.get(i).myAccounts.add(new CurrentAccount(initialbalance));
                    }

                }
            } else {
                System.out.println("ID not found\nTry Again!");
            }

        }

    }

    Boolean employeeUPChecker(Client [] clients)
    {
        for (int i = 0; i < clients.length; i++)
        {
            if (clients[i].username == this.username && clients[i].password == this.password)
            {
             return true;
            }

        }

        return false;
    }


    // create a method that takes an array of client and an id to update his username and password
    // Or use index() and get() in arraylist

    //void EmployeeEditClient



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

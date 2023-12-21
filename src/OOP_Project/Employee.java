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
    private static Scanner in = new Scanner(System.in);


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
        EmployeeCreatingAccount(clients2,ID);

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


     static void EmployeeSearchForClient(ArrayList <Client> clients2 )
     {
        while(true) {
            System.out.println("Enter 1 to search for the client by ID or 2 to search by account number.");
            System.out.println("Enter 0 to cancel.");
            System.out.println("Input:");
            int x = in.nextInt();
            if (x == 1) {
                System.out.println("Please enter the ID of the client:");
                int ID = in.nextInt();
                for (Client obj : clients2) {
                    if (obj.ID == ID) {
                        obj.toString();
                        break;
                    } else {
                        System.out.println("No client was found.");
                    }
                }
            } else if (x == 2) {
                boolean found = false;
                System.out.println("Please enter the account number of the client:");
                int n = in.nextInt();
                for (Client obj : clients2) {
                    for (Account acc : obj.myAccounts) {
                        if (acc.accountNumber == n) {
                            found = true;
                            obj.toString();
                            break;
                        }
                    }
                }
                if (!found) {
                    System.out.println("No client was found.");
                }
            } else if (x == 0) {
                return;
            } else {
                System.out.println("Wrong input");
            }
        }
     }


     static void EmployeeDeletingAccount(ArrayList <Client> clients2)
     {
         System.out.println("Please enter the username and password of the Client account.");
         System.out.println("Enter C in the username if you want to cancel");
         System.out.println("Username: ");String user = in.nextLine();
         if (user.equals("C") || user.equals("c")){return;}
         System.out.println("Password: ");String pass = in.nextLine();
         for (Client obj: clients2)
         {
             if (obj.username.equals(user) && obj.password.equals(pass))
             {

                 for (Account acc:obj.myAccounts)
                 {
                     System.out.println("--------------------------------");
                     System.out.println("     Account Number: " + acc.accountNumber);
                     System.out.println("     Balance: $" + acc.balance);
                     System.out.println("--------------------------------");

                 }

                 System.out.println("Enter the account number of the account you want to delete:");
                 int accNum = in.nextInt();

                 System.out.println("Enter 1 to confirm deletion or 0 to cancel.");
                 int ans = in.nextInt();
                 if (ans == 1)
                 {
                     for (Account acc:obj.myAccounts)
                     {
                         if (acc.accountNumber == accNum)
                         {
                             obj.myAccounts.remove(acc);
                         }
                     }
                     System.out.println("Account deleted successfully.");

                 } else if (ans == 0) {
                     return;
                 }


             }
             else
             {
                 System.out.println("/nNo client was found./n");
             }
         }

     }




}

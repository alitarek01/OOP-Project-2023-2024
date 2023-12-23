package OOP_Project;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author alit7
 */
public class Employee {

    Scanner scanner = new Scanner(System.in);
    private static Scanner in = new Scanner(System.in);


    //String username;
    String password;
    int id;
    String firstName;
    String lastName;
    String address;
    String position;
    String graduatedCollage;
    int yearOfGraduation;
    String totalGrade;
    boolean status=false; //to allow admin to authorize Employees' accounts
    static int counter = 1;


    //For testing

    public Employee(String password, int id) {
        this.password = password;
        this.id = id;
    }

    Employee(String password, String firstName, String lastName, String address, String position, String graduatedCollage, int yearOfGraduation, String totalGrade) {
        this.id = counter;
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
                this.address = scanner.next();
                break;
            }
            else if (editInfoInput == 2) {
                this.position = scanner.next();
                break;
            }
            else{
                System.out.println("Wrong Input!, try Again");
            }
        }

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
        int clientID;
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
                System.out.println("Enter the ID and password of the client ");
                System.out.println("ID:");
                clientID = scanner.nextInt();

                System.out.println("Password:");
                clientPassword = scanner.next();
                if (clients2.get(clientIndex).ID==clientID && clients2.get(clientIndex).password.equals(clientPassword)) {
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


//    boolean EmployeeEditClient(ArrayList<Client> clients2, int ID) {
//        int clientIndex = -1;
//        boolean clientFounded = false;
//        for (int i = 0; i < clients2.size(); i++) {
//            if (clients2.get(i).ID == ID) {
//                clientFounded = true;
//                clientIndex = i;
//                break;
//            }
//        }
//        if (clientFounded) {
//            while (true) {
//                System.out.println("Press 1 to change Client's username\nPress 2 to change Client's password");  // ask him what to change
//                int editInfoInput = scanner.nextInt();
//                if (editInfoInput == 1) {
//                    System.out.println("Enter new Username:");
//                    clients2.get(clientIndex).username = scanner.nextLine();
//                    return true;
//                } else if (editInfoInput == 2) {
//                    clients2.get(clientIndex).password = scanner.nextLine();
//                    return true;
//                } else {
//                    System.out.println("Wrong Input!, try Again");
//                }
//            }
//        } else {
//            System.out.println("ID not found\nTry Again!");
//            return false;
//        }
//
//    }
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

            System.out.println("Please enter the id and password of the client account.");
            System.out.println("ID:");int id = in.nextInt();
            System.out.println("Password:");String pass = in.next();
            if (clientUPAuthentication(clients2 , id , pass) != null)
            {
                System.out.println("Press 1 to change Client's username\nPress 2 to change Client's password");  // ask him what to change
                int editInfoInput = scanner.nextInt();
                if (editInfoInput == 1) {
                    System.out.print("Enter new Username:");
                    clients2.get(clientIndex).username = scanner.next();
                    return true;
                } else if (editInfoInput == 2) {
                    System.out.print("Enter new password:");
                    clients2.get(clientIndex).password = scanner.next();
                    return true;
                } else {
                    System.out.println("Wrong Input!, try Again");
                }
            }
            else{
                System.out.println("Username or password are wrong please try again");
            }

        }
    } else {
        System.out.println("ID not found\nTry Again!");
        return false;
    }

}


    void EmployeeSearchForClient(ArrayList <Client> clients2 )
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
                        System.out.println(obj.toString());
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


     void EmployeeDeletingAccount(ArrayList <Client> clients2)
     {
         System.out.println("Please enter the ID and password of the Client account.");
         System.out.println("Enter 0 in the ID if you want to cancel");
         System.out.println("ID: ");int userID = in.nextInt();
         if (userID ==0 ){return;}
         System.out.println("Password: ");String pass = in.next();
         for (Client obj: clients2)
         {
             if (obj.ID==userID && obj.password.equals(pass))
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
                             return;
                         }
                     }
                     System.out.println("Account deleted successfully.");

                 } else if (ans == 0) {
                     return;
                 }


             }
             else
             {
                 System.out.println("\nNo client was found.\n");
                 break;
             }
         }

     }

    void EmployeeMakingTransaction(ArrayList <Client> clients , ArrayList<transaction>allTransaction)
    {
        boolean test3 = true;
        while (test3) {

            System.out.println("Please enter the id and password of the client account or 0 for the id to cancel.");
            System.out.println("ID:");int id = in.nextInt();
            if (id == 0) {
                break;
            }
            System.out.println("Password:");String pass = in.next();
            Client tempClient = clientUPAuthentication(clients, id , pass);
            if (tempClient != null)
            {
                test3 = false;
                boolean test = true;
                int accountNum = 0;

                while (test)
                {
                    int i = 1;

                    System.out.println("Choose one of your accounts:");


                    for (Account acc : tempClient.myAccounts)
                    {
                        System.out.println(i + "-Account no.= " + acc.accountNumber);
                        i++;
                    }

                    int n = scanner.nextInt();

                    if (n<=i && n>0) {
                        test = false;
                        accountNum = n;
                    }
                    else{
                        System.out.println("Please enter a number from the range.");
                    }
                }


                boolean test2 = true;
                while (test2) {
                    System.out.println("press 1 to Deposit");
                    System.out.println("press 2 to Withdraw");
                    System.out.println("press 3 to make a transaction");
                    System.out.println("press 0 to return");
                    System.out.print("\nChoice: ");
                    int accountOperation = scanner.nextInt();
                    if (accountOperation == 1) {
                        System.out.println("check");
                        tempClient.myAccounts.get(accountNum - 1).makeTransaction(1, allTransaction, clients);
                        test2 = false;
                    } else if (accountOperation == 2) {
                        tempClient.myAccounts.get(accountNum - 1).makeTransaction(2, allTransaction, clients);
                        test2 = false;

                    } else if (accountOperation == 3) {
                        tempClient.myAccounts.get(accountNum - 1).makeTransaction(3, allTransaction, clients);
                        test2 = false;

                    } else if (accountOperation == 0) {
                        return;
                    } else {
                        System.out.println("Wrong Input, Please try again!");


                    }
                }


            }
            else
            {
                System.out.println("ID or password is incorrect please try again.");
                test3 = true;
            }
        }


    }

    private Client clientUPAuthentication(ArrayList<Client>client , int id, String pass)
    {
        for (Client obj : client)
        {
            if (obj.password.equals(pass) && obj.ID == id) {
                return obj;
            }
        }
        return null;
    }

     //////////////////////////////////Files////////////////////////////////////////////////////////
     public String save(){
         return id+"\n"+password+"\n" +firstName+"\n"+lastName+
                 "\n"+address+"\n"+position+"\n"+graduatedCollage+"\n"+yearOfGraduation+"\n"+totalGrade+"\n"+status+"\n";

     }
    public static void saveEmp(ArrayList<Employee> emps){

        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("EMPLOYEES.txt"));
            for(Employee e:emps){
                if(e!=null){
                    writer.write(e.save());}
            }
            writer.close();
            System.out.println("written to files successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void readEmp(ArrayList<Employee> emps) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("EMPLOYEES.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String password = reader.readLine();
                int id = Integer.parseInt(reader.readLine());
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                String address = reader.readLine();
                String position = reader.readLine();
                String graduatedCollage = reader.readLine();
                int yearOfGraduation = Integer.parseInt(reader.readLine());
                String totalGrade = reader.readLine();
                boolean status = Boolean.parseBoolean(reader.readLine());

                emps.add(new Employee(password, id, firstName, lastName, address, position,
                        graduatedCollage, yearOfGraduation, totalGrade, status));

            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Employee(String password, int id, String firstName, String lastName, String address,
               String position, String graduatedCollage, int yearOfGraduation, String totalGrade,boolean status) {
        this.password = password;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.position = position;
        this.graduatedCollage = graduatedCollage;
        this.yearOfGraduation = yearOfGraduation;
        this.totalGrade = totalGrade;
        this.status=status;
    }
}
//    // This function is used to check if the username and password of the client are correct
//    Boolean UPcheckerForClient(String user, String pass, Client[] clients) {
//
//        for (int i = 0; i < clients.length; i++) {
//            if (clients[i].username.equals(user) && clients[i].password.equals(pass)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//    Boolean employeeUPChecker(Client[] clients) {
//        for (int i = 0; i < clients.length; i++) {
//            if (clients[i].username == this.username && clients[i].password == this.password) {
//                return true;
//            }
//
//        }
//
//        return false;
//    }

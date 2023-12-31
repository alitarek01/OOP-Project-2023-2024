package OOP_Project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author alit7
 */
public class Employee {

    Scanner scanner = new Scanner(System.in);

    int id;
    String password;
    String firstName;
    String lastName;
    String address;
    String position;
    String graduatedCollage;
    int yearOfGraduation;
    String totalGrade;
    boolean status=true; //to allow admin to authorize Employees' accounts
    static int counter = 1;


    //For testing

    public Employee(String password, int id) {
        this.password = password;
        this.id = id;
    }

    public Employee(String password, String firstName, String lastName, String address,
            String position, String graduatedCollage, int yearOfGraduation, String totalGrade,boolean status) {
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
        this.status=status;
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


    void createAClient(ArrayList<Client> clients2,ArrayList<transaction> allTransaction) {
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
        clients2.add(new Client(ID, firstName, lastName,username, password, telephoneNumber));
        EmployeeCreatingAccount(clients2,ID,allTransaction);

    }

    boolean EmployeeCreatingAccount(ArrayList<Client> clients2, int ID,ArrayList<transaction> allTransaction) {
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
                System.out.println("Enter password of the client ");

                System.out.println("Password:");
                clientPassword = scanner.next();
                if (clients2.get(clientIndex).ID==ID && clients2.get(clientIndex).password.equals(clientPassword)) {
                    System.out.println("Press 1 to Create saving account\nPress 2 to Create current account\nPress 0 to cancel:");
                    int inputAccountType;
                    inputAccountType = scanner.nextInt();
                    double initialbalance;
                    if (inputAccountType == 1) {
                    System.out.println("enter initial balance:");
                        initialbalance = scanner.nextDouble();
                        clients2.get(clientIndex).myAccounts.add(new SavingAccount(initialbalance));
                        System.out.println("account created succefully");
                        return true;

                    } else if (inputAccountType == 2) {
                        System.out.println("enter initial balance:");
                        initialbalance = scanner.nextDouble();
                        clients2.get(clientIndex).myAccounts.add(new CurrentAccount(initialbalance,allTransaction,this.id));
                        System.out.println("account created succefully");
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





private static final Scanner in = new Scanner(System.in);


public static void CreatingEmployeeAccount(ArrayList<Employee>employees)
{
    System.out.println("Please enter the following infornation.");
    System.out.println("First name:");String fName = in.next();
    System.out.println("Enter Last name:");String lName = in.next();
    System.out.println("Password:");String pass = in.next();
    System.out.println("Address:");String add = in.next();
    System.out.println("Position:");String pos = in.next();
    System.out.println("Graduated collage:");String col = in.next();
    System.out.println("Year of graduation:");int year = in.nextInt();
    System.out.println("Total grades:");String grades = in.next();

    
    employees.add(new Employee(pass ,fName , lName , add , pos ,col , year , grades , false));
    System.out.println("\n---------------------");
    System.out.println("Account created successfully but waiting for validation from the admin.");
    System.out.println("---------------------\n");

    
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

            System.out.println("Please enter the id and password of the client account.");
            System.out.println("ID:");int id = scanner.nextInt();
            System.out.println("Password:");String pass = scanner.next();
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
            int x = scanner.nextInt();
            if (x == 1) {
                System.out.println("Please enter the ID of the client:");
                int ID = scanner.nextInt();
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
                int n = scanner.nextInt();
                for (Client obj : clients2) {
                    for (Account acc : obj.myAccounts) {
                        if (acc.accountNumber == n) {
                            found = true;
                            System.out.println(obj.toString());
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
        System.out.println("ID: ");int userID = scanner.nextInt();
        if (userID ==0 ){return;}
        System.out.println("Password: ");String pass = scanner.next();
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
                int accNum = scanner.nextInt();

                System.out.println("Enter 1 to confirm deletion or 0 to cancel.");
                int ans = scanner.nextInt();
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


            }else
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
            System.out.println("ID:");int id = scanner.nextInt();
            if (id == 0) {
                break;
            }
            System.out.println("Password:");String pass = scanner.next();
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
                    System.out.println("press 3 to make a transfer");
                    System.out.println("press 0 to return");
                    System.out.print("\nChoice: ");
                    int accountOperation = scanner.nextInt();
                    if (accountOperation == 1) {
                        try{
                        tempClient.myAccounts.get(accountNum - 1).makeTransaction(1, allTransaction, clients);
                        }catch (TransactionException exp){
                            System.out.println(exp.getMessage());
                        }
                        test2 = false;
                    } else if (accountOperation == 2) {
                        try{
                            tempClient.myAccounts.get(accountNum - 1).makeTransaction(2, allTransaction, clients);
                        }catch (TransactionException exp){
                            System.out.println(exp.getMessage());
                        }
                        test2 = false;

                    } else if (accountOperation == 3) {
                        try{
                            tempClient.myAccounts.get(accountNum - 1).makeTransaction(3, allTransaction, clients);
                        }catch (TransactionException exp){
                            System.out.println(exp.getMessage());
                        }
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
        return password+"\n" +firstName+"\n"+lastName+
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void readEmp(ArrayList<Employee> emps) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("EMPLOYEES.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String password = line;
               // int id = Integer.parseInt(reader.readLine());
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                String address = reader.readLine();
                String position = reader.readLine();
                String graduatedCollage = reader.readLine();
                int yearOfGraduation = Integer.parseInt(reader.readLine());
                String totalGrade = reader.readLine();
                boolean status = Boolean.parseBoolean(reader.readLine());

                emps.add(new Employee(password, firstName, lastName, address, position,
                        graduatedCollage, yearOfGraduation, totalGrade, status));

            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        String status = this.status ? "Authorized" : "Not Authorized";

        return "Employee{" +
                "id=" + id + "\n" +
                ", password='" + password + "\n" +
                ", firstName='" + firstName + "\n" +
                ", lastName='" + lastName + "\n" +
                ", address='" + address + "\n" +
                ", position='" + position + "\n" +
                ", graduatedCollage='" + graduatedCollage + "\n" +
                ", yearOfGraduation=" + yearOfGraduation + "\n" +
                ", totalGrade='" + totalGrade + "\n" +
                ", status=" + status + "\n" +
                '}';
    }
}

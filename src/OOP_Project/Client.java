package OOP_Project;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    //Client: (ID, FirstName, LastName, Account number (must be unique),Username, Password, Telephone number,
    // State of the account (Active or closed), Type of the account, Balance)
    public int ID;
    String firstName;
    String lastName;
    String username;
    String password;
    long telephoneNumber;
    boolean stateOfTheAccount = true;
    public static int acc_num=0;
    public Account [] MyAccounts = new Account[4];
    public ArrayList<Account> myAccounts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


   // written by ali

    //Constructors
    public Client(int ID, String firstName, String lastName, String username, String password, long telephoneNumber) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.telephoneNumber = telephoneNumber;


    }

    //For testing
    public Client(int ID, String username, String password) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }
    //Methods

    //● Edit personal information.
    void EditPersonalInformation (){
        int choice;
        while(true) {
            System.out.println("=================================");
            System.out.println("Press 1 to change your First Name");
            System.out.println("Press 2 to change your Last Name");
            System.out.println("Press 3 to change your Telephone Number\n\nchoice:\n");
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter New First Name: ");
                setFirstName(scanner.next());
                break;
            } else if (choice == 2) {
                System.out.print("Enter New Last Name: ");
                setLastName(scanner.next());
                break;
            }
            else if (choice ==3){
                System.out.print("Enter New Telephone Number: ");
                setTelephoneNumber(scanner.nextLong());
                break;
            }
            else {
                System.out.println("wrong Input,Try Again!\n\n");
            }

        }
    }

    //● Display details of his account.
    public void DisplayDetailsofhisAccount (){
        System.out.println("=====================================");
        System.out.println("FirstName: "+getFirstName());
        System.out.println("LastName: "+getLastName());
        System.out.println("ID: "+getID());
        System.out.println("Username: "+getUsername());
        System.out.println("Password: "+getPassword());
        System.out.println("TelephoneNumber: "+getTelephoneNumber());
//        if(stateOfTheAccount){System.out.println("State of the account: Active");}
//        else {System.out.println("State of the account: Active");}
        System.out.println("=====================================");
    }


    //● Transfer money to another client's account.
    //● Show transaction history.

    //● Take a deposit from his account.
//    CurrentAccount [] C_accounts = new CurrentAccount[3];;
//    SavingAccount [] S_accounts = new SavingAccount[3];
//    void create_C_account(int balance){
//        //MyAccounts[acc_num] = new  CurrentAccount(balance,acc_num);
//
//        acc_num++;
//    }
//    void create_S_account(int balance){
//        MyAccounts[acc_num] = new SavingAccount(balance,acc_num);
//        acc_num++;
//    }

    //Getters

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
    return lastName;}

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public boolean isStateOfTheAccount() {
        return stateOfTheAccount;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setStateOfTheAccount(boolean stateOfTheAccount) {
        this.stateOfTheAccount = stateOfTheAccount;
    }

    ///////////////////////////////////////Files/////////////////////////////////////////////////////////
    public static void readClient(ArrayList<Client> clients){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CLIENTS.txt"));

            String temp;
            while ((temp= reader.readLine())!= null){
                int clientID = Integer.parseInt(temp);
                String firstName=reader.readLine();
                String lastName=reader.readLine();
                String username=reader.readLine();
                String password=reader.readLine();
                long telephoneNumber=Long.parseLong(reader.readLine());
                boolean stateOfTheAccount = Boolean.parseBoolean(reader.readLine());
                ArrayList<Account> clientAccounts=new ArrayList<>();
                temp= reader.readLine();
                while (temp!=null&&!(temp.equals("#"))) {
                    int accountNumber=Integer.parseInt(temp);
                    double balance=Double.parseDouble(reader.readLine());
                    String type=reader.readLine();
                    if (type.equals("saving")){
                        clientAccounts.add(new SavingAccount(accountNumber,balance));
                    }
                    else if (type.equals("current")) {
                        clientAccounts.add(new CurrentAccount(accountNumber,balance));
                    }
                     //int lastindex=accountNumber;

                    //setLastIndex(accountNumber);
                    if(Account.getCounter()<accountNumber)
                    Account.setCounter(accountNumber);


                }
                clients.add(new Client(clientID, firstName, lastName, username, password,
                        telephoneNumber, stateOfTheAccount, clientAccounts));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Client(int ID, String firstName, String lastName, String username, String password,
                long telephoneNumber, boolean stateOfTheAccount, ArrayList<Account> myAccounts) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.stateOfTheAccount = stateOfTheAccount;
        this.myAccounts = myAccounts;
    }

    public ArrayList<Account> getMyAccounts() {
        return myAccounts;
    }

    public static void SaveClient(ArrayList<Client> clients){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("CLIENTS.txt"));
            for (Client client : clients) {
                if (client != null) {
                    writer.write(client.ID + "\n");
                    writer.write(client.firstName + "\n");
                    writer.write(client.lastName + "\n");
                    writer.write(client.username + "\n");
                    writer.write(client.password + "\n");
                    writer.write(client.telephoneNumber + "\n");
                    writer.write(client.stateOfTheAccount + "\n");

                    ArrayList<Account> clientAccounts = client.getMyAccounts();
                    for (Account account : clientAccounts) {
                        writer.write(account.getAccountNumber() + "\n");
                        writer.write(account.getBalance() + "\n");
                        if (account instanceof SavingAccount) {
                            writer.write("saving\n");
                        } else if (account instanceof CurrentAccount) {
                            writer.write("current\n");
                        }


                    }

                    // Add a marker to indicate the end of the accounts for this client
                    writer.write("#\n");
                }
            }

            writer.close();
            System.out.println("Data saved to files successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return
                "\n\n________________________________________________________" +
                "\nID :" + ID +
                "\nUsername: " + username   +
                "\nFirstName: " + firstName +
                "\nLastName: '" + lastName  +
                "\nTelephoneNumber: " + telephoneNumber +
                "\nStateOfTheAccount: " + stateOfTheAccount +
                "\n\n________________________________________________________"
                ;
    }
}

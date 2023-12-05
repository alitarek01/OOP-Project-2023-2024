package OOP_Project;
import java.util.Scanner;

public class Client {
    //Client: (ID, FirstName, LastName, Account number (must be unique),Username, Password, Telephone number,
    // State of the account (Active or closed), Type of the account, Balance)
    int ID;
    String firstName;
    String lastName;
    String username;
    String password;
    long telephoneNumber;
    boolean stateOfTheAccount = true;
   public static int acc_num=0;
   public Account [] MyAccounts = new Account[4];
   Scanner scanner = new Scanner(System.in);
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
        System.out.println("enter 1 to change your Telephone Number: ");
        choice = scanner.nextInt();
        if (choice==1) {
            long newtelephonenum;
            newtelephonenum = scanner.nextLong();
            setTelephoneNumber(newtelephonenum);
            System.out.println("your new telephone num is:");
            System.out.println(getTelephoneNumber());
        }

    }

    //● Display details of his account.
    public void DisplayDetailsofhisAccount (){
        System.out.println(getFirstName());
        System.out.println(getLastName());
        System.out.println(getUsername());
        System.out.println(getPassword());
        System.out.println(getID());
        System.out.println(getTelephoneNumber());
        System.out.println(isStateOfTheAccount());
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
}

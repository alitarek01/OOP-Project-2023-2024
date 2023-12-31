package OOP_Project;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Client {
    public int ID;
    String firstName;
    String lastName;
    String username;
    String password;
    long telephoneNumber;
    boolean stateOfTheAccount = true;
    public static int acc_num=0;
    public ArrayList<Account> myAccounts = new ArrayList<>();
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

    //Methods

    //● Edit personal information.
    void EditPersonalInformation (){
        int choice;
        while(true) {
            System.out.println("=================================");
            System.out.println("Press 1 to change your First Name");
            System.out.println("Press 2 to change your Last Name");
            System.out.println("Press 3 to change your Telephone Number\nchoice:");
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

                while (!(temp= reader.readLine()).equals("#")) {
                    double balance=Double.parseDouble(temp);
//                    LocalDate myDateObj = LocalDate.now();  // Create a date object
//                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//                    String formattedDate = myDateObj.format(myFormatObj);
                    String dateString = reader.readLine();

                    // Parse the date string into a Date object
                    //LocalDate date = Account.parseDate(dateString);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(dateString, formatter);
                    String type=reader.readLine();
                    if (type.equals("Saving Account")){
                        clientAccounts.add(new SavingAccount(balance ,"Saving Account", date));
                    }
                    else if (type.equals("Current Account")) {
                        clientAccounts.add(new CurrentAccount(balance ,"Current Account", date));
                    }
//                    if(Boolean.parseBoolean(reader.readLine())){
//                        int loanDurationInMonths=Integer.parseInt(reader.readLine());
//                         double loanAmount=Double.parseDouble(reader.readLine());
//                         double clientBalance=Double.parseDouble(reader.readLine());
//                        ArrayList<Installment> installments=new ArrayList<>();
//                         while (!(reader.readLine().equals("@"))){
//                             int installmentNumber=Integer.parseInt(reader.readLine());
//                              boolean paid=Boolean.parseBoolean(reader.readLine());
//                              double installmentAmount=Double.parseDouble(reader.readLine());
//                             installments.add(new Installment(installmentNumber,paid,installmentAmount));
//                        }
//                    }

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
                   // ArrayList<Account> clientAccounts = client.getMyAccounts();
                    for (Account account : client.getMyAccounts()) {
                        //writer.write(account.getAccountNumber() + "\n");
                        writer.write(account.getBalance() + "\n");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                        // Format the current date to a string
                        String formattedDate = account.creationDate.format(formatter);
                        writer.write(formattedDate + "\n");
                        writer.write(account.getAccountType() + "\n");
//                        if(account.accountLoan!=null||account.accountLoan.loanStatus)
//                        {
//                            writer.write("true");
//                            writer.write(account.accountLoan.loanDurationInMonths);
//                            writer.write(String.valueOf(account.accountLoan.loanAmount));
//                            writer.write(String.valueOf(account.accountLoan.clientBalance));
//                            for (Installment installment: account.accountLoan.installments){
//                                writer.write(installment.installmentNumber);
//                                writer.write(String.valueOf(installment.paid));
//                                writer.write(String.valueOf(installment.installmentAmount));
//                            }
//                            writer.write("@");
//                        }
//                        else writer.write("false");
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
                "\nLastName: " + lastName  +
                "\nTelephoneNumber: 0" + telephoneNumber +
                "\nStateOfTheAccount: " + stateOfTheAccount +
                "\n\n________________________________________________________"
                ;
    }
}

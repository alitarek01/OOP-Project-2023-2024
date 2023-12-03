package OOP_Project;

public class Main {
    public static void main(String[] args) {

       // Client[] clients_arr = new Client[2];
        
//        clients_arr[0] = new Client();
//        clients_arr[1] = new Client();


        //give client some data
//        clients_arr[0].ID =2022170873;
//        clients_arr[0].username ="Mr.J";
//        clients_arr[1].ID =2022170825;
//        clients_arr[1].username ="Aly";


        //two account for client0
//        clients_arr[0].create_C_account(4000);
//        clients_arr[0].create_S_account(5000);

        //two account for client1
//        clients_arr[1].create_C_account(6000);
//        clients_arr[1].create_S_account(7000);

        //test for client1
//        System.out.println("Client 1:");
//        clients_arr[0].display_balance(0);
//        clients_arr[0].MyAccounts[0].add_balance(500);
//        clients_arr[0].MyAccounts[0].display_type();
//        clients_arr[0].display_balance(0);
//        clients_arr[0].MyAccounts[1].display_type();
//        clients_arr[0].display_balance(1);

        //test for client2
//        System.out.println("Client 2:");
//        clients_arr[1].display_balance(2);
//        clients_arr[1].MyAccounts[2].add_balance(750);
//        clients_arr[1].MyAccounts[2].display_type();
//        clients_arr[1].display_balance(2);
//        clients_arr[1].MyAccounts[3].display_type();
//        clients_arr[1].display_balance(3);


        //Admin
//        Admin Admin1 = new Admin();
//        Admin1.Display_Clients(clients_arr); //admin display clients

        //Employee
        //employee index is the employee num
        Client c1 = null;
        Employee employees_arr[] = new Employee[2];
        employees_arr[0] = new Employee();
        c1 = employees_arr[0].create_a_client(c1);
        c1 = employees_arr[0].createCurrentAccount(c1);
        c1.DisplayDetailsofhisAccount();
        c1.MyAccounts[0].display_balance();
        //c1.EditPersonalInformation();
        c1.MyAccounts[0].display_type();
        c1.MyAccounts[0].add_balance(500);
        //employees_arr[0].add_acc_to_client(clients_arr,2);
      //  clients_arr[2].display_balance(5);


    }
}
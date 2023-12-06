package OOP_Project;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client[] clients = new Client[4];

        //Done by ali
        ArrayList<Client> clientsss = new ArrayList<>();

        clients[0] = new Client(2022170873,"Youssef", "Mahmoud","joe","1230",1060113886);
        clients[1] = new Client(2022170873,"aly", "maklad","loe","1231",1060113886);
        clients[2] = new Client(2022170873,"ahmed", "attia","mido","1232",1060113886);
        clients[3] = new Client(2022170873,"omar", "amged","mego","1233",1060113886);

        while (true) {
            System.out.println("press 1 to sign in as a Client");
            System.out.println("press 2 to sign in as a Employee");
            System.out.println("press 3 to sign in as a Admin");
            int signas = scanner.nextInt();
            boolean signInStatus = false;
            while (true) {
                if (signas == 1) {
                    System.out.print("Enter Username:");
                    String Username = scanner.next();
                    System.out.print("Enter Password:");
                    String Password = scanner.next();
                    int clientindex=-1;
                    for (int i = 0; i < 4; i++) {
                        if (Username.equals(clients[i].username) && Password.equals(clients[i].password)) {
                            signInStatus = true;
                            clientindex = i;
                            break;
                        }
                    }
                    if (signInStatus) {
                        System.out.println("\nSigned in Successfully\n");
                        System.out.println("This is Operations that you can do on your account:");
                        System.out.println("1-Display Details of Your account");
                        clients[clientindex].DisplayDetailsofhisAccount();

                    } else {
                        System.out.println("Wrong Username or Password");
                        System.out.println("Please try again!");
                        continue;

                    }
                    if (signas == 2) {

                    }
                    if (signas == 3) {

                    }

                }
            }
        }
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
//        Client c1 = null;
//        Employee employees_arr[] = new Employee[2];
//        employees_arr[0] = new Employee("Hazem","12345",2022);
//        c1 = employees_arr[0].create_a_client(c1);
//        c1 = employees_arr[0].createCurrentAccount(c1);
//        c1.DisplayDetailsofhisAccount();
//        c1.MyAccounts[0].display_balance();
            //c1.EditPersonalInformation();
//        c1.MyAccounts[0].display_type();
//        c1.MyAccounts[0].add_balance(500);
            //employees_arr[0].add_acc_to_client(clients_arr,2);
            //  clients_arr[2].display_balance(5);



    }
}
package OOP_Project;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Client[] clients = new Client[4];
//        clients[0] = new Client(2022170873, "Youssef", "Mahmoud", "joe", "1230", 1060113886);
//        clients[1] = new Client(2022170873, "aly", "maklad", "loe", "1231", 1060113886);
//        clients[2] = new Client(2022170873, "ahmed", "attia", "mido", "1232", 1060113886);
//        clients[3] = new Client(2022170873, "omar", "amged", "mego", "1233", 1060113886);

        ArrayList<Client> clients2 = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList <transaction> allTransaction = new ArrayList<>();




        clients2.add(new Client(2022170873, "Youssef", "Mahmoud", "j", "1", 1060113886));
        clients2.add(new Client(2022170825, "aly", "maklad", "loe", "1231", 1060113886));
        clients2.add(new Client(2022170850, "ahmed", "attia", "a", "2", 1060113886));
        clients2.add(new Client(2022170829, "omar", "amged", "mego", "1233", 1060113886));

        employees.add(new Employee( "dude", 100));
        employees.get(0).EmployeeCreatingAccount(clients2,2022170873);
        employees.get(0).EmployeeCreatingAccount(clients2,2022170850);
        //employees.get(0).EmployeeCreatingAccount(clients2, 2022170873);
        //employees.get(0).EmployeeCreatingAccount(clients2, 2022170873);
        //  employees.get(0).EmployeeCreatingAccount(clients2,2022170873);
        while (true) {
            System.out.println("press 1 to sign in as a Client");
            System.out.println("press 2 to sign in as a Employee");
            System.out.println("press 3 to sign in as a Admin");
            int signAs = scanner.nextInt();
            boolean signInStatus = false;
            boolean signInLoop = true;
            while (signInLoop) {
                if (signAs == 1) {
                    System.out.println("Sign in as a Client\n===================");
                    System.out.print("Enter Client ID:");
                    int clientID = scanner.nextInt();
                    System.out.print("Enter Password:");
                    String Password = scanner.next();
                    int clientindex = -1;
                    for (int i = 0; i < clients2.size(); i++) {
                        if (clientID == clients2.get(i).ID && Password.equals(clients2.get(i).password)) {
                            signInStatus = true;
                            clientindex = i;
                            break;
                        }
                    }
                    if (signInStatus) {
                        System.out.println("\nSigned in Successfully\n");
                        boolean clientOperationLoop =true;
                        while(clientOperationLoop) {
                            System.out.println("This is Operations that you can do on your account:");

                            System.out.println("1-Display Details of Your account");
                            System.out.println("2-Edit personal information");
                            System.out.println("3-Enter Account");
                            System.out.println("4-Sign out");
                            System.out.print("\nChoice: ");
                            int clientOperationChoice = scanner.nextInt();
                            if (clientOperationChoice == 1) {
                                clients2.get(clientindex).DisplayDetailsofhisAccount();
                            } else if (clientOperationChoice == 2) {
                                clients2.get(clientindex).EditPersonalInformation();
                            } else if (clientOperationChoice == 3) {
                                System.out.println("\n\nYour Accounts:");
                                for (int j = 0; j < clients2.get(clientindex).myAccounts.size(); j++) {
                                    System.out.println("=========================");
                                    System.out.println("Account " + (j + 1) + ":");
                                    clients2.get(clientindex).myAccounts.get(j).DisplayInfo();
                                }
                                System.out.println("=========================");
                                System.out.print("Choose Account (1,2,3,4): ");
                                int chooseAccount = scanner.nextInt();
                                if (chooseAccount == 1 || chooseAccount == 2 || chooseAccount == 3 || chooseAccount == 4) {
                                    while(true) {
                                        int currentAccNum = clients2.get(clientindex).myAccounts.get(chooseAccount - 1).accountNumber;
                                        System.out.println("----------------------------");
                                        System.out.println("Account " + chooseAccount + " info:");
                                        clients2.get(clientindex).myAccounts.get(chooseAccount - 1).DisplayInfo();
                                        System.out.println("----------------------------\n\n");
                                        System.out.println("press 1 to Deposit");
                                        System.out.println("press 2 to Withdraw");
                                        System.out.println("press 3 to make a transfer");
                                        System.out.println("press 4 to show transaction history");
                                        System.out.println("press 5 to return to client operations");
                                        System.out.print("\nChoice: ");
                                        int accountOperation = scanner.nextInt();
                                        if (accountOperation == 1) {
                                            try {
                                                clients2.get(clientindex).myAccounts.get(chooseAccount - 1).makeTransaction(1, allTransaction, clients2);
                                            }catch (TransactionException exp){
                                                System.out.println(exp.getMessage());
                                            }
                                        } else if (accountOperation == 2) {
                                            try {
                                                clients2.get(clientindex).myAccounts.get(chooseAccount - 1).makeTransaction(2, allTransaction, clients2);
                                            }catch (TransactionException exp){
                                                System.out.println(exp.getMessage());
                                            }
                                        } else if (accountOperation == 3) {
                                            try {
                                                clients2.get(clientindex).myAccounts.get(chooseAccount - 1).makeTransaction(3, allTransaction, clients2);
                                            }catch (TransactionException exp){
                                                System.out.println(exp.getMessage());
                                            }
                                        } else if (accountOperation == 4) {
                                            for (int m = 0; m < allTransaction.size(); m++) {
                                                if (allTransaction.get(m).getCustomerId() == currentAccNum || allTransaction.get(m).getRecipientId() == currentAccNum) {
                                                    System.out.println(allTransaction.get(m).toString());
                                                }
                                            }
                                        } else if (accountOperation == 5) {
                                            break;
                                        } else {
                                            System.out.println("Wrong Input, Please try again!");
                                            System.out.print("\nChoice: ");
                                            accountOperation = scanner.nextInt();

                                        }
                                    }

                                }


                            } else if (clientOperationChoice == 4) {
                                signInLoop=false;
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("\n\n\n------------------------------");
                        System.out.println("Wrong Username or Password");
                        System.out.println("Please try again!");
                        System.out.println("------------------------------\n\n\n");
                        continue;
                    }
                }

                else if (signAs == 2) {
                    System.out.print("Enter ID:");
                    int employeeID = scanner.nextInt();
                    System.out.print("Enter Password:");
                    String Password = scanner.next();
                    int empindex = -1;
                    for (int i = 0; i < employees.size(); i++) {
                        if (employeeID == employees.get(i).id && Password.equals(employees.get(i).password)) {
                            signInStatus = true;
                            empindex = i;
                            break;
                        }
                    }
                    if (signInStatus) {
                        System.out.println("\nSigned in Successfully\n");
                        while(true) {
                            System.out.println("This is Operations that you can do on your account:");
                            System.out.println("1-Edit his personal information");
                            System.out.println("2-Create a client account");
                            System.out.println("3-Create an account for a client");
                            System.out.println("4-Edit a client account");
                            System.out.println("5-Search for client by (Name or account number)");
                            System.out.println("6-Delete client account");
                            System.out.println("7-Make Transaction");
                            System.out.println("8-Sign out");

                            System.out.println("Choice: ");
                            int empOperationsChoice = scanner.nextInt();
                            if (empOperationsChoice == 1) {
                                employees.get(empindex).EmployeeEditInfo();
                            } else if (empOperationsChoice == 2) {
                                employees.get(empindex).createAClient(clients2);
                            } else if (empOperationsChoice == 3) {
                                while (true) {
                                    System.out.println("Enter Client ID: ");
                                    if (employees.get(empindex).EmployeeCreatingAccount(clients2, scanner.nextInt())) {
                                        break;
                                    }

                                }
                            } else if (empOperationsChoice == 4) {
                                while (true) {
                                    System.out.println("Enter Client ID: ");
                                    if (employees.get(empindex).EmployeeEditClient(clients2, scanner.nextInt())) {
                                        break;
                                    }

                                }
                            } else if (empOperationsChoice == 5) {employees.get(empindex).EmployeeSearchForClient(clients2);
                            } else if (empOperationsChoice == 6) {employees.get(empindex).EmployeeDeletingAccount(clients2);
                            }else if (empOperationsChoice==7){employees.get(empindex).EmployeeMakingTransaction(clients2,allTransaction);
                            } else if (empOperationsChoice == 8) {signInLoop=false;
                                break;
                            } else {
                                System.out.println("Please try again!");
                            }
//                        }
                        }
                    }
                    else {
                        System.out.println("Wrong Username or Password");
                        System.out.println("Please try again!");
                        continue;

                    }
                }
                else if (signAs == 3) {

                }

                else{break;}



            }


        }
    }
}
                            //h7tago wna b3ed al create account ll client

//                        System.out.println("Do you want to Create another account?");
//                        System.out.println("1:Yes\n2:NO");
//                        if (scanner.nextInt() == 1) {
//                            continue;
//                        } else if (scanner.nextInt() == 2) {
//                            break;
//                        } else {
//                            System.out.println("wrong Input,Try Again!");
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
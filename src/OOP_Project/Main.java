package OOP_Project;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Admin admin =new Admin();
            ArrayList<Client> clients2 = new ArrayList<>();
            ArrayList<Employee> employees = new ArrayList<>();
            ArrayList <transaction> allTransaction = new ArrayList<>();




            while (true) {
                Client.readClient(clients2);
                Employee.readEmp(employees);
                transaction.ReadTransactions(allTransaction);
                System.out.println("press 1 to sign in as a Client");
                System.out.println("press 2 to sign in/up as a Employee");
                System.out.println("press 3 to sign in as a Admin");
                System.out.println("press 4 to save Changes");
                System.out.print("\nChoice: ");
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
                                    System.out.print("Choose Account: ");
                                    int chooseAccount = scanner.nextInt();
                                    if (chooseAccount <=clients2.get(clientindex).myAccounts.size() &&chooseAccount>0) {
                                        while(true) {
                                            int currentAccNum = clients2.get(clientindex).myAccounts.get(chooseAccount - 1).accountNumber;
                                            System.out.println("----------------------------");
                                            System.out.println("Account " + chooseAccount + " info:");
                                            clients2.get(clientindex).myAccounts.get(chooseAccount - 1).DisplayInfo();
                                            System.out.println("----------------------------\n\n");
                                            System.out.println("press 1 to Deposit");
                                            System.out.println("press 2 to Withdraw");
                                            System.out.println("press 3 to make a transfer");
                                            System.out.println("press 4 to take a Loan");
                                            System.out.println("press 5 to pay an Installment");
                                            System.out.println("press 6 to show Loan History");
                                            System.out.println("press 7 to show transaction history");
                                            System.out.println("press 8 to return to client operations");
                                            if (clients2.get(clientindex).myAccounts.get(chooseAccount - 1).accountType.equals("Saving Account")) {
                                                System.out.println("press 9 to show account interest");
                                            }
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
                                            }else if (accountOperation==4) {clients2.get(clientindex).myAccounts.get(chooseAccount - 1).takeLoan();}
                                            else if (accountOperation==5) {clients2.get(clientindex).myAccounts.get(chooseAccount - 1).payInstallment(allTransaction);}
                                            else if (accountOperation==6) {
                                                if (clients2.get(clientindex).myAccounts.get(chooseAccount - 1).accountLoan != null) {
                                                    clients2.get(clientindex).myAccounts.get(chooseAccount - 1).accountLoan.display_loan_history();
                                                }
                                                else{
                                                    System.out.println("There is no loan");
                                                    continue;}
                                            }
                                            else if (accountOperation == 7) {
                                                for (int m = 0; m < allTransaction.size(); m++) {
                                                    if (allTransaction.get(m).getCustomerId() == currentAccNum || allTransaction.get(m).getRecipientId() == currentAccNum) {
                                                        System.out.println(allTransaction.get(m).toString());
                                                    }
                                                }
                                            } else if (accountOperation == 8) {
                                                break;
                                            }
                                            else if(accountOperation == 9){
                                                LocalDate myDateObj = LocalDate.now();  // Create a date object
                                                clients2.get(clientindex).myAccounts.get(chooseAccount - 1).CalculateInterest(myDateObj);

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

                        boolean empTest = true;
                        while (empTest) {
                            System.out.println("Enter 1 to sign in , 2 to sign up , or 0 to return to the main page.");
                            System.out.println("Ans:");
                            int ans = scanner.nextInt();
                            if (ans == 1) {

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
                                if (signInStatus && !employees.get(empindex).status) {
                                    System.out.println("Employee is not Authorized");
                                    break;
                                }
                                if (signInStatus) {
                                    System.out.println("\nSigned in Successfully\n");
                                    while (true) {
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
                                            employees.get(empindex).createAClient(clients2, allTransaction);
                                        } else if (empOperationsChoice == 3) {
                                            while (true) {
                                                System.out.println("Enter Client ID: ");
                                                if (employees.get(empindex).EmployeeCreatingAccount(clients2, scanner.nextInt(), allTransaction)) {
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
                                        } else if (empOperationsChoice == 5) {
                                            employees.get(empindex).EmployeeSearchForClient(clients2);
                                        } else if (empOperationsChoice == 6) {
                                            employees.get(empindex).EmployeeDeletingAccount(clients2);
                                        } else if (empOperationsChoice == 7) {
                                            employees.get(empindex).EmployeeMakingTransaction(clients2, allTransaction);
                                        } else if (empOperationsChoice == 8) {
                                            signInLoop = false;
                                            break;
                                        } else {
                                            System.out.println("Please try again!");
                                        }
//                        }
                                    }
                                } else {
                                    System.out.println("Wrong ID or Password");
                                    System.out.println("Please try again!");
                                    continue;

                                }
                            } else if (ans == 2) {
                                Employee.CreatingEmployeeAccount(employees);
                                empTest = false;
                            } else if (ans == 0) {
                                empTest = false;
                                signInLoop = false;

                            } else {
                                System.out.println("Please enter a valid number.");
                            }
                        }


                    }
                    else if (signAs == 3) {
                        System.out.println("\nSign in as a Admin\n===================");
                        System.out.print("Enter Username:");
                        String Username = scanner.next();
                        System.out.print("Enter Password:");
                        String Password = scanner.next();

                        if (Username.equals(admin.username)&&Password.equals(admin.password)){
                            while(true) {
                                System.out.println("\nSigned in Successfully\n---------------------");
                                System.out.println("This is Operations that you can do as an Admin:");
                                System.out.println("press 1 to Authorize the new employees’ accounts");
                                System.out.println("press 2 to Display all the employees.");
                                System.out.println("press 3 to Display all the clients.");
                                System.out.println("press 4 to Show all transactions done by (date/ client/ employee)");
                                System.out.println("press 5 to Sign out");
                                System.out.print("\nChoice: ");
                                int adminOperation = scanner.nextInt();
                                if (adminOperation == 1) {
                                    admin.authorizeEmployee(employees);
                                }
                                if (adminOperation == 2) {
                                    admin.DisplayEmployees(employees);
                                }
                                if (adminOperation == 3) {
                                    admin.DisplayClients(clients2);
                                }
                                if (adminOperation == 4) {
                                    admin.showTransactions(employees, clients2, allTransaction);
                                }
                                if (adminOperation == 5) {
                                    signInLoop=false;
                                    break;
                                }
                            }
                        }
                        else {
                            System.out.println("\nWrong Username or Password");
                            System.out.println("Please try again!\n\n");
                            continue;

                        }

                    }
                    else if (signAs == 4){
                        Client.SaveClient(clients2);
                        Employee.saveEmp(employees);
                        transaction.saveTransactions(allTransaction);

                        break;
                    }

                    else{break;}




                }



            }
        }
    }
}

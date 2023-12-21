//package OOP_Project;
//
//import java.util.ArrayList;
//
//public class Admin {
//    private String username;
//    private String password;
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    Boolean AdminLogIn(String username, String password){
//        return (this.username.equals(username)) && (this.password.equals(password));
//    }
//    void DisplayEmployees(ArrayList<Employee> employees){ //takes the employees array
//        for (Employee employee:employees) {
//           System.out.println(employee);      //needs toString method overriding
//        }
//    }
//    void DisplayClients(ArrayList <Client> clients){ //takes array of clients
//        for(Client client:clients){
//            System.out.println(client);    //needs toString method overriding
//        }
//
//    }
//
//    void ApproveEmployee(ArrayList <Employee> employees,int targetId,boolean targetStatus){
//        for (Employee employee : employees) {
//            if (employee.id == targetId) {
//                employee.status=targetStatus; // Update the salary of the target employee
//                break;
//            }
//        }
//    }
//    void DisplayTransactions(ArrayList <transaction> allTransactions) //takes the array of Transactions
//    {
//        for (transaction transaction:allTransactions){
//            System.out.println(allTransactions);             //needs toString method overriding
//        }
//
//    }
//    method to Authorize the new employees’ accounts.
//}

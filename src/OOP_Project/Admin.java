//package OOP_Project;
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
//    void DisplayEmployees(Emp[] Employees){ //takes the employees array
//        for (Emp employee:Employees) {
//           System.out.println(employee);      //needs toString method overriding
//        }
//    }
//    void DisplayClients(Client[] clients){ //takes array of clients
//        for(Client client:clients){
//            System.out.println(client);    //needs toString method overriding
//        }
//
//    }
//
//    void ApproveEmployee(Emp[] emps,int targetId,boolean targetStatus){
//        for (Emp employee : emps) {
//            if (employee.id == targetId) {
//                employee.status=targetStatus; // Update the salary of the target employee
//                break;
//            }
//        }
//    }
////    void DisplayTransactions(Transaction[] transactions) //takes the array of Transactions
////    {
////        for (Transaction transaction:transactions){
////            System.out.println(Transaction);             //needs toString method overriding
////        }
////
////    }
////    method to Authorize the new employees’ accounts.
//}

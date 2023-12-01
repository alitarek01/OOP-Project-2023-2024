/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alit7
 */
public class Employee {
    
    String username;
    String password;
    int id;
    String firtName;
    String lastName;
    String address;
    String position;
    String graduatedCollage;
    int yearOfGraduation;
    String totalGrade;
    static int counter = 1;
    
    Employee(String username , String password , String firtName, String lastName ,String address , String position  , String graduatedCollage , int yearOfGraduation ,  String totalGrade)
    {
        this.id = counter;
        this.username = username;
        this.password = password;
        this.firtName = firtName;
        this.lastName = lastName;
        this.address = address;
        this.position = position;
        this.graduatedCollage = graduatedCollage;
        this.yearOfGraduation = yearOfGraduation;
        this.totalGrade = totalGrade;
        counter++;
 
    }
    
    
    void EmployeeEditInfo(Employee [] employee , String address , String position)
    {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].id == this.id) {
                this.address = address;
                this.position = position;
            }
        }
    }
    
//    void EmployeeCreatingAccount(Client [] clients , Account newAccount)
//    {
//        
//        for (int i = 0; i < clients.length; i++) 
//        {
//            if (clients[i].id == this.id)
//            {
//                this.accounts[] = addToArray(clients, newAccount)
//            }
//   
//        }
//        
//    }
    
    Boolean employeeUPChecker(Client [] clients)
    {
        for (int i = 0; i < clients.length; i++) 
        {
            if (clients[i].username == this.username && clients[i].password == this.password) 
            {
             return True;   
            }
   
        }
        
        return False;
    }
    
    
    
    
     Account[] addAccountToClient(Client [] clients,  Account newAccount) {
        
        Boolean availble = this.employeeUPChecker(clients);
        
         if (availble) 
         {
            int length = clients.length;

        // Create a new array with increased size
            Client[] newArray = new Client[length + 1];

        // Copy the elements from the original array to the new array
             System.arraycopy(clients, 0, newArray, 0, length);

        // Add the new item to the last index
             newArray[length] = newAccount;

              return newArray;   
         }

         
         /*
         
         Raise an exception here if the username and password were not found
         
         
         */
         
     }
    
     static Employee[] addToArray(Employee[] array, Employee newItem) {
        int length = array.length;

        // Create a new array with increased size
        Employee[] newArray = new Employee[length + 1];

        // Copy the elements from the original array to the new array
        System.arraycopy(array, 0, newArray, 0, length);

        // Add the new item to the last index
        newArray[length] = newItem;

        return newArray;
    }
     
     static EmployeeSearchForClient(Client [] clients , int id)
     {
         for(Client client : clients)
         {
             if (client.id == id) 
             {
                 // Display all data of the client
             }
         }
     }
    
}

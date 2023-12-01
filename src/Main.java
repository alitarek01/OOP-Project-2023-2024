
public class Main extends javax.swing.JFrame {

    
    public Main() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main(String args[]) {
       
        
        int numEmployee = 3;
        Employee [] employee = new Employee[numEmployee];
        employee[0] = new Employee("Ali" , "Tarek" , "nas city" , "leader" , "cs" , 2023 , "Excellent");
        employee[1] = new Employee("lol" , "Tarek" , "masr el gdeda" , "manager" , "cs" , 2023 , "Excellent");
        employee[2] = new Employee("ana lol" , "Tarek" , "masr el gdeda" , "manager" , "cs" , 2023 , "Excellent");

        employee[0].EmployeeEditInfo(employee, "tgamo3", "CEO");

        Employee emp = new Employee("Ali" , "Tarek" , "nas city" , "leader" , "cs" , 2023 , "Excellent");
        
        employee =  Employee.addToArray(employee, emp);
        
        for (int i = 0; i < employee.length; i++) {
            
        
            System.out.println(employee[i].id);
            System.out.println(employee[i].firtName);
            System.out.println(employee[i].lastName);
            System.out.println(employee[i].address);
            System.out.println(employee[i].position);
            System.out.println(employee[i].graduatedCollage);
            System.out.println(employee[i].yearOfGraduation);
            System.out.println(employee[i].totalGrade);
            System.out.println("___________________________________________");

        }
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

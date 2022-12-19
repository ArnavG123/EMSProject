/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author arnav
 */
public class OverviewFrame extends javax.swing.JFrame {
    MyHashTable theHT;
    
    /**
     * Creates new form OverviewFrame
     */
    public OverviewFrame() {
        initComponents();
    }
    
    public void setHashTable(MyHashTable theRefValue){
        theHT = theRefValue;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        empNumLabel = new javax.swing.JLabel();
        empPayLabel = new javax.swing.JLabel();
        empHoursLabel = new javax.swing.JLabel();
        fteNumLabel = new javax.swing.JLabel();
        pteNumLabel = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Company Overview");

        empNumLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empNumLabel.setText("Number of Employees:");

        empPayLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empPayLabel.setText("Total Employee Pay:");

        empHoursLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empHoursLabel.setText("Total Hours Per Year:");

        fteNumLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fteNumLabel.setText("Number of FTEs:");

        pteNumLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pteNumLabel.setText("Number of PTEs:");

        updateButton.setText("Update Data");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Note that FTEs are estimate to work 2087 hours a year");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(empNumLabel)
                                .addComponent(empPayLabel)
                                .addComponent(empHoursLabel)
                                .addComponent(fteNumLabel)
                                .addComponent(pteNumLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(178, 178, 178)
                            .addComponent(titleLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(updateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(empNumLabel)
                .addGap(18, 18, 18)
                .addComponent(empPayLabel)
                .addGap(18, 18, 18)
                .addComponent(empHoursLabel)
                .addGap(18, 18, 18)
                .addComponent(fteNumLabel)
                .addGap(18, 18, 18)
                .addComponent(pteNumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int totalEmpHours = 0;
        int numberOfEmps = 0;
        double totalEmpPay = 0;
        int fteNum = 0;
        int pteNum = 0;
        
        for (int i = 0; i < theHT.buckets.length; i++) {
            if (!theHT.buckets[i].isEmpty()) {
                for (int j = 0; j < theHT.buckets[i].size(); j++) {
                    if (theHT.buckets[i].get(j) instanceof FTE targetFTE){
                        totalEmpHours += 2087;
                        totalEmpPay += targetFTE.getSalary();
                        fteNum++;
                    } else if (theHT.buckets[i].get(j) instanceof PTE targetPTE){
                        totalEmpHours += targetPTE.getHoursPerWeek()*targetPTE.getWeeksPerYear();
                        totalEmpPay += targetPTE.getHourlyWage()*targetPTE.getHoursPerWeek()*targetPTE.getWeeksPerYear();
                        pteNum++;
                    }
                    numberOfEmps++;
                }
            }
        }
        
        empHoursLabel.setText("Total Hours Per Year: " + totalEmpHours);
        empNumLabel.setText("Number of Employees: " + numberOfEmps);
        empPayLabel.setText("Total Employee Pay: " + totalEmpPay);
        fteNumLabel.setText("Number of FTEs: " + fteNum);
        pteNumLabel.setText("Number of PTEs: " + pteNum);
    }//GEN-LAST:event_updateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OverviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OverviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OverviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OverviewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OverviewFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel empHoursLabel;
    private javax.swing.JLabel empNumLabel;
    private javax.swing.JLabel empPayLabel;
    private javax.swing.JLabel fteNumLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel pteNumLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}

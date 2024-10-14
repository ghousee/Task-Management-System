/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import Model.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NATE
 */
public class AdminPage extends javax.swing.JPanel {
    private DefaultTableModel tableModel;
    private JTable taskTable;
    private TaskManager taskManager;
    /**
     * Creates new form AdminPage
     */
    public AdminPage(TaskManager taskManager) {
        this.taskManager = taskManager;
        initComponents();
        tableModel = new DefaultTableModel(new Object[]{"Name","Description","Priority","Deadline","Status"},0 );
        taskTable = new JTable(tableModel);
        jScrollPane1.setViewportView(taskTable);
        displayAllTasks();
    }
    
    public void displayAllTasks(){
        tableModel.setRowCount(0);
        List<Task> tasks = taskManager.getTasks();
        for(Task task : tasks){
            Object[] row = {task.getName(), task.getDescription(), task.getPriority(), task.getDeadline(), task.getStatus(), task.getAssignedUser()};
            tableModel.addRow(row);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLoginPage = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdetails = new javax.swing.JTextArea();
        cmbTasks = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(247, 245, 195));
        setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ALL TASKS");

        btnLoginPage.setText("LOGIN");
        btnLoginPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginPageActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("ADMIN PANEL");

        txtdetails.setColumns(20);
        txtdetails.setRows(5);
        jScrollPane1.setViewportView(txtdetails);

        cmbTasks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "View All", "Create", "Edit", "Delete" }));
        cmbTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTasksActionPerformed(evt);
            }
        });

        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                        .addComponent(btnEdit)
                        .addGap(76, 76, 76)
                        .addComponent(btnDelete)
                        .addGap(81, 81, 81)
                        .addComponent(btnLoginPage)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                        .addComponent(cmbTasks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(adminPanelLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel1)
                    .addContainerGap(530, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addGap(152, 152, 152)))
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(cmbTasks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoginPage)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(adminPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addGap(33, 33, 33)
                    .addComponent(jLabel1)
                    .addContainerGap(453, Short.MAX_VALUE)))
        );

        add(adminPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginPageActionPerformed
        // TODO add your handling code here:
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
        
        CardLayout cl = mainFrame.getCardLayout();
        JPanel mainPanel = mainFrame.getMainPanel();
        cl.show(mainPanel,"LoginPanel");
    }//GEN-LAST:event_btnLoginPageActionPerformed

    private void cmbTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTasksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTasksActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = taskTable.getSelectedRow();
        if(selectedRow >= 0){
            String taskName = tableModel.getValueAt(selectedRow,0).toString();
            String taskDescription = tableModel.getValueAt(selectedRow,1).toString();
            String taskPriority = tableModel.getValueAt(selectedRow,2).toString();
            String newTaskName = JOptionPane.showInputDialog("Enter a new name:",taskName);
            
            if(newTaskName != null){
                taskManager.editTask(taskName, newTaskName, taskDescription, taskPriority);
                displayAllTasks();
            }
                    
        } else {
            JOptionPane.showMessageDialog(this,"Selecr a task to edit");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = taskTable.getSelectedRow();
        
        if(selectedRow >= 0){
            String taskName = tableModel.getValueAt(selectedRow, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(this,"Are you sure you want to delete this task?");
            if(confirm == JOptionPane.YES_OPTION){
                taskManager.deleteTask(taskName);
                displayAllTasks();
            }
        } else {
            JOptionPane.showMessageDialog(this,"Select Task to delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPanel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLoginPage;
    private javax.swing.JComboBox<String> cmbTasks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtdetails;
    // End of variables declaration//GEN-END:variables

    public void displayAllTasks(List<Task> tasks) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

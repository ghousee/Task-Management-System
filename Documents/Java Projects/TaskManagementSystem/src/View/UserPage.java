/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import Model.*;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import View.MainFrame;


/**
 *
 * @author NATE
 */
public class UserPage extends javax.swing.JPanel {
    private String loggedInUsername;
    private TaskManager taskManager;
    private JList<String> taskList;
    private DefaultListModel<String> taskListModel;
    private DefaultTableModel tableModel;
    private JTable taskTable;

    /**
    * Creates new form UserPage
     */ 
    public UserPage(TaskManager taskManager, String username) {
        this.taskManager = taskManager;
        this.loggedInUsername = username;
        System.out.println("UserPage(Constructor)Username assigned in UserPage: " + loggedInUsername);
        initComponents();
        tableModel = new DefaultTableModel(new Object[]{"id","Name", "Description", "Priority", "Deadline", "Status", "Assigned User"}, 0);
        taskTable = new JTable(tableModel);
        jScrollPane1.setViewportView(taskTable);
        
        lblName.setText("Logged in as: " + loggedInUsername);
        refreshTasks();
    }
    
    public void displayTasks(List<Task> tasks){
        
        System.out.println("UserPage(displayTasks)Displaying tasks for user: " + loggedInUsername);
        tableModel.setRowCount(0);
        
        for(Task task : tasks){
            Object[] row = {task.getId(),task.getName(), task.getDescription(), task.getPriority(), task.getDeadline(), task.getStatus(), task.getAssignedUser()};
            System.out.println("UserPage(displayTasks)Assigned user is: " + task.getAssignedUser());
            tableModel.addRow(row);
        }
        if(tasks.isEmpty()){
            System.out.println("No tasks found for user: " + loggedInUsername);
        }
    }
    
    public void refreshTasks(){
        List<Task> userTasks = taskManager.getTasksForUser(loggedInUsername);
        displayTasks(userTasks);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetails = new javax.swing.JTextArea();
        btnLoginPage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAddTask = new javax.swing.JButton();
        btnEditTask = new javax.swing.JButton();
        btnDeleteTask = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(206, 206, 239));

        txtDetails.setColumns(20);
        txtDetails.setRows(5);
        jScrollPane1.setViewportView(txtDetails);

        btnLoginPage.setText("HOME");
        btnLoginPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginPageActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("TASKS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("USER PANEL");

        btnAddTask.setText("Add");
        btnAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTaskActionPerformed(evt);
            }
        });

        btnEditTask.setText("Edit");
        btnEditTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTaskActionPerformed(evt);
            }
        });

        btnDeleteTask.setText("Delete");
        btnDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTaskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(70, 70, 70)
                        .addComponent(btnAddTask)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditTask)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteTask))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(80, 80, 80)
                        .addComponent(btnLoginPage)))
                .addGap(76, 76, 76))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLoginPage)
                        .addComponent(jLabel2)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAddTask)
                    .addComponent(btnDeleteTask)
                    .addComponent(btnEditTask))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTaskActionPerformed
        // TODO add your handling code here:
        
        String taskName = JOptionPane.showInputDialog("Enter task:");
        String taskDescription = JOptionPane.showInputDialog("Enter task description:");
        String taskPriority = JOptionPane.showInputDialog("Enter task priority(Low,Medium,High):");
        Date taskDeadline = new Date();
        String taskStatus = "Pending";
        System.out.println("UserPage(AddBTN)Adding task for user in ADD Task USERPAGE: "+loggedInUsername);

        
        taskManager.addTask(taskName, taskDescription, taskPriority, taskDeadline, taskStatus, loggedInUsername);
        List<Task> updatedTasks = taskManager.getTasksForUser(loggedInUsername);
        displayTasks(updatedTasks);
        displayTasks(taskManager.getTasksForUser(loggedInUsername));
    }//GEN-LAST:event_btnAddTaskActionPerformed

    private void btnEditTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTaskActionPerformed
        // TODO add your handling code here:
        int selectedRow = taskTable.getSelectedRow();
        if (selectedRow >= 0) {
            int taskId = (int)tableModel.getValueAt(selectedRow, 0);
            System.out.println("Attempting to edit task: " + taskId);

            Task task = taskManager.getTaskById(taskId);
            if (task != null) {
                task.setName(JOptionPane.showInputDialog("Edit task name:", task.getName()));
                task.setDescription(JOptionPane.showInputDialog("Edit task description:", task.getDescription()));
                task.setPriority(JOptionPane.showInputDialog("Edit task priority:", task.getPriority()));

                List<Task> userTasks = taskManager.getTasksForUser(loggedInUsername);
                displayTasks(userTasks);
            } else {
                JOptionPane.showMessageDialog(this, "Task not found.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a task to edit.");
        }

    }//GEN-LAST:event_btnEditTaskActionPerformed

    private void btnDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTaskActionPerformed
        // TODO add your handling code here:
        int selectedRow = taskTable.getSelectedRow();
        
        if(selectedRow >= 0){
            int taskId = (int)tableModel.getValueAt(selectedRow,0);
            
            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this task?");
            
            if(confirmation == JOptionPane.YES_OPTION){
                taskManager.deleteTaskById(taskId);
                
                List<Task> userTasks = taskManager.getTasksForUser(loggedInUsername);
                displayTasks(userTasks);
            }
        } else {
            
            JOptionPane.showMessageDialog(this,"Select a task to delete");
        }
    }//GEN-LAST:event_btnDeleteTaskActionPerformed

    private void btnLoginPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginPageActionPerformed
        // TODO add your handling code here:
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
        
        CardLayout cl = mainFrame.getCardLayout();
        JPanel mainPanel = mainFrame.getMainPanel();
        cl.show(mainPanel,"LoginPanel");
    }//GEN-LAST:event_btnLoginPageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTask;
    private javax.swing.JButton btnDeleteTask;
    private javax.swing.JButton btnEditTask;
    private javax.swing.JButton btnLoginPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextArea txtDetails;
    // End of variables declaration//GEN-END:variables
}

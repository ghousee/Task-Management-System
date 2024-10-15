/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Task;
import Model.TaskManager;
import View.AdminPage;
import java.util.*;
import View.UserPage;

/**
 *
 * @author mgmoh
 */
public class TaskController {
    private TaskManager taskManager;
    private AdminPage adminPage;
    private UserPage userPage;
    
    public TaskController(AdminPage adminPage, UserPage userPage){
        this.taskManager = new TaskManager();
        this.adminPage = adminPage;
        this.userPage = userPage;
    }
    
    
    public void displayAllTasks(){
        List<Task> tasks = taskManager.getTasks();
        adminPage.displayAllTasks(tasks);
    }
    private void loadAdminTasks(){
        List<Task> tasks = taskManager.getTasks();
        adminPage.displayAllTasks(tasks);
    }
    
    public void setAdminPage(AdminPage adminPage){
        this.adminPage = adminPage;
        loadAdminTasks();
    }
    
    public void displayUserTasks(String username){
        List<Task> tasks = taskManager.getTasksForUser(username);
        userPage.displayTasks(tasks);
    }
    
    public void setUserPage(UserPage userPage){
        this.userPage = userPage;
    }
    
    public void addTask(String name, String description, String priority, Date deadline, String status, String assignedUser) {
    taskManager.addTask(name, description, priority, deadline, status, assignedUser);
    
    displayUserTasks(assignedUser);
    }

}
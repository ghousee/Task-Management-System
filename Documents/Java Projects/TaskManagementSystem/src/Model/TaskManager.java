/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author mgmoh
 */
public class TaskManager {
    private List<Task> tasks;
//    private List<User> users;
    private int nextTaskId = 1;

    
    public TaskManager(){
        tasks = new ArrayList<>();
//        users = new ArrayList<>();
    }
    
    public void addTask(String name, String description, String priority, Date deadline, String status, String assignedUser){
        if(name != null && assignedUser != null && !name.isEmpty() && !assignedUser.isEmpty()){
            Task newTask = new Task(getNextTaskId(),  name,  description,  priority,  deadline,  status,  assignedUser);
            tasks.add(newTask);
            System.out.println("TaskManager(addTask)Task Added:" + newTask.getName() + " assigned to" + newTask.getAssignedUser());
            System.out.println("TaskManager(addTask)Total tasks:" + tasks.size());
        } else {
            System.out.println("TaskManager(addTask)Failed to add task. Task name or assigned user is missing.");
        }
        
    }
    
    public void deleteTaskByName(String name){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getName().equals(name)){
                tasks.remove(i);
                break;
            }
        }
    }
    
    public void addUser(String username, String password, String role){

        for(User user : User.getUsers()){
            if(user.getUsername().equals(username)){
                System.out.println("taskManager(addUser) Username already exists: " + username);
                return;
            }
        }
        
        User newUser = new User(username, password, role);
        User.addUser(newUser);
        System.out.println("TaskManager(addUser) User Added: " + username);
        System.out.println("TaskManager(addUser) Total users: " + User.getUsers().size());

    }
    
    public User getUserByUsernameAndPassword(String username, String password) {
        for (User user : User.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    
    public List<User> getUsers(){
        return User.getUsers();
    }
    

    
    public List<Task> getTasks(){
        System.out.println("TaskManager(getTasks) method is working/ returnign tasks:  " + tasks.size());
        return tasks;
    }
    
    public List<Task> getTasksForUser(String username){
        List<Task> userTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getAssignedUser().equals(username)){
                userTasks.add(task);
            }
        }
        System.out.println("Tasks retrieved for user " + username + ": " + userTasks.size());
        return userTasks;
    }
    
    public void updateTask(Task updatedTask){
        for(int i = 0; i < tasks.size(); i++){
            Task existingTask = tasks.get(i);
            if(existingTask.getId() == updatedTask.getId()){
                tasks.set(i, updatedTask);
                return;
            }
        }
    }
    
    public void deleteTask(String name){
        for(int i = 0; i < tasks.size(); i++){
            Task task = tasks.get(i);
            if(task.getName().equals(name)){
                tasks.remove(i);
                break;
            }
        }
    }
    
    public void editTask(String currentName, String newName, String description, String priority){
        for(Task task : tasks){
            if(task.getName().equals(currentName)){
                task.setName(newName);
                task.setDescription(description);
                task.setPriority(priority);
                break;
            }
        }
    }
    
    public Task getTaskByName(String name){
        for(Task task : tasks){
            System.out.println("Checking task: " + task.getName());
            if(task.getName().equals(name)){
                return task;
            }
        }
        System.out.println("Task not found: " + name);
        return null;
    }
    
    public Task getTaskById(int id){
        for(Task task : tasks){
            if(task.getId() == id){
            return task;
        }
        }
        return null;
    }
    
    public void deleteTaskById(int id) {
    for (int i = 0; i < tasks.size(); i++) {
        if (tasks.get(i).getId() == id) {
            tasks.remove(i);
            break;
            }
        }
    }
    
    public int getNextTaskId(){
        return nextTaskId++;
    }
}

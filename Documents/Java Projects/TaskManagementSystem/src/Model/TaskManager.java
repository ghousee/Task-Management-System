/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mgmoh
 */
public class TaskManager {
    private List<Task> tasks;
    private List<User> users;
    
    public TaskManager(){
        this.tasks = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    
    public void addTask(Task task){
        tasks.add(task);
    }
    
    public void deleteTaskByName(String name){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getName().equals(name)){
                tasks.remove(i);
                break;
            }
        }
    }
    

    
    public List<Task> getTasks(){
        return tasks;
    }
    
    public List<Task> getTaskForUser(String username){
        List<Task> userTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getAssignedUser().equals(username)){
                userTasks.add(task);
            }
        }
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
            if(task.getName().equals(name)){
                return task;
            }
        }
        return null;
    }
    
    public List<Task> getTasksForUser(String username){
        List<Task> userTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getAssignedUser().equals(username)){
                userTasks.add(task);
            }
        }
        return userTasks;
    }
    
    
    private int nextTaskId = 1;
    
    public int getNextTaskId(){
        return nextTaskId++;
    }
    
}

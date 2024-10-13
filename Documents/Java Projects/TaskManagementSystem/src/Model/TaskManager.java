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
    
    public TaskManager(){
        this.tasks = new ArrayList<>();
    }
    
    public void addTask(Task task){
        tasks.add(task);
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
    
    public List<Task> getTasksForUser(String username){
        List<Task> userTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getAssignedUser().equals(username)){
                userTasks.add(task);
            }
        }
        return userTasks;
    }
    
    
}

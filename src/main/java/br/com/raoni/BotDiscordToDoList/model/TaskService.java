package br.com.raoni.BotDiscordToDoList.model;

import br.com.raoni.BotDiscordToDoList.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task createTask (String description,String userID){

        Task task = new Task();
        task.setDescription(description);
        task.setDiscordUserId(userID);
        task.setCompleted(false);
        taskRepository.save(task);

        return task;
    }


    public List<Task> getListTasksByUser(String userID){
        return taskRepository.findByDiscordUserId(userID);
    }

    public void deleteTasksById(Long id){
        taskRepository.deleteById(id);
    }

    public boolean taskCompleted(Long id){
        Optional <Task> taskFind =taskRepository.findById(id);
        if(taskFind.isPresent()){
            Task task = taskFind.get();
            task.setCompleted(true);
            taskRepository.save(task);
            return true;
        }else {
            return false;
        }
    }

}

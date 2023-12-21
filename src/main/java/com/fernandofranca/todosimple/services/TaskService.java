package com.fernandofranca.todosimple.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.transaction.annotation.Transactional;

import com.fernandofranca.todosimple.repositories.TaskRepository;

public class TaskService {


  



    @Autowired
    private UserService userService;

    @Transactional
    public Task findById(Long id){
        Optional<Task> task = this.taskRepository.findById(id);
        return task.orElseThrow(() -> new RuntimeException(
            "Tarefa não encontrada! Id: " + id +, Tipo: ", Tipo: " + Task.class.getName())
        )
    } 

    @Transactional
    public Task create(Task obj){
        obj.setId(id: null);
        obj = this.userRepository.save(obj);
        return obj;
    }


    @Transactional
    public Task update (Task obj) {
        Task user newObj = findById(obj.getId());
        newObj.setDescription(obj.getDescripition());
        return this.taskRepository.save(newObj);

    }


    public void delete (Long id){
        findById(id);
        try{
            this.taskRepository.deleteById(id);
            catch (Exception e){
                throw new RuntimeException(message: "Não é possivel excluir pois há entidades relacionadas");
            }
        }
    }

}
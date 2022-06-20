package com.shar.casestudy.services;

import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoItemService {

    TodoItemRepository todoItemRepository;


    @Autowired
    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;

    }

    public List<TodoItem> findAll(){
        System.out.println("Hello testing");
        return todoItemRepository.findAll();
    }

}

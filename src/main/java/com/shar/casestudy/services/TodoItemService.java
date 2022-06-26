package com.shar.casestudy.services;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.models.User;
import com.shar.casestudy.repositories.GroupRepository;
import com.shar.casestudy.repositories.TodoItemRepository;
import com.shar.casestudy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoItemService {

    TodoItemRepository todoItemRepository;
    GroupRepository groupRepository;

    UserRepository userRepository;


    @Autowired
    public TodoItemService(TodoItemRepository todoItemRepository, GroupRepository groupRepository, UserRepository userRepository) {
        this.todoItemRepository = todoItemRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public List<TodoItem> findAllByUserID(int id) {
        System.out.println("Hello testing");
        User user = userRepository.findById(id + "").orElseThrow();
        return todoItemRepository.findAllByUser(user);
    }
    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }

    public void EditItem(int itemId, String newDescription, int groupId) {
        //find the item by itemid. If item doesn't exist you can't edit it.

        TodoItem tdi = todoItemRepository.findById(itemId).orElseThrow();
        Group g = groupRepository.findById(groupId).orElseThrow();
        //remove the item from the old group
        tdi.getGroup().deleteItem(tdi);
        tdi.setGroup(g);
        g.addTodoItem(tdi);
    }

        public void addTodoItem(TodoItem todoitem) {
            todoItemRepository.save(todoitem);
        }
    }



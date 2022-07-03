package com.shar.casestudy.services;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.Status;
import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.models.User;
import com.shar.casestudy.repositories.GroupRepository;
import com.shar.casestudy.repositories.StatusRepository;
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

    StatusRepository statusRepository;


    @Autowired
    public TodoItemService(TodoItemRepository todoItemRepository, GroupRepository groupRepository, UserRepository userRepository, StatusRepository statusRepository) {
        this.todoItemRepository = todoItemRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
    }
//for the commandlinerunner.saves in the db
    public void saveOrUpdate(TodoItem todoItem){
        todoItemRepository.save(todoItem);

    }

    public List<TodoItem> findAllByUserID(int id) {
//        System.out.println("Hello testing");
        User user = userRepository.findById(id).orElseThrow();
        return todoItemRepository.findAllByUser(user);
    }
   //delete todoitem
    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }

//update todoitem.
// Post request for controller.
    public void editItem(TodoItem todoItem) {
        //find the item by itemid. If item doesn't exist you can't edit it.

        TodoItem tdi = todoItemRepository.findById(todoItem.getId()).orElseThrow();
        Group g = todoItem.getGroup();
        //remove the item from the old group
//        tdi.getGroup().deleteItem(todoItem);
        tdi.setGroup(g);
        tdi.setStatus(todoItem.getStatus());
        tdi.setDescription(todoItem.getDescription());
        todoItemRepository.save(tdi);
//        g.addTodoItem(todoItem);
    }
//create todoitem
        public void addTodoItem(TodoItem todoItem, Integer userId, Integer groupId, String statusId) {
           User user = userRepository.findById(userId).orElse(null);
           todoItem.setUser(user);
            Group group = groupRepository.findById(groupId).orElse(null);
            todoItem.setGroup(group);
            Status status = statusRepository.findById(statusId).orElse(null);
            todoItem.setStatus(status);
            todoItemRepository.save(todoItem);
        }
     //A Get request for controller
        public TodoItem findItemById(int itemId){
        return todoItemRepository.findById(itemId).orElseThrow();
        }
    }



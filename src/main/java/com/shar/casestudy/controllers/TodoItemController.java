package com.shar.casestudy.controllers;

import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.services.TodoItemService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("todoitem")
public class TodoItemController {

    TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;

    }
    @GetMapping
    public String getAllTodoItem(int id, Model model){
        model.addAttribute("todoitems", todoItemService.findAllByUserID(id));
        return "mylist";
    }

    @GetMapping(value = "/additem")
    public String showAddItemPage(Model model) {
        model.addAttribute("todoItem", new TodoItem());
        return "additem";
    }
}

package com.shar.casestudy.controllers;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.services.GroupService;
import com.shar.casestudy.services.TodoItemService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("todoitem")
public class TodoItemController {

    TodoItemService todoItemService;
    GroupService groupService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService, GroupService groupService) {
        this.todoItemService = todoItemService;
        this.groupService = groupService;

    }
    @PostMapping("/todoitem")
    public void createTodoItem(@RequestBody TodoItem todoItem, HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        String statusId = request.getParameter("statusId");
        todoItemService.addTodoItem(todoItem, userId, groupId, statusId);
    }


    @GetMapping
    public String getAllTodoItemsAndGroups(Integer id, Model model){
        System.out.println("HAHA");
        System.out.println(id);
        if(id == null){
            id = 1;
        }
        model.addAttribute("todoitems", todoItemService.findAllByUserID(id));
        model.addAttribute("groups", groupService.getGroupList(id));
        return "index";
    }

    @GetMapping(value = "/additem")
    public String showAddItemPage(Model model) {
        model.addAttribute("todoItem", new TodoItem());
        return "additem";
    }
}

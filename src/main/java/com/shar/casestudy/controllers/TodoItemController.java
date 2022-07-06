package com.shar.casestudy.controllers;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.services.GroupService;
import com.shar.casestudy.services.StatusService;
import com.shar.casestudy.services.TodoItemService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("todoitem")
public class TodoItemController {

    TodoItemService todoItemService;
    GroupService groupService;

    StatusService statusService;


    @Autowired
    public TodoItemController(TodoItemService todoItemService, GroupService groupService, StatusService statusService) {
        this.todoItemService = todoItemService;
        this.groupService = groupService;
        this.statusService = statusService;
    }

    @PostMapping("/additem")
    public String createTodoItem(@ModelAttribute("item") TodoItem item, @RequestParam("userId") Integer userId,
    @RequestParam("groupId") Integer groupId, @RequestParam("statusId") String statusId) {

        todoItemService.addTodoItem(item, userId, groupId, statusId);
        return "redirect:/index";
    }


    @GetMapping
    public String getAllTodoItemsAndGroups(Integer id, Model model) {
        log.info("userid: {}", id);
        if (id == null) {
            id = 1;
        }
        model.addAttribute("todoitems", todoItemService.findAllByUserID(id));
        model.addAttribute("groups", groupService.getGroupList(id));
        return "index";
    }

    @GetMapping(value = "/additem")
    public String showAddItemPage(Integer userId, Model model) {
        if(userId == null){
            userId = 1;
        }
        model.addAttribute("item", new TodoItem());
        model.addAttribute("groups", groupService.getGroupList(userId));
        model.addAttribute("status", statusService.getAllStatus());
        return "additem";
    }

    @GetMapping(value = "/edititem")
    public String editItem(Integer itemId, Model model) {
        if (itemId != null) {
            TodoItem tdi = todoItemService.findItemById(itemId);
            model.addAttribute("item", tdi);
            model.addAttribute("groups", groupService.getGroupList(tdi.getUser().getId()));
            model.addAttribute("status", statusService.getAllStatus());
        }
        return "edititem";
    }

    @PostMapping("/edititem")
    public String editItem(@ModelAttribute("item") TodoItem todoItem) {
//        todoItemService.saveOrUpdate(todoItem);
        todoItemService.editItem(todoItem);
        return "redirect:/index";
    }
    @PostMapping("/todoitem/{id}")
    public String delete(@PathVariable Integer id){
        TodoItem tdi = todoItemService.findItemById(id);
        todoItemService.delete(tdi);
        return "redirect:/index";
    }
}
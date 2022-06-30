package com.shar.casestudy;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.Status;
import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.models.User;
import com.shar.casestudy.services.GroupService;
import com.shar.casestudy.services.StatusService;
import com.shar.casestudy.services.TodoItemService;
import com.shar.casestudy.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ApplicationCommandLineRunner implements CommandLineRunner {

    TodoItemService todoItemService;

    GroupService groupService;

    StatusService statusService;

    UserService userService;

    @Autowired
    public ApplicationCommandLineRunner(TodoItemService todoItemService, GroupService groupService, StatusService statusService, UserService userService) {
        this.todoItemService = todoItemService;
        this.groupService = groupService;
        this.statusService = statusService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Status doing = new Status("doing");
        statusService.saveOrUpdate(doing);
        statusService.saveOrUpdate(new Status("done"));
        statusService.saveOrUpdate(new Status("todo"));
        User u = new User("Shar", "pass");
        userService.saveOrUpdate(u);
//        userService.saveOrUpdate(new User("Jane", "pass"));
//        userService.saveOrUpdate(new User("Mary", "pass"));
        Group g = new Group(1,"red","shopping", u);
        groupService.saveOrUpdate(g);
        Group g1 = new Group(2,"green","work", u);
        groupService.saveOrUpdate(g1);
//        groupService.saveOrUpdate(new Group(3,"blue","school"));
        TodoItem todoItem1 = new TodoItem(1, "get veggies", u, doing, g);
        todoItemService.saveOrUpdate(todoItem1);
        TodoItem todoItem2 = new TodoItem(2, "finish organizing the shelf", u, doing, g1);
        todoItemService.saveOrUpdate(todoItem2);
//        todoItemService.saveOrUpdate(new TodoItem(3, "assignment"));
        log.info("Run the application");;

    }
}

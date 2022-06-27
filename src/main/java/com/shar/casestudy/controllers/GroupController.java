package com.shar.casestudy.controllers;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.services.GroupService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("group")
public class GroupController {

    GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

//    @GetMapping("/mylist")
//    public void showGroupList(int userID){
//
//    }


    @PostMapping("/group")
    public void creategroup(@RequestBody Group group, Integer userID) {

        groupService.saveOrUpdateGroup(group, userID);
    }

}

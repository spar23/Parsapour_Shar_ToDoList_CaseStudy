package com.shar.casestudy.controllers;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.services.GroupService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@GetMapping(value = "/addgroup")
public String getAllGroups(Integer id, Model model){
    System.out.println(id);
    if(id == null){
        id = 1;
    }
    model.addAttribute("groups", groupService.getGroupList(id));
    return "addgroup";
}


    @PostMapping("/addgroup")
    public void creategroup(@ModelAttribute Group group, Integer userId) {
        System.out.println(group);
        groupService.saveOrUpdateGroup(group, userId);
    }

}

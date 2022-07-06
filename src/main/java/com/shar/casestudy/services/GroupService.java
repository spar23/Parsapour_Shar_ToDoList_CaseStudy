package com.shar.casestudy.services;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.User;
import com.shar.casestudy.repositories.GroupRepository;
import com.shar.casestudy.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
public class GroupService {

    GroupRepository groupRepository;
    UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }
//creates a new group
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public void saveOrUpdateGroup(Group group, int userID){
        // If group doesn't exist then add it to the user.

        User user = userRepository.findById(userID).orElseThrow();
        group.setUser(user);
        groupRepository.save(group);

    }

    public List<Group> getGroupList(int userId){
        User user = userRepository.findById(userId).orElseThrow();
        return groupRepository.findAllByUser(user);
    }
//method for commandlinerunner
    public void saveOrUpdate(Group group){
        groupRepository.save(group);

    }


}

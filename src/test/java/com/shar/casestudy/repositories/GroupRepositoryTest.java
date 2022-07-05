package com.shar.casestudy.repositories;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.Status;
import com.shar.casestudy.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GroupRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    TodoItemRepository todoItemRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StatusRepository statusRepository;

    @Test
    void findByGroupNameAndUser() {
        //Add any data
        entityManager.persist(new Status("Todo"));

        //Retrieve any data
        Status s = statusRepository.findById("Todo").orElse(null);

        //Asserts
        assertThat(s.getStatus()).isEqualTo("Todo");
//        User a = userRepository.findById(1).orElse(null);
//        List<Group> groups = groupRepository.findAllByUser(a);
    }

    @Test
    void findAllByUser() {
//created a user
        User u = new User("Shar", "pass");
        entityManager.persist(u);
//created a group and saved
        entityManager.persist(new Group("work", "red", u));
        // retreived the user
        u = userRepository.findById(1).orElse(null);
        //retreive the groups
        List<Group> groups = groupRepository.findAllByUser(u);
        assertThat(groups.get(0).getGroupName()).isEqualTo("work");

    }
}

package com.shar.casestudy.repositories;

import com.shar.casestudy.ApplicationCommandLineRunner;
import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.Status;
import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TodoItemRepositoryTest {
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


//    @Autowired
//    ApplicationCommandLineRunner applicationCommandLineRunner;
//
//    @BeforeAll
//    void beforeAll() {
////        applicationCommandLineRunner.run();
//
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void findAllByUser() {
        User u = new User("Sue", "pass");
        entityManager.persist(u);
        Group g = new Group(1,"red","shopping", u);
        entityManager.persist(g);
       Status s = entityManager.persist(new Status("Todo"));

        entityManager.persist(new TodoItem(1, "get veggies", u, s, g));
        // retreived the user
        User u1 = userRepository.findById(1).orElse(null);
        //retreive the todoitems
        List<TodoItem> todoItems = todoItemRepository.findAllByUser(u1);
//        assertThat(todoItems.size(;
    }
}
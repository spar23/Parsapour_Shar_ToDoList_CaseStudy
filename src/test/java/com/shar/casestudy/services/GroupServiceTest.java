package com.shar.casestudy.services;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.User;
import com.shar.casestudy.repositories.GroupRepository;
import com.shar.casestudy.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GroupServiceTest {
//    @Autowired
//    private TestEntityManager entityManager;
    @Autowired
    GroupService groupService;
    @Autowired
    UserService userService;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    void saveOrUpdate() {
        User u = new User(1,"Jane", "pass");
        userService.saveOrUpdate(u);
        u = userRepository.findById(1).orElse(null);
        Group g = new Group("work", "blue", u);
        groupService.saveOrUpdate(g);
        Group g1 = groupRepository.findById(1).orElse(null);
        assertThat(g1.getGroupName()).isEqualTo(g.getGroupName());
        assertThat(g1.getHexColor()).isEqualTo(g.getHexColor());

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(number % 2 != 0);
    }
}
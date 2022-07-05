package com.shar.casestudy.services;

import com.shar.casestudy.models.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

class GroupServiceTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    GroupService groupService;

    @Test
    void saveOrUpdate() {



    }
}
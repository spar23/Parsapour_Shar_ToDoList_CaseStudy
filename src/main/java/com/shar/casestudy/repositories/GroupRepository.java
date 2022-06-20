package com.shar.casestudy.repositories;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}

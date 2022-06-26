package com.shar.casestudy.repositories;

import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {


    public List<TodoItem> findAllByUser(User user);
}

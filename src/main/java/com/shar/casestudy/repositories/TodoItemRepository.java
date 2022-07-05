package com.shar.casestudy.repositories;

import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Integer> {


//    @Query("select tdi from TodoItem tdi where tdi.user_id = :#{#user.id}")
    public List<TodoItem> findAllByUser(User user);


}

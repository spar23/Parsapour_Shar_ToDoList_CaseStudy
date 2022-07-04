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

//    @Transactional
//    @Modifying
//    @Query("update todo_item tdi set tdi.description = ?2, tdi.user_id = ?3, tdi.group_id = ?4, tdi.status_status = ?5 where tdi.id = ?1")
//
//    int updateTodoItemById(Integer id, String description, Integer userId, Integer groupId, String statusId);
}

package com.tutool.todoapp.repository;

import com.tutool.todoapp.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    List<Todo> findAllByTitleIsNotNullAndUser_UserId(String userId);

    Todo findByTodoId(Long todoId);

    List<Todo> findAllByStatus_DescriptionEqualsIgnoreCase(String str);

    List<Todo> findAllByStatus_StatusIdEquals(Long statusId);

    List<Todo> findByDueDateTimeAfterOrderByDueDateTimeAsc(Date dueDate);

    List<Todo> findByDueDateTimeBeforeOrderByDueDateTimeDesc(Date dueDateTime);

    @Query("select e from Todo e where year(e.dueDateTime) = ?1 and month(e.dueDateTime) = ?2 and day(e.dueDateTime) = ?3 ")
    List<Todo> findByDueDateTimeByYearAndMonthAndDay(int year, int month, int day);

    List<Todo> findByDueDateTimeBetweenOrderByDueDateTimeAsc(Date dueDateFrom, Date dueDateTo);

    List<Todo> findAllByTitle(String title);
    void deleteByTodoId(int todoId);
}

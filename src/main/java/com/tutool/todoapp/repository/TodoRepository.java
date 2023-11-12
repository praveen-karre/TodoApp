package com.tutool.todoapp.repository;

import com.tutool.todoapp.models.Todo;
import com.tutool.todoapp.models.User;
import jakarta.persistence.TemporalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;

import java.util.Date;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByCreatedDateTimeBefore(Date creationDate);
    List<Todo> findByCreatedDateTimeAfter(Date creationDate);

    List<Todo> findByDueDateAfter(Date dueDate);
    List<Todo> findByDueDateBefore(Date dueDate);
    List<Todo> findByDueDate(@Temporal(TemporalType.DATE) Date dueDate);
}

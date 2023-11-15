package com.tutool.todoapp.repository;

import com.tutool.todoapp.models.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubtaskRepository extends JpaRepository<Subtask, Integer> {

    //List<Subtask> findAllByTodo_TodoId(Long todoId);
}

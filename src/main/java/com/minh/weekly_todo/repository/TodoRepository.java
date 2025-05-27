package com.minh.weekly_todo.repository;

import com.minh.weekly_todo.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<TodoItem, String> {
    List<TodoItem> findByDay(String day);
}

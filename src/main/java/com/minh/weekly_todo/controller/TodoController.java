package com.minh.weekly_todo.controller;

import com.minh.weekly_todo.model.TodoItem;
import com.minh.weekly_todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*") // Cho phép frontend gọi API từ domain khác
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/{day}")
    public List<TodoItem> getTodosByDay(@PathVariable String day) {
        return todoRepository.findByDay(day);
    }

    @PostMapping
    public TodoItem createTodo(@RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodo(@PathVariable String id, @RequestBody TodoItem updatedTodo) {
        Optional<TodoItem> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            TodoItem existing = optionalTodo.get();
            existing.setTitle(updatedTodo.getTitle());
            existing.setDescription(updatedTodo.getDescription());
            existing.setDay(updatedTodo.getDay());
            existing.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable String id) {
        todoRepository.deleteById(id);
    }
}

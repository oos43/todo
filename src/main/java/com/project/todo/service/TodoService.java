package com.project.todo.service;

import com.project.todo.domain.Category;
import com.project.todo.domain.Todo;
import com.project.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Long saveTodo(Todo todo) {
        todoRepository.saveTodo(todo);
        return todo.getNo();
    }

    public Long saveCategory(Category category) {
        todoRepository.saveCategory(category);
        return category.getNo();
    }
}

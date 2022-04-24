package com.project.todo.service;

import com.project.todo.domain.Category;
import com.project.todo.domain.Todo;
import com.project.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Long saveCategory(Category category) {
        todoRepository.saveCategory(category);
        return category.getNo();
    }

    public List<Category> findCategories(Long memberNo) {
        return todoRepository.findCategories(memberNo);
    }

    public Category findCategory(Long no) {
        return todoRepository.findCategory(no);
    }

    public Long saveTodo(Todo todo) {
        todoRepository.saveTodo(todo);
        return todo.getNo();
    }

    public List<Todo> findTodolist(Long memberNo) {
        return todoRepository.findTodolist(memberNo);
    }

    public void updateTodoCompleted(Long todoNo) {
        Todo findTodo = todoRepository.findTodo(todoNo);
        Todo.updateTodoCompleted(findTodo);
    }

    public void updateTodoUncompleted(Long todoNo) {
        Todo findTodo = todoRepository.findTodo(todoNo);
        Todo.updateTodoUncompleted(findTodo);
    }

    public List<Todo> findTodolistByDate(Long no, LocalDate date) {
        return todoRepository.findTodolistByDate(no, date);
    }
}

package com.project.todo.repository;

import com.project.todo.domain.Category;
import com.project.todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager em;

    public void saveCategory(Category category) {
        em.persist(category);
    }

    public void saveTodo(Todo todo) {
        em.persist(todo);
    }

    public Category findCategory(Long no) {
        return em.find(Category.class, no);
    }

    public Todo findTodo(Long no) {
        return em.find(Todo.class, no);
    }
}

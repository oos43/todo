package com.project.todo.repository;

import com.project.todo.domain.Category;
import com.project.todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final EntityManager em;

    /**
     * Category
     */
    public void saveCategory(Category category) {
        em.persist(category);
    }

    public List<Category> findCategories(Long no) {
        return em.createQuery("select c from Category c where member_no = :no", Category.class)
                .setParameter("no", no)
                .getResultList();
    }

    public Category findCategory(Long no) {
        return em.find(Category.class, no);
    }

    /**
     * Todolist
     */
    public void saveTodo(Todo todo) {
        em.persist(todo);
    }

    public Todo findTodo(Long no) {
        return em.find(Todo.class, no);
    }
}

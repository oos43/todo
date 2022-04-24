package com.project.todo.repository;

import com.project.todo.domain.Category;
import com.project.todo.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
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
        return em.createQuery("select c from Category c where c.member_no = :no", Category.class)
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

    public List<Todo> findTodolist(Long no) {
        return em.createQuery("select t from Todo t where member_no = :no order by t.status desc", Todo.class)
                .setParameter("no", no)
                .getResultList();
    }

    public Todo findTodo(Long no) {
        return em.find(Todo.class, no);
    }

    public List<Todo> findTodolistByDate(Long no, LocalDate date) {
        return em.createQuery("select t from Todo t where member_no = :no and t.date = :date order by t.status desc", Todo.class)
                .setParameter("no", no)
                .setParameter("date", date)
                .getResultList();
//        Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant())
    }
}

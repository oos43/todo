package com.project.todo.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Todo {

    @Id @GeneratedValue
    @Column(name = "todo_no")
    private Long no;

    private String content;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_no")
    private Category category;

    public static Todo createTodo(String content, LocalDate date, TodoStatus status, Member member, Category category) {
        Todo todo = new Todo();
        todo.content = content;
        todo.status = status;
        todo.date = date;
        todo.member = member;
        todo.category = category;

        return todo;
    }

    public static void updateTodoCompleted(Todo todo) {
        todo.status = TodoStatus.N;
    }

    public static void updateTodoUncompleted(Todo todo) {
        todo.status = TodoStatus.Y;
    }
}

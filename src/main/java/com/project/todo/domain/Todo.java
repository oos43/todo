package com.project.todo.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

import static com.project.todo.domain.TodoStatus.Y;

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

    private Todo(String content, LocalDate date, TodoStatus status, Member member, Category category) {
        this.content = content;
        this.date = date;
        this.status = status;
        this.member = member;
        this.category = category;
    }

    public static Todo createTodo(String content, LocalDate date, Member member, Category category) {
        Todo todo = new Todo(content, date, Y, member, category);
        return todo;
    }
}

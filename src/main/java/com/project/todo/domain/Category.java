package com.project.todo.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_no")
    private Long no;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    private Category(String name, Member member) {
        this.name = name;
        this.member = member;
    }

    public static Category createCategory(String name, Member member) {
        Category category = new Category(name, member);
        return category;
    }
}

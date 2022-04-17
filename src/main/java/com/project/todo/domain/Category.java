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


    public static Category createCategory(String name, Member member) {
        Category category = new Category();
        category.name = name;
        category.member = member;

        return category;
    }
}

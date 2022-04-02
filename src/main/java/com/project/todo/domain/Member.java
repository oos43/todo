package com.project.todo.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_no")
    private int no;

    private String id;
    private String password;
    private String nickname;
    private String email;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

}

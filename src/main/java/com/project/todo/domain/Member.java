package com.project.todo.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_no")
    private Long no;

    private String id;

    private String password;
    private String nickname;
    //private String email;

    //@Enumerated(EnumType.STRING)
    //private MemberStatus status;

    private String auth;

    public Member() {}

    public Member(String id, String password, String nickname, String auth) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.auth = auth;
    }

    public static Member createMember(String id, String password, String nickname, String auth) {
        Member member = new Member();
        member.id = id;
        member.password = password;
        member.nickname = nickname;
        member.auth = auth;

        return member;
    }
}

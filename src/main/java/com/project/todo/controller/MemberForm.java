package com.project.todo.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "아이디는 필수 입력 사항입니다.")
    private String id;

    @NotEmpty(message = "비밀번호는 필수 입력 사항입니다.")
    private String password;

    private String nickname;
}

package com.project.todo.controller;

import com.project.todo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp")
    public String createForm() {
        return "members/createMemberForm";
    }

    @GetMapping("/login")
    public String login() {
        return "members/login";
    }
}

package com.project.todo.controller;

import com.project.todo.domain.Member;
import com.project.todo.domain.MemberDetail;
import com.project.todo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp")
    public String createForm() {
        return "members/signUpForm";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestParam("id") String id,
                         @RequestParam("password") String password,
                         @RequestParam("nickname") String nickname,
                         @RequestParam("auth") String auth) {

        Member member = new Member(id, password, nickname, auth);

        Long memberNo = memberService.save(member);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "members/login";
    }
/*

    @PostMapping("/login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("password") String password) {
        System.out.println("id: " + id);
        System.out.println("pwd: " + password);

        try {
            MemberDetail memberDetail = memberService.loadUserByUsername(id);
        } catch (UsernameNotFoundException e) {
            System.out.println("error");
        }

        return "redirect:/todo";
    }
*/

    @GetMapping("/todo")
    public String showTodo() {
        return "members/todo";
    }

}

package com.project.todo.controller;

import com.project.todo.domain.Member;
import com.project.todo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String showSignUpForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "view/signUpForm";
    }

    @PostMapping("/members/new")
    public String signUp(@Valid MemberForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "view/signUpForm";
        }

        Member member = new Member(form.getId(), form.getPassword(), form.getNickname(), "USER");

        Long memberNo = memberService.save(member);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "view/login";
    }
}

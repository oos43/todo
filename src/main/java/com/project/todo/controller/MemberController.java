package com.project.todo.controller;

import com.project.todo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        Long memberNo = memberService.save(form);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "view/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}

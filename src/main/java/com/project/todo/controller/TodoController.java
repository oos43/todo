package com.project.todo.controller;

import com.project.todo.domain.Category;
import com.project.todo.domain.Member;
import com.project.todo.repository.MemberRepository;
import com.project.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.project.todo.domain.Category.createCategory;

@Controller
public class TodoController {

    @Autowired MemberRepository memberRepository;
    @Autowired TodoService todoService;

    @GetMapping("/todo")
    public String showTodo() {
        return "view/todo";
    }

    @GetMapping("/todolist/new")
    public String addTodo() { return "view/createTodo"; }

    @PostMapping("/categories/new")
    public String addCategory(@RequestParam("name") String name) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id = ((UserDetails) principal).getUsername();

        Member loginUser = memberRepository.findById(id);

        Category category = createCategory(name, loginUser);

        Long categoryNo = todoService.saveCategory(category);

        return "redirect:/todo";
    }
}

package com.project.todo.controller;

import com.project.todo.domain.Category;
import com.project.todo.domain.Member;
import com.project.todo.domain.Todo;
import com.project.todo.repository.MemberRepository;
import com.project.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.project.todo.domain.Category.createCategory;
import static com.project.todo.domain.Todo.createTodo;

@Controller
public class TodoController {

    @Autowired MemberRepository memberRepository;
    @Autowired TodoService todoService;

    @GetMapping("/todo")
    public String showTodo() {
        return "view/todo";
    }

    @PostMapping("/categories/new")
    public String addCategory(@RequestParam("name") String name) {
        Member loginUser = getLoginUser();

        Category category = createCategory(name, loginUser);

        Long categoryNo = todoService.saveCategory(category);

        return "redirect:/todo";
    }

    @GetMapping("/todolist/new")
    public String todoView(Model model) {
        Member loginUser = getLoginUser();

        List<Category> categories = todoService.findCategories(loginUser.getNo());
        for (Category c : categories) {
            System.out.println(c.getName());
        }

        model.addAttribute("todoForm", new TodoForm());
        model.addAttribute("categories", categories);

        return "view/createTodo";
    }

    @PostMapping("/todolist/new")
    public String addTodo(@Valid TodoForm todoForm, BindingResult result) {
        if (result.hasErrors()) {
            return "view/createTodo";
        }

        String dateString = todoForm.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);

        Member loginUser = getLoginUser();

        Long categoryNo = todoForm.getCategoryNo();
        Category category = todoService.findCategory(categoryNo);

        Todo todo = createTodo(todoForm.getContent(), date, loginUser, category);
        Long todoNo = todoService.saveTodo(todo);

        return "redirect:/todo";
    }


    private Member getLoginUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String id = ((UserDetails) principal).getUsername();

        return memberRepository.findById(id);
    }
}

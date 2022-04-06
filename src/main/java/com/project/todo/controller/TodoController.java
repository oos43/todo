package com.project.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @GetMapping("/todo")
    public String showTodo() {
        return "view/todo";
    }
}

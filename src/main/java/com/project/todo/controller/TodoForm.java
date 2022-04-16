package com.project.todo.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TodoForm {

    private String content;

    private String date;

    private Long categoryNo;
}

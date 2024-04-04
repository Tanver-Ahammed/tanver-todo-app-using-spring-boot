package org.dsi.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.dsi.dto.TodoDTO;
import org.dsi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(path = {"/", "home"})
    public String homeController() {
        return "home";
    }

    @GetMapping("/add")
    public String addTodo(Model model) {
        model.addAttribute("todoDTO", new TodoDTO());
        return "add-todo";
    }

    @PostMapping("save")
    public String saveTodo(Model model, @ModelAttribute TodoDTO todoDTO) {
        this.todoService.addToDO(todoDTO);
        return "home";
    }

}

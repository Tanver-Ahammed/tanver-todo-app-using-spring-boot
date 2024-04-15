package org.dsi.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.dsi.dto.TodoDTO;
import org.dsi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/todo/add")
    public String addTodo(Model model) {
        model.addAttribute("todoDTO", new TodoDTO());
        return "add-todo";
    }

    @PostMapping("save")
    public String saveTodo(Model model, @ModelAttribute TodoDTO todoDTO) {
        this.todoService.addToDO(todoDTO);
        return "redirect:/todo/all";
    }

    @GetMapping("/todo/all")
    // @ResponseBody
    public String allTodos(Model model) {
        List<TodoDTO> todoDTOS = this.todoService.getAllToDos();
        model.addAttribute("todoDTOS", todoDTOS);
        // return "all-todos";
        return "all-todos";
    }

    @GetMapping("/todo/delete/{todoId}")
    public String deleteTodo(Model model, @PathVariable("todoId") long todoId) {
        this.todoService.deleteTodo(todoId);
        // return "all-todos";
        return "redirect:/todo/all";
    }

}

package org.dsi.service;

import lombok.AllArgsConstructor;
import org.dsi.dto.TodoDTO;
import org.dsi.entity.Todo;
import org.dsi.mapper.TodoMapper;
import org.dsi.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {


    private TodoRepository todoRepository;

    public void addToDO(TodoDTO todoDTO) {
        Todo todo = TodoMapper.dtoToTodo(todoDTO);
        todo.setDate(Date.valueOf(LocalDate.now()));
        this.todoRepository.save(todo);
    }

    public List<TodoDTO> getAllToDos() {
        return this.todoRepository
                .findAll()
                .stream()
                .map(TodoMapper::todoToDTO)
                .toList();
    }

    public TodoDTO getTodoById(Long toDoId) {
        return TodoMapper.todoToDTO(this.todoRepository.findById(toDoId).orElseThrow());
    }

    public TodoDTO updateTodo(TodoDTO todoDTO, Long todoId) {
        Todo todo = this.todoRepository.findById(todoId).orElseThrow();
        todo.setTitle(todoDTO.getTitle());
        todo.setDetails(todoDTO.getDetails());
        todo.setDate(todoDTO.getDate());
        todo.setStatus(todoDTO.getStatus());
        todo.setPriority(todoDTO.getPriority());
        return TodoMapper.todoToDTO(this.todoRepository.save(todo));
    }

    public void deleteTodo(Long todoId) {
        Todo todo = this.todoRepository.findById(todoId).orElseThrow();
        this.todoRepository.delete(todo);
    }

}

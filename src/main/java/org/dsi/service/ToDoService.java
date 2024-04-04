package org.dsi.service;

import lombok.AllArgsConstructor;
import org.dsi.dto.ToDoDTO;
import org.dsi.mapper.ToDoMapper;
import org.dsi.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToDoService {

    private TodoRepository todoRepository;

    public void addToDO(ToDoDTO toDoDTO) {
        this.todoRepository.save(ToDoMapper.DTOToToDo(toDoDTO));
    }

}

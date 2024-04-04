package org.dsi.mapper;

import org.dsi.dto.TodoDTO;
import org.dsi.entity.Todo;

public class TodoMapper {

    public static TodoDTO todoToDTO(Todo toDo) {
        TodoDTO toDoDTO = new TodoDTO();
        toDoDTO.setId(toDo.getId());
        toDoDTO.setTitle(toDo.getTitle());
        toDoDTO.setDetails(toDo.getDetails());
        toDoDTO.setDate(toDo.getDate());
        toDoDTO.setStatus(toDo.getStatus());
        toDoDTO.setPriority(toDo.getPriority());
        return toDoDTO;
    }

    public static Todo dtoToTodo(TodoDTO toDoDTO) {
        Todo toDo = new Todo();
        toDo.setId(toDoDTO.getId());
        toDo.setTitle(toDoDTO.getTitle());
        toDo.setDetails(toDoDTO.getDetails());
        toDo.setDate(toDoDTO.getDate());
        toDo.setStatus(toDoDTO.getStatus());
        toDo.setPriority(toDoDTO.getPriority());
        return toDo;
    }

}

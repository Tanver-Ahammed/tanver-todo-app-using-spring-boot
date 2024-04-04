package org.dsi.mapper;

import org.dsi.dto.ToDoDTO;
import org.dsi.entity.ToDo;

public class ToDoMapper {

    public static ToDoDTO ToDoToDTO(ToDo toDo) {
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setId(toDo.getId());
        toDoDTO.setTitle(toDo.getTitle());
        toDoDTO.setDetails(toDo.getDetails());
        toDoDTO.setDate(toDo.getDate());
        toDoDTO.setStatus(toDo.getStatus());
        toDoDTO.setPriority(toDo.getPriority());
        return toDoDTO;
    }

    public static ToDo DTOToToDo(ToDoDTO toDoDTO) {
        ToDo toDo = new ToDo();
        toDo.setId(toDoDTO.getId());
        toDo.setTitle(toDoDTO.getTitle());
        toDo.setDetails(toDoDTO.getDetails());
        toDo.setDate(toDoDTO.getDate());
        toDo.setStatus(toDoDTO.getStatus());
        toDo.setPriority(toDoDTO.getPriority());
        return toDo;
    }

}

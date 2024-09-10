package com.bit.todo.service;

import com.bit.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> post(TodoDto todoDto);

    List<TodoDto> findAll();

    List<TodoDto> deleteById(Long id);

    List<TodoDto> modify(TodoDto todoDto);
}

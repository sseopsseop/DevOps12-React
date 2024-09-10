package com.bit.todo.service.impl;

import com.bit.todo.dto.TodoDto;
import com.bit.todo.entity.Todo;
import com.bit.todo.repository.TodoRepository;
import com.bit.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public List<TodoDto> post(TodoDto todoDto) {
        todoRepository.save(todoDto.toEntity());
        return todoRepository.findAll().stream().map(Todo::toDto).toList();
    }

    @Override
    public List<TodoDto> findAll() {
        return todoRepository.findAll().stream().map(Todo::toDto).toList();
    }

    @Override
    public List<TodoDto> deleteById(Long id) {
        todoRepository.deleteById(id);
        return todoRepository.findAll().stream().map(Todo::toDto).toList();
    }

    @Override
    public List<TodoDto> modify(TodoDto todoDto) {
        todoDto.setChecked(!todoDto.isChecked());

        todoRepository.save(todoDto.toEntity());
        return todoRepository.findAll().stream().map(Todo::toDto).toList();
    }


}

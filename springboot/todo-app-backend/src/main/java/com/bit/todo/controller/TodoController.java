package com.bit.todo.controller;

import com.bit.todo.dto.ResponseDto;
import com.bit.todo.dto.TodoDto;
import com.bit.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody TodoDto todoDto) {
        ResponseDto<TodoDto> responseDto = new ResponseDto<>();

        try {
            List<TodoDto> todoDtoList = todoService.post(todoDto);

            responseDto.setItems(todoDtoList);
            responseDto.setStatusCode(HttpStatus.CREATED.value());
            responseDto.setStatusMessage("created");

            return ResponseEntity.ok(responseDto);
        } catch(Exception e) {
            responseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseDto.setStatusMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(responseDto);
        }
    }

    @GetMapping
    public ResponseEntity<?> getTodos() {
        ResponseDto<TodoDto> responseDto = new ResponseDto<>();

        try {
            List<TodoDto> todoDtoList = todoService.findAll();

            responseDto.setItems(todoDtoList);
            responseDto.setStatusCode(HttpStatus.OK.value());
            responseDto.setStatusMessage("ok");

            return ResponseEntity.ok(responseDto);
        } catch(Exception e) {
            responseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseDto.setStatusMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(responseDto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeTodo(@PathVariable("id") Long id) {
        ResponseDto<TodoDto> responseDto = new ResponseDto<>();

        try {
            List<TodoDto> todoDtoList = todoService.deleteById(id);

            responseDto.setItems(todoDtoList);
            responseDto.setStatusCode(HttpStatus.NO_CONTENT.value());
            responseDto.setStatusMessage("no content");

            return ResponseEntity.ok(responseDto);
        } catch(Exception e) {
            responseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseDto.setStatusMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(responseDto);
        }
    }

    @PatchMapping
    public ResponseEntity<?> modifyTodo(@RequestBody TodoDto todoDto) {
        ResponseDto<TodoDto> responseDto = new ResponseDto<>();

        try {
            List<TodoDto> todoDtoList = todoService.modify(todoDto);

            responseDto.setItems(todoDtoList);
            responseDto.setStatusCode(HttpStatus.OK.value());
            responseDto.setStatusMessage("ok");

            return ResponseEntity.ok(responseDto);
        } catch(Exception e) {
            responseDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            responseDto.setStatusMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(responseDto);
        }
    }






}

package dev.chrisen.todo.controller;

import dev.chrisen.todo.entity.TodoEntity;
import dev.chrisen.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
    value = "/todos",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TodoController {

  private final TodoService service;

  @GetMapping()
  public ResponseEntity getTodos() {
    return new ResponseEntity(service.getTodos(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity getTodo(@PathVariable long id) {
    return new ResponseEntity(service.getTodo(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity createTodo(@RequestBody TodoEntity todo) {
    return new ResponseEntity(service.createTodo(todo), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity updateTodo(@RequestBody TodoEntity todo) {
    return new ResponseEntity(service.updateTodo(todo), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteTodo(@PathVariable long id) {
    service.deleteTodo(id);
    return new ResponseEntity(HttpStatus.OK);
  }

}

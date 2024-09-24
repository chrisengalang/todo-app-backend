package dev.chrisen.todo.service;

import dev.chrisen.todo.dto.TodoDto;
import dev.chrisen.todo.entity.TodoEntity;

import java.util.List;

public interface TodoService {

  TodoDto getTodo(long id);

  List<TodoDto> getTodos();

  TodoDto createTodo(TodoEntity todo);

  TodoDto updateTodo(TodoEntity todo);

  void deleteTodo(long id);

}

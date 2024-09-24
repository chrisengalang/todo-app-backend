package dev.chrisen.todo.service;

import dev.chrisen.todo.dto.TodoDto;
import dev.chrisen.todo.entity.TodoEntity;
import dev.chrisen.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

  private final TodoRepository repository;

  private final ModelMapper mapper;

  @Override
  public TodoDto getTodo(long id) {
    Optional<TodoEntity> optionalTodoEntity = repository.findById(id);

    if (optionalTodoEntity.isPresent()) {
      return mapper.map(optionalTodoEntity.get(), TodoDto.class);
    }

    return null;
  }

  @Override
  public List<TodoDto> getTodos() {
    List<TodoEntity> entities = repository.findAll();

    return entities.stream().map(entity -> mapper.map(entity, TodoDto.class)).collect(Collectors.toList());
  }

  @Override
  public TodoDto createTodo(TodoEntity todo) {
    TodoEntity created = repository.save(todo);
    return mapper.map(created, TodoDto.class);
  }

  @Override
  public TodoDto updateTodo(TodoEntity todo) {
    Optional<TodoEntity> optionalTodoEntity = repository.findById(todo.getId());

    if (optionalTodoEntity.isPresent()) {
      TodoEntity updated = repository.save(todo);
      return mapper.map(updated, TodoDto.class);
    }

    return null;
  }

  @Override
  public void deleteTodo(long id) {
    Optional<TodoEntity> optionalTodoEntity = repository.findById(id);

    if (optionalTodoEntity.isPresent()) {
      repository.deleteById(id);
    }
  }
}

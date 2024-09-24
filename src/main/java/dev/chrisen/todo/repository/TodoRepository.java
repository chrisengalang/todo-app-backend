package dev.chrisen.todo.repository;

import dev.chrisen.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}

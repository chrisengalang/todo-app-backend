package dev.chrisen.todo.dto;

import lombok.Data;

@Data
public class TodoDto {
  private long id;
  private String name;
  private boolean done;
}

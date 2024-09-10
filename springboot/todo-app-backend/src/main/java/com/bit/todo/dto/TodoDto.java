package com.bit.todo.dto;

import com.bit.todo.entity.Todo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {
    private Long id;
    private String text;
    private boolean checked;

    public Todo toEntity() {
        return Todo.builder()
                    .id(this.id)
                    .text(this.text)
                    .checked(this.checked)
                    .build();
    }
}

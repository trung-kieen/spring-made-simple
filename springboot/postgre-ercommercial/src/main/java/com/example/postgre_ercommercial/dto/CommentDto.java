package com.example.postgre_ercommercial.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

/**
 * CommentDto
 */
@Data
public class CommentDto {

  private Long userId;

  @PositiveOrZero
  @NotNull
  private Integer score;

  @NotBlank
  private String content;
}

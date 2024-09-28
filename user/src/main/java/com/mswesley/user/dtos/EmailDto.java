package com.mswesley.user.dtos;

import com.mswesley.user.enums.StatusEmail;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record EmailDto(@NotBlank String ownerRef, @NotBlank String email, @NotBlank String emailTo, @NotBlank String subject , @NotBlank String text){
}

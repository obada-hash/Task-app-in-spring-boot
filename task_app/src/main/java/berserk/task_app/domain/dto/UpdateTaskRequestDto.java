package berserk.task_app.domain.dto;

import berserk.task_app.domain.entity.TaskPriority;
import berserk.task_app.domain.entity.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto(
        @Length(min = 1, max = 320)
        @Nullable
        String title,
        @Length(min = 1, max = 100)
        @Nullable
        String description,
        @FutureOrPresent
        @Nullable
        LocalDate dueDate,
        @Nullable
        TaskStatus status,
        @Nullable
        TaskPriority priority
) {


}

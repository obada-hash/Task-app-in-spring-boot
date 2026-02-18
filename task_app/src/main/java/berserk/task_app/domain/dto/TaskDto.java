package berserk.task_app.domain.dto;

import berserk.task_app.domain.entity.TaskPriority;
import berserk.task_app.domain.entity.TaskStatus;

import java.time.Instant;
import java.time.LocalDate;

public record TaskDto(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority,
        Instant createdDate,
        Instant updatedDate
) {
}

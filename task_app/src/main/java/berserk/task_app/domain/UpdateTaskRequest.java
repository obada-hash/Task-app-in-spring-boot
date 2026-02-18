package berserk.task_app.domain;

import berserk.task_app.domain.entity.TaskPriority;
import berserk.task_app.domain.entity.TaskStatus;
import jakarta.persistence.Column;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}

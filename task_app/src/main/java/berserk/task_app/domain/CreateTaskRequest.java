package berserk.task_app.domain;

import berserk.task_app.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority
) {
}

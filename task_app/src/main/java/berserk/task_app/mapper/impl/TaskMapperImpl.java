package berserk.task_app.mapper.impl;

import berserk.task_app.domain.CreateTaskRequest;
import berserk.task_app.domain.UpdateTaskRequest;
import berserk.task_app.domain.dto.CreateTaskRequestDto;
import berserk.task_app.domain.dto.TaskDto;
import berserk.task_app.domain.dto.UpdateTaskRequestDto;
import berserk.task_app.domain.entity.Task;
import berserk.task_app.domain.entity.TaskStatus;
import berserk.task_app.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getStatus(),
                task.getPriority(),
                task.getCreated(),
                task.getUpdated()
        );
    }

    @Override
    public Task toEntity(CreateTaskRequest request) {
        return Task.builder()
                .title(request.title())
                .description(request.description())
                .dueDate(request.dueDate())
                .status(TaskStatus.OPEN)
                .priority(request.priority())
                .build();
    }

}

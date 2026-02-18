package berserk.task_app.mapper;

import berserk.task_app.domain.CreateTaskRequest;
import berserk.task_app.domain.UpdateTaskRequest;
import berserk.task_app.domain.dto.CreateTaskRequestDto;
import berserk.task_app.domain.dto.TaskDto;
import berserk.task_app.domain.dto.UpdateTaskRequestDto;
import berserk.task_app.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto createTaskRequestDto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto updateTaskRequestDto);

    TaskDto toDto(Task task);

    Task toEntity(CreateTaskRequest request);
}

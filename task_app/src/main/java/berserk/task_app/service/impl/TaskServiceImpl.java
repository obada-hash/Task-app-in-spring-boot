package berserk.task_app.service.impl;


import berserk.task_app.domain.CreateTaskRequest;
import berserk.task_app.domain.UpdateTaskRequest;
import berserk.task_app.domain.entity.Task;
import berserk.task_app.exception.RecordNotFoundException;
import berserk.task_app.mapper.TaskMapper;
import berserk.task_app.mapper.impl.TaskMapperImpl;
import berserk.task_app.repository.TaskRepo;
import berserk.task_app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;
    private final TaskMapper taskMapper;

    @Override
    public List<Task> findAll(){
        return taskRepo.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(int id, UpdateTaskRequest request) {
        Task task = taskRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException(id));
        System.out.println(String.format("Updating task with id %d", id));
        if(request.title() != null && !request.title().isEmpty()) task.setTitle(request.title());
        if(request.description() != null) task.setDescription(request.description());
        if(request.dueDate() != null) task.setDueDate(request.dueDate());
        if(request.priority() != null) task.setPriority(request.priority());
        if(request.status() != null) task.setStatus(request.status());

        return taskRepo.save(task);
    }

    @Override
    public void deleteTask(int id) {
        Task task = taskRepo.findById(id).orElseThrow(
                () -> new RecordNotFoundException(id)
        );
        taskRepo.delete(task);
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        return taskRepo.save(taskMapper.toEntity(request));
    }

}

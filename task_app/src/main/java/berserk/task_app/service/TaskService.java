package berserk.task_app.service;

import berserk.task_app.domain.CreateTaskRequest;
import berserk.task_app.domain.UpdateTaskRequest;
import berserk.task_app.domain.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> findAll();

    Task updateTask(int id, UpdateTaskRequest request);

    void deleteTask(int id);
}

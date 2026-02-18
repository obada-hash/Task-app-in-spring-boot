package berserk.task_app.controller;


import berserk.task_app.domain.UpdateTaskRequest;
import berserk.task_app.domain.dto.CreateTaskRequestDto;
import berserk.task_app.domain.dto.TaskDto;
import berserk.task_app.domain.dto.UpdateTaskRequestDto;
import berserk.task_app.domain.entity.Task;
import berserk.task_app.mapper.TaskMapper;
import berserk.task_app.service.impl.TaskServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;
    private final TaskMapper taskMapper;

    @GetMapping()
    public ResponseEntity<List<TaskDto>> findAll() {
        List<Task> tasks = taskService.findAll();
        List<TaskDto> list = tasks.stream()
                .map(taskMapper::toDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskRequestDto taskRequestDto) {
        Task task = taskService.createTask(taskMapper.fromDto(taskRequestDto));
        TaskDto taskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable int id, @Valid @RequestBody UpdateTaskRequestDto request) {
        UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(request);
        Task task = taskService.updateTask(id, updateTaskRequest);
        TaskDto taskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}

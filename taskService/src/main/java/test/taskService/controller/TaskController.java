package test.taskService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.taskService.task.Task;

import java.util.List;

@RequestMapping("/tasks")
public interface TaskController {
    @PostMapping("/regtaskname/{newtask}")
    public ResponseEntity<String> regTaskName(@PathVariable("newtask") String taskname);
    @GetMapping("/all")
    public ResponseEntity<List<Task>> getTasks();
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long id);
}

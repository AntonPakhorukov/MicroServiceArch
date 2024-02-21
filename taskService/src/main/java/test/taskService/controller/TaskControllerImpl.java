package test.taskService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.taskService.service.TaskService;
import test.taskService.task.Task;

import java.util.List;

@RestController
@RequestMapping("/tasks") // должен обязательно совпадать с интерфейсом
public class TaskControllerImpl implements TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerTask(@RequestBody Task task) {
        taskService.registerTask(task);
        return ResponseEntity.ok(String.format("Задача  \"%s\" успешно зарегистрирована", task.getDescription()));
    }

    @PostMapping("/regtaskname/{taskname}")
    public ResponseEntity<String> regTaskName(@PathVariable("taskname") String taskName) {
        taskService.regTaskName(taskName);
        return ResponseEntity.ok(String.format("Задача с именем \"%s\" зарегистрирована", taskName));
    }

}

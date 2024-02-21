package test.taskService.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.taskService.repository.TaskRepository;
import test.taskService.task.Task;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public String registerTask(Task task) {
//        if (task.getStatus() == null) task.setStatus(Task.Status.Todo);
        taskRepository.save(task);
        return "Задача зарегистрирована";
    }

    public String regTaskName(String taskName) {
        Task task = new Task();
        task.setName(taskName);
        taskRepository.save(task);
        return "Задача зарегистрирована по наименованию";
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(
                        String.format("Задачи с номером %d не найдено", id)));
    }
}

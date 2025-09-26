package com.mogou.controller;

import com.mogou.model.Task;
import com.mogou.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskWebController {

    private final TaskService service;

    public TaskWebController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String list(@RequestParam(value = "status", required = false) Task.Status status, Model model) {
        if (status != null) {
            model.addAttribute("tasks", service.findByStatus(status));
        } else {
            model.addAttribute("tasks", service.findAll());
        }
        model.addAttribute("statuses", Task.Status.values());
        return "tasks/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("statuses", Task.Status.values());
        return "tasks/form";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        service.findById(id).ifPresent(task -> {
            model.addAttribute("task", task);
            model.addAttribute("statuses", Task.Status.values());
        });
        return "tasks/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Task task) {
        service.create(task);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/tasks";
    }
}

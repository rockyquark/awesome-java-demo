package org.keep.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.keep.demo.task.TaskEntrance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 肖锦光
 * @version 0.1.0
 * @note: TODO
 * @date 2023/12/10 14:58
 */
@Slf4j
@RestController
@RequestMapping("task")
public class TaskController {

    private final TaskEntrance taskEntrance;

    @Autowired
    public TaskController(TaskEntrance taskEntrance) {
        this.taskEntrance = taskEntrance;
    }


    @PostMapping("add")
    public ResponseEntity<String> addTask() {
        taskEntrance.producer();
        return ResponseEntity.ok("添加下载任务成功");
    }
}

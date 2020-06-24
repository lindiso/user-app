package com.lindiso.black.swan.manage.users.controller;

import com.lindiso.black.swan.manage.users.dao.*;
import com.lindiso.black.swan.manage.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api")
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

   private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public void createUser(@RequestBody User user){
        if (userService != null){
            userService.createUser(user);
        }
    }

    @PutMapping(value = "/user/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User user){
        if (userService != null){
            userService.updateUser(user, id);
        }
        return "success";
    }

    @GetMapping(value = "/user")
    public List<User> getAllUsers(){
        if (userService != null){
            List<User> users = userService.getAllUsers();
            logger.info("Get Users....... ", users);
            return users;
        }
        return  new ArrayList<>();
    }

    @GetMapping(value = "/user/{id}")
    public Object getUserInfo(@PathVariable String id){
        if (userService != null){
            return userService.getUserInfo(id);
        }
        return new User();
    }

    @PostMapping(value = "/user/{user_Id}/task")
    public void createTask(@PathVariable String user_Id, @RequestBody Task task){
        if (userService != null){
            userService.createTask(task, user_Id);
        }
    }

    @PutMapping(value = "/user/{user_Id}/task/{task_id}")
    public void updateTask(@PathVariable String user_Id, @PathVariable String task_id, @RequestBody Task task){
        if (userService != null){
            userService.updateTask(user_Id, task_id, task);
        }
    }

    @DeleteMapping(value = "/user/{user_Id}/task/{task_id}")
    public void deleteTask(@PathVariable String user_Id, @PathVariable String task_id){
        if (userService != null){
            userService.deleteTask(user_Id, task_id);
        }
    }
    @GetMapping(value = "/user/{user_Id}/task/{task_id}")
    public Task getTaskInfo(@PathVariable String user_Id, @PathVariable String task_id){
        if (userService != null){
            return userService.getTaskInfo(user_Id, task_id);
        }
        return new Task();
    }
    @GetMapping(value = "/user/{user_Id}/task/")
    public List<Task> getAllUserTasks(@PathVariable String user_Id){
        if (userService != null){
            return userService.getAllUserTasks(user_Id);
        }
        return new ArrayList<>();
    }
}

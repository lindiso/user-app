package com.lindiso.black.swan.manage.users.service.impl;


import com.lindiso.black.swan.manage.users.dao.User;
import com.lindiso.black.swan.manage.users.repository.SequenceGeneratorService;
import com.lindiso.black.swan.manage.users.repository.TaskRepository;
import com.lindiso.black.swan.manage.users.dao.*;
import com.lindiso.black.swan.manage.users.repository.UserRepository;
import com.lindiso.black.swan.manage.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserRepository userRepository;

    public TaskRepository taskRepository;

    public SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TaskRepository taskRepository, SequenceGeneratorService sequenceGeneratorService ){
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }


    @Override
    public void createUser(User user) {
      logger.info("User about to create post ......");
        User response = userRepository.save(user);
         logger.info("User details :", response.toString());
    }

    @Override
    public void updateUser(User user, String id) {
        Optional<User> existingUser = userRepository.findById(id);
        logger.info("Update user : " + existingUser.get().toString());
       existingUser.get().setFirstName(user.getFirstName());
       existingUser.get().setLastName(user.getLastName());
       existingUser.get().setUsername(user.getLastName());
       mongoOperations.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserInfo(String id) {
        return userRepository.findById(id);
    }


    @Override
    public void createTask(Task task, String userId) {
        task.setId(sequenceGeneratorService.generateSequence(task.SEQUENCE_NAME));
        taskRepository.save(task);
    }

    @Override
    public void updateTask(String userId, String id, Task task) {
        Task existingTask = taskRepository.findById(Long.parseLong(id));
        logger.info("Task on update :" + existingTask.toString());
        existingTask.setDateTime(task.getDateTime());
        existingTask.setDescription(task.getDescription());
        existingTask.setName(task.getName());
        mongoOperations.save(task);
        logger.info("updated Task :" + existingTask.toString());
    }

    @Override
    public void deleteTask(String userId, String taskId) {
      taskRepository.deleteById(taskId);
    }

    @Override
    public Task getTaskInfo(String taskId, String userId) {
        return taskRepository.findTaskByIdAndUserId(taskId, userId);
    }

    @Override
    public List<Task> getAllUserTasks(String userId) {
        return taskRepository.findTaskByUserId(userId);
    }
}

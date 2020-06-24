package com.lindiso.black.swan.manage.users.service;

import com.lindiso.black.swan.manage.users.dao.User;
import com.lindiso.black.swan.manage.users.dao.*;


import java.util.List;
import java.util.Optional;

public interface UserService {

   void createUser(User user);

   void updateUser(User user, String id);

   List<User> getAllUsers();

   Optional<User> getUserInfo(String id);

   void createTask(Task task, String userId);

   void updateTask(String userId, String taskId, Task task);

   void deleteTask(String userId, String taskId);

   Task getTaskInfo(String userId, String taskId);

   List<Task> getAllUserTasks(String userId);



}

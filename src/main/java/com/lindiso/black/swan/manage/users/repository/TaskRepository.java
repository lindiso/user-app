package com.lindiso.black.swan.manage.users.repository;

import com.lindiso.black.swan.manage.users.dao.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {

    public Task save(Task user);

    public Task findTaskByIdAndUserId(String _id, String userId);

    public List<Task> findTaskByUserId(String userId);

    public Task findById(long _id);



}

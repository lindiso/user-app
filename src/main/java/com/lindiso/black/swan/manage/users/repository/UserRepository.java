package com.lindiso.black.swan.manage.users.repository;

import com.lindiso.black.swan.manage.users.dao.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    public User save(User user);

    public List<User>  findUserByFirstName(String firstName);
}

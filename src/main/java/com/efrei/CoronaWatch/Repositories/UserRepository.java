package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long>{

        User findByEmail(String email);
        User findByUserName(String username);

}

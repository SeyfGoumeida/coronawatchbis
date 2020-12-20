package com.efrei.CoronaWatch.Repositories;

import com.efrei.CoronaWatch.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

        User findByEmail(String email);
        User findByIdUser(long id);

        User findByUserName(String username);
        //******************
        Boolean existsByuserName(String username);
        Boolean existsByEmail(String email);

}

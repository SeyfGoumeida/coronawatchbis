
package com.efrei.CoronaWatch.Controlers;

        import com.efrei.CoronaWatch.Entities.User;
        import com.efrei.CoronaWatch.Repositories.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.transaction.annotation.Propagation;
        import org.springframework.transaction.annotation.Transactional;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersControler {

    UserRepository userRepository;

    @Autowired
    public UsersControler(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @GetMapping("/Users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/Users/AddUser")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addUser(@RequestBody User user) throws Exception {
        userRepository.save(user);

    }
    @PostMapping("/Users/Login")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void Login(@RequestBody User user) throws Exception {
        userRepository.findByEmail(user.getEmail());

    }


}
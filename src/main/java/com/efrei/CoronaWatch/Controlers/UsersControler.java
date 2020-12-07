
package com.efrei.CoronaWatch.Controlers;

        import com.efrei.CoronaWatch.Entities.Redactor;
        import com.efrei.CoronaWatch.Entities.User;
        import com.efrei.CoronaWatch.Entities.UserType;
        import com.efrei.CoronaWatch.Repositories.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.transaction.annotation.Propagation;
        import org.springframework.transaction.annotation.Transactional;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestController;

        import javax.persistence.SecondaryTable;
        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Set;

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
    @GetMapping("/Users/SuperAdmin")
    public User getSuperAdmin(){
        Iterable<User> listOfUsers = getUsers();
        User SuperAdmin = new User();
        for(User user :listOfUsers ){
            if(user.getUserType().equals("SuperAdmin"))
            {
                SuperAdmin = user;
            }
        }
        return SuperAdmin;
    }
    @GetMapping("/Users/Redactors")
    public Iterable<User> getRedactors(){
        Iterable<User> listOfUsers = getUsers();
        List<User> listOfRedactors = new ArrayList<>();
        for(User user :listOfUsers ){
            if(user.getUserType().equals("Redactor"))
            {
                listOfRedactors.add(user);
            }
        }
        return listOfRedactors;
    }
    @GetMapping("/Users/Moderators")
    public Iterable<User> getModerators(){
        Iterable<User> listOfUsers = getUsers();
        List<User> listOfModerators = new ArrayList<>();
        for(User user :listOfUsers ){
            if(user.getUserType().equals("Moderator"))
            {
                listOfModerators.add(user);
            }
        }
        return listOfModerators;
    }
    @GetMapping("/Users/HealthAgents")
    public Iterable<User> getHealthAgents(){
        Iterable<User> listOfUsers = getUsers();
        List<User> listOfHealthAgents = new ArrayList<>();
        for(User user :listOfUsers ){
            if(user.getUserType().equals("HealthAgent"))
            {
                listOfHealthAgents.add(user);
            }
        }
        return listOfHealthAgents;
    }
    @GetMapping("/User")
    public Iterable<User> getUser(@RequestBody User user){
        return userRepository.findByEmail(user.getEmail());
    }



    //---------------POST-------------------------
    @PostMapping("/Users/AddUser")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addUser(@RequestBody User user) throws Exception {
        if (user.getUserType().equals(UserType.SuperAdmin)){
            System.out.println( "There is only one SuperAdmin for this app" );
        }else {
            userRepository.save(user);
        }
    }

    @PostMapping("/Users/Login")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void Login(@RequestBody User user) throws Exception {
        userRepository.findByEmail(user.getEmail());

    }


}
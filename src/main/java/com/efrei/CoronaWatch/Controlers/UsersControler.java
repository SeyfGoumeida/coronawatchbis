
package com.efrei.CoronaWatch.Controlers;

        import com.efrei.CoronaWatch.Entities.User;
import com.efrei.CoronaWatch.Entities.UserType;
import com.efrei.CoronaWatch.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.security.crypto.bcrypt.BCrypt;

@RestController
public class UsersControler {

    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

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
            if(user.getUserType().toString().equals("SuperAdmin"))
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
            if(user.getUserType().toString().equals("Redactor"))
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
            if(user.getUserType().toString().equals("Moderator"))
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
            if(user.getUserType().toString().equals("HealthAgent"))
            {
                listOfHealthAgents.add(user);
            }
        }
        return listOfHealthAgents;
    }
    @GetMapping("/Users/WebUsers")
    public Iterable<User> getWebUsers(){
        Iterable<User> listOfUsers = getUsers();
        List<User> listOfWebUsers = new ArrayList<>();
        for(User user :listOfUsers ){
                if(user.getUserType().toString().equals("WebUser"))
            {
                listOfWebUsers.add(user);
            }
        }
        return listOfWebUsers;
    }

    @GetMapping("/User")
    public User getUser(@RequestParam String email){
        return userRepository.findByEmail(email);
    }


    //----------------DELETE----------------------
    @DeleteMapping("/Users/DeleteUser")

    public void delete(@RequestParam(name = "username") String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) {
            System.out.println( "There is no user with suck username" );
        }
        else {
             userRepository.delete(user);
        }
    }
    //---------------POST-------------------------
    @PostMapping("/Users/AddUser")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void addUser(@RequestBody User user) throws Exception {
        //String passencoded = user.getPassWord();
        //System.out.println( "---------------------------------------" );
        //System.out.println( passencoded );
        //System.out.println( "---------------------------------------" );
        //user.setPassWord(encoder.encode(passencoded));


        if (user.getUserType().equals(UserType.SuperAdmin)){
            System.out.println( "There is only one SuperAdmin for this app" );
        }else {
            User user1 = new User();
            user1.setEmail(user.getEmail());
            user1.setUserName(user.getUserName());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setUserType(user.getUserType());
            user1.setPassWord(encoder.encode(user.getPassWord()));
            userRepository.save(user1);
        }
    }

    @PostMapping("/Login")
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public User Login(@RequestBody String email , String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user != null){
            if (true/*BCrypt.checkpw(user.getPassWord(),password)*/){
                return user;
            }
            else {
                return null;
            }
        } else return null;
    }


}
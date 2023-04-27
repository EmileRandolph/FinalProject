package com.example.checkoutservice.restcontrollers;

import com.example.checkoutservice.objects.User;
import com.example.checkoutservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    private UserRepository userRepo;
    @PostMapping(path="")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        User newuser = new User(user.getUsername(), user.getName(), user.getEmail(),user.getPassword(),user.getAddress());
        userRepo.save(newuser);
    }

    @PostMapping(path="/withoutAddress")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUserWithoutAddress(@RequestBody User user){
        User newuser = new User(user.getUsername(), user.getName(), user.getEmail(),user.getPassword());
        userRepo.save(newuser);
    }

    @PutMapping(path = "/{userID}")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateUser(@RequestBody User user, @PathVariable UUID userID){
        if(user.getUserID()==userID) {
            userRepo.save(user);
        }else throw new NoSuchElementException("The items id's do not match");
    }

    @PutMapping(path = "/updateAddress/{userID}")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateAddressToUser(@RequestBody String address, @PathVariable UUID userID){
        User user = userRepo.findByUserID(userID);
        user.setAddress(address);
        userRepo.save(user);
    }

    @GetMapping(path = "/{userID}")
    @ResponseStatus(code = HttpStatus.OK)
    public User getUserById(@PathVariable UUID userID){
        return userRepo.findByUserID(userID);
    }

    @GetMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getUsers(){
        return userRepo.findAll();
    }
}


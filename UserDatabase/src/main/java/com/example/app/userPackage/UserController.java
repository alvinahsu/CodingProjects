/**
 * Author: Alvin Hsu
 * Date: 9/10/2021
 *
 * File Name: UserController.java
 * Description: This file contains the controller for the database connection.
 * It will use methods from UserService to update the status of the database.
 */

/* Packages */
package com.example.app.userPackage;

/* Imports */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * This class will call methods of userService to update the status of database
 */
@RestController //take care of mapping requests
@RequestMapping(path = "/userdb") //path of mapping
public class UserController {

    private final UserService userService;

    @Autowired //dependency injection
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /**
     * This method will get the users in the userRepository
     *
     * @return list of present users
     */
    @GetMapping
    public List<UserProfile> getUsers(){
        return userService.getUsers();
    }

    /**
     * This method will add users to the userRepository
     *
     * @param userProfile User to be added
     */
    @PostMapping
    public void registerNewUsers(@RequestBody UserProfile userProfile){
        userService.addNewUser(userProfile);
    }

    /**
     * This method will delete users in the userRepository
     *
     * @param userId
     */
    @DeleteMapping(path = "{userId}")
    public void deleteUsers(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }
}

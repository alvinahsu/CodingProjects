/**
 * Author: Alvin Hsu
 * Date: 9/10/2021
 *
 * File Name: UserService.java
 * Description: This file contains the UserService class which handles
 * the adding and deletion of Users from the database/repository.
 */

/* Packages */
package com.example.app.userPackage;

/* Imports */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 * This class contains the methods that are used to add, delete, and get users
 */
@Service //Service provider
public class UserService {

    private final UserRepository userRepository;

    @Autowired //dependency injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * This method will get the users in the userRepository
     *
     * @return list of Users found
     */
    public List<UserProfile> getUsers(){
        return userRepository.findAll();
    }

    /**
     * This method will add new Users to the repository if it hasn't been
     * added already. If it has, it will throw and exception.
     *
     * @param userProfile User to be added
     */
    public void addNewUser(UserProfile userProfile) {
        //Find Users
        Optional<UserProfile> userOptional =
                userRepository.findUserByEmail(userProfile.getEmail());
        //If found, through exception
        if (userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        //Otherwise, add user
        userRepository.save(userProfile);
    }

    /**
     * This method will delete Users from the repository if it is present. If
     * the User is not found, it will throw an exception.
     *
     * @param userId userId of User to delete
     */
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        //If user does not exists, throw exception
        if (!exists){
            throw new IllegalStateException("user with id " + userId
                                                + " does not exist");
        }
        //Otherwise, delete user from repository
        userRepository.deleteById(userId);
    }
}

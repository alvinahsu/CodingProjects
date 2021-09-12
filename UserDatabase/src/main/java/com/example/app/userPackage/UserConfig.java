/**
 * Author: Alvin Hsu
 * Date: 9/10/2021
 *
 * File Name: UserConfig.java
 * Description: This file contains the UserConfig class which is the backbone
 * of the User Database. We are able to directly add user into the database, or
 * send POST request which is saved in the User Repository.
 */

/* Package */
package com.example.app.userPackage;

/* Imports */
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * This class starts the SpringApplications using CommandLineRunner in which we
 * are able to directly add users manually or through POST requests.
 */
@Configuration //User Bean methods and processed by Spring container
public class UserConfig {

    @Bean //Manged by Spring container
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
        };
    }
}

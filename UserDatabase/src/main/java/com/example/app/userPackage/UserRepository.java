/**
 * Author: Alvin Hsu
 * Date: 9/10/2021
 *
 * File Name: UserRepository.java
 * Description: This file contains the UserRepository Interface that is used to
 * store Users, find them, and delete them.
 */

/* Packages */
package com.example.app.userPackage;

/* Imports */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * This interface extends the JpaRepository which contains the full API
 * of CrudRepository and PagingAndSortingRepository.
 */
@Repository //Indicate Repository
public interface UserRepository
        extends JpaRepository<UserProfile, Long> {

    //
    @Query("SELECT u FROM UserProfile u WHERE u.email = ?1")
    //May or may not have value
    Optional<UserProfile> findUserByEmail(String email);
}

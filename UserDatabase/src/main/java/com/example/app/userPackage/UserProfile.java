/**
 * Author: Alvin Hsu
 * Date: 9/10/2021
 *
 * File Name: UserProfile.java
 * Description: This file contains the User class which has the properties of
 * a User in the database.
 */

/* package */
package com.example.app.userPackage;

/* Imports */
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


/**
 * This class is the User class with instance variables: unique id,
 * name, age, date of birth, and email. These are all stored in the database
 * and contains setter and getter methods.
 */
@Entity //specify class is entity and is mapped to database table
@Table
public class UserProfile {
    @Id //primary key of entity
    //How the table is mapped (name, sequenceName, size)
    @SequenceGenerator(
            name = "userdb_sequence",
            sequenceName = "userdb_sequence",
            allocationSize = 1
    )
    //generation strategy
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userdb_sequence"
    )
    private Long id;
    private String name;
    @Transient //don't display age in table
    private Integer age;
    private LocalDate dob;
    private String email;

    /**
     * This is the No-Args Constructor
     */
    public UserProfile() {
    }

    /**
     * This is the Constructor with name, dob, and email of User
     *
     * @param name name of User
     * @param dob date of birth of User
     * @param email email of User
     */
    public UserProfile(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    /**
     * This is the Constructor with id, name, dob, and email of User
     *
     * @param id Id of user
     * @param name name of User
     * @param dob date of birth of User
     * @param email email of User
     */
    public UserProfile(Long id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    /**
     * This method will get the Id of the User
     *
     * @return Id of User
     */
    public Long getId() {
        return id;
    }

    /**
     * This method will set the Id of the User to the input Id
     *
     * @param id new Id of User
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method will get the name of the User
     *
     * @return name of the User
     */
    public String getName() {
        return name;
    }

    /**
     * This method will set the name of the User to the input name
     *
     * @param name new name of User
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method will get the age of the User
     *
     * @return age of the User
     */
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    /**
     * This method will set the age of the User to input age
     *
     * @param age new age of user
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method will return the date of birth of the User
     *
     * @return date of birth of User
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * This method will set the date of birth to the input date of birth
     *
     * @param dob new date of birth
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * This method gets the email of the user
     *
     * @return email of user
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the email to the new email that is passed in
     *
     * @param email new String email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method overrides the toString method to display the information
     * of the User.
     *
     * @return new User String.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}

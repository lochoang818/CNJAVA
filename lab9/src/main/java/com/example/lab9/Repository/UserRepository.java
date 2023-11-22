package com.example.lab9.Repository;

import com.example.lab9.Model.User;
import org.hibernate.annotations.HQLSelect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email like :email and u.password like :pwd")
    public User login(String email, String pwd);

}
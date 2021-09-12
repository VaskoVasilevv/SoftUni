package com.example.xml.reposirtory;

import com.example.xml.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u " +
            "WHERE (SELECT count (p) from Product  p " +
            "WHERE p.seller.id = u.id AND " +
            "p.buyer IS NOT NULL) > 0" +
            "ORDER BY u.lastName , u.firstName")
    List<User>  findAllUserWithMoreThenOneSoldProduct();
}
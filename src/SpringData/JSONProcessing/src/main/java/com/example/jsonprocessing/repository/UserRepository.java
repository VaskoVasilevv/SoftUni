package com.example.jsonprocessing.repository;

import com.example.jsonprocessing.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u " +
            "where (SELECT count(p) from Product p " +
            "where p.seller.id = u.id) > 0 " +
            "ORDER BY u.lastName,u.firstName")
    List<User>  findAllUsersWithMoreThenOneSoldProductsOrderByLastNameThenFirstName();
}

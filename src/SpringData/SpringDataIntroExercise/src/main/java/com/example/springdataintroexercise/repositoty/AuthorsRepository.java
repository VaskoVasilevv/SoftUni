package com.example.springdataintroexercise.repositoty;

import com.example.springdataintroexercise.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorsRepository extends JpaRepository<Author,Long> {
    @Query("SELECT a from Author a order by a.books.size DESC ")
    List<Author> findAllByBooksSizeDESC();
}

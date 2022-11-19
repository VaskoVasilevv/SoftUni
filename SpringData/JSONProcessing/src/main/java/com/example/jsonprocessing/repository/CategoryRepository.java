package com.example.jsonprocessing.repository;

import com.example.jsonprocessing.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("select c from Category c " +
            "order by c.products.size DESC")
    List<Category> getCategoryByProductsCount();


}

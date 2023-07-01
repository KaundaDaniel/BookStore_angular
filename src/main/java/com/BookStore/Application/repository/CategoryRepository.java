package com.BookStore.Application.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.BookStore.Application.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{
}

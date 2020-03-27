package com.featurevote.repositories;

import com.featurevote.domain.Product;
import com.featurevote.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p" + " join fetch p.user" + " where p.id = :id") //solving the lazy loading null value in product table for user_id
    Optional<Product> findByIdWithUser(Long id);

    //using Spring Data to derive query to let it find the products by user
    //such as    select * from product where user = :user;
    List<Product> findByUser(User user);
}

package com.moonwalker.repository;
import com.moonwalker.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long>{


    /** Derived Deleted Methods vs @Query */
    long deleteByName(String name);

    @Modifying
    @Query("delete from Product p where p.name=:name")
    void deleteBooks(@Param("title") String name);

    @Modifying
    @Query("delete from Product p where p.name=:name or p.price=:price")
    List<Integer> deleteFruits(@Param("name") String name, @Param("color") String color);

}

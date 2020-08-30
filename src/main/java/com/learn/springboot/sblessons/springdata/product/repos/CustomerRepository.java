package com.learn.springboot.sblessons.springdata.product.repos;


import com.learn.springboot.sblessons.springdata.product.entities.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByEmailAndFirstnm(String email, String fn);
    List<Customer> findByEmailLike(String email);
    List<Customer> findByIdIn(List<Integer> ids);

    @Query("update Customer set email = :c_email where id = :c_id")
    @Modifying
    void UpdateCustomerEmailById(@Param("c_id") Integer id, @Param("c_email") String email);

}

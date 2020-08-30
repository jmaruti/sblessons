package com.learn.springboot.sblessons.springdata.product.repos;

import com.learn.springboot.sblessons.springdata.product.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

// public interface ProductRepository extends CrudRepository<Product, Integer> {

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByNameAndDescr(String name, String desc);

    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByDescrContains(String descr);

    List<Product> findByPriceBetween(double price1, double price2);

    List<Product> findByDescrLike(String d);

    List<Product> findByIdIn(List<Integer> ids);

    List<Product> findByIdIn(List<Integer> ids, Pageable pageable);

}

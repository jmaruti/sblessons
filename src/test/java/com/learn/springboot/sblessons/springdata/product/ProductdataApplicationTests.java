package com.learn.springboot.sblessons.springdata.product;


import com.learn.springboot.sblessons.springdata.product.entities.Customer;
import com.learn.springboot.sblessons.springdata.product.entities.Product;
import com.learn.springboot.sblessons.springdata.product.repos.CustomerRepository;
import com.learn.springboot.sblessons.springdata.product.repos.ProductRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductdataApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testCreate() {

        Product product = new Product();
        product.setDescr("Apple phone");
        product.setPrice(1.0);
        productRepository.save(product);

        Assertions.assertEquals(6, productRepository.count());
        // productRepository.deleteById(product.getId());
    }

    @Test
    public void testRead() {
        Optional<Product> p = productRepository.findById(1);
        Product product = p.get();
        Assertions.assertEquals("IWatch", product.getName());
    }

    @Test
    public void tesetUpdate() {
        Optional<Product> p = productRepository.findById(1);
        Product product = p.get();
        product.setPrice(1400d);
        productRepository.save(product);

        p = productRepository.findById(1);
        product = p.get();
        Assertions.assertEquals(1400d, product.getPrice());
    }

    @Test
    public void testDelete() {
        if (productRepository.existsById(5))
            productRepository.deleteById(5);

    }

    @Test
    public void testCount() {
        System.out.println(productRepository.count());
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Jay");
        customer.setLastName("Jaganathan");
        customerRepository.save(customer);
    }

    @Test
    public void testFindByName() {
        List<Product> products = productRepository.findByName("IWatch");
        products.forEach(System.out::println);
    }

    @Test
    public void testFindByNameAndDesc() {
        List<Product> products = productRepository.findByNameAndDescr("TV", "From Samsung Inc");
        products.forEach(p -> System.out.println(p.getDescr()));
    }

    @Test
    public void testFindByPriceGreaterThan() {
        List<Product> products = productRepository.findByPriceGreaterThan(20);
        products.forEach(p -> System.out.println(p.getDescr()));
    }

    @Test
    public void testFindByDescrContains() {
        List<Product> products = productRepository.findByDescrContains("Apple");
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindByPriceBetween() {
        List<Product> products = productRepository.findByPriceBetween(2000, 30000);
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindByDescrLike() {
        List<Product> products = productRepository.findByDescrLike("%LG%");
        products.forEach(p -> System.out.println(p.getDescr()));
    }

    @Test
    public void testFindByIdsIn() {
        List<Product> products = productRepository.findByIdIn(Arrays.asList(1, 2,3 ));
        products.forEach(p -> System.out.println(p.getDescr()));
    }

    @Test
    public void testCustomerFindByNameAndEmail() {
        List<Customer> customers = customerRepository.findByEmailAndFirstnm( "jmaruti@gmail.com", "Jay");
        customers.forEach(c -> System.out.println(c.getLastName()));
    }

    @Test
    public void testCustomerFindByEmailLike() {
        List<Customer> customers = customerRepository.findByEmailLike( "%gmail%");
        customers.forEach(c -> System.out.println(c.getLastName()));
    }

    @Test
    public void testCustomerFindByIdIn() {
        List<Customer> customers = customerRepository.findByIdIn(Arrays.asList(2, 3));
        customers.forEach(c -> System.out.println(c.getLastName()));
    }

    @Test
    public void testFindAllPaging() {
        Pageable pageable = PageRequest.of(1, 2);
        Page<Product> products = productRepository.findAll(pageable);
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindAllSorting() {

        productRepository
            .findAll(Sort.by(Sort.Direction.DESC, "name"))
            .forEach(p -> System.out.println(p.getName()));

        productRepository
            .findAll(Sort.by(Sort.Direction.ASC, "name"))
            .forEach(p -> System.out.println(p.getName()));

        productRepository
            .findAll(Sort.by(Sort.Direction.DESC, "name", "price"))
            .forEach(p -> System.out.println(p.getName()));

        productRepository
            .findAll(Sort.by(
            new Sort.Order(Sort.Direction.ASC, "name"),
            new Sort.Order(Sort.Direction.DESC, "price")
            ))
            .forEach(p -> System.out.println(p.getName()));

    }

    @Test
    public void testFindAllPagingAndSorting() {
        Pageable pageable;
        pageable = PageRequest.of(0, 2, Sort.Direction.DESC, "name");
        productRepository.findAll(pageable).forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindAllIdsInPagingAndSorting() {
        Pageable pageable = PageRequest.of(1, 2);
        List<Product> products = productRepository.findByIdIn(Arrays.asList(1,2,3,4), pageable);
        products.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void UpdateCustomerEmailById() {
        customerRepository.findById(1).stream().forEach(c -> System.out.println(c.getEmail()));
        customerRepository.UpdateCustomerEmailById(1, "jmaruti@gmail.com");
        customerRepository.findById(1).stream().forEach(c -> System.out.println(c.getEmail()));
    }

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    // this annotation is required for L1 caching to be enabled.
    // without it, a select is issued every time there is a call to a find method
    public void testCaching() {
        // the following 2 calls will generate just one SELECT
        // if @Transactional is removed, 2 SELECTs can be seen in the console

        final Session unwrap = entityManager.unwrap(Session.class);

        Product product = productRepository.findById(1).get();
        productRepository.findById(1);
        unwrap.evict(product);
        productRepository.findById(1);
    }
}

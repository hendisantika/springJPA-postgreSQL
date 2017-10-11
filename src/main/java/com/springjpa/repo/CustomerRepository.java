package com.springjpa.repo;

import com.springjpa.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * Project : springJPA-postgreSQL
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/10/17
 * Time: 05.43
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
}

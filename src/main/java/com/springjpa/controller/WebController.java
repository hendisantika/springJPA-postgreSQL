package com.springjpa.controller;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springJPA-postgreSQL
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/10/17
 * Time: 05.53
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class WebController {
	@Autowired
	private CustomerRepository repository;

	@GetMapping("/")
	public String index() {
		return "Spring JPA PostgreSQL Example.<br>Waktu saat ini : " + new Date();
	}

	@GetMapping("/save")
	public String process() {
		repository.save(new Customer("Hendi", "Santika"));
		repository.save(new Customer("Uzumaki", "Naruto"));
		repository.save(new Customer("Uchiha", "Sasuke"));
		repository.save(new Customer("Sakura", "Haruno"));
		repository.save(new Customer("Hatake", "Kakashi"));
		repository.save(new Customer("Naara", "Shikamaru"));
		repository.save(new Customer("Aburame", "Shino"));
		repository.save(new Customer("Hyuuga", "Neji"));
		repository.save(new Customer("Hyuuga", "Hinata"));
		repository.save(new Customer("Yamanaka", "Ino"));
		repository.save(new Customer("Akimichi", "Choji"));
		repository.save(new Customer("Inuzuka", "Kiba"));
		repository.save(new Customer("Rock", "Lee"));
		repository.save(new Customer("Sarutobi", "Hiruzen"));
		return "Done";
	}


	@GetMapping("/findAll")
	public Iterable<Customer> findAll() {
		return repository.findAll();
	}

	@GetMapping("/findById")
	public Customer findById(@RequestParam("id") long id) {
		Optional<Customer> resultOpt = repository.findById(id);
		Customer customer = resultOpt.get();
		return customer;
	}

	@GetMapping("/findByLastname")
	public List<Customer> fetchDataByLastName(@RequestParam("lastname") String lastName) {
		return repository.findByLastName(lastName);
	}
}


package com.springjpa.controller;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequiredArgsConstructor
public class WebController {
	private final CustomerRepository customerRepository;

	@GetMapping("/")
	public String index() {
		return "Spring JPA PostgreSQL Example.<br>Waktu saat ini : " + new Date();
	}

	@GetMapping("/save")
	public String process() {
		customerRepository.save(new Customer("Hendi", "Santika"));
		customerRepository.save(new Customer("Uzumaki", "Naruto"));
		customerRepository.save(new Customer("Uchiha", "Sasuke"));
		customerRepository.save(new Customer("Sakura", "Haruno"));
		customerRepository.save(new Customer("Hatake", "Kakashi"));
		customerRepository.save(new Customer("Naara", "Shikamaru"));
		customerRepository.save(new Customer("Aburame", "Shino"));
		customerRepository.save(new Customer("Hyuuga", "Neji"));
		customerRepository.save(new Customer("Hyuuga", "Hinata"));
		customerRepository.save(new Customer("Yamanaka", "Ino"));
		customerRepository.save(new Customer("Akimichi", "Choji"));
		customerRepository.save(new Customer("Inuzuka", "Kiba"));
		customerRepository.save(new Customer("Rock", "Lee"));
		customerRepository.save(new Customer("Sarutobi", "Hiruzen"));
		return "Done";
	}


	@GetMapping("/findAll")
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}

	@GetMapping("/findById")
	public Customer findById(@RequestParam("id") long id) {
		Optional<Customer> resultOpt = customerRepository.findById(id);
		Customer customer = resultOpt.get();
		return customer;
	}

	@GetMapping("/findByLastname")
	public List<Customer> fetchDataByLastName(@RequestParam("lastname") String lastName) {
		return customerRepository.findByLastName(lastName);
	}
}


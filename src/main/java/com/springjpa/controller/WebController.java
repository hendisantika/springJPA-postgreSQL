package com.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.model.Customer;
import com.springjpa.repo.CustomerRepository;

import java.util.Date;

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
	CustomerRepository repository;

	@GetMapping("/")
	String index(){
		return "Spring JPA PostgreSQL Example. \n Waktu saat ini : " + new Date();
	}
	
	@RequestMapping("/save")
	public String process(){
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
	
	
	@RequestMapping("/findAll")
	public String findAll(){
		String result = "<html>";
		
		for(Customer cust : repository.findAll()){
			result += "<div>" + cust.toString() + "</div>";
		}
		
		return result + "</html>";
	}
	
	@RequestMapping("/findById")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}
	
	@RequestMapping("/findByLastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "<html>";
		
		for(Customer cust: repository.findByLastName(lastName)){
			result += "<div>" + cust.toString() + "</div>"; 
		}
		
		return result + "</html>";
	}
}


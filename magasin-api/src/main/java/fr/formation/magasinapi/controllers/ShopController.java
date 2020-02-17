package fr.formation.magasinapi.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.magasinapi.classes.Shop;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {
	
	@PostMapping
	public void userInput(@RequestBody Shop shop ) {
		System.out.println(shop.getCashRegisterVelocity().toString());
	}
	
	

}

package fr.formation.magasinapi.controllers;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.magasinapi.classes.Client;
import fr.formation.magasinapi.classes.Shop;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    @PostMapping
    public void userInput(@Valid @RequestBody Shop shop) {
	int[] items = shop.getItemsByClient();
	Client[] clients = new Client[items.length];
	for (int i = 0; i < items.length; i++) {
	    clients[i] = createClients(items[i]);
	}
	System.out.println(Arrays.toString(clients));
    }

    private Client createClients(int numberOfItems) {
	return new Client(numberOfItems);
    }
}

package fr.formation.magasinapi.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.magasinapi.classes.CashRegister;
import fr.formation.magasinapi.classes.Client;
import fr.formation.magasinapi.classes.Shop;
import fr.formation.magasinapi.utils.Utils;

@RestController
@RequestMapping("/shop")
@CrossOrigin
public class ShopController {

    @PostMapping
    public void userInput(@Valid @RequestBody Shop shop) {
	int[] itemsArr = shop.getItemsByClient();
	int[] velocityArr = shop.getCashRegisterVelocity();
	/*
	 * Creating clients
	 */
	Client[] clients = new Client[itemsArr.length];
	for (int i = 0; i < itemsArr.length; i++) {
	    clients[i] = createClients(itemsArr[i]);
	}
	/*
	 * Creating cash registers with a queue size equal to the total number of
	 * customers
	 */
	CashRegister[] cashRegisters = new CashRegister[velocityArr.length];
	for (int i = 0; i < velocityArr.length; i++) {
	    Client[] queue = new Client[clients.length];
	    cashRegisters[i] = createCashRegister(i + 1, velocityArr[i], 0, queue);
	}
	Utils.dispatch(clients, cashRegisters);
    }

    private Client createClients(int numberOfItems) {
	return new Client(numberOfItems);
    }

    private CashRegister createCashRegister(int number, int velocity, float saturation,
	    Client[] queue) {
	return new CashRegister(number, velocity, saturation, queue);
    }
}

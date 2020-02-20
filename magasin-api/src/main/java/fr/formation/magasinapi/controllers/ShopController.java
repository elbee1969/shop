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
	int[] items = shop.getItemsByClient();
	Client[] clients = new Client[items.length];
	for (int i = 0; i < items.length; i++) {
	    clients[i] = createClients(items[i]);
	}
	// System.out.println(Arrays.toString(clients));
	int[] velocityArr = shop.getCashRegisterVelocity();
	CashRegister[] cashRegisters = new CashRegister[velocityArr.length];
	for (int i = 0; i < velocityArr.length; i++) {
	    cashRegisters[i] = createCashRegister(i + 1, velocityArr[i], 0, new Client[0]);
	}
	// System.out.println(Arrays.toString(cashRegisters));
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

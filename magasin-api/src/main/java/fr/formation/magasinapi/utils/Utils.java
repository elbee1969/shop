package fr.formation.magasinapi.utils;

import java.util.Arrays;

import fr.formation.magasinapi.classes.CashRegister;
import fr.formation.magasinapi.classes.Client;

public final class Utils {

    public static void dispatch(Client[] clients, CashRegister[] cashRegisters) {
	for (int i = 0; i < clients.length; i++) {
	    CashRegister minSaturationCR = findMinSaturation(cashRegisters, clients[i]);
	    Client[] queue = minSaturationCR.getQueue();
	    for (int j = 0; j < queue.length; j++) {
		if (queue[j] == null) {
		    queue[j] = clients[i];
		    break;
		}
	    }
	    float newSaturation = saturationRate(minSaturationCR, clients[i]);
	    minSaturationCR.setSaturation(newSaturation);
	}
	System.out.println("cash registers" + Arrays.toString(cashRegisters));
    }

    public static CashRegister findMinSaturation(CashRegister[] cashRegisters, Client client) {
	CashRegister cr = cashRegisters[0];
	for (int j = 1; j < cashRegisters.length; j++) {
	    if (saturationRate(cr, client) > saturationRate(cashRegisters[j], client)) {
		cr = cashRegisters[j];
	    }
	}
	return cr;
    }

    public static float saturationRate(CashRegister cr, Client client) {
	return cr.getSaturation() + (float) client.getNumberOfItems() / cr.getVelocity();
    }
}

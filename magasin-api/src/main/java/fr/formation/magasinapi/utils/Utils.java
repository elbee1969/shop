package fr.formation.magasinapi.utils;

import java.util.Arrays;

import fr.formation.magasinapi.classes.CashRegister;
import fr.formation.magasinapi.classes.Client;

public final class Utils {

    public static void dispatch(Client[] clients, CashRegister[] cashRegisters) {
	for (int i = 0; i < clients.length; i++) {
	    CashRegister minSaturationCR = findMinSaturation(cashRegisters, clients[i]);
	    Client[] queue = resizeQueue(minSaturationCR.getQueue());
	    queue[queue.length - 1] = clients[i];
	    minSaturationCR.setQueue(queue);
	}
	System.out.println("cash registers" + Arrays.toString(cashRegisters));
    }

    public static CashRegister findMinSaturation(CashRegister[] cashRegisters, Client client) {
	CashRegister cr = cashRegisters[0];
	float bestRate = saturationRate(cr, client);
	for (int j = 1; j < cashRegisters.length; j++) {
	    float rate = saturationRate(cashRegisters[j], client);
	    if (bestRate > rate) {
		cr = cashRegisters[j];
		bestRate = rate;
	    }
	}
	cr.setSaturation(bestRate);
	return cr;
    }

    public static float saturationRate(CashRegister cr, Client client) {
	return cr.getSaturation() + (float) client.getNumberOfItems() / cr.getVelocity();
    }

    public static Client[] resizeQueue(Client[] oldQueue) {
	Client[] newQueue = new Client[oldQueue.length + 1];
	for (int i = 0; i < oldQueue.length; i++) {
	    newQueue[i] = oldQueue[i];
	}
	return newQueue;
    }
}

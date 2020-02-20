package fr.formation.magasinapi.utils;

import java.util.Arrays;

import fr.formation.magasinapi.classes.CashRegister;
import fr.formation.magasinapi.classes.Client;

public final class Utils {

    // Dispatcher steps:
    // 1. iterate over clients
    // 2. check which cash register will
    // handle the client faster by calculating the impact this client will have on
    // each cash reg. and choosing the one with lowest impact (saturation)
    // 3. make the client take the next free place in the line at this cash reg.
    //
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
	}
	/*
	 * lines of clients at cash registers
	 */
	System.out.println("cash registers" + Arrays.toString(cashRegisters));
	System.out.println("\n CHECKOUT \n");
	for (CashRegister cashRegister : cashRegisters) {
	    checkout(cashRegister);
	}
    }

    // Checkout steps:
    // 1. calculate total time a cash reg. would spend on total checkout based on
    // saturation
    // 2. iterate over the queue;
    // at each iteration add client's items to cash reg.'s total items
    // delte the client from the queue
    public static void checkout(CashRegister cashRegister) {
	int itemsTotal = 0;
	String timeTotal = calcTime(cashRegister.getSaturation());
	Client[] queue = cashRegister.getQueue();
	System.out.println("Cash register #" + cashRegister.getNumber());
	// "<=" used to display an empty queue at least once after the iteration is over
	// if a queue contains null, an empty queue will be displayed automatically
	for (int i = 0; i <= queue.length; i++) {
	    System.out.println(Arrays.toString(queue));
	    if (queue[0] != null) {
		itemsTotal += queue[0].getNumberOfItems();
		queue = updateQueue(queue);
	    } else {
		break;
	    }
	}
	System.out.println("items total: " + itemsTotal + ", time total: " + timeTotal);
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

    public static Client[] updateQueue(Client[] queue) {
	for (int i = 0; i < queue.length; i++) {
	    if (queue[i] != null && i < queue.length - 1) {
		queue[i] = queue[i + 1];
	    } else if (i == queue.length - 1) {
		queue[i] = null;
	    } else if (queue[i] == null) {
		break;
	    }
	}
	return queue;
    }

    private static String calcTime(float remainder) {
	int hours = (int) Math.floor(remainder / 60);
	remainder = remainder - hours * 60;
	int minuts = (int) Math.floor(remainder);
	remainder = remainder - minuts;
	int seconds = (int) Math.floor(remainder * 60);
	return hours + "h " + minuts + "min " + seconds + "sec";
    }
}

package fr.formation.magasinapi.utils;

import java.util.Arrays;

import fr.formation.magasinapi.classes.Client;

public final class Utils {

    public static void dispatch(Client[] clients, int[] velocityArr) {
	System.out.println("from dispatch " + Arrays.toString(clients));
    }
}

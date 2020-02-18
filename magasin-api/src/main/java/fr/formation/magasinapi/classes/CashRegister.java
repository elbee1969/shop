package fr.formation.magasinapi.classes;

import java.util.Arrays;

public class CashRegister {

    int number;

    int velocity;

    int[] queue;

    public CashRegister(int number, int velocity, int[] queue) {
	this.number = number;
	this.velocity = velocity;
	this.queue = queue;
    }

    public int getNumber() {
	return number;
    }

    public void setNumber(int number) {
	this.number = number;
    }

    public int getVelocity() {
	return velocity;
    }

    public void setVelocity(int velocity) {
	this.velocity = velocity;
    }

    public int[] getQueue() {
	return queue;
    }

    public void setQueue(int[] queue) {
	this.queue = queue;
    }

    @Override
    public String toString() {
	return "[Caisse numero: " + number + ", velocity: " + velocity
		+ ", line: " + Arrays.toString(queue) + "]";
    }
}

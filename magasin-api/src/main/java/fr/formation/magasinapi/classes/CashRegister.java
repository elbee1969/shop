package fr.formation.magasinapi.classes;

import java.util.Arrays;

public class CashRegister {

    int number;

    int velocity;

    float saturation;

    Client[] queue;

    public CashRegister(int number, int velocity, float saturation, Client[] queue) {
	this.number = number;
	this.velocity = velocity;
	this.saturation = saturation;
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

    public float getSaturation() {
	return saturation;
    }

    public void setSaturation(float saturation) {
	this.saturation = saturation;
    }

    public Client[] getQueue() {
	return queue;
    }

    public void setQueue(Client[] queue) {
	this.queue = queue;
    }

    @Override
    public String toString() {
	return "\n[Caisse numero: " + number + ", velocity: " + velocity + ", saturation: "
		+ saturation + ", line: " + Arrays.toString(queue) + "]";
    }
}

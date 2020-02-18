package fr.formation.magasinapi.classes;

public class CashRegister {

	int number;

	int velocity;

	public CashRegister(int number, int velocity) {
		this.number = number;
		this.velocity = velocity;
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

	@Override
	public String toString() {
		return "Caisse numero = " + number + ", velocity = " + velocity + ".";
	}

}

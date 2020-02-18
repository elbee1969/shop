package fr.formation.magasinapi.classes;

public class Client {

    int numberOfItems;

    public Client(int numberOfItems) {
	this.numberOfItems = numberOfItems;
    }

    public int getNumberOfItems() {
	return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
	this.numberOfItems = numberOfItems;
    }

    @Override
    public String toString() {
	return "Client items=" + numberOfItems;
    }
}

package com.efrei.JPAExample;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicule {
    protected int numberOfSeats;

    public Car(){super();}

    public Car(String plaque , int numberS){
        super(plaque);
        this.numberOfSeats = numberS;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeats=" + numberOfSeats +
                "} " + super.toString();
    }
}

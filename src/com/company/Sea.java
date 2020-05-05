package com.company;

import java.util.Random;

public class Sea implements Runnable {
    private int amountShipsInSea;
    private Tunnel tunnel;

    public Sea(int amountShipsInSea, Tunnel tunnel) {
        this.amountShipsInSea = amountShipsInSea;
        this.tunnel = tunnel;
    }


    @Override
    public void run() {
        while (amountShipsInSea > 0) {
            Ship ship = new Ship(getRandomSize(), getRandomType());
            tunnel.addShip(ship);
            amountShipsInSea--;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void addShips(int amount) {
        amountShipsInSea += amount;
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}

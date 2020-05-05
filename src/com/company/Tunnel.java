package com.company;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {
    private List<Ship> ships;
    private int shipsIn;
    final int maxShips = 7;
    final int minShips = 0;

    public Tunnel() {
        ships = new ArrayList<>();
        shipsIn = 0;
    }

    public boolean isAnyShipsIn(){
        if (shipsIn!=0) return true;
        return false;
    }

    public synchronized boolean addShip(Ship ship) {
        if (shipsIn < maxShips) {
            ships.add(ship);
            shipsIn++;
            notifyAll();
            System.out.println("In tunnel arrived " + ship.getType().toString() +
                    " ship" + ship.getSize() + " size");

        } else {
            try {
                wait();
                System.out.println("There are too many ships in tunnel");
                return false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public synchronized Ship take(Type type) {
        if (shipsIn > minShips) {
            notifyAll();
            for (Ship ship : ships) {
                if (ship.getType() == type) {
                    shipsIn--;
                    ship = ships.get(0);
                    ships.remove(0);
                    System.out.println("One of ships " + ship.getType().toString() +
                            " ship" + ship.getSize() + " size");
                    return ship;
                }
            }
        } else {
            try {
                wait();
                System.out.println("There are no any ships in tunnel");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

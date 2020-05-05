package com.company;


public class Berth implements Runnable {
    private Type type;
    private Tunnel tunnel;

    public Berth(Type type, Tunnel tunnel) {
        this.type = type;
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        while (true) {
            if (tunnel.isAnyShipsIn()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Ship ship = tunnel.take(type);
                while (ship != null && ship.checkGoods()) {
                    ship.addGoods();
                    System.out.println("We loaded some " + type.toString());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No any ships in tunnel");
            }
        }
    }
}

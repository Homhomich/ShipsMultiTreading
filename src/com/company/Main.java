package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        Tunnel tunnel=new Tunnel();
        Sea sea=new Sea(12, tunnel);

        Berth clothesBerth=new Berth(Type.CLOTHES,tunnel);
        Berth clothesBerth2=new Berth(Type.CLOTHES,tunnel);
        Berth foodBerth=new Berth(Type.FOOD,tunnel);
        Berth spiceBerth=new Berth(Type.SPICE,tunnel);



        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(sea);
        service.execute(clothesBerth);
        service.execute(clothesBerth2);
        service.execute(foodBerth);
        service.execute(spiceBerth);

        service.shutdown();
    }
}

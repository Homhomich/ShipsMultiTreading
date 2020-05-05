package com.company;

public class Ship {
    private Size size;
    private Type type;
    private int amountOfGoods;

    public Ship(Size size, Type type) {
        this.size = size;
        this.type = type;
        amountOfGoods = 0;
    }

    public void addGoods() {
        amountOfGoods += 10;
    }

    public Size getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    public int getAmountOfGoods() {
        return amountOfGoods;
    }

    public boolean checkGoods() {
        switch (size) {
            case SMALL:
                if (amountOfGoods <= 10) return true;
            case LARGE:
                if (amountOfGoods <= 150) return true;
            case MIDDLE:
                if (amountOfGoods <= 60) return true;
        }
        return false;
    }

}

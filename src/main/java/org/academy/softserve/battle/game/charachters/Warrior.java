package org.academy.softserve.battle.game.charachters;

public class Warrior {
    private int health = 50;

    public boolean isAlive() {
        return health > 0;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int attack() {
        int attack = 5;
        return attack;
    }
}
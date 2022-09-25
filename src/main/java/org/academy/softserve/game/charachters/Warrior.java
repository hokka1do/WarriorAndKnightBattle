package org.academy.softserve.game.charachters;

import java.util.Collections;
import java.util.List;

public class Warrior {
    //Fields
    private static final int WARRIOR_HEALTH = 50;
    private static final int ATTACK = 5;
    private int health;

    public Warrior() {
        this(WARRIOR_HEALTH);
    }

    protected Warrior(int health) {
        this.health = health;
    }

    //Methods

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public List<Warrior> selectTarget(Army enemyArmy) {
        return Collections.singletonList(enemyArmy.getFrontier().getWarrior());
    }

    public void hit(List<Warrior> targetList) {
        targetList.get(0).receiveDamage(getAttack());
    }

    public int receiveDamage(int attack) {
        setHealth(getHealth() - attack);
        return attack;
    }
    //Getters and setters

    public int getAttack() {
        return ATTACK;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected int getMaxHealth() {
        return WARRIOR_HEALTH;
    }
}
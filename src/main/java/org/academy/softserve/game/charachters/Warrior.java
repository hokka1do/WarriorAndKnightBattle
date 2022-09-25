package org.academy.softserve.game.charachters;

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

    public void hit(Warrior otherWarrior) {
        otherWarrior.receiveDamage(getAttack());
    }

    public void receiveDamage(int attack) {
        setHealth(getHealth() - attack);
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
}
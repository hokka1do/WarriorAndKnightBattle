package org.academy.softserve.game.charachters;

public class Healer extends Warrior implements Heal {

    private static final int HEALER_HEALTH = 60;
    private static final int ATTACK = 0;
    private static final int HEAL_POWER = 2;

    public Healer() {
        super(HEALER_HEALTH);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void heal(Warrior warrior) {
        int currentHealth = warrior.getHealth();
        int maxHealth = warrior.getMaxHealth();
        warrior.setHealth(Math.min(maxHealth, currentHealth + HEAL_POWER));
    }
}

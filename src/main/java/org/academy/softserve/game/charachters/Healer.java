package org.academy.softserve.game.charachters;

import org.academy.softserve.game.weapons.Weapon;

public class Healer extends Warrior implements Heal {

    private static final int HEALER_HEALTH = 60;
    private static final int ATTACK = 0;
    private static final int HEAL_POWER = 2;

    public Healer() {
        super(HEALER_HEALTH, ATTACK);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void heal(Warrior warrior) {
        int currentHealth = warrior.getHealth();
        int maxHealth = warrior.getMaxHealth();
        warrior.setHealth(Math.min(maxHealth, getHeal(currentHealth)));
    }

    public int getHeal(int currentHealth) {
        return currentHealth + getHealPower();
    }


    @Override
    protected int getMaxHealth() {
        return HEALER_HEALTH + getBonusHealthFromWeapons();
    }

    private int getBonusHealingFromWeapons() {
        return weapons.stream()
                .mapToInt(Weapon::getHealPower)
                .sum();
    }

    public int getHealPower() {
        return HEAL_POWER + getBonusHealingFromWeapons();
    }
}
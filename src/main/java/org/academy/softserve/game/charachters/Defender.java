package org.academy.softserve.game.charachters;

public class Defender extends Warrior {
    private static final int DEFENDER_HEALTH = 60;
    private static final int DEFENSE = 2;
    private static final int ATTACK = 3;


    public Defender() {
        super(DEFENDER_HEALTH);
    }

    protected int getDefense() {
        return DEFENSE;
    }

    @Override
    public int receiveDamage(int attack) {
        int damage = Math.max(0, attack - getDefense());
        return super.receiveDamage(damage);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    protected int getMaxHealth() {
        return DEFENDER_HEALTH;
    }
}
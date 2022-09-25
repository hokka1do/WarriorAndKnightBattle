package org.academy.softserve.game.charachters;

public class Defender extends Warrior {
    private static final int DEFENSE = 2;
    private static final int ATTACK = 3;

    public Defender() {
        super(60);
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
}
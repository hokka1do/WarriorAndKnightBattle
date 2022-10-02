package org.academy.softserve.game.charachters;

import org.academy.softserve.game.weapons.Weapon;

public class Defender extends Warrior {
    private static final int DEFENDER_HEALTH = 60;
    private static final int ATTACK = 3;
    private static final int DEFENCE = 2;

    public Defender() {
        super(DEFENDER_HEALTH, ATTACK);
    }

    protected int getDefense() {
        return DEFENCE + getBonusDefenceFromWeapons();
    }

    private int getBonusDefenceFromWeapons() {
        return weapons.stream()
                .mapToInt(Weapon::getDefence)
                .sum();
    }

    @Override
    public int receiveDamage(int attack) {
        int damage = Math.max(0, attack - getDefense());
        return super.receiveDamage(damage);
    }

    @Override
    public int getAttack() {
        return ATTACK + getBonusAttackFromWeapons();
    }

    @Override
    protected int getMaxHealth() {
        return DEFENDER_HEALTH + getBonusHealthFromWeapons();
    }

}
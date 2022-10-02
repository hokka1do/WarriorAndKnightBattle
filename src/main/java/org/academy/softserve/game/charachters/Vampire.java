package org.academy.softserve.game.charachters;

import org.academy.softserve.game.weapons.Weapon;

import java.util.List;

public class Vampire extends Warrior {

    public static final int VAMPIRE_HEALTH = 40;
    private static final int ATTACK = 4;

    private static final double INITIAL_VAMPIRISM = 50;

    public Vampire() {
        super(VAMPIRE_HEALTH, ATTACK);
    }

    @Override
    public void hit(List<Warrior> otherWarrior) {
        int inflictedDamage = otherWarrior.get(0).receiveDamage(getAttack());
        int healthRegen = (int) Math.round(inflictedDamage * getVampirism());
        setHealth(Math.min(getMaxHealth(), getHealth() + healthRegen));
    }

    public double getVampirism() {
        double checkingVampirismLimit = (INITIAL_VAMPIRISM + getBonusVampirismFromWeapons()) / 100;
        return checkingVampirismLimit > 1 ? 1 : Math.max(0, checkingVampirismLimit);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    protected int getMaxHealth() {
        return VAMPIRE_HEALTH + getBonusHealthFromWeapons();
    }

    private int getBonusVampirismFromWeapons() {
        return weapons.stream()
                .mapToInt(Weapon::getVampirism)
                .sum();
    }
}

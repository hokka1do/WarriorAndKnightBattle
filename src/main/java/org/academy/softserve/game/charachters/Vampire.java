package org.academy.softserve.game.charachters;

public class Vampire extends Warrior {

    public static final int VAMPIRE_HEALTH = 40;
    private static final int ATTACK = 4;

    private static final double VAMPIRISM = 0.5;

    public Vampire() {
        super(VAMPIRE_HEALTH);
    }

    @Override
    public void hit(Warrior otherWarrior) {
        int inflictedDamage = otherWarrior.receiveDamage(getAttack());
        int healthRegen = (int) Math.floor(inflictedDamage * VAMPIRISM);
        setHealth(Math.min(VAMPIRE_HEALTH, getHealth() + healthRegen));
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }
}

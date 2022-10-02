package org.academy.softserve.game.weapons;

public class MagicWand extends Weapon {
    private static final int HEALTH = 30;
    private static final int ATTACK = 3;
    private static final int HEAL_POWER = 3;

    public MagicWand() {
        this.setHealth(HEALTH);
        this.setAttack(ATTACK);
        this.setHealPower(HEAL_POWER);
    }
}

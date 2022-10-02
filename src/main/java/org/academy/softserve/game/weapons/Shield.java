package org.academy.softserve.game.weapons;

public class Shield  extends Weapon{
    private static final int SHIELD_HEALTH = 20;
    private static final int ATTACK = -1;
    private static final int DEFENCE = 2;

    public Shield() {
        this.setHealth(SHIELD_HEALTH);
        this.setAttack(ATTACK);
        this.setDefence(DEFENCE);
    }
}

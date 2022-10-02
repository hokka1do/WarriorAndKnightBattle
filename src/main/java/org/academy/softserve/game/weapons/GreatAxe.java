package org.academy.softserve.game.weapons;

public class GreatAxe extends Weapon{
    private static final int HEALTH = -15;
    private static final int ATTACK = 5;
    private static final int DEFENCE = -2;
    private static final int VAMPIRISM = 10;

    public GreatAxe() {
        this.setHealth(HEALTH);
        this.setAttack(ATTACK);
        this.setDefence(DEFENCE);
        this.setVampirism(VAMPIRISM);
    }
}

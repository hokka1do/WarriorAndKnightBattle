package org.academy.softserve.game.weapons;

public class Katana extends Weapon {
    private static final int HEALTH = -20;
    private static final int ATTACK = 6;
    private static final int DEFENCE = -5;
    private static final int VAMPIRISM = 50;

    public Katana() {
        this.setHealth(HEALTH);
        this.setAttack(ATTACK);
        this.setDefence(DEFENCE);
        this.setVampirism(VAMPIRISM);
    }
}

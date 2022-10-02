package org.academy.softserve.game.weapons;

import lombok.Getter;


@Getter
public class Sword extends Weapon {

    private static final int WEAPON_HEALTH = 5;
    private static final int ATTACK = 2;

    public Sword() {
        this.setHealth(WEAPON_HEALTH);
        this.setAttack(ATTACK);
    }
}

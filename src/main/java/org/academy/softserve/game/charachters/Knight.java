package org.academy.softserve.game.charachters;

public class Knight extends Warrior {

    private static final int KNIGHT_ATTACK = 7;

    @Override
    public int getAttack() {
        return getBonusAttackFromWeapons() + KNIGHT_ATTACK;
    }
}

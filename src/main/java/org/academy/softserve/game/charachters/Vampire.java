package org.academy.softserve.game.charachters;

public class Vampire extends Warrior {

    private static final int ATTACK = 4;

    private static final double VAMPIRISM = 0.5;

    public Vampire() {
        super(40);
    }

    protected double getVampirism() {
        return VAMPIRISM;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void receiveDamage(int attack) {
        super.receiveDamage(attack);
        //TODO implement
    }

    @Override
    public void hit(Warrior otherWarrior) {
        otherWarrior.receiveDamage(getAttack());
        if (otherWarrior.getClass().toString().equals("Defender")) {
            double increasingHealthByVampirism = (otherWarrior.getAttack() - 2) * VAMPIRISM;
            if (super.getHealth() < 40) {
                super.setHealth(getHealth() + (int) increasingHealthByVampirism);
            }
        } else {
            //TODO implement
        }
        if (super.getHealth() > 40) {
            super.setHealth(40);
        }
    }
}

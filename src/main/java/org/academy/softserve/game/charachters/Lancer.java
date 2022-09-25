package org.academy.softserve.game.charachters;

import java.util.Arrays;
import java.util.List;

public class Lancer extends Warrior {
    private final static int ATTACK = 6;
    private final static double PIERCE_DAMAGE_REDUCTION = 0.5;

    @Override
    public List<Warrior> selectTarget(Army enemyArmy) {
        ArmyUnit<Warrior> mainTarget = enemyArmy.getFrontier();
        return Arrays.asList(mainTarget.getWarrior(), mainTarget.getNext().getWarrior());
    }

    @Override
    public void hit(List<Warrior> targetList) {
        Warrior mainTarget = targetList.get(0);
        int mainDamage = mainTarget.receiveDamage(getAttack());
        Warrior secondaryTarget = targetList.get(1);
        if (secondaryTarget.isAlive())
            secondaryTarget.receiveDamage((int) Math.floor(mainDamage * PIERCE_DAMAGE_REDUCTION));
    }
}

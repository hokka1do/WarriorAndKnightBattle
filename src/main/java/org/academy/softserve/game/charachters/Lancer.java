package org.academy.softserve.game.charachters;

import java.util.ArrayList;
import java.util.List;

public class Lancer extends Warrior {
    private static final int ATTACK = 6;
    private static final double PIERCE_DAMAGE_REDUCTION = 0.5;

    @Override
    public List<Warrior> selectTarget(Army enemyArmy) {
        ArrayList<Warrior> targets = new ArrayList<>();
        ArmyUnit<Warrior> mainTarget = enemyArmy.getFrontier();
        targets.add(mainTarget.getWarrior());
        if (mainTarget.getNext() != null) {
            targets.add(mainTarget.getNext().getWarrior());
        }
        return targets;
    }

    @Override
    public void hit(List<Warrior> targetList) {
        Warrior mainTarget = targetList.get(0);
        int mainDamage = mainTarget.receiveDamage(getAttack());
        if (targetList.size() > 1 && targetList.get(1).isAlive()) {
            targetList.get(1).receiveDamage((int) Math.floor(mainDamage * PIERCE_DAMAGE_REDUCTION));
        }
    }

    @Override
    public int getAttack() {
        return ATTACK + getBonusAttackFromWeapons();
    }
}

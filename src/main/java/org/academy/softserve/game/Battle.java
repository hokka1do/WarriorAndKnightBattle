package org.academy.softserve.game;

import org.academy.softserve.game.charachters.ArmyUnit;
import org.academy.softserve.game.charachters.Warrior;
import org.academy.softserve.game.charachters.Army;

import java.util.Collections;
import java.util.List;

public class Battle {

    public boolean fight(Warrior attackingUnit, Warrior defendingUnit) {
        while (attackingUnit != null && attackingUnit.isAlive() && defendingUnit != null && defendingUnit.isAlive()) {
            attackingUnit.hit(Collections.singletonList(defendingUnit));
            if (defendingUnit.isAlive()) {
                defendingUnit.hit(Collections.singletonList(attackingUnit));
            }
        }
        return attackingUnit != null && attackingUnit.isAlive();
    }

    public boolean fight(Army attackingArmy, Army defendingArmy) {
        while (attackingArmy.isAlive() && defendingArmy.isAlive()) {
            final Warrior attackingWarrior = attackingArmy.getFrontier().getWarrior();
            final Warrior defendingWarrior = defendingArmy.getFrontier().getWarrior();
            List<Warrior> attackerTargets = attackingWarrior.selectTarget(defendingArmy);
            attackingWarrior.hit(attackerTargets);
            attackingArmy.healAll();
            if (defendingWarrior.isAlive()) {
                List<Warrior> defenderTargets = defendingWarrior.selectTarget(attackingArmy);
                defendingWarrior.hit(defenderTargets);
                defendingArmy.healAll();
            }
        }
        return attackingArmy.isAlive();
    }

    public boolean straightFight(Army attackingArmy, Army defendingArmy) {
        while (attackingArmy.isAlive() && defendingArmy.isAlive()) {
            ArmyUnit<Warrior> attackingArmyUnit = attackingArmy.getFrontier();
            ArmyUnit<Warrior> defendingArmyUnit = defendingArmy.getFrontier();
            Warrior attackingWarrior = attackingArmy.getFrontier().getWarrior();
            Warrior defendingWarrior = defendingArmy.getFrontier().getWarrior();
            duelFight(attackingArmyUnit, defendingArmyUnit, attackingWarrior, defendingWarrior);
        }
        return attackingArmy.isAlive();
    }

    private void duelFight(ArmyUnit<Warrior> attackingArmyUnit, ArmyUnit<Warrior> defendingArmyUnit, Warrior attackingWarrior, Warrior defendingWarrior) {
        do {
            fight(attackingWarrior, defendingWarrior);
            attackingWarrior = attackingArmyUnit.getNextAlive().map(ArmyUnit::getWarrior).orElse(null);
            defendingWarrior = defendingArmyUnit.getNextAlive().map(ArmyUnit::getWarrior).orElse(null);
        }
        while (attackingWarrior != null && defendingWarrior != null);
    }
}
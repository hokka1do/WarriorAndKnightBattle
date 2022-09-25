package org.academy.softserve.game;

import org.academy.softserve.game.charachters.Warrior;
import org.academy.softserve.game.charachters.Army;

import java.util.Collections;
import java.util.List;

public class Battle {

    public boolean fight(Warrior attacker, Warrior defender) {
        while (attacker.isAlive() && defender.isAlive()) {
            attacker.hit(Collections.singletonList(defender));
            if (defender.isAlive()) {
                defender.hit(Collections.singletonList(attacker));
            }
        }
        return attacker.isAlive();
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
}
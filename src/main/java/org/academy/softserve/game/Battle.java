package org.academy.softserve.game;

import org.academy.softserve.game.charachters.Warrior;
import org.academy.softserve.game.charachters.Army;

public class Battle {

    public boolean fight(Warrior attacker, Warrior defender) {
        while (attacker.isAlive() && defender.isAlive()) {
            attacker.hit(defender);
            if (defender.isAlive()) {
                defender.hit(attacker);
            }
        }
        return attacker.isAlive();
    }

    public boolean fight(Army attackingArmy, Army defendingArmy) {
        while (attackingArmy.isNotEmpty() && defendingArmy.isNotEmpty()) {
            final Warrior attackingWarrior = attackingArmy.getWarrior();
            final Warrior defendingWarrior = defendingArmy.getWarrior();
            final boolean warriorFightResult = this.fight(attackingWarrior, defendingWarrior);
            if (warriorFightResult) {
                defendingArmy.looseArmyUnit(defendingWarrior);
            } else {
                attackingArmy.looseArmyUnit(attackingWarrior);
            }
        }
        return attackingArmy.isNotEmpty();
    }
}
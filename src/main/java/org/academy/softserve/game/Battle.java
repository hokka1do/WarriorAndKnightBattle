package org.academy.softserve.game;

import org.academy.softserve.game.charachters.Warrior;
import org.academy.softserve.game.charachters.Army;

public class Battle {
    public static boolean fight(Warrior attacker, Warrior defender) {
        while (attacker.isAlive() && defender.isAlive()) {
            attacker.hit(defender);
            if (defender.isAlive()) {
                defender.hit(attacker);
            }
        }
        return attacker.isAlive();
    }

    public Battle() {
        //NOP
    }

    public static boolean armyFight(Army attackingArmy, Army defendingArmy) {
        while (attackingArmy.isNotEmpty() && defendingArmy.isNotEmpty()) {
            final Warrior attackingWarrior = attackingArmy.getWarrior();
            final Warrior defendingWarrior = defendingArmy.getWarrior();
            final boolean warriorFightResult = Battle.fight(attackingWarrior, defendingWarrior);
            if (warriorFightResult) {
                defendingArmy.looseArmyUnit(defendingWarrior);
            } else {
                attackingArmy.looseArmyUnit(attackingWarrior);
            }
        }
        return attackingArmy.isNotEmpty();
    }
}
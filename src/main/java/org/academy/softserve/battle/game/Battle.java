package org.academy.softserve.battle.game;

import org.academy.softserve.battle.game.charachters.Warrior;

public class Battle {
    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior2.setHealth(warrior2.getHealth() - warrior1.attack());
            warrior1.setHealth(warrior1.getHealth() - warrior2.attack());
        }
        return warrior1.isAlive();
    }
}
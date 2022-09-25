package org.academy.softserve.game.charachters;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Supplier;

public class Army {
    Collection<Warrior> armyOfUnits = new LinkedList<>();

    public Army addUnits(Supplier<Warrior> unitFactory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            armyOfUnits.add(unitFactory.get());
        }
        return this;
    }

    public boolean isNotEmpty() {
        return armyOfUnits.iterator().hasNext();
    }

    public Warrior getWarrior() {
        return armyOfUnits.iterator().next();
    }

    public void looseArmyUnit(Warrior deadWarrior) {
        armyOfUnits.remove(deadWarrior);
    }
}

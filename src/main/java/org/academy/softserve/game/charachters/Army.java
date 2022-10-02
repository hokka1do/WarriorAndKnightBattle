package org.academy.softserve.game.charachters;

import java.util.function.Supplier;

public class Army {
    private ArmyUnit<Warrior> firstArmyUnit;
    private ArmyUnit<Warrior> lastArmyUnit;

    public Army addUnits(Supplier<Warrior> unitSupplier, int quantity) {
        for (int i = 0; i < quantity; i++) {
            ArmyUnit<Warrior> conscript = new ArmyUnit<>(unitSupplier.get());
            if (firstArmyUnit == null) {
                firstArmyUnit = conscript;
            } else {
                this. lastArmyUnit.setNext(conscript);
                conscript.setPrevious(lastArmyUnit);
            }
            lastArmyUnit = conscript;
        }
        return this;
    }

    public boolean isAlive() {
        if (firstArmyUnit == null && lastArmyUnit == null) {
            return false;
        }
        return getFrontier() != null;
    }

    public ArmyUnit<Warrior> getFrontier() {
        ArmyUnit<Warrior> currentArmyUnit = this.firstArmyUnit;
        do {
            if (isAlive(currentArmyUnit)) {
                return currentArmyUnit;
            } else if (currentArmyUnit != null) {
                currentArmyUnit = currentArmyUnit.getNext();
            }
        } while (currentArmyUnit != null);
        return null;
    }

    private boolean isAlive(ArmyUnit<Warrior> currentArmyUnit) {
        return currentArmyUnit != null &&
                currentArmyUnit.getWarrior() != null &&
                currentArmyUnit.getWarrior().isAlive();
    }


    public void healAll() {
        ArmyUnit<Warrior> currentArmyUnit = this.firstArmyUnit;
        do {
            if (isAlive(currentArmyUnit) && currentArmyUnit.getWarrior() instanceof Heal) {
                ((Heal) currentArmyUnit.getWarrior()).heal(currentArmyUnit.getPrevious().getWarrior());
            }
            if (currentArmyUnit != null) {
                currentArmyUnit = currentArmyUnit.getNext();
            }
        } while (currentArmyUnit != null);
    }
}
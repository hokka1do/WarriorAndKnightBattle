package org.academy.softserve.game.charachters;

import java.util.List;
import java.util.Optional;

public class ArmyUnit<T extends Warrior> {
    private ArmyUnit<T> next;
    private ArmyUnit<T> previous;
    private final Warrior warrior;


    public ArmyUnit(Warrior warrior) {
        this.warrior = warrior;
    }

    public ArmyUnit<T> getNext() {
        return next;
    }

    void setNext(ArmyUnit<T> armyUnit) {
        this.next = armyUnit;
    }

    public ArmyUnit<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ArmyUnit<T> previous) {
        this.previous = previous;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public Optional<ArmyUnit<T>>  getNextAlive() {
        if (getNext() == null) {
            return Optional.empty();
        } else if (getNext().getWarrior().isAlive()) {
            return Optional.of(getNext());
        } else {
            return getNext().getNextAlive();
        }
    }
}

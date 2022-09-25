package org.academy.softserve.game.charachters;

public class ArmyUnit<T extends Warrior> {
    private ArmyUnit<T> next;
    private ArmyUnit<T> previous;
    private final Warrior warrior;

    public ArmyUnit(Warrior warrior) {
        this.warrior = warrior;
    }

    public ArmyUnit<T> getNext(){
        return next;
    }

    void setNext(ArmyUnit<T> armyUnit){
        this.next = armyUnit;
    }

    public ArmyUnit<T> getPrevious(){
        return previous;
    }

    public void setPrevious(ArmyUnit<T> previous) {
        this.previous = previous;
    }

    public Warrior getWarrior() {
        return warrior;
    }
}

package org.academy.softserve.game.charachters;

import org.academy.softserve.game.weapons.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Warrior {

    //Fields
    private static final int INITIAL_HEALTH = 50;
    private static final int INITIAL_ATTACK = 5;
    private int health;

    protected final List<Weapon> weapons = new ArrayList<>();

    public Warrior() {
        weapons.add(new Weapon());
    }

    public Warrior(int healerHealth, int attack) {
    }

    //Methods
    public boolean isAlive() {
        return getHealth() > 0;
    }

    public boolean isDead() {
        return !isAlive();
    }

    public List<Warrior> selectTarget(Army enemyArmy) {
        return Collections.singletonList(enemyArmy.getFrontier().getWarrior());
    }

    public void hit(List<Warrior> targetList) {
        targetList.get(0).receiveDamage(getAttack());
    }

    public int receiveDamage(int attack) {
        setHealth(getHealth() - attack);
        return attack;
    }

    public void equipWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    //Getters and setters
    public int getAttack() {
        return INITIAL_ATTACK + getBonusAttackFromWeapons();
    }

    protected int getBonusAttackFromWeapons() {
        return weapons.stream()
                .mapToInt(Weapon::getAttack)
                .sum();
    }

    protected int getBonusHealthFromWeapons() {
        return weapons.stream()
                .mapToInt(Weapon::getHealth)
                .sum();
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected int getMaxHealth() {
        return INITIAL_HEALTH + getBonusHealthFromWeapons();
    }
}
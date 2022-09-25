package org.academy.softserve.game;

import org.academy.softserve.game.charachters.Army;
import org.academy.softserve.game.charachters.Defender;
import org.academy.softserve.game.charachters.Knight;
import org.academy.softserve.game.charachters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArmyBattleTest {

    private final Battle battle = new Battle();

    @Test
    @DisplayName("1. Battle armies.")
    void FirstTestArmyWithSameAMountOfWarriors() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior::new, 10);
        army2.addUnits(Warrior::new, 10);

        assertTrue(battle.fight(army1, army2));
    }

    @Test
    @DisplayName("2. Battle armies.")
    void SecondTestArmySecondArmyShouldWin() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Warrior::new, 10);
        army2.addUnits(Knight::new, 9);

        assertFalse(battle.fight(army1, army2));
    }

    @Test
    @DisplayName("3. Battle armies.")
    void ThirdTestOfDifferentVariantsOfArmies() {
        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 20);
        army3.addUnits(Knight::new, 5);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 30);

        assertTrue(battle.fight(myArmy, enemyArmy));
        assertFalse(battle.fight(army3, army4));
        assertTrue(battle.fight(myArmy, army4));
    }

    @Test
    @DisplayName("Defenders involved in army battle")
    void FourthTestWithDefendersInTheArmy() {
        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Defender::new, 1);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 2);

        assertFalse(battle.fight(myArmy, enemyArmy));
        assertTrue(battle.fight(army3, army4));
    }

    @Test
    @DisplayName("Defenders involved in army battle")
    void FifthTestWithDefendersInTheArmy() {
        var army1 = new Army();
        army1.addUnits(Warrior::new, 5);
        army1.addUnits(Defender::new, 4);
        army1.addUnits(Defender::new, 5);

        var army2 = new Army();
        army2.addUnits(Warrior::new, 5);
        army2.addUnits(Defender::new, 5);

        var army3 = new Army();
        army3.addUnits(Defender::new, 5);
        army3.addUnits(Warrior::new, 20);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 22);
        army3.addUnits(Defender::new, 4);

        var army5 = new Army();
        army5.addUnits(Warrior::new, 10);
        army5.addUnits(Defender::new, 5);

        var army6 = new Army();
        army6.addUnits(Warrior::new, 10);
        army6.addUnits(Defender::new, 5);

        var army7 = new Army();
        army7.addUnits(Defender::new, 2);
        army7.addUnits(Warrior::new, 1);
        army7.addUnits(Defender::new, 1);

        var army8 = new Army();
        army8.addUnits(Warrior::new, 5);

        assertTrue(battle.fight(army1, army2));
        assertTrue(battle.fight(army3, army4));
        assertTrue(battle.fight(army5, army6));
        assertFalse(battle.fight(army7, army8));
    }
}
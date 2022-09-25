package org.academy.softserve.game;

import org.academy.softserve.game.charachters.Knight;
import org.academy.softserve.game.charachters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest extends Battle {
    @Test
    @DisplayName("testNo1 : Common tests")
    void testNo1() {
        //Arrange - Given
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();

        //Act - When
        var result = Battle.fight(chuck, bruce);
        var result2 = Battle.fight(dave, carl);

        //Assert - Then
        assertTrue(result);
        assertFalse(result2);
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());
    }

    @Test
    @DisplayName("testNo2 : warrior-knight")
    void testNo2() {
        //Arrange
        var carl = new Warrior();
        var jim = new Knight();

        //Act
        var fight1 = Battle.fight(carl, jim);

        //Assert
        assertFalse(fight1, "Knight should won");
    }

    @Test
    @DisplayName("testNo3 : knight - warrior")
    void testNo3() {
        //Arrange
        var ramon = new Knight();
        var slevin = new Warrior();

        //Act
        var fight2 = Battle.fight(ramon, slevin);

        //Assert
        assertTrue(fight2, "Knight should won");
    }

    @Test
    @DisplayName("testNo4: warrior-warrior")
    void testNo4() {
        //Arrange
        var bob = new Warrior();
        var mars = new Warrior();

        //Act
        var fight1 = Battle.fight(bob, mars);
        var resultOfFight = bob.isAlive();

        //Assert
        assertTrue(fight1, "bob should win");
        assertTrue(resultOfFight, "bob should stay alive");
    }

    @Test
    @DisplayName("testNo5: knight-warrior, isAlive?")
    void testNo5() {
        //Arrange
        var zeus = new Knight();
        var godKiller = new Warrior();

        //Act
        var fight1 = Battle.fight(zeus, godKiller);

        //Assert
        assertTrue(fight1, "zeus should win");
        assertTrue(zeus.isAlive(), "zeus should be alive");
    }

    @Test
    @DisplayName("testNo6: warrior-warrior, isAlive?")
    void testNo6() {
        //Arrange
        var husband = new Warrior();
        var wife = new Warrior();

        //Act
        var fight1 = Battle.fight(husband, wife);

        //Assert
        assertTrue(fight1, "wife should loose");
        assertFalse(wife.isAlive(), "wife should not be alive");
    }

    @Test
    @DisplayName("testNo7: warrior-warrior, isAlive?")
    void testNo7() {
        //Arrange
        var dragon = new Warrior();
        var knight = new Knight();

        //Act
        var fight1 = Battle.fight(dragon, knight);
        int knightHp = knight.getHealth();


        //Assert
        assertAll(
                () -> assertFalse(fight1, "knight should be alive"),
                () -> assertTrue(knight.isAlive()),
                () -> assertEquals(10, knightHp)
        );

    }

    @Test
    @DisplayName("testNo8: warrior-knight-warrior")
    void testNo8() {
        //Arrange
        var unit1 = new Warrior();
        var unit2 = new Knight();
        var unit3 = new Warrior();

        //Act
        var fight1 = Battle.fight(unit1, unit2);
        var fight2 = Battle.fight(unit2, unit3);
        int lastWarriorHp = unit3.getHealth();

        //Assert
        assertAll(
                () -> assertFalse(fight1, "in first fight should win unit2 - knight"),
                () -> assertFalse(fight2, "in second fight warrior should finish the damaged knight"),
                () -> assertEquals(36, lastWarriorHp)
        );
    }
}
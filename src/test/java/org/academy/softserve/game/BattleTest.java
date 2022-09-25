package org.academy.softserve.game;

import org.academy.softserve.game.charachters.Knight;
import org.academy.softserve.game.charachters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    private final Battle battle = new Battle();

    @Test
    void givenBattleWhenKnightVsWarriorThenKnightWins() {
        //Arrange - Given
        var carl = new Knight();
        var dave = givenWarrior();

        //Act - When
        var battleResult = battle.fight(carl, dave);

        //Assert - Then
        assertThatAttackerWonTheBattle(battleResult, carl, dave);
    }

    @Test
    void givenBattleWhenWarriorVsWarriorThenAttackerWarriorWins() {
        //Arrange - Given
        var chuck = givenWarrior();
        var bruce = givenWarrior();

        //Act - When
        var battleResult = battle.fight(chuck, bruce);

        //Assert - Then
        assertThatAttackerWonTheBattle(battleResult, chuck, bruce);
    }

    @Test
    @DisplayName("testNo2 : warrior-knight")
    void givenBattleWhenWarriorVsKnightThenDefendingKnightWins() {
        //Arrange
        var carl = givenWarrior();
        var jim = new Knight();

        //Act
        var battleResult = battle.fight(carl, jim);

        //Assert
        assertThatDefenderWonTheBattle(battleResult, carl, jim);
    }

    @Test
    void givenBattleWhenWarriorVsKnightThenAttackingKnightWins() {
        //Arrange
        var ramon = new Knight();
        var slevin = givenWarrior();

        //Act
        var battleResult = battle.fight(ramon, slevin);

        //Assert
        assertThatAttackerWonTheBattle(battleResult, ramon, slevin);
    }

    @Test
    void givenBattleWhenWarriorVsWarriorThenAttackerWins() {
        //given
        var bob = givenWarrior();
        var mars = givenWarrior();

        //when
        var fight1 = battle.fight(bob, mars);

        //then
        thenBobWinFight(fight1);
        thenBobShouldStayAlive(bob);
    }

    private static Warrior givenWarrior() {
        return new Warrior();
    }

    private void thenBobWinFight(boolean fightResult) {
        assertTrue(fightResult);
    }

    private static void thenBobShouldStayAlive(Warrior bob) {
        assertTrue(bob.isAlive());
    }

    @Test
    @DisplayName("testNo5: knight-warrior, isAlive?")
    void testNo5() {
        //Arrange
        var zeus = new Knight();
        var godKiller = givenWarrior();

        //Act
        var fight1 = battle.fight(zeus, godKiller);

        //Assert
        assertTrue(fight1, "zeus should win");
        assertTrue(zeus.isAlive(), "zeus should be alive");
    }

    @Test
    @DisplayName("testNo6: warrior-warrior, isAlive?")
    void testNo6() {
        //Arrange
        var husband = givenWarrior();
        var wife = givenWarrior();

        //Act
        var fight1 = battle.fight(husband, wife);

        //Assert
        assertTrue(fight1, "wife should loose");
        assertFalse(wife.isAlive(), "wife should not be alive");
    }

    @Test
    @DisplayName("testNo7: warrior-warrior, isAlive?")
    void testNo7() {
        //Arrange
        var dragon = givenWarrior();
        var knight = new Knight();

        //Act
        var fight1 = battle.fight(dragon, knight);
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
        var unit1 = givenWarrior();
        var unit2 = new Knight();
        var unit3 = givenWarrior();

        //Act
        var fight1 = battle.fight(unit1, unit2);
        var fight2 = battle.fight(unit2, unit3);
        int lastWarriorHp = unit3.getHealth();

        //Assert
        assertAll(
                () -> assertFalse(fight1, "in first fight should win unit2 - knight"),
                () -> assertFalse(fight2, "in second fight warrior should finish the damaged knight"),
                () -> assertEquals(36, lastWarriorHp)
        );
    }

    private void assertThatAttackerWonTheBattle(boolean battleResult, Warrior attacker, Warrior defender) {
        assertTrue(battleResult);
        assertTrue(attacker.isAlive());
        assertTrue(defender.isDead());
    }

    private void assertThatDefenderWonTheBattle(boolean battleResult, Warrior attacker, Warrior defender) {
        assertFalse(battleResult);
        assertTrue(attacker.isDead());
        assertTrue(defender.isAlive());
    }
}
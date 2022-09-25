package org.academy.softserve.game;

import org.academy.softserve.game.charachters.Defender;
import org.academy.softserve.game.charachters.Knight;
import org.academy.softserve.game.charachters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {
    
    private final Battle battle = new Battle();

    @DisplayName("1.Defender test battle")
    @Test
    void defenderTestBattleWithKnightAndWarrior() {

        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();

        var fight1 = battle.fight(chuck, bruce);
        var fight2 = battle.fight(carl, dave);
        var fight3 = battle.fight(bob, mark);
        var fight4 = battle.fight(mike, rog);
        var fight5 = battle.fight(rog, lancelot);

        assertAll(
                () -> assertTrue(fight1, "Chuck should win"),
                () -> assertTrue(fight2, "Carl should Win"),
                () -> assertTrue(fight3, "lets see where is the problem"),
                () -> assertTrue(fight4, "mike should win"),
                () -> assertFalse(fight5, "lancelot should win")
        );
    }

    static class Rookie extends Warrior {
        @Override
        public int getAttack() {
            return 1;
        }
    }

    @DisplayName("1.Defender test battle")
    @Test
    void defenderTestBattleWithRookie() {

        var chuck = new Rookie();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Rookie();
        var mark = new Rookie();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();

        var fight1 = battle.fight(chuck, bruce);
        var fight2 = battle.fight(carl, dave);
        var fight3 = battle.fight(bob, mark);
        var defenderHealthAfterBattle1 = bob.getHealth();
        var fight4 = battle.fight(bob, bruce);
        var defenderHealthAfterBattle2 = bob.getHealth();
        var fight5 = battle.fight(bob, mark);
        var defenderHealthAfterBattle3 = bob.getHealth();
        var fight6 = battle.fight(mike, rog);
        var fight7 = battle.fight(rog, lancelot);

        assertFalse(fight1, "Chuck should win");
        assertTrue(fight2, "Carl should Win");
        assertTrue(fight3, "lets see where is the problem");
        assertEquals(60, defenderHealthAfterBattle1);
        assertTrue(fight4, "lets see who wins");
        assertEquals(21, defenderHealthAfterBattle2);
        assertTrue(fight5, "lets see who wins");
        assertEquals(21, defenderHealthAfterBattle3);
        assertTrue(fight6, "mike should win");
        assertFalse(fight7, "lancelot should win");

    }
}
package org.academy.softserve.battle.game;

import org.academy.softserve.battle.game.charachters.Knight;
import org.academy.softserve.battle.game.charachters.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    @Test
    void smokeTest() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        assert Battle.fight(chuck, bruce) == true;
        assert Battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
    }
}
package org.academy.softserve.game.charachters;

import org.academy.softserve.game.Battle;
import org.junit.jupiter.api.Test;

class VampireBattleTest {
    private final Battle battle = new Battle();

    @Test
    void simpleTestsForVampire() {
        var chuck = new Warrior();
        var bruce = new Warrior();
        var carl = new Knight();
        var dave = new Warrior();
        var mark = new Warrior();
        var bob = new Defender();
        var mike = new Knight();
        var rog = new Warrior();
        var lancelot = new Defender();
        var eric = new Vampire();
        var adam = new Vampire();
        var richard = new Defender();
        var ogre = new Warrior();

        var battle1 = (battle.fight(chuck, bruce));
        assert battle.fight(dave, carl) == false;
        assert chuck.isAlive() == true;
        assert bruce.isAlive() == false;
        assert carl.isAlive() == true;
        assert dave.isAlive() == false;
        assert battle.fight(carl, mark) == false;
        assert carl.isAlive() == false;
        assert battle.fight(bob, mike) == false;
        assert battle.fight(lancelot, rog) == true;
        assert battle.fight(eric, richard) == false;
        assert battle.fight(ogre, adam) == true;


        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);
        enemyArmy.addUnits(Defender::new, 2);
        enemyArmy.addUnits(Vampire::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Defender::new, 4);

        var army4 = new Army();
        army4.addUnits(Vampire::new, 3);
        army4.addUnits(Warrior::new, 2);

        assert battle.fight(myArmy, enemyArmy) == false;
        assert battle.fight(army3, army4) == true;
    }
}
package org.academy.softserve.game;

import org.academy.softserve.game.charachters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightFightbattleTest {
    private  Battle battle = new Battle();
    @Test
    void testStraightFight() {
       
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
        var freelancer = new Lancer();
        var vampire = new Vampire();
        var priest = new Healer();

        assert battle.fight(chuck, bruce) == true;
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
        assert battle.fight(freelancer, vampire) == true;
        assert freelancer.isAlive() == true;
        assert freelancer.getHealth() == 14;
        priest.heal(freelancer);
        assert freelancer.getHealth() == 16;

        var myArmy = new Army();
        myArmy.addUnits(Defender::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Vampire::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 1);
        myArmy.addUnits(Warrior::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 2);
        enemyArmy.addUnits(Lancer::new, 4);
        enemyArmy.addUnits(Healer::new, 1);
        enemyArmy.addUnits(Defender::new, 2);
        enemyArmy.addUnits(Vampire::new, 3);
        enemyArmy.addUnits(Healer::new, 1);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 1);
        army3.addUnits(Lancer::new, 1);
        army3.addUnits(Healer::new, 1);
        army3.addUnits(Defender::new, 2);

        var army4 = new Army();
        army4.addUnits(Vampire::new, 3);
        army4.addUnits(Warrior::new, 1);
        army4.addUnits(Healer::new, 1);
        army4.addUnits(Lancer::new, 2);

        var army5 = new Army();
        army5.addUnits(Warrior::new, 10);

        var army6 = new Army();
        army6.addUnits(Warrior::new, 6);
        army6.addUnits(Lancer::new, 5);

        assert battle.fight(myArmy, enemyArmy) == false;
        assert battle.fight(army3, army4) == true;
        assert battle.straightFight(army5, army6) == false;
    }
}
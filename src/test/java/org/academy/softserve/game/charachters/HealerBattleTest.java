package org.academy.softserve.game.charachters;

import org.academy.softserve.game.Battle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealerBattleTest  {
    private final Battle battle = new Battle();

    @Test
    void healer_Default_Test() {
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

        var my_army = new Army();
        my_army.addUnits(Defender::new, 2);
        my_army.addUnits(Healer::new, 1);
        my_army.addUnits(Vampire::new, 2);
        my_army.addUnits(Lancer::new, 2);
        my_army.addUnits(Healer::new, 1);
        my_army.addUnits(Warrior::new, 1);

        var enemy_army = new Army();
        enemy_army.addUnits(Warrior::new, 2);
        enemy_army.addUnits(Lancer::new, 4);
        enemy_army.addUnits(Healer::new, 1);
        enemy_army.addUnits(Defender::new, 2);
        enemy_army.addUnits(Vampire::new, 3);
        enemy_army.addUnits(Healer::new, 1);

        var army_3 = new Army();
        army_3.addUnits(Warrior::new, 1);
        army_3.addUnits(Lancer::new, 1);
        army_3.addUnits(Healer::new, 1);
        army_3.addUnits(Defender::new, 2);

        var army_4 = new Army();
        army_4.addUnits(Vampire::new, 3);
        army_4.addUnits(Warrior::new, 1);
        army_4.addUnits(Healer::new, 1);
        army_4.addUnits(Lancer::new, 2);

        assert battle.fight(my_army, enemy_army) == false;
        assert battle.fight(army_3, army_4) == true;
    }
}
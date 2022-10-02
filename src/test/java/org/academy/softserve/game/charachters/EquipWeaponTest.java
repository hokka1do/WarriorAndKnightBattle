package org.academy.softserve.game.charachters;

import org.academy.softserve.game.Battle;
import org.academy.softserve.game.weapons.*;
import org.junit.jupiter.api.Test;

class EquipWeaponTest{
    Battle battle = new Battle();

    @Test
    void equipWeapon() {
        var ogre = new Warrior();
        var lancelot = new Knight();
        var richard = new Defender();
        var eric = new Vampire();
        var freelancer = new Lancer();
        var priest = new Healer();

// you may consider using another interfaces for the predefined weapon
// e.g. you could use enum or some factory
        var sword = new Sword();
        var shield = new Shield();
        var axe = new GreatAxe();
        var katana = new Katana();
        var wand = new MagicWand();
// consider using a builder instead
        var superWeapon = new Weapon(50, 10, 5, 150, 8);

        ogre.equipWeapon(sword);
        ogre.equipWeapon(shield);
        ogre.equipWeapon(superWeapon);
        lancelot.equipWeapon(superWeapon);
        richard.equipWeapon(shield);
        eric.equipWeapon(superWeapon);
        freelancer.equipWeapon(axe);
        freelancer.equipWeapon(katana);
        priest.equipWeapon(wand);
        priest.equipWeapon(shield);

        assert ogre.getHealth() == 125;
        assert lancelot.getAttack() == 17;
        assert richard.getDefense() == 4;
        assert eric.getVampirism() == 200;
        assert freelancer.getHealth() == 15;
        assert priest.getHealPower() == 5;

        assert battle.fight(ogre, eric) == false;
        assert battle.fight(priest, richard) == false;
        assert battle.fight(lancelot, freelancer) == true;

        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 1);
        myArmy.addUnits(Lancer::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, axe);
        myArmy.equipWarriorAtPosition(1, superWeapon);

        enemyArmy.equipWarriorAtPosition(0, katana);
        enemyArmy.equipWarriorAtPosition(1, wand);

        assert battle.fight(myArmy, enemyArmy) == true;
    }
}
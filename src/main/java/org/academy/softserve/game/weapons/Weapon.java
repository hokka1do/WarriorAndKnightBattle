package org.academy.softserve.game.weapons;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weapon {
    private int health = 0;
    private int attack = 0;
    private int defence = 0;
    private int vampirism = 0;
    private int healPower = 0;

}

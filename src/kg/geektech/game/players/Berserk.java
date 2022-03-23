package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = (boss.getDamage() - RPG_Game.random.nextInt(20));
        boss.setHealth(boss.getHealth() - (this.getDamage() + coeff));
        System.out.println("Berserk attacks " + (this.getDamage() + coeff));
    }
}

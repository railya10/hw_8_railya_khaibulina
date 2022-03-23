package kg.geektech.game.players;

public abstract class Hero extends GameEntity
        implements HavingSuperPower {
    private SuperAbility ability;

    public Hero(String name, int health,
                int damage, SuperAbility ability) {
        super(name, health, damage);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void setAbility(SuperAbility ability) {
        this.ability = ability;
    }

    public void hit(Boss boss) {
        if (boss.getHealth() > 0 && this.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - this.getDamage());
        }
    }
}

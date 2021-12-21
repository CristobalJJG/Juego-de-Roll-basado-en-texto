package text_based_rollgame.Enemies;

public class EnemyZombie extends Enemy{
    
    public EnemyZombie(){
        this.health = 100;
        this.attackDamage = 25;
    }
    
    @Override
    public String getName(){
        return "Zombie";
    }

    @Override
    public String enemyInfo() {
        return "\tZombie - Vida: " + health;
    }
}

package text_based_rollgame.Enemies;

public class EnemySkeleton extends Enemy{
    
    public EnemySkeleton(){
        this.health = 50;
        this.attackDamage = 35;
    }
    
    public String getName(){
        return "Skeleton";
    }
    
    @Override
    public String enemyInfo() {
        return "\tSkeleton - Vida: " + health;
    }
}

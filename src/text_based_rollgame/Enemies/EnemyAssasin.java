package text_based_rollgame.Enemies;

public class EnemyAssasin extends Enemy{
    
    public EnemyAssasin(){
        this.health = 75;
        this.attackDamage = 50;
    }
    
    public String getName(){
        return "Assasin";
    }
    
    @Override
    public String enemyInfo() {
        return "\tAssasin - Vida: " + health;
    }
}

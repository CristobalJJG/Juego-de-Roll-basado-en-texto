package text_based_rollgame.Enemies;

public class EnemyWarrior extends Enemy{
    
    public EnemyWarrior(){
        this.health = 150;
        this.attackDamage = 35;
    }
    
    public String getName(){
        return "Warrior";
    }
    
    @Override
    public String enemyInfo() {
        return "\tWarrior - Vida: " + health;
    }
}

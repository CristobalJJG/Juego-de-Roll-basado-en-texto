package text_based_rollgame.Enemies;

import java.util.Random;
import text_based_rollgame.Player.Player;

public abstract class Enemy {
    protected int health;
    protected int attackDamage;
    
    public abstract String enemyInfo();
    
    public abstract String getName();
    
    public int getHealth() {
        return this.health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void attackPlayer(Player player, int chanceToHit) {
        boolean val = new Random().nextInt(chanceToHit) < chanceToHit;
        if(val){
            player.setHealth(player.getHealth() - this.attackDamage);
        }else{
            System.out.println("\tEl enemigo falló el golpe!");
        }
    }
}

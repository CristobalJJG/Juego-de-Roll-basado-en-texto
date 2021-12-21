package text_based_rollgame.Player;

import java.util.ArrayList;
import java.util.Random;
import text_based_rollgame.Enemies.Enemy;

public class Player {
    //Atributos del Jugador
    //Vida
    private int health;
    
    //Daño de ataque
    private int attackDamage;
    
    //Pociones de Curación
    private HealthPotion healthPotion;
    //-------- Cosas por ver ---------//
    //private int PotionMana;
    //private ArrayList<Item> items;
    
    /* Jugador
     * Se inicializa al jugador
     */
    public Player(){
        this.health = 500;
        this.attackDamage = 25;
        this.healthPotion = new HealthPotion();
    }
    
    public void showInfo(){
        String s = "";
        s += "Vida: " + health;
        s += "\nDaño de ataque: " + attackDamage;
        s += "\nPociones de Curación:" + healthPotion.getNumberOfPotions();
        System.out.println(s);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getNumberOfPotions() {
        return healthPotion.getNumberOfPotions();
    }

    public void setHealthPotion(HealthPotion healthPotion) {
        this.healthPotion = healthPotion;
    }

    public void attackAction(Enemy e, int chanceToHit) {
        boolean val = new Random().nextInt(chanceToHit) < chanceToHit;
        if(val){
            e.setHealth(e.getHealth() - this.attackDamage);
        }else{
            System.out.println("\t\tFallaste el golpe!");
        }
    }
    
    public boolean heal(){
        int nPotions = healthPotion.getNumberOfPotions();
        if(nPotions > 0){
            this.setHealth(this.health + this.healthPotion.getHealStat());
            this.healthPotion.setNumberOfPotion(nPotions-1);
            return true;
        }
        return false;
    }
    
    public boolean runAway(int chanceToRunAway) {
        return new Random().nextInt(chanceToRunAway) < chanceToRunAway;
    }
    
}

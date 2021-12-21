package text_based_rollgame.Scenes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import text_based_rollgame.Enemies.Enemy;
import text_based_rollgame.Player.Player;

public class FightScene extends Scene{
    
    // Probabilidad de que al matar un enemigo suelte una Health Potion = 50%
    int chanceDropHealthPotion = 25;
        
    int chanceAttack1Hit = 75; // Probabilidad de que el jugador pegue
    int chanceEnemyHit = 50;   // Probabilidad de que el enemigo pegue
    int chaceToRunAway = 70;
    //int chanceAttack2Hit = 50;
    //int chanceAttack3Hit = 25;
    
    //Sistema
    Scanner sc;
    
    //Enemigo 
    private Enemy e;
    
    //Jugdor 
    private Player player;
    
    public FightScene(Scanner sc, Player player, ArrayList<Enemy> enemies){
        this.e = enemies.get(new Random().nextInt(enemies.size()));
        this.player = player;
        this.sc = sc;
    }
    
    @Override
    public boolean startScene(){
        System.out.println("\t# " + e.getName() + " acaba de aparecer delante de ti! #\n");
        //  # Skeleton acaba de apareces delante de ti! #
        
        while(e.getHealth() > 0){
            System.out.println("\tTu vida: " + player.getHealth());
            System.out.println(e.enemyInfo());
            System.out.println("\n\t¿Qué quieres hacer?");
            System.out.println("\t1. Atacar");
            System.out.println("\t2. Beber poción sanadora");
            System.out.println("\t3. Ver tus estadísticas");
            System.out.println("\t4. Huir!");
             
            String input = sc.nextLine();
            switch(input){
                case "1":
                    player.attackAction(e, chanceAttack1Hit); 
                    e.attackPlayer(player, chanceEnemyHit); break;
                    
                case "2":
                    player.heal();
                    e.attackPlayer(player, chanceEnemyHit);
                    break;
                       
                case "3":
                    System.out.println("|| -------- Jugador ------- || -------- Enemigo --------- ||");
                    System.out.println("|| - Vida:" + player.getHealth()                 + "  \t\t    ||  Vida:" + e.getHealth() + "   \t\t- ||");
                    System.out.println("|| - Daño de Ataque:" + player.getAttackDamage() + "\t    ||  Daño del enemigo:" + e.getAttackDamage() + "     - ||");
                    System.out.println("|| - Pociones:" + player.getNumberOfPotions()    + "\t\t    ||\t\t\t\t- ||");
                    System.out.println("|| -------- ------- ------- || -------- ------- --------- ||\n");
                    break;
                    
                case "4":
                    if(player.runAway(chaceToRunAway)){
                        System.out.println("Pudiste huir! :)");
                    }else{
                        System.out.println("No has podido huir! :(");
                    } 
                    e.attackPlayer(player, chanceEnemyHit);
                    break;
            
                default:
                    System.out.println("Prueba otro número.");
            }
                
            if(e.getHealth() <= 0){
                return true;
            }else if(player.getHealth() <= 0){
                return false;
            }
        }
        return true;
    }
}

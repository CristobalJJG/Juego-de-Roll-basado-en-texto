package text_based_rollgame.Scenes;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import text_based_rollgame.Enemies.Enemy;
import text_based_rollgame.GUI.Base_Game;
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
    
    public FightScene(Scanner sc, Player player, ArrayList<Enemy> enemies, Base_Game game){
        super(game);
        this.e = enemies.get(new Random().nextInt(enemies.size()));
        this.player = player;
        this.sc = sc;
    }
    
    @Override
    public boolean startScene(){
        //  # Skeleton acaba de apareces delante de ti! #
        
        while(e.getHealth() > 0){
            getGame().setPlayerSprite(player.getSprite());
            getGame().setEnemySprite(e.getSprite());
            getGame().setLifeBar(player.getHealth(), player.getMaxHealth(), e.getHealth(), e.getMaxHealth());
            String s = "\t# " + e.getName() + " acaba de aparecer delante de ti! #\n" +
                        """
                        \t\u00bfQu\u00e9 quieres hacer?
                        \t\t1. Atacar
                        \t\t2. Beber poci\u00f3n sanadora
                        \t\t3. Ver tus estad\u00edsticas
                        \t\t4. Huir!""";
            System.out.println(s);
            getGame().writeStory(s);
            String input = "";
            while(input.equals("")){
                input = getGame().getInput();
                delay(1000);
            }
            
            switch(input){
                case "1":
                    playerAttack();
                    break;
                    
                case "2":
                    player.heal();
                    enemyAttack();
                    getGame().updatePlayerLifeBar(player.getHealth(), player.getMaxHealth());
                    break;
                       
                case "3":
                    String s1 = "|| -------- Jugador ------- || -------- Enemigo --------- ||" +
                            "\n|| - Vida:" + player.getHealth()                 + "  \t\t    ||  Vida:" + e.getHealth() + "   \t\t- ||" +
                            "\n|| - Daño de Ataque:" + player.getAttackDamage() + "\t    ||  Daño del enemigo:" + e.getAttackDamage() + "     - ||"+
                            "\n|| - Pociones:" + player.getNumberOfPotions()    + "\t\t    ||\t\t\t\t- ||"+
                            "\n|| -------- ------- ------- || -------- ------- --------- ||\n";
                    System.out.println(s1);
                    getGame().writeStory(s1);
                    delay(5000);
                    break;
                    
                case "4":
                    if(player.runAway(chaceToRunAway)){
                        System.out.println("Pudiste huir! :)");
                    }else{
                        System.out.println("No has podido huir! :(");
                    } 
                    enemyAttack();
                    break;
            
                default:
                    getGame().writeStory("No es una acción válida!");
                    System.out.println("Prueba otro número.");
            }
                
            if(e.getHealth() <= 0){
                enemyDies();
                getGame().updateEnemyLifeBar(e.getHealth(), e.getMaxHealth());
                return true;
            }else if(player.getHealth() <= 0){
                return false;
            }
            enemyAttack();
            input = "0";
        }
        return true;
    }
    
    private void enemyAttack(){
        e.attackPlayer(player, chanceEnemyHit); 
        updateSprite();
        getGame().updateEnemyLifeBar(e.getHealth(), e.getMaxHealth());
        delay(1000);
        doCommonSprite();
    }
    
    private void playerAttack(){
        player.attackAction(e, chanceAttack1Hit); 
        updateSprite();
        getGame().updatePlayerLifeBar(player.getHealth(), player.getMaxHealth());
        delay(1000);
        doCommonSprite();
    }
    
    private static void delay(long milis){
        try{ Thread.sleep(milis); }
        catch(InterruptedException e){
            e.getMessage();
        }
    }
    
    private void doCommonSprite(){
        player.changeSprite(13); e.changeSprite(13);
        updateSprite();
    }
    
    private void updateSprite(){
        getGame().setPlayerSprite(player.getSprite());
        getGame().setEnemySprite(e.getSprite());
    }
    
    private void enemyDies(){
        e.changeSprite(1);
        player.changeSprite(3);
        updateSprite();
    }
}

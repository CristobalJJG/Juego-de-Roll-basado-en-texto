package text_based_rollgame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import text_based_rollgame.Enemies.*;
import text_based_rollgame.GUI.*;
import text_based_rollgame.GUI.Dialogs.Aprove;
import text_based_rollgame.GUI.Dialogs.Before;
import text_based_rollgame.Player.Player;
import text_based_rollgame.Scenes.*;

public class TextBasedRollGame {
    public static void main(String[] args) {
        // Objetos del sistema
        Scanner sc = new Scanner(System.in);
        Random rand = new Random(); 
        
        // Variables de Enemigos
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new EnemySkeleton());
        enemies.add(new EnemyWarrior());
        
        
        // Jugador
        Player player = new Player();
        
        // Variable que se modificará en caso de que la partida no continue        
        boolean running = true;
        
        
        // Inicio del Juego
        System.out.println("Bienvenido a la Mazmorra!");
   
        
        Base_Game game = new Base_Game();
        
        Before dialogBf = new Before(game, true, "¿Estás seguro de querer entrar en la Mazmorra?");
        boolean sure = dialogBf.getPressed();
        while(!sure){
            dialogBf = new Before(game, true, "No es tan malo, créeme.\n¿Quieres entrar en la Mazmorra?");
            sure = dialogBf.getPressed();
            delay(750);
        } 
        dialogBf.dispose();
        new Aprove(game, true);
        
        
        while(running){
            System.out.println("----------------------------------------------------------------");
            
            // Carga de los escenarios
            ArrayList<Scene> escenarios = new ArrayList<>();
            escenarios.add(new FightScene(sc, player, enemies, game));
            
            game.writeStory("Pelea!!");
            
            for (int i = 0; i < escenarios.size(); i++) {
                Scene escenario = escenarios.get(i);
                if(escenario instanceof FightScene fs){
                    if(!fs.startScene()){
                        System.out.println("\tHas muerto dentro de la Mazmorra! esperamos al siguiente valiente.\n\n\n\n");
                        running = false;
                        break;
                    }
                    game.writeStory("\tHas Ganado!!!");
                    System.out.println("\tHas ganado!\n\n\n\n");
                }
            }
        }    
        
    }
    
    private static void delay(long milis){
        try{ Thread.sleep(milis); }
        catch(InterruptedException e){
            e.getMessage();
        }
    }
    
}

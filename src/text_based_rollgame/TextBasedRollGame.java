package text_based_rollgame;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import text_based_rollgame.Enemies.*;
import text_based_rollgame.Player.Player;
import text_based_rollgame.Scenes.*;

public class TextBasedRollGame {
    public static void main(String[] args) {
        // Objetos del sistema
        Scanner sc = new Scanner(System.in);
        Random rand = new Random(); 
        
        // Variables de Enemigos
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new EnemyZombie());
        enemies.add(new EnemySkeleton());
        enemies.add(new EnemyWarrior());
        enemies.add(new EnemyAssasin());
        
        
        // Jugador
        Player player = new Player();
        
        // Variable que se modificará en caso de que la partida no continue        
        boolean running = true;
        
        
        // Inicio del Juego
        System.out.println("Bienvenido a la Mazmorra!");
        
    
        boolean sure = false;
        while(!sure){
            System.out.println("¿Estás seguro de querer entrar? (si/no)");
        
            String input = sc.nextLine();
            switch(input.toLowerCase()){
                case "no":
                    System.out.println("No es tan malo, ¿créeme!");
                    break;

                case "si":
                    System.out.println("¡Perfecto!"); sure = true;
                    break;
            }
        }    
        GAME:
        while(running){
            System.out.println("----------------------------------------------------------------");
            // Carga de los escenarios
            ArrayList<Scene> escenarios = new ArrayList<>();
            escenarios.add(new FightScene(sc, player, enemies));
            player.showInfo();
            escenarios.add(new FightScene(sc, player, enemies));
            escenarios.add(new FightScene(sc, player, enemies));
            escenarios.add(new FightScene(sc, player, enemies));
            
            for (int i = 0; i < escenarios.size(); i++) {
                delay(1500);
                Scene escenario = escenarios.get(i);
                if(escenario instanceof FightScene fs){
                    if(!fs.startScene()){
                        System.out.println("\tHas muerto dentro de la Mazmorra! esperamos al siguiente valiente.\n\n\n\n");
                        running = false;
                        break;
                    }
                    System.out.println("\tHas ganado!\n\n\n\n");
                }
                
            }
            running = false;
        }    
            
    }
    
    private static void delay(long milis){
        try{ Thread.sleep(milis); }
        catch(InterruptedException e){
            e.getMessage();
        }
    }
    
}

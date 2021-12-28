package Images.Warrior;

import javax.swing.ImageIcon;

//Sprite gotten from
//(Skeleton) https://astrobob.itch.io/animated-pixel-art-skeleton
public class SpriteOfWarrior extends Images.Sprite{
    
    public SpriteOfWarrior(){}

    private  ImageIcon getWarriorAttacking() {
        return new ImageIcon(getClass().getResource("/Images/Warrior/Warrior_Attack.gif"));
    }
    
    private ImageIcon getWarriorDead() {
        return new ImageIcon(getClass().getResource("/Images/Warrior/Warrior_Dead.gif"));
    }
    
    private ImageIcon getWarriorInjured() {
        return new ImageIcon(getClass().getResource("/Images/Warrior/Warrior_Hit.gif"));
    }
    
    private ImageIcon getWarriorIdle() {
        return new ImageIcon(getClass().getResource("/Images/Warrior/Warrior_Idle.gif"));
    }
    
    private ImageIcon getWarriorWalking() {
        return new ImageIcon(getClass().getResource("/Images/Warrior/Warrior_Run.gif"));
    }
    
    @Override
    public ImageIcon changeSprite() {
        return getWarriorIdle();
    }

    @Override
    public ImageIcon changeSprite(int n) {
        switch(n){
            //Ataca
            case 0: return getWarriorAttacking();
            
            //Muere
            case 1: return getWarriorDead();
                
            //Es herido
            case 2: return getWarriorInjured();
            
            //Camina    
            case 3: return getWarriorWalking();
            
            //Quieto
            case 4:    
            default:
                return getWarriorIdle();
        }
    }
}


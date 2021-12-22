package text_based_rollgame.GUI;

import javax.swing.*;

public class Game extends JFrame{
    private final JPanel backgroundPanel= new JPanel();
    
    public Game(){
        initializeWindow();
        
        
        
    }

    private void initializeWindow() {
        try{
            UIManager.setLookAndFeel(text_based_rollgame.GUI.Themes.Themes.flatDark());
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){
            e.getMessage();
        }
        setBounds(1920, 0, 1920, 1080);
        setVisible(true);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Mazmorra de Cosas");
    }

    
    
}

package edu.udesc.volley;

import edu.udesc.volley.controller.ControllerSystem;
import edu.udesc.volley.view.ViewSystem;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main class of System
 * @author Jean Poffo
 */
public class Main {
    
    public static void main(String[] args) {
        setLookAndFeel();
        
        new ViewSystem(ControllerSystem.getInstance());
    }
    
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

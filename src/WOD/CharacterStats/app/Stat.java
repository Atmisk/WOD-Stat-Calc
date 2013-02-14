/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import javax.swing.*;

/**
 *
 * @author Mike
 */
public class Stat extends JPanel{
    RadioPanel statLevel;
    JTextField specialty;
    JLabel statName;
    
    public Stat(String name){
        statLevel = new RadioPanel();
        specialty = new JTextField();
        statName = new JLabel(name);
        
        this.add(statName);
        this.add(specialty);
        this.add(statLevel);
    }
}

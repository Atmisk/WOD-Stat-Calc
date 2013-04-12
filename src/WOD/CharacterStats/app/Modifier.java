/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import javax.swing.JLabel;

/**
 *
 * @author Mike
 */
public class Modifier extends JLabel {
    private int value;
    
    public Modifier(){
        this.value = 0;
        this.setText("+0");
    }
    
    public Modifier(int value){
        Integer intToStr = new Integer(value);
        this.value = value;
        this.setText("+" + intToStr.toString());
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(int value){
        Integer intToStr = new Integer(value);
        this.value = value;
        this.setText("+" + intToStr.toString());
    }
}

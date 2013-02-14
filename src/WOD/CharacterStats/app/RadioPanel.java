/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Mike
 */
public class RadioPanel extends JPanel {
    private final int COLUMNS = 5;
    private final int NONE = 0;
    
    private int value;
    
    private class RadioListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(radio1)){
                //JOptionPane.showMessageDialog(radio1, "Radio1 clicked");
                if(((JRadioButton)e.getSource()).isSelected()){
                    radio2.setSelected(false);
                    radio3.setSelected(false);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                }
                else if(radio2.isSelected()){
                    radio1.setSelected(true);
                    radio2.setSelected(false);
                    radio3.setSelected(false);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                }
                else{
                    radio1.setSelected(false);
                    radio2.setSelected(false);
                    radio3.setSelected(false);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                }
            }
            else if(e.getSource().equals(radio2)){
                //JOptionPane.showMessageDialog(radio2, "Radio2 clicked");
                if(((JRadioButton)e.getSource()).isSelected()){
                    radio1.setSelected(true);
                    radio3.setSelected(false);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                }
                else{
                    radio2.setSelected(true);
                    radio3.setSelected(false);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                }
            }
            else if(e.getSource().equals(radio3)){
                //JOptionPane.showMessageDialog(radio3, "Radio3 clicked");
                if(((JRadioButton)e.getSource()).isSelected()){
                    radio1.setSelected(true);
                    radio2.setSelected(true);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                }
                else{
                    radio3.setSelected(true);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                }
            }
            else if(e.getSource().equals(radio4)){
                //JOptionPane.showMessageDialog(radio4, "Radio4 clicked");
                if(((JRadioButton)e.getSource()).isSelected()){
                    radio1.setSelected(true);
                    radio2.setSelected(true);
                    radio3.setSelected(true);
                    radio5.setSelected(false);
                }
                else{
                    radio4.setSelected(true);
                    radio5.setSelected(false);
                }
            }
            else if(e.getSource().equals(radio5)){
                //JOptionPane.showMessageDialog(radio5, "Radio5 clicked");
                if(((JRadioButton)e.getSource()).isSelected()){
                    radio1.setSelected(true);
                    radio2.setSelected(true);
                    radio3.setSelected(true);
                    radio4.setSelected(true);
                }
                else{
                    radio5.setSelected(true);
                }
            }
        }
    }
    
    JRadioButton radio1 = new JRadioButton();
    JRadioButton radio2 = new JRadioButton();
    JRadioButton radio3 = new JRadioButton();
    JRadioButton radio4 = new JRadioButton();
    JRadioButton radio5 = new JRadioButton();
    
    private EmptyBorder noBorder = new EmptyBorder(new Insets(0, 0, 0, 0));
    
    GridLayout layout = new GridLayout(0, COLUMNS);

    public RadioPanel(){
        value = 0;
        
        layout.setHgap(NONE);
        
        radio1.setBorder(noBorder);
        radio2.setBorder(noBorder);
        radio3.setBorder(noBorder);
        radio4.setBorder(noBorder);
        radio5.setBorder(noBorder);
        
        this.add(radio1);
        this.add(radio2);
        this.add(radio3);
        this.add(radio4);
        this.add(radio5);
        
        RadioListener listener = new RadioListener();
        
        radio1.addActionListener(listener);
        radio2.addActionListener(listener);
        radio3.addActionListener(listener);
        radio4.addActionListener(listener);
        radio5.addActionListener(listener);
    }
    public int Value(){
        return value;
    }
}

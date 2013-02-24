/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mike
 */
public class Stat extends JPanel {
    int COLUMNS = 3;
    
    JLabel name = new JLabel();
    //JTextField specialty = new JTextField();
    RadioPanel statRank = new RadioPanel();
    
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c;
    
    public Stat(String name){
        initComponents();
        this.name.setText(name);
    }
    
    public Stat(String name, int rank){
        initComponents();
        this.name.setText(name);
        switch(rank){
            case 0:
                break;
            case 1:
                statRank.radio1.doClick();
                break;
            case 2:
                statRank.radio2.doClick();
                break;
            case 3:
                statRank.radio3.doClick();
                break;
            case 4:
                statRank.radio4.doClick();
                break;
            case 5:
                statRank.radio5.doClick();
                break;
            default:
                statRank.radio1.doClick();
        }
    }
    
    private void initComponents(){
        this.setLayout(layout);
        c = setAnchor(GridBagConstraints.WEST);
        this.add(name, c);
        //this.add(specialty);
        c = setAnchor(GridBagConstraints.EAST);
        this.add(statRank, c);
    }
    
    public void addActionListener(ActionListener l){
        statRank.addActionListener(l);
    }
    
    public int getValue(){
        return statRank.Value();
    }
    private static GridBagConstraints setAnchor(int anchor){
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.anchor = anchor;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mike
 */
public class Detail extends JPanel {
    JLabel name = new JLabel();
    JTextField detail = new JTextField(10);
    
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c;
    
    public Detail(String name){
        this.name.setText(name);
        InitComponents();
    }
    public Detail(String name, String detail){
        this.name.setText(name);
        this.detail.setText(detail);
        InitComponents();
    }
    
    private void InitComponents(){
        this.setLayout(layout);
        name.setMinimumSize(new Dimension(10,20));
        
        c = setAnchor(GridBagConstraints.WEST);
        this.add(name, c);
        c = setAnchor(GridBagConstraints.EAST);
        this.add(detail, c);
    }
    
    public void addActionListener(ActionListener l){
        detail.addActionListener(l);
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

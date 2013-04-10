/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Mike
 */
public class Detail extends JPanel {
    JLabel name = new JLabel();
    JTextField detail = new JTextField(11);
    JComboBox detailBox;
    
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c;
    
    private enum Type{
        BOX, TEXT
    }
    
    private Type type;
    
    public Detail(String name){
        this.name.setText(name);
        type = Type.TEXT;
        InitComponents();
    }
    public Detail(String name, DocumentListener l){
        this.name.setText(name);
        type = Type.TEXT;
        detail.getDocument().addDocumentListener(l);
        InitComponents();
    }
    public Detail(String name, String detail){
        this.name.setText(name);
        this.detail.setText(detail);
        type = Type.TEXT;
        InitComponents();
    }
    public Detail(String name, String detail, DocumentListener l){
        this.name.setText(name);
        this.detail.setText(detail);
        type = Type.TEXT;
        this.detail.getDocument().addDocumentListener(l);
        InitComponents();
    }
    public Detail(String name, String[] details){
        this.name.setText(name);
        this.detailBox = new JComboBox(details);
        this.detailBox.setPrototypeDisplayValue("String to set size");
        type = Type.BOX;
        InitComponents();
    }
    public Detail(String name, String[] details, ItemListener l){
        this.name.setText(name);
        this.detailBox = new JComboBox(details);
        this.detailBox.setPrototypeDisplayValue("String to set size");
        type = Type.BOX;
        this.detailBox.addItemListener(l);
        InitComponents();
    }
    
    private void InitComponents(){
        this.setLayout(layout);
        name.setMinimumSize(new Dimension(10,20));
        
        c = setAnchor(GridBagConstraints.WEST);
        this.add(name, c);
        c = setAnchor(GridBagConstraints.EAST);
        if(type == Type.TEXT){
            this.add(detail, c);
        }
        else{
            this.add(detailBox, c);
        }
    }
    
    public void addDocumentListener(DocumentListener l){
        detail.getDocument().addDocumentListener(l);
    }
    public void addItemListener(ItemListener l){
        if(detailBox != null){
            detailBox.addItemListener(l);
        }
    }
    private static GridBagConstraints setAnchor(int anchor){
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.anchor = anchor;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }
    public String getDetail(){
        if(type == Type.TEXT){
            return detail.getText();
        }
        else if(type == Type.BOX){
            return detailBox.getSelectedItem().toString();
        }
        else{
            return null;
        }
    }
    public void setDetail(String detail){
        if(type == Type.TEXT){
            this.detail.setText(detail);
        }
        else{
            this.detailBox.setSelectedItem(detail);
        }
    }
}

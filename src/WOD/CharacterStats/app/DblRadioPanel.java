/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Mike
 */
public class DblRadioPanel extends JPanel implements ActionListener{
    RadioPanel paneLow;
    RadioPanel paneHigh;
    int value;
    
    private GridBagLayout layout;
    Dimension dim;
    
    private ArrayList<ActionListener> aListeners = new ArrayList<>();
    private ActionEvent event = new ActionEvent(this, 1, "Select");
    
    public DblRadioPanel(){
        paneLow = new RadioPanel();
        paneHigh = new RadioPanel();
        value = 0;
        
        initPanel();
    }
    
    public DblRadioPanel(int rank){
        if(rank > 5){
            paneLow = new RadioPanel(5);
            paneHigh = new RadioPanel(rank - 5);
        }
        else{
            paneLow = new RadioPanel(rank);
            paneHigh = new RadioPanel();
        }
        
        value = paneLow.getValue() + paneHigh.getValue();
        
        initPanel();
    }
    
    public DblRadioPanel(String size){
        paneLow = new RadioPanel(size);
        paneHigh = new RadioPanel(size);
        
        value = 0;
        
        initPanel();
    }
    
    public DblRadioPanel(int rank, String size){
        if(rank > 5){
            paneLow = new RadioPanel(5, size);
            paneHigh = new RadioPanel(rank - 5, size);
        }
        else{
            paneLow = new RadioPanel(rank, size);
            paneHigh = new RadioPanel(size);
        }
        
        value = paneLow.getValue() + paneHigh.getValue();
        
        initPanel();
    }
    
    private void initPanel(){
        dim = new Dimension(230, 18);
        
        layout = new GridBagLayout();
        dim = new Dimension(115, 18);
        
        this.setLayout(layout);
        this.add(paneLow);
        this.add(paneHigh);
        
        paneLow.addActionListener(this);
        paneHigh.addActionListener(this);
        
        this.setMinimumSize(dim);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(paneLow)){
            paneHigh.clear();
            value = paneLow.getValue();
        }
        else if(e.getSource().equals(paneHigh)){
            paneLow.setAll();
            value = paneLow.getValue() + paneHigh.getValue();
        }
        notifyListeners();
    }
    
    public void setValue(int rank){
        if(rank < 0){
            value = 0;
            paneLow.setValue(0);
            paneHigh.setValue(0);
        }
        else if(rank < 6){
            value = rank;
            paneLow.setValue(rank);
            paneHigh.setValue(0);
        }
        else if(rank < 11){
            value = rank;
            paneLow.setValue(5);
            paneHigh.setValue(value - 5);
        }
        else{
            value = 10;
            paneLow.setValue(5);
            paneHigh.setValue(5);
        }
    }
    
    public int getValue(){return value;}
    
    public void addActionListener(ActionListener l){
        aListeners.add(l);
    }
    
    private void notifyListeners(){
        for(ActionListener listen : aListeners){
            listen.actionPerformed(event);
        }
    }
    
    public void setAll(){
        paneLow.setAll();
        paneHigh.setAll();
    }
    
    public void clear(){
        paneLow.clear();
        paneHigh.clear();
    }
}

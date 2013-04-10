/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.FontMetrics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Mike
 */
public class Stat extends JPanel implements ActionListener{
    // this exists so that the actions listeners get the right instance
    // as a source
    @Override
    public void actionPerformed(ActionEvent e){
        notifyListeners();
    }
    
    int COLUMNS = 3;
    
    JLabel name = new JLabel();
    //JTextField specialty = new JTextField();
    RadioPanel statRank = new RadioPanel();
    //JLabel modifier = new JLabel();
    
    GridBagLayout layout = new GridBagLayout();
    //BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
    GridBagConstraints c;
    
    ArrayList<ActionListener> aListeners = new ArrayList<>();
    
    ActionEvent event = new ActionEvent(this, 1, "Rank Change");
    /**
     * 
     * @param name 
     */
    public Stat(String name){
        initComponents();
        this.name.setText(name);
    }
    /**
     * 
     * @param name
     * @param rank 
     */
    public Stat(String name, int rank){
        initComponents();
        this.name.setText(name);
        statRank.setValue(rank);
    }
    /**
     * 
     * @param name
     * @param l 
     */
    public Stat(String name, ActionListener l){
        initComponents();
        this.name.setText(name);
        initActionListener(l);
    }
    /**
     * 
     * @param name
     * @param rank
     * @param l 
     */
    public Stat(String name, int rank, ActionListener l){
        initComponents();
        this.name.setText(name);
        initActionListener(l);
        statRank.setValue(rank);
    }
    /**
     * 
     */
    private void initComponents(){
        // <editor-fold defaultstate="collapsed" desc="code for measuring text size">
//        FontMetrics fMet = name.getFontMetrics(name.getFont());
//        System.out.print("Width: ");
//        System.out.println(fMet.stringWidth(name.getText()));
//        System.out.print("Height: ");
//        System.out.println(fMet.getHeight());
        // </editor-fold>
        
        this.setLayout(layout);
        c = setAnchor(GridBagConstraints.WEST);
        this.add(name, c);
        //this.add(specialty);
        c = setAnchor(GridBagConstraints.EAST);
        this.add(statRank, c);
        //c = setAnchor(GridBagConstraints.EAST);
        //this.add(modifier, c);
        
        statRank.addActionListener(this);
    }
    /**
     * 
     * @param l 
     */
    private void initActionListener(ActionListener l){
        aListeners.add(l);
    }
    /**
     * 
     * @param l 
     */
    public void addActionListener(ActionListener l){
        aListeners.add(l);
    }
    /**
     * 
     */
    public void notifyListeners(){
        for(ActionListener listen : aListeners){
            listen.actionPerformed(event);
        }
    }
    /**
     * 
     * @return 
     */
    public int getValue(){
        return statRank.getValue();
    }
    /**
     * 
     * @param value 
     */
    public void setValue(int value){
        this.statRank.setValue(value);
    }
    /**
     * 
     * @param anchor
     * @return 
     */
    private static GridBagConstraints setAnchor(int anchor){
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.anchor = anchor;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }
}

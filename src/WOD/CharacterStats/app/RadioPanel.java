/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
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
                    //System.out.println("IF 1");
                    value = 1;
                }
                else if(radio2.isSelected()){
                    radio1.setSelected(true);
                    radio2.setSelected(false);
                    radio3.setSelected(false);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                    //System.out.println("IF 2");
                    value = 1;
                }
                else{
                    radio1.setSelected(false);
                    radio2.setSelected(false);
                    radio3.setSelected(false);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                    //System.out.println("IF 3");
                    value = 0;
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
    
    //private AffineTransform scalingTransform;
    //private AffineTransform inverseScalingTransform;
    //double originalW = this.getWidth();
    //double originalH = this.getHeight();
    
    JRadioButton radio1 = new JRadioButton();
        /*{
            @Override
            public void paint(Graphics g)
            {
                resize();
                ((Graphics2D)g).setTransform(scalingTransform);
                super.paint(g);
            }
            @Override
            public void paintAll(Graphics g)
            {
                resize();
                ((Graphics2D)g).setTransform(scalingTransform);
                super.paintAll(g);
            }
            @Override
            public void paintComponents(Graphics g)
            {
                resize();
                ((Graphics2D)g).setTransform(scalingTransform);
                super.paintComponents(g);
            }
    };*/
    JRadioButton radio2 = new JRadioButton();
    JRadioButton radio3 = new JRadioButton();
    JRadioButton radio4 = new JRadioButton();
    JRadioButton radio5 = new JRadioButton();
    
    private EmptyBorder noBorder = new EmptyBorder(new Insets(0, 0, 0, 0));
    
    GridLayout layout = new GridLayout(0, COLUMNS);

    public RadioPanel(){
        value = 0;
        
        this.setMaximumSize(new Dimension(250, 20));
        this.setLayout(layout);
        
        //this.setBackground(Color.red);
        
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
        
        setInitListeners(listener);
    }

    public int Value(){
        return value;
    }
    private void setInitListeners(ActionListener l){
        radio1.addActionListener(l);
        radio2.addActionListener(l);
        radio3.addActionListener(l);
        radio4.addActionListener(l);
        radio5.addActionListener(l);
    }
    public void addActionListener(ActionListener l){
        radio1.addActionListener(l);
        radio2.addActionListener(l);
        radio3.addActionListener(l);
        radio4.addActionListener(l);
        radio5.addActionListener(l);
    }
    /*private void resize(){
        double xFactor;
        double yFactor;
        xFactor = ((double)(this.getWidth()))/(originalW);
        yFactor = ((double)(this.getHeight()))/(originalH);
        this.scalingTransform = new AffineTransform();
        this.inverseScalingTransform = new AffineTransform();
        this.scalingTransform.scale(xFactor,yFactor);
        this.inverseScalingTransform.scale(1D/xFactor,1D/yFactor);
        
        originalW = this.getWidth();
        originalH = this.getHeight();
    }*/
}

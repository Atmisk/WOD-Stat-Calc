/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Mike
 * 
 * A RadioPanel is made up of 5 radio buttons aligned horizontally and is used
 * to display a value from 0 to 5, starting from the left to right.
 */
public class RadioPanel extends JPanel implements ActionListener{
//    private final int COLUMNS = 5;
//    private final int NONE = 0;
    
    private int value;
    
    private ArrayList<ActionListener> aListeners = new ArrayList<>();
    // <editor-fold defaultstate="collapsed" desc="button selection code">
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(radio1)){
            // If the first(left-most) button is already selected
            // deselect the others as well
            if(((JRadioButton)e.getSource()).isSelected()){
                radio2.setSelected(false);
                radio3.setSelected(false);
                radio4.setSelected(false);
                radio5.setSelected(false);
                value = 1;
            }
            // If the second(from left) button is selected  
            // deselct all buttons except the first
            else if(radio2.isSelected()){
                radio1.setSelected(true);
                radio2.setSelected(false);
                radio3.setSelected(false);
                radio4.setSelected(false);
                radio5.setSelected(false);
                value = 1;
            }
            // If the first is the only selected, deselect
            else{
                radio1.setSelected(false);
                radio2.setSelected(false);
                radio3.setSelected(false);
                radio4.setSelected(false);
                radio5.setSelected(false);
                value = 0;
            }
            notifyListeners();

        }
        else if(e.getSource().equals(radio2)){
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
            value = 2;
            notifyListeners();
        }
        else if(e.getSource().equals(radio3)){
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
            value = 3;
            notifyListeners();
        }
        else if(e.getSource().equals(radio4)){
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
            value = 4;
            notifyListeners();
        }
        else if(e.getSource().equals(radio5)){
            if(((JRadioButton)e.getSource()).isSelected()){
                radio1.setSelected(true);
                radio2.setSelected(true);
                radio3.setSelected(true);
                radio4.setSelected(true);
            }
            else{
                radio5.setSelected(true);
            }
            value = 5;
            notifyListeners();
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="unused vars for resizing">
    //private AffineTransform scalingTransform;
    //private AffineTransform inverseScalingTransform;
    //double originalW = this.getWidth();
    //double originalH = this.getHeight();
    // </editor-fold>
    
    private JRadioButton radio1 = new JRadioButton();
    
    // <editor-fold defaultstate="collapsed" desc="Code for repainting">
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
    // </editor-fold>
    
    private JRadioButton radio2 = new JRadioButton();
    private JRadioButton radio3 = new JRadioButton();
    private JRadioButton radio4 = new JRadioButton();
    private JRadioButton radio5 = new JRadioButton();
    
    private EmptyBorder noBorder = new EmptyBorder(new Insets(0, 0, 0, 0));
    
    private GridBagLayout layout = new GridBagLayout();
    
    private ActionEvent event = new ActionEvent(this, 1, "Select");
    
    /**
     * Base Constructor
     */
    public RadioPanel(){
        InitRadPan();
    }
    /**
     * Constructor That sets initial value to the RadioPanel
     * 
     * @param rank Integer representing the initial value
     */
    public RadioPanel(int rank){
        InitRadPan();
        setValue(rank);
    }
    
    /**
     * Constructor that sets the components size if a look and feel has been
     * set and supports a size change
     * 
     * @param size string that sets the size for the components. Can be "large"
     * or "small".
     */
    public RadioPanel(String size){
        InitRadPan();
        
        switch(size){
            case "large":
                radio1.putClientProperty("JComponent.sizeVariant", "large");
                radio2.putClientProperty("JComponent.sizeVariant", "large");
                radio3.putClientProperty("JComponent.sizeVariant", "large");
                radio4.putClientProperty("JComponent.sizeVariant", "large");
                radio5.putClientProperty("JComponent.sizeVariant", "large");
                break;
            case "small":
                radio1.putClientProperty("JComponent.sizeVariant", "small");
                radio2.putClientProperty("JComponent.sizeVariant", "small");
                radio3.putClientProperty("JComponent.sizeVariant", "small");
                radio4.putClientProperty("JComponent.sizeVariant", "small");
                radio5.putClientProperty("JComponent.sizeVariant", "small");
        }
    }
    
    /**
     * Initializes the component. Used by constructors.
     */
    private void InitRadPan(){
        value = 0;
        Dimension dim = new Dimension(115, 18);
        
        this.setLayout(layout);
        
        //this.setBackground(Color.red);
        
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
        
        //SwingUtilities.updateComponentTreeUI(this);
        
        radio1.addActionListener(this);
        radio2.addActionListener(this);
        radio3.addActionListener(this);
        radio4.addActionListener(this);
        radio5.addActionListener(this);
        
        this.setMinimumSize(dim);
    }

    /**
     * getValue returns the stored value of the radio panel
     * 
     * @return the rank set in the radio panel
     */
    public final int getValue(){
        return value;
    }
    /**
     * 
     * @param value 
     */
    public final void setValue(int value){
        switch(value){
            case 0:
                this.value = value;
                radio1.setSelected(false);
                radio2.setSelected(false);
                radio3.setSelected(false);
                radio4.setSelected(false);
                radio5.setSelected(false);
                break;
            case 1:
                this.value = value;
                if(!radio1.isSelected()){
                    radio1.doClick();
                }
                break;
            case 2:
                this.value = value;
                radio2.doClick();
                break;
            case 3:
                this.value = value;
                radio3.doClick();
                break;
            case 4:
                this.value = value;
                radio4.doClick();
                break;
            case 5:
                this.value = value;
                radio5.doClick();
                break;
            default:
                if(value > 5){
                    this.value = 5;
                    radio5.doClick();
                }
                else{
                    this.value = 0;
                    radio1.setSelected(false);
                    radio2.setSelected(false);
                    radio3.setSelected(false);
                    radio4.setSelected(false);
                    radio5.setSelected(false);
                }
        }
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
    private void notifyListeners(){
        for(ActionListener listen : aListeners){
            listen.actionPerformed(event);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="unused function for resize">
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
    // </editor-fold>
}

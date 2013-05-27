/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 * TabButton creates a label and a button for closing a tabbed panel
 *
 * @author Mike
 */
public class TabClose extends JPanel {
    private final JTabbedPane pane;
    private final ArrayList<StatPanel> paneList;
    private FlowLayout layout;
    private ArrayList <ActionListener> actList = new ArrayList();
    private ActionEvent tClose = new ActionEvent(this, 1, "Tab Closed");
    
    public TabClose(final JTabbedPane aPane, final ArrayList<StatPanel> aPaneList){
        layout = new FlowLayout();
        this.setLayout(layout);
        if (aPane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = aPane;
        if(aPaneList == null){
            throw new NullPointerException("ArrayList is null");
        }
        this.paneList = aPaneList;
        JLabel title = new JLabel() {
            @Override
            public String getText() {
                int i = pane.indexOfTabComponent(TabClose.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };
        
        closeButton close = new closeButton();
        
        add(title);
        add(close);
    }
    
    private class closeButton extends JButton {
        public closeButton(){
            int size = 17;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("Close Character Sheet");
            //Make the button look the same for all Laf's
            setUI(new BasicButtonUI());
            //Make it transparent
            setContentAreaFilled(false);
            //No need to be focusable
            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            //Making nice rollover effect
            //we use the same listener for all buttons
            addMouseListener(buttonMouseListener);
            setRolloverEnabled(true);
            //Close the proper tab by clicking the button
            addActionListener(new closeListener());
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            //shift the image for pressed buttons
            if (getModel().isPressed()) {
                g2.translate(1, 1);
            }
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                g2.setColor(Color.RED);
            }
            int delta = 5;
            g2.drawLine(delta, delta, getWidth() - delta - 1,
                        getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta,
                        getHeight() - delta - 1);
            //g2.drawOval(delta - 3 , delta - 3, getHeight() - delta, 
              //          getWidth() - delta);
            g2.dispose();
        }

        @Override
        public void updateUI() {}
    }
    
    private final static MouseListener buttonMouseListener = new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                Component component = e.getComponent();
                if (component instanceof AbstractButton) {
                    AbstractButton button = (AbstractButton) component;
                    button.setBorderPainted(true);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Component component = e.getComponent();
                if (component instanceof AbstractButton) {
                    AbstractButton button = (AbstractButton) component;
                    button.setBorderPainted(false);
                }
            }
        };
    
    private final class closeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfTabComponent(TabClose.this);
            boolean cancel = false;
            if (i != -1) {
                // have changes been made? if so ask user if they wish to save
                if(paneList.get(i).changeMade){
                    int c = JOptionPane.showConfirmDialog(pane,
                            "Would you like to save changes?");
                    try {
                        switch(c){
                            case JOptionPane.YES_OPTION:
                                paneList.get(i).saveStats();
                                break;
                            case JOptionPane.CANCEL_OPTION:
                                cancel = true;
                                break;
                            case JOptionPane.CLOSED_OPTION:
                                cancel = true;
                                break;
                            case JOptionPane.NO_OPTION:
                                break;
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(TabClose.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
                if(!cancel){
                    pane.remove(i);
                    paneList.remove(i);
                    NotifyListeners();
                }
            }
        }
    }
    
    public void AddActionListener(ActionListener l){
        actList.add(l);
    }
    
    private void NotifyListeners(){
        for(ActionListener listen : actList){
            listen.actionPerformed(tClose);
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * TabButton creates a label and a button for closing a tabbed panel
 *
 * @author Mike
 */
public class TabClose extends JPanel {
    private final JTabbedPane pane;
    private final ArrayList<StatPanel> aList;
    private FlowLayout layout;
    
    public TabClose(final JTabbedPane pane, final ArrayList<StatPanel> aList){
        layout = new FlowLayout();
        this.setLayout(layout);
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = pane;
        if(aList == null){
            throw new NullPointerException("ArrayList is null");
        }
        this.aList = aList;
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
        
        JButton close = new JButton("X");
        //close.setPreferredSize(new Dimension(20, 20));
        close.setToolTipText("Close Character Sheet");
        close.addActionListener(new closeListener());
        
        add(title);
        add(close);
    }
    
    private final class closeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfTabComponent(TabClose.this);
            if (i != -1) {
                pane.remove(i);
                aList.remove(i);
            }
        }
    }
}

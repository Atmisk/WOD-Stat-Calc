/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mike
 */
public class CharacterSheetGUI extends JFrame{
    
    private class menuItemListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(newFile)){
                mainTabPane.addTab("New Character", new StatPanel());
            }
        }
    }
    
    StatPanel statPanel = new StatPanel();    // CHANGE TO NEW CLASS
    StatPanel statPanel2 = new StatPanel();
    
    JTabbedPane mainTabPane = new JTabbedPane();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem newFile = new JMenuItem("New");
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new CharacterSheetGUI().setVisible(true);
            }
        });
    }
    
    public CharacterSheetGUI(){
        createAndShowGUI();
        //strPanel.addActionListener(statListen);
    }
    
    public final void createAndShowGUI(){
        //JFrame mainFrame = new JFrame("Character Sheet");
        
        newFile.addActionListener(new menuItemListener());
        menuBar.add(fileMenu);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 600));
        this.setJMenuBar(menuBar);
        
        //statPanel.setLayout(mainLayout);// CHANGE TO NEW CLASS
        
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    
        
        
//        Stat testStat = new Stat("Repair", 7);
//        c = setGridPos(0, 20, 0);
//        statPanel.add(testStat, c);
//        
//        Detail testDetail = new Detail("Blargh", "Wort");
//        c = setGridPos(0, 21, 0);
//        statPanel.add(testDetail, c);
        
        //mainTabPane.addTab("Tab", statPanel);
        //mainTabPane.addTab("Tab2", statPanel2);
        this.add(mainTabPane);
        this.pack();
        this.setLocationRelativeTo(null); // set frame to center of screen
        this.setVisible(true);
    }
    
//    private JScrollPane newScrollTab(StatPanel panel){
//        return new JScrollPane(panel);
//    }
}

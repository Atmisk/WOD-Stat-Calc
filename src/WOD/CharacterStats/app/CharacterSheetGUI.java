/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import PlayerStats.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mike
 */
public class CharacterSheetGUI extends JFrame{
    BaseStats stats;
    
    private class menuItemListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource().equals(newFile)){
                mainTabPane.addTab("Character", newScrollTab(new StatPanel()));
            }
        }
    }
    
    /**class StatListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(strPanel)){
                
            }
            else if(e.getSource().equals(dexPanel)){
                
            }
            else if(e.getSource().equals(stamPanel)){
                
            }
            else if(e.getSource().equals(charisPanel)){
                
            }
            else if(e.getSource().equals(manipPanel)){
                
            }
            else if(e.getSource().equals(appearPanel)){
                
            }
            else if(e.getSource().equals(perceptPanel)){
                
            }
            else if(e.getSource().equals(intPanel)){
                
            }
            else if(e.getSource().equals(witsPanel)){
                
            }
            
            else if(e.getSource().equals(alertPanel)){
                
            }
            else if(e.getSource().equals(athletPanel)){
                
            }
            else if(e.getSource().equals(brawlPanel)){
                
            }
            else if(e.getSource().equals(dodgePanel)){
                
            }
            else if(e.getSource().equals(empathyPanel)){
                
            }
            else if(e.getSource().equals(expressPanel)){
                
            }
            else if(e.getSource().equals(intimidatePanel)){
                
            }
            else if(e.getSource().equals(primalPanel)){
                
            }
            else if(e.getSource().equals(streetPanel)){
                
            }
            else if(e.getSource().equals(subterPanel)){
                
            }
            
            else if(e.getSource().equals(animalPanel)){
                
            }
            else if(e.getSource().equals(craftPanel)){
                
            }
            else if(e.getSource().equals(drivePanel)){
                
            }
            else if(e.getSource().equals(etiquettePanel)){
                
            }
            else if(e.getSource().equals(firearmPanel)){
                
            }
            else if(e.getSource().equals(meleePanel)){
                
            }
            else if(e.getSource().equals(leaderPanel)){
                
            }
            else if(e.getSource().equals(performPanel)){
                
            }
            else if(e.getSource().equals(stealthPanel)){
                
            }
            else if(e.getSource().equals(survivePanel)){
                
            }
            
            else if(e.getSource().equals(compPanel)){
                
            }
            else if(e.getSource().equals(enigmaPanel)){
                
            }
            else if(e.getSource().equals(investigatePanel)){
                
            }
            else if(e.getSource().equals(lawPanel)){
                
            }
            else if(e.getSource().equals(linguistPanel)){
                
            }
            else if(e.getSource().equals(medicPanel)){
                
            }
            else if(e.getSource().equals(occultPanel)){
                
            }
            else if(e.getSource().equals(politicsPanel)){
                
            }
            else if(e.getSource().equals(ritualsPanel)){
                
            }
            else if(e.getSource().equals(sciencePanel)){
                
            }
        }  
    }*/
    
    StatPanel statPanel = new StatPanel();    // CHANGE TO NEW CLASS
    StatPanel statPanel2 = new StatPanel();
    
    JTabbedPane mainTabPane = new JTabbedPane();
    //JScrollPane mainSPane = new JScrollPane(statPanel);// REPLACE MAINPANEL
    
    
    //StatListener statListen = new StatListener();
    
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
        
        mainTabPane.addTab("Tab", newScrollTab(statPanel));
        mainTabPane.addTab("Tab2", newScrollTab(statPanel2));
        this.add(mainTabPane);
        this.pack();
        this.setLocationRelativeTo(null); // set frame to center of screen
        this.setVisible(true);
    }
    
    private JScrollPane newScrollTab(StatPanel panel){
        return new JScrollPane(panel);
    }
}

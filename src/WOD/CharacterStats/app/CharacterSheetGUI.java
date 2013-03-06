/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import PlayerStats.BaseStats.Race;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                panelList.add(new StatPanel());
                mainTabPane.addTab(
                        "New Character", panelList.get(panelList.size()-1));
            }
            else if(e.getSource().equals(saveFile)){
                int index;
                index = mainTabPane.getSelectedIndex();
                try {
                    panelList.get(index).saveStats();
                    panelList.get(index).changeMade = false;
                    mainTabPane.setTitleAt(index, panelList.get(index)
                                                  .name.detail.getText());
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(
                            CharacterSheetGUI.class.getName()).log(
                                Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource().equals(openFile)){
                panelList.add(new StatPanel());
                mainTabPane.addTab("Character", panelList.get(panelList.size()-1));
                try {
                    openType = fileChooser.showOpenDialog(null);
                    if(openType == JFileChooser.APPROVE_OPTION){
                        panelList.get(
                                panelList.size()-1).loadStats(
                                    fileChooser.getSelectedFile()
                                    .getName(), Race.WOLF);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(
                            CharacterSheetGUI.class.getName()).log(
                                Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    JTabbedPane mainTabPane = new JTabbedPane();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem newFile = new JMenuItem("New");
    JMenuItem saveFile = new JMenuItem("Save");
    JFileChooser fileChooser = new JFileChooser();
    int openType = 0;
    
    ArrayList<StatPanel> panelList = new ArrayList<>();
    
    
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
    }
    
    public final void createAndShowGUI(){
        
        newFile.addActionListener(new menuItemListener());
        saveFile.addActionListener(new menuItemListener());
        openFile.addActionListener(new menuItemListener());
        menuBar.add(fileMenu);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 600));
        this.setJMenuBar(menuBar);
        
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.add(mainTabPane);
        this.pack();
        this.setLocationRelativeTo(null); // set frame to center of screen
        this.setVisible(true);
    }
}

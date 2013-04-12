/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import PlayerStats.BaseStats;
import PlayerStats.BaseStats.Race;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Mike
 */
public class CharacterSheetGUI extends JFrame implements ActionListener{
    // <editor-fold defaultstate="collapsed" desc="menu selection code">
    @Override
    public void actionPerformed(ActionEvent e){
        JFileChooser fileChooser = new JFileChooser(
                System.getProperty("user.dir"));
        String dir = System.getProperty("user.dir");
        String fileName;
        BaseStats stats;
        String charName;
        Race race;
        int index = 0;
        int openType;
        if(e.getSource().equals(wolfSheet)){
            panelList.add(new WerewolfPanel());
            index = panelList.size()-1;
            mainTabPane.addTab(
                    "New Character", panelList.get(index));
            mainTabPane.setSelectedIndex(index);
            //mainTabPane.setMinimumSize(panelList.get(index).getMinimumSize());
            //setMinSize(mainTabPane.getMinimumSize());
        }
        else if(e.getSource().equals(foxSheet)){
            panelList.add(new WerefoxPanel());
            index = panelList.size()-1;
            mainTabPane.addTab(
                    "New Character", panelList.get(index));
            mainTabPane.setSelectedIndex(index);
        }
        else if(e.getSource().equals(saveFile)){
            index = mainTabPane.getSelectedIndex();
            try {
                panelList.get(index).saveStats();
                panelList.get(index).changeMade = false;
                mainTabPane.setTitleAt(index, panelList.get(index)
                                              .nameField.getText());
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(
                        CharacterSheetGUI.class.getName()).log(
                            Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource().equals(openFile)){
            openType = fileChooser.showOpenDialog(null);
            if(openType == JFileChooser.APPROVE_OPTION){
                fileName = fileChooser.getSelectedFile().getName();
                
                try {
                    stats = BaseStats.LoadStats(fileName, dir);
                    charName = stats.getCName();
                    race = stats.getRace();
                    switch(race){
                        case WOLF:
                            panelList.add(new WerewolfPanel());
                            break;
                        case FOX:
                            panelList.add(new WerefoxPanel());
                            break;
                        default:
                    }
                    index = panelList.size()-1;
                    if(charName != null){
                        mainTabPane.addTab(charName, panelList.get(index));
                    }
                    else{
                        mainTabPane.addTab("Character", panelList.get(index));
                    }
                    panelList.get(index).loadStats(fileName);
                    mainTabPane.setSelectedIndex(index);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(
                            CharacterSheetGUI.class.getName()).log(
                            Level.SEVERE, null, ex);
                    panelList.remove(index);
                    mainTabPane.remove(index);
                }
            }

        }
    }
    // </editor-fold>
    JTabbedPane mainTabPane = new JTabbedPane();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem openFile = new JMenuItem("Open");
    JMenu newFile = new JMenu("New");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem wolfSheet = new JMenuItem("Garou - Werewolf");
    JMenuItem foxSheet = new JMenuItem("Kitsune - Werefox");
    
    ArrayList<StatPanel> panelList = new ArrayList<>();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                setLaF();
                new CharacterSheetGUI().setVisible(true);
            }
        });
    }
    
    public CharacterSheetGUI(){
        InitMenuItems();
        menuBar.add(fileMenu);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        newFile.add(wolfSheet);
        newFile.add(foxSheet);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 600));
        this.setJMenuBar(menuBar);
        
        this.add(mainTabPane);
        this.pack();
        this.setLocationRelativeTo(null); // set frame to center of screen
        this.setVisible(true);
    }
    
    private void InitMenuItems(){
        wolfSheet.addActionListener(this);
        foxSheet.addActionListener(this);
        saveFile.addActionListener(this);
        openFile.addActionListener(this);
        
    }
    
    private static void setLaF(){
        try{
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (Exception e){
        }
    }
}

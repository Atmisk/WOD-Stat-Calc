/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import PlayerStats.BaseStats;
import PlayerStats.WerefoxStats;
import PlayerStats.WerewolfStats;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
    // <editor-fold defaultstate="collapsed" desc="menu selection and tab closing code">
    @Override
    public void actionPerformed(ActionEvent e){
        JFileChooser fileChooser = new JFileChooser(
                System.getProperty("user.dir"));
        String dir = System.getProperty("user.dir");
        String fileName;
        BaseStats stats;
        String charName;
        int index = 0;
        int openType;
        TabClose tabClose;
        
        if(e.getSource().equals(wolfSheet)){
            panelList.add(new WerewolfPanel());
            index = panelList.size()-1;

            mainTabPane.addTab(
                    "New Werewolf", panelList.get(index));
            tabClose = new TabClose(mainTabPane, panelList);
            tabClose.AddActionListener(this);
            mainTabPane.setTabComponentAt(index, tabClose);
            mainTabPane.setSelectedIndex(index);
            // activae save button
            if(!saveFile.isEnabled()){
                saveFile.setEnabled(true);
            }
            setWinSize();
        }
        else if(e.getSource().equals(foxSheet)){
            panelList.add(new WerefoxPanel());
            index = panelList.size()-1;
            mainTabPane.addTab(
                    "New Werefox", panelList.get(index));
            tabClose = new TabClose(mainTabPane, panelList);
            tabClose.AddActionListener(this);
            mainTabPane.setTabComponentAt(index, tabClose);
            mainTabPane.setSelectedIndex(index);
            // activae save button
            if(!saveFile.isEnabled()){
                saveFile.setEnabled(true);
            }
            setWinSize();
        }
        else if(e.getSource().equals(saveFile)){
            index = mainTabPane.getSelectedIndex();
            if(index != -1){
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
        }
        else if(e.getSource().equals(openFile)){
            openType = fileChooser.showOpenDialog(null);
            if(openType == JFileChooser.APPROVE_OPTION){
                fileName = fileChooser.getSelectedFile().getName();

                try {
                    stats = BaseStats.LoadStats(fileName, dir);
                    charName = stats.getCName();
                    if(stats instanceof WerewolfStats) {
                        panelList.add(new WerewolfPanel());
                    }
                    else if(stats instanceof WerefoxStats){
                        panelList.add(new WerefoxPanel());
                    }
                    index = panelList.size()-1;
                    if(charName != null){
                        mainTabPane.addTab(charName, panelList.get(index));
                    }
                    else{
                        mainTabPane.addTab("Character", panelList.get(index));
                    }
                    panelList.get(index).loadStats(fileName);
                    tabClose = new TabClose(mainTabPane, panelList);
                    tabClose.AddActionListener(this);
                    mainTabPane.setTabComponentAt(index, tabClose);
                    mainTabPane.setSelectedIndex(index);
                    // activae save button
                    if(!saveFile.isEnabled()){
                        saveFile.setEnabled(true);
                    }
                    setWinSize();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(
                            CharacterSheetGUI.class.getName()).log(
                            Level.SEVERE, null, ex);
                    panelList.remove(index);
                    mainTabPane.remove(index);
                }
            }
        }
        else if (e.getSource() instanceof TabClose){
            if(panelList.isEmpty()){
                saveFile.setEnabled(false);
            }
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Window state code">
    private WindowListener winLis = new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent e) {
            ArrayList <Integer> indecis = new ArrayList();
            boolean needToSave = false;
            boolean cancel = false;
            for(StatPanel panel : panelList){
                if(panel.changeMade){
                    indecis.add(panelList.indexOf(panel));
                    if(!needToSave){
                        needToSave = true;
                    }
                }
            }
            if(needToSave){
                int c = JOptionPane.showConfirmDialog(null,
                        "Would you like to save changes?");
                try {
                    switch(c){
                        case JOptionPane.YES_OPTION:
                            for(Integer ind : indecis){
                                panelList.get(ind).saveStats();
                            }
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
                mainFrame.dispose();
            }
        }
    };
    // </editor-fold>
    
    private static JFrame mainFrame;
    private JTabbedPane mainTabPane = new JTabbedPane();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem openFile = new JMenuItem("Open");
    private JMenu newFile = new JMenu("New");
    private JMenuItem saveFile = new JMenuItem("Save");
    private JMenuItem wolfSheet = new JMenuItem("Garou - Werewolf");
    private JMenuItem foxSheet = new JMenuItem("Kitsune - Werefox");
    
    ArrayList<StatPanel> panelList = new ArrayList<>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                setLaF();
                mainFrame = new CharacterSheetGUI();
                mainFrame.setVisible(true);
            }
        });
    }
    
    public CharacterSheetGUI(){
        this.addWindowListener(winLis);
        InitMenuItems();
        menuBar.add(fileMenu);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        newFile.add(wolfSheet);
        newFile.add(foxSheet);
        
        saveFile.setEnabled(false);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setJMenuBar(menuBar);
        
        this.add(mainTabPane);
        this.pack();
        this.setVisible(true);
        this.setSize(new Dimension(600, 600));
        this.setLocationRelativeTo(null); // set frame to center of screen
        this.setResizable(false);
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
        }catch (Exception e){}
    }
    
    private void setWinSize(){
        this.setSize(this.getPreferredSize());
        // set frame to center of screen
        this.setLocationRelativeTo(null); 
    }
}

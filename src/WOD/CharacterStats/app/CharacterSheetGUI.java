/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import PlayerStats.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mike
 */
public class CharacterSheetGUI extends JFrame{
    BaseStats stats;
    
    /*class StatListener implements ActionListener{
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
    
    JPanel mainPanel = new JPanel();
    JTabbedPane mainTabPane = new JTabbedPane();
    JScrollPane mainSPane = new JScrollPane(mainPanel);
    GridBagLayout mainLayout = new GridBagLayout();
    GridBagConstraints c;
    //StatListener statListen = new StatListener();
    
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem newFile = new JMenuItem("New");
        
    Detail name = new Detail("Name");
    Detail breed = new Detail("Breed");
    Detail player = new Detail("Player");
    Detail tribe = new Detail("Tribe");
    Detail auspice = new Detail("Auspice");
    Detail camp = new Detail("Camp");
    Detail pack = new Detail("Pack");
    Detail totem = new Detail("Totem");

    JLabel attrLabel = new JLabel("Attributes", JLabel.CENTER);
    JLabel physLabel = new JLabel("Physical", JLabel.CENTER);
    JLabel socialLabel = new JLabel("Social", JLabel.CENTER);
    JLabel mentalLabel = new JLabel("Mental", JLabel.CENTER);
    JLabel abilityLabel = new JLabel("Abilities", JLabel.CENTER);
    JLabel talentLabel = new JLabel("Talents", JLabel.CENTER);
    JLabel skillLabel = new JLabel("Skills", JLabel.CENTER);
    JLabel knowLabel = new JLabel("Knowledges", JLabel.CENTER);
    Font font;

    Stat str = new Stat("Strength");
    Stat dex = new Stat("Dexterity");
    Stat stam = new Stat("Stamina");

    Stat charis = new Stat("Charisma");
    Stat manip = new Stat("Manipulation");
    Stat appear = new Stat("Appearance");

    Stat percept = new Stat("Perception");
    Stat intel = new Stat("Inteligence");
    Stat wits = new Stat("Wits");

    Stat alert = new Stat("Alertness");
    Stat athlet = new Stat("Athletics");
    Stat brawl = new Stat("Brawl");
    Stat dodge = new Stat("Dodge");
    Stat empathy = new Stat("Empathy");
    Stat express = new Stat("Expression");
    Stat intimidate = new Stat("Intimidate");
    Stat primal = new Stat("Pimal Urge");
    Stat streetwise = new Stat("Streetwise");
    Stat subter = new Stat("Subterfuge");

    Stat animalKen = new Stat("Animal Ken");
    Stat crafts = new Stat("Crafts");
    Stat drive = new Stat("Drive");
    Stat etiquette = new Stat("Etiquette");
    Stat firearm = new Stat("Firearms");
    Stat leader = new Stat("Leadership");
    Stat melee = new Stat("Melee");
    Stat perform = new Stat("Perform");
    Stat stealth = new Stat("Stealth");
    Stat survive = new Stat("Survival");

    Stat comp = new Stat("Computers");
    Stat enigma = new Stat("Enigma");
    Stat investigate = new Stat("Investigate");
    Stat law = new Stat("Law");
    Stat linguist = new Stat("Linquistics");
    Stat medic = new Stat("Medicine");
    Stat occult = new Stat("Occult");
    Stat politics = new Stat("Politics");
    Stat rituals = new Stat("Rituals");
    Stat science = new Stat("Science");
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
        
        menuBar.add(fileMenu);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(700, 600));
        this.setJMenuBar(menuBar);
        mainPanel.setLayout(mainLayout); //READ MORE ON THIS
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    
        //----------------------------------------------------------------------
        // CHARACTER INFO
        
        c = setGridPos(0 ,0, 5);
        mainPanel.add(name, c);
        
        c = setGridPos(1, 0, 5);
        mainPanel.add(breed, c);
        
        c = setGridPos(2, 0, 5);
        mainPanel.add(pack, c);
        
        c = setGridPos(0, 1, 5);
        mainPanel.add(player, c);
        
        c = setGridPos(1, 1, 5);
        mainPanel.add(auspice, c);
        
        c = setGridPos(2, 1, 5);
        mainPanel.add(totem, c);
        
        c = setGridPos(0, 2, 5);
        mainPanel.add(tribe, c);
        
        c = setGridPos(1, 2, 5);
        mainPanel.add(camp, c);
        
        //----------------------------------------------------------------------
        // ATTRIBUTES
        
        c = setLabelPos(1, 3);
        font = new Font(attrLabel.getFont().getName(), Font.PLAIN, 20);
        attrLabel.setFont(font);
        mainPanel.add(attrLabel, c);
        
        c = setLabelPos(0, 4);
        font = new Font(physLabel.getFont().getName(), Font.PLAIN, 16);
        physLabel.setFont(font);
        mainPanel.add(physLabel, c);
        
        c = setGridPos(0, 5, 0);
        mainPanel.add(str, c);
        
        c = setGridPos(0, 6, 0);
        mainPanel.add(dex, c);
        
        c = setGridPos(0, 7, 0);
        mainPanel.add(stam, c);
        
        c = setLabelPos(1, 4);
        font = new Font(socialLabel.getFont().getName(), Font.PLAIN, 16);
        socialLabel.setFont(font);
        mainPanel.add(socialLabel, c);
        
        c = setGridPos(1, 5, 0);
        mainPanel.add(charis, c);
        
        c = setGridPos(1, 6, 0);
        mainPanel.add(manip, c);
        
        c = setGridPos(1, 7, 0);
        mainPanel.add(appear, c);
        
        c = setLabelPos(2, 4);
        font = new Font(mentalLabel.getFont().getName(), Font.PLAIN, 16);
        mentalLabel.setFont(font);
        mainPanel.add(mentalLabel, c);
        
        c = setGridPos(2, 5, 0);
        mainPanel.add(percept, c);
        
        c = setGridPos(2, 6, 0);
        mainPanel.add(intel, c);
        
        c = setGridPos(2, 7, 0);
        mainPanel.add(wits, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - TALENTS
        
        c = setLabelPos(1, 8);
        font = new Font(abilityLabel.getFont().getName(), Font.PLAIN, 20);
        abilityLabel.setFont(font);
        mainPanel.add(abilityLabel, c);
        
        c = setLabelPos(0, 9);
        font = new Font(talentLabel.getFont().getName(), Font.PLAIN, 16);
        talentLabel.setFont(font);
        mainPanel.add(talentLabel, c);
        
        c = setGridPos(0, 10, 0);
        mainPanel.add(alert, c);
        
        c = setGridPos(0, 11, 0);
        mainPanel.add(athlet, c);
        
        c = setGridPos(0, 12, 0);
        mainPanel.add(brawl, c);
        
        c = setGridPos(0, 13, 0);
        mainPanel.add(dodge, c);
        
        c = setGridPos(0, 14, 0);
        mainPanel.add(empathy, c);
        

        c = setGridPos(0, 15, 0);
        mainPanel.add(express, c);
        
        c = setGridPos(0, 16, 0);
        mainPanel.add(intimidate, c);
        
        c = setGridPos(0, 17, 0);
        mainPanel.add(primal, c);
        
        c = setGridPos(0, 18, 0);
        mainPanel.add(streetwise, c);
        
        c = setGridPos(0, 19, 0);
        mainPanel.add(subter, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - SKILLS
        
        c = setLabelPos(1, 9);
        font = new Font(skillLabel.getFont().getName(), Font.PLAIN, 16);
        skillLabel.setFont(font);
        mainPanel.add(skillLabel, c);
        
        c = setGridPos(1, 10, 0);
        mainPanel.add(animalKen, c);
        
        c = setGridPos(1, 11, 0);
        mainPanel.add(crafts, c);
        
        c = setGridPos(1, 12, 0);
        mainPanel.add(drive, c);
        
        c = setGridPos(1, 13, 0);
        mainPanel.add(etiquette, c);
        
        c = setGridPos(1, 14, 0);
        mainPanel.add(firearm, c);
        
        c = setGridPos(1, 15, 0);
        mainPanel.add(leader, c);
        
        c = setGridPos(1, 16, 0);
        mainPanel.add(melee, c);
        
        c = setGridPos(1, 17, 0);
        mainPanel.add(perform, c);
        
        c = setGridPos(1, 18, 0);
        mainPanel.add(stealth, c);
        
        c = setGridPos(1, 19, 0);
        mainPanel.add(survive, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - KNOWLEDGES
        
        c = setLabelPos(2, 9);
        font = new Font(knowLabel.getFont().getName(), Font.PLAIN, 16);
        knowLabel.setFont(font);
        mainPanel.add(knowLabel, c);
        
        c = setGridPos(2, 10, 0);
        mainPanel.add(comp, c);
        
        c = setGridPos(2, 11, 0);
        mainPanel.add(enigma, c);
        
        c = setGridPos(2, 12, 0);
        mainPanel.add(investigate, c);
        
        c = setGridPos(2, 13, 0);
        mainPanel.add(law, c);
        
        c = setGridPos(2, 14, 0);
        mainPanel.add(linguist, c);

        c = setGridPos(2, 15, 0);
        mainPanel.add(medic, c);

        c = setGridPos(2, 16, 0);
        mainPanel.add(occult, c);

        c = setGridPos(2, 17, 0);
        mainPanel.add(politics, c);
        
        c = setGridPos(2, 18, 0);
        mainPanel.add(rituals, c);
        
        c = setGridPos(2, 19, 0);
        mainPanel.add(science, c);
        
//        Stat testStat = new Stat("Repair", 7);
//        c = setGridPos(0, 20, 0);
//        mainPanel.add(testStat, c);
//        
//        Detail testDetail = new Detail("Blargh", "Wort");
//        c = setGridPos(0, 21, 0);
//        mainPanel.add(testDetail, c);
        
        mainTabPane.addTab("Tab", mainSPane);
        mainTabPane.addTab("Tab2", new JPanel());
        this.add(mainTabPane);
        this.pack();
        this.setLocationRelativeTo(null); // set frame to center of screen
        this.setVisible(true);
    }
    
    private static GridBagConstraints setGridPos(int x, int y, int yGap){
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.ipadx = 10;
        c.insets = new Insets(yGap,0,0,0);
        c.gridx = x;
        c.gridy = y;
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }
    
    private static GridBagConstraints setLabelPos(int x, int y){
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.insets = new Insets(10,0,0,0);
        c.gridwidth = 1;
        c.gridx = x;
        c.gridy = y;
        return c;
    }
}

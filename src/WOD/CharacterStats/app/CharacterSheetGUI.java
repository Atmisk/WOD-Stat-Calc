/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Mike
 */
public class CharacterSheetGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createAndShowGUI();
    }
    
    public static void createAndShowGUI(){
        JFrame mainFrame = new JFrame("Character Sheet");
        JPanel mainPanel = new JPanel();
        JTabbedPane mainTabPane = new JTabbedPane();
        JScrollPane mainSPane = new JScrollPane(mainPanel);
        GridBagLayout mainLayout = new GridBagLayout();
        GridBagConstraints c;
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openFile = new JMenuItem("Open");
        JMenuItem newFile = new JMenuItem("New");
        
        JLabel nameLabel = new JLabel("Name");
        JTextField nameField = new JTextField(10);
        JLabel breedLabel = new JLabel("Breed");
        JTextField breedField = new JTextField(10);
        JLabel playerLabel = new JLabel("Player");
        JTextField playerField = new JTextField(10);
        JLabel tribeLabel = new JLabel("Tribe");
        JTextField tribeField = new JTextField(10);
        JLabel auspiceLabel = new JLabel("Auspice");
        JTextField auspiceField = new JTextField(10);
        JLabel campLabel = new JLabel("Camp");
        JTextField campField = new JTextField(10);
        JLabel packLabel = new JLabel("Pack");
        JTextField packField = new JTextField(10);
        JLabel totemLabel = new JLabel("Totem");
        JTextField totemField = new JTextField(10);
        
        JLabel attrLabel = new JLabel("Attributes", JLabel.CENTER);
        JLabel physLabel = new JLabel("Physical", JLabel.CENTER);
        JLabel socialLabel = new JLabel("Social", JLabel.CENTER);
        JLabel mentalLabel = new JLabel("Mental", JLabel.CENTER);
        JLabel abilityLabel = new JLabel("Abilities", JLabel.CENTER);
        JLabel talentLabel = new JLabel("Talents", JLabel.CENTER);
        JLabel skillLabel = new JLabel("Skills", JLabel.CENTER);
        JLabel knowLabel = new JLabel("Knowledges", JLabel.CENTER);
        Font font;
        
        JLabel strLbl = new JLabel("Strength");
        RadioPanel strPanel = new RadioPanel();
        JLabel dexLbl = new JLabel("Dexterity");
        RadioPanel dexPanel = new RadioPanel();
        JLabel stamLbl = new JLabel("Stamina");
        RadioPanel stamPanel = new RadioPanel();
        
        JLabel charisLbl = new JLabel("Charisma");
        RadioPanel charisPanel = new RadioPanel();
        JLabel manipLbl = new JLabel("Manipulation");
        RadioPanel manipPanel = new RadioPanel();
        JLabel appearLbl = new JLabel("Appearance");
        RadioPanel appearPanel = new RadioPanel();
        
        JLabel perceptLbl = new JLabel("Perception");
        RadioPanel perceptPanel = new RadioPanel();
        JLabel intLbl = new JLabel("Intelligence");
        RadioPanel intPanel = new RadioPanel();
        JLabel witsLbl = new JLabel("Wits");
        RadioPanel witsPanel = new RadioPanel();
        
        JLabel alertLbl = new JLabel("Alertness");
        RadioPanel alertPanel = new RadioPanel();
        JLabel athletLbl = new JLabel("Athletics");
        RadioPanel athletPanel = new RadioPanel();
        JLabel brawlLbl = new JLabel("Brawl");
        RadioPanel brawlPanel = new RadioPanel();
        JLabel dodgeLbl = new JLabel("Dodge");
        RadioPanel dodgePanel = new RadioPanel();
        JLabel empathyLbl = new JLabel("Empathy");
        RadioPanel empathyPanel = new RadioPanel();
        JLabel expressLbl = new JLabel("Expression");
        RadioPanel expressPanel = new RadioPanel();
        JLabel intimidateLbl = new JLabel("Intimidation");
        RadioPanel intimidatePanel = new RadioPanel();
        JLabel primalLbl = new JLabel("Pimal-Urge");
        RadioPanel primalPanel = new RadioPanel();
        JLabel streetwiseLbl = new JLabel("Streetwise");
        RadioPanel streetPanel = new RadioPanel();
        JLabel subterLbl = new JLabel("Subterfuge");
        RadioPanel subterPanel = new RadioPanel();
        
        JLabel animalKenLbl = new JLabel("Animale Ken");
        RadioPanel animalPanel = new RadioPanel();
        JLabel craftLbl = new JLabel("Crafts");
        RadioPanel craftPanel = new RadioPanel();
        JLabel driveLbl = new JLabel("Drive");
        RadioPanel drivePanel = new RadioPanel();
        JLabel etiquetteLbl = new JLabel("Etiquette");
        RadioPanel etiquettePanel = new RadioPanel();
        JLabel firearmLbl = new JLabel("Firearms");
        RadioPanel firearmPanel = new RadioPanel();
        JLabel leaderLbl = new JLabel("Leadership");
        RadioPanel leaderPanel = new RadioPanel();
        JLabel meleeLbl = new JLabel("Melee");
        RadioPanel meleePanel = new RadioPanel();
        JLabel performLbl = new JLabel("Performance");
        RadioPanel performPanel = new RadioPanel();
        JLabel stealthLbl = new JLabel("Stealth");
        RadioPanel stealthPanel = new RadioPanel();
        JLabel surviveLbl = new JLabel("Survival");
        RadioPanel survivePanel = new RadioPanel();
        
        JLabel compLbl = new JLabel("Computer");
        RadioPanel compPanel = new RadioPanel();
        JLabel enigmaLbl = new JLabel("Enigmas");
        RadioPanel enigmaPanel = new RadioPanel();
        JLabel investigateLbl = new JLabel("Investigation");
        RadioPanel investigatePanel = new RadioPanel();
        JLabel lawLbl = new JLabel("Law");
        RadioPanel lawPanel = new RadioPanel();
        JLabel linguistLbl = new JLabel("Linquistics");
        RadioPanel linguistPanel = new RadioPanel();
        JLabel medicLbl = new JLabel("Medicine");
        RadioPanel medicPanel = new RadioPanel();
        JLabel occultLbl = new JLabel("Occult");
        RadioPanel occultPanel = new RadioPanel();
        JLabel politicsLbl = new JLabel("Politics");
        RadioPanel politicsPanel = new RadioPanel();
        JLabel ritualsLbl = new JLabel("Rituals");
        RadioPanel ritualsPanel = new RadioPanel();
        JLabel scienceLbl = new JLabel("Science");
        RadioPanel sciencePanel = new RadioPanel();
        
        menuBar.add(fileMenu);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setPreferredSize(new Dimension(800, 600));
        mainFrame.setJMenuBar(menuBar);
        mainPanel.setLayout(mainLayout); //READ MORE ON THIS        
    
        //----------------------------------------------------------------------
        // CHARACTER INFO
        
        c = setGridPos(0 ,0);
        // might help with window alignment
        //c.fill = GridBagConstraints.BOTH;
        //c.anchor = GridBagConstraints.NORTHWEST;
        mainPanel.add(nameLabel, c);
        c = setGridPos(1, 0);
        //nameField.setText("Name");
        mainPanel.add(nameField, c);
        
        c = setGridPos(2, 0);
        mainPanel.add(breedLabel, c);
        c = setGridPos(3, 0);
        //breedField.setText("Breed");
        mainPanel.add(breedField, c);
        
        c = setGridPos(4, 0);
        mainPanel.add(packLabel, c);
        c = setGridPos(5, 0);
        //packField.setText("Pack");
        mainPanel.add(packField, c);
        
        c = setGridPos(0, 1);
        mainPanel.add(playerLabel, c);
        c = setGridPos(1, 1);
        //playerField.setText("Player");
        mainPanel.add(playerField, c);
        
        c = setGridPos(0, 2);
        mainPanel.add(tribeLabel, c);
        c = setGridPos(1, 2);
        //tribeField.setText("Tribe");
        mainPanel.add(tribeField, c);
        
        c = setGridPos(2, 1);
        mainPanel.add(auspiceLabel, c);
        c = setGridPos(3, 1);
        //auspiceField.setText("Auspice");
        mainPanel.add(auspiceField, c);
        
        c = setGridPos(2, 2);
        mainPanel.add(campLabel, c);
        c = setGridPos(3, 2);
        //campField.setText("Camp");
        mainPanel.add(campField, c);
        
        c = setGridPos(4, 1);
        mainPanel.add(totemLabel, c);
        c = setGridPos(5, 1);
        //totemField.setText("Totem");
        mainPanel.add(totemField, c);
        
        //----------------------------------------------------------------------
        // ATTRIBUTES
        
        c = setLabelPos(2, 3);
        font = new Font(attrLabel.getFont().getName(), Font.PLAIN, 20);
        attrLabel.setFont(font);
        mainPanel.add(attrLabel, c);
        
        c = setLabelPos(0, 4);
        font = new Font(physLabel.getFont().getName(), Font.PLAIN, 16);
        physLabel.setFont(font);
        mainPanel.add(physLabel, c);
        
        c = setGridPos(0, 5);
        mainPanel.add(strLbl,c);
        c = setGridPos(1, 5);
        mainPanel.add(strPanel, c);
        
        c = setGridPos(0, 6);
        mainPanel.add(dexLbl,c);
        c = setGridPos(1, 6);
        mainPanel.add(dexPanel, c);
        
        c = setGridPos(0, 7);
        mainPanel.add(stamLbl,c);
        c = setGridPos(1, 7);
        mainPanel.add(stamPanel, c);
        
        c = setLabelPos(2, 4);
        font = new Font(socialLabel.getFont().getName(), Font.PLAIN, 16);
        socialLabel.setFont(font);
        mainPanel.add(socialLabel, c);
        
        c = setGridPos(2, 5);
        mainPanel.add(charisLbl,c);
        c = setGridPos(3, 5);
        mainPanel.add(charisPanel, c);
        
        c = setGridPos(2, 6);
        mainPanel.add(manipLbl,c);
        c = setGridPos(3, 6);
        mainPanel.add(manipPanel, c);
        
        c = setGridPos(2, 7);
        mainPanel.add(appearLbl,c);
        c = setGridPos(3, 7);
        mainPanel.add(appearPanel, c);
        
        c = setLabelPos(4, 4);
        font = new Font(mentalLabel.getFont().getName(), Font.PLAIN, 16);
        mentalLabel.setFont(font);
        mainPanel.add(mentalLabel, c);
        
        c = setGridPos(4, 5);
        mainPanel.add(perceptLbl,c);
        c = setGridPos(5, 5);
        mainPanel.add(perceptPanel, c);
        
        c = setGridPos(4, 6);
        mainPanel.add(intLbl,c);
        c = setGridPos(5, 6);
        mainPanel.add(intPanel, c);
        
        c = setGridPos(4, 7);
        mainPanel.add(witsLbl,c);
        c = setGridPos(5, 7);
        mainPanel.add(witsPanel, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - TALENTS
        
        c = setLabelPos(2, 8);
        font = new Font(abilityLabel.getFont().getName(), Font.PLAIN, 20);
        abilityLabel.setFont(font);
        mainPanel.add(abilityLabel, c);
        
        c = setLabelPos(0, 9);
        font = new Font(talentLabel.getFont().getName(), Font.PLAIN, 16);
        talentLabel.setFont(font);
        mainPanel.add(talentLabel, c);
        
        c = setGridPos(0, 10);
        mainPanel.add(alertLbl,c);
        c = setGridPos(1, 10);
        mainPanel.add(alertPanel, c);
        
        c = setGridPos(0, 11);
        mainPanel.add(athletLbl,c);
        c = setGridPos(1, 11);
        mainPanel.add(athletPanel, c);
        
        c = setGridPos(0, 12);
        mainPanel.add(brawlLbl,c);
        c = setGridPos(1, 12);
        mainPanel.add(brawlPanel, c);
        
        c = setGridPos(0, 13);
        mainPanel.add(dodgeLbl,c);
        c = setGridPos(1, 13);
        mainPanel.add(dodgePanel, c);
        
        c = setGridPos(0, 14);
        mainPanel.add(empathyLbl,c);
        c = setGridPos(1, 14);
        mainPanel.add(empathyPanel, c);
        

        c = setGridPos(0, 15);
        mainPanel.add(expressLbl,c);
        c = setGridPos(1, 15);
        mainPanel.add(expressPanel, c);
        
        c = setGridPos(0, 16);
        mainPanel.add(intimidateLbl,c);
        c = setGridPos(1, 16);
        mainPanel.add(intimidatePanel, c);
        
        c = setGridPos(0, 17);
        mainPanel.add(primalLbl,c);
        c = setGridPos(1, 17);
        mainPanel.add(primalPanel, c);
        
        c = setGridPos(0, 18);
        mainPanel.add(streetwiseLbl,c);
        c = setGridPos(1, 18);
        mainPanel.add(streetPanel, c);
        
        c = setGridPos(0, 19);
        mainPanel.add(subterLbl,c);
        c = setGridPos(1, 19);
        mainPanel.add(subterPanel, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - SKILLS
        
        c = setLabelPos(2, 9);
        font = new Font(skillLabel.getFont().getName(), Font.PLAIN, 16);
        skillLabel.setFont(font);
        mainPanel.add(skillLabel, c);
        
        c = setGridPos(2, 10);
        mainPanel.add(animalKenLbl,c);
        c = setGridPos(3, 10);
        mainPanel.add(animalPanel, c);
        
        c = setGridPos(2, 11);
        mainPanel.add(craftLbl,c);
        c = setGridPos(3, 11);
        mainPanel.add(craftPanel, c);
        
        c = setGridPos(2, 12);
        mainPanel.add(driveLbl,c);
        c = setGridPos(3, 12);
        mainPanel.add(drivePanel, c);
        
        c = setGridPos(2, 13);
        mainPanel.add(etiquetteLbl,c);
        c = setGridPos(3, 13);
        mainPanel.add(etiquettePanel, c);
        
        c = setGridPos(2, 14);
        mainPanel.add(firearmLbl,c);
        c = setGridPos(3, 14);
        mainPanel.add(firearmPanel, c);
        
        c = setGridPos(2, 15);
        mainPanel.add(leaderLbl,c);
        c = setGridPos(3, 15);
        mainPanel.add(leaderPanel, c);
        
        c = setGridPos(2, 16);
        mainPanel.add(meleeLbl,c);
        c = setGridPos(3, 16);
        mainPanel.add(meleePanel, c);
        
        c = setGridPos(2, 17);
        mainPanel.add(performLbl,c);
        c = setGridPos(3, 17);
        mainPanel.add(performPanel, c);
        
        c = setGridPos(2, 18);
        mainPanel.add(stealthLbl,c);
        c = setGridPos(3, 18);
        mainPanel.add(stealthPanel, c);
        
        c = setGridPos(2, 19);
        mainPanel.add(surviveLbl,c);
        c = setGridPos(3, 19);
        mainPanel.add(survivePanel, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - KNOWLEDGES
        
        c = setLabelPos(4, 9);
        font = new Font(knowLabel.getFont().getName(), Font.PLAIN, 16);
        knowLabel.setFont(font);
        mainPanel.add(knowLabel, c);
        
        c = setGridPos(4, 10);
        mainPanel.add(compLbl,c);
        c = setGridPos(5, 10);
        mainPanel.add(compPanel, c);
        
        c = setGridPos(4, 11);
        mainPanel.add(enigmaLbl,c);
        c = setGridPos(5, 11);
        mainPanel.add(enigmaPanel, c);
        
        c = setGridPos(4, 12);
        mainPanel.add(investigateLbl,c);
        c = setGridPos(5, 12);
        mainPanel.add(investigatePanel, c);
        
        c = setGridPos(4, 13);
        mainPanel.add(lawLbl,c);
        c = setGridPos(5, 13);
        mainPanel.add(lawPanel, c);
        
        c = setGridPos(4, 14);
        mainPanel.add(linguistLbl,c);
        c = setGridPos(5, 14);
        mainPanel.add(linguistPanel, c);
        
        c = setGridPos(4, 15);
        mainPanel.add(medicLbl,c);
        c = setGridPos(5, 15);
        mainPanel.add(medicPanel, c);
        
        c = setGridPos(4, 16);
        mainPanel.add(occultLbl,c);
        c = setGridPos(5, 16);
        mainPanel.add(occultPanel, c);
        
        c = setGridPos(4, 17);
        mainPanel.add(politicsLbl,c);
        c = setGridPos(5, 17);
        mainPanel.add(politicsPanel, c);
        
        c = setGridPos(4, 18);
        mainPanel.add(ritualsLbl,c);
        c = setGridPos(5, 18);
        mainPanel.add(ritualsPanel, c);
        
        c = setGridPos(4, 19);
        mainPanel.add(scienceLbl,c);
        c = setGridPos(5, 19);
        mainPanel.add(sciencePanel, c);
        
        mainFrame.add(mainSPane);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null); // set frame to center of screen
        mainFrame.setVisible(true);
    }
    
    private static GridBagConstraints setGridPos(int x, int y){
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.ipadx = 5;
        c.insets = new Insets(10,0,0,0);
        // might help with window alignment
        //c.weightx = 1;
        //c.weighty = 1;
        c.gridx = x;
        c.gridy = y;
        c.anchor = GridBagConstraints.WEST;
        return c;
    }
    
    private static GridBagConstraints setLabelPos(int x, int y){
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.insets = new Insets(10,0,0,0);
        c.gridwidth = 2;
        c.gridx = x;
        c.gridy = y;
        return c;
    }
}

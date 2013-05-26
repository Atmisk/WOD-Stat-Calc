/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.*;


/* 
 * GUI uses a GridBagLayout and goes 6 columns wide
 * 
 * lines are generally formated like this:
 *  0     1          2     3          4     5
 * Label radioPanel label radioPanel label radioPanel
 *       ___________
 *   0  |0|1|2|3|4|5|
 *   1  | | | | | | |
 *   .
 *   .
 *   .  |_|_|_|_|_|_|
 */

/**
 * StatPanel is a base GUI class to use as a base for the various character
 * sheet GUI's
 * 
 * @author Mike
 */
public abstract class StatPanel extends JScrollPane {
    final private int initRank = 1;
    final protected String prototypeString= "Item############";
    
    // <editor-fold defaultstate="collapsed" desc="variables and components">
    public boolean changeMade = false;
    
    protected JPanel panel = new JPanel();
    private GridBagLayout mainLayout = new GridBagLayout();
    protected GridBagConstraints c;
    
    protected JLabel title = new JLabel("Title");

    //<editor-fold defaultstate="collapsed" desc="Detail labels">
    private JLabel name          = new JLabel("Name");
    private JLabel player        = new JLabel("Player");
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Section Labels">
    private JLabel attrLabel     = new JLabel("Attributes", JLabel.CENTER);
    private JLabel physLabel     = new JLabel("Physical", JLabel.CENTER);
    private JLabel socialLabel   = new JLabel("Social", JLabel.CENTER);
    private JLabel mentalLabel   = new JLabel("Mental", JLabel.CENTER);
    private JLabel abilityLabel  = new JLabel("Abilities", JLabel.CENTER);
    private JLabel talentLabel   = new JLabel("Talents", JLabel.CENTER);
    private JLabel skillLabel    = new JLabel("Skills", JLabel.CENTER);
    private JLabel knowLabel     = new JLabel("Knowledges", JLabel.CENTER);
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Attribute and Ability labels">
    protected JLabel strength      = new JLabel("Strength");
    protected JLabel dexterity     = new JLabel("Dexterity");
    protected JLabel stamina       = new JLabel("Stamina");
    protected JLabel charisma      = new JLabel("Charisma");
    protected JLabel manipulation  = new JLabel("Manipulation");
    protected JLabel appearance    = new JLabel("Appearance");
    protected JLabel perception    = new JLabel("Perception");
    protected JLabel inteligence   = new JLabel("Intelligence");
    protected JLabel wits          = new JLabel("Wits");
    protected JLabel alertLabel    = new JLabel("Alertness");
    protected JLabel athletLabel   = new JLabel("Athletics");
    protected JLabel brawlLabel    = new JLabel("Brawl");
    protected JLabel dodgeLabel    = new JLabel("Dodge");
    protected JLabel empLabel      = new JLabel("Empathy");
    protected JLabel expressLabel  = new JLabel("Expression");
    protected JLabel intimLabel    = new JLabel("Intimidate");
    protected JLabel primalLabel   = new JLabel("Primal Urge");
    protected JLabel streetLabel   = new JLabel("Streetwise");
    protected JLabel subterLabel   = new JLabel("Subterfuge");
    protected JLabel animalLabel   = new JLabel("Animal Ken");
    protected JLabel craftLabel    = new JLabel("Crafts");
    protected JLabel driveLabel    = new JLabel("Drive");
    protected JLabel etiquLabel    = new JLabel("Etiquette");
    protected JLabel fireLabel     = new JLabel("Firearms");
    protected JLabel leadLabel     = new JLabel("Leadership");
    protected JLabel meleeLabel    = new JLabel("Melee");
    protected JLabel performLabel  = new JLabel("Performance");
    protected JLabel stealthLabel  = new JLabel("Stealth");
    protected JLabel survivalLabel = new JLabel("Survival");
    protected JLabel compLabel     = new JLabel("Computers");
    protected JLabel enigmaLabel   = new JLabel("Enigmas");
    protected JLabel invesLabel    = new JLabel("Investigate");
    protected JLabel lawLabel      = new JLabel("Law");
    protected JLabel linguistLabel = new JLabel("Linquistics");
    protected JLabel medicLabel    = new JLabel("Medicine");
    protected JLabel occultLabel   = new JLabel("Occult");
    protected JLabel politicsLabel = new JLabel("Politics");
    protected JLabel ritualsLabel  = new JLabel("Rituals");
    protected JLabel scienceLabel  = new JLabel("Science");
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Health level labels">
    private JLabel healthLabel    = new JLabel("Health", JLabel.CENTER);
    private JLabel bruiseLabel    = new JLabel("Bruised");
    private JLabel hurtLabel      = new JLabel("Hurt");
    private JLabel injureLabel    = new JLabel("Injured");
    private JLabel woundLabel     = new JLabel("Wounded");
    private JLabel maulLabel      = new JLabel("Mauled");
    private JLabel crippledLabel  = new JLabel("Crippled");
    private JLabel incapacitLabel = new JLabel("Incapacitated");
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Textfields">
    protected JTextField nameField   = new JTextField();
    protected JTextField playerField = new JTextField();
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RadioPanels">
    protected RadioPanel str         = new RadioPanel(initRank);
    protected RadioPanel dex         = new RadioPanel(initRank);
    protected RadioPanel stam        = new RadioPanel(initRank);
    protected RadioPanel manip       = new RadioPanel(initRank);
    protected RadioPanel appear      = new RadioPanel(initRank);
    protected RadioPanel charis      = new RadioPanel(initRank);
    protected RadioPanel percept     = new RadioPanel(initRank);
    protected RadioPanel intel       = new RadioPanel(initRank);
    protected RadioPanel wit         = new RadioPanel(initRank);
    protected RadioPanel alert       = new RadioPanel();
    protected RadioPanel athlet      = new RadioPanel();
    protected RadioPanel brawl       = new RadioPanel();
    protected RadioPanel dodge       = new RadioPanel();
    protected RadioPanel empathy     = new RadioPanel();
    protected RadioPanel express     = new RadioPanel();
    protected RadioPanel intimidate  = new RadioPanel();
    protected RadioPanel primalUrge  = new RadioPanel();
    protected RadioPanel streetwise  = new RadioPanel();
    protected RadioPanel subterfuge  = new RadioPanel();
    protected RadioPanel animalKen   = new RadioPanel();
    protected RadioPanel crafts      = new RadioPanel();
    protected RadioPanel drive       = new RadioPanel();
    protected RadioPanel etiquette   = new RadioPanel();
    protected RadioPanel firearms    = new RadioPanel();
    protected RadioPanel leadership  = new RadioPanel();
    protected RadioPanel melee       = new RadioPanel();
    protected RadioPanel perform     = new RadioPanel();
    protected RadioPanel stealth     = new RadioPanel();
    protected RadioPanel survival    = new RadioPanel();
    protected RadioPanel computers   = new RadioPanel();
    protected RadioPanel enigmas     = new RadioPanel();
    protected RadioPanel investigate = new RadioPanel();
    protected RadioPanel law         = new RadioPanel();
    protected RadioPanel linguist    = new RadioPanel();
    protected RadioPanel medicine    = new RadioPanel();
    protected RadioPanel occult      = new RadioPanel();
    protected RadioPanel politics    = new RadioPanel();
    protected RadioPanel rituals     = new RadioPanel();
    protected RadioPanel science     = new RadioPanel();
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Unused Modifiers">
//    protected Modifier strMod         = new Modifier();
//    protected Modifier dexMod         = new Modifier();
//    protected Modifier stamMod        = new Modifier();
//    protected Modifier manipMod       = new Modifier();
//    protected Modifier appearMod      = new Modifier();
//    protected Modifier charisMod      = new Modifier();
//    protected Modifier perceptMod     = new Modifier();
//    protected Modifier intelMod       = new Modifier();
//    protected Modifier witMod         = new Modifier();
//    protected Modifier alertMod       = new Modifier();
//    protected Modifier athletMod      = new Modifier();
//    protected Modifier brawlMod       = new Modifier();
//    protected Modifier dodgeMod       = new Modifier();
//    protected Modifier empathyMod     = new Modifier();
//    protected Modifier expressMod     = new Modifier();
//    protected Modifier intimidateMod  = new Modifier();
//    protected Modifier primalUrgeMod  = new Modifier();
//    protected Modifier streetwiseMod  = new Modifier();
//    protected Modifier subterfugeMod  = new Modifier();
//    protected Modifier animalKenMod   = new Modifier();
//    protected Modifier craftsMod      = new Modifier();
//    protected Modifier driveMod       = new Modifier();
//    protected Modifier etiquetteMod   = new Modifier();
//    protected Modifier firearmsMod    = new Modifier();
//    protected Modifier leadershipMod  = new Modifier();
//    protected Modifier meleeMod       = new Modifier();
//    protected Modifier performMod     = new Modifier();
//    protected Modifier stealthMod     = new Modifier();
//    protected Modifier survivalMod    = new Modifier();
//    protected Modifier computersMod   = new Modifier();
//    protected Modifier enigmasMod     = new Modifier();
//    protected Modifier investigateMod = new Modifier();
//    protected Modifier lawMod         = new Modifier();
//    protected Modifier linguistMod    = new Modifier();
//    protected Modifier medicineMod    = new Modifier();
//    protected Modifier occultMod      = new Modifier();
//    protected Modifier politicsMod    = new Modifier();
//    protected Modifier ritualsMod     = new Modifier();
//    protected Modifier scienceMod     = new Modifier();
    // </editor-fold>
    
    private JButton moreAbilities = new JButton("More");
    
    protected Font font;
    // </editor-fold>
    
    public StatPanel(){
        this.setViewportView(panel);
        panel.setLayout(mainLayout);
        
        // COL 2-3 ROW 0
        c = setLabelPos(2, 0);
        font = new Font(title.getFont().getName(), Font.PLAIN, 30);
        title.setFont(font);
        panel.add(title, c);
        
        //----------------------------------------------------------------------
        // CHARACTER INFO
        
        // This section takes up rows 1-3
        c = setGridPos(0 ,1);
        panel.add(name, c);
        
        c = setGridPos(1 ,1);
        panel.add(nameField, c);
        //---------------------//
        c = setGridPos(0, 2);
        panel.add(player, c);
        
        c = setGridPos(1, 2);
        panel.add(playerField, c);
        
        //----------------------------------------------------------------------
        // ATTRIBUTES
        
        // Label sits at row 4
        c = setLabelPos(2, 4);
        font = new Font(attrLabel.getFont().getName(), Font.PLAIN, 20);
        attrLabel.setFont(font);
        panel.add(attrLabel, c);
        
        // Label sits at row 5
        c = setLabelPos(0, 5);
        font = new Font(physLabel.getFont().getName(), Font.PLAIN, 16);
        physLabel.setFont(font);
        panel.add(physLabel, c);
        
        // This section extends from row 6 - 8
        c = setGridPos(0, 6);
        panel.add(strength, c);
        
        c = setGridPos(1, 6);
        panel.add(str, c);
        //---------------------//
        c = setGridPos(0, 7);
        panel.add(dexterity, c);
        
        c = setGridPos(1, 7);
        panel.add(dex, c);
        //---------------------//
        c = setGridPos(0, 8);
        panel.add(stamina, c);
        
        c = setGridPos(1, 8);
        panel.add(stam, c);
        //---------------------//
        
        // Label sits at row 5
        c = setLabelPos(2, 5);
        font = new Font(socialLabel.getFont().getName(), Font.PLAIN, 16);
        socialLabel.setFont(font);
        panel.add(socialLabel, c);
        
        c = setGridPos(2, 6);
        panel.add(charisma, c);
        
        c = setGridPos(3, 6);
        panel.add(charis, c);
        //---------------------//
        c = setGridPos(2, 7);
        panel.add(manipulation, c);
        
        c = setGridPos(3, 7);
        panel.add(manip, c);
        //---------------------//
        c = setGridPos(2, 8);
        panel.add(appearance, c);
        
        c = setGridPos(3, 8);
        panel.add(appear, c);
        //---------------------//
        
        // Label sits at row 5
        c = setLabelPos(4, 5);
        font = new Font(mentalLabel.getFont().getName(), Font.PLAIN, 16);
        mentalLabel.setFont(font);
        panel.add(mentalLabel, c);
        
        c = setGridPos(4, 6);
        panel.add(perception, c);
        
        c = setGridPos(5, 6);
        panel.add(percept, c);
        //---------------------//
        c = setGridPos(4, 7);
        panel.add(inteligence, c);
        
        c = setGridPos(5, 7);
        panel.add(intel, c);
        //---------------------//
        c = setGridPos(4, 8);
        panel.add(wits, c);
        
        c = setGridPos(5, 8);
        panel.add(wit, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - TALENTS
        
        // Label sits at row 9
        c = setLabelPos(2, 9);
        font = new Font(abilityLabel.getFont().getName(), Font.PLAIN, 20);
        abilityLabel.setFont(font);
        panel.add(abilityLabel, c);
        
        // Label sits at row 10
        c = setLabelPos(0, 10);
        font = new Font(talentLabel.getFont().getName(), Font.PLAIN, 16);
        talentLabel.setFont(font);
        panel.add(talentLabel, c);
        
        c = setGridPos(0, 11);
        panel.add(alertLabel, c);
        
        c = setGridPos(1, 11);
        panel.add(alert, c);
        //---------------------//
        c = setGridPos(0, 12);
        panel.add(athletLabel, c);
        
        c = setGridPos(1, 12);
        panel.add(athlet, c);
        //---------------------//
        c = setGridPos(0, 13);
        panel.add(brawlLabel, c);
        
        c = setGridPos(1, 13);
        panel.add(brawl, c);
        //---------------------//
        c = setGridPos(0, 14);
        panel.add(dodgeLabel, c);
        
        c = setGridPos(1, 14);
        panel.add(dodge, c);
        //---------------------//        
        c = setGridPos(0, 15);
        panel.add(empLabel, c);
        
        c = setGridPos(1, 15);
        panel.add(empathy, c);
        //---------------------//
        c = setGridPos(0, 16);
        panel.add(expressLabel, c);
        
        c = setGridPos(1, 16);
        panel.add(express, c);
        //---------------------//
        c = setGridPos(0, 17);
        panel.add(intimLabel, c);
        
        c = setGridPos(1, 17);
        panel.add(intimidate, c);
        //---------------------//
        c = setGridPos(0, 18);
        panel.add(primalLabel, c);
        
        c = setGridPos(1, 18);
        panel.add(primalUrge, c);
        //---------------------//
        c = setGridPos(0, 19);
        panel.add(streetLabel, c);
        
        c = setGridPos(1, 19);
        panel.add(streetwise, c);
        //---------------------//
        c = setGridPos(0, 20);
        panel.add(subterLabel, c);
        
        c = setGridPos(1, 20);
        panel.add(subterfuge, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - SKILLS
        
        // Label sits at row 10
        c = setLabelPos(2, 10);
        font = new Font(skillLabel.getFont().getName(), Font.PLAIN, 16);
        skillLabel.setFont(font);
        panel.add(skillLabel, c);
        
        c = setGridPos(2, 11);
        panel.add(animalLabel, c);
        
        c = setGridPos(3, 11);
        panel.add(animalKen, c);
        //---------------------//
        c = setGridPos(2, 12);
        panel.add(craftLabel, c);
        
        c = setGridPos(3, 12);
        panel.add(crafts, c);
        //---------------------//
        c = setGridPos(2, 13);
        panel.add(driveLabel, c);
        
        c = setGridPos(3, 13);
        panel.add(drive, c);
        //---------------------//
        c = setGridPos(2, 14);
        panel.add(etiquLabel, c);
        
        c = setGridPos(3, 14);
        panel.add(etiquette, c);
        //---------------------//
        c = setGridPos(2, 15);
        panel.add(fireLabel, c);
        
        c = setGridPos(3, 15);
        panel.add(firearms, c);
        //---------------------//
        c = setGridPos(2, 16);
        panel.add(leadLabel, c);
        
        c = setGridPos(3, 16);
        panel.add(leadership, c);
        //---------------------//
        c = setGridPos(2, 17);
        panel.add(meleeLabel, c);
        
        c = setGridPos(3, 17);
        panel.add(melee, c);
        //---------------------//
        c = setGridPos(2, 18);
        panel.add(performLabel, c);
        
        c = setGridPos(3, 18);
        panel.add(perform, c);
        //---------------------//
        c = setGridPos(2, 19);
        panel.add(stealthLabel, c);
        
        c = setGridPos(3, 19);
        panel.add(stealth, c);
        //---------------------//
        c = setGridPos(2, 20);
        panel.add(survivalLabel, c);
        
        c = setGridPos(3, 20);
        panel.add(survival, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - KNOWLEDGES
        
        // Label sits at row 10
        c = setLabelPos(4, 10);
        font = new Font(knowLabel.getFont().getName(), Font.PLAIN, 16);
        knowLabel.setFont(font);
        panel.add(knowLabel, c);
        
        c = setGridPos(4, 11);
        panel.add(compLabel, c);
        
        c = setGridPos(5, 11);
        panel.add(computers, c);
        //---------------------//
        c = setGridPos(4, 12);
        panel.add(enigmaLabel, c);
        
        c = setGridPos(5, 12);
        panel.add(enigmas, c);
        //---------------------//
        c = setGridPos(4, 13);
        panel.add(invesLabel, c);
        
        c = setGridPos(5, 13);
        panel.add(investigate, c);
        //---------------------//
        c = setGridPos(4, 14);
        panel.add(lawLabel, c);
        
        c = setGridPos(5, 14);
        panel.add(law, c);
        //---------------------//
        c = setGridPos(4, 15);
        panel.add(linguistLabel, c);

        c = setGridPos(5, 15);
        panel.add(linguist, c);
        //---------------------//
        c = setGridPos(4, 16);
        panel.add(medicLabel, c);

        c = setGridPos(5, 16);
        panel.add(medicine, c);
        //---------------------//
        c = setGridPos(4, 17);
        panel.add(occultLabel, c);

        c = setGridPos(5, 17);
        panel.add(occult, c);
        //---------------------//
        c = setGridPos(4, 18);
        panel.add(politicsLabel, c);
        
        c = setGridPos(5, 18);
        panel.add(politics, c);
        //---------------------//
        c = setGridPos(4, 19);
        panel.add(ritualsLabel, c);
        
        c = setGridPos(5, 19);
        panel.add(rituals, c);
        //---------------------//
        c = setGridPos(4, 20);
        panel.add(scienceLabel, c);
        
        c = setGridPos(5, 20);
        panel.add(science, c);
        //---------------------//
        // Button for more abilities/ability editing
        c = setLabelPos(0, 21);
        panel.add(moreAbilities, c);
        
        //----------------------------------------------------------------------
        // HEALTH SECTION
        
        // Label sits at row 22
        c = setLabelPos(4, 22);
        panel.add(healthLabel, c);
        
        c = setGridPos(4, 23);
        panel.add(bruiseLabel, c);
        
        c = setGridPos(4, 24);
        panel.add(hurtLabel, c);
        
        c = setGridPos(4, 25);
        panel.add(injureLabel, c);
        
        c = setGridPos(4, 26);
        panel.add(woundLabel, c);
        
        c = setGridPos(4, 27);
        panel.add(maulLabel, c);
        
        c = setGridPos(4, 28);
        panel.add(crippledLabel, c);
        
        c = setGridPos(4, 29);
        panel.add(incapacitLabel, c);
        //---------------------//
        
    }
    
    /**
     * 
     * @param x horizontal position in grid
     * @param y vertical position in grid
     * 
     * @return a GridBagConstraints object
     */
    protected static GridBagConstraints setGridPos(int x, int y){
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.ipadx = 10;
        c.insets = new Insets(0,0,0,0);
        c.gridx = x;
        c.gridy = y;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }
    
    protected static GridBagConstraints setLabelPos(int x, int y){
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.insets = new Insets(5,0,5,0);
        c.gridwidth = 2;
        c.gridx = x;
        c.gridy = y;
        return c;
    }
    
    public abstract void saveStats()throws IOException, ClassNotFoundException;
    
    public abstract void loadStats(String charName) 
            throws IOException, ClassNotFoundException;
    
    protected abstract void initStats();
}
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


/**
 *
 * @author Mike
 * 
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
public abstract class StatPanel extends JScrollPane {
    final private int initRank = 1;
    
    // <editor-fold defaultstate="collapsed" desc="variables and components">
    boolean changeMade = false;
    
    JPanel panel = new JPanel();
    GridBagLayout mainLayout = new GridBagLayout();
    GridBagConstraints c;

    //<editor-fold defaultstate="collapsed" desc="Detail labels">
    JLabel name          = new JLabel("Name");
    JLabel player        = new JLabel("Player");
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Section Labels">
    JLabel attrLabel     = new JLabel("Attributes", JLabel.CENTER);
    JLabel physLabel     = new JLabel("Physical", JLabel.CENTER);
    JLabel socialLabel   = new JLabel("Social", JLabel.CENTER);
    JLabel mentalLabel   = new JLabel("Mental", JLabel.CENTER);
    JLabel abilityLabel  = new JLabel("Abilities", JLabel.CENTER);
    JLabel talentLabel   = new JLabel("Talents", JLabel.CENTER);
    JLabel skillLabel    = new JLabel("Skills", JLabel.CENTER);
    JLabel knowLabel     = new JLabel("Knowledges", JLabel.CENTER);
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Attribute and Ability labels">
    JLabel strength      = new JLabel("Strength");
    JLabel dexterity     = new JLabel("Dexterity");
    JLabel stamina       = new JLabel("Stamina");
    JLabel charisma      = new JLabel("Charisma");
    JLabel manipulation  = new JLabel("Manipulation");
    JLabel appearance    = new JLabel("Appearance");
    JLabel perception    = new JLabel("Perception");
    JLabel inteligence   = new JLabel("Intelligence");
    JLabel wits          = new JLabel("Wits");
    JLabel alertLabel    = new JLabel("Alertness");
    JLabel athletLabel   = new JLabel("Athletics");
    JLabel brawlLabel    = new JLabel("Brawl");
    JLabel dodgeLabel    = new JLabel("Dodge");
    JLabel empLabel      = new JLabel("Empathy");
    JLabel expressLabel  = new JLabel("Expression");
    JLabel intimLabel    = new JLabel("Intimidate");
    JLabel primalLabel   = new JLabel("Primal Urge");
    JLabel streetLabel   = new JLabel("Streetwise");
    JLabel subterLabel   = new JLabel("Subterfuge");
    JLabel animalLabel   = new JLabel("Animal Ken");
    JLabel craftLabel    = new JLabel("Crafts");
    JLabel driveLabel    = new JLabel("Drive");
    JLabel etiquLabel    = new JLabel("Etiquette");
    JLabel fireLabel     = new JLabel("Firearms");
    JLabel leadLabel     = new JLabel("Leadership");
    JLabel meleeLabel    = new JLabel("Melee");
    JLabel performLabel  = new JLabel("Performance");
    JLabel stealthLabel  = new JLabel("Stealth");
    JLabel survivalLabel = new JLabel("Survival");
    JLabel compLabel     = new JLabel("Computers");
    JLabel enigmaLabel   = new JLabel("Enigmas");
    JLabel invesLabel    = new JLabel("Investigate");
    JLabel lawLabel      = new JLabel("Law");
    JLabel linguistLabel = new JLabel("Linquistics");
    JLabel medicLabel    = new JLabel("Medicine");
    JLabel occultLabel   = new JLabel("Occult");
    JLabel politicsLabel = new JLabel("Politics");
    JLabel ritualsLabel  = new JLabel("Rituals");
    JLabel scienceLabel  = new JLabel("Science");
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Textfields">
    JTextField nameField   = new JTextField();
    JTextField playerField = new JTextField();
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="RadioPanels">
    RadioPanel str         = new RadioPanel(initRank);
    RadioPanel dex         = new RadioPanel(initRank);
    RadioPanel stam        = new RadioPanel(initRank);
    RadioPanel manip       = new RadioPanel(initRank);
    RadioPanel appear      = new RadioPanel(initRank);
    RadioPanel charis      = new RadioPanel(initRank);
    RadioPanel percept     = new RadioPanel(initRank);
    RadioPanel intel       = new RadioPanel(initRank);
    RadioPanel wit         = new RadioPanel(initRank);
    RadioPanel alert       = new RadioPanel();
    RadioPanel athlet      = new RadioPanel();
    RadioPanel brawl       = new RadioPanel();
    RadioPanel dodge       = new RadioPanel();
    RadioPanel empathy     = new RadioPanel();
    RadioPanel express     = new RadioPanel();
    RadioPanel intimidate  = new RadioPanel();
    RadioPanel primalUrge  = new RadioPanel();
    RadioPanel streetwise  = new RadioPanel();
    RadioPanel subterfuge  = new RadioPanel();
    RadioPanel animalKen   = new RadioPanel();
    RadioPanel crafts      = new RadioPanel();
    RadioPanel drive       = new RadioPanel();
    RadioPanel etiquette   = new RadioPanel();
    RadioPanel firearms    = new RadioPanel();
    RadioPanel leadership  = new RadioPanel();
    RadioPanel melee       = new RadioPanel();
    RadioPanel perform     = new RadioPanel();
    RadioPanel stealth     = new RadioPanel();
    RadioPanel survival    = new RadioPanel();
    RadioPanel computers   = new RadioPanel();
    RadioPanel enigmas     = new RadioPanel();
    RadioPanel investigate = new RadioPanel();
    RadioPanel law         = new RadioPanel();
    RadioPanel linguist    = new RadioPanel();
    RadioPanel medicine    = new RadioPanel();
    RadioPanel occult      = new RadioPanel();
    RadioPanel politics    = new RadioPanel();
    RadioPanel rituals     = new RadioPanel();
    RadioPanel science     = new RadioPanel();
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Unused Modifiers">
//    Modifier strMod         = new Modifier();
//    Modifier dexMod         = new Modifier();
//    Modifier stamMod        = new Modifier();
//    Modifier manipMod       = new Modifier();
//    Modifier appearMod      = new Modifier();
//    Modifier charisMod      = new Modifier();
//    Modifier perceptMod     = new Modifier();
//    Modifier intelMod       = new Modifier();
//    Modifier witMod         = new Modifier();
//    Modifier alertMod       = new Modifier();
//    Modifier athletMod      = new Modifier();
//    Modifier brawlMod       = new Modifier();
//    Modifier dodgeMod       = new Modifier();
//    Modifier empathyMod     = new Modifier();
//    Modifier expressMod     = new Modifier();
//    Modifier intimidateMod  = new Modifier();
//    Modifier primalUrgeMod  = new Modifier();
//    Modifier streetwiseMod  = new Modifier();
//    Modifier subterfugeMod  = new Modifier();
//    Modifier animalKenMod   = new Modifier();
//    Modifier craftsMod      = new Modifier();
//    Modifier driveMod       = new Modifier();
//    Modifier etiquetteMod   = new Modifier();
//    Modifier firearmsMod    = new Modifier();
//    Modifier leadershipMod  = new Modifier();
//    Modifier meleeMod       = new Modifier();
//    Modifier performMod     = new Modifier();
//    Modifier stealthMod     = new Modifier();
//    Modifier survivalMod    = new Modifier();
//    Modifier computersMod   = new Modifier();
//    Modifier enigmasMod     = new Modifier();
//    Modifier investigateMod = new Modifier();
//    Modifier lawMod         = new Modifier();
//    Modifier linguistMod    = new Modifier();
//    Modifier medicineMod    = new Modifier();
//    Modifier occultMod      = new Modifier();
//    Modifier politicsMod    = new Modifier();
//    Modifier ritualsMod     = new Modifier();
//    Modifier scienceMod     = new Modifier();
    // </editor-fold>
    
    JButton moreAbilities = new JButton("More");
    
    Font font;
    // </editor-fold>
    
    public StatPanel(){
        this.setViewportView(panel);
        panel.setLayout(mainLayout);
        
        //----------------------------------------------------------------------
        // CHARACTER INFO
        
        c = setGridPos(0 ,0);
        panel.add(name, c);
        
        c = setGridPos(1 ,0);
        panel.add(nameField, c);
        //---------------------//
        c = setGridPos(0, 1);
        panel.add(player, c);
        
        c = setGridPos(1, 1);
        panel.add(playerField, c);
        
        //----------------------------------------------------------------------
        // ATTRIBUTES
        
        c = setLabelPos(2, 3);
        font = new Font(attrLabel.getFont().getName(), Font.PLAIN, 20);
        attrLabel.setFont(font);
        panel.add(attrLabel, c);
        
        c = setLabelPos(0, 4);
        font = new Font(physLabel.getFont().getName(), Font.PLAIN, 16);
        physLabel.setFont(font);
        panel.add(physLabel, c);
        
        c = setGridPos(0, 5);
        panel.add(strength, c);
        
        c = setGridPos(1, 5);
        panel.add(str, c);
        //---------------------//
        c = setGridPos(0, 6);
        panel.add(dexterity, c);
        
        c = setGridPos(1, 6);
        panel.add(dex, c);
        //---------------------//
        c = setGridPos(0, 7);
        panel.add(stamina, c);
        
        c = setGridPos(1, 7);
        panel.add(stam, c);
        //---------------------//
        c = setLabelPos(2, 4);
        font = new Font(socialLabel.getFont().getName(), Font.PLAIN, 16);
        socialLabel.setFont(font);
        panel.add(socialLabel, c);
        
        c = setGridPos(2, 5);
        panel.add(charisma, c);
        
        c = setGridPos(3, 5);
        panel.add(charis, c);
        //---------------------//
        c = setGridPos(2, 6);
        panel.add(manipulation, c);
        
        c = setGridPos(3, 6);
        panel.add(manip, c);
        //---------------------//
        c = setGridPos(2, 7);
        panel.add(appearance, c);
        
        c = setGridPos(3, 7);
        panel.add(appear, c);
        //---------------------//
        c = setLabelPos(4, 4);
        font = new Font(mentalLabel.getFont().getName(), Font.PLAIN, 16);
        mentalLabel.setFont(font);
        panel.add(mentalLabel, c);
        
        c = setGridPos(4, 5);
        panel.add(perception, c);
        
        c = setGridPos(5, 5);
        panel.add(percept, c);
        //---------------------//
        c = setGridPos(4, 6);
        panel.add(inteligence, c);
        
        c = setGridPos(5, 6);
        panel.add(intel, c);
        //---------------------//
        c = setGridPos(4, 7);
        panel.add(wits, c);
        
        c = setGridPos(5, 7);
        panel.add(wit, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - TALENTS
        
        c = setLabelPos(2, 8);
        font = new Font(abilityLabel.getFont().getName(), Font.PLAIN, 20);
        abilityLabel.setFont(font);
        panel.add(abilityLabel, c);
        
        c = setLabelPos(0, 9);
        font = new Font(talentLabel.getFont().getName(), Font.PLAIN, 16);
        talentLabel.setFont(font);
        panel.add(talentLabel, c);
        
        c = setGridPos(0, 10);
        panel.add(alertLabel, c);
        
        c = setGridPos(1, 10);
        panel.add(alert, c);
        //---------------------//
        c = setGridPos(0, 11);
        panel.add(athletLabel, c);
        
        c = setGridPos(1, 11);
        panel.add(athlet, c);
        //---------------------//
        c = setGridPos(0, 12);
        panel.add(brawlLabel, c);
        
        c = setGridPos(1, 12);
        panel.add(brawl, c);
        //---------------------//
        c = setGridPos(0, 13);
        panel.add(dodgeLabel, c);
        
        c = setGridPos(1, 13);
        panel.add(dodge, c);
        //---------------------//        
        c = setGridPos(0, 14);
        panel.add(empLabel, c);
        
        c = setGridPos(1, 14);
        panel.add(empathy, c);
        //---------------------//
        c = setGridPos(0, 15);
        panel.add(expressLabel, c);
        
        c = setGridPos(1, 15);
        panel.add(express, c);
        //---------------------//
        c = setGridPos(0, 16);
        panel.add(intimLabel, c);
        
        c = setGridPos(1, 16);
        panel.add(intimidate, c);
        //---------------------//
        c = setGridPos(0, 17);
        panel.add(primalLabel, c);
        
        c = setGridPos(1, 17);
        panel.add(primalUrge, c);
        //---------------------//
        c = setGridPos(0, 18);
        panel.add(streetLabel, c);
        
        c = setGridPos(1, 18);
        panel.add(streetwise, c);
        //---------------------//
        c = setGridPos(0, 19);
        panel.add(subterLabel, c);
        
        c = setGridPos(1, 19);
        panel.add(subterfuge, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - SKILLS
        
        c = setLabelPos(2, 9);
        font = new Font(skillLabel.getFont().getName(), Font.PLAIN, 16);
        skillLabel.setFont(font);
        panel.add(skillLabel, c);
        
        c = setGridPos(2, 10);
        panel.add(animalLabel, c);
        
        c = setGridPos(3, 10);
        panel.add(animalKen, c);
        //---------------------//
        c = setGridPos(2, 11);
        panel.add(craftLabel, c);
        
        c = setGridPos(3, 11);
        panel.add(crafts, c);
        //---------------------//
        c = setGridPos(2, 12);
        panel.add(driveLabel, c);
        
        c = setGridPos(3, 12);
        panel.add(drive, c);
        //---------------------//
        c = setGridPos(2, 13);
        panel.add(etiquLabel, c);
        
        c = setGridPos(3, 13);
        panel.add(etiquette, c);
        //---------------------//
        c = setGridPos(2, 14);
        panel.add(fireLabel, c);
        
        c = setGridPos(3, 14);
        panel.add(firearms, c);
        //---------------------//
        c = setGridPos(2, 15);
        panel.add(leadLabel, c);
        
        c = setGridPos(3, 15);
        panel.add(leadership, c);
        //---------------------//
        c = setGridPos(2, 16);
        panel.add(meleeLabel, c);
        
        c = setGridPos(3, 16);
        panel.add(melee, c);
        //---------------------//
        c = setGridPos(2, 17);
        panel.add(performLabel, c);
        
        c = setGridPos(3, 17);
        panel.add(perform, c);
        //---------------------//
        c = setGridPos(2, 18);
        panel.add(stealthLabel, c);
        
        c = setGridPos(3, 18);
        panel.add(stealth, c);
        //---------------------//
        c = setGridPos(2, 19);
        panel.add(survivalLabel, c);
        
        c = setGridPos(3, 19);
        panel.add(survival, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - KNOWLEDGES
        
        c = setLabelPos(4, 9);
        font = new Font(knowLabel.getFont().getName(), Font.PLAIN, 16);
        knowLabel.setFont(font);
        panel.add(knowLabel, c);
        
        c = setGridPos(4, 10);
        panel.add(compLabel, c);
        
        c = setGridPos(5, 10);
        panel.add(computers, c);
        //---------------------//
        c = setGridPos(4, 11);
        panel.add(enigmaLabel, c);
        
        c = setGridPos(5, 11);
        panel.add(enigmas, c);
        //---------------------//
        c = setGridPos(4, 12);
        panel.add(invesLabel, c);
        
        c = setGridPos(5, 12);
        panel.add(investigate, c);
        //---------------------//
        c = setGridPos(4, 13);
        panel.add(lawLabel, c);
        
        c = setGridPos(5, 13);
        panel.add(law, c);
        //---------------------//
        c = setGridPos(4, 14);
        panel.add(linguistLabel, c);

        c = setGridPos(5, 14);
        panel.add(linguist, c);
        //---------------------//
        c = setGridPos(4, 15);
        panel.add(medicLabel, c);

        c = setGridPos(5, 15);
        panel.add(medicine, c);
        //---------------------//
        c = setGridPos(4, 16);
        panel.add(occultLabel, c);

        c = setGridPos(5, 16);
        panel.add(occult, c);
        //---------------------//
        c = setGridPos(4, 17);
        panel.add(politicsLabel, c);
        
        c = setGridPos(5, 17);
        panel.add(politics, c);
        //---------------------//
        c = setGridPos(4, 18);
        panel.add(ritualsLabel, c);
        
        c = setGridPos(5, 18);
        panel.add(rituals, c);
        //---------------------//
        c = setGridPos(4, 19);
        panel.add(scienceLabel, c);
        
        c = setGridPos(5, 19);
        panel.add(science, c);
        //---------------------//
        // Button for more abilities/ability editing
        c = setLabelPos(0, 20);
        panel.add(moreAbilities, c);
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
        c.anchor = GridBagConstraints.LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        return c;
    }
    
    private static GridBagConstraints setLabelPos(int x, int y){
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
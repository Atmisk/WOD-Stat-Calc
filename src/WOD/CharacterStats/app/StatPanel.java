/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import PlayerStats.*;
import PlayerStats.BaseStats.Race;
import PlayerStats.WerewolfStats.Auspice;
import PlayerStats.WerewolfStats.Breed;
import PlayerStats.WerewolfStats.Tribe;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


/**
 *
 * @author Mike
 * 
 * GUI uses a GridBagLayout and goes 6 columns wide
 *       ___________
 *   0  |0|1|2|3|4|5|
 *   1  | | | | | | |
 *   .
 *   .
 *   .  |_|_|_|_|_|_|
 */
public class StatPanel extends JScrollPane {
    final private int initRank = 1;
    
    // <editor-fold defaultstate="collapsed" desc="Listeners">
    class statListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(str)){
                stats.Strength(str.getValue());
            }
            else if(e.getSource().equals(dex)){
                stats.Dexterity(dex.getValue());
            }
            else if(e.getSource().equals(stam)){
                stats.Stamina(stam.getValue());
            }
            else if(e.getSource().equals(charis)){
                stats.Charisma(charis.getValue());
            }
            else if(e.getSource().equals(manip)){
                stats.Manip(manip.getValue());
            }
            else if(e.getSource().equals(appear)){
                stats.Appear(appear.getValue());
            }
            else if(e.getSource().equals(percept)){
                stats.Percept(percept.getValue());
            }
            else if(e.getSource().equals(intel)){
                stats.Intel(intel.getValue());
            }
            else if(e.getSource().equals(wit)){
                stats.Wits(wit.getValue());
            }
            
            else if(e.getSource().equals(alert)){
                stats.Alert(alert.getValue());
            }
            else if(e.getSource().equals(athlet)){
                stats.Athletic(athlet.getValue());
            }
            else if(e.getSource().equals(brawl)){
                stats.Brawl(brawl.getValue());
            }
            else if(e.getSource().equals(dodge)){
                stats.Dodge(dodge.getValue());
            }
            else if(e.getSource().equals(empathy)){
                stats.Empathy(empathy.getValue());
            }
            else if(e.getSource().equals(express)){
                stats.Express(express.getValue());
            }
            else if(e.getSource().equals(intimidate)){
                stats.Intimidate(intimidate.getValue());
            }
            else if(e.getSource().equals(primalUrge)){
                stats.Primal(primalUrge.getValue());
            }
            else if(e.getSource().equals(streetwise)){
                stats.StreetWise(streetwise.getValue());
            }
            else if(e.getSource().equals(subterfuge)){
                stats.Subterfuge(subterfuge.getValue());
            }
            
            else if(e.getSource().equals(animalKen)){
                stats.AnimalKen(animalKen.getValue());
            }
            else if(e.getSource().equals(crafts)){
                stats.Crafts(crafts.getValue());
            }
            else if(e.getSource().equals(drive)){
                stats.Drive(drive.getValue());
            }
            else if(e.getSource().equals(etiquette)){
                stats.Etiquette(etiquette.getValue());
            }
            else if(e.getSource().equals(firearms)){
                stats.Firearms(firearms.getValue());
            }
            else if(e.getSource().equals(melee)){
                stats.Melee(melee.getValue());
            }
            else if(e.getSource().equals(leadership)){
                stats.Leadership(leadership.getValue());
            }
            else if(e.getSource().equals(perform)){
                stats.Performance(perform.getValue());
            }
            else if(e.getSource().equals(stealth)){
                stats.Stealth(stealth.getValue());
            }
            else if(e.getSource().equals(survival)){
                stats.Survival(survival.getValue());
            }
            
            else if(e.getSource().equals(computers)){
                stats.Computer(computers.getValue());
            }
            else if(e.getSource().equals(enigmas)){
                stats.Enigmas(enigmas.getValue());
            }
            else if(e.getSource().equals(investigate)){
                stats.Investigate(investigate.getValue());
            }
            else if(e.getSource().equals(law)){
                stats.Law(law.getValue());
            }
            else if(e.getSource().equals(linguist)){
                stats.Linguistics(linguist.getValue());
            }
            else if(e.getSource().equals(medicine)){
                stats.Medicine(medicine.getValue());
            }
            else if(e.getSource().equals(occult)){
                stats.Occult(occult.getValue());
            }
            else if(e.getSource().equals(politics)){
                stats.Politics(politics.getValue());
            }
            else if(e.getSource().equals(rituals)){
                stats.Rituals(rituals.getValue());
            }
            else if(e.getSource().equals(science)){
                stats.Science(science.getValue());
            }
            changeMade = true;
            System.out.println("listener success");
        }  
    }
    class detailListener implements DocumentListener {
        @Override
        public void changedUpdate(DocumentEvent e){
            saveChanges(e);
        }
        @Override
        public void removeUpdate(DocumentEvent e){
            saveChanges(e);
        }
        @Override
        public void insertUpdate(DocumentEvent e){
            saveChanges(e);
        }

        private void saveChanges(DocumentEvent e){
            Document nameDoc = nameField.getDocument();
            Document playerDoc = playerField.getDocument();
            Document campDoc = campField.getDocument();
            Document packDoc = packField.getDocument();
            Document totemDoc = totemField.getDocument();

            if(e.getDocument().equals(nameDoc)){
                stats.setCName(nameField.getText());
                //System.out.println("Character Name: " + name.getDetail());
            }
            
            else if(e.getDocument().equals(playerDoc)){
                stats.setPName(playerField.getText());
                //System.out.println("Player Name: " + player.getDetail());
            }
            
            else if(e.getDocument().equals(campDoc)){
                stats.Camp(campField.getText());
                //System.out.println("Camp: " + camp.getDetail());
            }
            else if(e.getDocument().equals(packDoc)){
                stats.PackName(packField.getText());
                //System.out.println("Pack: " + pack.getDetail());
            }
            else if(e.getDocument().equals(totemDoc)){
                stats.TotemName(totemField.getText());
                //System.out.println("Totem: " + totem.getDetail());
            }
            System.out.println("Detail changed");
            changeMade = true;
        }
    }
    class comboListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                if(e.getSource().equals(breedCombo)){
                    switch (breedCombo.getSelectedItem().toString()) {
                        case "Homid":
                            stats.Breed(Breed.HOMID);
                            break;
                        case "Crinos":
                            stats.Breed(Breed.CRINOS);
                            break;
                        case "Lupus":
                            stats.Breed(Breed.LUPUS);
                            break;
                    }
                    System.out.println("Breed: " + breedCombo.getSelectedItem()
                            .toString());
                }
                else if(e.getSource().equals(tribeCombo)){
                    switch (tribeCombo.getSelectedItem().toString()) {
                        case "Black Furries":
                            stats.Tribe(Tribe.BLACKFURY);
                            break;
                        case "Bone Gnawers":
                            stats.Tribe(Tribe.BONEGNAWER);
                            break;
                        case "Children of Gaia":
                            stats.Tribe(Tribe.CHILDOFGAIA);
                            break;
                        case "Fianna":
                            stats.Tribe(Tribe.FIANNA);
                            break;
                        case "Get of Fenris":
                            stats.Tribe(Tribe.GETOFFENRIS);
                            break;
                        case "Glasswalkers":
                            stats.Tribe(Tribe.GLASSWALKER);
                            break;
                        case "Red Talons":
                            stats.Tribe(Tribe.REDTALON);
                            break;
                        case "Shadow Lords":
                            stats.Tribe(Tribe.SHADOWLORD);
                            break;
                        case "Silent Striders":
                            stats.Tribe(Tribe.SILENTSTRIDER);
                            break;
                        case "Silverfangs":
                            stats.Tribe(Tribe.SILVERFANG);
                            break;
                        case "Stargazers":
                            stats.Tribe(Tribe.STARGAZER);
                            break;
                        case "Uktena":
                            stats.Tribe(Tribe.UKTENA);
                            break;
                        case "Wendigo":
                            stats.Tribe(Tribe.WENDIGO);
                            break;
                    }
                    System.out.println("Tribe: " + tribeCombo.getSelectedItem()
                            .toString());
                }
                else if(e.getSource().equals(auspiceCombo)){
                    switch(auspiceCombo.getSelectedItem().toString()){
                        case "Ahroun":
                            stats.Auspice(Auspice.AHROUN);
                            break;
                        case "Galliard":
                            stats.Auspice(Auspice.GALLIARD);
                            break;
                        case "Philodox":
                            stats.Auspice(Auspice.PHILODOX);
                            break;
                        case "Ragabash":
                            stats.Auspice(Auspice.RAGABASH);
                            break;
                        case "Theurge":
                            stats.Auspice(Auspice.THEURGE);
                            break;
                        //default:
                          //  stats.Auspice(null);
                    }
                    System.out.println("Auspice: " + auspiceCombo
                            .getSelectedItem().toString());
                }
                changeMade = true;
            }
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="variables and components">
    boolean changeMade = false;
    private WerewolfStats stats = new WerewolfStats(); // needs to be base stat
    
    JPanel panel = new JPanel();
    GridBagLayout mainLayout = new GridBagLayout();
    GridBagConstraints c;
    
    statListener   listener      = new statListener();
    detailListener docListener   = new detailListener();
    comboListener  comboListener = new comboListener();
    
    String[] breedList = {  "Homid", "Crinos", "Lupus"};
    
    String[] tribeList = {  "Black Furries", "Bone Gnawers", "Children of Gaia",
                            "Fianna", "Get of Fenris", "Glasswalkers", 
                            "Red Talons", "Shadow Lords", "Silent Striders",
                            "Silverfangs", "Stargazers", "Uktena", "Wendigo"};
    
    String[] auspiceList = {"Ragabash", "Theurge", "Philodox", 
                            "Galliard", "Ahroun"};
    
    String[] formList =    {"Homid", "Glabro", "Crinos", "Hispo", "Lupus"};

    JLabel name          = new JLabel("Name");
    JLabel breed         = new JLabel("Breed");
    JLabel player        = new JLabel("Player");
    JLabel tribe         = new JLabel("Tribe");
    JLabel auspice       = new JLabel("Auspice");
    JLabel camp          = new JLabel("Camp");
    JLabel pack          = new JLabel("Pack");
    JLabel totem         = new JLabel("Totem");
    JLabel attrLabel     = new JLabel("Attributes", JLabel.CENTER);
    JLabel physLabel     = new JLabel("Physical", JLabel.CENTER);
    JLabel socialLabel   = new JLabel("Social", JLabel.CENTER);
    JLabel mentalLabel   = new JLabel("Mental", JLabel.CENTER);
    JLabel abilityLabel  = new JLabel("Abilities", JLabel.CENTER);
    JLabel talentLabel   = new JLabel("Talents", JLabel.CENTER);
    JLabel skillLabel    = new JLabel("Skills", JLabel.CENTER);
    JLabel knowLabel     = new JLabel("Knowledges", JLabel.CENTER);
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
    
    JTextField nameField   = new JTextField();
    JTextField playerField = new JTextField();
    JTextField campField   = new JTextField();
    JTextField packField   = new JTextField();
    JTextField totemField  = new JTextField();
    
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
    
    JComboBox breedCombo   = new JComboBox(breedList);
    JComboBox tribeCombo   = new JComboBox(tribeList);
    JComboBox auspiceCombo = new JComboBox(auspiceList);
    JComboBox formBox      = new JComboBox(formList);
    
    Font font;
    // </editor-fold>
    
    public StatPanel(){
        this.setViewportView(panel);
        panel.setLayout(mainLayout);
        
        nameField.getDocument().addDocumentListener(docListener);
        playerField.getDocument().addDocumentListener(docListener);
        campField.getDocument().addDocumentListener(docListener);
        packField.getDocument().addDocumentListener(docListener);
        totemField.getDocument().addDocumentListener(docListener);
        
        breedCombo.addItemListener(comboListener);
        tribeCombo.addItemListener(comboListener);
        auspiceCombo.addItemListener(comboListener);
        
        str.addActionListener(listener);
        dex.addActionListener(listener);
        stam.addActionListener(listener);
        manip.addActionListener(listener);
        appear.addActionListener(listener);
        charis.addActionListener(listener);
        percept.addActionListener(listener);
        intel.addActionListener(listener);
        wit.addActionListener(listener);
        alert.addActionListener(listener);
        athlet.addActionListener(listener);
        brawl.addActionListener(listener);
        dodge.addActionListener(listener);
        empathy.addActionListener(listener);
        express.addActionListener(listener);
        intimidate.addActionListener(listener);
        primalUrge.addActionListener(listener);
        streetwise.addActionListener(listener);
        subterfuge.addActionListener(listener);
        animalKen.addActionListener(listener);
        crafts.addActionListener(listener);
        drive.addActionListener(listener);
        etiquette.addActionListener(listener);
        firearms.addActionListener(listener);
        leadership.addActionListener(listener);
        melee.addActionListener(listener);
        perform.addActionListener(listener);
        stealth.addActionListener(listener);
        survival.addActionListener(listener);
        computers.addActionListener(listener);
        enigmas.addActionListener(listener);
        investigate.addActionListener(listener);
        law.addActionListener(listener);
        linguist.addActionListener(listener);
        medicine.addActionListener(listener);
        occult.addActionListener(listener);
        politics.addActionListener(listener);
        rituals.addActionListener(listener);
        science.addActionListener(listener);
        
        //----------------------------------------------------------------------
        // CHARACTER INFO
        
        c = setGridPos(0 ,0);
        panel.add(name, c);
        
        c = setGridPos(1 ,0);
        panel.add(nameField, c);
        //---------------------//
        c = setGridPos(2, 0);
        panel.add(breed, c);
        
        c = setGridPos(3, 0);
        panel.add(breedCombo, c);
        //---------------------//
        c = setGridPos(4, 0);
        panel.add(pack, c);
        
        c = setGridPos(5, 0);
        panel.add(packField, c);
        //---------------------//
        c = setGridPos(0, 1);
        panel.add(player, c);
        
        c = setGridPos(1, 1);
        panel.add(playerField, c);
        //---------------------//
        c = setGridPos(2, 1);
        panel.add(auspice, c);
        
        c = setGridPos(3, 1);
        panel.add(auspiceCombo, c);
        //---------------------//
        c = setGridPos(4, 1);
        panel.add(totem, c);
        
        c = setGridPos(5, 1);
        panel.add(totemField, c);
        //---------------------//
        c = setGridPos(0, 2);
        panel.add(tribe, c);
        
        c = setGridPos(1, 2);
        panel.add(tribeCombo, c);
        //---------------------//
        c = setGridPos(2, 2);
        panel.add(camp, c);
        
        c = setGridPos(3, 2);
        panel.add(campField, c);
        
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
        c = setLabelPos(4, 20);
        panel.add(formBox, c);
    }
    
    
    /**
     * 
     * @param x horizontal position in grid
     * @param y vertical position in grid
     * 
     * @return a GridBagConstraints object
     */
    private static GridBagConstraints setGridPos(int x, int y){
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
    
    public void saveStats()throws IOException, ClassNotFoundException{
        String dir = System.getProperty("user.dir");// + "\\Characters";
        stats.SaveStats(dir);
    }
    
    public void loadStats(String charName, Race race) 
            throws IOException, ClassNotFoundException{
        String dir = System.getProperty("user.dir");// + "\\Characters";
        if(race == Race.WOLF){
            stats = WerewolfStats.LoadStats(charName, dir);
            initStats();
        }
    }
    
    // overide with or make abstract with subclasses
    // BEFORE ADDING CHECK FOR NULL, CHANGE HOW ELEMENTS ADDED FIRST
    // COULD HAVE BEEN TAKEN CARE OF IN INDIVIDUAL CLASSES
    private void initStats(){
        nameField.setText(stats.getCName());
        breedCombo.setSelectedItem(breedToString(stats.Breed()));
        playerField.setText(stats.getPName());
        tribeCombo.setSelectedItem(tribeToString(stats.Tribe()));
        auspiceCombo.setSelectedItem(auspToString(stats.Auspice()));
        campField.setText(stats.Camp());
        packField.setText(stats.PackName());
        totemField.setText(stats.TotemName());
        
        str.setValue(stats.Strength());
        dex.setValue(stats.Dexterity());
        stam.setValue(stats.Stamina());
        
        charis.setValue(stats.Charisma());
        manip.setValue(stats.Manip());
        appear.setValue(stats.Appear());
        
        intel.setValue(stats.Intel());
        percept.setValue(stats.Percept());
        wit.setValue(stats.Wits());
        
        alert.setValue(stats.Alert());
        athlet.setValue(stats.Athletic());
        brawl.setValue(stats.Brawl());
        dodge.setValue(stats.Dodge());
        empathy.setValue(stats.Empathy());
        express.setValue(stats.Express());
        intimidate.setValue(stats.Intimidate());
        primalUrge.setValue(stats.Primal());
        streetwise.setValue(stats.StreetWise());
        subterfuge.setValue(stats.Subterfuge());
        
        animalKen.setValue(stats.AnimalKen());
        crafts.setValue(stats.Crafts());
        drive.setValue(stats.Drive());
        etiquette.setValue(stats.Etiquette());
        firearms.setValue(stats.Firearms());
        leadership.setValue(stats.Leadership());
        melee.setValue(stats.Melee());
        perform.setValue(stats.Performance());
        stealth.setValue(stats.Stealth());
        survival.setValue(stats.Survival());
        
        computers.setValue(stats.Computer());
        enigmas.setValue(stats.Enigmas());
        investigate.setValue(stats.Investigate());
        law.setValue(stats.Law());
        linguist.setValue(stats.Linguistics());
        medicine.setValue(stats.Medicine());
        occult.setValue(stats.Occult());
        politics.setValue(stats.Politics());
        rituals.setValue(stats.Rituals());
        science.setValue(stats.Science());
    }
    // <editor-fold defaultstate="collapsed" desc="string conversion functions">
    private String auspToString(Auspice auspice){
        switch(auspice){
            case AHROUN:
                return "Ahroun";
            case PHILODOX:
                return "Philodox";
            case GALLIARD:
                return "Galliard";
            case THEURGE:
                return "Theurge";
            case RAGABASH:
                return "Ragabash";
            default:
                return null;
        }
    }
    
    private String breedToString(Breed breed){
        switch(breed){
            case HOMID:
                return "Homid";
            case CRINOS:
                return "Crinos";
            case LUPUS:
                return "Lupus";
            default:
                return null;
        }
    }
    
    private String tribeToString(Tribe tribe){
        switch(tribe){
            case BLACKFURY:
                return "Black Furries";
            case BONEGNAWER:
                return "Bone Gnawers";
            case CHILDOFGAIA:
                return "Children of Gaia";
            case FIANNA:
                return "Fianna";
            case GETOFFENRIS:
                return "Get of Fenris";
            case GLASSWALKER:
                return "Glasswalkers";
            case REDTALON:
                return "Red Talons";
            case SHADOWLORD:
                return "Shadow Lords";
            case SILENTSTRIDER:
                return "Silent Striders";
            case SILVERFANG:
                return "Silverfangs";
            case STARGAZER:
                return "Stargazers";
            case UKTENA:
                return "Uktena";
            case WENDIGO:
                return "Wendigo";
            default:
                return null;
        }
    }
}
// </editor-fold>
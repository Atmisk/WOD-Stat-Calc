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
import java.awt.Component;
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
 */
public class StatPanel extends JScrollPane {
    // <editor-fold defaultstate="collapsed" desc="Listeners">
    class statListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(str)){
                stats.Strength(str.getValue());
                //System.out.println("listener success");
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
            else if(e.getSource().equals(wits)){
                stats.Wits(wits.getValue());
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
            else if(e.getSource().equals(primal)){
                stats.Primal(primal.getValue());
            }
            else if(e.getSource().equals(streetwise)){
                stats.StreetWise(streetwise.getValue());
            }
            else if(e.getSource().equals(subter)){
                stats.Subterfuge(subter.getValue());
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
            else if(e.getSource().equals(firearm)){
                stats.Firearms(firearm.getValue());
            }
            else if(e.getSource().equals(melee)){
                stats.Melee(melee.getValue());
            }
            else if(e.getSource().equals(leader)){
                stats.Leadership(leader.getValue());
            }
            else if(e.getSource().equals(perform)){
                stats.Performance(perform.getValue());
            }
            else if(e.getSource().equals(stealth)){
                stats.Stealth(stealth.getValue());
            }
            else if(e.getSource().equals(survive)){
                stats.Survival(survive.getValue());
            }
            
            else if(e.getSource().equals(comp)){
                stats.Computer(comp.getValue());
            }
            else if(e.getSource().equals(enigma)){
                stats.Enigmas(enigma.getValue());
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
            else if(e.getSource().equals(medic)){
                stats.Medicine(medic.getValue());
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
            Document nameDoc = name.detail.getDocument();
            Document playerDoc = player.detail.getDocument();
            Document campDoc = camp.detail.getDocument();
            Document packDoc = pack.detail.getDocument();
            Document totemDoc = totem.detail.getDocument();

            if(e.getDocument().equals(nameDoc)){
                stats.setCName(name.getDetail());
                //System.out.println("Character Name: " + name.getDetail());
            }
            
            else if(e.getDocument().equals(playerDoc)){
                stats.setPName(player.getDetail());
                //System.out.println("Player Name: " + player.getDetail());
            }
            
            else if(e.getDocument().equals(campDoc)){
                stats.Camp(camp.getDetail());
                //System.out.println("Camp: " + camp.getDetail());
            }
            else if(e.getDocument().equals(packDoc)){
                stats.PackName(pack.getDetail());
                //System.out.println("Pack: " + pack.getDetail());
            }
            else if(e.getDocument().equals(totemDoc)){
                stats.TotemName(totem.getDetail());
                //System.out.println("Totem: " + totem.getDetail());
            }
            changeMade = true;
        }
    }
    class comboListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                if(e.getSource().equals(breed.detailBox)){
                    switch (breed.getDetail()) {
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
                    System.out.println("Breed: " + breed.getDetail());
                }
                else if(e.getSource().equals(tribe.detailBox)){
                    switch (tribe.getDetail()) {
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
                    System.out.println("Tribe: " + tribe.getDetail());
                }
                else if(e.getSource().equals(auspice.detailBox)){
                    switch(auspice.getDetail()){
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
                    System.out.println("Auspice: " + auspice.getDetail());
                }
                //System.out.println("Selection changed");
                changeMade = true;
            }
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="variables and components">
    boolean changeMade = false;
    private WerewolfStats stats = new WerewolfStats();
    
    JPanel panel = new JPanel();
    GridBagLayout mainLayout = new GridBagLayout();
    GridBagConstraints c;
    statListener listener = new statListener();
    detailListener docListener = new detailListener();
    comboListener comboListener = new comboListener();
    Dimension dim;
    
    String[] breedList = {  "Homid", "Crinos", "Lupus"};
    
    String[] tribeList = {  "Black Furries", "Bone Gnawers", "Children of Gaia",
                            "Fianna", "Get of Fenris", "Glasswalkers", 
                            "Red Talons", "Shadow Lords", "Silent Striders",
                            "Silverfangs", "Stargazers", "Uktena", "Wendigo"};
    
    String[] auspiceList = {"Ragabash", "Theurge", "Philodox", 
                            "Galliard", "Ahroun"};
    
    String[] formList =    {"Homid", "Glabro", "Crinos", "Hispo", "Lupus"};

    Detail name = new Detail("Name", docListener);
    Detail breed = new Detail("Breed", breedList, comboListener);
    Detail player = new Detail("Player", docListener);
    Detail tribe = new Detail("Tribe", tribeList, comboListener);
    Detail auspice = new Detail("Auspice", auspiceList, comboListener);
    Detail camp = new Detail("Camp", docListener);
    Detail pack = new Detail("Pack", docListener);
    Detail totem = new Detail("Totem", docListener); // CREATE PRESEST?

    JLabel attrLabel = new JLabel("Attributes", JLabel.CENTER);
    JLabel physLabel = new JLabel("Physical", JLabel.CENTER);
    JLabel socialLabel = new JLabel("Social", JLabel.CENTER);
    JLabel mentalLabel = new JLabel("Mental", JLabel.CENTER);
    JLabel abilityLabel = new JLabel("Abilities", JLabel.CENTER);
    JLabel talentLabel = new JLabel("Talents", JLabel.CENTER);
    JLabel skillLabel = new JLabel("Skills", JLabel.CENTER);
    JLabel knowLabel = new JLabel("Knowledges", JLabel.CENTER);
    Font font;

    Stat str = new Stat("Strength", 1, listener);
    Stat dex = new Stat("Dexterity", 1, listener);
    Stat stam = new Stat("Stamina", 1, listener);

    Stat charis = new Stat("Charisma", 1, listener);
    Stat manip = new Stat("Manipulation", 1, listener);
    Stat appear = new Stat("Appearance", 1, listener);

    Stat percept = new Stat("Perception", 1, listener);
    Stat intel = new Stat("Inteligence", 1, listener);
    Stat wits = new Stat("Wits", 1, listener);

    Stat alert = new Stat("Alertness", listener);
    Stat athlet = new Stat("Athletics", listener);
    Stat brawl = new Stat("Brawl", listener);
    Stat dodge = new Stat("Dodge", listener);
    Stat empathy = new Stat("Empathy", listener);
    Stat express = new Stat("Expression", listener);
    Stat intimidate = new Stat("Intimidate", listener);
    Stat primal = new Stat("Pimal Urge", listener);
    Stat streetwise = new Stat("Streetwise", listener);
    Stat subter = new Stat("Subterfuge", listener);

    Stat animalKen = new Stat("Animal Ken", listener);
    Stat crafts = new Stat("Crafts", listener);
    Stat drive = new Stat("Drive", listener);
    Stat etiquette = new Stat("Etiquette", listener);
    Stat firearm = new Stat("Firearms", listener);
    Stat leader = new Stat("Leadership", listener);
    Stat melee = new Stat("Melee", listener);
    Stat perform = new Stat("Perform", listener);
    Stat stealth = new Stat("Stealth", listener);
    Stat survive = new Stat("Survival", listener);

    Stat comp = new Stat("Computers", listener);
    Stat enigma = new Stat("Enigma", listener);
    Stat investigate = new Stat("Investigate", listener);
    Stat law = new Stat("Law", listener);
    Stat linguist = new Stat("Linquistics", listener);
    Stat medic = new Stat("Medicine", listener);
    Stat occult = new Stat("Occult", listener);
    Stat politics = new Stat("Politics", listener);
    Stat rituals = new Stat("Rituals", listener);
    Stat science = new Stat("Science", listener);
    
    JComboBox formBox = new JComboBox(formList);
    // </editor-fold>
    public StatPanel(){
        this.setViewportView(panel);
        panel.setLayout(mainLayout);
        
        //----------------------------------------------------------------------
        // CHARACTER INFO
        
        c = setGridPos(0 ,0);
        panel.add(name, c);
        
        c = setGridPos(1, 0);
        panel.add(breed, c);
        
        c = setGridPos(2, 0);
        panel.add(pack, c);
        
        c = setGridPos(0, 1);
        panel.add(player, c);
        
        c = setGridPos(1, 1);
        panel.add(auspice, c);
        
        c = setGridPos(2, 1);
        panel.add(totem, c);
        
        c = setGridPos(0, 2);
        panel.add(tribe, c);
        
        c = setGridPos(1, 2);
        panel.add(camp, c);
        
        //----------------------------------------------------------------------
        // ATTRIBUTES
        
        c = setLabelPos(1, 3);
        font = new Font(attrLabel.getFont().getName(), Font.PLAIN, 20);
        attrLabel.setFont(font);
        panel.add(attrLabel, c);
        
        c = setLabelPos(0, 4);
        font = new Font(physLabel.getFont().getName(), Font.PLAIN, 16);
        physLabel.setFont(font);
        panel.add(physLabel, c);
        
        c = setGridPos(0, 5);
        panel.add(str, c);
        
        c = setGridPos(0, 6);
        panel.add(dex, c);
        
        c = setGridPos(0, 7);
        panel.add(stam, c);
        
        c = setLabelPos(1, 4);
        font = new Font(socialLabel.getFont().getName(), Font.PLAIN, 16);
        socialLabel.setFont(font);
        panel.add(socialLabel, c);
        
        c = setGridPos(1, 5);
        panel.add(charis, c);
        
        c = setGridPos(1, 6);
        panel.add(manip, c);
        
        c = setGridPos(1, 7);
        panel.add(appear, c);
        
        c = setLabelPos(2, 4);
        font = new Font(mentalLabel.getFont().getName(), Font.PLAIN, 16);
        mentalLabel.setFont(font);
        panel.add(mentalLabel, c);
        
        c = setGridPos(2, 5);
        panel.add(percept, c);
        
        c = setGridPos(2, 6);
        panel.add(intel, c);
        
        c = setGridPos(2, 7);
        panel.add(wits, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - TALENTS
        
        c = setLabelPos(1, 8);
        font = new Font(abilityLabel.getFont().getName(), Font.PLAIN, 20);
        abilityLabel.setFont(font);
        panel.add(abilityLabel, c);
        
        c = setLabelPos(0, 9);
        font = new Font(talentLabel.getFont().getName(), Font.PLAIN, 16);
        talentLabel.setFont(font);
        panel.add(talentLabel, c);
        
        c = setGridPos(0, 10);
        panel.add(alert, c);
        
        c = setGridPos(0, 11);
        panel.add(athlet, c);
        
        c = setGridPos(0, 12);
        panel.add(brawl, c);
        
        c = setGridPos(0, 13);
        panel.add(dodge, c);
        
        c = setGridPos(0, 14);
        panel.add(empathy, c);
        
        c = setGridPos(0, 15);
        panel.add(express, c);
        
        c = setGridPos(0, 16);
        panel.add(intimidate, c);
        
        c = setGridPos(0, 17);
        panel.add(primal, c);
        
        c = setGridPos(0, 18);
        panel.add(streetwise, c);
        
        c = setGridPos(0, 19);
        panel.add(subter, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - SKILLS
        
        c = setLabelPos(1, 9);
        font = new Font(skillLabel.getFont().getName(), Font.PLAIN, 16);
        skillLabel.setFont(font);
        panel.add(skillLabel, c);
        
        c = setGridPos(1, 10);
        panel.add(animalKen, c);
        
        c = setGridPos(1, 11);
        panel.add(crafts, c);
        
        c = setGridPos(1, 12);
        panel.add(drive, c);
        
        c = setGridPos(1, 13);
        panel.add(etiquette, c);
        
        c = setGridPos(1, 14);
        panel.add(firearm, c);
        
        c = setGridPos(1, 15);
        panel.add(leader, c);
        
        c = setGridPos(1, 16);
        panel.add(melee, c);
        
        c = setGridPos(1, 17);
        panel.add(perform, c);
        
        c = setGridPos(1, 18);
        panel.add(stealth, c);
        
        c = setGridPos(1, 19);
        panel.add(survive, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - KNOWLEDGES
        
        c = setLabelPos(2, 9);
        font = new Font(knowLabel.getFont().getName(), Font.PLAIN, 16);
        knowLabel.setFont(font);
        panel.add(knowLabel, c);
        
        c = setGridPos(2, 10);
        panel.add(comp, c);
        
        c = setGridPos(2, 11);
        panel.add(enigma, c);
        
        c = setGridPos(2, 12);
        panel.add(investigate, c);
        
        c = setGridPos(2, 13);
        panel.add(law, c);
        
        c = setGridPos(2, 14);
        panel.add(linguist, c);

        c = setGridPos(2, 15);
        panel.add(medic, c);

        c = setGridPos(2, 16);
        panel.add(occult, c);

        c = setGridPos(2, 17);
        panel.add(politics, c);
        
        c = setGridPos(2, 18);
        panel.add(rituals, c);
        
        c = setGridPos(2, 19);
        panel.add(science, c);
        
        c = setLabelPos(2, 20);
        panel.add(formBox, c);
    }
    
    /**
     * 
     * @param x horizontal position in grid
     * @param y vertical position in grid
     * @param yGap space between object and the object above it
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
        c.gridwidth = 1;
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
        name.setDetail(stats.getCName());
        breed.setDetail(breedToString(stats.Breed()));
        player.setDetail(stats.getPName());
        tribe.setDetail(tribeToString(stats.Tribe()));
        auspice.setDetail(auspToString(stats.Auspice()));
        camp.setDetail(stats.Camp());
        pack.setDetail(stats.PackName());
        totem.setDetail(stats.TotemName());
        
        str.setValue(stats.Strength());
        dex.setValue(stats.Dexterity());
        stam.setValue(stats.Stamina());
        
        charis.setValue(stats.Charisma());
        manip.setValue(stats.Manip());
        appear.setValue(stats.Appear());
        
        intel.setValue(stats.Intel());
        percept.setValue(stats.Percept());
        wits.setValue(stats.Wits());
        
        alert.setValue(stats.Alert());
        athlet.setValue(stats.Athletic());
        brawl.setValue(stats.Brawl());
        dodge.setValue(stats.Dodge());
        empathy.setValue(stats.Empathy());
        express.setValue(stats.Express());
        intimidate.setValue(stats.Intimidate());
        primal.setValue(stats.Primal());
        streetwise.setValue(stats.StreetWise());
        subter.setValue(stats.Subterfuge());
        
        animalKen.setValue(stats.AnimalKen());
        crafts.setValue(stats.Crafts());
        drive.setValue(stats.Drive());
        etiquette.setValue(stats.Etiquette());
        firearm.setValue(stats.Firearms());
        leader.setValue(stats.Leadership());
        melee.setValue(stats.Melee());
        perform.setValue(stats.Performance());
        stealth.setValue(stats.Stealth());
        survive.setValue(stats.Survival());
        
        comp.setValue(stats.Computer());
        enigma.setValue(stats.Enigmas());
        investigate.setValue(stats.Investigate());
        law.setValue(stats.Law());
        linguist.setValue(stats.Linguistics());
        medic.setValue(stats.Medicine());
        occult.setValue(stats.Occult());
        politics.setValue(stats.Politics());
        rituals.setValue(stats.Rituals());
        science.setValue(stats.Science());
    }
    
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import PlayerStats.WerewolfStats;
import PlayerStats.WerewolfStats.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author Mike
 */
public class WerewolfPanel extends StatPanel{
    //<editor-fold defaultstate="collapsed" desc="Variables and components">
    private WerewolfStats stats = new WerewolfStats();
    
    //<editor-fold defaultstate="collapsed" desc="String arrays">
    private String[] breedList = {  "", "Homid", "Metis", "Lupus"};
    
    private String[] tribeList = {  "", "Black Furries", "Bone Gnawers",
        "Children of Gaia", "Fianna", "Get of Fenris",
        "Glasswalkers", "Red Talons", "Shadow Lords",
        "Silent Striders", "Silverfangs", "Stargazers",
        "Uktena", "Wendigo"};
    
    private String[] auspiceList = {"", "Ragabash", "Theurge", "Philodox",
        "Galliard", "Ahroun"};
    
    private String[] formList =    {"", "Homid", "Glabro", "Crinos", "Hispo", "Lupus"};
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Listener declarations">
    private class comboListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                if(e.getSource().equals(breedCombo)){
                    switch (breedCombo.getSelectedItem().toString()) {
                        case "Homid":
                            stats.setBreed(Breed.HOMID);
                            break;
                        case "Crinos":
                            stats.setBreed(Breed.METIS);
                            break;
                        case "Lupus":
                            stats.setBreed(Breed.LUPUS);
                            break;
                    }
                }
                else if(e.getSource().equals(tribeCombo)){
                    switch (tribeCombo.getSelectedItem().toString()) {
                        case "Black Furries":
                            stats.setTribe(Tribe.BLACKFURY);
                            break;
                        case "Bone Gnawers":
                            stats.setTribe(Tribe.BONEGNAWER);
                            break;
                        case "Children of Gaia":
                            stats.setTribe(Tribe.CHILDOFGAIA);
                            break;
                        case "Fianna":
                            stats.setTribe(Tribe.FIANNA);
                            break;
                        case "Get of Fenris":
                            stats.setTribe(Tribe.GETOFFENRIS);
                            break;
                        case "Glasswalkers":
                            stats.setTribe(Tribe.GLASSWALKER);
                            break;
                        case "Red Talons":
                            stats.setTribe(Tribe.REDTALON);
                            break;
                        case "Shadow Lords":
                            stats.setTribe(Tribe.SHADOWLORD);
                            break;
                        case "Silent Striders":
                            stats.setTribe(Tribe.SILENTSTRIDER);
                            break;
                        case "Silverfangs":
                            stats.setTribe(Tribe.SILVERFANG);
                            break;
                        case "Stargazers":
                            stats.setTribe(Tribe.STARGAZER);
                            break;
                        case "Uktena":
                            stats.setTribe(Tribe.UKTENA);
                            break;
                        case "Wendigo":
                            stats.setTribe(Tribe.WENDIGO);
                            break;
                    }
                    //                    System.out.println("Tribe: " + tribeCombo.getSelectedItem()
                    //                            .toString());
                }
                else if(e.getSource().equals(auspiceCombo)){
                    switch(auspiceCombo.getSelectedItem().toString()){
                        case "Ahroun":
                            stats.setAuspice(Auspice.AHROUN);
                            break;
                        case "Galliard":
                            stats.setAuspice(Auspice.GALLIARD);
                            break;
                        case "Philodox":
                            stats.setAuspice(Auspice.PHILODOX);
                            break;
                        case "Ragabash":
                            stats.setAuspice(Auspice.RAGABASH);
                            break;
                        case "Theurge":
                            stats.setAuspice(Auspice.THEURGE);
                            break;
                    }
                }
                else if(e.getSource().equals(formBox)){
                    switch (formBox.getSelectedItem().toString()) {
                        case "Homid":
                            stats.setForm(ShiftedForm.HOMID);
                            break;
                        case "Glabro":
                            stats.setForm(ShiftedForm.GLABRO);
                            break;
                        case "Crinos":
                            stats.setForm(ShiftedForm.CRINOS);
                            break;
                        case "Hispo":
                            stats.setForm(ShiftedForm.HISPO);
                            break;
                        case "Lupus":
                            stats.setForm(ShiftedForm.LUPUS);
                            break;
                    }
                }
                changeMade = true;
            }
        }
    }
    private class detailListener implements DocumentListener {
        @Override
        public void changedUpdate(DocumentEvent e){
            storeChanges(e);
        }
        @Override
        public void removeUpdate(DocumentEvent e){
            storeChanges(e);
        }
        @Override
        public void insertUpdate(DocumentEvent e){
            storeChanges(e);
        }
        
        private void storeChanges(DocumentEvent e){
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
                stats.setCamp(campField.getText());
                //System.out.println("Camp: " + camp.getDetail());
            }
            else if(e.getDocument().equals(packDoc)){
                stats.setPackName(packField.getText());
                //System.out.println("Pack: " + pack.getDetail());
            }
            else if(e.getDocument().equals(totemDoc)){
                stats.setTotemName(totemField.getText());
                //System.out.println("Totem: " + totem.getDetail());
            }
            //System.out.println("Detail changed");
            changeMade = true;
        }
    }
    private class statListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(str)){
                stats.setStrength(str.getValue());
            }
            else if(e.getSource().equals(dex)){
                stats.setDexterity(dex.getValue());
            }
            else if(e.getSource().equals(stam)){
                stats.setStamina(stam.getValue());
            }
            else if(e.getSource().equals(charis)){
                stats.setCharisma(charis.getValue());
            }
            else if(e.getSource().equals(manip)){
                stats.setManip(manip.getValue());
            }
            else if(e.getSource().equals(appear)){
                stats.setAppear(appear.getValue());
            }
            else if(e.getSource().equals(percept)){
                stats.setPercept(percept.getValue());
            }
            else if(e.getSource().equals(intel)){
                stats.setIntel(intel.getValue());
            }
            else if(e.getSource().equals(wit)){
                stats.setWits(wit.getValue());
            }
            
            else if(e.getSource().equals(alert)){
                stats.setAlert(alert.getValue());
            }
            else if(e.getSource().equals(athlet)){
                stats.setAthletic(athlet.getValue());
            }
            else if(e.getSource().equals(brawl)){
                stats.setBrawl(brawl.getValue());
            }
            else if(e.getSource().equals(dodge)){
                stats.setDodge(dodge.getValue());
            }
            else if(e.getSource().equals(empathy)){
                stats.setEmpathy(empathy.getValue());
            }
            else if(e.getSource().equals(express)){
                stats.setExpress(express.getValue());
            }
            else if(e.getSource().equals(intimidate)){
                stats.setIntimidate(intimidate.getValue());
            }
            else if(e.getSource().equals(primalUrge)){
                stats.setPrimal(primalUrge.getValue());
            }
            else if(e.getSource().equals(streetwise)){
                stats.setStreetWise(streetwise.getValue());
            }
            else if(e.getSource().equals(subterfuge)){
                stats.setSubterfuge(subterfuge.getValue());
            }
            
            else if(e.getSource().equals(animalKen)){
                stats.setAnimalKen(animalKen.getValue());
            }
            else if(e.getSource().equals(crafts)){
                stats.setCrafts(crafts.getValue());
            }
            else if(e.getSource().equals(drive)){
                stats.setDrive(drive.getValue());
            }
            else if(e.getSource().equals(etiquette)){
                stats.setEtiquette(etiquette.getValue());
            }
            else if(e.getSource().equals(firearms)){
                stats.setFirearms(firearms.getValue());
            }
            else if(e.getSource().equals(melee)){
                stats.setMelee(melee.getValue());
            }
            else if(e.getSource().equals(leadership)){
                stats.setLeadership(leadership.getValue());
            }
            else if(e.getSource().equals(perform)){
                stats.setPerformance(perform.getValue());
            }
            else if(e.getSource().equals(stealth)){
                stats.setStealth(stealth.getValue());
            }
            else if(e.getSource().equals(survival)){
                stats.setSurvival(survival.getValue());
            }
            
            else if(e.getSource().equals(computers)){
                stats.setComputer(computers.getValue());
            }
            else if(e.getSource().equals(enigmas)){
                stats.setEnigmas(enigmas.getValue());
            }
            else if(e.getSource().equals(investigate)){
                stats.setInvestigate(investigate.getValue());
            }
            else if(e.getSource().equals(law)){
                stats.setLaw(law.getValue());
            }
            else if(e.getSource().equals(linguist)){
                stats.setLinguistics(linguist.getValue());
            }
            else if(e.getSource().equals(medicine)){
                stats.setMedicine(medicine.getValue());
            }
            else if(e.getSource().equals(occult)){
                stats.setOccult(occult.getValue());
            }
            else if(e.getSource().equals(politics)){
                stats.setPolitics(politics.getValue());
            }
            else if(e.getSource().equals(rituals)){
                stats.setRituals(rituals.getValue());
            }
            else if(e.getSource().equals(science)){
                stats.setScience(science.getValue());
            }
            changeMade = true;
        }
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Listeners">
    private comboListener  comboListener = new comboListener();
    private detailListener docListener   = new detailListener();
    private statListener   listener      = new statListener();
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="JLabels">
    private JLabel breed         = new JLabel("Breed");
    private JLabel tribe         = new JLabel("Tribe");
    private JLabel auspice       = new JLabel("Auspice");
    private JLabel form          = new JLabel("Form");
    private JLabel camp          = new JLabel("Camp");
    private JLabel pack          = new JLabel("Pack");
    private JLabel totem         = new JLabel("Totem");
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Combo Boxes">
    private JComboBox breedCombo   = new JComboBox(breedList);
    private JComboBox tribeCombo   = new JComboBox(tribeList);
    private JComboBox auspiceCombo = new JComboBox(auspiceList);
    private JComboBox formBox      = new JComboBox(formList);
    //</editor-fold>
    
    private JTextField campField   = new JTextField();
    private JTextField packField   = new JTextField();
    private JTextField totemField  = new JTextField();
    //</editor-fold>
    
    public WerewolfPanel(){
        super();
        
//        int width;
        
        title.setText("Garou");
        
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
        
        nameField.getDocument().addDocumentListener(docListener);
        playerField.getDocument().addDocumentListener(docListener);
        campField.getDocument().addDocumentListener(docListener);
        packField.getDocument().addDocumentListener(docListener);
        totemField.getDocument().addDocumentListener(docListener);
        
        breedCombo.addItemListener(comboListener);
        tribeCombo.addItemListener(comboListener);
        auspiceCombo.addItemListener(comboListener);
        formBox.addItemListener(comboListener);
        
        breedCombo.setPrototypeDisplayValue(prototypeString);
        tribeCombo.setPrototypeDisplayValue(prototypeString);
        auspiceCombo.setPrototypeDisplayValue(prototypeString);
        formBox.setPrototypeDisplayValue(prototypeString);
        
        //----------------------------------------------------------------------
        // CHARACTER INFO

        c = setGridPos(2, 1);
        panel.add(breed, c);
        
        c = setGridPos(3, 1);
        panel.add(breedCombo, c);
        //---------------------//
        c = setGridPos(4, 1);
        panel.add(pack, c);
        
        c = setGridPos(5, 1);
        panel.add(packField, c);
        //---------------------//
        c = setGridPos(2, 2);
        panel.add(auspice, c);
        
        c = setGridPos(3, 2);
        panel.add(auspiceCombo, c);
        //---------------------//
        c = setGridPos(4, 2);
        panel.add(totem, c);
        
        c = setGridPos(5, 2);
        panel.add(totemField, c);
        //---------------------//
        c = setGridPos(0, 3);
        panel.add(form, c);
        
        c = setGridPos(1, 3);
        panel.add(formBox, c);
        //---------------------//
        c = setGridPos(2, 3);
        panel.add(camp, c);
        
        c = setGridPos(3, 3);
        panel.add(campField, c);
        //---------------------//
        c = setGridPos(4, 3);
        panel.add(tribe, c);
        
        c = setGridPos(5, 3);
        panel.add(tribeCombo, c);
        
//        width = name.getMinimumSize().width 
//                + nameField.getMinimumSize().width
//                + breed.getMinimumSize().width
//                + breedCombo.getMinimumSize().width
//                + pack.getMinimumSize().width
//                + packField.getMinimumSize().width;
//        
//        System.out.println("Min Width: " + width);
//        this.setPreferredSize(new Dimension(width, 700));
    }
    
    @Override
    public void loadStats(String charName) 
            throws IOException, ClassNotFoundException{
        String dir = System.getProperty("user.dir");// + "\\Characters";
        stats = WerewolfStats.LoadStats(charName, dir);
        initStats();
        changeMade = false;
    }
    
    @Override
    public void saveStats()throws IOException, ClassNotFoundException{
        String dir = System.getProperty("user.dir");// + "\\Characters";
        stats.SaveStats(dir);
        changeMade = false;
    }
 
    @Override
    protected void initStats(){
        if(stats.getBreed() != null){
            breedCombo.setSelectedItem(breedToString(stats.getBreed()));}
        if(stats.getTribe() != null){
            tribeCombo.setSelectedItem(tribeToString(stats.getTribe()));}
        if(stats.getAuspice() != null){
            auspiceCombo.setSelectedItem(auspToString(stats.getAuspice()));}
        if(stats.getCamp() != null){
            campField.setText(stats.getCamp());}
        if(stats.getPackName() != null){
            packField.setText(stats.getPackName());}
        if(stats.getTotemName() != null){
            totemField.setText(stats.getTotemName());}
        if(stats.getCName() != null){
            nameField.setText(stats.getCName());}
        if(stats.getPName() != null){
            playerField.setText(stats.getPName());}
        if(stats.getForm() != null){
            formBox.setSelectedItem(formToString(stats.getForm()));}
        
        str.setValue(stats.getStrength());
        dex.setValue(stats.getDexterity());
        stam.setValue(stats.getStamina());
        
        charis.setValue(stats.getCharisma());
        manip.setValue(stats.getManip());
        appear.setValue(stats.getAppear());
        
        intel.setValue(stats.getIntel());
        percept.setValue(stats.getPercept());
        wit.setValue(stats.getWits());
        
        alert.setValue(stats.getAlert());
        athlet.setValue(stats.getAthletic());
        brawl.setValue(stats.getBrawl());
        dodge.setValue(stats.getDodge());
        empathy.setValue(stats.getEmpathy());
        express.setValue(stats.getExpress());
        intimidate.setValue(stats.getIntimidate());
        primalUrge.setValue(stats.getPrimal());
        streetwise.setValue(stats.getStreetWise());
        subterfuge.setValue(stats.getSubterfuge());
        
        animalKen.setValue(stats.getAnimalKen());
        crafts.setValue(stats.getCrafts());
        drive.setValue(stats.getDrive());
        etiquette.setValue(stats.getEtiquette());
        firearms.setValue(stats.getFirearms());
        leadership.setValue(stats.getLeadership());
        melee.setValue(stats.getMelee());
        perform.setValue(stats.getPerformance());
        stealth.setValue(stats.getStealth());
        survival.setValue(stats.getSurvival());
        
        computers.setValue(stats.getComputer());
        enigmas.setValue(stats.getEnigmas());
        investigate.setValue(stats.getInvestigate());
        law.setValue(stats.getLaw());
        linguist.setValue(stats.getLinguistics());
        medicine.setValue(stats.getMedicine());
        occult.setValue(stats.getOccult());
        politics.setValue(stats.getPolitics());
        rituals.setValue(stats.getRituals());
        science.setValue(stats.getScience());
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
            case METIS:
                return "Metis";
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
    
    private String formToString(ShiftedForm form){
        switch(form){
            case HOMID:
                return "Homid";
            case GLABRO:
                return "Glabro";
            case CRINOS:
                return "Crinos";
            case HISPO:
                return "Hispo";
            case LUPUS:
                return "Lupus";
            default:
                return null;
        }
    }
    // </editor-fold>
}

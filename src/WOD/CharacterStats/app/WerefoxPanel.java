/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import PlayerStats.WerefoxStats;
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
public class WerefoxPanel extends StatPanel{
    WerefoxStats stats = new WerefoxStats();
    
    String[] breedList = {  "", "Kojin", "Shinju", "Roko"};
    
    String[] pathList  = {"", "Doshi", "Eji", "Gukutsushi", "Kataribe"};
    
    String[] formList  = {"", "Hitogata", "Sambuhenge", 
                          "Koto", "Juko", "Kyubi"};
    
    // <editor-fold defaultstate="collapsed" desc="Listener declarations">
    private class comboListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED)
            {
                if(e.getSource().equals(breedCombo)){
                    switch (breedCombo.getSelectedItem().toString()) {
                        case "Kojin":
                            stats.setBreed(WerefoxStats.Breed.KOJIN);
                            break;
                        case "Shinju":
                            stats.setBreed(WerefoxStats.Breed.SHINJU);
                            break;
                        case "Roko":
                            stats.setBreed(WerefoxStats.Breed.ROKO);
                            break;
                    }
    //                    System.out.println("Breed: " + breedCombo.getSelectedItem()
    //                            .toString());
                }
                else if(e.getSource().equals(pathCombo)){
                    switch(pathCombo.getSelectedItem().toString()){
                        case "Doshi":
                            stats.setPath(WerefoxStats.Path.DOSHI);
                            break;
                        case "Eji":
                            stats.setPath(WerefoxStats.Path.EJI);
                            break;
                        case "Gukutsushi":
                            stats.setPath(WerefoxStats.Path.GUKUTSHUSHI);
                            break;
                        case "Kataribe":
                            stats.setPath(WerefoxStats.Path.KATARIBE);
                            break;
                        //default:
                          //  stats.Auspice(null);
                    }
                    //System.out.println("Auspice: " + auspiceCombo
                    //        .getSelectedItem().toString());
                }
                changeMade = true;
            }
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
            Document missionDoc = missionField.getDocument();
            Document sentaiDoc = sentaiField.getDocument();
            Document totemDoc = totemField.getDocument();

            if(e.getDocument().equals(nameDoc)){
                stats.setCName(nameField.getText());
                //System.out.println("Character Name: " + name.getDetail());
            }
            
            else if(e.getDocument().equals(playerDoc)){
                stats.setPName(playerField.getText());
                //System.out.println("Player Name: " + player.getDetail());
            }
            
            else if(e.getDocument().equals(missionDoc)){
                stats.setMission(missionField.getText());
                //System.out.println("Camp: " + camp.getDetail());
            }
            else if(e.getDocument().equals(sentaiDoc)){
                stats.setSentai(sentaiField.getText());
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
    // MIGHT BE ABLE TO MOVE TO BASE STATPANEL
    class statListener implements ActionListener{
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
           // System.out.println("listener success");
        }  
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Listeners">
    comboListener  comboListener = new comboListener();
    detailListener docListener   = new detailListener();
    statListener   listener      = new statListener();
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="JLabels">
    JLabel breed         = new JLabel("Breed");
    JLabel path          = new JLabel("Path");
    JLabel form          = new JLabel("Form");
    JLabel mission       = new JLabel("Mission");
    JLabel sentai        = new JLabel("Sentai");
    JLabel totem         = new JLabel("Totem");
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Combo Boxes">
    JComboBox breedCombo   = new JComboBox(breedList);
    JComboBox pathCombo = new JComboBox(pathList);
    JComboBox formBox      = new JComboBox(formList);
    //</editor-fold>
    
    JTextField missionField = new JTextField();
    JTextField sentaiField  = new JTextField();
    JTextField totemField   = new JTextField();
    
    public WerefoxPanel(){
        super();
        
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
        missionField.getDocument().addDocumentListener(docListener);
        sentaiField.getDocument().addDocumentListener(docListener);
        totemField.getDocument().addDocumentListener(docListener);
        
        breedCombo.addItemListener(comboListener);
        pathCombo.addItemListener(comboListener);
        
        //----------------------------------------------------------------------
        // CHARACTER INFO

        c = setGridPos(2, 0);
        panel.add(breed, c);
        
        c = setGridPos(3, 0);
        panel.add(breedCombo, c);
        //---------------------//
        c = setGridPos(4, 0);
        panel.add(sentai, c);
        
        c = setGridPos(5, 0);
        panel.add(sentaiField, c);
        //---------------------//
        c = setGridPos(2, 1);
        panel.add(path, c);
        
        c = setGridPos(3, 1);
        panel.add(pathCombo, c);
        //---------------------//
        c = setGridPos(4, 1);
        panel.add(totem, c);
        
        c = setGridPos(5, 1);
        panel.add(totemField, c);
        //---------------------//
//        c = setGridPos(0, 2);
//        panel.add(tribe, c);
//        
//        c = setGridPos(1, 2);
//        panel.add(tribeCombo, c);
        //---------------------//
        c = setGridPos(2, 2);
        panel.add(mission, c);
        
        c = setGridPos(3, 2);
        panel.add(missionField, c);
        //---------------------//
        c = setGridPos(4, 2);
        panel.add(form, c);
        
        c = setGridPos(5, 2);
        panel.add(formBox, c);
    }
    
    @Override
    public void loadStats(String charName) 
            throws IOException, ClassNotFoundException{
        String dir = System.getProperty("user.dir");// + "\\Characters";
        stats = WerefoxStats.LoadStats(charName, dir);
        initStats();
    }
    
    @Override
    public void saveStats()throws IOException, ClassNotFoundException{
        String dir = System.getProperty("user.dir");// + "\\Characters";
        stats.SaveStats(dir);
    }
 
    @Override
    protected void initStats(){
        if(stats.getBreed() != null){
            breedCombo.setSelectedItem(breedToString(stats.getBreed()));}
        if(stats.getPath() != null){
            pathCombo.setSelectedItem(pathToString(stats.getPath()));}
        if(stats.getMission() != null){
            missionField.setText(stats.getMission());}
        if(stats.getSentai() != null){
            sentaiField.setText(stats.getSentai());}
        if(stats.getTotemName() != null){
            totemField.setText(stats.getTotemName());}
        if(stats.getCName() != null){
            nameField.setText(stats.getCName());}
        if(stats.getPName() != null){
            playerField.setText(stats.getPName());}
        
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
    private String pathToString(WerefoxStats.Path path){
        switch(path){
            case DOSHI:
                return "Doshi";
            case EJI:
                return "Eji";
            case GUKUTSHUSHI:
                return "Gukutsushi";
            case KATARIBE:
                return "Kataribe";
            default:
                return null;
        }
    }
    
    private String breedToString(WerefoxStats.Breed breed){
        switch(breed){
            case KOJIN:
                return "Kojin";
            case SHINJU:
                return "Shinju";
            case ROKO:
                return "Roko";
            default:
                return null;
        }
    }
    // </editor-fold>
}

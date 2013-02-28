/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package WOD.CharacterStats.app;

import PlayerStats.*;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Mike
 */
public class StatPanel extends JScrollPane {
    
    class statListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(str)){
                stats.Strength(str.getValue());
                System.out.println(stats.Strength());
            }
            else if(e.getSource().equals(dex)){
                System.out.println("dexterity edit");
            }
            else if(e.getSource().equals(stam)){
                
            }
            else if(e.getSource().equals(charis)){
                
            }
            else if(e.getSource().equals(manip)){
                
            }
            else if(e.getSource().equals(appear)){
                
            }
            else if(e.getSource().equals(percept)){
                
            }
            else if(e.getSource().equals(intel)){
                
            }
            else if(e.getSource().equals(wits)){
                
            }
            
            else if(e.getSource().equals(alert)){
                
            }
            else if(e.getSource().equals(athlet)){
                
            }
            else if(e.getSource().equals(brawl)){
                
            }
            else if(e.getSource().equals(dodge)){
                
            }
            else if(e.getSource().equals(empathy)){
                
            }
            else if(e.getSource().equals(express)){
                
            }
            else if(e.getSource().equals(intimidate)){
                
            }
            else if(e.getSource().equals(primal)){
                
            }
            else if(e.getSource().equals(streetwise)){
                
            }
            else if(e.getSource().equals(subter)){
                
            }
            
            else if(e.getSource().equals(animalKen)){
                
            }
            else if(e.getSource().equals(crafts)){
                
            }
            else if(e.getSource().equals(drive)){
                
            }
            else if(e.getSource().equals(etiquette)){
                
            }
            else if(e.getSource().equals(firearm)){
                
            }
            else if(e.getSource().equals(melee)){
                
            }
            else if(e.getSource().equals(leader)){
                
            }
            else if(e.getSource().equals(perform)){
                
            }
            else if(e.getSource().equals(stealth)){
                
            }
            else if(e.getSource().equals(survive)){
                
            }
            
            else if(e.getSource().equals(comp)){
                
            }
            else if(e.getSource().equals(enigma)){
                
            }
            else if(e.getSource().equals(investigate)){
                
            }
            else if(e.getSource().equals(law)){
                
            }
            else if(e.getSource().equals(linguist)){
                
            }
            else if(e.getSource().equals(medic)){
                
            }
            else if(e.getSource().equals(occult)){
                
            }
            else if(e.getSource().equals(politics)){
                
            }
            else if(e.getSource().equals(rituals)){
                
            }
            else if(e.getSource().equals(science)){
                
            }
        }  
    }
    
    BaseStats stats = new WerewolfStats();
    
    JPanel panel = new JPanel();
    GridBagLayout mainLayout = new GridBagLayout();
    GridBagConstraints c;
    
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

    Stat str = new Stat("Strength", new statListener());
    Stat dex = new Stat("Dexterity", new statListener());
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
    
    public StatPanel(){
        InitPanel();
    }
    
    private void InitPanel(){
        this.setViewportView(panel);
        panel.setLayout(mainLayout);
        
        //----------------------------------------------------------------------
        // CHARACTER INFO
        
        c = setGridPos(0 ,0, 5);
        panel.add(name, c);
        
        c = setGridPos(1, 0, 5);
        panel.add(breed, c);
        
        c = setGridPos(2, 0, 5);
        panel.add(pack, c);
        
        c = setGridPos(0, 1, 5);
        panel.add(player, c);
        
        c = setGridPos(1, 1, 5);
        panel.add(auspice, c);
        
        c = setGridPos(2, 1, 5);
        panel.add(totem, c);
        
        c = setGridPos(0, 2, 5);
        panel.add(tribe, c);
        
        c = setGridPos(1, 2, 5);
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
        
        c = setGridPos(0, 5, 0);
        panel.add(str, c);
        //str.addActionListener(new statListener());
        
        c = setGridPos(0, 6, 0);
        panel.add(dex, c);
        
        c = setGridPos(0, 7, 0);
        panel.add(stam, c);
        
        c = setLabelPos(1, 4);
        font = new Font(socialLabel.getFont().getName(), Font.PLAIN, 16);
        socialLabel.setFont(font);
        panel.add(socialLabel, c);
        
        c = setGridPos(1, 5, 0);
        panel.add(charis, c);
        
        c = setGridPos(1, 6, 0);
        panel.add(manip, c);
        
        c = setGridPos(1, 7, 0);
        panel.add(appear, c);
        
        c = setLabelPos(2, 4);
        font = new Font(mentalLabel.getFont().getName(), Font.PLAIN, 16);
        mentalLabel.setFont(font);
        panel.add(mentalLabel, c);
        
        c = setGridPos(2, 5, 0);
        panel.add(percept, c);
        
        c = setGridPos(2, 6, 0);
        panel.add(intel, c);
        
        c = setGridPos(2, 7, 0);
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
        
        c = setGridPos(0, 10, 0);
        panel.add(alert, c);
        
        c = setGridPos(0, 11, 0);
        panel.add(athlet, c);
        
        c = setGridPos(0, 12, 0);
        panel.add(brawl, c);
        
        c = setGridPos(0, 13, 0);
        panel.add(dodge, c);
        
        c = setGridPos(0, 14, 0);
        panel.add(empathy, c);
        

        c = setGridPos(0, 15, 0);
        panel.add(express, c);
        
        c = setGridPos(0, 16, 0);
        panel.add(intimidate, c);
        
        c = setGridPos(0, 17, 0);
        panel.add(primal, c);
        
        c = setGridPos(0, 18, 0);
        panel.add(streetwise, c);
        
        c = setGridPos(0, 19, 0);
        panel.add(subter, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - SKILLS
        
        c = setLabelPos(1, 9);
        font = new Font(skillLabel.getFont().getName(), Font.PLAIN, 16);
        skillLabel.setFont(font);
        panel.add(skillLabel, c);
        
        c = setGridPos(1, 10, 0);
        panel.add(animalKen, c);
        
        c = setGridPos(1, 11, 0);
        panel.add(crafts, c);
        
        c = setGridPos(1, 12, 0);
        panel.add(drive, c);
        
        c = setGridPos(1, 13, 0);
        panel.add(etiquette, c);
        
        c = setGridPos(1, 14, 0);
        panel.add(firearm, c);
        
        c = setGridPos(1, 15, 0);
        panel.add(leader, c);
        
        c = setGridPos(1, 16, 0);
        panel.add(melee, c);
        
        c = setGridPos(1, 17, 0);
        panel.add(perform, c);
        
        c = setGridPos(1, 18, 0);
        panel.add(stealth, c);
        
        c = setGridPos(1, 19, 0);
        panel.add(survive, c);
        
        //----------------------------------------------------------------------
        // ABILITIES - KNOWLEDGES
        
        c = setLabelPos(2, 9);
        font = new Font(knowLabel.getFont().getName(), Font.PLAIN, 16);
        knowLabel.setFont(font);
        panel.add(knowLabel, c);
        
        c = setGridPos(2, 10, 0);
        panel.add(comp, c);
        
        c = setGridPos(2, 11, 0);
        panel.add(enigma, c);
        
        c = setGridPos(2, 12, 0);
        panel.add(investigate, c);
        
        c = setGridPos(2, 13, 0);
        panel.add(law, c);
        
        c = setGridPos(2, 14, 0);
        panel.add(linguist, c);

        c = setGridPos(2, 15, 0);
        panel.add(medic, c);

        c = setGridPos(2, 16, 0);
        panel.add(occult, c);

        c = setGridPos(2, 17, 0);
        panel.add(politics, c);
        
        c = setGridPos(2, 18, 0);
        panel.add(rituals, c);
        
        c = setGridPos(2, 19, 0);
        panel.add(science, c);
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

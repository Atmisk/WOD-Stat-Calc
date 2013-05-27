/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerStats;

import java.io.IOException;

/**
 *
 * @author Mike
 */
public class WerefoxStats extends BaseStats{
    final int BaseRenown = 0;
    
    public enum ShiftedForm{
        HITOGATA, SAMBUHENGE , KOTO, JUKO, KYUBI
    }
    
    public enum Breed{
        KOJIN, SHINJU, ROKO
    }
    
    public enum Path{
        DOSHI, EJI, GUKUTSHUSHI, KATARIBE
    }
    
    public enum Rank{
        YAKAN1, KIKO2, KORYO3, KEIKO4, TENKO5
    }
    private WerefoxStats.Breed breed= null;
    private WerefoxStats.Path path = null;
    private String mission = null;
    private String sentai = null;
    private String totemName = null;
    // Renown
    private int chie = BaseRenown; // wisdom
    private int toru = BaseRenown; // honor
    private int kagayaki = BaseRenown; // glory
    
    private WerefoxStats.ShiftedForm form = WerefoxStats.ShiftedForm.HITOGATA;
    
    public WerefoxStats(){
        super();
        //race = Race.FOX;
    }
    public WerefoxStats(String playerName, String characterName){
        super(playerName, characterName);
        //race = Race.FOX;
    }
    
    public WerefoxStats.Breed getBreed(){return breed;}
    public WerefoxStats.Path getPath(){return path;}
    public String getMission(){return mission;}
    public String getSentai(){return sentai;}
    public String getTotemName(){return totemName;}
    public WerefoxStats.ShiftedForm getForm(){return form;}
    
    public int getKagayaki(){return kagayaki;}
    public int getToru(){return toru;}
    public int getChie(){return chie;}
    
    public void setBreed(WerefoxStats.Breed value){breed = value;}
    public void setPath(WerefoxStats.Path value){path = value;}
    public void setMission(String value){mission = value;}
    public void setSentai(String value){sentai = value;}
    public void setTotemName(String value){totemName = value;}
    public void setForm(WerefoxStats.ShiftedForm form){
        this.form = form;
        FormShift(form);
    }
    
    public void setKagayaki(int value){kagayaki = value;}
    public void setToru(int value){toru = value;}
    public void setChie(int value){chie = value;}
    
    public void FormShift(WerefoxStats.ShiftedForm form){
        switch(form){
            case HITOGATA:
                adjStr = strength;
                adjDex = dexterity;
                adjStam = stamina;
                adjChrsma = charisma;
                adjManip = manipulation;
                adjAppear = appearance;
                adjPerc = perception;
                adjInt = intelligence;
                adjWits = wits;
                break;
            case SAMBUHENGE:
                adjStr = strength;
                adjDex = dexterity+1;
                adjStam = stamina+1;
                adjChrsma = charisma;
                if((adjManip = manipulation-1) < 0){
                    adjManip = 0;
                }
                adjAppear = 0;
                adjPerc = perception+1;
                adjInt = intelligence;
                adjWits = wits;
                break;
            case KOTO:
                adjStr = strength+1;
                adjDex = dexterity+1;
                adjStam = stamina+3;
                adjChrsma = charisma;
                if((adjManip = manipulation-1) < 0){
                    adjManip = 0;
                }
                adjAppear = 0;
                adjPerc = perception;
                adjInt = intelligence;
                adjWits = wits;
                break;
            case JUKO:
                adjStr = strength;
                adjDex = dexterity+3;
                adjStam = stamina+3;
                adjChrsma = charisma;
                if((adjManip = manipulation-2) < 0){
                    adjManip = 0;
                }
                adjAppear = appearance;
                adjPerc = perception+1;
                adjInt = intelligence;
                adjWits = wits;
                break;
            case KYUBI:
                adjStr = strength;
                adjDex = dexterity+4;
                adjStam = stamina+2;
                adjChrsma = charisma;
                if((adjManip = manipulation-1) < 0){
                    adjManip = 0;
                }
                adjAppear = appearance;
                adjPerc = perception+2;
                adjInt = intelligence;
                adjWits = wits;
        }
    }
    
    public static WerefoxStats LoadStats(String fileName, String dir) 
            throws IOException, ClassNotFoundException{
        return (WerefoxStats) BaseStats.LoadStats(fileName, dir);
    }
}

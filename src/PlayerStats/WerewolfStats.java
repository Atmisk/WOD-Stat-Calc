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
public class WerewolfStats extends BaseStats{
    final int BaseRenown = 0;
    
    public enum ShiftedForm{
        HOMID, GLABRO, CRINOS, HISPO, LUPUS
    }
    
    public enum Breed{
        HOMID, METIS, LUPUS
    }
    
    public enum Auspice{
        RAGABASH, THEURGE, PHILODOX, GALLIARD, AHROUN
    }
    
    public enum Tribe{
        BLACKFURY, BONEGNAWER, CHILDOFGAIA, FIANNA, GETOFFENRIS, 
        GLASSWALKER, REDTALON, SHADOWLORD, SILENTSTRIDER, SILVERFANG,
        STARGAZER, UKTENA, WENDIGO
    }
    
    public enum Rank{
        CLIATH1, FOSTERN2, ADREN3, ATHRO4, ELDER5
    }
    private Breed breed= null;
    private Auspice auspice= null;
    private String camp= null;
    private String packName= null;
    private String totemName= null;
    private Tribe tribe = null;
    // Renown
    private int glory = BaseRenown;
    private int honor = BaseRenown;
    private int wisdom = BaseRenown;
    
    private ShiftedForm form = ShiftedForm.HOMID;
    
    public WerewolfStats(){
        super();
        //race = Race.WOLF;
    }
    
    public WerewolfStats(String playerName, String characterName){
        super(playerName, characterName);
        //race = Race.WOLF;
    }
    
    public Breed getBreed(){return breed;}
    public Auspice getAuspice(){return auspice;}
    public String getCamp(){return camp;}
    public String getPackName(){return packName;}
    public String getTotemName(){return totemName;}
    public Tribe getTribe(){return tribe;}
    public ShiftedForm getForm(){return form;}
    
    public int getGlory(){return glory;}
    public int getHonor(){return honor;}
    public int getWisdom(){return wisdom;}
    
    public void setBreed(Breed value){breed = value;}
    public void setAuspice(Auspice value){auspice = value;}
    public void setCamp(String value){camp = value;}
    public void setPackName(String value){packName = value;}
    public void setTotemName(String value){totemName = value;}
    public void setTribe(Tribe value){tribe = value;}
    public void setForm(ShiftedForm form){
        this.form = form;
        FormShift(form);
    }
    
    public void setGlory(int value){glory = value;}
    public void setHonor(int value){honor = value;}
    public void setWisdom(int value){wisdom = value;}
    
    public void FormShift(ShiftedForm form){
        switch(form){
            case HOMID:
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
            case GLABRO:
                adjStr = strength+2;
                adjDex = dexterity;
                adjStam = stamina+2;
                adjChrsma = charisma;
                if((adjManip = manipulation-1) < 0){
                    adjManip = 0;
                }
                if((adjAppear = appearance-1) < 0){
                    adjAppear = 0;
                }
                adjPerc = perception;
                adjInt = intelligence;
                adjWits = wits;
                break;
            case CRINOS:
                adjStr = strength+4;
                adjDex = dexterity+1;
                adjStam = stamina+3;
                adjChrsma = charisma;
                if((adjManip = manipulation-3) < 0){
                    adjManip = 0;
                }
                adjAppear = 0;
                adjPerc = perception;
                adjInt = intelligence;
                adjWits = wits;
                break;
            case HISPO:
                adjStr = strength+3;
                adjDex = dexterity+2;
                adjStam = stamina+3;
                adjChrsma = charisma;
                if((adjManip = manipulation-3) < 0){
                    adjManip = 0;
                }
                adjAppear = appearance;
                adjPerc = perception;
                adjInt = intelligence;
                adjWits = wits;
                break;
            case LUPUS:
                adjStr = strength+1;
                adjDex = dexterity+2;
                adjStam = stamina+2;
                adjChrsma = charisma;
                if((adjManip = manipulation-3) < 0){
                    adjManip = 0;
                }
                if((adjAppear = appearance-1) < 0){
                    adjAppear = 0;
                }
                adjPerc = perception;
                adjInt = intelligence;
                adjWits = wits;
        }
    }
    
    public static WerewolfStats LoadStats(String fileName, String dir) 
            throws IOException, ClassNotFoundException{
        return (WerewolfStats) BaseStats.LoadStats(fileName, dir);
    }
}

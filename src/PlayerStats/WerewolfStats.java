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
        HOMID, CRINOS, LUPUS
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
    // Adjusted Stats
    private int adjStr = strength;
    private int adjDex = dexterity;
    private int adjStam = stamina;
    
    private int adjChrsma = charisma;
    private int adjManip = manipulation;
    private int adjAppear = appearance;
    
    private int adjPerc = perception;
    private int adjInt = intelligence;
    private int adjWits = wits;
    
    private ShiftedForm form = ShiftedForm.HOMID;
    
    public WerewolfStats(){
        super();
        race = Race.WOLF;
    }
    /*public WerewolfStats(String Name, name type){
        super(Name, type);
        race = Race.WOLF;
    }*/
    public WerewolfStats(String playerName, String characterName){
        super(playerName, characterName);
        race = Race.WOLF;
    }
    
    public Breed Breed(){return breed;}
    public Auspice Auspice(){return auspice;}
    public String Camp(){return camp;}
    public String PackName(){return packName;}
    public String TotemName(){return totemName;}
    public Tribe Tribe(){return tribe;}
    public ShiftedForm Form(){return form;}
    
    public int Glory(){return glory;}
    public int Honor(){return honor;}
    public int Wisdom(){return wisdom;}
    
    public int AdjStr(){return adjStr;}
    public int AdjDex(){return adjDex;}
    public int AdjStam(){return adjStam;}
    
    public int AdjChrsma(){return adjChrsma;}
    public int AdjManip(){return adjManip;}
    public int AdjAppear(){return adjAppear;}
    
    public int AdjPerc(){return adjPerc;}
    public int AdjInt(){return adjInt;}
    public int AdjWits(){return adjWits;}
    
    public void Breed(Breed value){breed = value;}
    public void Auspice(Auspice value){auspice = value;}
    public void Camp(String value){camp = value;}
    public void PackName(String value){packName = value;}
    public void TotemName(String value){totemName = value;}
    public void Tribe(Tribe value){tribe = value;}
    public void Form(ShiftedForm value){form = value;}
    
    public void Glory(int value){glory = value;}
    public void Honor(int value){honor = value;}
    public void Wisdom(int value){wisdom = value;}
    
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
                adjManip = manipulation-1;
                adjAppear = appearance-1;
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
                adjManip = manipulation-3;
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
                adjManip = manipulation-3;
                adjAppear = appearance-1;
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

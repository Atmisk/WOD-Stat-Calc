/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerStats;

/**
 *
 * @author Mike
 */
public class WerewolfStats extends BaseStats{
    final int BaseRenown = 0;
    
    protected String breed= null;
    protected String auspice= null;
    protected String camp= null;
    protected String packName= null;
    protected String totemName= null;
    protected String tribe = null;
    // Renown
    protected int glory = BaseRenown;
    protected int honor = BaseRenown;
    protected int wisdom = BaseRenown;
    
    public enum ShiftedForm{
        HOMID, GLRABRO, CRINOS, HISPO, LUPUS
    }
    
    protected ShiftedForm form = null;
    
    public WerewolfStats(){
        super();
    }
    public WerewolfStats(String Name, name type){
        super(Name, type);
    }
    public WerewolfStats(String playerName, String characterName){
        super(playerName, characterName);
    }
    
    public String Breed(){return breed;}
    public String Auspice(){return auspice;}
    public String Camp(){return camp;}
    public String PackName(){return packName;}
    public String TotemName(){return totemName;}
    
    public int Glory(){return glory;}
    public int Honor(){return honor;}
    public int Wisdom(){return wisdom;}
    
    public void Breed(String value){breed = value;}
    public void Auspice(String value){auspice = value;}
    public void Camp(String value){camp = value;}
    public void PackName(String value){packName = value;}
    public void TotemName(String value){totemName = value;}
    
    public void Glory(int value){glory = value;}
    public void Honor(int value){honor = value;}
    public void Wisdom(int value){wisdom = value;}
}

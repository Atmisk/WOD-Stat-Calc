/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerStats;

/**
 *
 * @author Mike
 */
public class Gift {
    final int defaultDiff = 6;
    
    public enum usedStat{
        RAGE, GNOSIS, WILLPOWER
    }
    public enum attribute{
        STRENGTH, DEXTERITY, STAMINA, CHARISMA, MANIPULATION, APPEARANCE,
        PERCEPTION, INTELLIGENCE, WITS
    }
    public enum talent{
        ALERTNESS, ATHLETICS, BRAWL, DODGE, EMPATHY, EXPRESSION, INTIMIDATION,
        PRIMALURGE, STREETWISE, SUBTERFUGE, SEARCH, ANIMALKEN, CRAFTS, DRIVE,
        ETIQUETTE, FIREARMS, LEADERSHIP, MELEE, PERFORMANCE, STEALTH, SURVIVAL,
        INSTRUCTION, MIMICRY, VENTRILOQUISM, ARCHERY, GAMBLING, MEDITATION,
        TRAPS, SWIMMING, KAILINDO, KLAIVEDUEL, REPAIR, COMPUTER, ENIGMAS,
        INVESTIGATION, LAW, LINGUISTICS, MEDICINE, OCCULT, POLITICS, RITUALS,
        SCIENCE, POISONS, DEMOLITIONS, PILOT, COSMOLOGY, AREAKNOW, HERBALSIM,
        WYRMLORE
    }
    private static int giftNum = 0;
    private String name;
    private boolean roll;
    private boolean spend;
    private usedStat rollStat;
    private usedStat spentStat;
    private int spentAmt;
    private int difficulty;
    private attribute rollAtt;
    private talent rollTalent;
    private boolean chooseable;
    
    public Gift(){
        giftNum++;
        name = "Gift" + String.valueOf(giftNum);
        roll = false;
        spend = false;
        rollStat = null;
        spentStat = null;
        spentAmt = 0;
        difficulty = defaultDiff;
        rollAtt = null;
        rollTalent = null;
        chooseable = false;
    }
    // check if spend
    //      if so, what is cost type? 
    //      is cost amount choosable?
    //      if not, what is cost amount?
    // check if roll
    //      if so, what roll? 1 or 2?
    //          what stat(s)?
    // if neither then it just activates
    public int GiftNum(){return giftNum;}
    public String Name(){return name;}
    public boolean Roll(){return roll;}
    public boolean Spend(){return spend;}
    public usedStat RollStat(){return rollStat;}
    public usedStat SpentStat(){return spentStat;}
    public int SpentAmt(){return spentAmt;}
    public int Difficulty(){return difficulty;}
    public attribute RollAtt(){return rollAtt;}
    public talent RollTalent(){return rollTalent;}
    public boolean Chooseable(){return chooseable;}
    
    public void GiftNum(int value){giftNum = value;}
    public void Name(String value){name = value;}
    public void Roll(boolean value){roll = value;}
    public void Spend(boolean value){spend = value;}
    public void RollStat(usedStat value){rollStat = value;}
    public void SpentStat(usedStat value){spentStat = value;}
    public void SpentAmt(int value){spentAmt = value;}
    public void Difficulty(int value){difficulty = value;}
    public void RollAtt(attribute value){rollAtt = value;}
    public void RollTalent(talent value){rollTalent = value;}
    public void Chooseable(boolean value){chooseable = value;}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerStats;
import java.io.Serializable;

/**
 *
 * @author Mike
 * 
 * Gift represents a gift from the Role-playing game World of Darkness.
 * 
 */
public class Gift implements Serializable{
    final int defaultDiff = 6;
    /**
     * Represents the attributes Rage, Gnosis, and Willpower.
     * These stats have a permanent rating along with a temporary one.
     */
    public enum Power{
        RAGE, GNOSIS, WILLPOWER
    }
    /**
     * These are the physical attributes used by player characters in the
     * World of Darkness Setting
     */
    public enum Attribute{
        STRENGTH, DEXTERITY, STAMINA, CHARISMA, MANIPULATION, APPEARANCE,
        PERCEPTION, INTELLIGENCE, WITS
    }
    /**
     * This is a base list of talents commonly used by World of Darkness
     * characters
     */
    public enum Talent{
        ALERTNESS, ATHLETICS, BRAWL, DODGE, EMPATHY, EXPRESSION, INTIMIDATION,
        PRIMALURGE, STREETWISE, SUBTERFUGE, SEARCH, ANIMALKEN, CRAFTS, DRIVE,
        ETIQUETTE, FIREARMS, LEADERSHIP, MELEE, PERFORMANCE, STEALTH, SURVIVAL,
        INSTRUCTION, MIMICRY, VENTRILOQUISM, ARCHERY, GAMBLING, MEDITATION,
        TRAPS, SWIMMING, KAILINDO, KLAIVEDUEL, REPAIR, COMPUTER, ENIGMAS,
        INVESTIGATION, LAW, LINGUISTICS, MEDICINE, OCCULT, POLITICS, RITUALS,
        SCIENCE, POISONS, DEMOLITIONS, PILOT, COSMOLOGY, AREAKNOW, HERBALSIM,
        WYRMLORE
    }
    public enum BoostType{
        ATTRIBUTE, ABILITY
    }
    private class Cost implements Serializable{
        private Power power;
        private int amount;
        private boolean adjustable;
        
        public Cost(){
            power = null;
            amount = 0;
            adjustable = false;
        }
        public Cost(Power power, int amount, boolean adjustable){
            this.power = power;
            this.amount = amount;
            this.adjustable = adjustable;
        }
        public Power getPower(){return power;}
        public int getAmount(){return amount;}
        public boolean isAdjustable(){return adjustable;}
        
        public void setPower(Power power){this.power = power;}
        public void setAmount(int amount){this.amount = amount;}
        public void setAdjust(boolean adjust){adjustable = adjust;}
        
        public void copyCost(Cost cost){
            if(cost != null){
                this.power = cost.power;
                this.amount = cost.amount;
                this.adjustable = cost.adjustable;
            }
        }
    }
    private class AttributeRoll implements Serializable{
        private Attribute attr;
        private Talent talent;
        private int difficulty;
        
        public AttributeRoll(){
            attr = null;
            talent = null;
            difficulty = 6;
        }
        public AttributeRoll(Attribute attr, Talent talent, int difficulty){
            this.attr = attr;
            this.talent = talent;
            this.difficulty = difficulty;
        }
        public Attribute getAttr(){return attr;}
        public Talent getTalent(){return talent;}
        public int getDiffic(){return difficulty;}
        
        public void setAttr(Attribute attr){this.attr = attr;}
        public void setTalent(Talent talent){this.talent = talent;}
        public void setDiffic(int difficulty){this.difficulty = difficulty;}
        
        public void copyAttrRoll(AttributeRoll attrRoll){
            if(attrRoll != null){
                attr = attrRoll.attr;
                talent = attrRoll.talent;
                difficulty = attrRoll.difficulty;
            }
        }
    }
    private class PowerRoll implements Serializable{
        private Power power;
        private int difficulty;
        
        public PowerRoll(){
            power = null;
            difficulty = 0;
        }
        public PowerRoll(Power power, int difficulty){
            this.power = power;
            this.difficulty = difficulty;
        }
        public Power getAttr(){return power;}
        public int getDiffic(){return difficulty;}
        
        public void setAttr(Power power){this.power = power;}
        public void setDiffic(int difficulty){this.difficulty = difficulty;}
        
        public void copyPwrRoll(PowerRoll powerRoll){
            if(powerRoll != null){
                power = powerRoll.power;
                difficulty = powerRoll.difficulty;
            }
        }
    }
    private class Effect implements Serializable{
        private String description;
        private int boostAmt;
        private BoostType boostT;
        
        public Effect(){
            description = "";
            boostAmt = 0;
            boostT = null;
        }
        public Effect(String description, int boostAmt, BoostType boostT){
            this.description = description;
            this.boostAmt = boostAmt;
            this.boostT = boostT;
        }
        
        public String getDesc(){return description;}
        public int getBoostAmt(){return boostAmt;}
        public BoostType getbBoostType(){return boostT;}
        
        public void setDesc(String description){
            this.description = description;
        }
        public void setBoostAmt(int boostAmt){
            this.boostAmt = boostAmt;
        }
        public void setBoostT(BoostType boostT){
            this.boostT = boostT;
        }
        
        public void copyEffect(Effect effect){
            if(effect != null){
                this.description = effect.description;
                this.boostAmt = effect.boostAmt;
                this.boostT = effect.boostT;
            }
        }
    }
    private String name;
    private String description;
    private Cost cost;
    private AttributeRoll attrRoll;
    private PowerRoll powerRoll;
    private Effect effect;
    
    public Gift(){
        name = "Gift";
        description = "";
        cost = null;
        attrRoll = null;
        powerRoll = null;
        effect = null;
    }
    public Gift(String name,
                String giftDescr,
                Power cPower,
                int amount,
                boolean adjustable,
                Attribute attr,
                Talent talent,
                int attrDiff,
                Power pPower,
                int pwrDiff,
                String effectDescr,
                int boostAmt,
                BoostType boostT){
        this.name = name;
        this.description = giftDescr;
        this.cost = new Cost(cPower, amount, adjustable);
        this.attrRoll = new AttributeRoll(attr, talent, attrDiff);
        this.powerRoll = new PowerRoll(pPower, pwrDiff);
        this.effect = new Effect(effectDescr, boostAmt, boostT);
    }
    public String getName(){return name;}
    public String getDescription(){return description;}
    //public Cost getCost(){return cost;}
    //public AttributeRoll getAttrRoll(){return attrRoll;}
    //public PowerRoll getPwrRoll(){return powerRoll;}
    //public Effect getEffect(){return effect;}
    
    public Power getCostPwr(){
        if(this.hasCost()){
            return cost.power;
        }
        else{return null;}
    }
    public int getCostAmt(){
        if(this.hasCost()){
            return cost.amount;
        }
        else{return 0;}
    }
    public boolean getCostAdj(){
        if(this.hasCost()){
            return cost.adjustable;
        }
        else{return false;}
    }
    
    public Attribute getAttRollAttr(){
        if(this.hasAttRoll()){
            return attrRoll.attr;
        }
        else{return null;}
    }
    public Talent getAttRollTal(){
        if(this.hasAttRoll()){
            return attrRoll.talent;
        }
        else{return null;}
    }
    public int getAttRollDiff(){
        if(this.hasAttRoll()){
            return attrRoll.difficulty;
        }
        else{return 0;}
    }
    
    public Power getPwrRollPwr(){
        if(this.hasPwrRoll()){
            return powerRoll.power;
        }
        else{return null;}
    }
    public int getPwrRollDiff(){
        if(this.hasPwrRoll()){
            return powerRoll.difficulty;
        }
        else{return 0;}
    }
    
    public String getEffectDesc(){
        if(this.hasEffect()){
            return effect.description;
        }
        else{return null;}
    }
    public int getEffectBstAmt(){
        if(this.hasEffect()){
            return effect.boostAmt;
        }
        else{return 0;}
    }
    public BoostType getEffectBstT(){
        if(this.hasEffect()){
            return effect.boostT;
        }
        else{return null;}
    }
    
    public void setName(String value){name = value;}
    public void setDescription(String value){description = value;}
    /*public void setCost(Cost cost){
        this.cost.power = cost.power;
        this.cost.amount = cost.amount;
        this.cost.adjustable = cost.adjustable;
    }
    public void setAttrRoll(AttributeRoll attrRoll){
        this.attrRoll.attr = attrRoll.attr;
        this.attrRoll.difficulty = attrRoll.difficulty;
        this.attrRoll.talent = attrRoll.talent;
    }
    public void setPwrRoll(PowerRoll powerRoll){
        this.powerRoll.power = powerRoll.power;
        this.powerRoll.difficulty = powerRoll.difficulty;
    }
    public void setEffect(Effect effect){
        this.effect.description = effect.description;
        this.effect.boostAmt = effect.boostAmt;
        this.effect.boostT = effect.boostT;
    }*/
    
    public void setCostPwr(Power power){
        cost.power = power;
    }
    public void setCostAmt(int amount){
        cost.amount = amount;
    }
    public void setCostAdj(boolean adjustable){
        cost.adjustable = adjustable;
    }
    
    public void setAttRollAttr(Attribute attr){
        attrRoll.attr = attr;
    }
    public void setAttRollTal(Talent talent){
        attrRoll.talent = talent;
    }
    public void setAttRollDiff(int difficulty){
        attrRoll.difficulty = difficulty;
    }
    
    public void setPwrRollPwr(Power power){
        powerRoll.power = power;
    }
    public void setPwrRollDiff(int difficulty){
        powerRoll.difficulty = difficulty;
    }
    
    public void setEffectDesc(String description){
        effect.description = description;
    }
    public void setEffectBstAmt(int boostAmt){
        effect.boostAmt = boostAmt;
    }
    public void setEffectBstT(BoostType boostT){
        effect.boostT = boostT;
    }
    
    // hasCost, hasActRoll, hasPwrRoll, copyGift
    public void copyGift(Gift gift){
        this.name = gift.name;
        this.description = gift.description;
        if(this.cost == null){
            this.cost = new Cost();
        }
        this.cost.copyCost(gift.cost);
        if(this.attrRoll == null){
            this.attrRoll = new AttributeRoll();
        }
        this.attrRoll.copyAttrRoll(gift.attrRoll);
        if(this.powerRoll == null){
            this.powerRoll = new PowerRoll();
        }
        this.powerRoll.copyPwrRoll(gift.powerRoll);
        if(this.effect == null){
            this.effect = new Effect();
        }
        this.effect.copyEffect(gift.effect);
    }
    public boolean hasCost(){
        if(cost == null){
            return false;}
        else{return true;}
    }
    public boolean hasAttRoll(){
        if(attrRoll == null){
            return false;}
        else{return true;}
    }
    public boolean hasPwrRoll(){
        if(powerRoll == null){
            return false;}
        else{return true;}
    }
    public boolean hasEffect(){
        if(effect == null){
            return false;
        }
        else{return true;}
    }
}

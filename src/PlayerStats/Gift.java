/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerStats;

/**
 *
 * @author Mike
 * 
 * Gift represents a gift from the Role-playing game World of Darkness.
 * 
 */
public class Gift {
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
    public static class Cost{
        private Power power;
        private int amount;
        private boolean adjustable;
        
        public Cost(){
            power = Power.GNOSIS;
            amount = 1;
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
            this.power = cost.power;
            this.amount = cost.amount;
            this.adjustable = cost.adjustable;
        }
    }
    public static class AttributeRoll{
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
            attr = attrRoll.attr;
            talent = attrRoll.talent;
            difficulty = attrRoll.difficulty;
        }
    }
    public static class PowerRoll{
        private Power power;
        private int difficulty;
        
        public PowerRoll(){
            power = null;
            difficulty = 6;
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
            power = powerRoll.power;
            difficulty = powerRoll.difficulty;
        }
    }
    //public static class Effect{
        
    //}
    private String name;
    private String description;
    private Cost cost;
    private AttributeRoll attrRoll;
    private PowerRoll powerRoll;
    
    public Gift(){
        name = "Gift";
        description = "";
        cost = null;
        attrRoll = null;
        powerRoll = null;
    }
    public Gift(String name,
                String description,
                Cost cost,
                AttributeRoll attrRoll,
                PowerRoll powerRoll){
        this.name = name;
        this.description = description;
        this.cost = new Cost();
        this.cost.copyCost(cost);
        this.attrRoll = new AttributeRoll();
        this.attrRoll.copyAttrRoll(attrRoll);
        this.powerRoll = new PowerRoll();
        this.powerRoll.copyPwrRoll(powerRoll);
    }
    public String getName(){return name;}
    public String getDescription(){return description;}
    public Cost getCost(){return cost;}
    public AttributeRoll getAttrRoll(){return attrRoll;}
    public PowerRoll getPwrRoll(){return powerRoll;}
    
    public void setName(String value){name = value;}
    public void setDescription(String value){description = value;}
    public void setCost(Cost cost){
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
}

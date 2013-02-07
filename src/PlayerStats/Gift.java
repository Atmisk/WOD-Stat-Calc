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
    
    public enum Power{
        RAGE, GNOSIS, WILLPOWER
    }
    public enum Attribute{
        STRENGTH, DEXTERITY, STAMINA, CHARISMA, MANIPULATION, APPEARANCE,
        PERCEPTION, INTELLIGENCE, WITS
    }
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
    public class Cost{
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
    }
    public class AttributeRoll{
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
    }
    public class PowerRoll{
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
    }
    public class Effect{
        
    }
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
    public String getName(){return name;}
    public String getDescription(){return description;}
    public Cost getCost(){return cost;}
    public AttributeRoll getAttrRoll(){return attrRoll;}
    public PowerRoll getPwrRoll(){return powerRoll;}
    
    public void setName(String value){name = value;}
    public void setDescription(String value){description = value;}
    public void setCost(Cost cost){this.cost = cost;}
    public void setAttrRoll(AttributeRoll attrRoll){this.attrRoll = attrRoll;}
    public void setPwrRoll(PowerRoll powerRoll){this.powerRoll = powerRoll;}
    
    // hasCost, hasActRoll, hasPwrRoll
}

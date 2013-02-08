/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerStats;
import java.util.ArrayList;

/**
 *
 * @author Mike
 */

public abstract class BaseStats {
    private final int BaseAttVal = 1;
    private final int BaseSkillVal = 0;
    final int BasePower = 0;
    public final String defaultName= "Character";
    
    public enum HealthLevel {
        NODAMAGE, BRUISED, HURT, INJURED, WOUNDED, MAULED, CRIPPLED, 
        INCAPACITATED, DEAD
    }
    public enum name{
        PLAYER, CHARACTER
    }
    
    protected String playerName;
    protected String characterName;
    // phyisical stats
    protected int strength = BaseAttVal;
    protected int dexterity = BaseAttVal;
    protected int stamina = BaseAttVal;
    // social stats
    protected int charisma = BaseAttVal;
    protected int manipulation = BaseAttVal;
    protected int appearance = BaseAttVal;
    // mental stats
    protected int perception = BaseAttVal;
    protected int intelligence = BaseAttVal;
    protected int wits = BaseAttVal;
    // Base talents
    protected int alertness = BaseSkillVal;
    protected int athletics = BaseSkillVal;
    protected int brawl = BaseSkillVal;
    protected int dodge = BaseSkillVal;
    protected int empathy = BaseSkillVal;
    protected int expression = BaseSkillVal;
    protected int intimidation = BaseSkillVal;
    protected int primalUrge = BaseSkillVal;
    protected int streetwise = BaseSkillVal;
    protected int subterfuge = BaseSkillVal;
    protected int search = BaseSkillVal;
    // Base skills
    protected int animalKen = BaseSkillVal;
    protected int crafts = BaseSkillVal;
    protected int drive = BaseSkillVal;
    protected int etiquette = BaseSkillVal;
    protected int firearms = BaseSkillVal;
    protected int leadership = BaseSkillVal;
    protected int melee = BaseSkillVal;
    protected int performance = BaseSkillVal;
    protected int stealth = BaseSkillVal;
    protected int survival = BaseSkillVal;
    protected int instruction = BaseSkillVal;
    protected int mimicry = BaseSkillVal;
    protected int ventriloquism = BaseSkillVal;
    protected int archery = BaseSkillVal;
    protected int gambling = BaseSkillVal;
    protected int meditation = BaseSkillVal;
    protected int traps = BaseSkillVal;
    protected int swimming = BaseSkillVal;
    protected int kailindo = BaseSkillVal;
    protected int klaiveDuel = BaseSkillVal;
    protected int repair = BaseSkillVal;
    // Base knowledges
    protected int computer = BaseSkillVal;
    protected int enigmas = BaseSkillVal;
    protected int investigation = BaseSkillVal;
    protected int law = BaseSkillVal;
    protected int linguistics = BaseSkillVal;
    protected int medicine = BaseSkillVal;
    protected int occult = BaseSkillVal;
    protected int politics = BaseSkillVal;
    protected int rituals = BaseSkillVal;
    protected int science = BaseSkillVal;
    protected int poisons = BaseSkillVal;
    protected int demolitions = BaseSkillVal;
    protected int pilot = BaseSkillVal;
    protected int cosmology = BaseSkillVal;
    protected int areaKnow = BaseSkillVal;
    protected int herbalism = BaseSkillVal;
    protected int wyrmLore = BaseSkillVal;
    // Background
    protected int allies = BaseSkillVal;
    protected int ancestors = BaseSkillVal;
    protected int contacts = BaseSkillVal;
    protected int fetish = BaseSkillVal;
    protected int kinfolk = BaseSkillVal;
    protected int mentor = BaseSkillVal;
    protected int purebreed = BaseSkillVal;
    protected int resources = BaseSkillVal;
    protected int rites = BaseSkillVal;
    protected int totem = BaseSkillVal;
    // Health level
    protected HealthLevel lethal = HealthLevel.NODAMAGE;
    protected HealthLevel aggrevated = HealthLevel.NODAMAGE;
    // List of gifts
    ArrayList<Gift> giftList = new ArrayList<>();
    // List of weapons
    ArrayList<Weapon> weaponList = new ArrayList<>();
    
    protected int permRage = BasePower;
    protected int permGnosis = BasePower;
    protected int permWillpower = BasePower;
    
    protected int tempRage = BasePower;
    protected int tempGnosis = BasePower;
    protected int tempWillpower = BasePower;
    // Constructors
    public BaseStats(){
        playerName = null;
        characterName = defaultName;
    }
    public BaseStats(String Name, name type){
        if(type == name.CHARACTER){
            characterName = Name;
            playerName = null;
        }
        else{
            playerName = Name;
            characterName = defaultName;
        }
    }
    public BaseStats(String playerName, String characterName) {
        this.playerName = playerName;
        this.characterName = characterName;
    }
    public String getPName(){return playerName;}
    public String getCName(){return characterName;}

    public int Strength() {return strength;}
    public int Dexterity() {return dexterity;}
    public int Stamina() {return stamina;}
    
    public int Charisma() {return charisma;}
    public int Manip() {return manipulation;}
    public int Appear() {return appearance;}
    
    public int Percept() {return perception;}
    public int Intel() {return intelligence;}
    public int Wits() {return wits;}
    
    public int Alert() {return alertness;}
    public int Athletic() {return athletics;}
    public int Brawl() {return brawl;}
    public int Dodge() {return dodge;}
    public int Empathy() {return empathy;}
    public int Express() {return expression;}
    public int Intimidate() {return intimidation;}
    public int Primal() {return primalUrge;}
    public int StreeWise() {return streetwise;}
    public int Subterfuge() {return subterfuge;}
    public int Search() {return search;}
    
    public int AnimalKen() {return animalKen;}
    public int Crafts() {return crafts;}
    public int Drive() {return drive;}
    public int Etiquette() {return etiquette;}
    public int Firearms() {return firearms;}
    public int Leadership() {return leadership;}
    public int Melee() {return melee;}
    public int Performance() {return performance;}
    public int Stealth() {return stealth;}
    public int Survival() {return survival;}
    public int Instruction() {return instruction;}
    public int Mimicry() {return mimicry;}
    public int Ventril() {return ventriloquism;}
    public int Archery() {return archery;}
    public int Gambling() {return gambling;}
    public int Medication() {return meditation;}
    public int Traps() {return traps;}
    public int Swimming() {return swimming;}
    public int Kailindo() {return kailindo;}
    public int KlaiveDuel() {return klaiveDuel;}
    public int Repair() {return repair;}
    
    public int Comuter() {return computer;}
    public int Enigmas() {return enigmas;}
    public int Investigate() {return investigation;}
    public int Law() {return law;}
    public int Linguistics() {return linguistics;}
    public int Medicine() {return medicine;}
    public int Occult() {return occult;}
    public int Politics() {return politics;}
    public int Rituals() {return rituals;}
    public int Science() {return science;}
    public int Poisions() {return poisons;}
    public int Demolitions() {return demolitions;}
    public int pilot() {return pilot;}
    public int Cosmology() {return cosmology;}
    public int AreaKnow() {return areaKnow;}
    public int Herbalsim() {return herbalism;}
    public int WyrmLore() {return wyrmLore;}
    
    public int Allies() {return allies;}
    public int Ancestors() {return ancestors;}
    public int Contacts() {return contacts;}
    public int Fetish() {return fetish;}
    public int Kinfolk() {return kinfolk;}
    public int Mentor() {return mentor;}
    public int Purebreed() {return purebreed;}
    public int Resources() {return resources;}
    public int Rites() {return rites;}
    public int Totem() {return totem;}
    
    public HealthLevel LethalDmg() {return lethal;}
    public HealthLevel AggDmg() {return aggrevated;}
    
    public int PermRage(){return permRage;}
    public int PermGnosis(){return permGnosis;}
    public int PermWillpower(){return permWillpower;}
    
    public int TempRage(){return tempRage;}
    public int TempGnosis(){return tempGnosis;}
    public int TempWillpower(){return tempWillpower;}
    
    public void setPName(String Name){playerName = Name;}
    public void setCName(String Name){characterName = Name;}

    public void Strength(int value) {strength = value;}
    public void Dexterity(int value) {dexterity = value;}
    public void Stamina(int value) {stamina = value;}
    
    public void Charisma(int value) {charisma = value;}
    public void Manip(int value) {manipulation = value;}
    public void Appear(int value) {appearance = value;}
    
    public void Percept(int value) {perception = value;}
    public void Intel(int value) {intelligence = value;}
    public void Wits(int value) {wits = value;}
    
    public void Alert(int value) {alertness = value;}
    public void Athletic(int value) {athletics = value;}
    public void Brawl(int value) {brawl = value;}
    public void Dodge(int value) {dodge = value;}
    public void Empathy(int value) {empathy = value;}
    public void Express(int value) {expression = value;}
    public void Intimidate(int value) {intimidation = value;}
    public void Primal(int value) {primalUrge = value;}
    public void StreeWise(int value) {streetwise = value;}
    public void Subterfuge(int value) {subterfuge = value;}
    public void Search(int value) {search = value;}
    
    public void AnimalKen(int value) {animalKen = value;}
    public void Crafts(int value) {crafts = value;}
    public void Drive(int value) {drive = value;}
    public void Etiquette(int value) {etiquette = value;}
    public void Firearms(int value) {firearms = value;}
    public void Leadership(int value) {leadership = value;}
    public void Melee(int value) {melee = value;}
    public void Performance(int value) {performance = value;}
    public void Stealth(int value) {stealth = value;}
    public void Survival(int value) {survival = value;}
    public void Instruction(int value) {instruction = value;}
    public void Mimicry(int value) {mimicry = value;}
    public void Ventril(int value) {ventriloquism = value;}
    public void Archery(int value) {archery = value;}
    public void Gambling(int value) {gambling = value;}
    public void Medication(int value) {meditation = value;}
    public void Traps(int value) {traps = value;}
    public void Swimming(int value) {swimming = value;}
    public void Kailindo(int value) {kailindo = value;}
    public void KlaiveDuel(int value) {klaiveDuel = value;}
    public void Repair(int value) {repair = value;}
    
    public void Comuter(int value) {computer = value;}
    public void Enigmas(int value) {enigmas = value;}
    public void Investigate(int value) {investigation = value;}
    public void Law(int value) {law = value;}
    public void Linguistics(int value) {linguistics = value;}
    public void Medicine(int value) {medicine = value;}
    public void Occult(int value) {occult = value;}
    public void Politics(int value) {politics = value;}
    public void Rituals(int value) {rituals = value;}
    public void Science(int value) {science = value;}
    public void Poisions(int value) {poisons = value;}
    public void Demolitions(int value) {demolitions = value;}
    public void pilot(int value) {pilot = value;}
    public void Cosmology(int value) {cosmology = value;}
    public void AreaKnow(int value) {areaKnow = value;}
    public void Herbalsim(int value) {herbalism = value;}
    public void WyrmLore(int value) {wyrmLore = value;}
    
    public void Allies(int value) {allies = value;}
    public void Ancestors(int value) {ancestors = value;}
    public void Contacts(int value) {contacts = value;}
    public void Fetish(int value) {fetish = value;}
    public void Kinfolk(int value) {kinfolk = value;}
    public void Mentor(int value) {mentor = value;}
    public void Purebreed(int value) {purebreed = value;}
    public void Resources(int value) {resources = value;}
    public void Rites(int value) {rites = value;}
    public void Totem(int value) {totem = value;}
    
    public void LethalDmg(HealthLevel value) {lethal = value;}
    public void AggDmg(HealthLevel value) {aggrevated = value;}
    
    public void PermRage(int value){permRage = value;}
    public void PermGnosis(int value){permGnosis = value;}
    public void PermWillpower(int value){permWillpower = value;}
    
    public void TempRage(int value){tempRage = value;}
    public void TempGnosis(int value){tempGnosis = value;}
    public void TempWillpower(int value){tempWillpower = value;}
    
    public boolean SubtractCost(Gift.Power power, int amount){
        switch(power){
            case RAGE:
                if(tempRage > amount){
                    tempRage =- amount;
                    return true;
                }
                else{return false;}
            case GNOSIS:
                if(tempGnosis > amount){
                    tempGnosis =- amount;
                    return true;
                }
                else{return false;}
            case WILLPOWER:
                if(tempWillpower > amount){
                    tempWillpower =- amount;
                    return true;
                }
                else{return false;}
            default:
                return false;
        }
    }
    public boolean hasGifts(){
        if(giftList.isEmpty()){
            return false;
        }
        else{return true;}
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerStats;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Mike
 */

public abstract class BaseStats implements Serializable{
    private final int BaseAttVal = 1;
    private final int BaseSkillVal = 0;
    private final int BasePower = 0;
    public final String defaultName = "Character";
    //final static String CharDataPath = "\\Character Data\\"; // move out of class
    //public static ArrayList<String> NameList;
    
    // <editor-fold defaultstate="collapsed" desc="Enums">
    /*public enum Race{
        WOLF, FOX
    }*/
    
    public enum HealthLevel {
        NODAMAGE, BRUISED, HURT, INJURED, WOUNDED, MAULED, CRIPPLED, 
        INCAPACITATED, DEAD
    }
//    public enum name{
//        PLAYER, CHARACTER
//    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Nested Classes">
    protected class Ability{
        private String name = null;
        private int value = 0;
        
        public Ability(String name){
            this.name = name;
        }
        
        public Ability(String name, int value){
            this.name = name;
            this.value = value;
        }
        
        public String getName(){return name;}
        public int getValue(){return value;}
        
        public void setName(String name){this.name = name;}
        public void setValue(int value){this.value = value;}
    }
    
    protected class Background extends Ability{
        private String desc = null;
        
        public Background(String name){
            super(name);
        }
        
        public Background(String name, int value){
            super(name, value);
        }
        
        public Background(String name, String desc){
            super(name);
            this.desc = desc;
        }
        
        public Background(String name, int value, String desc){
            super(name, value);
            this.desc = desc;
        }
        
        public String getDesc(){return desc;}
        public void setDesc(String desc){this.desc = desc;}
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Variables">
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
    // Adjusted Stats
    protected int adjStr = strength;
    protected int adjDex = dexterity;
    protected int adjStam = stamina;
    
    protected int adjChrsma = charisma;
    protected int adjManip = manipulation;
    protected int adjAppear = appearance;
    
    protected int adjPerc = perception;
    protected int adjInt = intelligence;
    protected int adjWits = wits;
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
    // extra talents
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
    // extra skills
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
    // extra knowledges
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
    private ArrayList<Gift> giftList = new ArrayList<>();
    // List of weapons
    private ArrayList<Weapon> weaponList = new ArrayList<>();
    // List of added abilities
    private ArrayList<Ability> abilityList = new ArrayList<>();
    // List of added Backgrounds
    private ArrayList<Background> backgroundList = new ArrayList<>();
    
    protected int permRage = BasePower;
    protected int permGnosis = BasePower;
    protected int permWillpower = BasePower;
    
    protected int tempRage = BasePower;
    protected int tempGnosis = BasePower;
    protected int tempWillpower = BasePower;
    
    //protected Race race = null;
    //</editor-fold>
    
    // Constructors
    public BaseStats(){
        playerName = null;
        characterName = defaultName;
    }
    
    public BaseStats(String playerName, String characterName) {
        this.playerName = playerName;
        this.characterName = characterName;
    }
    
    public String getPName(){return playerName;}
    public String getCName(){return characterName;}

    public int getStrength() {return strength;}
    public int getDexterity() {return dexterity;}
    public int getStamina() {return stamina;}
    
    public int getCharisma() {return charisma;}
    public int getManip() {return manipulation;}
    public int getAppear() {return appearance;}
    
    public int getPercept() {return perception;}
    public int getIntel() {return intelligence;}
    public int getWits() {return wits;}
    
    public int getAdjStr(){return adjStr;}
    public int getAdjDex(){return adjDex;}
    public int getAdjStam(){return adjStam;}
    
    public int getAdjChrsma(){return adjChrsma;}
    public int getAdjManip(){return adjManip;}
    public int getAdjAppear(){return adjAppear;}
    
    public int getAdjPerc(){return adjPerc;}
    public int getAdjInt(){return adjInt;}
    public int getAdjWits(){return adjWits;}
    
    public int getAlert() {return alertness;}
    public int getAthletic() {return athletics;}
    public int getBrawl() {return brawl;}
    public int getDodge() {return dodge;}
    public int getEmpathy() {return empathy;}
    public int getExpress() {return expression;}
    public int getIntimidate() {return intimidation;}
    public int getPrimal() {return primalUrge;}
    public int getStreetWise() {return streetwise;}
    public int getSubterfuge() {return subterfuge;}
    public int getSearch() {return search;}
    
    public int getAnimalKen() {return animalKen;}
    public int getCrafts() {return crafts;}
    public int getDrive() {return drive;}
    public int getEtiquette() {return etiquette;}
    public int getFirearms() {return firearms;}
    public int getLeadership() {return leadership;}
    public int getMelee() {return melee;}
    public int getPerformance() {return performance;}
    public int getStealth() {return stealth;}
    public int getSurvival() {return survival;}
    public int getInstruction() {return instruction;}
    public int getMimicry() {return mimicry;}
    public int getVentril() {return ventriloquism;}
    public int getArchery() {return archery;}
    public int getGambling() {return gambling;}
    public int getMeditation() {return meditation;}
    public int getTraps() {return traps;}
    public int getSwimming() {return swimming;}
    public int getKailindo() {return kailindo;}
    public int getKlaiveDuel() {return klaiveDuel;}
    public int getRepair() {return repair;}
    
    public int getComputer() {return computer;}
    public int getEnigmas() {return enigmas;}
    public int getInvestigate() {return investigation;}
    public int getLaw() {return law;}
    public int getLinguistics() {return linguistics;}
    public int getMedicine() {return medicine;}
    public int getOccult() {return occult;}
    public int getPolitics() {return politics;}
    public int getRituals() {return rituals;}
    public int getScience() {return science;}
    public int getPoisions() {return poisons;}
    public int getDemolitions() {return demolitions;}
    public int getpilot() {return pilot;}
    public int getCosmology() {return cosmology;}
    public int getAreaKnow() {return areaKnow;}
    public int getHerbalsim() {return herbalism;}
    public int getWyrmLore() {return wyrmLore;}
    
    public int getAllies() {return allies;}
    public int getAncestors() {return ancestors;}
    public int getContacts() {return contacts;}
    public int getFetish() {return fetish;}
    public int getKinfolk() {return kinfolk;}
    public int getMentor() {return mentor;}
    public int getPurebreed() {return purebreed;}
    public int getResources() {return resources;}
    public int getRites() {return rites;}
    public int getTotem() {return totem;}
    
    public HealthLevel getLethalDmg() {return lethal;}
    public HealthLevel getAggDmg() {return aggrevated;}
    
    public int getPermRage(){return permRage;}
    public int getPermGnosis(){return permGnosis;}
    public int getPermWillpower(){return permWillpower;}
    
    public int getTempRage(){return tempRage;}
    public int getTempGnosis(){return tempGnosis;}
    public int getTempWillpower(){return tempWillpower;}
    //public Race getRace(){return race;}
    
    public void setPName(String Name){playerName = Name;}
    public void setCName(String Name){characterName = Name;}

    public void setStrength(int value) {strength = value;}
    public void setDexterity(int value) {dexterity = value;}
    public void setStamina(int value) {stamina = value;}
    
    public void setCharisma(int value) {charisma = value;}
    public void setManip(int value) {manipulation = value;}
    public void setAppear(int value) {appearance = value;}
    
    public void setPercept(int value) {perception = value;}
    public void setIntel(int value) {intelligence = value;}
    public void setWits(int value) {wits = value;}
    
    public void setAdjStr(int value){adjStr = value;}
    public void setAdjDex(int value){adjDex = value;}
    public void setAdjStam(int value){adjStam = value;}
    
    public void setAdjChrsma(int value){adjChrsma = value;}
    public void setAdjManip(int value){adjManip = value;}
    public void setAdjAppear(int value){adjAppear = value;}
    
    public void setAdjPerc(int value){adjPerc = value;}
    public void setAdjInt(int value){adjInt = value;}
    public void setAdjWits(int value){adjWits = value;}
    
    public void setAlert(int value) {alertness = value;}
    public void setAthletic(int value) {athletics = value;}
    public void setBrawl(int value) {brawl = value;}
    public void setDodge(int value) {dodge = value;}
    public void setEmpathy(int value) {empathy = value;}
    public void setExpress(int value) {expression = value;}
    public void setIntimidate(int value) {intimidation = value;}
    public void setPrimal(int value) {primalUrge = value;}
    public void setStreetWise(int value) {streetwise = value;}
    public void setSubterfuge(int value) {subterfuge = value;}
    public void setSearch(int value) {search = value;}
    
    public void setAnimalKen(int value) {animalKen = value;}
    public void setCrafts(int value) {crafts = value;}
    public void setDrive(int value) {drive = value;}
    public void setEtiquette(int value) {etiquette = value;}
    public void setFirearms(int value) {firearms = value;}
    public void setLeadership(int value) {leadership = value;}
    public void setMelee(int value) {melee = value;}
    public void setPerformance(int value) {performance = value;}
    public void setStealth(int value) {stealth = value;}
    public void setSurvival(int value) {survival = value;}
    public void setInstruction(int value) {instruction = value;}
    public void setMimicry(int value) {mimicry = value;}
    public void setVentril(int value) {ventriloquism = value;}
    public void setArchery(int value) {archery = value;}
    public void setGambling(int value) {gambling = value;}
    public void setMeditation(int value) {meditation = value;}
    public void setTraps(int value) {traps = value;}
    public void setSwimming(int value) {swimming = value;}
    public void setKailindo(int value) {kailindo = value;}
    public void setKlaiveDuel(int value) {klaiveDuel = value;}
    public void setRepair(int value) {repair = value;}
    
    public void setComputer(int value) {computer = value;}
    public void setEnigmas(int value) {enigmas = value;}
    public void setInvestigate(int value) {investigation = value;}
    public void setLaw(int value) {law = value;}
    public void setLinguistics(int value) {linguistics = value;}
    public void setMedicine(int value) {medicine = value;}
    public void setOccult(int value) {occult = value;}
    public void setPolitics(int value) {politics = value;}
    public void setRituals(int value) {rituals = value;}
    public void setScience(int value) {science = value;}
    public void setPoisions(int value) {poisons = value;}
    public void setDemolitions(int value) {demolitions = value;}
    public void setpilot(int value) {pilot = value;}
    public void setCosmology(int value) {cosmology = value;}
    public void setAreaKnow(int value) {areaKnow = value;}
    public void setHerbalsim(int value) {herbalism = value;}
    public void setWyrmLore(int value) {wyrmLore = value;}
    
    public void setAllies(int value) {allies = value;}
    public void setAncestors(int value) {ancestors = value;}
    public void setContacts(int value) {contacts = value;}
    public void setFetish(int value) {fetish = value;}
    public void setKinfolk(int value) {kinfolk = value;}
    public void setMentor(int value) {mentor = value;}
    public void setPurebreed(int value) {purebreed = value;}
    public void setResources(int value) {resources = value;}
    public void setRites(int value) {rites = value;}
    public void setTotem(int value) {totem = value;}
    
    public void setLethalDmg(HealthLevel value) {lethal = value;}
    public void setAggDmg(HealthLevel value) {aggrevated = value;}
    
    public void setPermRage(int value){permRage = value;}
    public void setPermGnosis(int value){permGnosis = value;}
    public void setPermWillpower(int value){permWillpower = value;}
    
    public void setTempRage(int value){tempRage = value;}
    public void setTempGnosis(int value){tempGnosis = value;}
    public void setTempWillpower(int value){tempWillpower = value;}
    
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
    // <editor-fold defaultstate="collapsed" desc="Gift functions">
    public boolean hasGifts(){
        if(giftList.isEmpty()){
            return false;
        }
        else{return true;}
    }
    
    public Gift getGift(String giftName){
        for(Gift gift : giftList){
            if(gift.getName().equals(giftName)){
                return gift;
            }
        }
        return null;
    }
    
    public boolean addGift(Gift gift){
        for(Gift gft : giftList){
            if(gft.equals(gift)){
                return false;
            }
        }
        return giftList.add(gift);
    }
    
    public boolean removeGift(Gift gift){
        for(Gift gft : giftList){
            if(gft.equals(gift)){
                return giftList.remove(gift);
            }
        }
        return false;
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Weapon functions">
    public boolean hasWeapon(){
        if(weaponList.isEmpty()){
            return false;
        }
        else{return true;}
    }
    
    public Weapon getWeapon(String wpnName){
        for(Weapon wpn : weaponList){
            if(wpn.getName().equals(wpnName)){
                return wpn;
            }
        }
        return null;
    }
    
    public boolean addWeapon(Weapon wpn){
        for(Weapon weap : weaponList){
            if(weap.equals(wpn)){
                return false;
            }
        }
        return weaponList.add(wpn);
    }
    
    public boolean removeWeapon(Weapon wpn){
        for(Weapon weap : weaponList){
            if(weap.equals(wpn)){
                return weaponList.remove(wpn);
            }
        }
        return false;
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Ability functions">
    public boolean hasAbility(){
        if(abilityList.isEmpty()){
            return false;
        }
        else{return true;}
    }
    
    public Ability getAbility(String abilityName){
        for(Ability ability : abilityList){
            if(ability.getName().equals(abilityName)){
                return ability;
            }
        }
        return null;
    }
    
    public boolean addAbility(Ability ability){
        for(Ability ablty : abilityList){
            if(ablty.equals(ability)){
                return false;
            }
        }
        return abilityList.add(ability);
    }
    
    public boolean removeAbility(Ability ability){
        for(Ability ablty : abilityList){
            if(ablty.equals(ability)){
                return abilityList.remove(ablty);
            }
        }
        return false;
    }
    //</editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Background functions">
    public boolean hasBackground(){
        if(backgroundList.isEmpty()){
            return false;
        }
        else{return true;}
    }
    
    public Background getBackground(String backgName){
        for(Background backg : backgroundList){
            if(backg.getName().equals(backgName)){
                return backg;
            }
        }
        return null;
    }
    
    public boolean addBackground(Background backg){
        for(Background bckg : backgroundList){
            if(bckg.equals(backg)){
                return false;
            }
        }
        return backgroundList.add(backg);
    }
    
    public boolean removeBackground(Background backg){
        for(Background bckg : backgroundList){
            if(bckg.equals(backg)){
                return backgroundList.add(backg);
            }
        }
        return false;
    }
    //</editor-fold>
    
    public void SaveStats(String dir)throws IOException{
        String fileName = characterName + ".dat";
        File outFile = new File(dir + "\\" + fileName);
        FileOutputStream fos = new FileOutputStream(outFile);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
            //GetNameList();
        }
    }
    
    public static BaseStats LoadStats(String fileName, String dir)
            throws IOException, ClassNotFoundException, FileNotFoundException{
        //String fName = fileName + ".dat";
        File inFile = new File(dir + "\\" + fileName);
        FileInputStream fin = new FileInputStream(inFile);
        BaseStats loadedStats;
        try (ObjectInputStream ois = new ObjectInputStream(fin)) {
            loadedStats = (BaseStats) ois.readObject();
        }
        return loadedStats;
    }
    
    /*public static void GetNameList(){
        NameList = new ArrayList<>();
        String workingDir = System.getProperty("user.dir");
        Path dir = Paths.get(workingDir);// + CharDataPath);
        String fName;
        if(Files.exists(dir)){
            File CharFiles = dir.toFile();
            File[] listOfFiles = CharFiles.listFiles();
            for(File file : listOfFiles){
                fName = file.toString();
                if(fName.endsWith(".dat")){
                    fName = fName.replace(".dat", "");
                    fName = fName.substring(dir.toString().length() + 1);
                    NameList.add(fName);
                }
            }
        }
    }*/
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerStats;
import java.io.Serializable;

/**
 *
 * @author Mike
 */
public class Weapon implements Serializable{
    final int defVal = 6;
    
    public enum ConcealT{
        POCKET, JACKET, TRENCHCOAT, CANNOT
    }
    public enum WeaponT{
        MELEE, FIREARM
    }
    
    private class Firearm implements Serializable{
        private boolean scope;
        private int range;
        private int rate;
        private int clipSize;
        
        public Firearm(){
            scope = false;
            range = 0;
            rate = 0;
            clipSize = 0;
        }
        public Firearm(boolean scope, int range, int rate, int clipSize){
            this.scope = scope;
            this.range = range;
            this.rate = rate;
            this.clipSize = clipSize;
        }
        public boolean hasScope(){return scope;}
        public int Range(){return range;}
        public int Rate(){return rate;}
        public int ClipSize(){return clipSize;}
        
        public void Scope(boolean scope){this.scope = scope;}
        public void Range(int range){this.range = range;}
        public void Rate(int rate){this.rate = rate;}
        public void ClipSize(int clipSize){this.clipSize = clipSize;}
    }
    private String name;
    private int difficulty;
    private int damage;
    private ConcealT conceal;
    private WeaponT wType;
    private Firearm gun;
    /**
     * Default constructor
     */
    public Weapon(){
        name = "Weapon";
        difficulty = defVal;
        damage = defVal;
        conceal = ConcealT.POCKET;
        wType = WeaponT.MELEE;
        gun = null;
    }
    /**
     * Use for initializing a melee weapon
     * 
     * @param name - name of weapon
     * @param difficulty - difficulty of roll to use weapon
     * @param damage - damage weapon deals
     * @param conceal - how and if weapon can be concealed
     * @param wType - the type of weapon. Will be MELEE or FIREARM
     */
    public Weapon(String name,
                  int difficulty,
                  int damage,
                  ConcealT conceal,
                  WeaponT wType){
        this.name = name;
        this.difficulty = difficulty;
        this.damage = damage;
        this.conceal = conceal;
        this.wType = wType;
        gun = null;
    }
    /**
     * Use for initializing a firearm
     * 
     * @param name - name of weapon
     * @param difficulty - difficulty of roll to use weapon
     * @param damage - damage weapon deals
     * @param conceal - how and if weapon can be concealed
     * @param wType - the type of weapon. Will be MELEE or FIREARM
     * @param scope - true if weapon has a scope
     * @param range - range the shot can hit before increasing difficulty
     * @param rate - how fast the gun can fire
     * @param clipSize - number of bullets in the clip
     */
    public Weapon(String name,
                  int difficulty,
                  int damage,
                  ConcealT conceal,
                  WeaponT wType,
                  boolean scope,
                  int range,
                  int rate,
                  int clipSize){
        this.name = name;
        this.difficulty = difficulty;
        this.damage = damage;
        this.conceal = conceal;
        this.wType = wType;
        this.gun = new Firearm(scope, range, rate, clipSize);
    }
    
    public boolean isFirearm(){
        if(wType == WeaponT.FIREARM){
            return true;
        }
        else{return false;}
    }
    
    public String getName(){return name;}
    public int getDiff(){return difficulty;}
    public int getDamage(){return damage;}
    public ConcealT getCnclT(){return conceal;}
    public WeaponT getWpnT(){return wType;}
    public boolean hasScope(){
        //try{
            if(this.isFirearm() && (this.gun != null)){
                if(this.gun.hasScope()){
                    return true;
                }
                else{return false;}
            }
            else{return false;}
        //}
        /*catch (NullPointerException e){
            System.err.println("Null pointer exception: " 
                               + e.getMessage()
                               + "\ngun set to null");
            return false;
        }*/
    }
    public int getRange(){
        if(this.isFirearm() && (this.gun != null)){
            return gun.range;
        }
        else{return 0;}
    }
    public int getRate(){
        if(this.isFirearm() && (this.gun != null)){
            return gun.rate;
        }
        else{return 0;}
    }
    public int getClipSize(){
        if(this.isFirearm() && (this.gun != null)){
            return gun.clipSize;
        }
        else{return 0;}
    }
    
    public void setName(String name){this.name = name;}
    public void setDiff(int difficulty){this.difficulty = difficulty;}
    public void setDamage(int damage){this.damage = damage;}
    public void setCnclT(ConcealT conceal){this.conceal = conceal;}
    public void setScope(boolean scope){gun.scope = scope;}
    public void setRange(int range){gun.range = range;}
    public void setRate(int rate){gun.rate = rate;}
    public void setClipSize(int clipSize){gun.clipSize = clipSize;}
    public void setWpnT(WeaponT type){
        if(type == WeaponT.MELEE){
            gun = null;
        }
        else{
            gun = new Firearm();
        }
        wType = type;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import PlayerStats.*;
import PlayerStats.BaseStats.name;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Mike
 */
public class GiftTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws IOException, ClassNotFoundException {
        /*Gift.Cost tCost = new Gift.Cost(Gift.Power.GNOSIS,1,false);
        Gift.AttributeRoll tAttr 
                = new Gift.AttributeRoll(Gift.Attribute.DEXTERITY,
                                         Gift.Talent.BRAWL,
                                         6);
        Gift.PowerRoll tPwrRoll = new Gift.PowerRoll(Gift.Power.WILLPOWER, 6);
        Gift.Effect tEffect = new Gift.Effect("test Effec",
                                                2,
                                                Gift.BoostType.ABILITY);
        */
        
        final String CharDataPath = "\\Character Data\\";
        Gift gift1 = new Gift("test gift",
                              "A test gift",
                              Gift.Power.GNOSIS,
                              1,
                              false,
                              Gift.Attribute.DEXTERITY,
                              Gift.Talent.BRAWL,
                              6,
                              Gift.Power.WILLPOWER,
                              6,
                              "test Effec",
                              2,
                              Gift.BoostType.ABILITY);
        
        Gift gift2 = new Gift();
        
        gift2.copyGift(gift1);
        
        //tPwrRoll.setDiffic(10);
        //gift2.setPwrRoll(tPwrRoll);
        gift2.setPwrRollDiff(10);
        gift2.setEffectBstT(Gift.BoostType.ATTRIBUTE);
        
        System.out.format("Gift1: " + gift1.getName() + ","
                            + gift1.getDescription() + ","
                            + gift1.getCostPwr().name() + ","
                            + gift1.getAttRollAttr().name() + ","
                            + "%d,"
                            + gift1.getEffectBstT() + "\n",
                            gift1.getPwrRollDiff());
        
        System.out.format("Gift2: " + gift2.getName() + ","
                            + gift2.getDescription() + ","
                            + gift2.getCostPwr() + ","
                            + gift2.getAttRollAttr() + ","
                            + "%d,"
                            + gift2.getEffectBstT() + "\n",
                            gift2.getPwrRollDiff());
        
        Weapon tWeapon = new Weapon("Sword",
                                    6,
                                    3,
                                    Weapon.ConcealT.JACKET,
                                    Weapon.WeaponT.MELEE);
        
        System.out.format("Weapon1: " 
                          + tWeapon.getName() + ","
                          + tWeapon.getDiff() + ","
                          + tWeapon.getDamage() + ","
                          + tWeapon.getCnclT() + ","
                          + tWeapon.getWpnT() + "\n");
        tWeapon.setWpnT(Weapon.WeaponT.FIREARM);
        tWeapon.setCnclT(Weapon.ConcealT.POCKET);
        tWeapon.setName("Pistol");
        tWeapon.setDamage(6);
        tWeapon.setRange(20);
        tWeapon.setRate(4);
        tWeapon.setClipSize(8);
        tWeapon.setScope(true);
        System.out.format("Weapon2: " 
                          + tWeapon.getName() + ","
                          + tWeapon.getDiff() + ","
                          + tWeapon.getDamage() + ","
                          + tWeapon.getCnclT() + ","
                          + tWeapon.getWpnT() + ","
                          + tWeapon.getRate() + "," 
                          + tWeapon.getRange() + ","
                          + tWeapon.getClipSize() + "\n");
        if(tWeapon.hasScope()){
            System.out.println("Has a scope");
        }
        
        WerewolfStats tStats = new WerewolfStats("Mike", "Xidel");
        
        if(tStats.addGift(gift2)){
            System.out.println("Gift Added");
        }
        if(tStats.addWeapon(tWeapon)){
            System.out.println("Weapon Added");
        }
        Gift tempGift;
        tempGift = tStats.getGift("test gift");
        System.out.println(tempGift.getDescription());
        
        String workingDir = System.getProperty("user.dir");
        Path dir = Paths.get(workingDir + CharDataPath);
        if(Files.notExists(dir)){
            Files.createDirectory(dir);
        }
        
        tStats.SaveStats(dir.toString());
        WerewolfStats tStats2 = WerewolfStats.LoadStats("Xidel", dir.toString());
        WerewolfStats tStats3 = new WerewolfStats("Mike", name.CHARACTER);
        tStats3.SaveStats(dir.toString());
        
        System.out.format(tStats2.getPName() + ","
                          + tStats2.getGift("test gift").getAttRollTal() + ","
                          + tStats2.getWeapon("Pistol").getCnclT() +"\n");
        
        WerewolfStats.GetNameList();
    }
}

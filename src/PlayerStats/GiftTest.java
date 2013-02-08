/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayerStats;

/**
 *
 * @author Mike
 */
public class GiftTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
    }
}

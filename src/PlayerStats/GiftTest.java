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
        Gift.Cost tCost = new Gift.Cost(Gift.Power.GNOSIS,1,false);
        Gift.AttributeRoll tAttr 
                = new Gift.AttributeRoll(Gift.Attribute.DEXTERITY,
                                         Gift.Talent.BRAWL,
                                         6);
        Gift.PowerRoll tPwrRoll = new Gift.PowerRoll(Gift.Power.WILLPOWER, 6);
        
        Gift gift1 = new Gift("test gift",
                              "A test gift",
                              tCost,
                              tAttr,
                              tPwrRoll);
        
        Gift gift2 = new Gift();
        
        gift2.copyGift(gift1);
        
        tPwrRoll.setDiffic(10);
        gift2.setPwrRoll(tPwrRoll);
        
        System.out.format("Gift1: " + gift1.getName() + ","
                            + gift1.getDescription() + ","
                            + gift1.getCost().getPower().name() + ","
                            + gift1.getAttrRoll().getAttr().name() + ","
                            + "%d\n", gift1.getPwrRoll().getDiffic());
        
        System.out.format("Gift2: " + gift2.getName() + ","
                            + gift2.getDescription() + ","
                            + gift2.getCost().getPower().name() + ","
                            + gift2.getAttrRoll().getAttr().name() + ","
                            + "%d\n", gift2.getPwrRoll().getDiffic());
    }
}

package server.champions;

import java.util.ArrayList;

/**
 * Created by Michal Szarek
 **/
public class ComplexChampion extends SimpleChampion {
    private String resourceType;
    private String hp;
    private String hpPerLevel;
    private String mp;
    private String mpPerLevel;
    private String armor;
    private String armorPerLevel;
    private String magicRes;
    private String magicResPerLevel;
    private String attackDamage;
    private String attackDamagePerLevel;
    private String attackSpeed;
    private String attackSpeedPerLevel;
    private String movementSpeed;

    @Override
    public String toString() {
        return "{" +
                "\"name\":" + "\""+ name + "\"," +
                "\"resourceType\":" + "\"" + resourceType + "\"," +
                "\"imgSuffix\":" + "\"" + imgSuffix + "\"," +
                "\"hp\":" + "\""+ hp + "\"," +
                "\"hpPerLevel\":" + "\"" + hpPerLevel + "\"," +
                "\"mp\":" + "\"" + mp + "\"," +
                "\"mpPerLevel\":" + "\"" + mpPerLevel + "\"," +
                "\"armor\":" + "\"" + armor + "\"," +
                "\"armorPerLevel\":" + "\"" + armorPerLevel + "\"," +
                "\"magicRes\":" + "\"" + magicRes + "\"," +
                "\"magicResPerLevel\":" + "\"" + magicResPerLevel + "\"," +
                "\"attackDamage\":" + "\"" + attackDamage + "\"," +
                "\"attackDamagePerLevel\":" + "\"" + attackDamagePerLevel + "\"," +
                "\"attackSpeed\":" + "\"" + attackSpeed + "\"," +
                "\"attackSpeedPerLevel\":" + "\"" + attackSpeedPerLevel + "\"," +
                "\"movementSpeed\":" + "\"" + movementSpeed + "\"" +
                '}';
    }

    public ComplexChampion(ArrayList<String> championDetails) {
        this.name = championDetails.get(0);
        this.resourceType = championDetails.get(1);
        this.imgSuffix = championDetails.get(2);
        this.hp = championDetails.get(3);
        this.hpPerLevel = championDetails.get(4);
        this.mp = championDetails.get(5);
        this.mpPerLevel = championDetails.get(6);
        this.armor = championDetails.get(7);
        this.armorPerLevel = championDetails.get(8);
        this.magicRes = championDetails.get(9);
        this.magicResPerLevel = championDetails.get(10);
        this.attackDamage = championDetails.get(11);
        this.attackDamagePerLevel = championDetails.get(12);
        this.attackSpeed = championDetails.get(13);
        this.attackSpeedPerLevel = championDetails.get(14);
        this.movementSpeed = championDetails.get(15);
    }
}

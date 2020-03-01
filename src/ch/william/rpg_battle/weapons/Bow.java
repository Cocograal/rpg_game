package ch.william.rpg_battle.weapons;

public class Bow extends Weapon {
    String weaponName;

    public Bow() {
        this.weaponName = "Bow";
        price = 500;
        attack = 30;
        defense = 10;
        accuracy = 20;
    }
    @Override
    protected void weaponFeature() {


    }
}

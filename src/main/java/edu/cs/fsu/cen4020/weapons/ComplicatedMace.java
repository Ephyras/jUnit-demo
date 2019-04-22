package edu.cs.fsu.cen4020.weapons;

/**
 * Created by Javier on 3/29/2017.
 */
public class ComplicatedMace {

    private final int DAMAGE;

    public ComplicatedMace(int damage) {
        this.DAMAGE = damage;
    }

    /**
     * Damages the opponent. The resulting damage is computed according to the following rules:
     * 1) If armor is less or equals than 10, the mace ignores the armor
     * 2) If armor is greater than 10 but less than 50, damage is decreased by the same amount of armor
     * 3) If armor is greater or equals than 50 but less than 100, damage is decreased by the amount of armor multiplied by 2
     * 4) If armor is greater or equals than 100, damage is decreased by the amount of armor multiplied by 3
     *
     * @param armor Number of armor points of the opponent
     * @return The amount of damage done by the mace
     * @throws IllegalArmorException If armor points are negative
     */
    public double hit(int armor) throws IllegalArmorException {

        double finalDamage;
        if (armor <= 10) {
            finalDamage = DAMAGE;
        } else if (armor > 10 && armor < 50) {
            finalDamage = DAMAGE - armor;
        } else if (armor >= 50 && armor < 100) {
            finalDamage = DAMAGE - (armor * 2);
        } else {
            finalDamage = DAMAGE - (armor * 3);
        }
        return finalDamage;
    }

}

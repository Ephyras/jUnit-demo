package edu.cs.fsu.cen4020.weapons;

import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Created by Javier on 3/29/2017.
 */
public class MillennialScimitar {

    private final int DAMAGE;
    private final Twitter TWITTER;

    public MillennialScimitar(int DAMAGE) {
        this.DAMAGE = DAMAGE;
        this.TWITTER = null;
    }

    public MillennialScimitar(int damage, Twitter twitter) {
        this.DAMAGE = damage;
        this.TWITTER = twitter;
    }

    /**
     * Damages the opponent. The resulting damage is computed according to the following rules:
     * 1) If armor is less or equals than 10, the mace ignores the armor
     * 2) If armor is greater than 10 damage is decreased by the same amount of armor
     *
     * @param armor     Number of armor points of the opponent
     * @param withTweet If the weapon should send a tweet
     * @return The amount of damage done by the mace
     * @throws IllegalArmorException If armor points are negative
     * @throws TwitterException      If something wrong happended with twitting
     * @throws IllegalStateException If it wants to tweet but tweeter client was not provided
     */
    public double hit(int armor, boolean withTweet) throws IllegalArmorException, TwitterException, IllegalStateException {

        if (withTweet && TWITTER == null) {
            throw new IllegalStateException("Twitter client was not configured");
        }

        double finalDamage;
        if (armor <= 10) {
            finalDamage = DAMAGE;
        } else {
            finalDamage = DAMAGE - armor;
        }

        if (withTweet) {
            TWITTER.updateStatus("JUnit demo "+ finalDamage + " (ignore me)" );
        }

        return finalDamage;
    }


}

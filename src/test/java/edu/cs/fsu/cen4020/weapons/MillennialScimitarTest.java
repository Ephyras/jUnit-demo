package edu.cs.fsu.cen4020.weapons;

import org.junit.Test;
import org.mockito.Mockito;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import static org.junit.Assert.*;

/**
 * Created by Javier on 3/29/2017.
 */
public class MillennialScimitarTest {

    @Test
    public void hitCondition1() throws Exception {
        MillennialScimitar scimitar = new MillennialScimitar(1000);
        int armor = 10;
        double expectedDamage = 1000;
        try {
            assertEquals(scimitar.hit(armor, false), expectedDamage, 0.0);
        } catch (IllegalArmorException ex) {
            fail("Exception was thrown " + ex.getMessage());
        }
    }

    @Test
    public void hitCondition2() throws Exception {
        MillennialScimitar scimitar = new MillennialScimitar(1000);
        int armor = 40;
        double expectedDamage = 960;
        try {
            assertEquals(scimitar.hit(armor, false), expectedDamage, 0.0);
        } catch (IllegalArmorException ex) {
            fail("Exception was thrown " + ex.getMessage());
        }
    }

    @Test
    public void hitCondition1AndTweet() throws Exception {

        MillennialScimitar scimitar = new MillennialScimitar(1000, getTwitterClient());
        int armor = 10;
        double expectedDamage = 1000;
        try {
            assertEquals(scimitar.hit(armor, true), expectedDamage, 0.0);
        } catch (IllegalArmorException ex) {
            fail("Exception was thrown " + ex.getMessage());
        }
    }


    @Test
    public void hitCondition1AndTweetMocked() throws Exception {
        Twitter mock = Mockito.mock(Twitter.class);
        MillennialScimitar scimitar = new MillennialScimitar(1000, mock);
        int armor = 10;
        double expectedDamage = 1000;
        try {
            assertEquals(scimitar.hit(armor, true), expectedDamage, 0.0);
            Mockito.verify(mock).updateStatus("JUnit demo " + expectedDamage+" (ignore me)");
        } catch (IllegalArmorException ex) {
            fail("Exception was thrown " + ex.getMessage());
        }
    }

    private Twitter getTwitterClient() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("KEY")
                .setOAuthConsumerSecret("SECRET")
                .setOAuthAccessToken("TOKEN")
                .setOAuthAccessTokenSecret("TOKEN-SECRET");
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }


}
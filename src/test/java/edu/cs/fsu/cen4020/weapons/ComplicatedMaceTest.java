package edu.cs.fsu.cen4020.weapons;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Javier on 3/29/2017.
 */
public class ComplicatedMaceTest {

    @Test
    public void hitCondition1() throws Exception {
        ComplicatedMace mace = new ComplicatedMace(1000);
        int armor = 10;
        double expectedDamage = 1000;
        try {
            assertEquals(mace.hit(armor), expectedDamage, 0.0);
        } catch (IllegalArmorException ex) {
            fail("Exception was thrown " + ex.getMessage());
        }
    }

    @Test
    public void hitCondition2() throws Exception {
        ComplicatedMace mace = new ComplicatedMace(1000);
        int armor = 40;
        double expectedDamage = 960;
        try {
            assertEquals(mace.hit(armor), expectedDamage, 0.0);
        } catch (IllegalArmorException ex) {
            fail("Exception was thrown " + ex.getMessage());
        }
    }

    @Test
    public void hitCondition3() throws Exception {
        ComplicatedMace mace = new ComplicatedMace(1000);
        int armor = 50;
        double expectedDamage = 900;
        try {
            assertEquals(mace.hit(armor), expectedDamage, 0.0);
        } catch (IllegalArmorException ex) {
            fail("Exception was thrown " + ex.getMessage());
        }
    }

    @Test
    public void hitCondition4() throws Exception {
        ComplicatedMace mace = new ComplicatedMace(1000);
        int armor = 100;
        double expectedDamage = 700;
        try {
            assertEquals(mace.hit(armor), expectedDamage, 0.0);
        } catch (IllegalArmorException ex) {
            fail("Exception was thrown " + ex.getMessage());
        }
    }

    @Test
    public void hitWithException() throws Exception {
        ComplicatedMace mace = new ComplicatedMace(1000);
        int armor = -1;
        double expectedDamage = 1000;
        try {
            assertEquals(mace.hit(armor), expectedDamage, 0.0);
            fail("Exception was not thrown");
        } catch (IllegalArmorException ex) {
            //Everything was OK
        }
    }
}
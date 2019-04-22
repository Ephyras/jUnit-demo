package edu.cs.fsu.cen4020.weapons;

/**
 * Created by Javier on 3/29/2017.
 */
public class IllegalArmorException extends Exception{

    public IllegalArmorException() {
        super("Armor value is illegal!!");
    }
}

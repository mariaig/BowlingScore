/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowlingscore;

/**
 *
 * @author Maria
 */
public class InvalidNumberOfRolls extends Exception{

    InvalidNumberOfRolls() {
    }

    public static void showMessage() {
        System.err.println("Invalid number of rolls");
    }
}

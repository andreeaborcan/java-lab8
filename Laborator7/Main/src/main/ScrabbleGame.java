/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexandru
 */
public class ScrabbleGame extends Game{
    
    public ScrabbleGame()
    {
        bag = new Bag();
        board = new Board();
        bag.addAZLetters();
        order = new ArrayList<>();
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author alexandru
 */
public class WordBuilder {
    
    
    /*
    private static WordBuilder instance = null;
    
    private WordBuilder()
    {
        
    }
    
    public static WordBuilder getInstance()
    {
        if(instance == null) 
            instance = new WordBuilder();
        return instance;
    }
    */
    
    public String build(ArrayList<Character> list)
    {
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < 10; i++) 
            word.append(list.get(0));
        //word.append('a');
        return word.toString();
    }
    
}

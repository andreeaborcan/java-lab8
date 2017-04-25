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
public class MyWordBuilder extends WordBuilder{
    /*
    private MyWordBuilder()
    {
        
    }*/
    WordDictionary dict;
    
    public String build(ArrayList<Character> list)
    {
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < 10; i++) 
            word.append(list.get(0));
            word.append("alex");
            return word.toString();
    }
    
}

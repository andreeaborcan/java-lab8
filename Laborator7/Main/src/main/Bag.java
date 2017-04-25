package main;


import java.beans.Expression;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexandru
 */
public class Bag {
    private final Queue<Character> letters = new LinkedList<>();
    
    public Bag() { 
        
        System.err.print("Constr!\n");
        //Collections.shuffle((List<?>) letters);
    }
    
    public synchronized void addAZLetters()
    {
        for(char c = 'a'; c<= 'z'; c++)
        {
            letters.add(c);
        }
        Collections.shuffle((List<?>) letters);
    }
    
    public synchronized boolean isEmpty(){
        return letters.isEmpty();
    }
    
    public synchronized int size()
    {
        return letters.size();
    }
    
    public synchronized List<Character> extractLetters(int howMany) 
    {
        List<Character> extracted = new ArrayList<Character>();
        
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) 
                break;
            extracted.add(letters.poll());
        }
        return extracted;
    }
}

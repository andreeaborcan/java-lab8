package main;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class WordDictionary {
    private HashMap<String, Integer> wordList;
    
    public void loadDatabase(String file) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new FileInputStream(file));
        while(sc.hasNext())
        {
            String tmp = sc.next();
            wordList.putIfAbsent(tmp, value(tmp));
        }
    }
        
    
    public static int value(String s)
    {
        int ans = 0;
        for(int i=0;i<s.length();i++)
        {
            ans += (int) s.charAt(i) - 'a';
        }
        return ans;
    }
    
    public WordDictionary()
    {
        wordList = new HashMap<String, Integer>();
    }
    
    public boolean containsWord(String str)
    {
        if(wordList.containsKey(str))
            return true;
        return false;
    }
    
    
        
    
}

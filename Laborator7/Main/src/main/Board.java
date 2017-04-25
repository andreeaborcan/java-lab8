package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexandru
 */
import java.util.*;

public class Board {
    
    private HashMap<Player, ArrayList<String>> playerWords;
    private ArrayList<Player> players;
    
    public Board()
    {
        playerWords = new HashMap<>();
        players = new ArrayList<>();
    }
    
    public synchronized boolean addWord(Player player, String word)
    {
        System.out.println("-->  Jucatorul "+player.toString() + " a adaugat cuvantul: \"" + word + "\"");
        if(players.indexOf(player) == -1)
            players.add(player);
        player.addPointes(WordDictionary.value(word));
        playerWords.putIfAbsent(player, new ArrayList<>());
        playerWords.get(player).add(word);
        
        return true;
    }
    
    
    public synchronized String toString()
    {
        
        StringBuilder sb = new StringBuilder();
        sb.append("\nBoard:\n");
        for(Player i : players)
        {
            sb.append("  - "+i.toString() + ":");
            for(String w : playerWords.get(i))
            {
                sb.append(w + ", ");
            }
            sb.delete(sb.length()-2, sb.length());
            sb.append("  Total pts:");
            sb.append(i.getScore());
            
            sb.append("\n");
        }
        sb.append("end board;\n\n");
        return sb.toString();
    }
    
}

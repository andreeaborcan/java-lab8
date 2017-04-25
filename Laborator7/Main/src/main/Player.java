package main;

/**
 *
 * @author alexandru
 */


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Player implements Runnable{
    private String name;
    private Game game;
    private int score;
    private boolean isWorking;
    private ArrayList<Character> myCharacters;
    WordBuilder wb;
    
    public Player(String n)
    {
        name = n;
        myCharacters = new ArrayList<>();
        wb = new WordBuilder();
    }
    
    public void setWordBuilder(WordBuilder wordBuilder)
    {
        wb = wordBuilder;
    }
    
    public synchronized void addPointes(int add)
    {
        score += add;
    }
    
    public synchronized void resetScore()
    {
        score = 0;
    }
    
    public synchronized int getScore()
    {
        return score;
    }
    
    private synchronized boolean createSubmitWord(WordBuilder wb) throws InterruptedException {
        List<Character> extracted = game.getBag().extractLetters(1);
        if (extracted.isEmpty()) 
            return false;
        /*
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < 10; i++) 
            word.append(extracted.get(0));
        */
        
        String word = wb.build((ArrayList<Character>) extracted);
        
        boolean add = game.getBoard().addWord(this, word);
        //Thread.sleep(300);
                
        return add;
    }

    
    public synchronized void goToWork()
    {
        System.err.println(toString() + " goes to work");
        /*while (isWorking) {
            try 
            {
                wait();
            }
            catch (InterruptedException e) 
            {
                System.err.println("Salut");
                return;
            }
        
        }*/
        isWorking = true;
        notifyAll();
    }
    
    public boolean isWorking()
    {
        return isWorking;
    }
 
    
    @Override
    public synchronized void run() {
      
        while(true)
        {
            while (!isWorking) {
                try { wait(); }
                catch (InterruptedException e) 
                {
                    System.err.println("Salut");
                    return;
                }
            }
            
            //System.err.println(toString() + "Enters work");
            
            boolean ok=false;
            try 
            {
                ok = createSubmitWord(wb);
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            game.addOrder(toString());
            
            
            isWorking = false;
            //notifyAll();
            synchronized(game)
            {
                game.notify();
            }
            if(ok == false)
                break;
        }
        System.out.flush();
    }
    
    @Override
    public synchronized String toString()
    {
        return name;
    }
        
    
    public void setGame(Game g)
    {
        game = g;
    }
}
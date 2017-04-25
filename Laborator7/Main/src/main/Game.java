package main;


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
public class Game {
    protected Bag bag;
    protected Board board;
    protected WordDictionary dictionary;
    protected final List<Player> players = new ArrayList<>();
    protected ArrayList<String> order;
    protected boolean isWorking = false;
    
    public Game()
    {
        bag = new Bag();
        board = new Board();
        bag.addAZLetters();
        order = new ArrayList<>();
    }
    
    public void addPlayer(Player player) 
    {
        players.add(player);
        player.setGame(this);
    }

    public synchronized void setWorking()
    {
        isWorking = true;
    }
    
    public synchronized void finishWorking()
    {
        isWorking = false;
    }
    
    public synchronized void addOrder(String s)
    {
        order.add(s);
    }
        
    public synchronized Board getBoard()
    {
        return board;
    }
    
    public synchronized Bag getBag()
    {
        return bag;
    }
    
    public void start() throws InterruptedException
    {
        for(Player p : players)
        {
            Thread t = new Thread(p);
            t.start();
        }
        synchronized(this)
        {
            while(!getBag().isEmpty())
            {
                Thread.sleep(1000);
               for(Player p : players)
               {
                    p.goToWork();

                    while(p.isWorking())
                    {
                        this.wait();
                    }
                    //notify();
               }
            }
            System.out.print(getBoard().toString());

            for(Player p : players)
            {
                synchronized(p)
                {
                    p.goToWork();
                    p.notify();
                }
            }
        }
    }
    
}
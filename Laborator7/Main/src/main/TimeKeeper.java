/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandru
 */
public class TimeKeeper implements Runnable{
    
    boolean visible;
    int startTime;
    int refreshRate;
    public TimeKeeper() {
        visible = true;
        startTime = (int) System.currentTimeMillis();
        refreshRate = 500;
    }
    
    void printTime()
    {
        int time = (int) (System.currentTimeMillis() - startTime);
        //time /= 1000;
        System.out.print("Time Elapsed: ");
        System.out.print(time);
        System.out.println(" miliseconds");
    }
    
    @Override
    public void run() {
        
        while(true)
        {
            try 
            {
                Thread.sleep(refreshRate);
            } 
            catch (InterruptedException ex)
            {
                Logger.getLogger(TimeKeeper.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(visible)
                printTime();
        }
    }
    
}

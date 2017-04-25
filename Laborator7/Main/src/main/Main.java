/*
 * JAVA   Laborator 7!!!!!
 */
package main;
/**
 *
 * @author alexandru
 */
public class Main {

    /**
     * @param args the command line arguments
     */
     
        public static void main(String args[]) throws InterruptedException {
            
            
        Game game = new Game();
        TimeKeeper tk = new TimeKeeper();
        Thread timeThread = new Thread(tk);
        timeThread.setDaemon(true);
        timeThread.start();
        ScrabbleGame sg = new ScrabbleGame();
        sg.addPlayer(new Player("Andrei"));
        Player alex = new Player("Alex");
        alex.setWordBuilder(new MyWordBuilder());
        game.addPlayer(alex);
        game.addPlayer(new Player("Andreea"));
        game.addPlayer(new Player("Cosmin"));
        game.addPlayer(new Player("Romeo"));
        game.start();


    }

}

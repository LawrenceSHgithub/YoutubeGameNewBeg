package main;
// Main class to implement game. Shall have all the handlers, player, levels , enemies classes. Game Loop
public class Game implements Runnable{
    private Thread gameThread;
    private final int FPS_SET = 120;

    private GameWindow gameWindow; //  <--- Step 2 : Creating an variable object for the gameWindow class, this where the object shall be saved
    private GamePanel gamePanel; // <---  Step 6.0 Creating an variable object for the gamePane; class, this where the object shall be saved

    // We use the Class Game Constructor to create objects of this class in main to start game
    // multi able constructors chained here, Game panel and game window
    public Game() {
        // Step 6.1 : creating object from Game panel class (The Jpanel) in Game constructor - This will be the picture of the game. It will be created when Game Constructor is called from main
        gamePanel = new GamePanel();// 8.3 GamePanel must be initialized to be passed into game window
        // Step 3 : creating object from Game window class (The Jframe) in Game constructor - This will be the picture frame of the game. It will be created when Game Constructor is called from main
        gameWindow = new GameWindow(gamePanel); // Step 8.3 Adding gamePanel variable GameWindow Constructor. This is when we pass the Jpanel into the Jframe
        // Step 11 Inputs are added , but unfocused. This gives the inputs to be focused towards the jpanel
        gamePanel.requestFocus();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

            double timePerFrame = .0/FPS_SET;
            long lastFrame = System.nanoTime();

        while(true){
            if(System.nanoTime() - lastFrame >= timePerFrame){

            }
        }
    }
}




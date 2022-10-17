package main;
//JFrame is the Picture Frame, JPanel is the picture
// Game window is the Frame or JFrame of the picture
import javax.swing.JFrame;

public class GameWindow  {
    private JFrame jFrame;

    // Step 8 We need to assemble the picture frame. I.E put picture inside the frame
    // Add a GamePanel parameter tp the jFrame constructor
    public GameWindow(GamePanel gamePanel){
        //Step 1: Object of the JFrame was created - ready to be called
        JFrame jframe = new JFrame();

        // Step 4.0 Size of the GUI window Width and height
        jframe.setSize(400, 400);
        // Step 4.2 sets the program terminate when gui closed
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Step 8.2 Call class name Jframe plus . add() Method to add gamePanel Constructor. Adding the picture to the frame
        jframe.add(gamePanel);
        // Step 9 Sets the Start up Location of your GUI to be center of the screen
        jframe.setLocationRelativeTo(null);
        // Step 4.1 Allows the GUI to be seen when called, must be at bottom of this list - true means visible
        jframe.setVisible(true);
    }
}

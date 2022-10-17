package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    // Step 14 Setting up a constructor to change X and y variable on Our Component
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // Step 12 If statements w/ Switch to check which key is pressed KeyEvent.Vk_* , * =  which key you would like to set up
            switch (e.getKeyCode()){
                case KeyEvent.VK_W:
                    gamePanel.changeYDelta(-5);

                    break; // Remember your breaks or all code ran
                case KeyEvent.VK_A:
                    gamePanel.changeXDelta(-5);
                    break;
                case KeyEvent.VK_S:
                    gamePanel.changeYDelta(5);
                    break;
                case KeyEvent.VK_D:
                    gamePanel.changeXDelta(5);
                    break;




            }
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

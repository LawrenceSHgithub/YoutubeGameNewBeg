package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

//JFrame is the Picture Frame, JPanel is the picture
//this is Jpanel
public class GamePanel extends JPanel {
    private Random random;
    private Color color = new Color(217, 20, 143);
    private long lastCheck = 0;
    // Variable that counts our frames, gets incremented per call or use - see paintComponents();
    private int frames;
    // Step 13.1 Setting up object variable to re use same object in mouseListner and mouse motion listener
    private MouseInputs mouseInputs;
    // sets X and Y postion on components. Currently only the filled rectangle. See Step 7
    private float xDelta = 100, yDelta = 100;
    //Step 19
    private float xDir = 0.1f , yDir = 0.1f;
    //Step 5.0 Create Jpanel Constructor - the picture itself
    public GamePanel() {
        random = new Random();
        // Step 13.2 Make sure the class is intilized to make objects of it
        mouseInputs = new MouseInputs(this);
        // Step 10.1 Setting up Key inputs. keu listner listens for user key input. Code for key listener is in separate file --- our self made class KeyboardInputs <-- type this to get pre gen code
        // STep 10 our class KeyboardInputs implements KeyListener. We have a seperate package for user inputs
        addKeyListener(new KeyboardInputs(this)); // Step 15 passing Keyboard input params into keylistner
        // Step 13 Setting up the Mouse inputs, same as key inputs. Also use this to set up motion listener of mouse.
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    // Step 16 method to change X and y variable using user input. See class keyboardinputs Called in keyPressed
    public void changeXDelta(int value){
        this.xDelta += value;
        // repaint method calls paintComment. This will update the frame everytime the xDelta variable is changed
        repaint();
    }

    public void changeYDelta(int value){
        this.yDelta += value;
        // repaint method calls paintComment. This will update the frame everytime the yDelta variable is changed
        //repaint();
    }

    // Step 16 adding the method that allows us to move out Rectangle component with the mouse
    public void  setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
       // repaint();
    }
    // Step 5.1 It gets called when game starts. Takes a Graphic g as a argument. NEED THIS TO DRAW JPANEL "you can draw here"  --- GRAPHICs "ok I draw here". Must be spelt right
    public void paintComponent(Graphics g){
        // Step 5.2 Call super class to do pre work.
        super.paintComponent(g);
        // Step 18
        updateRectangle();
        // Step 20
        g.setColor( color);
        //Step 7 this Draws a filled rectangle shape First two variables are an x and y postion. Curretly connected to user input for x and y. Mouse and Keyboard
        g.fillRect((int)xDelta, (int)yDelta,200,50); // Step 14 Setting movement for this Component via user input. XDelta and yDelta are x and y variables
        // Step 17 Fps Counter, checks fps every second passed,
        frames++;
        if (System.currentTimeMillis() - lastCheck >= 1_000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
        repaint();
    }
    // Step 18.1 This methods stops components from leaving the gameWindow. calculates thses valuses by updating everytime paintComponent is called
    private void updateRectangle() {
        xDelta+= xDir;
        if ( xDelta > 400 || xDelta < 0){
            xDir *= -1;
            color = getRndColor();
        }// 400 is the width of our window


        yDelta+= yDir;
        if ( yDelta > 400 || yDelta < 0){
            yDir *= -1;
            color = getRndColor();
        }
        // 400 is the height of our window

    }

    private Color getRndColor() {
        int r = random.nextInt(255); // returns anything in between 0 and 255
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color( r, g, b);
    }
}

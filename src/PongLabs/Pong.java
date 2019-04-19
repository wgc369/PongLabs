package PongLabs;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {

    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;
    private BufferedImage back;
    private String ls;
    private String rs;
    public static int left;
    public static int right;

    public Pong() {
        //set up all variables related to the game
        ball = new Ball(200, 200, 10, 10, Color.BLUE, 2, 1);
        leftPaddle = new Paddle(10, 0, 20, 70, Color.YELLOW, 6);
        rightPaddle = new Paddle(770, 0, 20, 70, Color.YELLOW, 6);

        keys = new boolean[4];

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);		//starts the key thread to log key strokes
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

		//take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

		//create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        //see if ball hits left wall or right wall
        if (!(ball.getX() >= 10 && ball.getX() <= 780)) {
            ball.setxSpeed(0);
            ball.setySpeed(0);
        }
        //see if the ball hits the top or bottom wall 
        if (!(ball.getY() >= 10 && ball.getY() <= 500)) {
            ball.setySpeed(-ball.getySpeed());
        }
        //see if the ball hits the left paddle
        if ((ball.getX() <= leftPaddle.getX()) && ((leftPaddle.getY() <= ball.getY()) && (ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()))) {
            ball.setxSpeed(-ball.getxSpeed());
            left++;
        }

        //see if the ball hits the right paddle
        if ((ball.getX() >= rightPaddle.getX()) && ((rightPaddle.getY() <= ball.getY()) && (ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()))) {
            ball.setxSpeed(-ball.getxSpeed());
            right++;
        }

        //see if the paddles need to be moved
        if (keys[0] == true) {
            //move left paddle up and draw it on the window
            leftPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[1] == true) {
            //move left paddle down and draw it on the window
            leftPaddle.moveDownAndDraw(graphToBack);
        }
        if (keys[2] == true) {
            rightPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[3] == true) {
            rightPaddle.moveDownAndDraw(graphToBack);
        }

        graphToBack.setColor(Color.WHITE);
        ls = "Left Score: " + (left - 1);
        rs = "Right Score: " + (right - 1);
        graphToBack.drawString(ls, 650, 50);
        graphToBack.drawString(rs, 650, 70);

        graphToBack.setColor(Color.BLACK);
        ls = "Left Score: " + left;
        rs = "Right Score: " + right;
        graphToBack.drawString(ls, 650, 50);
        graphToBack.drawString(rs, 650, 70);

        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'Z':
                keys[1] = true;
                break;
            case 'I':
                keys[2] = true;
                break;
            case 'M':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'Z':
                keys[1] = false;
                break;
            case 'I':
                keys[2] = false;
                break;
            case 'M':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}

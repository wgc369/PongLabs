package PongLabs;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable {

    private int xSpeed;
    private int ySpeed;

    public Ball() {
        super(200, 200);
        xSpeed = 3;
        ySpeed = 1;
    }
    public Ball(int x, int y)
    {
        super(x, y);
        xSpeed = 3;
        ySpeed = 1;
    }
    public Ball(int x, int y, int w, int h)
    {
        super(x, y, w, h);
        xSpeed = 3;
        ySpeed = 1;
    }
    public Ball(int x, int y, int w, int h, Color c)
    {
        super(x, y, w, h, c);
        xSpeed = 3;
        ySpeed = 1;
    }
    public Ball(int x, int y, int w, int h, Color c, int xSp, int ySp)
    {
        super(x, y, w, h, c);
        xSpeed=xSp;
        ySpeed=ySp;
    }

	//add the other Ball constructors
   //add the set methods

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }
    
    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void moveAndDraw(Graphics window) {
   	//draw a white ball at old ball location
        draw(window, Color.WHITE);
        setX(getX() + getxSpeed());
		//setY
        setY(getY() + getySpeed());

        //draw the ball at its new location
        draw(window);
    }

    public boolean equals(Object obj) {
        Ball test = (Ball)obj;
        return (super.equals(obj) && this.getxSpeed() == test.getxSpeed() && this.getySpeed()==test.getySpeed());

    }

   //add the get methods
    public int getxSpeed() {
        return xSpeed;
    }
    public int getySpeed() {
        return ySpeed;
    }
   //add a toString() method
    public String toString()
    {
        return super.toString()+" "+getxSpeed()+" "+getySpeed();
    }
    

    public boolean didCollideLeft(Object obj)
    {
        Block other = (Block)obj;
        return (getX() <= (other.getX()+other.getWidth()+Math.abs(getxSpeed())));
    }
    
    public boolean didCollideRight(Object obj)
    {
        Block other = (Block)obj;
        return (getX() >= (other.getX()-other.getWidth()-Math.abs(getxSpeed())));
        //return false;
    }
    
    public boolean didCollideTop(Object obj)
    {
        Block other = (Block)obj;
        return (getY() <= (other.getY()+other.getHeight()+Math.abs(getySpeed())));
    }
    
    public boolean didCollideBottom(Object obj)
    {
        Block other = (Block)obj;
        return (getY() >= (other.getY()-other.getHeight()-Math.abs(getySpeed())));
    }

}

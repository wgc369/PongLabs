package PongLabs;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

   //constructors
   public BlinkyBall()
   {
		super();
   }

   public BlinkyBall(int x, int y)
   {
       super(x,y);


   }

   public BlinkyBall(int x, int y, int wid, int ht)
   {
       super(x,y,wid,ht);


   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
       
       super(x,y,wid,ht,c,xSpd,ySpd);

   }

   public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {




   }

   public Color randomColor()
   {
   	int r = 0;		//use Math.random()
 		int g = 0;
 		int b = 0;
 		return new Color(r,g,b);
   }

   public void moveAndDraw(Graphics window)
   {




   }
}
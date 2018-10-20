package tanzida.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import java.util.ArrayList;

public class ball
{
	private boolean checkball=true;
	private float x,y,xx=10,yy=-10,radius=15;
	boolean firstTime=true;
	
	//constructor for object
	 public boolean ballavailable() 
	 {
	        return checkball;
	 }
	
	//set value
	 public void setBall(Canvas canvas,bar bar)
	 {
		 float BarMid=(bar. getBarRight()-bar.getBarLeft())/2;
		 x=bar.getBarLeft()+BarMid;
		 y=(bar.getBarTop()-radius);
	 }
	 
	 public void setBallAvailable(boolean BallAvailable) {
	        this.checkball = BallAvailable;
	    }
	 
	 public void setX(float x)
	 	{ 
	    	this.x = x; 
	 	}
	 public void setY(float y)
	 	{
	        this.y = y;
	 	}
	 public void setDX(float dx) 
	 	{ 
	    	this.xx = dx; 
	 	}
	 public void setDY(float dy)
	    { 
	    	this.yy = dy; 
	    }
	 public void setRadius(float radius) 
	    { 
	    	this.radius = radius; 
	    }
	    //get values
	 public float getX() 
	    { 
	    	return x; 
	    }
	 public float getY() 
	    {
	        return y;
	    }
	 public float getDX() 
	    {
	        return xx;
	    }
	 public float getDY()
	    {
	        return yy;
	    }
	  public float getRadius()
	    { 
	    	return radius; 
	    }
	  public void drawBall(Canvas canvas, Paint paint)
	  {
	        canvas.drawCircle(x,y,radius,paint);
	  }
	  protected void nextPos(Canvas canvas,bar bar, Paint paint){
			if(firstTime)
			{
				firstTime=false;
				x=canvas.getWidth() / 2;
				y=canvas.getHeight() / 2;
			}
			y+=1*yy;
			x+=1*xx;
			if(x<=0+20) xx*=-1;
			if(x>=canvas.getWidth()-20) xx*=-1;
			if(y<=0+20) yy*=-1;
			
			if(y+45>=canvas.getHeight()-30) {
				if(x>=bar.getBarLeft() && x<=bar.getBarRight()){
					xx*=-1;
					yy*=-1;
				}
			}
			if(y>=canvas.getHeight())
				System.exit(0);
		}
	  
	  public void collision(ArrayList<brick> br, ball ball){
	        for(int i=0;i<br.size();i++) {
	            if (((ball.getY() - ball.getRadius()) <= br.get(i).getBrickBottom()) && ((ball.getY() + ball.getRadius()) >= br.get(i).getBrickTop()) && ((ball.getX()) >= br.get(i).getBrickLeft()) && ((ball.getX()) <= br.get(i).getBrickRight())) {
	                br.remove(i); 
	                gameactivity.score ++;
	                ball.setDY(-(ball.getDY()));
	            }
	            else if(((ball.getY()) <= br.get(i).getBrickBottom()) && ((ball.getY()) >= br.get(i).getBrickTop()) && ((ball.getX() + ball.getRadius()) >= br.get(i).getBrickLeft()) && ((ball.getX() - ball.getRadius()) <= br.get(i).getBrickRight())) {
	                br.remove(i);
	                gameactivity.score ++;
	                ball.setDX(-(ball.getDX()));
	            }
	        }
	    }
}

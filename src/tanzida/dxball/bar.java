package tanzida.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class bar
{
	 private float left,right,top,bottom,barwidth;
	    
	    //set bar features
	    public  void setBar(Canvas canvas) 
	    {
	    	left= (canvas.getWidth()/2)-(canvas.getWidth()/8);
	        right = left + (canvas.getWidth()/3);
	        bottom = canvas.getHeight()-30;
	        top = bottom - 35;
	        barwidth= left+right;
	     }
	    public void drawBar(Canvas canvas, Paint paint)
	    {
	        canvas.drawRect(left,top,right,bottom, paint);
	    }
	   
	    public void setBarBottom(float Bottom) 
	    {
	        this.bottom = Bottom;
	    }
	    public void setBarTop(float Top)
	    {
	        this.top = Top;
	    }
	    public void setBarLeft(float Left)
	    {
	        this.left = Left;
	    }
	    public void setBarRight(float Right)
	    {
	        this.right = Right;
	    }
	    public float getBarWidth()
	    {
	    	return this.barwidth;
	    }
	    public float getBarLeft()
	    {
	        return left;
	    }
	    public float getBarBottom()
	    {
	        return bottom;
	    }
	    public float getBarRight()
	    {
	        return right;
	    }
	    public float getBarTop()
	    {
	        return top;
	    }
}

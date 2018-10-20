package tanzida.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class brick
{
	float left, right,top,bottom;
	Paint paint;
	Point point;
	Canvas canvas=new Canvas();
	int brickcolor;
	int x,y;
	
	//object constructor
	brick(float top,float bottom,float left,float right,int color)
	{
		this.right=right;
		this.left=left;
		this.top=top;
		this.bottom=bottom;
		this.brickcolor= color;
		paint=new Paint();
		paint.setColor(color);
	}
	//set values
	public void setBrickTop(float Top)
	{
		this.top=Top;
	}
	public void setBrickBottom(float Bottom)
	{
		this.bottom=Bottom;
	}
	public void setBrickLeft(float Left)
	{
		this.left=Left;
	}
	public void setBrickRight(float Right)
	{
		this.right=Right;
	}
	
	 public float getBrickLeft() 
	 {
	        return this.left;
	 }
	 public float getBrickRight()
	  {
	    return this.right;
	  }
	 public float getBrickTop()
	 {
		return this.top;
	 }
	public float getBrickBottom()
	{
		return this.bottom;
	}
	public Paint getPaint()
	{
		return this.paint;
	}
}

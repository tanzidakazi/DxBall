package tanzida.dxball;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;

public class gameactivity extends View
{
    public static boolean gameOver=false;
    boolean GameBegin=true;
    boolean StartGame;
    
    public static int score=0;
    int level;
    float Touch;
    
    Canvas canvas;
    Paint paint;
    bar bar;
    ball ball;
    
    ArrayList<brick>bricks =new ArrayList<brick>();
	 stage stage = new stage();
    
	// @SuppressLint("ClickableViewAccessibility")
	public gameactivity(Context context) 
	{
		super(context);
		// TODO Auto-generated constructor stub
		paint=new Paint();
		level=1;
	
		StartGame=true;
		gameOver=false;
		
		 bar=new bar();
		 ball=new ball();
	
		setOnTouchListener(new OnTouchListener()
		{
			public boolean onTouch(View v,MotionEvent m)
			{
				if(ball.ballavailable())
				{
					Touch=m.getX();
					if(Touch<v.getWidth()/2 && bar.getBarLeft()>0)
					{
						bar.setBarLeft(bar.getBarLeft()-20);
						bar.setBarRight(bar.getBarRight()-20);
						Touch = -20;
					}
					else if(Touch >= v.getWidth()/2 && bar.getBarRight()<v.getWidth())
					{
						bar.setBarLeft(bar.getBarLeft()+20);
						bar.setBarRight(bar.getBarRight()+20);
						Touch = -20;
					}
				}
				return true;
			}
		});
	}

	   public void drawLifeText(Canvas canvas) {
	        paint.setTypeface(Typeface.create("Arial",Typeface.BOLD));
	        paint.setTextSize(40);
	        canvas.drawText("SCORE : " + score,  150, 60, paint); 
	    }
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		if(GameBegin){
		GameBegin=false;
		bar.setBar(canvas);
		ball.setBall(canvas,bar);
		}
		
	 canvas.drawRGB(255, 0, 0);
	 paint.setColor(Color.GREEN);
     paint.setStyle(Paint.Style.FILL);   
     ball.drawBall(canvas,paint);
     paint.setColor(Color.YELLOW);
     bar.drawBar(canvas,paint);
     ball.nextPos(canvas, bar, paint);
     
     drawLifeText(canvas);
     
     if(StartGame)
     {
    	 StartGame=false;
    	 if(level == 1)
    	 {
    		stage.stageone(canvas,bricks); 
    	 }
    	 else
    	 {
    		gameOver=true; 
    	 }
     }

     for(int i = 0; i< bricks.size(); i++)
     {
    	 brick b=bricks.get(i);
         canvas.drawRect(bricks.get(i).getBrickLeft(), bricks.get(i).getBrickTop(), bricks.get(i).getBrickRight(), bricks.get(i).getBrickBottom(), bricks.get(i).getPaint());
     }
     invalidate();
     ball.collision(bricks,ball);
     
     if(ball.ballavailable() == false && gameOver==false)
     {
         ball.setBallAvailable(true);
         GameBegin = true;
         ball.setDX(5);
         ball.setDY(-5);
     }
	}}
	
	



	

   



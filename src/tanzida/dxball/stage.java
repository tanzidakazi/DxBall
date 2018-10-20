package tanzida.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import java.util.ArrayList;

public class stage
{
	float row = 4, brickD = 70, brickH = 70, brickX, brickY;
    int col;
    
    public void stageone(Canvas canvas,ArrayList<brick> bricks){
    	brickX= 70;
    	brickY=10;
    	float bricWidth = ((canvas.getWidth()) / row);
        for (int i = 0; i <7; i++) {
            for (int j = 0; j < row; j++) {
            		col =Color.BLUE;
            	bricks.add(new brick(brickX, brickX + 100,brickY, brickY + 70, col));
            	brickX =brickX+ bricWidth;
            }
            brickY =brickY+ brickH;
            brickX = 70;
        } 
    }
}

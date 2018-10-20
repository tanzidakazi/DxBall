package tanzida.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class drawable 
{
	float x1, y1;
    Paint paint;

    public float getX() {
        return x1;
    }
    public void setX(int x) {
        this.x1 = x;
    }
    public float getY() {
        return y1;
    }
    public void setY(int y) {
        this.y1 = y;
    }
    public abstract void onDraw(Canvas canvas,Paint paint);
}
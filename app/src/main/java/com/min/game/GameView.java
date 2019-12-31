package com.min.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {
    private Dock dock;
    private Paint paint = new Paint();
    private Bitmap bitmapDock;
    private Bitmap bitmapDead;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(dock ==null) {
            dock = new Dock(this);
        }
        Log.d("Game", "onDraw: " + getWidth() + ", " + getHeight());
        bitmapDock = BitmapFactory.decodeResource(getResources(), R.drawable.dock);
        bitmapDead = BitmapFactory.decodeResource(getResources(), R.drawable.dead);
        if(dock.getDirection() == Dock.DIRECTION_DEAD) {
            bitmapDock = bitmapDead;
        }
        canvas.drawBitmap(bitmapDock, dock.getX(), dock.getY(), paint);
    }

    public void moveRight() {
        if(dock.getX() < getWidth()-200) {
            dock.setDirection(Dock.DIRECTION_RIGHT);
            invalidate();
        }
    }
    public void moveLeft() {
        if(dock.getX() > 0) {
            dock.setDirection(Dock.DIRECTION_LEFT);
            invalidate();
        }
    }
    public void moveUp() {
        if(dock.getY() > 50) {
            dock.setDirection(Dock.DIRECTION_UP);
            invalidate();
        }
    }
    public void moveDown() {
        if(dock.getY() < getHeight()-200) {
            dock.setDirection(Dock.DIRECTION_DOWN);
            invalidate();
        }
    }
}

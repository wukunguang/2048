package com.example.wukunguang.demo2048;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wukunguang on 15-4-9.
 */
public class Myrectangle extends View{

    private static int x[][]=new int[4][4];
    private int absx,absy;

    private Canvas canvas1;

    public Myrectangle(Context context) {

        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int Now_X=MainActivity.number_x*100;  //方块起始坐标
        int Now_Y=MainActivity.number_y*100;

        Paint paint=new Paint();
        paint.setColor(Color.YELLOW);

        canvas.drawRect(Now_X,Now_Y,100+Now_X,100+Now_Y,paint);

        //canvas1=canvas;
        canvas.save();

    }

}

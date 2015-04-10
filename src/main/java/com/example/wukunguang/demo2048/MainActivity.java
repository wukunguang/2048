package com.example.wukunguang.demo2048;

import android.app.Activity;
import android.content.Loader;
import android.gesture.GestureOverlayView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Random;


public class MainActivity extends Activity {

    private RelativeLayout layout;
    private Myrectangle myrectangle;
    private MyGestureListener myGestureListener;
    private GestureDetector gestureDetector;

    public static Myrectangle[][] myrectangles=new Myrectangle[4][4];

    public static int[][] numbers=new int[4][4];

    public static int number_x=0,number_y=0;

    public static  int desc_top=0,top=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout= (RelativeLayout) findViewById(R.id.main_layout);
        Log.i("shuzi",numbers[0][1]+"");

        init();


        myGestureListener=new MyGestureListener(this);

        gestureDetector=new GestureDetector(this,myGestureListener);







       // myrectangle.invalidate();







    }

    public static void init(){
        // 生成方块
        for (; ;) {
            Random r=new Random();
            number_x = r.nextInt(4);
            number_y = r.nextInt(4);

            if (numbers[number_y][number_x]==0){
                break;
            }
        }
        numbers[number_y][number_x]=2;
        System.out.println("zhuru"+numbers[number_y][number_x]);
        MyGestureListener.printIndex();
        //myrectangles[number_y][number_x]=new Myrectangle(this);
        //myrectangles[number_y][number_x].invalidate();
        //layout.addView(myrectangles[number_y][number_x]);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //layout.addView(new Myrectangle(getBaseContext()));
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

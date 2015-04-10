package com.example.wukunguang.demo2048;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by wukunguang on 15-4-9.
 */
public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

    private View cv;
    private int absx,absy;
    //private int x[][]=new int[4][4];
    private Context context;
    public MyGestureListener(Context context){
          this.context= context;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        absx=(int)Math.abs(e2.getX()-e1.getX());
        absy=(int)Math.abs(e2.getY()-e1.getY());

        if (absx>absy){
            if (e2.getX()-e1.getX()>0){
                //cv.scrollBy(-100,0);
                movePoint_X(3);
                Toast.makeText(context,"right",Toast.LENGTH_SHORT).show();
                printIndex();
            }
            else {
                movePoint_deX(3);
                Toast.makeText(context,"left",Toast.LENGTH_SHORT).show();
                printIndex();
            }
        }
        else {
            if (e2.getY()-e1.getY()>0){

                movePoint_Y(3);
                Toast.makeText(context,"down",Toast.LENGTH_SHORT).show();
                printIndex();
               // cv.scrollBy(0,-100);
            }
            else {
                movePoint_deY(3);
                Toast.makeText(context,"up",Toast.LENGTH_SHORT).show();
                printIndex();
              //  cv.scrollBy(0,100);
            }
        }
        MainActivity.init();

        return true;
    }

    public static  void printIndex(){
        for (int y=0;y<=3; y++){
            String string=new String();
            string="show:";
            for (int x=0;x<=3;x++){
                //System.out.println("Show：");
                //System.out.println("num"+MainActivity.numbers[y][x]+" ");
                string=string+MainActivity.numbers[y][x]+" ";
            }
            System.out.println(string);

        }
        System.out.println("show-----------------");
    }

    public void movePoint_X(int top){
        for (int y=0;y<=3;y++){
            for (int i=top;i>=0;i--){
                for (int j=i-1;j>=0;j--){
                    if (MainActivity.numbers[y][i]==0){ break; }//如果第y排i列个数为0，那么就退出当前遍历循环。
                    else if (MainActivity.numbers[y][i]==MainActivity.numbers[y][j]){
                        MainActivity.numbers[y][i]+=MainActivity.numbers[y][j];
                        MainActivity.numbers[y][j]=0;

                    }
                }
                int temp=i;
                for (int t=i+1;t<=3;t++){
                    if (MainActivity.numbers[y][t]==0){

                        MainActivity.numbers[y][t]=MainActivity.numbers[y][temp]; //靠边。
                        MainActivity.numbers[y][temp]=0;
                        temp++;
                    }
                    else {break;}
                }
            }
        }

    }

    public void movePoint_Y(int top){
        for (int y=0;y<=3;y++){
            for (int i=top;i>=0;i--){
                for (int j=i-1;j>=0;j--){
                    if (MainActivity.numbers[i][y]==0){ break; }//如果第y排i列个数为0，那么就退出当前遍历循环。
                    else if (MainActivity.numbers[i][y]==MainActivity.numbers[j][y]){
                        MainActivity.numbers[i][y]+=MainActivity.numbers[j][y];
                        MainActivity.numbers[j][y]=0;
                    }
                }
                int temp=i;
                for (int t=i+1;t<=3;t++){
                    if (MainActivity.numbers[t][y]==0){

                        //System.out.println("show:"+"x");
                        MainActivity.numbers[t][y]=MainActivity.numbers[temp][y]; //靠边。
                        MainActivity.numbers[temp][y]=0;
                        temp++;
                    }
                    else {break;}
                }
            }
        }

    }

    public void movePoint_deY(int top){
        for (int y=0;y<=3;y++){
            for (int i=0;i<=top;i++){
                for (int j=i+1;j<=top;j++){
                    if (MainActivity.numbers[i][y]==0){ break; }//如果第y排i列个数为0，那么就退出当前遍历循环。
                    else if (MainActivity.numbers[i][y]==MainActivity.numbers[j][y]){
                        MainActivity.numbers[i][y]+=MainActivity.numbers[j][y];
                        MainActivity.numbers[j][y]=0;
                    }
                }
                int temp=i;
                for (int t=i-1;t>=0;t--){
                    if (MainActivity.numbers[t][y]==0){

                        MainActivity.numbers[t][y]=MainActivity.numbers[temp][y]; //靠边。
                        MainActivity.numbers[temp][y]=0;
                        temp--;
                    }
                    else {break;}
                }
            }
        }
    }

    public  void movePoint_deX(int top){
        for (int y=0;y<=3;y++){
            for (int i=0;i<=top;i++){
                for (int j=i+1;j<=top;j++){
                    if (MainActivity.numbers[y][i]==0){ break; }//如果第y排i列个数为0，那么就退出当前遍历循环。
                    else if (MainActivity.numbers[y][i]==MainActivity.numbers[y][j]){
                        MainActivity.numbers[y][i]+=MainActivity.numbers[y][j];
                        MainActivity.numbers[y][j]=0;
                    }
                }
                int temp=i;
                for (int t=i-1;t>=0;t--){
                    if (MainActivity.numbers[y][t]==0){

                        MainActivity.numbers[y][t]=MainActivity.numbers[y][temp]; //靠边。
                        MainActivity.numbers[y][temp]=0;
                        temp--;
                    }
                    else {break;}
                }
            }
        }

    }



}

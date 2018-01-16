package com.example.mahammad.snake_game;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
 import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;



import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private ViewGroup mainLayout;
    private ImageView image;


Button left;
Button right;
Button up;
Button down;
Handler handler=new Handler();
private Timer timer=new Timer();

    private int screenWidth;
    private int screenHeight;
    private float X;
    private float Y;
    int a=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = (RelativeLayout) findViewById(R.id.main);
        image = (ImageView) findViewById(R.id.imager);

        WindowManager wm = getWindowManager();
        Display ada = wm.getDefaultDisplay();
right=(Button)findViewById(R.id.btnright);
        left=(Button)findViewById(R.id.btnleft);
        up=(Button)findViewById(R.id.btnup);
        down=(Button)findViewById(R.id.btndown);
        Point size = new Point();
        ada.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {

                    @Override
                    public void run() {

                        changeposition();
                        if(a==1){  turnLeft(X,Y);    }
                        if(a==2){  turnRight(X,Y);    }
                        if(a==3){   turnDown(X,Y);   }
                        if(a==4){   turnUp(X,Y);   }
                    }
                });

            }

        } ,0, 20
        );




    }
public void turnLeft(float x, float y){

     X -=10;
    if(image.getX()+image.getWidth()<0){

      X=screenWidth+100.0f;

    }
    image.setX( X);
    image.setY( Y);
}
    public void turnRight(float x, float y){

    X +=10;
        if(image.getX()>screenWidth){
            image.setY(-80.0f);
            image.setX(screenWidth+80.0f);
            //  upX=(float)Math.floor(Math.random()*screenWidth-imageup.getWidth());
           X=-100.0f;
        }
        image.setX( X);
        image.setY( Y);}
    public void turnUp(float x, float y){
        Y -=10;
       if(image.getY()+image.getHeight()<0){

            //  upX=(float)Math.floor(Math.random()*screenWidth-imageup.getWidth());
            Y=screenHeight+100.0f;

        }
        image.setX(X);
        image.setY(Y);}
    public void turnDown(float x, float y){

        Y +=10;
        if(image.getY()>screenHeight){

            //  upX=(float)Math.floor(Math.random()*screenWidth-imageup.getWidth());
            Y=-100.0f;

        }
        image.setX(X);
        image.setY(Y);
    }
public void changeposition(){
    right.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           // Tunrright(X,Y);
a=2;
        }
    });
    left.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
              // Turnleft(X, Y);
a=1;
        }
    });
    up.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           // Tunrup(X, Y);
a=4;
        }
    });
    down.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
a=3;
        //    Tunrdown(X, Y);
        }
    });



}

}

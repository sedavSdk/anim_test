package com.example.a6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private RelativeLayout cr;
    static float x = 0;
    static float y = 0;
    ImageView a;
    TextView t;
    MyTimerTask m;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cr = findViewById(R.id.a1);
        a = findViewById(R.id.imageView2);
        cr.setOnTouchListener(this::onTouch);
        t = findViewById(R.id.textView);
      //  t.setText("-1");
        x = 0;
        y = 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
        layoutParams.setMargins(-100, -100, 0, 0);

        ImageView[] imageView = new ImageView[20];
        for(int i = 0; i < 20; ++i){
            imageView[i] = new ImageView(this);
            imageView[i].setImageResource(R.drawable.bullet);
            cr.addView(imageView[i], layoutParams);
        }
        // new RelativeLayout(MainActivity.this);
        // relativeLayout.addView(imageView, layoutParams);
      //  Animation an = new TranslateAnimation(400, 400, 400 , 0);
       // an.setDuration(2000);
      //  an.setFillAfter(true);
        //  imageView.startAnimation(an);
        Timer ti = new Timer(true);
        MyTimerTask my = new MyTimerTask(imageView);
        ti.schedule(my, 1000, 500);
    }

    int state = 0;
    float newX, newY;
    @SuppressLint("SetTextI18n")
    public boolean onTouch(View v, MotionEvent event) {
      //  t.setText("0");
        switch (event.getActionMasked()){
            case 0:
                state = 1;
                newX = event.getX() - 150;
                newY = event.getY() - 180;
                t.setText(String.valueOf(1));
                break;
            case 2:
           // case 2:
                state = 2;
                t.setText(String.valueOf(2));
                newX = event.getX() - 150;
                newY = event.getY() - 180;
                break;
            case 1:
                state = 0;
                t.setText(String.valueOf(3));
        }
        if(state == 1) {
            t.setText("2");
            double le = Math.sqrt((newX - x) * (newX - x) + (newY - y) * (newY - y));
            float le2 = (float) le;
            le2 = le2 / 20;
            le2 = Math.round(le2);
            if (le2 < 3) le2 = 1;
            float anX = (newX - x) / le2 + x;
            float anY = (newY - y) / le2 + y;
            TranslateAnimation animation = new TranslateAnimation(x, anX, y, anY);
            animation.setAnimationListener(animationEnlargeListener);
            animation.setDuration(20);
            animation.setFillAfter(true);
            a.startAnimation(animation);
            x = anX;
            y = anY;
           // t.setText(String.valueOf(event.getAction()));
        }
        return true;
    }
    Animation.AnimationListener animationEnlargeListener = new Animation.AnimationListener() {

        public void onAnimationEnd(Animation animation) {
                a.startAnimation(animation);
            }


        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
            if(state != 0){
                double le = Math.sqrt((newX - x) * (newX - x) + (newY - y) * (newY - y));
                float le2 = (float)le;
                le2 = le2 / 20;
                le2 = Math.round(le2);
                if(le2 == 0) le2 = 1;
                float anX = (newX - x) / le2 + x;
                float anY = (newY - y) / le2 + y;
                animation = new TranslateAnimation(x, anX, y, anY);
                animation.setAnimationListener(animationEnlargeListener);
                animation.setFillAfter(true);
                animation.setDuration(20);
                a.startAnimation(animation);
                x = anX;
                y = anY;
            }
            else {
                double le = Math.sqrt((newX - x) * (newX - x) + (newY - y) * (newY - y));
                float le2 = (float)le;
                le2 = le2 / 20;
                le2 = Math.round(le2);
                if(le2 == 0) le2 = 1;
                float anX = (newX - x) / le2 + x;
                float anY = (newY - y) / le2 + y;
                animation = new TranslateAnimation(x, anX, y, anY);
               // animation.setAnimationListener(animationEnlargeListener);
                animation.setFillAfter(true);
                animation.setDuration(20);
                a.startAnimation(animation);
                x = anX;
                y = anY;
            }
        }
    };

}
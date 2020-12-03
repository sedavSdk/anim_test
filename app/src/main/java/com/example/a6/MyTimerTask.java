package com.example.a6;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    int j = 0;
    ImageView[] imageView = new ImageView[20];
    MyTimerTask(ImageView[] imageView){
        for(int i = 0; i < 20; ++i){
            this.imageView[i] = imageView[i];
        }

    }
    @Override
    public void run() {
        if(j == 9) j = 0;
        else j++;
        Animation an = new TranslateAnimation(MainActivity.x + 200, MainActivity.x + 200, MainActivity.y + 100, MainActivity.y + 100 - 2000);
       // float u = MainActivity.y + 50 + 100;
        //int d = Math.round(u);
        an.setDuration(1400);
        //an.setFillAfter(true);
        imageView[j].startAnimation(an);
    }
}
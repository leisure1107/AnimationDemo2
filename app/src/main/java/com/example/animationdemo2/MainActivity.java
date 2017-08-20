package com.example.animationdemo2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button addButton=null;
    private Button removeButton = null;
    private ImageView imageView = null;
    private ViewGroup viewGroup=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = (Button) findViewById(R.id.addButton);
        removeButton = (Button) findViewById(R.id.removeButton);
        imageView = (ImageView) findViewById(R.id.image);
        viewGroup = (ViewGroup) findViewById(R.id.layoutId);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setStartOffset(500);
//                ImageView imageViewAdd = new ImageView(MainActivity.this);
//                imageViewAdd.setImageResource(R.mipmap.ic_launcher);
                viewGroup.addView(imageView,new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                imageView.startAnimation(alphaAnimation);
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setStartOffset(500);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        System.out.println("Start");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        System.out.println("end");
                        viewGroup.removeView(imageView);
//                        viewGroup.removeAllViews();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        System.out.println("Repeat");

                    }
                });
                imageView.startAnimation(alphaAnimation);
            }
        });
    }
}

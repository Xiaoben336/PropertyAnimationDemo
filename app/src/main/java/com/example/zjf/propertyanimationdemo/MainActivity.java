package com.example.zjf.propertyanimationdemo;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnPropetyAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPropetyAnimation = (Button) findViewById(R.id.btnPropetyAnimation);

        ValueAnimator animator = ValueAnimator.ofInt(btnPropetyAnimation.getLayoutParams().width,500);

        animator.setDuration(2000);
        animator.setStartDelay(500);
        animator.setRepeatCount(99);
        animator.setRepeatMode(ValueAnimator.RESTART);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (Integer) animation.getAnimatedValue();
                System.out.println(currentValue);
                btnPropetyAnimation.getLayoutParams().width = currentValue;
                btnPropetyAnimation.requestLayout();
            }
        });
        animator.start();
    }
}

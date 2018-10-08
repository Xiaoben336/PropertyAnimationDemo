package com.example.zjf.propertyanimationdemo.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.example.zjf.propertyanimationdemo.R;

public class ViewAnimationAcivity extends Activity {
    private Button btnPropetyAnimation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_viewanimation);
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

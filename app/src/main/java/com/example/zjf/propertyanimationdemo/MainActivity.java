package com.example.zjf.propertyanimationdemo;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnViewAnimation,btnPointAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnViewAnimation = (Button)findViewById(R.id.btnViewAnimation);
        btnPointAnimation = (Button)findViewById(R.id.btnPointAnimation);
        btnViewAnimation.setOnClickListener(this);
        btnPointAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btnViewAnimation:
                intent.setClass(MainActivity.this,ViewAnimationAcivity.class);
                startActivity(intent);
                break;
            case R.id.btnPointAnimation:
                intent.setClass(MainActivity.this,PointAnimationActivity.class);
                startActivity(intent);
                break;
                default:
                    break;
        }
    }
}

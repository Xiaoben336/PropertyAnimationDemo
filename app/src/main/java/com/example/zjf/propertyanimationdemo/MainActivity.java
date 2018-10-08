package com.example.zjf.propertyanimationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zjf.propertyanimationdemo.activity.AnimatorSetActivity;
import com.example.zjf.propertyanimationdemo.activity.CustomObjectActivity;
import com.example.zjf.propertyanimationdemo.activity.PointAnimationActivity;
import com.example.zjf.propertyanimationdemo.activity.ViewAnimationAcivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnViewAnimation,btnPointAnimation,btnCustomObject,btnAnimatorSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnViewAnimation = (Button)findViewById(R.id.btnViewAnimation);
        btnPointAnimation = (Button)findViewById(R.id.btnPointAnimation);
        btnCustomObject = (Button)findViewById(R.id.btnCustomObject);
        btnAnimatorSet = (Button)findViewById(R.id.btnAnimatorSet);

        btnViewAnimation.setOnClickListener(this);
        btnPointAnimation.setOnClickListener(this);
        btnCustomObject.setOnClickListener(this);
        btnAnimatorSet.setOnClickListener(this);
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
            case R.id.btnCustomObject:
                intent.setClass(MainActivity.this,CustomObjectActivity.class);
                startActivity(intent);
            case R.id.btnAnimatorSet:
                intent.setClass(MainActivity.this, AnimatorSetActivity.class);
                startActivity(intent);
                default:
                    break;
        }
    }
}

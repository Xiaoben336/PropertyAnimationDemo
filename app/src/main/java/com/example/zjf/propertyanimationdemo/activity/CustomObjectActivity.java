package com.example.zjf.propertyanimationdemo.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.zjf.propertyanimationdemo.evaluator.ColorEvaluator;
import com.example.zjf.propertyanimationdemo.view.CustomObjectView;
import com.example.zjf.propertyanimationdemo.R;

/**
*@description 通过自定义对象属性实现动画效果
*
*@author zjf
*@date 2018/10/8 19:25
*/
public class CustomObjectActivity extends Activity {
    CustomObjectView customObjectView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customobject);
        customObjectView = (CustomObjectView) findViewById(R.id.customObjectView);
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(customObjectView,"color",new ColorEvaluator(),"#0000FF", "#FF0000");

        // 设置自定义View对象、背景颜色属性值 & 颜色估值器
        // 本质逻辑：
        // 步骤1：根据颜色估值器不断 改变 值
        // 步骤2：调用set（）设置背景颜色的属性值（实际上是通过画笔进行颜色设置）
        // 步骤3：调用invalidate()刷新视图，即调用onDraw（）重新绘制，从而实现动画效果

        objectAnimator.setDuration(8000);
        objectAnimator.setRepeatCount(99);
        objectAnimator.start();
    }
}

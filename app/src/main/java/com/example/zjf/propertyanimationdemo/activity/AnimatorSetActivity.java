package com.example.zjf.propertyanimationdemo.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.example.zjf.propertyanimationdemo.R;
/**
*@description 单一动画实现的效果相当有限，更多的使用场景是同时使用多种动画效果，即组合动画
 *
 *              实例 : 主要动画是平移，平移过程中伴随旋转动画，平移完后进行透明度变化
*
*@author zjf
*@date 2018/10/8 19:55
*/
public class AnimatorSetActivity extends Activity {
    private Button btnAnimatorSet;
    private float curTranslationX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatorset);
        btnAnimatorSet = (Button)findViewById(R.id.btnAnimatorSet);
        curTranslationX = btnAnimatorSet.getTranslationX();

        // 步骤1：设置需要组合的动画效果
        // 平移动画
        ObjectAnimator translation = ObjectAnimator.ofFloat(btnAnimatorSet, "translationX", curTranslationX, 300,curTranslationX);
        // 旋转动画
        ObjectAnimator rotate = ObjectAnimator.ofFloat(btnAnimatorSet, "rotation", 0f, 360f);
        // 透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(btnAnimatorSet, "alpha", 1f, 0f, 1f);

        // 步骤2：创建组合动画的对象
        AnimatorSet animSet = new AnimatorSet();

        // 步骤3：根据需求组合动画
        /*
        *   AnimatorSet.play(Animator anim)   ：播放当前动画
            AnimatorSet.after(long delay)   ：将现有动画延迟x毫秒后执行
            AnimatorSet.with(Animator anim)   ：将现有动画和传入的动画同时执行
            AnimatorSet.after(Animator anim)   ：将现有动画插入到传入的动画之后执行
            AnimatorSet.before(Animator anim) ：  将现有动画插入到传入的动画之前执行
        * */
        animSet.play(translation).with(rotate).before(alpha);

        animSet.setDuration(5000);
        // 步骤4：启动动画
        animSet.start();
    }
}

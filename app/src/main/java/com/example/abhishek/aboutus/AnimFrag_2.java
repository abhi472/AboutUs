package com.example.abhishek.aboutus;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AnimFrag_2 extends Fragment {
    TextView tv, tv1;
    ImageView imv;

    RelativeLayout rl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_anim_page, container, false);
        tv = (TextView) rootView.findViewById(R.id.tv1);
        imv = (ImageView) rootView.findViewById(R.id.imv);

        tv1 = (TextView) rootView.findViewById(R.id.tv2);
        rl = (RelativeLayout) rootView.findViewById(R.id.root);
//        setupWindowsTransition();

        return rootView;
    }

    public void setupWindowsTransition() {
        ObjectAnimator imageX = ObjectAnimator.ofFloat(imv, "scaleX", 0f, 1f);
        ObjectAnimator imageY = ObjectAnimator.ofFloat(imv, "scaleY", 0f, 1f);
        AnimatorSet aset = new AnimatorSet();
        aset.play(imageX).with(imageY);
        aset.setInterpolator(new LinearInterpolator());
        aset.setDuration(600);
        aset.setStartDelay(200);
        if(!(imv.getVisibility()==View.VISIBLE)) {
            aset.start();
        }
        else
        {
            circleAnimation();
        }
        imageX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                imv.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                tv.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);
                elementAnimation();

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    private void elementAnimation() {

        ObjectAnimator tV1 = ObjectAnimator.ofFloat(tv, "translationY", -tv.getHeight(), 5);
        ObjectAnimator tV2 = ObjectAnimator.ofFloat(tv1, "translationY", tv1.getHeight(), -5);
        AnimatorSet aset2 = new AnimatorSet();
        aset2.setInterpolator(new AnticipateOvershootInterpolator());
        aset2.play(tV1).with(tV2);
        aset2.setDuration(1000);
        aset2.start();
        tV1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                circleAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }

    private void circleAnimation() {
        ObjectAnimator imageX = ObjectAnimator.ofFloat(imv, "scaleX", 1f, 0.90f);
        ObjectAnimator imageY = ObjectAnimator.ofFloat(imv, "scaleY", 1f, 0.90f);
        AnimatorSet anim = new AnimatorSet();
        anim.setDuration(1000);
        imageX.setRepeatCount(ValueAnimator.INFINITE);
        imageY.setRepeatCount(ValueAnimator.INFINITE);
        imageX.setRepeatMode(ValueAnimator.REVERSE);
        imageY.setRepeatMode(ValueAnimator.REVERSE);
        anim.play(imageX).with(imageY);
        anim.start();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void setMenuVisibility(final boolean visible) {
        super.setMenuVisibility(visible);
        if (visible) {
            setupWindowsTransition();
        }
    }

}

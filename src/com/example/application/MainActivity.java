package com.example.application;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.application.R.anim.frame_anim;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button startFrameAnim;
	private Button startTransformAnim;
	private Button startAlphaAnim;
	private Button cancelAnim;

	private ImageView animationView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		startFrameAnim = (Button) findViewById(R.id.frameAnimationStart);
		startTransformAnim= (Button) findViewById(R.id.transformAnimationStart);
		startAlphaAnim = (Button) findViewById(R.id.alphaAnimationStart);
		cancelAnim = (Button) findViewById(R.id.cancelAnimation);
		animationView = (ImageView) findViewById(R.id.animationView);
		
		startFrameAnim.setOnClickListener(this);
		startTransformAnim.setOnClickListener(this);
		startAlphaAnim.setOnClickListener(this);
		cancelAnim.setOnClickListener(this);
	}

	public void onClick(View v) {
		if (startFrameAnim.equals(v)) {
			animationView.setBackgroundResource(frame_anim);
			AnimationDrawable animation = (AnimationDrawable) animationView.getBackground();
			animation.start();
		} else if (startTransformAnim.equals(v)) {
			animationView.setBackgroundResource(R.drawable.v);
			Animation transformAnimation = AnimationUtils.loadAnimation(this, R.anim.transform_anim);
			animationView.startAnimation(transformAnimation);
		}else if (startAlphaAnim.equals(v)) {
				animationView.setBackgroundResource(R.drawable.v);
				Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpa_anim);
				animationView.startAnimation(alphaAnimation);
		} else if (cancelAnim.equals(v)) {
			animationView.setBackgroundColor(Color.BLACK);
		}
	}
}
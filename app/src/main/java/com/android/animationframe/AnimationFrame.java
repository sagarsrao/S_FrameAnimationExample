package com.android.animationframe;

import com.cf.S_FrameAnimationExample.R;
import com.cf.S_FrameAnimationExample.R.drawable;
import com.cf.S_FrameAnimationExample.R.id;
import com.cf.S_FrameAnimationExample.R.layout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class AnimationFrame extends Activity implements OnClickListener{
    Button start,stop;
    AnimationDrawable animationDrawable=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        start=(Button)findViewById(R.id.button1);
        stop=(Button)findViewById(R.id.button2);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			startanimation();
			break;
			
		case R.id.button2:
			stopanimation();
			break;
		default:
			break;
		}
		
	}
	
	void startanimation()
	{
		ImageView img=(ImageView)findViewById(R.id.imageView1);
		
		BitmapDrawable image1=(BitmapDrawable)getResources().getDrawable(R.drawable.splash1);
		BitmapDrawable image2=(BitmapDrawable)getResources().getDrawable(R.drawable.splash2);
		BitmapDrawable image3=(BitmapDrawable)getResources().getDrawable(R.drawable.splash3);
		
		int reasonableduration=500;
		animationDrawable=new AnimationDrawable();
		
		animationDrawable.addFrame(image1, reasonableduration);
		animationDrawable.addFrame(image2, reasonableduration);
		animationDrawable.addFrame(image3, reasonableduration);
		
		animationDrawable.setOneShot(false);		
		img.setBackground(animationDrawable);
		animationDrawable.setVisible(true,true);
		animationDrawable.start();
		
	}
	

	void stopanimation(){
		animationDrawable.stop();
		}
}
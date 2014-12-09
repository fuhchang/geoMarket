package com.example.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class AnimatedTabHostListener implements OnTabChangeListener {
	
	private static final int ANIMATION_TIME = 240;
	private TabHost tabHost;
	private View previousView;
	private View currentView;
	private GestureDetector gestureDetector;
	private int currentTab;

	public AnimatedTabHostListener(Context context, TabHost tabHost){
		this.tabHost = tabHost;
		this.previousView = tabHost.getCurrentTabView();
		gestureDetector = new GestureDetector(context, new MyGestureDetector());
		tabHost.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(gestureDetector.onTouchEvent(event)){
					return false;
				}else{
					return true;
				}
			}
			
		});
	}
	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		currentView = tabHost.getCurrentTabView();
		if(tabHost.getCurrentTab() < currentTab){
			previousView.setAnimation(outToLeftAnimation());
			currentView.setAnimation(inFromRightAnimation());
		}else{
			previousView.setAnimation(outToRightAnimation());
			currentView.setAnimation(inFromLeftAnimation());
		}
		previousView = currentView;
		currentTab = tabHost.getCurrentTab();
	}
	
	private Animation inFromRightAnimation(){
		Animation inFromRight = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
				0.0f);
		return setProperties(inFromRight);
	}
	
	private Animation outToRightAnimation()
	{
		Animation outToRight = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
				1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
		return setProperties(outToRight);
	}
	
	private Animation inFromLeftAnimation()
	{
		Animation inFromLeft = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
				0.0f);
		return setProperties(inFromLeft);
	}
	
	private Animation outToLeftAnimation()
	{
		Animation outtoLeft = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT,
				-1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
		return setProperties(outtoLeft);
	}
	
	private Animation setProperties(Animation animation)
	{
		animation.setDuration(ANIMATION_TIME);
		animation.setInterpolator(new AccelerateInterpolator());
		return animation;
	}
	
	private class MyGestureDetector extends SimpleOnGestureListener
	{
		private static final int SWIPE_MIN_DISTANCE = 120;
		private static final int SWIPE_MAX_OFF_PATH = 250;
		private static final int SWIPE_THRESHOLD_VELOCITY = 200;
		private int maxTabs;
		
		public MyGestureDetector(){
			maxTabs = tabHost.getTabContentView().getChildCount();
		}

		@Override
		public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			int newTab = 0;
			if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH)
			{
				return false;
			}
			if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
			{
				// Swipe right to left
				newTab = currentTab + 1;
			}
			else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE
					&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
			{
				// Swipe left to right
				newTab = currentTab - 1;
			}
			if (newTab < 0 || newTab > (maxTabs - 1))
			{
				return false;
			}
			tabHost.setCurrentTab(newTab);
			return super.onFling(event1, event2, velocityX, velocityY);
		}
		
		
	}
}

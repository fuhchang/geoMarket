package com.example.geomarket;



import java.io.Console;
import java.util.List;

import com.example.util.AnimatedTabHostListener;
import com.example.util.OnSwipeTouchListener;
import com.example.util.fragmentAdapter;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnGenericMotionListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Fragment_home extends Fragment implements ActionBar.TabListener{
	private FragmentTabHost mTabHost;
	private ViewPager mViewPager;
	private fragmentAdapter adapter;
	public Fragment_home(){}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		/*
		View rootView = inflater.inflate(R.layout.activity_fragment_home,
				container, false);*/
		
		mTabHost = new FragmentTabHost(getActivity());
		mTabHost.setup(getActivity(), getChildFragmentManager(), R.layout.activity_fragment_home);
		mTabHost.addTab(mTabHost.newTabSpec("offer").setIndicator("offer"), Fragment_offer.class, null);
		mTabHost.addTab(mTabHost.newTabSpec("map view").setIndicator("map view"), Fragment_map.class, null);
		
		//mTabHost.setOnTabChangedListener(new AnimatedTabHostListener(this.getActivity(), mTabHost));
		mTabHost.setOnTouchListener(new OnSwipeTouchListener(this.getActivity()){

			@Override
			public void onSwipeRight() {
				// TODO Auto-generated method stub
				//mTabHost.getTabWidget().getChildTabViewAt(1);
				mTabHost.setCurrentTab(1);
			}

			@Override
			public void onSwipeLeft() {
				// TODO Auto-generated method stub
				//mTabHost.getTabWidget().getChildTabViewAt(0);
				mTabHost.setCurrentTab(0);
			}
			
		});
		
		
		return mTabHost;
	}
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		mTabHost = null;
	}
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		// TODO Auto-generated method stub
		mViewPager.setCurrentItem(tab.getPosition());
	}
	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}





}

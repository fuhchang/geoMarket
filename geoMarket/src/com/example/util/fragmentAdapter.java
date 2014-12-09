package com.example.util;

import com.example.geomarket.Fragment_map;
import com.example.geomarket.Fragment_offer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class fragmentAdapter extends FragmentPagerAdapter {

	public fragmentAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Fragment fragment = null;
		switch(arg0){
		case 0:
			fragment = new Fragment_offer();
			break;
		case 1:
			fragment = new Fragment_map();
			break;
		
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

}

package com.example.geomarket;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_home extends Fragment {
	private FragmentTabHost mTabHost;
	public Fragment_home(){}
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
	        
		
		return mTabHost;
	}
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		mTabHost = null;
	}





}

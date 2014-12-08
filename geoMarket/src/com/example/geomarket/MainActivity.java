package com.example.geomarket;

import com.example.adapter.NavigationListAdapter;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends FragmentActivity {
	private ActionBarDrawerToggle navigationToggle;
    private ListView navigationList;
    private DrawerLayout navigationDrawer;
    
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH) @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Remove divider under actionbar
        getActionBar().setBackgroundDrawable(null);
        
        navigationDrawer = (DrawerLayout) findViewById(R.id.navigationDrawer);
        navigationToggle = new ActionBarDrawerToggle(this,navigationDrawer, R.drawable.ic_drawer,R.string.app_name, R.string.app_name);
        navigationDrawer.setDrawerListener(navigationToggle);
        
        this.getActionBar().setDisplayHomeAsUpEnabled(true);
        this.getActionBar().setHomeButtonEnabled(true);
        
        NavigationListAdapter navigationListAdapter = new NavigationListAdapter(this.getApplicationContext(), R.array.mainmenu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}

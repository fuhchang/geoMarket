package com.example.adapter;

import java.util.List;


import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationListAdapter extends BaseAdapter {
	
	private List<String> data;
    private LayoutInflater layoutInflater;

    public NavigationListAdapter(Context context, List<String> data) {
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }
    
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int i) {
		// TODO Auto-generated method stub
		return data.get(i);
	}

	@Override
	public long getItemId(int i) {
		// TODO Auto-generated method stub
		return i;
	}

	@Override
	public View getView(int i, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view;
		ViewHolder viewHolder;
		
		if(convertView == null){
			 view = layoutInflater.inflate(R.layout.adapter_activity_navigation, parent, false);
             viewHolder = new ViewHolder();
             viewHolder.navigationListItemTitle = (TextView) view.findViewById(R.id.navigationListItemTitle);
             viewHolder.navigationListItemIcon = (ImageView) view.findViewById(R.id.navigationListItemIcon);
             view.setTag(viewHolder);
		} else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
		String datum = data.get(i);
        viewHolder.navigationListItemTitle.setText(datum);
		return view;
	}
	
	 private class ViewHolder {
         public TextView navigationListItemTitle;
         public ImageView navigationListItemIcon;
     }
}

package com.example.adapter;

import java.util.ArrayList;

import com.example.adapter.ProAdapter.ViewHolder;
import com.example.business.Line;
import com.example.cvsebastienferrand.R;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileAdapter extends BaseAdapter{
	

	private LayoutInflater mInflater;
	private ArrayList<Line> listString;
	private Typeface vavontFont;
	
	static class ViewHolder {
		public ImageView pic;
		public TextView text;
	}

	public ProfileAdapter(Context c, ArrayList<Line> list) {
		listString = list;
		mInflater = LayoutInflater.from(c);
		vavontFont = Typeface.createFromAsset(c.getAssets(), "fonts/vavont-bolder.ttf");
	}
	
	
	@Override
	public int getCount() {
		return listString.size();
	}

	@Override
	public Object getItem(int pos) {
		return listString.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return 0;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup par) {
		
		ViewHolder holder;
		
		if (convertView == null) { 
			
			holder = new ViewHolder();
			
			convertView = mInflater.inflate(R.layout.row_content, null);
			
			holder.text = (TextView) convertView.findViewById(R.id.text);

			convertView.setTag(holder);
			
		}else{
			holder = (ViewHolder) convertView.getTag();
		}

//		holder.text.setTypeface(vavontFont);
		holder.text.setText(listString.get(pos).getText());
		
		return convertView;
	}

}

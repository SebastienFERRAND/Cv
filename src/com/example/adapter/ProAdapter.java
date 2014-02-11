package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.ProfileAdapter.ViewHolder;
import com.example.business.ContentPro;
import com.example.business.Line;
import com.example.cvsebastienferrand.R;

public class ProAdapter extends BaseAdapter{


	private LayoutInflater mInflater;
	private ArrayList<ContentPro> listString;
	private Typeface vavontFont;
	private Context context;

	static class ViewHolder {
		public TextView date;
		public ImageView point;
		public TextView description;
	}

	public ProAdapter(Context c, ArrayList<ContentPro> list) {
		context = c;
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
		return pos;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup par) {


		ViewHolder holder;

		if (convertView == null) { 

			holder = new ViewHolder();

			convertView = mInflater.inflate(R.layout.row_pro, par, false);

			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.description = (TextView) convertView.findViewById(R.id.description);

			convertView.setTag(holder);

		}else{
			holder = (ViewHolder) convertView.getTag();
		}


//		holder.description.setTypeface(vavontFont);
		holder.description.setText(listString.get(pos).getContent());

//		holder.date.setTypeface(vavontFont);
		holder.date.setText(listString.get(pos).getDate());

		return convertView;
	}

}

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

import com.example.adapter.ProAdapter.ViewHolder;
import com.example.business.ContentPro;
import com.example.business.Hobbies;
import com.example.cvsebastienferrand.R;

public class HobbiesAdapter extends BaseAdapter{


	private LayoutInflater mInflater;
	private ArrayList<Hobbies> listString;
	private Typeface vavontFont;
	private Context context;

	static class ViewHolder {
		public ImageView pic;
		public TextView title;
		public TextView description;
	}

	public HobbiesAdapter(Context c, ArrayList<Hobbies> list) {
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

			convertView = mInflater.inflate(R.layout.row_hobbies, par, false);

			holder.pic = (ImageView) convertView.findViewById(R.id.pic);

			holder.description = (TextView) convertView.findViewById(R.id.description_hob);
			holder.title = (TextView) convertView.findViewById(R.id.title_hob);

			convertView.setTag(holder);

		}else{
			holder = (ViewHolder) convertView.getTag();
		}


		holder.pic.setImageResource(listString.get(pos).getResId());

		//		holder.description.setTypeface(vavontFont);
		holder.description.setText(listString.get(pos).getDescription());

		holder.title.setText(listString.get(pos).getTitle());

		return convertView;
	}

}
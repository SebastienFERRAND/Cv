package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.business.Hobbies;
import com.example.cvsebastienferrand.R;

public class HobbiesAdapter extends BaseAdapter{


	private LayoutInflater mInflater;
	private ArrayList<Hobbies> listString;
	
	static class ViewHolder {
		public ImageView pic;
		public TextView title;
		public TextView description;
	}

	public HobbiesAdapter(Context c, ArrayList<Hobbies> list) {
		listString = list;
		mInflater = LayoutInflater.from(c);
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

		holder.title.setText(listString.get(pos).getTitle());
		
		if (listString.get(pos).getTitle().equals("Blogs")){
			holder.description.setMovementMethod(LinkMovementMethod.getInstance());
			holder.description.setText(Html.fromHtml(listString.get(pos).getDescription()));
		}else{
			holder.description.setText(listString.get(pos).getDescription());
		}

		return convertView;
	}

}
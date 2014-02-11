package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.adapter.ProAdapter.ViewHolder;
import com.example.business.ContentPro;
import com.example.business.Language;
import com.example.cvsebastienferrand.R;

public class LangueAdapter extends BaseAdapter{


	private LayoutInflater mInflater;
	private ArrayList<Language> listString;
	private Typeface vavontFont;
	private Context context;

	static class ViewHolder {
		public ImageView flag;
		public RatingBar bar;
	}

	public LangueAdapter(Context c, ArrayList<Language> list) {
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

			convertView = mInflater.inflate(R.layout.row_language, par, false);

			holder.flag = (ImageView) convertView.findViewById(R.id.flag);
			holder.flag.setImageResource(listString.get(pos).getResId());
			holder.bar = (RatingBar) convertView.findViewById(R.id.ratingBar2);

			convertView.setTag(holder);

		}else{
			holder = (ViewHolder) convertView.getTag();
		}

		holder.bar.setRating(listString.get(pos).getRating());


		return convertView;
	}

}

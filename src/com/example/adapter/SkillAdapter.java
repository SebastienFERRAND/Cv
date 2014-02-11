package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.adapter.ProfileAdapter.ViewHolder;
import com.example.business.ContentPro;
import com.example.business.Line;
import com.example.business.Skills;
import com.example.cvsebastienferrand.R;

public class SkillAdapter extends BaseAdapter{

	private LayoutInflater mInflater;
	private ArrayList<Skills> listString;

	private static final int skills = 0;
	private static final int project = 1;
	private static final int TYPE_MAX_COUNT = project + 1;

	static class ViewHolder {
		public TextView title;
		public RatingBar bar;
		public ImageView logo_project;
		public TextView title_project;
		public ImageView qrcode_project;
	}

	public SkillAdapter(Context c, ArrayList<Skills> list) {
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
	public int getItemViewType(int position) {
		int type;
		if ((position) < 8){
			type = skills;
		}else{
			type = project;
		}
		return type;
	}

	@Override
	public int getViewTypeCount() {
		return TYPE_MAX_COUNT;
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup par) {


		ViewHolder holder;
		int type = getItemViewType(pos);

		if (convertView == null) {

			holder = new ViewHolder();

			switch (type){

			case skills:

				convertView = mInflater.inflate(R.layout.row_skills, par, false);

				holder.title = (TextView) convertView.findViewById(R.id.skill_title);
				holder.bar = (RatingBar) convertView.findViewById(R.id.ratingBar);

				if (listString.get(pos).getRating() == 0){
					holder.bar.setVisibility(View.GONE);
				}else{
					holder.bar.setVisibility(View.VISIBLE);
				}

				convertView.setTag(holder);

				break;

			case project:

				convertView = mInflater.inflate(R.layout.row_realisation, par, false);

				holder.logo_project = (ImageView) convertView.findViewById(R.id.logo_project);
				holder.title_project = (TextView) convertView.findViewById(R.id.title_project);
				holder.qrcode_project = (ImageView) convertView.findViewById(R.id.qrcode_project);

				break;

			}

		}else{
			holder = (ViewHolder) convertView.getTag();
		}


		//			holder.title.setTypeface(vavontFont);
		holder.title.setText(listString.get(pos).getTitleSkill());

		if ((listString.get(pos).getTitleSkill().equals("RŽalisations : "))
				|| (listString.get(pos).getTitleSkill().equals("Language : "))
				|| (listString.get(pos).getTitleSkill().equals("Design : "))){

			((LinearLayout) holder.title.getParent()).setBackgroundColor(0xFFffa500);
			holder.title.setTextSize(22);
			holder.title.setTypeface(null, Typeface.BOLD);
		}


		holder.bar.setRating(listString.get(pos).getRating());

		return convertView;
	}




}


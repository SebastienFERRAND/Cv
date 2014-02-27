package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.business.Skills;
import com.example.cvsebastienferrand.R;

public class SkillAdapter extends BaseAdapter{

	private LayoutInflater mInflater;
	private ArrayList<Skills> listString;


	private static final int SKILL_TITLE = 0;
	private static final int SKILL_ROW = 1;
	private static final int TYPE_MAX_COUNT = SKILL_ROW + 1;

	static class ViewHolder {
		public TextView title;
		public RatingBar bar;
		public TextView title_skill;
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
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public int getViewTypeCount() {
		return TYPE_MAX_COUNT;
	}

	@Override
	public int getItemViewType(int position) {
		int type;
		if (listString.get(position).getRating() == 0){
			type = SKILL_TITLE;
		}else{
			type = SKILL_ROW;
		}
		return type;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup par) {


		ViewHolder holder= new ViewHolder();;
		int type = getItemViewType(pos);

		if (convertView == null) {


			switch (type) {

			case SKILL_ROW:

				convertView = mInflater.inflate(R.layout.row_skills, par, false);

				holder.title = (TextView) convertView.findViewById(R.id.skill_title);
				holder.bar = (RatingBar) convertView.findViewById(R.id.ratingBar);

				break;


			case SKILL_TITLE:
				convertView = mInflater.inflate(R.layout.row_big_title, par, false);

				holder.title_skill = (TextView) convertView.findViewById(R.id.title_skill);

				break;

			}

			convertView.setTag(holder);

		}else{
			holder = (ViewHolder) convertView.getTag();
		}


		switch (type) {

		case SKILL_ROW:
			
			holder.title.setText(listString.get(pos).getTitleSkill());
			holder.bar.setRating(listString.get(pos).getRating());
			
			break;

		case SKILL_TITLE:

			holder.title_skill.setText(listString.get(pos).getTitleSkill());

			break;

		}
		
		return convertView;
	}




}


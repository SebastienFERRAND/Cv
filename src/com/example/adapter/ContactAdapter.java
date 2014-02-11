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

import com.example.adapter.HobbiesAdapter.ViewHolder;
import com.example.business.Contact;
import com.example.business.Hobbies;
import com.example.cvsebastienferrand.R;

public class ContactAdapter extends BaseAdapter{


	private LayoutInflater mInflater;
	private ArrayList<Contact> listString;
	private Typeface vavontFont;
	private Context context;

	static class ViewHolder {
		public ImageView pic;
		public TextView description;
	}

	public ContactAdapter(Context c, ArrayList<Contact> list) {
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

			convertView = mInflater.inflate(R.layout.row_contact, par, false);
			holder.pic = (ImageView) convertView.findViewById(R.id.pic_contact);

			holder.description = (TextView) convertView.findViewById(R.id.contact_content);
			
			convertView.setTag(holder);

		}else{
			holder = (ViewHolder) convertView.getTag();
		}


		holder.pic.setImageResource(listString.get(pos).getResId());

//		holder.description.setTypeface(vavontFont);
		holder.description.setText(listString.get(pos).getTitle());

		return convertView;
	}

}
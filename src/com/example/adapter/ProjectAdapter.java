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

import com.example.business.Projects;
import com.example.cvsebastienferrand.R;

public class ProjectAdapter extends BaseAdapter{

	private LayoutInflater mInflater;
	private ArrayList<Projects> listString;
	
	static class ViewHolder {
		public ImageView logo_project;
		public TextView title_project;
		public TextView description_project;
		public ImageView qrcode_project;
	}

	public ProjectAdapter(Context c, ArrayList<Projects> list) {
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
			
			convertView = mInflater.inflate(R.layout.row_realisation, par, false);

			holder.logo_project = (ImageView) convertView.findViewById(R.id.logo_project);
			holder.title_project = (TextView) convertView.findViewById(R.id.title_project);
			holder.description_project = (TextView) convertView.findViewById(R.id.description_project);
			holder.qrcode_project = (ImageView) convertView.findViewById(R.id.qrcode_project);

			convertView.setTag(holder);

		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.logo_project.setBackgroundResource(listString.get(pos).getLogo());
		holder.title_project.setText(listString.get(pos).getTitle());
		holder.description_project.setText(listString.get(pos).getDescription());
		holder.qrcode_project.setBackgroundResource(listString.get(pos).getQrcode());


		holder.description_project.setMovementMethod(LinkMovementMethod.getInstance());
		holder.description_project.setText(Html.fromHtml(listString.get(pos).getDescription()));
		
		return convertView;
	}

}

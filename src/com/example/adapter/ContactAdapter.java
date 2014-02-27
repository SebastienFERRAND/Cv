package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.business.Contact;
import com.example.cvsebastienferrand.R;

public class ContactAdapter extends BaseAdapter{


	private LayoutInflater mInflater;
	private ArrayList<Contact> listString;
	private Context con;

	static class ViewHolder {
		public ImageView pic;
		public TextView description;
	}

	public ContactAdapter(Context c, ArrayList<Contact> list) {
		listString = list;
		mInflater = LayoutInflater.from(c);
		con = c;
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

		holder.description.setText(listString.get(pos).getTitle());

		if (listString.get(pos).getTitle().equals("06 51 57 91 22")){

			holder.description.setPaintFlags(holder.description.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);

			((RelativeLayout) holder.description.getParent()).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(Intent.ACTION_INSERT, 
							ContactsContract.Contacts.CONTENT_URI);
					intent.putExtra(ContactsContract.Intents.Insert.NAME, "Sébastien FERRAND");
					intent.putExtra(ContactsContract.Intents.Insert.PHONE, "06 51 57 91 22");
					intent.putExtra(ContactsContract.Intents.Insert.EMAIL, "Sebastien.ferrand.dev@gmail.com");
					intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, "Ingénieur android");
					intent.putExtra(ContactsContract.Intents.Insert.POSTAL, "406 rue de la pépinière 34000 Montpellier");
					con.startActivity(intent);

				}
			});
		}

		if (listString.get(pos).getTitle().equals("406 rue de la pépinière 34000 Montpellier")){

			holder.description.setPaintFlags(holder.description.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);

			((RelativeLayout) holder.description.getParent()).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(android.content.Intent.ACTION_VIEW, 
							Uri.parse("https://maps.google.com/"
									+ "maps?q=406+rue+de+la+p%C3%A9pini%C3%A"
									+ "8re+34000+Montpellier&hl=en&ie=UTF8&l"
									+ "l=43.617809,3.892422&spn=0.033741,0.0"
									+ "65145&hnear=406+Rue+de+la+P%C3%A9pini%"
									+ "C3%A8re,+34000+Montpellier,+H%C3%A9raul"
									+ "t,+Languedoc-Roussillon,+France&t=m&z=14&iwloc=A"));
					con.startActivity(intent);
				}
			});
		}


		if (listString.get(pos).getTitle().equals("Sebastien.ferrand.dev@gmail.com")){
			
			holder.description.setPaintFlags(holder.description.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
			
			((RelativeLayout) holder.description.getParent()).setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent i = new Intent(Intent.ACTION_SEND);
					i.setType("message/rfc822");
					i.putExtra(Intent.EXTRA_EMAIL, new String[]{"sebastien.ferrand.dev@gmail.com"});
					try {
						con.startActivity(Intent.createChooser(i, "Send mail..."));
					} catch (android.content.ActivityNotFoundException ex) {

					}
				}

			});

		}

		return convertView;
	}

}
package com.example.cvsebastienferrand;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.ContactAdapter;
import com.example.adapter.HobbiesAdapter;
import com.example.adapter.LangueAdapter;
import com.example.adapter.ProAdapter;
import com.example.adapter.ProjectAdapter;
import com.example.adapter.SkillAdapter;
import com.example.business.Contact;
import com.example.business.ContentPro;
import com.example.business.Hobbies;
import com.example.business.Language;
import com.example.business.Projects;
import com.example.business.Skills;

public class MainActivity extends Activity {

	private ArrayList<Contact> listProfil;
	private ArrayList<ContentPro> listPro;
	private ArrayList<ContentPro> listSch;
	private ArrayList<Skills> listSkills;
	private ArrayList<Language> listLangue;
	private ArrayList<Hobbies> listHobbies;
	private ArrayList<Projects> listProject;
	private ListView lv;

	private Button iconProfile;
	private Button iconPro;
	private Button iconScholar;
	private Button iconSkills;
	private Button iconMap;
	private Button iconHobbies;
	private Button iconProject;

	private Button current_b_selection;
	private int id_res_back;

	private ImageView startBul;
	private ImageView map;

	private TextView title;
	private TextView selfDescription;

	private MainActivity ma;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		ma = this;

		lv = (ListView) this.findViewById(R.id.lv_content);

		selfDescription = (TextView) findViewById(R.id.self_description);
		selfDescription.setText(ma.getResources().getString(R.string.description_of_myself));
		startBul = (ImageView) this.findViewById(R.id.bubble_1);
		map = (ImageView) this.findViewById(R.id.map);

		listProfil = new ArrayList<Contact>();
		listPro = new ArrayList<ContentPro>();
		listSch = new ArrayList<ContentPro>();
		listSkills = new ArrayList<Skills>();
		listLangue = new ArrayList<Language>();
		listHobbies = new ArrayList<Hobbies>();
		listProject = new ArrayList<Projects>();

		final int[] listIconProfil = {
				R.drawable.man_icon,
				R.drawable.cake_candle_icon,
				R.drawable.icon_house,
				R.drawable.french_flag_icon,
				R.drawable.icon_car,
				R.drawable.heart_icon,
				R.drawable.contact_icon_new,
				R.drawable.icon_mail_new,
				R.drawable.skype_icon

		};

		final String[] listTextProfil = {
				"Homme",
				"27 juillet 1989, 24 ans",
				"406 rue de la pépinière 34000 Montpellier, France",
				"Français",
				"Détenteur du permis B",
				"Célibataire",
				"06 51 57 91 22",
				"Sebastien.ferrand.dev@gmail.com",
				"Ferrand.sebastien.dev"
		};

		for (int i = 0; i < listTextProfil.length; i++){
			Contact line = new Contact();
			line.setResId(listIconProfil[i]);
			line.setTitle(listTextProfil[i]);
			listProfil.add(line);

		}


		final String[] listDatePro = {
				"2013/14\n1 an",
				"2012/13\n1 an",
				"2011\n3 mois",
				"2009/10\n1 an ",
				"2009\n3 mois",
				"2008\n3 mois"
		};

		final String[] listTextPro = {
				ma.getResources().getString(R.string.exp_paradroid),
				ma.getResources().getString(R.string.exp_adylitica),
				ma.getResources().getString(R.string.exp_scolaris),
				ma.getResources().getString(R.string.exp_pikko),
				ma.getResources().getString(R.string.exp_iufm),
				ma.getResources().getString(R.string.exp_emploi_lr)
		};


		for (int i = 0; i < listTextPro.length; i++){
			ContentPro pro = new ContentPro();
			pro.setDate(listDatePro[i]);
			pro.setContent(listTextPro[i]);
			listPro.add(pro);
		}

		final String[] listDateSch = {
				"2012",
				"2010",
				"2009",
				"2007"
		};

		final String[] listTextSch = {
				ma.getResources().getString(R.string.diplome_inge),
				ma.getResources().getString(R.string.diplome_bachelor),
				ma.getResources().getString(R.string.diplome_bts),
				ma.getResources().getString(R.string.diplome_bac)
		};


		for (int i = 0; i < listTextSch.length; i++){
			ContentPro sch = new ContentPro();
			sch.setDate(listDateSch[i]);
			sch.setContent(listTextSch[i]);
			listSch.add(sch);
		}

		final String[] listTextSkill = {
				"Language : ",
				"Java - Android",
				"SQL",
				"PHP",
				"C++",
				"Action script 3",
				"Utilitaires : ",
				"Rational rose",
				"Photoshop",
				"Gimp"
		};

		final int[] listRateSkill = {
				0,
				5,
				4,
				3,
				3,
				3,
				0,
				3,
				2,
				2
		};

		for (int i = 0; i < listTextSkill.length; i++){
			Skills sk = new Skills();
			sk.setTitleSkill(listTextSkill[i]);
			sk.setRating(listRateSkill[i]);
			listSkills.add(sk);
		}



		final int[] listLogo = {
				R.drawable.everydaynotes_icon,
				R.drawable.paradroid_alarm
		};

		final String[] listTitleProject = {
				"Everyday Notes\nAndroid",
				"Paradroid Alarm\nAndroid"
		};

		final String[] listDescriptionProject = {
				ma.getResources().getString(R.string.everyday_notes),
				ma.getResources().getString(R.string.paradroid_alarm)
		};

		final int[] listQr = {
				R.drawable.qrcode_everydaynotes,
				R.drawable.paradroid_alarm_qrcode
		};



		for (int i = 0; i < listLogo.length; i++){
			Projects pr = new Projects();
			pr.setLogo(listLogo[i]);
			pr.setTitle(listTitleProject[i]);
			pr.setDescription(listDescriptionProject[i]);
			pr.setQrcode(listQr[i]);
			listProject.add(pr);
		}


		final int[] listFlag = {
				R.drawable.french_flag_icon,
				R.drawable.uk_flag_icon,
				R.drawable.spain_flag_icon,
				R.drawable.china_flag_icon,
				R.drawable.thailand_flag_icon

		};

		final int[] listLevelLanguage = {
				5,
				5,
				2,
				2,
				2
		};

		for (int i = 0; i < listFlag.length; i++){
			Language lg = new Language();
			lg.setResId(listFlag[i]);
			lg.setRating(listLevelLanguage[i]);
			listLangue.add(lg);
		}


		final int[] listHobbiesIcon = {
				R.drawable.chess_icon,
				R.drawable.icon_sport_new,
				R.drawable.icon_music,
				R.drawable.wordpress_logo,
				R.drawable.icon_book

		};

		final String[] listTextHobbies = {
				"Professeur certifié DAFFE et expérimenté\n"
						+ "Double champion départemental\n"
						+ "Triple champion de france par équipe des collèges et lycées",
						"Tennis de table\nNatation\nKayak (Montpellier-Avignon "
								+ "réalisé dans le cadre de la lutte contre le cancer)",
								"Guitare\nChant",
								ma.getResources().getString(R.string.hobbie_desc_china) 
								+ "<br />" + ma.getResources().getString(R.string.hobbie_desc_bitcoin),
								"Steve Jobs : la vie d'un génie",
		};

		final String[] listHobbiesTitle = {
				"Echecs",
				"Sport",
				"Musique",
				"Blogs",
				"Livre"	
		};

		for (int i = 0; i < listTextHobbies.length; i++){
			Hobbies hob = new Hobbies();
			hob.setResId(listHobbiesIcon[i]);
			hob.setTitle(listHobbiesTitle[i]);
			hob.setDescription(listTextHobbies[i]);
			listHobbies.add(hob);
		}

		ContactAdapter pa = new ContactAdapter(this, listProfil);
		lv.setAdapter(pa);

		title = (TextView) this.findViewById(R.id.title);

		iconProfile = (Button) this.findViewById(R.id.profile_button);
		iconPro = (Button) this.findViewById(R.id.pro_button);
		iconScholar = (Button) this.findViewById(R.id.education_button);
		iconSkills = (Button) this.findViewById(R.id.skills_button);
		iconMap = (Button) this.findViewById(R.id.langue_button);
		iconHobbies = (Button) this.findViewById(R.id.loisir_button);
		iconProject = (Button) this.findViewById(R.id.project_button);

		current_b_selection = iconProfile;
		id_res_back = R.drawable.essai_profil_small;

		iconProfile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ContactAdapter pa = new ContactAdapter(ma, listProfil);
				lv.setAdapter(pa);
				title.setText(ma.getResources().getString(R.string.title_profile));

				setIconBackground(R.drawable.essai_profil_small, R.drawable.essai_profil_h_small, iconProfile);

				map.setVisibility(View.GONE);
				selfDescription.setVisibility(View.VISIBLE);
				setVisibility((ImageView) ma.findViewById(R.id.bubble_1));
			}
		});


		iconPro.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ProAdapter pa = new ProAdapter(ma, listPro);
				lv.setAdapter(pa);
				title.setText(ma.getResources().getString(R.string.title_pro));

				setIconBackground(R.drawable.icon_portrait_small, R.drawable.icon_portrait_h_small, iconPro);

				map.setVisibility(View.GONE);
				selfDescription.setVisibility(View.GONE);
				setVisibility((ImageView) ma.findViewById(R.id.bubble_2));
			}
		});

		iconScholar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ProAdapter pa = new ProAdapter(ma, listSch);
				lv.setAdapter(pa);
				title.setText(ma.getResources().getString(R.string.title_sch));

				setIconBackground(R.drawable.education_icon_small, R.drawable.education_icon_h_small, iconScholar);

				map.setVisibility(View.GONE);
				selfDescription.setVisibility(View.GONE);
				setVisibility((ImageView) ma.findViewById(R.id.bubble_3));
			}
		});

		iconSkills.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SkillAdapter pa = new SkillAdapter(ma, listSkills);
				lv.setAdapter(pa);
				title.setText(ma.getResources().getString(R.string.title_skill));

				setIconBackground(R.drawable.skill_icon_small, R.drawable.skill_icon_h_small, iconSkills);

				setVisibility((ImageView) ma.findViewById(R.id.bubble_4));

				map.setVisibility(View.GONE);
				selfDescription.setVisibility(View.GONE);
			}
		});


		iconProject.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ProjectAdapter pa = new ProjectAdapter(ma, listProject);
				lv.setAdapter(pa);
				title.setText(ma.getResources().getString(R.string.title_project));

				setIconBackground(R.drawable.project_icon_small, R.drawable.project_icon_h_small, iconProject);

				setVisibility((ImageView) ma.findViewById(R.id.bubble_5));
				map.setVisibility(View.GONE);
				selfDescription.setVisibility(View.GONE);
			}
		});

		iconMap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				LangueAdapter pa = new LangueAdapter(ma, listLangue);
				lv.setAdapter(pa);
				title.setText(ma.getResources().getString(R.string.title_map));

				setIconBackground(R.drawable.map_icon_small, R.drawable.map_icon_h_small, iconMap);

				setVisibility((ImageView) ma.findViewById(R.id.bubble_6));
				map.setVisibility(View.VISIBLE);
				selfDescription.setVisibility(View.GONE);

			}
		});

		iconHobbies.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				HobbiesAdapter pa = new HobbiesAdapter(ma, listHobbies);
				lv.setAdapter(pa);

				setIconBackground(R.drawable.dice_small, R.drawable.dice_h_small, iconHobbies);

				title.setText(ma.getResources().getString(R.string.title_hobbies));
				setVisibility((ImageView) ma.findViewById(R.id.bubble_7));

				map.setVisibility(View.GONE);
				selfDescription.setVisibility(View.GONE);
			}
		});


		return true;
	}

	public void setVisibility(ImageView iv){
		startBul.setVisibility(View.INVISIBLE);
		startBul = iv;
		startBul.setVisibility(View.VISIBLE);
	}

	public void setIconBackground(int resIdOld, int resIdNew, Button but){

		if(resIdOld != id_res_back){

			but.setBackgroundResource(resIdNew);

			current_b_selection.setBackgroundResource(id_res_back);

			current_b_selection = but;
			id_res_back = resIdOld;
		}
	}

}

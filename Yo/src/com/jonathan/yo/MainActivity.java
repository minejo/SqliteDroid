package com.jonathan.yo;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public DBManager dbHelper;
	Spinner spinner1 = null;
	EditText edit1 = null;
	Button button1 = null;
	ListView list1 = null;
	TextView count = null;
	List<Map<String, Object>> shortlist = null;
	SimpleAdapter listItemAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dbHelper = new DBManager(this);
		dbHelper.openDatabase();

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		edit1 = (EditText) findViewById(R.id.editText1);
		button1 = (Button) findViewById(R.id.button1);
		list1 = (ListView) findViewById(R.id.listView);
		count = (TextView) findViewById(R.id.count);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter
				.createFromResource(this, R.array.dr,
						android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		dbHelper.closeDatabase();
	}

	public void onClick(View view) {
		dbHelper.count = 0;
		String spinner_choice = spinner1.getSelectedItem().toString();
		String input = edit1.getText().toString();

		if (!input.trim().equals("")) {
			if (spinner_choice.equals("姓名")) {
				shortlist = dbHelper.getByName(input);

			} else if (spinner_choice.equals("學號")) {
				PersonBean person = dbHelper
						.getByStunum(Integer.valueOf(input));

				Intent intent1 = new Intent();

				intent1.putExtra("stunum", input);
				intent1.putExtra("name", person.getName());
				intent1.putExtra("classnum",
						String.valueOf(person.getClassnum()));
				intent1.putExtra("boss", person.getBoss());
				intent1.putExtra("gender", person.getGender());
				intent1.putExtra("major", person.getMajor());
				intent1.putExtra("field", person.getField());
				intent1.putExtra("birthday", person.getBirthday());
				intent1.putExtra("poliface", person.getPoliface());
				intent1.putExtra("address", person.getAddress());
				intent1.putExtra("phone", person.getPhone());
				intent1.putExtra("qq", person.getQq());
				intent1.putExtra("email", person.getEmail());
				intent1.putExtra("grashcool", person.getGraschool());
				intent1.putExtra("homeaddress", person.getHomeaddress());
				intent1.putExtra("huji", person.getHuji());
				intent1.putExtra("type", person.getType());
				intent1.putExtra("religon", person.getReligon());
				intent1.putExtra("mingzu", person.getMingzu());

				intent1.setClass(MainActivity.this, DetailActivity.class);

				startActivity(intent1);

			} else if (spinner_choice.equals("班級")) {
				shortlist = dbHelper.getByClass(Integer.valueOf(input));

			} else if (spinner_choice.equals("導師")) {
				shortlist = dbHelper.getByBoss(input);

			} else if (spinner_choice.equals("性別")) {
				shortlist = dbHelper.getByGender(input);
			}
				else if (spinner_choice.equals("找老乡")) {
					shortlist = dbHelper.getByZuji(input);				

			}else if (spinner_choice.equals("政治面貌")) {
				shortlist = dbHelper.getByPoliFace(input);

			} 
			else if( spinner_choice.equals("民族"))
			{
				shortlist =dbHelper.getByMingzu(input);
			}
		}

          if(input.trim().equals(""))
		{
			Log.i("ttt", input);
			shortlist = dbHelper.getAll();
		}

		if (shortlist != null) {
			count.setText("共有" + dbHelper.count + "条记录");
			listItemAdapter = new SimpleAdapter(
					this,
					shortlist,
					R.layout.item,
					new String[] { "name", "stunum", "boss", "gender" },
					new int[] { R.id.name, R.id.stunum, R.id.boss, R.id.gender });
			list1.setAdapter(listItemAdapter);

			list1.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					int stunum = Integer.valueOf(shortlist.get(arg2)
							.get("stunum").toString());

					PersonBean person = dbHelper.getByStunum(stunum);

					// Log.i("tttT", String.valueOf(stunum));
					Intent intent1 = new Intent();

					intent1.putExtra("stunum", String.valueOf(stunum));
					intent1.putExtra("name", person.getName());
					intent1.putExtra("classnum",
							String.valueOf(person.getClassnum()));
					intent1.putExtra("boss", person.getBoss());
					intent1.putExtra("gender", person.getGender());
					intent1.putExtra("major", person.getMajor());
					intent1.putExtra("field", person.getField());
					intent1.putExtra("birthday", person.getBirthday());
					intent1.putExtra("poliface", person.getPoliface());
					intent1.putExtra("address", person.getAddress());
					intent1.putExtra("phone", person.getPhone());
					intent1.putExtra("qq", person.getQq());
					intent1.putExtra("email", person.getEmail());
					intent1.putExtra("grashcool", person.getGraschool());
					intent1.putExtra("homeaddress", person.getHomeaddress());
					intent1.putExtra("huji", person.getHuji());
					intent1.putExtra("type", person.getType());
					intent1.putExtra("religon", person.getReligon());
					intent1.putExtra("mingzu", person.getMingzu());

					intent1.setClass(MainActivity.this, DetailActivity.class);

					startActivity(intent1);

				}
			});
		} else
			count.setText("共有" + dbHelper.count + "条记录");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, AboutAuthorActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}

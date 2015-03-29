package com.jonathan.yo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends Activity {

	TextView name = null; // 姓名
	TextView phone = null; // 手机
	TextView classnum = null; // 班级
	TextView stunum = null; // 学号
	TextView major = null; // 专业
	TextView field = null; // 方向
	TextView gender = null; // 性别
	TextView birthday = null; // 生日
	TextView boss = null; // 导师
	TextView mingzu = null; // 民族
	TextView religon = null; // 宗教信仰
	TextView poliface = null; // 政治面貌
	TextView address = null; // 宿舍
	TextView qq = null; // QQ
	TextView email = null; // E-mail
	TextView graschool = null; // 毕业学校
	TextView homeaddress = null; // 家庭住址
	TextView huji = null; // 户籍
	TextView type = null; // 入学类型

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);

		stunum = (TextView) findViewById(R.id.detailstunum);
		name = (TextView) findViewById(R.id.detailname);
		phone = (TextView) findViewById(R.id.detailphone);
		classnum = (TextView) findViewById(R.id.detailclass);
		major = (TextView) findViewById(R.id.detailmajor);
		field = (TextView) findViewById(R.id.detailfield);
		gender = (TextView) findViewById(R.id.detailgender);
		birthday = (TextView) findViewById(R.id.detailbirthday);
		boss = (TextView) findViewById(R.id.deteailboss);
		mingzu = (TextView) findViewById(R.id.detailmingzu);
		religon = (TextView) findViewById(R.id.detailreligon);
		poliface = (TextView) findViewById(R.id.detailpoliface);
		address = (TextView) findViewById(R.id.detailaddress);
		qq = (TextView) findViewById(R.id.detailqq);
		email = (TextView) findViewById(R.id.detailemail);
		graschool = (TextView) findViewById(R.id.detailgraschool);
		homeaddress = (TextView) findViewById(R.id.detialhomeaddress);
		huji = (TextView) findViewById(R.id.deailhuji);
		type = (TextView) findViewById(R.id.detailtype);

		Intent intent1 = getIntent();
		stunum.setText(intent1.getStringExtra("stunum"));
		name.setText(intent1.getStringExtra("name"));
		classnum.setText(intent1.getStringExtra("classnum"));
		boss.setText(intent1.getStringExtra("boss"));
		gender.setText(intent1.getStringExtra("gender"));
		major.setText(intent1.getStringExtra("major"));
		field.setText(intent1.getStringExtra("field"));
		
		birthday.setText(Deldot(intent1.getStringExtra("birthday")));		
		poliface.setText(intent1.getStringExtra("poliface"));
		address.setText(Deldot(intent1.getStringExtra("address")));
		phone.setText(Deldot(intent1.getStringExtra("phone")));
		qq.setText(Deldot(intent1.getStringExtra("qq")));
		email.setText(intent1.getStringExtra("email"));
		graschool.setText(intent1.getStringExtra("grashcool"));
		homeaddress.setText(intent1.getStringExtra("homeaddress"));
		huji.setText(intent1.getStringExtra("huji"));
		type.setText(intent1.getStringExtra("type"));
		religon.setText(intent1.getStringExtra("religon"));
		mingzu.setText(intent1.getStringExtra("mingzu"));

	}
	
	public String Deldot(String s)
	{
		if(s.endsWith(".0"))
		{
			s = s.replace(".0", "");
		}
		return s;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
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
			intent.setClass(DetailActivity.this, AboutAuthorActivity.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

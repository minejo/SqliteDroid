package com.jonathan.yo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

public class DBManager {
	private final int BUFFER_SIZE = 400000;
	public static final String DB_NAME = "yoinfo.db"; // ��������ݿ��ļ���
	public static final String PACKAGE_NAME = "com.jonathan.yo";
	public static final String DB_PATH = "/data"
			+ Environment.getDataDirectory().getAbsolutePath() + "/"
			+ PACKAGE_NAME; // ���ֻ��������ݿ��λ��

	// Contacts table name
	public static final String TABLE_NAME = "yoinfo";

	// Contacts Table Columns names

	public static final String KEY_NAME = "name"; // ����
	public static final String KEY_PHONE = "phone"; // �ֻ�
	public static final String KEY_CLASSNUM = "class"; // �༶
	public static final String KEY_STUNUM = "stunum"; // ѧ��
	public static final String KEY_MAJOR = "major"; // רҵ
	public static final String KEY_FIELD = "field"; // ����
	public static final String KEY_GENDER = "gender"; // �Ա�
	public static final String KEY_BIRTHDAY = "birthday"; // ����
	public static final String KEY_BOSS = "boss"; // ��ʦ
	public static final String KEY_MINGZU = "mingzu"; // ����
	public static final String KEY_RELIGON = "religon"; // �ڽ�����
	public static final String KEY_POLIFACE = "poliface"; // ������ò
	public static final String KEY_ADDRESS = "address"; // ����
	public static final String KEY_QQ = "qq"; // QQ
	public static final String KEY_EMAIL = "email"; // E-mail
	public static final String KEY_GRASCHOOL = "graschool"; // ��ҵѧУ
	public static final String KEY_HOMEADDRESS = "homeaddress"; // ��ͥסַ
	public static final String KEY_HUJI = "huji"; // ����
	public static final String KEY_TYPE = "type"; // ��ѧ����
	
	public static int count = 0;	

	public static final String[] short_column = { KEY_NAME, KEY_STUNUM,
			KEY_BOSS, KEY_GENDER };

	private SQLiteDatabase database;
	private Context context;

	public DBManager(Context context) {
		this.context = context;
	}

	public void openDatabase() {
		this.database = this.openDatabase(DB_PATH + "/" + DB_NAME);
	}

	private SQLiteDatabase openDatabase(String dbfile) {
		try {
			if (!(new File(dbfile).exists())) {// �ж����ݿ��ļ��Ƿ���ڣ�����������ִ�е��룬����ֱ�Ӵ����ݿ�
				InputStream is = this.context.getResources().openRawResource(
						R.raw.yoinfo); // ����������ݿ�
				FileOutputStream fos = new FileOutputStream(dbfile);
				byte[] buffer = new byte[BUFFER_SIZE];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}
				fos.close();
				is.close();
			}
			SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile,
					null);
			return db;
		} catch (FileNotFoundException e) {
			Log.e("Database", "File not found");
			e.printStackTrace();
		} catch (IOException e) {
			Log.e("Database", "IO exception");
			e.printStackTrace();
		}
		return null;
	}

	public PersonBean getByStunum(int stunum) {

		Cursor cursor = database.query(DBManager.TABLE_NAME, null,
				DBManager.KEY_STUNUM + "=?",
				new String[] { String.valueOf(stunum) }, null, null,
				DBManager.KEY_STUNUM);
		if (cursor != null) {
			cursor.moveToFirst();
		}

		PersonBean person = new PersonBean(cursor);

		return person;

	}

	public List<Map<String, Object>> getList(Cursor cursor) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		if (cursor.moveToFirst()) {
			do {
				count = cursor.getCount();
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", cursor.getString(0));
				map.put("stunum", String.valueOf(cursor.getInt(1)));
				map.put("boss", cursor.getString(2));
				map.put("gender", cursor.getString(3));
				list.add(map);

			} while (cursor.moveToNext());			
		}
		return list;
	}

	public List<Map<String, Object>> getByClass(int classnum) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cursor cursor = database.query(TABLE_NAME, short_column, KEY_CLASSNUM
				+ "=?", new String[] { String.valueOf(classnum) }, null, null,
				KEY_STUNUM);
		list = getList(cursor);

		return list;
	}
	
	public List<Map<String, Object>> getByBoss(String boss)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cursor cursor = database.query(TABLE_NAME, short_column, KEY_BOSS
				+ "=?", new String[] { boss }, null, null,
				KEY_STUNUM);
		list = getList(cursor);
		return list;
	}
	
	public List<Map<String, Object>> getByName(String name)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cursor cursor = database.query(TABLE_NAME, short_column, KEY_NAME
				+ "=?", new String[] { name }, null, null,
				KEY_STUNUM);
		list = getList(cursor);
		return list;
	}
	
	public List<Map<String, Object>> getByPoliFace(String face)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cursor cursor = database.query(TABLE_NAME, short_column, KEY_POLIFACE + " like '%" + face +"%'"
				, null, null, null,
				KEY_STUNUM);
		list = getList(cursor);
		return list;
	}
	
	public List<Map<String, Object>> getByGender(String gender)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cursor cursor = database.query(TABLE_NAME, short_column, KEY_GENDER
				+ "=?", new String[] { gender }, null, null,
				KEY_STUNUM);
		list = getList(cursor);
		return list;
	}
	
	public List<Map<String, Object>> getByBirthday(String birthday)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cursor cursor = database.query(TABLE_NAME, short_column, KEY_BIRTHDAY
				+ "=?", new String[] { birthday }, null, null,
				KEY_STUNUM);
		list = getList(cursor);
		return list;
	}
	
	public List<Map<String, Object>> getByZuji(String zuji)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cursor cursor = database.query(TABLE_NAME, short_column, KEY_HOMEADDRESS + " like '%" + zuji +"%'"
				, null, null, null,
				KEY_STUNUM);
		list = getList(cursor);
		return list;
	}
	
	public List<Map<String, Object>> getByMingzu(String mingzu)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cursor cursor = database.query(TABLE_NAME, short_column, KEY_MINGZU + " like '%" + mingzu +"%'"
				, null, null, null,
				KEY_STUNUM);
		list = getList(cursor);
		return list;
	}
	
	public List<Map<String, Object>> getAll()
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Cursor cursor = database.query(TABLE_NAME, short_column, null
				, null, null, null,
				KEY_STUNUM);
		list = getList(cursor);
		return list;
	}

	public static int getCount() {
		return count;
	}
	
	public void closeDatabase() {
		this.database.close();
	}

}

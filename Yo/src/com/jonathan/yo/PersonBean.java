package com.jonathan.yo;

import android.database.Cursor;
import android.util.Log;

public class PersonBean {
	
	int classnum; //�༶
	int stunum; //ѧ��
	String name; //����	  
    String major; //רҵ
    String field; //����
    String gender; //�Ա�
    String birthday; //����
    String boss; //��ʦ
    String mingzu; //����
    String religon; //�ڽ�����
    String poliface; //������ò
    String address; //����
    String phone; //�ֻ�
    String qq;  //QQ
    String email; //E-mail
    String graschool; //��ҵѧУ
    String homeaddress; //��ͥסַ
    String huji; //����
    String type; //��ѧ����
    
    public PersonBean(Cursor cursor)
    {
    	this.classnum = cursor.getInt(0);
    	this.stunum = cursor.getInt(1);
    	Log.i("ttt", String.valueOf(classnum));
    	this.name = cursor.getString(2);
    	this.major = cursor.getString(3);
    	this.field = cursor.getString(4);
    	this.gender = cursor.getString(5);
    	this.birthday = cursor.getString(6);
    	this.boss = cursor.getString(7);
    	this.mingzu = cursor.getString(8);
    	this.religon = cursor.getString(9);
    	this.poliface = cursor.getString(10);
    	this.address = cursor.getString(11);
    	this.phone = cursor.getString(12);
    	this.qq = cursor.getString(13);
    	this.email = cursor.getString(14);
    	this.graschool = cursor.getString(15);
    	this.homeaddress = cursor.getString(16);
    	this.huji = cursor.getString(17);
    	this.type = cursor.getString(18);
    	
    }
    
    public PersonBean(int classnum,int stunum,String name)
    {
    	this.classnum = classnum;
    	this.stunum = stunum;
    	this.name = name;
    	
    }
    
	public int getClassnum() {
		return classnum;
	}
	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}
	public int getStunum() {
		return stunum;
	}
	public void setStunum(int stunum) {
		this.stunum = stunum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public String getMingzu() {
		return mingzu;
	}
	public void setMingzu(String mingzu) {
		this.mingzu = mingzu;
	}
	public String getReligon() {
		return religon;
	}
	public void setReligon(String religon) {
		this.religon = religon;
	}
	public String getPoliface() {
		return poliface;
	}
	public void setPoliface(String poliface) {
		this.poliface = poliface;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGraschool() {
		return graschool;
	}
	public void setGraschool(String graschool) {
		this.graschool = graschool;
	}
	public String getHomeaddress() {
		return homeaddress;
	}
	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}
	public String getHuji() {
		return huji;
	}
	public void setHuji(String huji) {
		this.huji = huji;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}

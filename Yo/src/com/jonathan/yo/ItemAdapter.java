package com.jonathan.yo;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<PersonBean>{

	private final Context context;
	private final ArrayList<PersonBean> values;
	public ItemAdapter(Context context, ArrayList<PersonBean> values) {
		super(context,R.layout.item,values);
		this.context = context;
		this.values = values;
		// TODO Auto-generated constructor stub
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		  LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    View rowView = inflater.inflate(R.layout.item, parent, false);
			    TextView name = (TextView) rowView.findViewById(R.id.name);
			    TextView stunum = (TextView) rowView.findViewById(R.id.stunum);
			    TextView boss = (TextView) rowView.findViewById(R.id.boss);
			    name.setText(values.get(position).getName());
			    stunum.setText(values.get(position).getStunum());
			    stunum.setText(values.get(position).getBoss());
			   
		return rowView;
	}
	
	

	

}

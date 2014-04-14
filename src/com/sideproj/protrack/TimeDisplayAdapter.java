
	package com.sideproj.protrack;

	import java.util.ArrayList;

	import android.content.Context;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.widget.ArrayAdapter;
	import android.widget.TextView;

	public class TimeDisplayAdapter extends ArrayAdapter<JobEntry>{
		Context context;
		int layoutResourceId;
		ArrayList<JobEntry> data = new ArrayList<JobEntry>(0);
		

		public TimeDisplayAdapter(Context cont, int res, ArrayList<JobEntry> data)
		{
			super(cont,res,data);
			context = cont;
			layoutResourceId = res;
			this.data=data;	
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{	View row = convertView;
			 
			if( row == null)
			{
				LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				//LayoutInflater inflater = ((Activity)context).getLayoutInflater();
				row = inflater.inflate(layoutResourceId, parent,false);
				TextView txtView = (TextView) row.findViewById(R.id.txtName);
				txtView.setText(data.get(position).getName());
				
			}
			else {
				
			}
			return row;
		}
	}


package com.sideproj.protrack;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Manage_job extends Activity{

	private ArrayList<TimeEntry> timeList = new ArrayList<TimeEntry>(0); //holds a list of times for each job
	static final int ADD_JOB_REQUEST = 1;
	static final int RESULT_CORRECT = 0;
	JobNameAdapter adapter;
	ListView timelistview;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_jobs);
		/*
	    adapter = new JobNameAdapter(this,
	            R.layout.timeList view_row, timeList );
	    timeList View = (ListView)findViewById(R.id.timeList View);
	    timeList View.setAdapter(adapter);
	    timeList View.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		//Sets up the action bar
		//setupActionBar();
	    try {
			timeList View.setOnItemClickListener(new OnItemClickListener() {
				public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
					JobEntry job = (JobEntry) timeList View.getItemAtPosition(position);
					String txt = job.getName();
					String pos = job.getPos();
					String add = job.getDes();
					System.out.println("We did it!!! txt: "+ txt +"pos: "+pos);
					
				}
			});
		} catch (ActivityNotFoundException safe) {
			Log.e("Add_job.onCreate", "Activity Not Found", safe);
		}
		*/
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.job_actions, menu);
		getMenuInflater().inflate(R.menu.jobs, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		System.out.println("we have pressed something "+item.toString());
	//Handle presses on the action bar items
		switch (item.getItemId())
			{
				case R.id.action_add:
				{	
					onPause();
				
					//Now launch the "add" activity when the "plus-sign" is hit 
					Intent jobEntryForm = new Intent (this, Add_job.class);
					startActivityForResult(jobEntryForm,ADD_JOB_REQUEST);
					
					return true;
				}
					/*
				case R.id.timeList View:
				{
					String txt = String.valueOf(timeList View.getCheckedItemCount());
					System.out.println("We did it!!! txt: "+ txt);
					//openSettings();
					return true;
				}
				*/
				default:
					return super.onOptionsItemSelected(item);
			
			}
	}
	

	
	public void onPause()
	{
		super.onPause();
		
	}
	
	  protected void onRestoreInstanceState(Bundle savedInstanceState) {
		    super.onRestoreInstanceState(savedInstanceState);
	  }
    protected void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
	}
	
	
	/**
	 * add a textview
	*/
	public void addJobEntry(JobEntry aJob)
	{
		//timeList .add(aJob);
	/*
	TextView textView =(TextView)findViewById(R.id.job1);
	textView.setClickable(true);
	textView.setMovementMethod(LinkMovementMethod.getInstance());
	String text = "<a href='http://www.google.com'> Google </a>";
	textView.setText(Html.fromHtml(text));
	*/
	}
	public void addJobView(int entry)
	{
		//TextView textView =(TextView)findViewById(R.id.test_button);
		//textView.setClickable(true);
		//textView.setMovementMethod(LinkMovementMethod.getInstance());
		//String text = "<a href='http://www.google.com'> Google </a>";
		//textView.setText(timeList .get(entry).getName());
		//textView.setText("example Job Kirk");
		
	}

	
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	
        if (requestCode == ADD_JOB_REQUEST) {
        	if (resultCode == RESULT_CORRECT) {
            	//A new job was successfully added and now we add the entry and save it
  /*
        		String name = data.getStringExtra("returnedJobName");
            	String title = data.getStringExtra("returnedJobTitle");
            	String address = data.getStringExtra("returnedAddress");
            	String employer = data.getStringExtra("returnedEmployer");
            	String description = data.getStringExtra("returnedDescription");            	
            	timeList .add(new JobEntry(timeList .size(),name,title,employer,description));
            	addJobView(0);
    */        	
            }
        }
        
        adapter.notifyDataSetChanged();
    }
	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
	
	
	
	

}

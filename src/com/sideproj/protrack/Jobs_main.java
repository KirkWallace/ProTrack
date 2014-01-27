package com.sideproj.protrack;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Jobs_main extends Activity {

	private ArrayList<JobEntry> jobList = new ArrayList<JobEntry>(0); //holds a list of jobs for the user to access
	static final int ADD_JOB_REQUEST = 1;
	static final int RESULT_CORRECT = 0;
	//Jobs_main creates a list of jobs that launch new Activities like 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jobs);
		
		//Sets up the action bar
		//setupActionBar();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.job_actions, menu);

		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
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
				case R.id.action_settings:
					//openSettings();
					return true;
				*/	
				default:
					return super.onOptionsItemSelected(item);
			
			}
	}
	

	
	
	
	
	/**
	 * add a textview
	*/
	public void addJobEntry(JobEntry aJob)
	{
		jobList.add(aJob);
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
		TextView textView =(TextView)findViewById(R.id.test_button);
		textView.setClickable(true);
		//textView.setMovementMethod(LinkMovementMethod.getInstance());
		//String text = "<a href='http://www.google.com'> Google </a>";
		textView.setText(jobList.get(entry).getName());
		//textView.setText("example Job Kirk");
		
	}

	
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	System.out.println("we are back");
        if (requestCode == ADD_JOB_REQUEST) {
        	System.out.println("we are in first if");
            if (resultCode == RESULT_CORRECT) {
            	System.out.println("we are in second if");
            	//A new job was successfully added and now we add the entry and save it
            	String name = data.getStringExtra("returnedJobName");
            	String title = data.getStringExtra("returnedJobTitle");
            	String address = data.getStringExtra("returnedAddress");
            	String employer = data.getStringExtra("returnedEmployer");
            	String description = data.getStringExtra("returnedDescription");
            	System.out.println("we are done getting data");
            	jobList.add(new JobEntry(jobList.size(),name,title,employer,description));
            	System.out.println("we are now adding data");
            	addJobView(0);
            	
            }
        }
        System.out.println("we are finished");

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

package com.sideproj.protrack;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Add_time extends Activity{
	static final int RESULT_CORRECT = 0;

	// Jobs_main creates a list of jobs that launch new Activities like
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_job_layout);

		try {
			Button addJobB = (Button) findViewById(R.id.addJobButton);
			addJobB.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					addJob();
				}
				
			});
			Button clearFormB = (Button) findViewById(R.id.clearFormButton);
			clearFormB.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					clear();
				}
				
			});
		} catch (ActivityNotFoundException safe) {
			Log.e("Add_job.onCreate", "Activity Not Found", safe);
		}


	}



	protected void clear() {
		//remove all populated fields in the form and redraw
		EditText editText = (EditText) findViewById(R.id.jobName);
		editText.setText(null);
		editText = (EditText) findViewById(R.id.jobTitle);
		editText.setText(null);
		editText = (EditText) findViewById(R.id.address);
		editText.setText(null);
		editText = (EditText) findViewById(R.id.employer);
		editText.setText(null);
		editText = (EditText) findViewById(R.id.description);
		editText.setText(null);
	}



	public void addJob() {
	 // Pull information from the form
		// jobName
		EditText editText = (EditText) findViewById(R.id.jobName);
		String jobName = editText.getText().toString();

		// position: jobTitle
		editText = (EditText) findViewById(R.id.jobTitle);
		String jobTitle = editText.getText().toString();

		// address
		editText = (EditText) findViewById(R.id.address);
		String address = editText.getText().toString();

		// address
		editText = (EditText) findViewById(R.id.employer);
		String employer = editText.getText().toString();

		// address
		editText = (EditText) findViewById(R.id.description);
		String description = editText.getText().toString();

		Intent returnTheJob = new Intent();
		returnTheJob.putExtra("returnedJobName", jobName);
		returnTheJob.putExtra("returnedJobTitle", jobTitle);
		returnTheJob.putExtra("returnedAddress", address);
		returnTheJob.putExtra("returnedEmployer", employer);
		returnTheJob.putExtra("returnedDescription", description);
		setResult(RESULT_CORRECT, returnTheJob);
		finish();
		// Intent intent = getParentActivityIntent();
		/*
		 * Intent intent = new Intent (this, DisplayMessageActivity.class);
		 * EditText editText = (EditText) findViewById(R.id.edit_message);
		 * String message = editText.getText().toString();
		 * intent.putExtra(EXTRA_MESSAGE,message); startActivity(intent);
		 */
	}



}

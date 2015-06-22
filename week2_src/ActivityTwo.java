package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// tod0
	// Create variables named 	
	// mCreate, mRestart, mStart and mResume 	
	// to count calls to onCreate(), onRestart(), onStart() and
	// onResume(). These variables should not be defined as static.
	
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called.
	
     static int mCreate, mRestart, mStart, mResume;
	
	
	// tod0 Create variables for each of the TextViews
	// named  mTvCreate, mTvRestart, mTvStart, mTvResume.
	// for displaying the current count of each counter variable

    TextView mTvCreate, mTvRestart, mTvStart, mTvResume;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// tod0 Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);
		

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
                // tod0
                // This function closes Activity Two
                // Hint: use Context's finish() method

                //Intent a2CloseIntent = new Intent(getApplicationContext(), ActivityTwo.class);
                finish();
            }
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {

			// tod0
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable

            mCreate = savedInstanceState.getInt("onCreate");
            mStart = savedInstanceState.getInt("onStart");
            mResume = savedInstanceState.getInt("onResume");
            mRestart = savedInstanceState.getInt("onRestart");

		}

		// Emit LogCat message
		Log.i(TAG, "Entered the onCreate() method");

		// tod0
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method

        mCreate+=1;
        displayCounts();
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStart() method");

		// tod0
		// Update the appropriate count variable
		// Update the user interface

        mStart+=1;
        displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();

		// Emit LogCat message
		Log.i(TAG, "Entered the onResume() method");

		// tod0
		// Update the appropriate count variable
		// Update the user interface

        mResume+=1;
        displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();

		// Emit LogCat message
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();

		// Emit LogCat message
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// Emit LogCat message
		Log.i(TAG, "Entered the onRestart() method");

		// tod0
		// Update the appropriate count variable
		// Update the user interface

        mRestart+=1;
        displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// Emit LogCat message
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// tod0
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable

        savedInstanceState.putInt("onCreate", mCreate);
        savedInstanceState.putInt("onStart", mStart);
        savedInstanceState.putInt("onResume", mResume);
        savedInstanceState.putInt("onRestart", mRestart);
	}

	// Updates the displayed counters
	// This method expects that the counters and TextView variables use the
	// names
	// specified above
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	}
}

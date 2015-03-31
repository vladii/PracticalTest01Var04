package ro.pub.cs.systems.pdsd.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class PracticalTest01Var04SecondaryActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get text from intent from parent
		Intent intentFromParent = getIntent();
		Bundle data = intentFromParent.getExtras();
		
		// Check text
		String text = data.getString("notes");
		Boolean ok = false;
		Log.d("Colocviu", text);
		if ("Do, Mi, Sol, Do'".equals(text)) {
			ok = true;
		}
		
		// Send results back to parent via an intent
		Intent intentToParent = new Intent();
		intentToParent.putExtra("notes", ok);
		setResult(RESULT_OK, intentToParent);
		
		finish();
	}
}

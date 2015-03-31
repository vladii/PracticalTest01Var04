package ro.pub.cs.systems.pdsd.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01Var04MainActivity extends Activity {

	private final static int[] buttons = {R.id.navigate, R.id.do1, R.id.mi, R.id.sol, R.id.do2};
	private final static int INTENT_CODE = 2015;
	private int nrTotalTry = 0;
	private int nrCorrect = 0;
	private int nrWrong = 0;
	
	
	protected ButtonListener buttonListener = new ButtonListener();
	
	protected class ButtonListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			EditText editText = (EditText)findViewById(R.id.notes);
			
			switch (v.getId()) {
				case R.id.navigate:
					// Send intent to check results
					Log.d("Colocviu", "1");
					Intent intent = new Intent(PracticalTest01Var04MainActivity.this,
											PracticalTest01Var04SecondaryActivity.class);
					Log.d("Colocviu", "2");
					intent.putExtra("notes", editText.getText().toString());
					Log.d("Colocviu", "3");
					startActivityForResult(intent, INTENT_CODE);
					Log.d("Colocviu", "4");
					
					// Clear edit text
					editText.setText("");
					Log.d("Colocviu", "5");
					
					break;
					
				default:
					Button clickedButton = (Button) findViewById(v.getId());
					
					String newText = editText.getText().toString();
					
					if (newText.length() > 0) {
						newText += ", ";
					}
					newText += clickedButton.getText();
					
					editText.setText(newText);
					
					break;
			}
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		switch (requestCode) {
			case INTENT_CODE:
				nrTotalTry ++;
				
				Bundle data = intent.getExtras();
				if (data.getBoolean("notes") == true) {
					nrCorrect ++;
				} else {
					nrWrong ++;
				}
				
				Toast.makeText(this, "Total: " + nrTotalTry +
									 ", Correct: " + nrCorrect +
									 ", Wrong: " + nrWrong, Toast.LENGTH_LONG).show();
				break;
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);
        
        // Restore previous state
        if (savedInstanceState != null) {
        	nrTotalTry = savedInstanceState.getInt("nrTotalTry", -1);
        	nrCorrect = savedInstanceState.getInt("nrCorrect", -1);
        	nrWrong = savedInstanceState.getInt("nrWrong", -1);
        }
        
        Log.d("Colocviu", nrTotalTry + ": " + nrCorrect + " + " + nrWrong);
        
        // Set listeners for all buttons
        for (int i = 0; i < buttons.length; i++) {
        	Button button = (Button)findViewById(buttons[i]);
        	button.setOnClickListener(buttonListener);
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
    	savedInstanceState.putInt("nrTotalTry", nrTotalTry);
    	savedInstanceState.putInt("nrCorrect", nrCorrect);
    	savedInstanceState.putInt("nrWrong", nrWrong);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var04_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

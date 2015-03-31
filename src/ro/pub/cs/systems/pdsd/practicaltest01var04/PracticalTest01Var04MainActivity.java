package ro.pub.cs.systems.pdsd.practicaltest01var04;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var04MainActivity extends Activity {

	private final static int[] buttons = {R.id.do1, R.id.mi, R.id.sol, R.id.do2};
	
	protected ButtonListener buttonListener = new ButtonListener();
	
	protected class ButtonListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			EditText editText = (EditText)findViewById(R.id.notes);
			
			switch (v.getId()) {
				case 1:
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);
        
        // Set listeners for all buttons
        for (int i = 0; i < buttons.length; i++) {
        	Button button = (Button)findViewById(buttons[i]);
        	button.setOnClickListener(buttonListener);
        }
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

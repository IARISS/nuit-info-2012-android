package fr.uha.ensisa.iariss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class TagSearchActivity extends Activity 
{
	private EditText editText;
	private Button button;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tag_search); 
		
		editText = (EditText) findViewById(R.id.edit);
		editText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
		editText.setLines(3);
		editText.setText("Tag");
		
		button = (Button) findViewById(R.id.set);
		editText.setText(R.string.button);
		button.setText("Envoyer !");
		
		button.setOnClickListener(new OnClickListener()
        {			
			public void onClick(View v) 
			{
				// Starting new intent
                Intent in = new Intent(getApplicationContext(), DataView.class);
                in.putExtra("tag", editText.getText().toString());
                startActivity(in);	
			}
        });

	}
	
	
}

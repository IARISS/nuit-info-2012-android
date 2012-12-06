package fr.uha.ensisa.iariss;

import org.json.JSONObject;

import fr.uha.ensisa.iariss.model.DataController;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	public static final int RESULT_Main = 1;
    private static String url = "http://api.androidhive.info/contacts/";

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); 
		setContentData();
	}

	public boolean onCreateOptionsMenu(Menu menu)
    {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	menu.getItem(0).getSubMenu().setHeaderIcon(R.drawable.ic_launcher);
    	return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch (item.getItemId()) 
    	{
    		case R.id.main:
    			Toast.makeText(MainActivity.this, "Accueil", Toast.LENGTH_SHORT).show();
    			Intent main_intent = new Intent(this,MainActivity.class);
    			startActivity(main_intent);
    			return true;
    		case R.id.option:
    			Toast.makeText(MainActivity.this, "Option", Toast.LENGTH_SHORT).show();
    			return true;
    		case R.id.dataview:
    			Toast.makeText(MainActivity.this, "Data View", Toast.LENGTH_SHORT).show();
    			Intent settings_intent = new Intent(this,DataView.class);
    			startActivity(settings_intent);
    			return true;
    		case R.id.quitter:
    			finish();
    			return true;
    	}
    	return false;
    }

	private void setContentData() 
	{
		//DataController dataController = new DataController();
		//JSONObject json = dataController.getJSONFromUrl(url);
		
		
	}
}

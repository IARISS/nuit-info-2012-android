package fr.uha.ensisa.iariss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.uha.ensisa.iariss.model.DataController;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	public static final int RESULT_Main = 1;
    private static String urlRandomTag = "http://10.57.110.8/api.php?action=random&value=8";
    private ArrayList<TextView> news = new ArrayList<TextView>();
    
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
    	menu.getItem(0).getSubMenu().setHeaderIcon(R.drawable.beret);
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
    		case R.id.tag_search:
    			Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
    			Intent search_intent = new Intent(this,TagSearchActivity.class);
    			startActivity(search_intent);
    			return true;
    		case R.id.quitter:
    			finish();
    			return true;
    	}
    	return false;
    }

	public void setContentData() 
	{
        news.add((TextView) findViewById(R.widget.news1));
        news.add((TextView) findViewById(R.widget.news2));
        news.add((TextView) findViewById(R.widget.news3));
        news.add((TextView) findViewById(R.widget.news4));
        news.add((TextView) findViewById(R.widget.news5));
        news.add((TextView) findViewById(R.widget.news6));
        news.add((TextView) findViewById(R.widget.news7));
        
		ArrayList<String> tagsList = getRandomTag();
		
		news.get(0).setText("Tag Aléatoire (Cliquer pour détails)");
		for(int i=1; i < news.size(); i++)
		{
			final TextView tmp = news.get(i);
			tmp.setText("Tag : " + tagsList.get(i));
			tmp.setOnClickListener(new OnClickListener()
	        {			
				public void onClick(View v) 
				{
					// Starting new intent
	                Intent in = new Intent(getApplicationContext(), DataView.class);
	                in.putExtra("tag", tmp.getText().toString());
	                startActivity(in);	
				}
	        });		
		}
		
		
	}
	
	public ArrayList<String> getRandomTag()
	{
		DataController jParser = new DataController();
		JSONObject json = jParser.getJSONFromUrl(urlRandomTag);
		
		JSONArray tags = null;
		ArrayList<String> tagsList = new ArrayList<String>();
		 try 
	        {
	            // Getting Array of Contacts
	            tags = json.getJSONArray("tag");
	 
	            // looping through All Contacts
	            for(int i = 0; i < tags.length(); i++)
	            {
	                JSONObject c = tags.getJSONObject(i);
	 
	                // Storing each json item in variable
	                String id = c.getString("id");
	                String name = c.getString("name");
	                String description = c.getString("tagType");
	                
	                tagsList.add(name);
	            }
	        } 
	        catch (JSONException e) 
	        {
	            e.printStackTrace();
	        }
		 
		 return tagsList;
	}
	
    public void onStop(Bundle savedInstanceState) 
    {
        finish();
        setContentData();
    }
}

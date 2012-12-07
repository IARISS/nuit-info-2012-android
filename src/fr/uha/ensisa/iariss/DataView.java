package fr.uha.ensisa.iariss;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import fr.uha.ensisa.iariss.model.DataController;

public class DataView extends ListActivity 
{
    // url to make request
    private static String url = "http://demo.iarissteam.me/api.php?action=search&value=";
    
    //Json Node Name
    private static final String TAG_CULTURE = "culture";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    //private static final String TAG_POSITION = "position";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_IMG = "img";
    //private static final String TAG_TAGS = "tags";
    
    // contacts JSONArray
    JSONArray culture = null;
 
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataview);
        setContentData();
    }
    
    public void setContentData()
    {
        // Hashmap for ListView
        ArrayList<HashMap<String, String>> contactList = new ArrayList<HashMap<String, String>>();
 
        // Creating JSON Parser instance
        DataController jParser = new DataController();
        
        Intent tag = getIntent();
        String tags = new String();
        try 
        {
			tags = URLEncoder.encode(tag.getStringExtra("tag"),"UTF-8");
			Log.i("tag",tags);
		} 
        catch (UnsupportedEncodingException e1) 
		{
			e1.printStackTrace();
		}
        // getting JSON string from URL
        JSONObject json = jParser.getJSONFromUrl(url+tags);
        
        if(!json.isNull(TAG_CULTURE))
        {
		    try 
		    {
		        // Getting Array of Contacts
		            culture = json.getJSONArray(TAG_CULTURE);
		 
		            // looping through All Contacts
		            for(int i = 0; i < culture.length(); i++)
		            {
		                JSONObject c = culture.getJSONObject(i);
		 
		                // Storing each json item in variable
		                String id = c.getString(TAG_ID);
		                String name = c.getString(TAG_NAME);
		                String description = c.getString(TAG_DESCRIPTION);
		                String img = c.getString(TAG_IMG);
		 
		                // creating new HashMap
		                HashMap<String, String> map = new HashMap<String, String>();
		 
		                // adding each child node to HashMap key => value
		                map.put(TAG_ID, id);
		                map.put(TAG_NAME, name);
		                map.put(TAG_DESCRIPTION, description);
		                map.put(TAG_IMG, img);
		 
		                // adding HashList to ArrayList
		            contactList.add(map);
		        }
		    } 
		    catch (JSONException e) 
		    {
		        e.printStackTrace();
		    }
	       
	 
	        /**
	         * Updating parsed JSON data into ListView
	         * */
	        if(!contactList.isEmpty())
	        {
	        ListAdapter adapter = new SimpleAdapter(this, contactList, R.layout.list_item,
	                new String[] { TAG_NAME, TAG_DESCRIPTION }, new int[] {
	                        R.id.name, R.id.description });
	        
	        setListAdapter(adapter);
	        	
	        // selecting single ListView item
	        ListView lv = getListView();
	 
	        // Launching new screen on Selecting Single ListItem
	        lv.setOnItemClickListener(new OnItemClickListener() 
	        {
	 
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
	            {
	                // getting values from selected ListItem
	                String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
	                String description = ((TextView) view.findViewById(R.id.description)).getText().toString();
	                
	                // Starting new intent
	                Intent in = new Intent(getApplicationContext(), SingleDataView.class);
	                in.putExtra(TAG_NAME, name);
	                in.putExtra(TAG_DESCRIPTION, description);
	                startActivity(in);
	            }
	        });
	        
	        TextView error = (TextView) findViewById(R.id.error);
	   	 	error.setText("");
	        }
	        else
	        {
	        	 TextView error = (TextView) findViewById(R.id.error);
	        	 error.setText("Pas de résultat pour ce tag");
	        }
        }
        else
        {
        	TextView error = (TextView) findViewById(R.id.error);
       	 	error.setText("Pas de résultat pour ce tag");
        }
    }
    
    public void onStop(Bundle savedInstanceState) 
    {
        finish();
    }
 
}

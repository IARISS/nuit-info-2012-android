package fr.uha.ensisa.iariss.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class DataController 
{
	static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
 
    public DataController() 
    {
    }
    
    public JSONObject getJSONFromUrl(String url)
    {
 
		 try
		 {
		    	InputStream is = new URL(url).openStream();
		        try 
		        {
		          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		          StringBuilder sb = new StringBuilder();
		          int cp;
		          while ((cp = rd.read()) != -1) {
		            sb.append((char) cp);
		          }
		         json = sb.toString();
		        } 
		        finally {
		          is.close();
		        }
		 }
		 catch (Exception e) 
		 {
			// TODO: handle exception
		}
		 
        // try parse the string to a JSON object
        try 
        {
            jObj = new JSONObject(json);
        } 
        catch (JSONException e) 
        {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
 
        // return JSON String
        return jObj;
 
    }
}

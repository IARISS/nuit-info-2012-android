package fr.uha.ensisa.iariss;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SingleDataView extends Activity 
{
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.simple_list_item);
 
        TextView txtName = (TextView) findViewById(R.id.name_label);
        TextView txtDescription = (TextView) findViewById(R.id.description_label);
 
        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String description = i.getStringExtra("description");

        txtName.setText(name);
        txtDescription.setText(description);

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
    			Toast.makeText(SingleDataView.this, "Accueil", Toast.LENGTH_SHORT).show();
    			Intent main_intent = new Intent(this,MainActivity.class);
    			startActivity(main_intent);
    			return true;
    		case R.id.option:
    			Toast.makeText(SingleDataView.this, "Option", Toast.LENGTH_SHORT).show();
    			return true;
    		case R.id.tag_search:
    			Toast.makeText(SingleDataView.this, "Search", Toast.LENGTH_SHORT).show();
    			Intent search_intent = new Intent(this,TagSearchActivity.class);
    			startActivity(search_intent);
    			return true;
    		case R.id.quitter:
    			finish();
    			return true;
    	}
    	return false;
    }
}

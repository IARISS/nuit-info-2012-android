package fr.uha.ensisa.iariss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleDataView extends Activity 
{
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.simple_list_item);
 
        TextView txtName = (TextView) findViewById(R.id.name_label);
        TextView txtEmail = (TextView) findViewById(R.id.email_label);
        TextView txtMobile = (TextView) findViewById(R.id.mobile_label);
 
        Intent i = getIntent();
        // getting attached intent data
        String name = i.getStringExtra("name");
        String email = i.getStringExtra("email");
        String mobile = i.getStringExtra("mobile");
        // displaying selected product name
        txtName.setText(name);
        txtEmail.setText(email);
        txtMobile.setText(mobile);
 
    }
}

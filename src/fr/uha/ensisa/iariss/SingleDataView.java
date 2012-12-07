package fr.uha.ensisa.iariss;

import java.net.URI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleDataView extends Activity 
{
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.simple_list_item);
 
        TextView txtName = (TextView) findViewById(R.id.name_label);
        TextView txtDescription = (TextView) findViewById(R.id.description_label);
        //ImageView txtImg = (ImageView) findViewById(R.id.img_label);
 
        Intent i = getIntent();
        // getting attached intent data
        String name = i.getStringExtra("name");
        String description = i.getStringExtra("description");
        //String img = i.getStringExtra("img");
        // displaying selected product name
        txtName.setText(name);
        txtDescription.setText(description);
        //txtImg.setIm
        
        /*Bitmap bimage=  getBitmapFromURL(bannerpath);
        image.setImageBitmap(bimage);

         public static Bitmap getBitmapFromURL(String src) {
                try {
                    Log.e("src",src);
                    URL url = new URL(src);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    Bitmap myBitmap = BitmapFactory.decodeStream(input);
                    Log.e("Bitmap","returned");
                    return myBitmap;
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("Exception",e.getMessage());
                    return null;
                }
            }*/
 
    }
}

package com.example.michaelvargas.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

private  static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView dogImage = (ImageView) findViewById(R.id.dog_image);
        dogImage.setImageDrawable(getResources().getDrawable(R.drawable.dog));
        Button btnCalculation = (Button) findViewById(R.id.bnt1);
        final TextView answer = ( TextView ) findViewById(R.id.txtResul);
        final EditText ageField = (EditText) findViewById(R.id.editText1);

      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "contact me: msvargas97@gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        btnCalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String age = ageField.getText().toString();
                    answer.setText(((String)getResources().getString(R.string.init1))+ (Integer.parseInt(age) * 6) + " " + getResources().getString( R.string.years));
                    Log.d(TAG, age);
                }catch (NumberFormatException nfe){
                    Log.v(TAG , nfe.toString());
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.stringDebug),Toast.LENGTH_SHORT).show();
                }
            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

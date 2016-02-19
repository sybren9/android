package com.example.sybren.eersteapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button buttonUsd;
    Button buttonEuro;
    EditText invoerVeld;
    TextView textLabel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonUsd = (Button) findViewById(R.id.buttonUsd);
        buttonEuro = (Button) findViewById(R.id.buttonEuro);

        invoerVeld = (EditText) findViewById(R.id.invoerVeld);
        textLabel = (TextView) findViewById(R.id.textLabel);

    }


   public void naarUSD(View v){

       Double invoer = Double.parseDouble(invoerVeld.getText().toString());
       Double resultaat = invoer * 1.13;
       String resultaatString = String.valueOf(String.format("%.2f", resultaat));
       textLabel.setText("$ " + resultaatString);

   }

    public void naarEURO(View v){

        Double invoer = Double.parseDouble(invoerVeld.getText().toString());
        Double resultaat = invoer * 0.8989;
        String resultaatString = String.valueOf(String.format("%.2f", resultaat));
        textLabel.setText("$ " + resultaatString);

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

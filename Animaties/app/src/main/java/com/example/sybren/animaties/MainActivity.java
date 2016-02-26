package com.example.sybren.animaties;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    ImageView maggieImg;
    ImageView krustyImg;
    long duurAnimatie;
    boolean isMaggie;
    SeekBar seekbar;
    RadioGroup radioGroup;
    RadioButton fadeButton;
    RadioButton translateButton;
    RadioButton rotateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        maggieImg = (ImageView) findViewById(R.id.maggieImg);
        krustyImg = (ImageView) findViewById(R.id.krustyImg);
        duurAnimatie = 2000l;

        seekbar = (SeekBar) findViewById(R.id.seekBar);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        fadeButton = (RadioButton) findViewById(R.id.fadeRadioButton);
        translateButton = (RadioButton) findViewById(R.id.translateRadioButton);
        rotateButton = (RadioButton) findViewById(R.id.rotateRadioButton);


        isMaggie = true;


        if(fadeButton.isChecked()){
            krustyImg.animate().alpha(0l).setDuration(0l);
        }
    }

    public void animate(View view) {
        radioGroup();

        duurAnimatie = seekbar.getProgress();

        if(fadeButton.isChecked()) {
           fade();
        }

        if(translateButton.isChecked()) {
            krustyImg.animate().alpha(1l).setDuration(0l);
            rotate();
        }

        if(rotateButton.isChecked()) {
            rotateAndScale();
        }

        isMaggie = !isMaggie;
    }

    public void radioGroup() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (isMaggie) {
                    if (fadeButton.isChecked()) {
                        krustyImg.animate().translationX(0f).setDuration(0l);
                        krustyImg.animate().scaleX(1f).scaleY(1f).setDuration(0l);
                        krustyImg.animate().alpha(0f).setDuration(0l);
                    } else if (translateButton.isChecked()) {
                        krustyImg.animate().alpha(1f).setDuration(0l);
                        krustyImg.animate().scaleX(1f).scaleY(1f).setDuration(0l);
                        krustyImg.animate().translationX(-1000l).setDuration(0l);
                    } else {
                        krustyImg.animate().alpha(1f).setDuration(0l);
                        krustyImg.animate().translationX(0f).setDuration(0l);
                        krustyImg.animate().scaleX(0f).scaleY(0f).setDuration(0l);
                    }
                }
                else{
                    if (fadeButton.isChecked()) {
                        maggieImg.animate().translationX(0f).setDuration(0l);
                        maggieImg.animate().scaleX(1f).scaleY(1f).setDuration(0l);
                        maggieImg.animate().alpha(0f).setDuration(0l);
                    } else if (translateButton.isChecked()) {
                        maggieImg.animate().alpha(1f).setDuration(0l);
                        maggieImg.animate().scaleX(1f).scaleY(1f).setDuration(0l);
                        maggieImg.animate().translationX(1000l).setDuration(0l);
                    } else {
                        maggieImg.animate().alpha(1f).setDuration(0l);
                        maggieImg.animate().translationX(0f).setDuration(0l);
                        maggieImg.animate().scaleX(0f).scaleY(0f).setDuration(0l);
                    }
                }
            }
        });
    }

    private void fade() {

        if (isMaggie) {
            maggieImg.animate().alpha(0f).setDuration(duurAnimatie);
            krustyImg.animate().alpha(1f).setDuration(duurAnimatie);

        } else {

            maggieImg.animate().alpha(1f).setDuration(duurAnimatie);
            krustyImg.animate().alpha(0f).setDuration(duurAnimatie);
        }
    }

    private void rotate() {
        if (isMaggie){
            maggieImg.animate().translationX(1000l).setDuration(duurAnimatie);
            krustyImg.animate().translationX(0f).setDuration(duurAnimatie);

        }
        else {

            maggieImg.animate().translationX(0f).setDuration(duurAnimatie);
            krustyImg.animate().translationX(-1000l).setDuration(duurAnimatie);
        }
    }

    private void rotateAndScale() {
        if (isMaggie) {
            maggieImg.animate()
                    .rotation(1080l)
                    .scaleX(0l)
                    .scaleY(0l)
                    .setDuration(duurAnimatie);

            krustyImg.animate()
                    .rotation(-1080l)
                    .scaleX(1l)
                    .scaleY(1l)
                    .setDuration(duurAnimatie);
        }
        else {
            maggieImg.animate()
                    .rotation(-1080l)
                    .scaleX(1l)
                    .scaleY(1l)
                    .setDuration(duurAnimatie);

            krustyImg.animate()
                    .rotation(1080l)
                    .scaleX(0l)
                    .scaleY(0l)
                    .setDuration(duurAnimatie);
        }
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

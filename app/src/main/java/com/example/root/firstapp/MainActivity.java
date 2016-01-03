package com.example.root.firstapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    private static final String DT = "MFALog";
    ImageView dimgview;
    Animation an;
 //   private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
                super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


               startActivity(new Intent(getApplicationContext(),SecondActivity.class));

               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
               //         .setAction("Action", null).show();
            }
        });

        dimgview=(ImageView)findViewById(R.id.imageView);
        an= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        dimgview.startAnimation(an);

        dimgview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                an= AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.fade_in);
                dimgview.startAnimation(an);
            }
        });

        Log.i(DT, "Info about Story");
        //playMusicFromWeb();
        getLocation();
    }

    public void getLocation()
    {
        try
        {
            LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Location recentLoc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Log.i(DT, "loc  " + recentLoc.toString());
        }
        catch (Exception e)
        {
            Log.e(DT, "Location Fetch Failed");
        }
    }

   /* public void playMusicFromWeb()
    {
        try
        {
            Uri file = Uri.parse("http://32.webmusic.pw/music/hindi/artist/m/mohammed_irfan/mohammed_irfan_single/Akela-Hu-Main_(webmusic.in).mp3");
            mp = MediaPlayer.create(this, file);
            mp.start();
        }
        catch (Exception e)
        {
            Log.e(DT, "Player Failed");
        }
    }   */

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

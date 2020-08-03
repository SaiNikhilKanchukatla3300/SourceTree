package com.example.sourcetree;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class OtherUsefulSites extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Intent i;
public void move_us(android.view.View v){
        switch(v.getId()){
            case R.id.gh_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com"));
                break;
            case R.id.so_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com"));

                break;
            case R.id.cs50_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cs50.harvard.edu/college/"));

                break;
            case R.id.w3_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.w3schools.com"));

                break;
            case R.id.mit_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ocw.mit.edu/index.htm"));
                break;
            case R.id.li_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com"));
                break;
            case R.id.jt_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com"));
                break;
            case R.id.sn_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://swayam.gov.in"));
                break;
            case R.id.sl_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sololearn.com"));
                break;
            case R.id.tp_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/index.htm"));
                break;
            case R.id.ph_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://programminghub.io"));
                break;
            case R.id.caa_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.codecademy.com"));
                break;
            case R.id.c4_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.c4learn.com"));
                break;
            case R.id.ud_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.udemy.com"));
                break;
            case R.id.uc_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.udacity.com"));
                break;
            case R.id.edx_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.edx.org"));
                break;
            case R.id.gfg_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org"));
                break;
            case R.id.tg_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.techgig.com"));
                break;
            case R.id.core_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coursera.org"));
                break;
            case R.id.ly_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.lynda.com"));
                break;
            case R.id.c9_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://channel9.msdn.com"));
                break;
            case R.id.mv_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.microsoft.com/en-us/learn/"));
                break;
            case R.id.ps_i:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pluralsight.com/partners/offer-ended"));
                break;

        }
        startActivity(i);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_useful_sites);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "App not placed in stores", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent j;
        if (id == R.id.nav_home) {
            j= new Intent(getApplicationContext(), MainActivity.class);
            startActivity(j);
        } else if (id == R.id.nav_share) { View v = null;
            Toast.makeText(getApplicationContext(),"App not placed in stores",Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_send) {
            String uriText =
                    "mailto:sainikhil.kanchukatla@gmail.com" +
                            "?subject=" + Uri.encode("some Suggestion") +
                            "&body=" + Uri.encode("From Sourcetree user,");

            Uri uri = Uri.parse(uriText);

            Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
            sendIntent.setData(uri);
            startActivity(Intent.createChooser(sendIntent, "Send email"));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

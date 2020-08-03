package com.example.sourcetree;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class StartCoding extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Intent i;
    public void move_code(android.view.View v){
            switch(v.getId()){
                case R.id.hc_i:
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hackerrank.com"));
                    break;
                case R.id.he_i:
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hackerearth.com"));
                    break;
                case R.id.cc_i:
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.codechef.com"));
                    break;
                case R.id.cf_i:
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://codeforces.com"));
                    break;
                case R.id.tc_i:
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.spoj.com"));
                    break;
                case R.id.ccal_i:
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.limitskyapps.CodingCalendar&hl=en_IN"));
                    break;
                case R.id.lc_i:
                    i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://leetcode.com"));
                    break;
            }
            startActivity(i);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_coding);
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

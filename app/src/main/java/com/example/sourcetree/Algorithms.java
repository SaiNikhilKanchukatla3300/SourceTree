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

public class Algorithms extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Intent i;
    public void movec(android.view.View v) {
        switch (v.getId()) {
            case R.id.h_c:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.geeksforgeeks.org/fundamentals-of-algorithms/"));
                break;
            case R.id.h1_c:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coursera.org/specializations/algorithms?="));
                break;
            case R.id.h2_c:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=HtSuA80QTyo&list=PLUl4u3cNGP61Oq3tWYp6V_F-5jb5L2iHb"));
                break;
            case R.id.h4_c:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=0IAPZzGSbME&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O"));
                break;
            case R.id.h5_c:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flipkart.com/introduction-algorithms-3rd/p/itmdwxyrafdburzg?gclid=Cj0KCQjw9fntBRCGARIsAGjFq5H64SYTKfkpsm7hox4esQ3FDZtEi3tVQb4xuf1hQ5lEZ-SkkdWZPfwaAh4NEALw_wcB&pid=9788120340077&lid=LSTBOK9788120340077DGGYTH&marketplace=FLIPKART&cmpid=content_book_8965229628_gmc_pla&tgi=sem,1,G,11214002,g,search,,291072750917,1o1,,,c,,,,,,,&ef_id=Cj0KCQjw9fntBRCGARIsAGjFq5H64SYTKfkpsm7hox4esQ3FDZtEi3tVQb4xuf1hQ5lEZ-SkkdWZPfwaAh4NEALw_wcB:G:s&s_kwcid=AL!739!3!291072750917!!!g!295092701166!"));
                break;

        }
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithms);
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

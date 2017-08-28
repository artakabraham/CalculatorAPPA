package com.alsari.calc.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        MainFragment mainFragment = new MainFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,mainFragment);
        fragmentTransaction.commit();

    } // onCreate


    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        String manualText = getText(R.string.manualText).toString();
        String manualTitle = getText(R.string.manual).toString();
        String linksTitle = getText(R.string.links).toString();
        String linksText = getText(R.string.linksText).toString();
        String aboutTitle = getText(R.string.about).toString();
        String aboutText = getText(R.string.aboutText).toString();

        int id = item.getItemId();

        if (id == R.id.nav_main) {

            MainFragment mainFragment = new MainFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.replace(R.id.fragment_container,mainFragment)
                    .addToBackStack(MainFragment.class.getName());
            fragmentTransaction.commit();

        } else

        if (id == R.id.nav_appa) {

                AppaNewFragment appaNewFragment = new AppaNewFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                fragmentTransaction.replace(R.id.fragment_container,appaNewFragment)
                        .addToBackStack(null);
                fragmentTransaction.commit();


        } else if (id == R.id.nav_property) {

            PropertyFragment propertyFragment = new PropertyFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.replace(R.id.fragment_container,propertyFragment)
                    .addToBackStack(null);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_tech) {

            TechFragment techFragment = new TechFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.replace(R.id.fragment_container,techFragment)
                    .addToBackStack(null);
            fragmentTransaction.commit();

        }  else if (id == R.id.nav_co) {

            CoFragment coFragment = new CoFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.replace(R.id.fragment_container,coFragment)
                    .addToBackStack(null);
            fragmentTransaction.commit();

        }
        else if (id == R.id.manual) {
            Intent testIntent = new Intent(MainActivity.this, Text.class);
            //testIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            testIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            testIntent.putExtra("manualKey", manualText);
            testIntent.putExtra("manualTitle", manualTitle);
            startActivity(testIntent);
            overridePendingTransition(0,0); //0 for no animation

        } else if (id == R.id.links) {
            Intent testIntent = new Intent(MainActivity.this, Text.class);
            //testIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            testIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            testIntent.putExtra("manualKey", linksText);
            testIntent.putExtra("manualTitle", linksTitle);
            startActivity(testIntent);
            overridePendingTransition(0,0); //0 for no animation

        } else if (id == R.id.about) {
            Intent testIntent = new Intent(MainActivity.this, Text.class);
            //testIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            testIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            testIntent.putExtra("manualKey", aboutText);
            testIntent.putExtra("manualTitle", aboutTitle);
            startActivity(testIntent);
            overridePendingTransition(0,0); //0 for no animation
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
        if(getFragmentManager().getBackStackEntryCount() > 0){
            //getFragmentManager().popBackStack();
            getFragmentManager().popBackStack(
                    MainFragment.class.getName(),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        else {
            super.onBackPressed();
        }
    }
}

package com.example.nikhilbansal.jct;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nikhilbansal.jct.loginRegistration.LoginRegistrationFragment;
import com.example.nikhilbansal.jct.utils.SharePreferenceData;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private DrawerLayout drawer;
    private static NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setProperties();

        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.guest_user_navigation_menu);

//        //load navigation menu according to guest or logged in user
//        if(isUserLoggedIn()){
//            loadNavigationMenu(R.menu.logged_in_user_navigation_menu);
//        }else {
//            loadNavigationMenu(R.menu.guest_user_navigation_menu);
//        }

        //load home fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        LoginRegistrationFragment fragment = LoginRegistrationFragment.newInstance();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }

    public static  void loadNavigationMenu(int menu) {
        navigationView.getMenu().clear();
        navigationView.inflateMenu(menu);


    }

    public boolean isUserLoggedIn(){
        boolean loggedIn = false;
        String userId = SharePreferenceData.getInstance().getString(SharePreferenceData.KEY_USER_ID);
        boolean userLoggedIn = SharePreferenceData.getInstance().getBooleanValue(SharePreferenceData.KEY_USER_LOGGED_IN);
        if(!TextUtils.isEmpty(userId) && userLoggedIn != false){
            loggedIn = true;
        }else {
            loggedIn = false;
        }

        return loggedIn;
    }

    private void initializeViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
    }


    /**
     * Capable of setting properties to the all the views inflated.
     */
    private void setProperties() {
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //check if user logged in
        //if user already logged in show MY ACCOUNT in drawer
        //else show log in in drawer
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



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

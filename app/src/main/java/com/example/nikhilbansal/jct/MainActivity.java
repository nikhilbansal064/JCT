package com.example.nikhilbansal.jct;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.nikhilbansal.jct.loginRegistration.LoginRegistrationFragment;
import com.example.nikhilbansal.jct.utils.FragmentUtils;
import com.example.nikhilbansal.jct.utils.SharePreferenceData;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar mToolbar;
    private DrawerLayout drawer;
    private static NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setProperties();

        //load home fragment
        HomeFragment homeFragment = HomeFragment.newInstance();
        FragmentUtils.addFragment(this, homeFragment, HomeFragment.class.getName(), true);

        //load navigation menu according to guest or logged in user
        if(isUserLoggedIn()){
            loadNavigationMenu(R.menu.logged_in_user_navigation_menu);
        }else {
            loadNavigationMenu(R.menu.guest_user_navigation_menu);
        }
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
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(true);

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
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, as long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void setNavigationIcon(int navigationIcon, final String navigation) {
        if(mToolbar != null){
            mToolbar.setNavigationIcon(navigationIcon);

            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (navigation){
                        case "BACK":
                            onBackPressed();
                            break;
                    }
                }
            });
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_my_account:
                //go to user account
                break;

            case R.id.nav_log_in_or_register:
                //load loginRegistration fragment
                FragmentUtils.addFragment(this, LoginRegistrationFragment.newInstance(), LoginRegistrationFragment.class.getSimpleName(), true);
                break;
        }
        drawer.closeDrawers();
        return true;
    }
}

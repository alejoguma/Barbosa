package com.example.alejandroguma.barbosa;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;



public class drawertabActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
        private String title;


    private String nameTab1;
    private String nameTab2;
    private String nameTab3;


    private String sel;
    private Fragment tab1Fragment;
    private Fragment tab2Fragment;
    private Fragment tab3Fragment;

    Intent intent;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    Bundle extras;
    SharedPreferences prefs;//creopreferenciascompartidas
    SharedPreferences.Editor editor;//el editor para lo anterior
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawertab);
        prefs =getSharedPreferences("MisPreferencias",MODE_PRIVATE);//traigolas preferencias
        editor = prefs.edit();//cargo el editor

        extras = getIntent().getExtras();

        sel= extras.getString("sel");

        if (sel.equals("Hotel")){

            setStringNames(getString(R.string.hotel_title), getString(R.string.hotel1),
                    getString(R.string.hotel2), getString(R.string.hotel3));
            setFragments(1);
        }else if (sel.equals("Rest")){

            setStringNames(getString(R.string.restaurant_title), getString(R.string.restaurant1),
                    getString(R.string.restaurant2), getString(R.string.restaurant3));
            setFragments(2);
        }else if (sel.equals("Bar")){

            setStringNames(getString(R.string.tour_title), getString(R.string.bar1),
                    getString(R.string.bar2), getString(R.string.bar3));
            setFragments(3);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container1);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent;
            super.onBackPressed();
            intent=new Intent(drawertabActivity.this,drawerMainActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.nav_miperfil) {
            intent=new Intent(drawertabActivity.this,drawerPerfilActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_inicio) {
            intent=new Intent(drawertabActivity.this,drawerMainActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_hotel) {
            intent=new Intent(drawertabActivity.this,drawertabActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Hotel");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_bar) {
            intent=new Intent(drawertabActivity.this,drawertabActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Bar");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_rest) {
            intent=new Intent(drawertabActivity.this,drawertabActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Rest");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_ubi) {
            intent=new Intent(drawertabActivity.this,MapsActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_logout) {
            editor.putInt("login",-1);
            editor.commit();
            intent=new Intent(drawertabActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    return tab1Fragment;
                case 1:
                    return tab2Fragment;
                case 2:
                    return tab3Fragment;

                default: return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return nameTab1;
                case 1:
                    return nameTab2;
                case 2:
                    return nameTab3;

            }
            return null;
        }
    }

    private void setStringNames(String _title, String _nameTab1, String _nameTab2, String _nameTab3){
        title = _title;
        nameTab1 = _nameTab1;
        nameTab2 = _nameTab2;
        nameTab3 = _nameTab3;

    }

    /** Method to set fragments to every tab **/
    private void setFragments(int option){
        switch (option){
            case 1:
                tab1Fragment = new HotelFragment();
                tab2Fragment = new hotel2Fragment();
                tab3Fragment = new hotel3Fragment();

                break;
            case 2:
                tab1Fragment = new restaurante1Fragment();
                tab2Fragment = new restaurante2Fragment();
                tab3Fragment = new restaurante3Fragment();

                break;
            case 3:
                tab1Fragment = new barFragment();
                tab2Fragment = new bar2Fragment();
                tab3Fragment = new bar3Fragment();

                break;
        }
    }


}

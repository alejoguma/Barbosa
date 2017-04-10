package com.example.alejandroguma.barbosa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class drawerPerfilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tUsername,tCorreo;
    Intent intent;
    Bundle extras;
    SharedPreferences prefs;//creopreferenciascompartidas
    SharedPreferences.Editor editor;//el editor para lo anterior
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_perfil);
        prefs =getSharedPreferences("MisPreferencias",MODE_PRIVATE);//traigolas preferencias
        editor = prefs.edit();//cargo el editor
        tUsername=(TextView)findViewById(R.id.tUsuarioperfil);
        tCorreo=(TextView)findViewById(R.id.tCorreoperfil);
        extras = getIntent().getExtras();
        tUsername.setText(extras.getString("username"));
        tCorreo.setText(extras.getString("email"));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            intent=new Intent(drawerPerfilActivity.this,drawerMainActivity.class);
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

        if (id == R.id.nav_miperfil2) {
            intent=new Intent(drawerPerfilActivity.this,drawerPerfilActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_inicio2) {
            intent=new Intent(drawerPerfilActivity.this,drawerMainActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_hotel2) {
            intent=new Intent(drawerPerfilActivity.this,drawertabActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Hotel");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_bar2) {
            intent=new Intent(drawerPerfilActivity.this,drawertabActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Bar");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_rest2) {
            intent=new Intent(drawerPerfilActivity.this,drawertabActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Rest");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_ubi2) {
            intent=new Intent(drawerPerfilActivity.this,MapsActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_logout2) {
            editor.putInt("login",-1);
            editor.commit();
            intent=new Intent(drawerPerfilActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

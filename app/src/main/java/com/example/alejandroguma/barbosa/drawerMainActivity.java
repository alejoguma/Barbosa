package com.example.alejandroguma.barbosa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class drawerMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Intent intent;
    Bundle extras;
    ListView lista;
    SharedPreferences prefs;//creopreferenciascompartidas
    SharedPreferences.Editor editor;//el editor para lo anterior
    Lista_Entrada[] datos =new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.iglesia,"Iglesia San Antonio de Padua","Lugar Turistico"),
            new Lista_Entrada(R.drawable.pinas,"Fiestas  de la Piña","Festival"),
            new Lista_Entrada(R.drawable.parquesb,"Parque Simon Bolivar","Lugar Turistico")
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);

        prefs =getSharedPreferences("MisPreferencias",MODE_PRIVATE);//traigolas preferencias
        editor = prefs.edit();//cargo el editor

        extras = getIntent().getExtras();
        Adapter adapter = new Adapter(this,datos);

        lista=(ListView) findViewById(R.id.lista);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //
                if(((Lista_Entrada)parent.getItemAtPosition(position)).getIdImagen()==R.drawable.pinas){
                    intent=new Intent(drawerMainActivity.this,fiestaspActivity.class);
                    intent.putExtra("username",extras.getString("username"));
                    intent.putExtra("email",extras.getString("email"));
                    startActivity(intent);
                    finish();
                }else if(((Lista_Entrada)parent.getItemAtPosition(position)).getIdImagen()==R.drawable.iglesia){
                    intent=new Intent(drawerMainActivity.this,iglesiactivity.class);
                    intent.putExtra("username",extras.getString("username"));
                    intent.putExtra("email",extras.getString("email"));
                    startActivity(intent);
                    finish();
                }else if(((Lista_Entrada)parent.getItemAtPosition(position)).getIdImagen()==R.drawable.parquesb){
                    intent=new Intent(drawerMainActivity.this,parqueActivity.class);
                    intent.putExtra("username",extras.getString("username"));
                    intent.putExtra("email",extras.getString("email"));
                    startActivity(intent);
                    finish();
                }
               // String opcion=((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                //Toast.makeText(getApplicationContext(), opcion, Toast.LENGTH_SHORT).show();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout1);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);
    }
    class Adapter extends ArrayAdapter<Lista_Entrada> {
        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.listwiew1,datos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=LayoutInflater.from(getContext());
            View item=inflater.inflate(R.layout.listwiew1,null);

            TextView nombre=(TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip=(TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescripcion());

            ImageView imagen=(ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;

        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout1);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent;
            super.onBackPressed();
            intent=new Intent(drawerMainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings1) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();// Handle navigation view item clicks here.



        if (id == R.id.nav_miperfil1) {
            intent=new Intent(drawerMainActivity.this,drawerPerfilActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_inicio1) {
            intent=new Intent(drawerMainActivity.this,drawerMainActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_hotel1) {
            intent=new Intent(drawerMainActivity.this,drawertabActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Hotel");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_bar1) {
            intent=new Intent(drawerMainActivity.this,drawertabActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Bar");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_rest1) {
            intent=new Intent(drawerMainActivity.this,drawertabActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            intent.putExtra("sel", "Rest");
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_ubi1) {
            intent=new Intent(drawerMainActivity.this,MapsActivity.class);
            intent.putExtra("username",extras.getString("username"));
            intent.putExtra("email",extras.getString("email"));
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_logout1) {
            editor.putInt("login",-1);
            editor.commit();
            intent=new Intent(drawerMainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout1);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

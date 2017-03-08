package com.example.alejandroguma.barbosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {
    TextView tUsername,tCorreo;
    String username="",email="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername=(TextView)findViewById(R.id.tUsuarioperfil);
        tCorreo=(TextView)findViewById(R.id.tCorreoperfil);

        Bundle extras=getIntent().getExtras();
        username=extras.getString("username");
        email=extras.getString("email");
        tUsername.setText(username);
        tCorreo.setText(email);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id) {
            case R.id.mLogOut:
                Intent intent=new Intent(PerfilActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }

}
